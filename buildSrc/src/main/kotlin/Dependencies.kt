const val kotlinVersion = "1.3.50"
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
