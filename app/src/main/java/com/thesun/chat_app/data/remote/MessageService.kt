package com.thesun.chat_app.data.remote

import com.thesun.chat_app.domain.model.Message

interface MessageService {

    suspend fun getAllMessages(): List<Message>

    companion object{
        const val BASE_URL = "http://192.168.3.227:8082"
    }

    sealed class Endpoints(val url: String){
        object GetAllMessages: Endpoints("$BASE_URL/messages")

    }
}