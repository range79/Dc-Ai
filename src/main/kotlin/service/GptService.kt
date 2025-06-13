package com.range.service

import com.aallam.openai.api.chat.ChatCompletionRequest
import com.aallam.openai.api.chat.ChatMessage
import com.aallam.openai.api.chat.ChatRole
import com.aallam.openai.api.model.ModelId
import com.aallam.openai.client.OpenAI
import com.range.config.GetEnv
import org.slf4j.LoggerFactory
import kotlin.math.log

class GptService {
    private val log = LoggerFactory.getLogger(GptService::class.java)
    private val token =GetEnv.getGptToken()
    suspend fun askToGpt(message: String?): String? {
        val gpt = OpenAI(token = token)
        val response = gpt.chatCompletion(
            ChatCompletionRequest(
                model = ModelId(GetEnv.getGptModel()),
                messages = listOf(
                    ChatMessage(role = ChatRole.User, content = message.orEmpty())
                )
            )
        )
        log.warn("Gpt response {}",response)
        return response.choices.firstOrNull()?.message?.content
    }

}