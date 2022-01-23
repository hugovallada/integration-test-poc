package com.github.hugovallada.core.domain

import java.time.OffsetDateTime

data class PokemonDomain(
    val id: Long? = null,
    val name: String,
    val status: String,
    val createDate: OffsetDateTime? = null,
    val updateDate: OffsetDateTime? = null,
    val height: Int
)
