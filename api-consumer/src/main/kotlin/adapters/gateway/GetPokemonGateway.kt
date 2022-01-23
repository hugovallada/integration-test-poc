package adapters.gateway

import adapters.config.KtorConfig
import core.Pokemon
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*

class GetPokemonGateway {

    companion object {

        suspend fun getAllPokemons() {
            val ktorClient = KtorConfig.ktorImpl()

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