package edu.iesam.examaad1eval.features.ex2.data.local

import edu.iesam.examaad1eval.features.ex2.data.local.db.GameDao
import edu.iesam.examaad1eval.features.ex2.data.local.db.PlayerDao
import edu.iesam.examaad1eval.features.ex2.data.local.db.toDomain
import edu.iesam.examaad1eval.features.ex2.data.local.db.toEntity
import edu.iesam.examaad1eval.features.ex2.domain.Game
import edu.iesam.examaad1eval.features.ex2.domain.Player

class DbEx2LocalDataSource(
    private val gameDao: GameDao,
    private val playerDao: PlayerDao
) {
    suspend fun getAllGames(): List<Game> {
        return gameDao.findAllGames().map { gameEntity ->
            gameEntity.toDomain()
        }
    }

    suspend fun getAllPlayers(): List<Player> {
        return playerDao.findAllGames().map { playerEntity ->
            playerEntity.toDomain()
        }
    }

    suspend fun saveAllGames(games: List<Game>) {
        gameDao.saveAllGames(*games.map { it.toEntity() }.toTypedArray())

    }

    suspend fun saveAllPlayers(players: List<Player>) {
        playerDao.saveAllGames(*players.map { it.toEntity() }.toTypedArray())
    }

}