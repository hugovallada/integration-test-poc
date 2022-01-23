package com.github.hugovallada.adapter.pokemon.outbound.db

import com.github.hugovallada.adapter.pokemon.converter.PokemonConverter
import com.github.hugovallada.adapter.pokemon.repository.PokemonRepository
import com.github.hugovallada.core.domain.PokemonDomain
import com.github.hugovallada.core.ports.GetAllPokemonPort
import org.jboss.logging.Logger
import org.mapstruct.factory.Mappers
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class GetAllPokemonPortImpl(
    private val log: Logger,
    private val repository: PokemonRepository,
) : GetAllPokemonPort {

    val converter = Mappers.getMapper(PokemonConverter::class.java)

    override fun execute(): Set<PokemonDomain> {
        log.info("Searching for every single pokemon")

        val x = repository.listAll()

        x.forEach {
            println(it.id)
            println(it.name)
            println(it.status)
            println(it.createDate)
            println(it.height)
        }

        return x.map {
            println(it)
            converter.toDomain(it)
        }.toSet()
    }
}