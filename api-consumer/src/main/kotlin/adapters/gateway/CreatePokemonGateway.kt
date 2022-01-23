package adapters.gateway

import core.PokemonRequest
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.http.*

class CreatePokemonGateway {

    companion object {
        suspend fun createPokemon(ktorClient: HttpClient) {

            ktorClient.request<Any>("http://localhost:8080/pokemons") {
                method = HttpMethod.Post
                contentType(ContentType.Application.Json)
                body = PokemonRequest("Hugo", "ACTIVE", 200)
            }

        }
    }

}