package core

import kotlinx.serialization.Serializable

@Serializable
data class PokemonRequest(
    val name: String,
    val status: String,
    val height: Int
)