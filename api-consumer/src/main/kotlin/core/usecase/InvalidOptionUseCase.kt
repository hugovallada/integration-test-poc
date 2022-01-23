package core.usecase

import java.io.File

class InvalidOptionUseCase {

    companion object {
        fun execute() {
            println("Você escolheu uma opção errada e o programa acabou se enforcando... Escolha uma opção valida na próxima!!!")
            try {
                File("./src/main/kotlin/adapters/utils/file/invalid").forEachLine { println(it) }
            }catch (ex: Exception) {
                println("Teste de fluxo finalizado inesperadamente.")
            }
        }
    }

}