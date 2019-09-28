const val kotlinVersion = "1.3.50"
const val gradleVersion = "3.5.0"
const val retrofitVersion = "2.5.0"
const val roomVersion = "2.1.0"
const val coroutinesVersion = "1.3.1"
const val lifecycleVersion = "2.2.0-alpha05"

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
    private const val buildConfigFieldStringType = "String"

    const val abyyLingvoType = buildConfigFieldStringType
    const val abyyLingvoName = "APP_KEY"
    const val abyyLingvoValue = "MGU1YmEyZTctYTY5Mi00ZjhhLWJlM2UtYmU5ODg5YzcyMWI4OjkzY2FkYmEyYWQ2ZDQyYmQ5NmE0MGNhMTE2MWQ0YWZi"

    const val baseUrlType = buildConfigFieldStringType
    const val baseUrlName = "BASE_URL"
    const val baseUrlValue = "https://developers.lingvolive.com/"
}
