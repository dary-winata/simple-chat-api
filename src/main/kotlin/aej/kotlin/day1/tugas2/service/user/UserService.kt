package aej.kotlin.day1.tugas2.service.user

import aej.kotlin.day1.tugas2.model.user.UserDatabase
import aej.kotlin.day1.tugas2.model.user.UserRequest

interface UserService {
    suspend fun getUsers(): List<UserDatabase>
    suspend fun addUser(userRequest: UserRequest): UserDatabase
    suspend fun updateUser(id: String, userRequest: UserRequest): UserDatabase
}