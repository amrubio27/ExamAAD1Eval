package edu.iesam.examaad1eval.features.ex1.data

import edu.iesam.examaad1eval.features.ex1.data.local.sharedPref.XmlEx1LocalDataSource
import edu.iesam.examaad1eval.features.ex1.data.remote.MockEx1RemoteDataSource
import edu.iesam.examaad1eval.features.ex1.domain.Ex1Repository
import edu.iesam.examaad1eval.features.ex1.domain.Item
import edu.iesam.examaad1eval.features.ex1.domain.Services
import edu.iesam.examaad1eval.features.ex1.domain.User

class Ex1DataRepository(
    private val remote: MockEx1RemoteDataSource,
    private val localXml: XmlEx1LocalDataSource
) : Ex1Repository {
    override fun getUsers(): List<User> {
        val users = localXml.findAllUsers()
        if (users.isEmpty()) {
            val remoteUsers = remote.getUsers()
            localXml.saveAllUsers(remoteUsers)
            return remoteUsers
        } else {
            return users
        }
    }

    override fun getItems(): List<Item> {
        val items = localXml.findAllItems()
        if (items.isEmpty()) {
            val remoteItems = remote.getItems()
            localXml.saveAllItems(remoteItems)
            return remoteItems
        } else {
            return items
        }
    }

    override fun getServices(): List<Services> {
        val services = localXml.findAllServices()
        if (services.isEmpty()) {
            val remoteServices = remote.getServices()
            localXml.saveAllServices(remoteServices)
            return remoteServices
        } else {
            return services
        }
    }
}