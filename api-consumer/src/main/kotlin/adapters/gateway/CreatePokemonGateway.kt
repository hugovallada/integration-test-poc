package adapters.gateway

import adapters.config.KtorConfig
import core.PokemonRequest
import io.ktor.client.request.*
import io.ktor.http.*

class CreatePokemonGateway {

    companion object {
        suspend fun createPokemon() {
            val ktorClient = KtorConfig.ktorImpl()

            ktorClient.request<Any>("http://localhost:8080/pokemons") {
                method = HttpMethod.Post
                contentType(ContentType.Application.Json)
                body = PokemonRequest("Hugo", "ACTIVE", 200)
            }

        }
    }

}