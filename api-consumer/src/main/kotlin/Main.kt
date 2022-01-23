import adapters.config.KtorConfig
import core.usecase.*

suspend fun main(args: Array<String>) {
    val ktorClient = KtorConfig.ktorImpl()

    when (args[0]) {
        "all" -> ExecuteAllUseCase.executeAll(ktorClient)
        "post" -> CreatePokemonUseCase.execute(ktorClient)
        "get" -> GetPokemonUseCase.execute(ktorClient)
        "exists" -> ExistsPokemonUseCase.execute(ktorClient)
        else -> InvalidOptionUseCase.execute()
    }

    ktorClient.close()
}