package core.usecase

import adapters.gateway.GetPokemonGateway
import core.models.PokemonDomain
import io.ktor.client.*
import io.ktor.client.call.*

class ExistsPokemonUseCase {

    companion object {
        suspend fun execute(ktorClient: HttpClient) {
            val response = GetPokemonGateway.getAllPokemons(ktorClient)

            if (response.status.value == 200) {
                val listOfPokemons = response.receive<List<PokemonDomain>>()

                val expectedPokemon =
                    PokemonDomain(name = "Umbreon", status = "ACTIVE", createDate = "", updateDate = "", height = 200)

                val exists = listOfPokemons.any {
                    it.name == expectedPokemon.name && it.status == expectedPokemon.status && it.height == expectedPokemon.height
                }

                if (exists) {
                    println("Successfully executed the exists flow!!")
                } else {
                    throw IllegalStateException("Does not exists.")
                }

            } else {
                throw IllegalStateException("Invalid Status.")
            }
        }
    }

}