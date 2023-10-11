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
    androidBase(false)
    xmlNavigation()
    lifecycle()
    material_dialog()
    androidX()

    customactivityoncrash()

    // implementation("androidx.core:core-ktx:1.9.0")
    // implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    // implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}