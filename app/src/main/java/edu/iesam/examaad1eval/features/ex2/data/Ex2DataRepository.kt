package edu.iesam.examaad1eval.features.ex2.data

import edu.iesam.examaad1eval.features.ex2.data.local.DbEx2LocalDataSource
import edu.iesam.examaad1eval.features.ex2.data.remote.MockEx2RemoteDataSource
import edu.iesam.examaad1eval.features.ex2.domain.Game
import edu.iesam.examaad1eval.features.ex2.domain.Player

class Ex2DataRepository(
    private val remote: MockEx2RemoteDataSource,
    private val local: DbEx2LocalDataSource
) {
    suspend fun getAllGames(): List<Game> {
        return remote.getGames()
    }

    suspend fun saveAllGames(games: List<Game>) {
        local.saveAllGames(games)
    }

    suspend fun getAllPlayers(): List<Player> {
        return remote.getPlayers()
    }

    suspend fun saveAllPlayers(players: List<Player>) {
        local.saveAllPlayers(players)
    }



}