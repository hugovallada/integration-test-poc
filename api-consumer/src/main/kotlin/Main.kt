import adapters.config.KtorConfig
import adapters.gateway.CreatePokemonGateway
import adapters.gateway.GetPokemonGateway
import core.usecase.ExecuteAllUseCase

suspend fun main(args: Array<String>) {
    val ktorClient = KtorConfig.ktorImpl()

    when (args[0]) {
        "all" -> ExecuteAllUseCase.executeAll(ktorClient)
        "post" -> CreatePokemonGateway.createPokemon(ktorClient)
        "get" -> GetPokemonGateway.getAllPokemons(ktorClient)
        else -> println("Opção não encontrada")
    }

    ktorClient.close()
}