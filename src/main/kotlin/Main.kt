import dev.kord.core.Kord
import dev.kord.core.event.gateway.ReadyEvent
import dev.kord.core.event.message.MessageCreateEvent
import dev.kord.core.on
import dev.kord.gateway.Intent
import dev.kord.gateway.Intents
import io.github.cdimascio.dotenv.dotenv

suspend fun main() {
    val dotenv = dotenv()
    val kord = Kord(dotenv.get("CITATION_BOT_TOKEN"))
    kord.login() {
        intents = Intents(Intent.Guilds, Intent.GuildMessages)
    }

    kord.on<ReadyEvent> {
        println("Ready!")
    }

    kord.on<MessageCreateEvent> {
        if(message.author?.isBot == true && message.getGuildOrNull() == null) return@on
    }
}

