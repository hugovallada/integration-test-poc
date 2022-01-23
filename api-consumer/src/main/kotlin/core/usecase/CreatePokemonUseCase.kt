package core.usecase

import adapters.gateway.CreatePokemonGateway
import adapters.utils.Colors
import io.ktor.client.*

class CreatePokemonUseCase {

    companion object{
        suspend fun execute(ktorClient: HttpClient) {
            val response = CreatePokemonGateway.createPokemon(ktorClient)

            if (response.status.value != 201) {
                println("${Colors.ANSI_RED.ansiValue}Unexpected Code. Recived ${response.status.value}, but expected 201}")
                throw IllegalStateException("Wrong status")
            }

            println("Successfully validated the creation flux!!")
        }
    }

}