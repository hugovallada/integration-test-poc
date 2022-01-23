package com.github.hugovallada.core.ports

import com.github.hugovallada.core.domain.PokemonDomain

interface GetAllPokemonPort {

    fun execute() : Set<PokemonDomain>

}