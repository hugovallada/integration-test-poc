package adapters.gateway

import core.models.Pokemon
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*

class GetPokemonGateway {

    companion object {

        suspend fun getAllPokemons(ktorClient: HttpClient) {
            val response: HttpResponse = ktorClient.request("http://localhost:8080/pokemons") {
                method = HttpMethod.Get
            }

            if (response.status.value == 200) {
                println("Status OK")
            }

            response.receive<List<Pokemon>>().run {
                forEach { println(it) }
            }
        }
    }
}