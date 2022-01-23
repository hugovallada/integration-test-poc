package adapters.config

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.features.json.*

object KtorConfig {

    fun ktorImpl(): HttpClient {

        val ktor = HttpClient(CIO) {
            install(JsonFeature) {
                serializer = JacksonSerializer()
            }
            expectSuccess = false
            engine {
                endpoint {
                    connectTimeout = 5000
                    connectAttempts = 5
                }

            }
        }


        return ktor
    }

}