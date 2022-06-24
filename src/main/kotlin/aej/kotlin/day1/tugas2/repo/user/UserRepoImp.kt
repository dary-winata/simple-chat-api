package aej.kotlin.day1.tugas2.repo.user

import aej.kotlin.day1.tugas2.database.DatabaseComponent
import aej.kotlin.day1.tugas2.model.user.UserDatabase
import aej.kotlin.day1.tugas2.model.user.UserRequest
import org.litote.kmongo.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
class UserRepoImp: UserRepo {

    @Autowired
    private lateinit var databaseComponent: DatabaseComponent

    private fun userCollection() =
        databaseComponent.database.getDatabase("Chatting").getCollection<UserDatabase>()

    override suspend fun getUsers(): List<UserDatabase> {
        return userCollection().find().toList()
    }

    override suspend fun addUser(userRequest: UserRequest): UserDatabase {
        val userDatabase = UserDatabase(
            id = UUID.randomUUID().toString(),
            name = userRequest.name,
            username = userRequest.username,
            password = userRequest.password,
            friendList = null,
            descriptionProfile = userRequest.descriptionProfile
        )

        val insertUser = userCollection().insertOne(userDatabase)

        return if(insertUser.wasAcknowledged()){
            userDatabase
        } else {
            throw IllegalStateException("insert user gagal")
        }
    }

    override suspend fun updateUser(id: String, userRequest: UserRequest): UserDatabase {
        val oldData = userCollection().findOne(UserDatabase::id eq id)

        if(oldData == null)
            throw IllegalStateException("DATA KOSONG")

        println(oldData)

        val userDatabase = UserDatabase(
            id = oldData!!.id,
            name = userRequest.name,
            username = userRequest.username,
            password = userRequest.password,
            friendList = userRequest.friendList?:oldData.friendList,
            descriptionProfile = userRequest.descriptionProfile?:oldData.descriptionProfile
        )

        userCollection().updateOne(UserDatabase::id eq id, userDatabase)

        return userDatabase
    }
}