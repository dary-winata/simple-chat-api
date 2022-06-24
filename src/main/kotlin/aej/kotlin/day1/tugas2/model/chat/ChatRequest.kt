package aej.kotlin.day1.tugas2.model.chat

import aej.kotlin.day1.tugas2.entity.Chat
import javax.validation.constraints.NotBlank

data class ChatRequest(
    @field:NotBlank
    val userId: MutableList<String>,
    val chat: MutableList<Chat>?
)
