package edu.iesam.examaad1eval.features.ex2.data.local.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface PlayerDao {
    @Query("SELECT * FROM $PLAYER_TABLE")
    fun findAllGames(): List<PlayerEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveAllGames(vararg player: PlayerEntity)
}