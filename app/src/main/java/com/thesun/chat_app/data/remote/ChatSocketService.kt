package com.thesun.chat_app.data.remote

import com.thesun.chat_app.domain.model.Message
import com.thesun.chat_app.util.Resource
import kotlinx.coroutines.flow.Flow

interface ChatSocketService {

    suspend fun initSession(
        username: String
    ): Resource<Unit>

    suspend fun sendMessage(message: String)

    fun observeMessages(): Flow<Message>

    suspend fun closeSession()

    companion object{
        const val BASE_URL = "ws://192.168.3.227:8082"
    }

    sealed class Endpoints(val url: String){
        object ChatSocket: Endpoints("$BASE_URL/chat-socket")

    }
}