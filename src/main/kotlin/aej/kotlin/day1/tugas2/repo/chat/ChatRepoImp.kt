package aej.kotlin.day1.tugas2.repo.chat

import aej.kotlin.day1.tugas2.database.DatabaseComponent
import aej.kotlin.day1.tugas2.entity.Chat
import aej.kotlin.day1.tugas2.model.chat.ChatDatabase
import aej.kotlin.day1.tugas2.model.chat.ChatRequest
import org.litote.kmongo.eq
import org.litote.kmongo.*
import org.litote.kmongo.getCollection
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
class ChatRepoImp: ChatRepo {
    @Autowired
    private lateinit var databaseComponent: DatabaseComponent

    private fun chatCollection() =
        databaseComponent.database.getDatabase("Chatting").getCollection<ChatDatabase>()

    override suspend fun createChatRoom(chatRequest: ChatRequest): ChatDatabase {
        val chatDatabase = ChatDatabase(
            id = UUID.randomUUID().toString(),
            userId = chatRequest.userId,
            chat = mutableListOf<Chat>()
        )

        val createChatRoom = chatCollection().insertOne(chatDatabase)

        return if(createChatRoom.wasAcknowledged()){
            chatDatabase
        } else{
            throw IllegalStateException("membuat chat gagal")
        }
    }

    override suspend fun getChatRooms(): List<ChatDatabase> {
        return chatCollection().find().toList()
    }

    override suspend fun addChat(id: String, chat: Chat): ChatDatabase {
        var oldChat = chatCollection().findOne(ChatDatabase::id eq id)

        if(oldChat == null) {
            throw IllegalStateException("gagal menambahkan chat")
        }

        oldChat.chat.add(chat)

        var chatDatabase = ChatDatabase(
            id = oldChat.id,
            userId = oldChat.userId,
            chat = oldChat.chat
        )

        chatCollection().updateOne(ChatDatabase::id eq id, chatDatabase)

        return chatDatabase
    }

}