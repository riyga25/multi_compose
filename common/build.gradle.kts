import org.jetbrains.compose.compose

plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization")
    id("org.jetbrains.compose")
    id("com.android.library")
}

group = "me.antonlabachou"
version = "1.0"

val ktorVersion = "1.6.7"
val coroutinesVersion = "1.5.2"
val serializationVersion = "1.3.1"

kotlin {
    android()
    jvm("desktop")
    sourceSets {
        val commonMain by getting {
            dependencies {
                api(compose.runtime)
                api(compose.foundation)
                api(compose.material)

                api("org.jetbrains.kotlinx:kotlinx-serialization-core:${serializationVersion}")

                // HTTP
                implementation("io.ktor:ktor-client-core:${ktorVersion}")
                implementation("io.ktor:ktor-client-json:${ktorVersion}")
                implementation("io.ktor:ktor-client-serialization:${ktorVersion}")
                implementation("io.ktor:ktor-client-logging:$ktorVersion")

                // Coroutines
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:${coroutinesVersion}")

                // DI
                implementation("org.kodein.di:kodein-di:7.9.0")
            }
        }
        val androidMain by getting {
            dependencies {
                api("androidx.appcompat:appcompat:1.4.0")
                api("androidx.core:core-ktx:1.7.0")

                // HTTP
                implementation("io.ktor:ktor-client-okhttp:$ktorVersion")
            }
        }
        val desktopMain by getting {
            dependencies {
                api(compose.preview)

                // HTTP
                implementation("io.ktor:ktor-client-cio:${ktorVersion}")
            }
        }
    }
}

android {
    compileSdk = 31
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdk = 24
        targetSdk = 31
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}