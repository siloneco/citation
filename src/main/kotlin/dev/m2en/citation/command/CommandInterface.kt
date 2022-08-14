package dev.m2en.citation.command

import dev.kord.core.entity.Message

interface CommandInterface {

    suspend fun onCommand(message: Message)

}
