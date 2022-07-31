@file:JvmName("Mainkt")

import dev.kord.core.Kord
import dev.kord.core.event.gateway.ReadyEvent
import dev.kord.core.on
import utils.Util

suspend fun main() {
    val kord = Kord(Util.getEnv("CITATION_BOT_TOKEN"))
    kord.login()

    kord.on<ReadyEvent> {
        println("Ready!")
    }
}

