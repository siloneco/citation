package dev.m2en.citation.command

import dev.kord.core.behavior.interaction.response.DeferredEphemeralMessageInteractionResponseBehavior
import dev.kord.core.entity.interaction.GuildChatInputCommandInteraction

interface InteractionCommandInterface {

    suspend fun onCommand(
        interaction: GuildChatInputCommandInteraction,
        responseBehavior: DeferredEphemeralMessageInteractionResponseBehavior
    )
}
