package dev.m2en.citation

import dev.kord.core.Kord
import dev.kord.core.event.gateway.ReadyEvent
import dev.kord.core.event.interaction.GuildChatInputCommandInteractionCreateEvent
import dev.kord.core.event.message.MessageCreateEvent
import dev.kord.core.kordLogger
import dev.kord.core.on
import dev.kord.gateway.Intent
import dev.kord.gateway.Intents
import dev.kord.gateway.PrivilegedIntent
import dev.m2en.citation.command.HelpCommand
import dev.m2en.citation.command.InteractionCommandInterface
import dev.m2en.citation.command.MessageCommandInterface
import dev.m2en.citation.command.RegisterCommand
import io.github.cdimascio.dotenv.dotenv

@OptIn(PrivilegedIntent::class)
suspend fun main() {
    val dotenv = dotenv()
    val kord = Kord(dotenv.get("CITATION_BOT_TOKEN"))

    val messageMap = mutableMapOf<String, MessageCommandInterface>()
    messageMap["!register"] = RegisterCommand

    val interactionMap = mutableMapOf<String, InteractionCommandInterface>()
    interactionMap["help"] = HelpCommand

    kord.on<ReadyEvent> {
        println("citation is ready!")
    }

    /**
     * Kordが接続しているクライアントユーザー(Bot)が参加しているギルドに対してメッセージが送信されたら発火するイベント
     */
    kord.on<MessageCreateEvent> {
        if(message.author?.isBot == true || message.getGuildOrNull() == null) return@on
        when(message.content) {
            "!register" -> {
                messageMap["!register"]?.onCommand(message)
            }
        }
    }

    /**
     * Kordが接続しているクライアントユーザー(Bot)に対してインタラクションが発行されたら動作するイベント
     */
    kord.on<GuildChatInputCommandInteractionCreateEvent> {
        if(interaction.getGuildOrNull() == null) return@on

        // インタラクションが発行されたコマンドを取得、本来用意されていないコマンドのインタラクションが発行された場合はエラーをLoggerから報告する
        when(interaction.invokedCommandName) {
            "help" -> {
                interactionMap["help"]?.onCommand(interaction, interaction.deferEphemeralResponse())
            }

            else -> {
                kordLogger.warn("警告: citationで本来想定されていない不正なインタラクションを受信しました。レスポンスは返さず無視します。")
                return@on
            }
        }

        // 発行されたインタラクションについて報告する
        kordLogger.info("ログ: ${interaction.user.tag} が ${interaction.invokedCommandName}(${interaction.invokedCommandId}) を実行しました")
    }

    kord.login() {
        intents = Intents(Intent.Guilds, Intent.GuildMessages, Intent.MessageContent)
    }
}

