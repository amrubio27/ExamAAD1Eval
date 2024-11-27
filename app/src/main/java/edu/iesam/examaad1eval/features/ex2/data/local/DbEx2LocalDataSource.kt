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










/*class DbLocalDataSource(
    private val userDao: UserDao,
    private val playlistDao: PlaylistDao
) {
    suspend fun getAllUsers() {
        userDao.findAll().map { userEntity ->
            userEntity.toDomain()
        }
    }

    suspend fun getAllPlaylists() {
        playlistDao.findAll().map { playlistEntity ->
            playlistEntity.toDomain()
        }
    }

    suspend fun getUserById(userId: String) {
        userDao.findById(userId).toDomain()
    }

    suspend fun getPlaylistById(playlistId: String) {
        playlistDao.findById(playlistId).toDomain()
    }

    suspend fun saveUser(user: User) {
        userDao.save(user.toEntity())
    }

    suspend fun saveUser(user: User) {
        userDao.save(user.toEntity())
    }

    suspend fun savePlaylist(playlist: Playlist) {
        playlistDao.save(playlist.toEntity())
    }

    suspend fun saveAllUsers(users: List<User>) {
        userDao.saveAll(*users.map { it.toEntity() }.toTypedArray())
    }

    suspend fun saveAllPlaylists(playlists: List<Playlist>) {
        playlistDao.saveAll(*playlists.map { it.toEntity() }.toTypedArray())
    }

    suspend fun deleteUserById(userId: String) {
        userDao.deleteById(userId)
    }

    suspend fun deletePlaylistById(playlistId: String) {
        playlistDao.deleteById(playlistId)
    }

    suspend fun deleteAllUsers() {
        userDao.deleteAll()
    }

    suspend fun deleteAllPlaylists() {
        playlistDao.deleteAll()
    }

    suspend fun getUserPlaylists() : List<UserWithPlaylists>{
        return userDao.getUsersWithPlaylists()
    }

    suspend fun sa
* */

/*
* private suspend fun testRoom() {
val db = DbLocalDataSource(
    DataBaseProvider.provideDb(this).UserDao(),
    DataBaseProvider.provideDb(this).PlaylistDao()
)

//Crear datos de prueba
val user1 = User("1", "user1", "juanito@email.com")
val user2 = User("2", "user2", "pepe@email.com")
val playlist1 = Playlist("1", "playlist1", "RapDePokemon")
val playlist2 = Playlist("2", "playlist2", "OpeningsDigimon")

//Guardar datos de prueba
db.saveUser(user1)
db.saveUser(user2)
db.savePlaylist(playlist1)
db.savePlaylist(playlist2)
db.saveAllUsers(listOf(user1, user2))
db.saveAllPlaylists(listOf(playlist1, playlist2))

//Obtener datos de prueba Usuarios
val user1Db = db.getUserById("1")
Log.d("User 1", "$user1Db")

val users = db.getAllUsers()
Log.d("Users", "$users")

//Obtener datos de prueba Playlists
val playlist1Db = db.getPlaylistById("1")
Log.d("Playlist 1", "$playlist1Db")

val playlists = db.getAllPlaylists()
Log.d("Playlists", "$playlists")

//Borrar datos de prueba
db.deleteUserById("1")
Log.d("Users", "${db.getAllUsers()}")*/