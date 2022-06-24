package aej.kotlin.day1.tugas2.repo.chat

import aej.kotlin.day1.tugas2.entity.Chat
import aej.kotlin.day1.tugas2.model.chat.ChatDatabase
import aej.kotlin.day1.tugas2.model.chat.ChatRequest

interface ChatRepo {
    suspend fun createChatRoom(chatRequest: ChatRequest): ChatDatabase
    suspend fun getChatRooms(): List<ChatDatabase>
    suspend fun addChat(id: String, chat: Chat): ChatDatabase
}