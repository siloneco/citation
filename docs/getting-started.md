# Getting Started

- [ビルド済みイメージの取得](#ビルド済みイメージの取得)
- [Botの登録](#Botの登録)
- [コマンドの登録](#コマンドの登録)
- [コマンドの削除](#コマンドの削除)
- [コマンドのアップデート](#コマンドのアップデート)

## ビルド済みイメージの取得

次のコマンドを実行し、ビルド済みイメージを取得してください。

```shell
docker pull ghcr.io/m2en/citation:latest
```

## Botの登録

1. [Developer Portal](https://discord.com/developers/applications) にアクセスする
2. `New Application`をクリックする
3. `name` にBotの名前を入力する
4. 次に `Bots` タブへ移動し、 `New bot` をクリックしBotを作成する
5. `PRESENCE INTENT`, `SERVER MEMBERS INTENT`, `MESSAGE CONTENT INTENT` をそれぞれONにする
6. `Reset token` からトークンを取得する
7. `OAuth2` タブに移動し、 `URL Generator` をクリックする
8. `SCOPES` から以下のScopeを選択する
    - `bot`
    - `applications.commands`
9. `BOT PERMISSIONS` から以下の権限を選択する
    - `Send Messages`
    - `Send Messages in Threads`
    - `Read Messages / View Channels`
10. 生成されたURLからBotを招待する

### コマンドの登録

次にApplicationCommandsを登録します。

次の環境変数を登録し、 `!register` を実行します。

- `CLIENT_ID`
- `GUILD_ID`
