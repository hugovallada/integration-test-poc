package adapters.config

object Environment {

    val name: String
    val password: String

    init {
        try {
            name = System.getenv("INTEGRATION_TEST_USER")
            password = System.getenv("INTEGRATION_TEST_PASSWORD")


            if(name.isBlank() || password.isBlank()) {
                throw IllegalStateException("No env found")
            }

        } catch (ex: NullPointerException) {
            throw IllegalStateException("No env found")
        }
    }

}