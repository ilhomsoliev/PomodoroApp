
repositories {
    mavenCentral()
    google()
}

plugins {
    `kotlin-dsl`
    `kotlin-dsl-precompiled-script-plugins`
}

@Suppress("GradleDependency")
dependencies {
    implementation("com.android.tools.build:gradle:8.1.1")
    implementation("com.android.tools.build:gradle-api:7.4.2")

    val kotlinVer = "1.9.0"
    implementation("org.jetbrains.kotlin:kotlin-android-extensions:$kotlinVer")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin-api:$kotlinVer")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVer")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVer")
}