package com.github.hugovallada.core.service

import com.github.hugovallada.core.domain.PokemonDomain
import com.github.hugovallada.core.ports.PersistPokemonPort
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class CreatePokemonService(private val persistPokemonPort: PersistPokemonPort) {

    fun execute(pokemonDomain: PokemonDomain) {
        print(pokemonDomain)
        persistPokemonPort.execute(pokemonDomain)
    }

}