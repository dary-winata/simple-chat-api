package aej.kotlin.day1.tugas2.model.user

data class UserDatabase(
    val id: String,
    val name: String,
    val username: String,
    val password: String,
    var friendList: MutableList<String>?,
    val descriptionProfile: String?
)
