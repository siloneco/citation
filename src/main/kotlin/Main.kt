@file:JvmName("Mainkt")

import dev.kord.core.Kord
import dev.kord.core.event.gateway.ReadyEvent
import dev.kord.core.on

suspend fun main() {
    val kord = Kord("MTAwMzM2Nzk4NDE2MjY3Mjc2MQ.GwPVzH.TTjUycLgQBjUZr_P2CkpddAUjj3GcNmXrzKnFU")
    kord.login()

    kord.on<ReadyEvent> {
        println("Ready!")
    }
}

