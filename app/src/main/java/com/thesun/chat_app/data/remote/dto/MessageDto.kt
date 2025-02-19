package com.thesun.chat_app.data.remote.dto

import com.thesun.chat_app.domain.model.Message
import kotlinx.serialization.Serializable

@Serializable
data class MessageDto (
    val text: String,
    val timestamp: Long,
    val username: String,
    val id: String
){
    fun toMessage() : Message{
        val date = java.util.Date(timestamp)
        val formattedDate = java.text.DateFormat
            .getDateInstance(java.text.DateFormat.DEFAULT)
            .format(date)
        return Message(
            text = text,
            formattedTime = formattedDate,
            username = username
        )
    }
}