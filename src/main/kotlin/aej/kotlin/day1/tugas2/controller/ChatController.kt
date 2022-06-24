package aej.kotlin.day1.tugas2.controller

import aej.kotlin.day1.tugas2.entity.Chat
import aej.kotlin.day1.tugas2.model.BaseResponse
import aej.kotlin.day1.tugas2.model.chat.ChatDatabase
import aej.kotlin.day1.tugas2.model.chat.ChatRequest
import aej.kotlin.day1.tugas2.service.chat.ChatService
import com.fasterxml.jackson.databind.ser.Serializers.Base
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("aej/2/chat")
class ChatController {
    @Autowired
    private lateinit var chatService: ChatService

    @GetMapping
    suspend fun getAllChatRooms(): BaseResponse<List<ChatDatabase>> {
        return BaseResponse(
            code = "200",
            message = "data room berhasil diambil",
            data = chatService.getAllChatRooms()
        )
    }

    @PostMapping
    suspend fun createNewChatRoom(@RequestBody chatRequest: ChatRequest): BaseResponse<ChatDatabase> {
        return BaseResponse(
            code = "200",
            message = "chat room berhasil di buat",
            data = chatService.createChatRoom(chatRequest)
        )
    }

    @PutMapping("/{id}")
    suspend fun addChat(@PathVariable id: String, @RequestBody chat: Chat): BaseResponse<ChatDatabase> {
        return BaseResponse(
            code = "200",
            message = "Chat berhasil ditambahkan",
            data = chatService.addChat(id, chat)
        )
    }
}