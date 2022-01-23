import adapters.config.KtorConfig
import adapters.gateway.CreatePokemonGateway
import adapters.gateway.GetPokemonGateway
import core.Pokemon
import core.PokemonRequest
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*

suspend fun main(args: Array<String>) {
    val ktorClient = KtorConfig.ktorImpl()

    when (args[0]) {
        "all" -> {
            val response: HttpResponse = ktorClient.request("http://localhost:8080/pokemons") {
                method = HttpMethod.Get
            }

            println(response.status)
            val bodyResponse = response.receive<List<Pokemon>>()

            bodyResponse.forEach {
                println(it)
            }

            ktorClient.request("http://localhost:8080/pokemons") {
                method = HttpMethod.Post
                contentType(ContentType.Application.Json)
                body = PokemonRequest("Hugo", "ACTIVE", 200)
            }

        }
        "post" -> CreatePokemonGateway.createPokemon(ktorClient)
        "get" -> GetPokemonGateway.getAllPokemons(ktorClient)
        else -> println("Opção não encontrada")
    }

}