package com.range.commants

import com.range.config.GetEnv.Companion.getChannel
import com.range.service.GptService
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class GptCommand : ListenerAdapter() {
    val log: Logger = LoggerFactory.getLogger(GptCommand::class.java)
    override fun onSlashCommandInteraction(event: SlashCommandInteractionEvent) {
        if(event.user.isBot) return

        if(event.channel.id!=getChannel()) return
        if (event.name == "gpt"){
       val message = event.getOption("content")?.asString
            println(message)
            log.info("User")
            val service = GptService()
        suspend {
            val answer: String? = service.askToGpt(message)
            event.reply(answer.orEmpty()).setEphemeral(true).queue()
        }



        }
    }
}