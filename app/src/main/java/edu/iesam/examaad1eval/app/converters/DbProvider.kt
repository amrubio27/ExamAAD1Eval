package edu.iesam.examaad1eval.app.converters

import android.content.Context
import androidx.room.Room
import edu.iesam.examaad1eval.app.ExamenDataBase

object DbProvider {
    fun provideDb(context: Context): ExamenDataBase {
        return Room.databaseBuilder(
            context,
            ExamenDataBase::class.java,
            "examenDb-db"
        ).fallbackToDestructiveMigration().build()
    }
}