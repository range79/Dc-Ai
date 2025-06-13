package com.range.config

import io.github.cdimascio.dotenv.dotenv

class GetEnv {

    companion object{

        private val env = dotenv()

        fun  getChannel(): String{

            return env.get("MESSAGE_CHANNEL")

        }
        fun getGptModel():String{
            return env.get("GPT_MODEL")
        }
        fun getGptToken():String{
            return env.get("GPT_TOKEN")
        }

        fun getDicordToken():String?{
            return env.get("DISCORD_TOKEN")
        }

    }






}