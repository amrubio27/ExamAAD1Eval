package edu.iesam.examaad1eval

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import edu.iesam.examaad1eval.app.ExamenDataBase
import edu.iesam.examaad1eval.app.converters.DbProvider
import edu.iesam.examaad1eval.features.ex1.data.Ex1DataRepository
import edu.iesam.examaad1eval.features.ex1.data.local.sharedPref.XmlEx1LocalDataSource
import edu.iesam.examaad1eval.features.ex1.data.remote.MockEx1RemoteDataSource
import edu.iesam.examaad1eval.features.ex2.data.Ex2DataRepository
import edu.iesam.examaad1eval.features.ex2.data.local.DbEx2LocalDataSource
import edu.iesam.examaad1eval.features.ex2.data.remote.MockEx2RemoteDataSource
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //executeExercise1()
        executeExercise2()
    }

    private fun executeExercise1(){
        //Ejecutar el ejercicio 1 desde aquí llamando al Ex1DataRepository directamente
        //Inicializar el Ex1DataRepository con el MockEx1RemoteDataSource y el XmlEx1LocalDataSource
        val ex1DataRepository = Ex1DataRepository(MockEx1RemoteDataSource(), XmlEx1LocalDataSource(this))
        //Llamar a los métodos
        ex1DataRepository.getUsers()
        ex1DataRepository.getItems()
        ex1DataRepository.getServices()

        //printeamos en Log
        Log.d("@dev", "Users: " + ex1DataRepository.getUsers().toString())
        Log.d("@dev", "Items: " + ex1DataRepository.getItems().toString())
        Log.d("@dev", "Services: " + ex1DataRepository.getServices().toString())
    }

    @OptIn(DelicateCoroutinesApi::class)
    private fun executeExercise2(){
        //Ejecutar el ejercicio 2 desde aquí llamando al Ex2DataRepository directamente
        GlobalScope.launch {
            //llamar a Room
            val db = DbEx2LocalDataSource(
                DbProvider.provideDb(this@MainActivity).gameDao(),
                DbProvider.provideDb(this@MainActivity).playerDao()
            )
            //llamar a los metodos del repositorio
            val ex2DataRepository = Ex2DataRepository(MockEx2RemoteDataSource(), db)
            val games = ex2DataRepository.getAllGames()
            ex2DataRepository.saveAllGames(games)

            val players = ex2DataRepository.getAllPlayers()
            ex2DataRepository.saveAllPlayers(players)

            //Llamar a los métodos
            /*val games= db.getAllGames()
            db.saveAllGames(games)
            val players= db.getAllPlayers()
            db.saveAllPlayers(players)*/
        }
    }
}