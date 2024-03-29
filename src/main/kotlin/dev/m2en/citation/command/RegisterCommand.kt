package dev.m2en.citation.command

import dev.kord.common.entity.Snowflake
import dev.kord.core.Kord
import dev.kord.core.behavior.reply
import dev.kord.core.entity.Message
import dev.kord.core.kordLogger
import dev.kord.rest.builder.interaction.channel
import dev.kord.rest.builder.interaction.string
import io.github.cdimascio.dotenv.dotenv

object RegisterCommand: MessageCommandInterface {

    private val dotenv = dotenv()

    override suspend fun onCommand(message: Message) {
        val kord = message.kord
        try {
            kordLogger.info("Application Commandの登録を開始します....")
            message.reply { content = "Application Commandの登録を開始します...." }

            registerSlashCommand(kord)

            kordLogger.info("Application Commandの登録に成功しました")
            message.reply { content = "Application Commandの登録に成功しました\n(コマンドが反映していない場合はDiscordクライアントの再起動をしてください)" }
        } catch (e: Exception) {
            kordLogger.error("Application Commandの登録に失敗しました。", e)
            message.reply { content = "Application Commandの登録に失敗しました。詳細はログを参照してください。" }
        }
    }

    private suspend fun registerSlashCommand(kord: Kord) {
        // /help
        kord.createGuildChatInputCommand(
            Snowflake(dotenv.get("GUILD_ID")),
            "help",
            "ヘルプを表示します"
        )

        // /debug <messageId> [channelId]
        kord.createGuildChatInputCommand(
            Snowflake(dotenv.get("GUILD_ID")),
            "debug",
            "メッセージをデバックします"
        ) {
            string("target", "メッセージIDを指定してください") {
                required = true
            }
        }
    }
}
