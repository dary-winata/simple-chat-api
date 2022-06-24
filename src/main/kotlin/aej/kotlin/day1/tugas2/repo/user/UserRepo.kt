package aej.kotlin.day1.tugas2.repo.user

import aej.kotlin.day1.tugas2.model.user.UserDatabase
import aej.kotlin.day1.tugas2.model.user.UserRequest

interface UserRepo {
    suspend fun getUsers(): List<UserDatabase>
    suspend fun addUser(userRequest: UserRequest): UserDatabase
    suspend fun updateUser(id: String, userRequest: UserRequest): UserDatabase
}