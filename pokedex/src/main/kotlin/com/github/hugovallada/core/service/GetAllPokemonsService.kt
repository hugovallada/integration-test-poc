package com.github.hugovallada.core.service

import com.github.hugovallada.core.ports.GetAllPokemonPort
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class GetAllPokemonsService (private val getAllPokemonPort: GetAllPokemonPort){

    fun execute() = getAllPokemonPort.execute()

}