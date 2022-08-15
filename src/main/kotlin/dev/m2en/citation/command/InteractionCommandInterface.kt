package dev.m2en.citation.command

import dev.kord.core.behavior.interaction.response.DeferredEphemeralMessageInteractionResponseBehavior
import dev.kord.core.entity.interaction.Interaction

interface InteractionCommandInterface {

    suspend fun onCommand(
        interaction: Interaction,
        responseBehavior: DeferredEphemeralMessageInteractionResponseBehavior
    )
}
