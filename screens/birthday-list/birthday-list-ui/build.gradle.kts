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
    implementation(project(":screens:birthday-list:birthday-list-business-logic"))

    implementation(Dependencies.Kotlin.standardLibrary)
    implementation(Dependencies.AndroidX.coreExtensions)
    implementation(Dependencies.AndroidX.appCompat)
    implementation(Dependencies.AndroidX.viewModel)

    implementation(Dependencies.Material.materialDesign)
    implementation("androidx.appcompat:appcompat:1.2.0")
    implementation("androidx.constraintlayout:constraintlayout:2.0.4")

    testImplementation(Dependencies.Testing.junit)

    androidTestImplementation(Dependencies.Testing.AndroidXTest.junit)
}
