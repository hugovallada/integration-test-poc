import adapters.config.KtorConfig
import adapters.gateway.CreatePokemonGateway
import adapters.gateway.GetPokemonGateway
import core.usecase.CreatePokemonUseCase
import core.usecase.ExecuteAllUseCase
import core.usecase.ExistsPokemonUseCase
import core.usecase.GetPokemonUseCase

suspend fun main(args: Array<String>) {
    val ktorClient = KtorConfig.ktorImpl()

    when (args[0]) {
        "all" -> ExecuteAllUseCase.executeAll(ktorClient)
        "post" -> CreatePokemonUseCase.execute(ktorClient)
        "get" -> GetPokemonUseCase.execute(ktorClient)
        "exists" -> ExistsPokemonUseCase.execute(ktorClient)
        else -> println("Opção não encontrada")
    }

    ktorClient.close()
}