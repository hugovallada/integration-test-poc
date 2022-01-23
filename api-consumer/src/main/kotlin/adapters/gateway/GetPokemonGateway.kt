package adapters.gateway

import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*

class GetPokemonGateway {

    companion object {

        suspend fun getAllPokemons(ktorClient: HttpClient): HttpResponse {
            val response: HttpResponse = ktorClient.request("http://localhost:8080/pokemons") {
                method = HttpMethod.Get
            }

            return response
        }
    }
}