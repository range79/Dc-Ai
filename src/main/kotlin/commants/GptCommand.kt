package com.range.commants

import com.range.config.GetEnv.Companion.getChannel
import com.range.service.GptService
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class GptCommand : ListenerAdapter() {
    val log: Logger = LoggerFactory.getLogger(GptCommand::class.java)
    @OptIn(DelicateCoroutinesApi::class)
    override fun onSlashCommandInteraction(event: SlashCommandInteractionEvent) {
        if(event.user.isBot) return

        if(event.channel.id!=getChannel()) return
        if (event.name == "gpt"){
       val message = event.getOption("content")?.asString
            println(message)
            log.info("User")
            val service = GptService()
            GlobalScope.launch {
                try {
                    val answer: String? = service.askToGpt(message)
                    event.reply(answer.orEmpty()).setEphemeral(true).queue()
                } catch (e: Exception) {
                    log.error("GPT servis hatası", e)
                    event.reply("Bir hata oluştu: ${e.message}").setEphemeral(true).queue()
                }



        }}
    }
}