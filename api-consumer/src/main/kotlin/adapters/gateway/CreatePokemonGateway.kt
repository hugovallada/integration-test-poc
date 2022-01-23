package adapters.gateway

import adapters.config.Environment
import core.models.PokemonRequest
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.http.*
import java.time.LocalDateTime

class CreatePokemonGateway {

    companion object {
        suspend fun createPokemon(ktorClient: HttpClient) {

            println("${LocalDateTime.now()} - INFO - User: ${Environment.name} - Password: ${Environment.password}")

            ktorClient.request<Any>("http://localhost:8080/pokemons") {
                method = HttpMethod.Post
                contentType(ContentType.Application.Json)
                body = PokemonRequest("Umbreon", "ACTIVE", 200)
            }

        }
    }

}