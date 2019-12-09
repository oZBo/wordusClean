const val kotlinVersion = "1.3.61"
const val gradleVersion = "3.5.3"
const val retrofitVersion = "2.5.0"
const val roomVersion = "2.2.2"
const val coroutinesVersion = "1.3.2"
const val lifecycleVersion = "2.2.0-rc03"
const val koinVersion = "2.0.1"

object AndroidSdk {
    const val min = 23
    const val compile = 29
    const val target = compile
    const val androidJUnitRunner = "androidx.test.runner.AndroidJUnitRunner"
}

object FileTree {
    val fileTree = mapOf("dir" to "libs", "include" to listOf("*.jar"))
}

object ResValue {
    const val abyyAppKeyName = "ABYY_APP_KEY"

    const val baseUrlName = "BASE_URL"
    const val baseUrlValue = "https://developers.lingvolive.com/"
}
