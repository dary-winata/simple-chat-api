package aej.kotlin.day1.tugas2.service.chat

import aej.kotlin.day1.tugas2.entity.Chat
import aej.kotlin.day1.tugas2.model.chat.ChatDatabase
import aej.kotlin.day1.tugas2.model.chat.ChatRequest

interface ChatService {
    suspend fun createChatRoom(chatRequest: ChatRequest): ChatDatabase
    suspend fun getAllChatRooms(): List<ChatDatabase>
    suspend fun addChat(id: String, chat: Chat): ChatDatabase
}