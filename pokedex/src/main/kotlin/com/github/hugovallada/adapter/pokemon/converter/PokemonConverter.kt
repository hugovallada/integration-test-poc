package com.github.hugovallada.adapter.pokemon.converter

import com.github.hugovallada.adapter.pokemon.dtos.RequestPokemon
import com.github.hugovallada.adapter.pokemon.dtos.ResponsePokemon
import com.github.hugovallada.adapter.pokemon.model.Pokemon
import com.github.hugovallada.adapter.pokemon.model.enum.Status
import com.github.hugovallada.core.domain.PokemonDomain
import org.mapstruct.Mapper

/**
 * componentModel permite ao framework controlar a injeção de dependência
 * cdi server para os principais frameworks (spring, micronaut, quarkus)
 * spring também pode ser usado, mas sendo específico do spring
 */
@Mapper(componentModel = "cdi")
abstract class PokemonConverter {


    /**
     * o map struct consegue converter de string para enum e vice versa
     * se fosse preciso um valor default para nulo, poderia adicionar a propriedade defaultValue
     */
    fun toModel(pokemonDomain: PokemonDomain): Pokemon {
        return Pokemon(
            pokemonDomain.id,
            pokemonDomain.name,
            Status.valueOf(pokemonDomain.status),
            pokemonDomain.createDate,
            pokemonDomain.updateDate,
            pokemonDomain.height
        )
    }

    abstract fun requestToDomain(requestPokemon: RequestPokemon): PokemonDomain

    /**
     * O Inherit conf pega as configurações onde inverte o tipo de entrada e saida e faz o mapa automaticamente
     * Em caso de valor default, é necessáio definirem ambos
     */
    fun toDomain(pokemon: Pokemon): PokemonDomain {
        return PokemonDomain(
            pokemon.id, pokemon.name, pokemon.status.name,
            pokemon.createDate, pokemon.updateDate, pokemon.height
        )
    }

    abstract fun listModelToListDomain(listOfPokemons: List<Pokemon>): List<PokemonDomain>


    abstract fun domainToResponse(pokemonDomain: PokemonDomain): ResponsePokemon

    //
//    @Mapping(source = "status", target = "status")
//
    abstract fun setOfDomainTosetOfResponse(listOfPokemons: Set<PokemonDomain>): Set<ResponsePokemon>

}