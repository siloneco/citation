package utils

import io.github.cdimascio.dotenv.dotenv

object Util {

    /**
     * Returns the environment variable for the Key specified by the first argument.
     * If the environment variable does not exist, the default value specified in the second argument is returned.
     *
     * @return Environment variable (or default value)
     */
    fun getEnv(value: String): String {
        val dotenv = dotenv()
        return dotenv.get(value) ?: error("次の環境変数が正しく設定されていません -> $value")
    }
}
