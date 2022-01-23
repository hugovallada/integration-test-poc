package com.github.hugovallada.adapter.pokemon.dtos

import java.time.OffsetDateTime

data class ResponsePokemon(
    val name: String,
    val status: String,
    val createDate: OffsetDateTime,
    val updateDate: OffsetDateTime,
    val height: Int
)