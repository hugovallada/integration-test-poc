package core.models

import kotlinx.serialization.Serializable

@Serializable
data class PokemonDomain(
    val name: String,
    val status: String,
    val createDate: String,
    val updateDate: String,
    val height: Int
)
