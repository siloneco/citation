# Commands Details

## `!command set`

Application Commandsを登録します。

サーバーの管理権限を持ったユーザーのみが実行できます。

## `!command remove`

Application Commandsを削除します。

サーバーの管理権限を持ったユーザーのみが実行できます。

## `!command update`

Application Commandsを更新します。

このコマンドは [Releases](https://github.com/m2en/citation/releases) で案内が行われた場合のみ必要です。

サーバーの管理権限を持ったユーザーのみが実行できます。

## `/debug`

| Command  | Parameter                                |
|----------|------------------------------------------|
| `/debug` | `<messageId: String> [channel: Channel]` |

第1引数で指定したメッセージIDのメッセージをコードブロックとして表示します。

実行したチャンネル、または第2引数で指定されたチャンネルのメッセージのみを検索することができます。

## `/help`

ヘルプを表示します。

## `/ping`

レイテンシを表示します。
