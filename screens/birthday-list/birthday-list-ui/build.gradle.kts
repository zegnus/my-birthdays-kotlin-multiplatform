plugins {
    id("com.android.library")
    kotlin("android")
    id("kotlin-android")
}

android {
    compileSdkVersion(Versions.androidCompileSdk)

    defaultConfig {
        minSdkVersion(Versions.androidMinSdk)
        targetSdkVersion(Versions.androidTargetSdk)

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = Versions.java
    }
}

dependencies {
    implementation(Dependencies.Kotlin.standardLibrary)
    implementation(Dependencies.AndroidX.coreExtensions)
    implementation(Dependencies.AndroidX.appCompat)

    implementation(Dependencies.Material.materialDesign)
    implementation("androidx.appcompat:appcompat:1.2.0")
    implementation("org.jetbrains.kotlin:kotlin-stdlib:${rootProject.extra["kotlin_version"]}")
    implementation("androidx.constraintlayout:constraintlayout:2.0.4")

    testImplementation(Dependencies.Testing.UnitTesting.jUnit)

    androidTestImplementation(Dependencies.Testing.AndroidInstrumentation.jUnitExtensions)
    androidTestImplementation(Dependencies.Testing.AndroidInstrumentation.expressoCore)
}