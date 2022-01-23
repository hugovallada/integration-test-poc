package core.usecase

import adapters.gateway.GetPokemonGateway
import core.models.PokemonDomain
import io.ktor.client.*
import io.ktor.client.call.*

class GetPokemonUseCase {

    companion object {
        suspend fun execute(ktorClient: HttpClient) {
            val response = GetPokemonGateway.getAllPokemons(ktorClient)

            if (response.status.value == 200) {
                val listOfPokemons = response.receive<List<PokemonDomain>>()
                listOfPokemons.forEach { println(it) }
                println("Successfully validated the get flux!!")
            } else {
                throw IllegalStateException("Invalid status")
            }
        }
    }

}