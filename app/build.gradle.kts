plugins {
    id("com.android.application")
    kotlin("android")
    id("kotlin-android")
}

android {
    compileSdkVersion(Versions.androidCompileSdk)
    buildToolsVersion = Versions.buildTools

    defaultConfig {
        applicationId = "com.zegnus.mybirthdays"
        minSdkVersion(Versions.androidMinSdk)
        targetSdkVersion(Versions.androidTargetSdk)
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
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
    implementation(project(":screens:birthday-list:birthday-list-ui"))

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
