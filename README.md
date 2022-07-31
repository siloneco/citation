# citation

メッセージリンクのプレビューをEmbedで表示するDiscord Botです。

## Usage

citationはDockerをサポートしています。次のコマンドを使用することでビルド済みイメージを利用することができます。

```shell
docker pull ghcr.io/m2en/citation:latest
```

## Register Commands

citationは[ApplicationCommands](https://discord.com/developers/docs/interactions/application-commands)をサポートしています。

`/debug`などのコマンド類を使用するには登録が必要です。

登録方法については [citation docs](https://citation.merunno.dev/) を参照してください。

## Environment variables

| value                | description                                                                          | required |
|----------------------|--------------------------------------------------------------------------------------|----------|
| `CITATION_BOT_TOKEN` | citationが接続するDiscord Botのトークン ([発行方法](https://citation.merunno.dev/getting-started)) | `true`   |
| `CLIENT_ID`          | Commandを登録するDiscord BotのユーザーID                                                       | `false`  |
| `GUILD_ID`           | Commandを登録したいサーバーのギルドID                                                              | `false`  |
