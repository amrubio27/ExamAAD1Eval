package edu.iesam.examaad1eval.app

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import edu.iesam.examaad1eval.app.converters.ListConverter
import edu.iesam.examaad1eval.features.ex2.data.local.db.GameDao
import edu.iesam.examaad1eval.features.ex2.data.local.db.GameEntity
import edu.iesam.examaad1eval.features.ex2.data.local.db.PlayerDao
import edu.iesam.examaad1eval.features.ex2.data.local.db.PlayerEntity

@Database(entities = [GameEntity::class, PlayerEntity::class], version = 1, exportSchema = false)
@TypeConverters(ListConverter::class)
abstract class ExamenDataBase : RoomDatabase() {
    abstract fun gameDao(): GameDao
    abstract fun playerDao(): PlayerDao
}