// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    val kotlin_version by extra("1.4.21")
    repositories {
        google()
        mavenCentral()
        jcenter()
    }

    dependencies {
        classpath(Dependencies.Gradle.androidGradlePlugin)
        classpath(Dependencies.Gradle.kotlinPlugin)
        classpath(kotlin("gradle-plugin", Versions.kotlin))

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
        jcenter()
    }
}

tasks.register("clean") {
    delete(rootProject.buildDir)
}
