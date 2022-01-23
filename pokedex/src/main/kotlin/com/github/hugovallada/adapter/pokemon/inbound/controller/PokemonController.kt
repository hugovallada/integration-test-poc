package com.github.hugovallada.adapter.pokemon.inbound.controller

import com.github.hugovallada.adapter.pokemon.converter.PokemonConverter
import com.github.hugovallada.adapter.pokemon.dtos.RequestPokemon
import com.github.hugovallada.adapter.pokemon.dtos.ResponsePokemon
import com.github.hugovallada.core.service.CreatePokemonService
import com.github.hugovallada.core.service.GetAllPokemonsService
import org.jboss.resteasy.reactive.RestResponse
import javax.ws.rs.GET
import javax.ws.rs.POST
import javax.ws.rs.Path

@Path("/pokemons")
class PokemonController(
    private val createPokemonService: CreatePokemonService,
    private val getPokemonService: GetAllPokemonsService,
    private val converter: PokemonConverter
) {


    @POST
    fun createPokemon(requestPokemon: RequestPokemon): RestResponse<Any> {
        converter.requestToDomain(requestPokemon).run {
            createPokemonService.execute(this)
            return RestResponse.status(201, "Created")
        }


    }

    @GET
    fun getAll(): RestResponse<Set<ResponsePokemon>> {
        getPokemonService.execute().run {
            return RestResponse.ok(converter.setOfDomainTosetOfResponse(this))
        }
    }


}