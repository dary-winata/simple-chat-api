package aej.kotlin.day1.tugas2.service.chat

import aej.kotlin.day1.tugas2.entity.Chat
import aej.kotlin.day1.tugas2.model.chat.ChatDatabase
import aej.kotlin.day1.tugas2.model.chat.ChatRequest
import aej.kotlin.day1.tugas2.repo.chat.ChatRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ChatServiceImp: ChatService {

    @Autowired
    private lateinit var chatRepo: ChatRepo

    override suspend fun createChatRoom(chatRequest: ChatRequest): ChatDatabase {
        return chatRepo.createChatRoom(chatRequest)
    }

    override suspend fun getAllChatRooms(): List<ChatDatabase> {
        return chatRepo.getChatRooms()
    }

    override suspend fun addChat(id: String, chat: Chat): ChatDatabase {
        return chatRepo.addChat(id, chat)
    }
}