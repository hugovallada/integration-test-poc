package com.github.hugovallada.adapter.pokemon.inbound.db

import com.github.hugovallada.adapter.pokemon.converter.PokemonConverter
import com.github.hugovallada.adapter.pokemon.repository.PokemonRepository
import com.github.hugovallada.core.domain.PokemonDomain
import com.github.hugovallada.core.ports.PersistPokemonPort
import org.jboss.logging.Logger
import org.mapstruct.factory.Mappers
import javax.enterprise.context.ApplicationScoped
import javax.inject.Inject
import javax.transaction.Transactional

/**
 * @Inject não é necessário no construtor
 * o Logger do JBOSS é automaticamente injetado pelo quarkus, sem necessidade de criar um bean para isso
 */
@ApplicationScoped
class PersistPokemonPortImpl(
    @Inject private val log: Logger,
    @Inject private val repository: PokemonRepository,
    @Inject private val converter: PokemonConverter
) : PersistPokemonPort {


    @Transactional
    override fun execute(pokemonDomain: PokemonDomain) {
        log.info("Pokemon ${pokemonDomain.name} is going to be persisted")

        converter.toModel(pokemonDomain).run {
            log.info(this)
            repository.persist(this).also { log.info("Pokemon persisted!") }.also { log.info("${this.id} - ${this.createDate}- ${this.name}") }
        }
    }
}