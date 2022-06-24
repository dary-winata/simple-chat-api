package aej.kotlin.day1.tugas2.model.chat

import aej.kotlin.day1.tugas2.entity.Chat

data class ChatDatabase(
    val id: String,
    val userId: MutableList<String>,
    var chat: MutableList<Chat>
)
