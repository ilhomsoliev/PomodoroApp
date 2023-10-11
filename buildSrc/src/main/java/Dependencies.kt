import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.DependencyHandlerScope

val navigationVer = "2.5.3"
fun DependencyHandlerScope.androidBase() {
    implementation(
        "androidx.lifecycle:lifecycle-runtime-ktx:2.5.1",
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4",
        "androidx.core:core-ktx:1.9.0",
        platform("org.jetbrains.kotlin:kotlin-bom:1.9.0"),
    )
    koin()
    /*paging()
    yandexmap()*/
}

private fun DependencyHandlerScope.yandexmap() = implementation(
    "com.yandex.android:maps.mobile:4.3.1-full"
)

private const val composeVer = Config.composeUiVer


fun DependencyHandlerScope.compose() = implementation(
    platform("androidx.compose:compose-bom:2023.06.01"),
    "androidx.compose.ui:ui",
    "androidx.compose.ui:ui-graphics",
    "androidx.compose.ui:ui-tooling-preview",
    "androidx.compose.material3:material3",
    "androidx.activity:activity-compose:1.5.1",
    "androidx.compose.material:material-icons-extended",
    "io.coil-kt:coil-compose:2.3.0",
    "androidx.activity:activity-compose:1.6.0",
    /*"com.google.accompanist:accompanist-navigation-material:0.30.0",*/
    "androidx.compose.material3:material3-window-size-class",
    "androidx.compose.material3:material3:1.2.0-alpha03"
    /*
    "androidx.compose.material3:material3:$materialVer",
    "androidx.compose.material3:material3-window-size-class:$materialVer",
    "androidx.navigation:navigation-compose:2.5.2",
    "com.google.accompanist:accompanist-navigation-material:0.30.0",
    "androidx.activity:activity-compose:1.6.0",
    "androidx.compose.ui:ui:$composeVer",
    "io.coil-kt:coil-compose:2.3.0",
    "androidx.compose.material:material-icons-extended:${composeVer}",*/
) and implementation(
    "androidx.compose.ui:ui-test-manifest:$composeVer",
    "androidx.compose.ui:ui-tooling-preview:$composeVer",
    "androidx.compose.ui:ui-tooling:$composeVer",
) and accompanist(
) and accompanistPermissions(
) and // firebase()and
        swipeRefresher(
        ) and lottie()

val pagingVer = "3.1.1"

fun DependencyHandlerScope.imageCropper() = implementation(
    "com.github.SmartToolFactory:Compose-Colorful-Sliders:1.1.0",
    "com.github.SmartToolFactory:Compose-Color-Picker-Bundle:1.0.1",
    "com.github.SmartToolFactory:Compose-Extended-Gestures:2.1.0",
    "com.github.SmartToolFactory:Compose-AnimatedList:0.5.1",
)

fun DependencyHandlerScope.compressor() = implementation(
    "id.zelory:compressor:3.0.1"
)

fun DependencyHandlerScope.lottie() = implementation(
    "com.airbnb.android:lottie-compose:5.2.0"
)

fun DependencyHandlerScope.okio() = implementation(
    "com.squareup.okio:okio:3.0.0"
)

fun DependencyHandlerScope.paging() = implementation(
    "androidx.paging:paging-compose:1.0.0-alpha17"
)

fun DependencyHandlerScope.swipeRefresher() = implementation(
    "com.google.accompanist:accompanist-swiperefresh:0.24.13-rc"
)

fun DependencyHandlerScope.firebase() = implementation(
    "com.google.firebase:firebase-messaging:23.1.1",
    "com.google.firebase:firebase-analytics:21.2.0",
    //"com.google.firebase:firebase-bom:31.2.0",
    "com.google.firebase:firebase-storage-ktx",
)

fun DependencyHandlerScope.accompanist() = implementation(
    "com.google.accompanist:accompanist-systemuicontroller:0.26.5-rc",
    "com.google.accompanist:accompanist-pager:0.28.0",
    "com.google.accompanist:accompanist-pager-indicators:0.28.0"
)

const val accompanistPermissionsVer = "0.20.3"
fun DependencyHandlerScope.accompanistPermissions() = implementation(
    "com.google.accompanist:accompanist-permissions:$accompanistPermissionsVer"
)

const val koinVer = "3.2.1"
fun DependencyHandlerScope.koin() = implementation(
    "io.insert-koin:koin-androidx-compose:$koinVer",
    "io.insert-koin:koin-android:$koinVer",
    "io.insert-koin:koin-core:$koinVer",
)

fun DependencyHandlerScope.dataBase() =
    retrofit() and dataStore() //and room()

fun DependencyHandlerScope.realm() = implementation(
    "io.realm.kotlin:library-base:1.5.0"
)


val jacksonVer = "2.14.0"
fun DependencyHandlerScope.jackson() = implementation(
    "com.fasterxml.jackson.dataformat:jackson-dataformat-cbor:$jacksonVer",
    "com.fasterxml.jackson.module:jackson-module-kotlin:$jacksonVer"
)

val retrofitVer = "2.9.0"

fun DependencyHandlerScope.retrofit() = implementation(
    "com.squareup.retrofit2:retrofit:$retrofitVer",
    "com.squareup.retrofit2:converter-scalars:2.1.0",
    "com.squareup.retrofit2:converter-gson:$retrofitVer",
    "com.squareup.okhttp3:okhttp:5.0.0-alpha.2",
    "com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.2",
)

const val room = "2.4.3"

fun DependencyHandlerScope.room() = implementation(
    "androidx.room:room-runtime:$room",
    //"androidx.room:room-compiler:$room",
    "androidx.room:room-ktx:$room",
    "androidx.room:room-paging:$room",
)

val dataStoreVer = "1.0.0"

fun DependencyHandlerScope.dataStore() = implementation(
    "androidx.datastore:datastore-preferences:${dataStoreVer}"
)


val ktorVer = "2.2.1"
fun DependencyHandlerScope.ktor() = implementation(
    "io.ktor:ktor-client-content-negotiation:$ktorVer",
    "io.ktor:ktor-serialization-jackson:$ktorVer",
    "org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.2",
    "io.ktor:ktor-serialization-kotlinx-json:$ktorVer",
    "io.ktor:ktor-client-websockets:$ktorVer",
    "io.ktor:ktor-client-logging:$ktorVer",
    "io.ktor:ktor-client-okhttp:$ktorVer",
    "io.ktor:ktor-client-auth:$ktorVer",
    "io.ktor:ktor-client-core:$ktorVer",
)

@Suppress("UNUSED_PARAMETER")
private infix fun Unit.and(o: Unit) {
}

private fun DependencyHandler.implementationIf(condition: Boolean, dependencyNotation: Any) {
    if (condition) implementation(dependencyNotation)
}

private fun DependencyHandler.implementation(vararg dependencyNotations: Any) =
    dependencyNotations.forEach { add("implementation", it) }

private fun DependencyHandler.debugImplementation(vararg dependencyNotations: Any) =
    dependencyNotations.forEach { add("debugImplementation", it) }