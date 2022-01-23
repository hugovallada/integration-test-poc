package core.usecase

import adapters.gateway.CreatePokemonGateway
import adapters.gateway.GetPokemonGateway
import io.ktor.client.*

class ExecuteAllUseCase {

    companion object {
        suspend fun executeAll(ktorClient: HttpClient) {
            GetPokemonGateway.getAllPokemons(ktorClient)
            CreatePokemonGateway.createPokemon(ktorClient)
        }
    }

}