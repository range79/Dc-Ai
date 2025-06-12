package com.range.service

import com.aallam.openai.api.chat.ChatCompletionRequest
import com.aallam.openai.api.chat.ChatMessage
import com.aallam.openai.api.chat.ChatRole
import com.aallam.openai.api.model.ModelId
import com.aallam.openai.client.OpenAI
import com.range.config.GetEnv

class GptService {
    suspend fun askToGpt(message: String?): String? {
        val  gpt = OpenAI(token = GetEnv.getGptToken() )
        val response = gpt.chatCompletion(        ChatCompletionRequest(
            model = ModelId("gpt-3.5-turbo"),
            messages = listOf(
                ChatMessage(role = ChatRole.User, content = "Bana bir şaka yap!")
            )
        ))
        return response.choices.first().message.content

    }
}