package aej.kotlin.day1.tugas2.model.user

import javax.validation.constraints.NotBlank

data class UserRequest (
    @field:NotBlank
    val name: String,
    @field:NotBlank
    val username: String,
    @field:NotBlank
    val password: String,
    val friendList: MutableList<String>?,
    val descriptionProfile: String?
)