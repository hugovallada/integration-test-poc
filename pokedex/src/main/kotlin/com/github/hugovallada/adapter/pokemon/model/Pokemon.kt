package com.github.hugovallada.adapter.pokemon.model

import com.github.hugovallada.adapter.pokemon.model.enum.Status
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.OffsetDateTime
import javax.persistence.*

@Entity
@Table(name = "tb_pokemon")
class Pokemon(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    val name: String,

    @Enumerated(EnumType.STRING)
    val status: Status,

    @CreationTimestamp
    val createDate: OffsetDateTime? = null,

    @UpdateTimestamp
    val updateDate: OffsetDateTime? = null,

    val height: Int
) {
    override fun toString(): String {
        return "Pokemon(id=$id, name='$name', status=$status, createDate=$createDate, updateDate=$updateDate, height=$height)"
    }
}