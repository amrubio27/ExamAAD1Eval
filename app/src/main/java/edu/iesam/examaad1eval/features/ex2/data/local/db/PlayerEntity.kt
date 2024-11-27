package edu.iesam.examaad1eval.features.ex2.data.local.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

const val PLAYER_TABLE = "player"
const val PLAYER_ID = "idPLAYER"

@Entity(tableName = PLAYER_TABLE)
data class PlayerEntity(
    @PrimaryKey @ColumnInfo(name = PLAYER_ID) val id: String,
    @ColumnInfo(name = "name") val name: String
)
