package core.models

import kotlinx.serialization.Serializable

@Serializable
data class Pokemon(
    val name: String,
    val status: String,
    val createDate: String,
    val updateDate: String,
    val height: Int
)
