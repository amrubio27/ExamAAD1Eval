package edu.iesam.examaad1eval.features.ex1.data.local.sharedPref

import android.content.Context
import com.google.gson.Gson
import edu.iesam.examaad1eval.R
import edu.iesam.examaad1eval.features.ex1.domain.Item
import edu.iesam.examaad1eval.features.ex1.domain.Services
import edu.iesam.examaad1eval.features.ex1.domain.User

class XmlEx1LocalDataSource(private val context: Context) {
    private val sharedPref = context.getSharedPreferences(
        context.getString(R.string.db_exam), Context.MODE_PRIVATE
    )

    private val gson = Gson()

    fun saveAllUsers(users: List<User>) {
        val editor = sharedPref.edit()
        users.forEach { user ->
            val userJson = gson.toJson(user)
            editor.putString("user_"+user.id, userJson)
        }
        editor.apply()
    }

    fun findAllUsers(): List<User> {
        return sharedPref.all.filterKeys { it.startsWith("user_") }.values.mapNotNull { jsonUser ->
            gson.fromJson(jsonUser as String, User::class.java)
        }
    }

    fun saveAllItems(items: List<Item>) {
        val editor = sharedPref.edit()
        items.forEach { item ->
            val itemJson = gson.toJson(item)
            editor.putString("item_"+item.id, itemJson)
        }
        editor.apply()
    }

    fun findAllItems(): List<Item> {
        return sharedPref.all.filterKeys { it.startsWith("item_") }.values.mapNotNull { jsonItem ->
            gson.fromJson(jsonItem as String, Item::class.java)
        }
    }

    fun saveAllServices(services: List<Services>) {
        val editor = sharedPref.edit()
        services.forEach { service ->
            val serviceJson = gson.toJson(service)
            editor.putString("service_"+service.id, serviceJson)
        }
        editor.apply()
    }

    fun findAllServices(): List<Services> {
        return sharedPref.all.filterKeys { it.startsWith("service_") }.values.mapNotNull { jsonService ->
            gson.fromJson(jsonService as String, Services::class.java)
        }
    }


}