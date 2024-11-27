package edu.iesam.examaad1eval.features.ex2.data.local.db

import edu.iesam.examaad1eval.features.ex2.domain.Game
import edu.iesam.examaad1eval.features.ex2.domain.Player

fun GameEntity.toDomain(): Game {
    return Game(
        id = id,
        title = title,
        player = player
    )
}

fun Game.toEntity() : GameEntity {
    return GameEntity(
        id = id,
        title = title,
        player = player
    )
}

fun PlayerEntity.toDomain(): Player {
    return Player(id, name)
}

fun Player.toEntity(): PlayerEntity {
    return PlayerEntity(id, name)
}