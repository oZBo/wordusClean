import org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions
import org.jetbrains.kotlin.konan.properties.Properties

private val properties: Properties by lazy {
    Properties().also {
        val load = project.rootProject.file("local.properties").inputStream()
        it.load(load)
    }
}

plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-android-extensions")
    id("kotlin-kapt")
}

android {
    compileSdkVersion(AndroidSdk.compile)
    defaultConfig {
        applicationId = "com.braincollaboration.wordus"
        minSdkVersion(AndroidSdk.min)
        targetSdkVersion(AndroidSdk.target)
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = AndroidSdk.androidJUnitRunner
        vectorDrawables.useSupportLibrary = true

        kapt.arguments {
            arg("room.schemaLocation", "$projectDir/schemas")
        }

        buildConfigField("String", ResValue.baseUrlName, "\"${ResValue.baseUrlValue}\"")

        val abyyAppKeyValue = getAbyyAppKey()
        buildConfigField("String", ResValue.abyyAppKeyName, abyyAppKeyValue)
    }

    buildTypes.getByName("release") {
        isMinifyEnabled = false //R8 shrinking
        proguardFiles(
            getDefaultProguardFile("proguard-android-optimize.txt"),
            "proguard-rules.pro"
        )
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    (kotlinOptions as KotlinJvmOptions).apply {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }

    dataBinding.isEnabled = true
}

androidExtensions.isExperimental = true

dependencies {
    implementation(fileTree(FileTree.fileTree))
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion")
    implementation("androidx.appcompat:appcompat:1.1.0")
    implementation("androidx.fragment:fragment-ktx:1.2.0-rc04")
    implementation("androidx.core:core-ktx:1.2.0-rc01")
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    implementation("com.google.android.material:material:1.2.0-alpha03")
    // don't update to beta2 (has an issues)
    implementation("androidx.constraintlayout:constraintlayout:2.0.0-beta4")
    kapt("com.android.databinding:compiler:$gradleVersion")

    implementation("com.squareup.retrofit2:retrofit:$retrofitVersion")
    implementation("com.squareup.retrofit2:converter-gson:$retrofitVersion")
    implementation("com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:0.9.2")

    implementation("org.jetbrains.kotlin:kotlin-reflect:1.3.61")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutinesVersion")

    implementation("androidx.lifecycle:lifecycle-extensions:$lifecycleVersion")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycleVersion")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycleVersion")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:$lifecycleVersion")
    implementation("androidx.lifecycle:lifecycle-common-java8:$lifecycleVersion")

    implementation("androidx.room:room-ktx:$roomVersion")
    implementation("androidx.room:room-runtime:$roomVersion")
    kapt("androidx.room:room-compiler:$roomVersion")

    implementation ("io.github.inflationx:calligraphy3:3.1.1")
    implementation ("io.github.inflationx:viewpump:2.0.3")

    // Koin for Android
    implementation("org.koin:koin-android:$koinVersion")
    // Koin AndroidX Scope features
    implementation("org.koin:koin-androidx-scope:$koinVersion")
    // Koin AndroidX ViewModel features
    implementation("org.koin:koin-androidx-viewmodel:$koinVersion")

    testImplementation("junit:junit:4.13-beta-2")
    androidTestImplementation("androidx.test:runner:1.2.0")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.2.0")
}

fun getAbyyAppKey(): String {
    return properties.getProperty("abyy_app_key", "")
}