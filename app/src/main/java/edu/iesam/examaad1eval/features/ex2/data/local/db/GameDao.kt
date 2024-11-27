package edu.iesam.examaad1eval.features.ex2.data.local.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface GameDao {
    @Query("SELECT * FROM $GAME_TABLE")
    fun findAllGames(): List<GameEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveAllGames(vararg games: GameEntity)

}
















/*Query("SELECT * FROM $PLAYLIST_TABLE")
    suspend fun findAll(): List<PlaylistEntity>

    @Query("SELECT * FROM $PLAYLIST_TABLE where $PLAYLIST_ID = :playlistId LIMIT 1")
    suspend fun findById(playlistId: String): PlaylistEntity

    @Query("DELETE FROM $PLAYLIST_TABLE where $PLAYLIST_ID = :playlistId")
    suspend fun deleteById(playlistId: String)

    @Query("DELETE FROM $PLAYLIST_TABLE")
    suspend fun deleteAll()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveAll(vararg playlists: PlaylistEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun save(playlist: PlaylistEntity)*/