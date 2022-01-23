package com.github.hugovallada.adapter.pokemon.repository

import com.github.hugovallada.adapter.pokemon.model.Pokemon
import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import javax.enterprise.context.ApplicationScoped
import javax.ws.rs.ApplicationPath

@ApplicationScoped
class PokemonRepository : PanacheRepository<Pokemon> {
}