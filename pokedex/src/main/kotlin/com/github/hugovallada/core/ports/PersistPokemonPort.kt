package com.github.hugovallada.core.ports

import com.github.hugovallada.core.domain.PokemonDomain

interface PersistPokemonPort {

    fun execute(pokemonDomain: PokemonDomain)

}