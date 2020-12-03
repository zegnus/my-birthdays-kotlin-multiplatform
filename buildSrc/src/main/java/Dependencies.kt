object Versions {
    const val androidMinSdk = 21
    const val androidTargetSdk = 29
    const val androidCompileSdk = 29
    const val coroutines = "1.4.2-native-mt"
    const val kotlin = "1.4.20"
    const val java = "1.8"
    const val buildTools = "30.0.2"
    const val androidXTest = "1.3.0"
}

object Dependencies {
    object Gradle {
        const val androidGradlePlugin = "com.android.tools.build:gradle:4.1.1"
        const val kotlinPlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    }

    object Coroutines {
        val common = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
        val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
    }

    object Kotlin {
        const val standardLibrary = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"
    }

    object AndroidX {
        const val coreExtensions = "androidx.core:core-ktx:1.3.2"
        const val appCompat = "androidx.appcompat:appcompat:1.2.0"
        const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:2.2.0"
    }

    object Material {
        const val materialDesign = "com.google.android.material:material:1.2.1"
    }

    object Testing {
        const val junit = "junit:junit:4.13"
        const val robolectric = "org.robolectric:robolectric:4.4"

        object AndroidXTest {
            const val core = "androidx.test:core:${Versions.androidXTest}"
            const val junit = "androidx.test.ext:junit:1.1.2"
            const val runner = "androidx.test:runner:${Versions.androidXTest}"
            const val rules = "androidx.test:rules:${Versions.androidXTest}"
            const val expressoCore = "androidx.test.espresso:espresso-core:3.3.0"
        }

        object KotlinTest {
            const val common = "org.jetbrains.kotlin:kotlin-test-common:${Versions.kotlin}"
            const val annotations = "org.jetbrains.kotlin:kotlin-test-annotations-common:${Versions.kotlin}"
            const val jvm = "org.jetbrains.kotlin:kotlin-test:${Versions.kotlin}"
            const val junit = "org.jetbrains.kotlin:kotlin-test-junit:${Versions.kotlin}"
        }
    }
}
