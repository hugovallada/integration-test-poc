package adapters.gateway

import adapters.utils.Colors
import adapters.config.Environment
import core.models.PokemonRequest
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.http.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle

class CreatePokemonGateway {

    companion object {
        suspend fun createPokemon(ktorClient: HttpClient) {
            println("${Colors.ANSI_RED.ansiValue}${LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT))} - ${this::class.java.declaringClass.simpleName} INFO: User: ${Environment.name} - Password: ${Environment.password}")

            ktorClient.request<Any>("http://localhost:8080/pokemons") {
                method = HttpMethod.Post
                contentType(ContentType.Application.Json)
                body = PokemonRequest("Umbreon", "ACTIVE", 200)
            }

        }
    }

}