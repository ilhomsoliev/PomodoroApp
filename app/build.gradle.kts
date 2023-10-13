plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")

}

baseConfig()

android {
    defaultConfig {
        vectorDrawables {
            useSupportLibrary = true
        }
    }
    buildTypes {
        getByName("release") {
            signingConfig = signingConfigs.getByName("debug")
        }
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(project(mapOf("path" to ":appthemehelper")))
    implementation("androidx.lifecycle:lifecycle-service:2.6.2")
    androidBase(false)
    xmlNavigation()
    lifecycle()
    material_dialog()
    androidX()

    // EventBus
    eventbus()

    customactivityoncrash()

    implementation("com.google.android.material:material:1.10.0")

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}