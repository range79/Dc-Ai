package com.range.bot

import com.range.commants.GptCommand
import com.range.config.GetEnv
import io.github.cdimascio.dotenv.dotenv
import net.dv8tion.jda.api.JDABuilder
import net.dv8tion.jda.api.interactions.commands.OptionType
import net.dv8tion.jda.api.interactions.commands.build.Commands
import net.dv8tion.jda.api.requests.GatewayIntent


class Init {

    fun startBot(){

        val intents =setOf(GatewayIntent.GUILD_MESSAGES, GatewayIntent.MESSAGE_CONTENT)

        val jda = JDABuilder.createLight(GetEnv.getDicordToken(), intents).addEventListeners(GptCommand())
            .build()

        val commands = jda.updateCommands()
        commands.addCommands(
            Commands.slash("gpt","ask a question to gpt").addOption(OptionType.STRING,"content","Your question",true)
        )
        commands.queue()

    }


}