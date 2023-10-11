import com.android.build.gradle.BaseExtension
import com.android.build.gradle.LibraryExtension
import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import com.android.build.gradle.internal.dsl.DynamicFeatureExtension
import org.gradle.api.Project
import org.gradle.api.plugins.ExtensionAware
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.findByType
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions

fun Project.baseConfig(name: String = project.name) =
    android (
        app = { baseAppModuleConfig() },
        library = { libraryConfig() },
        feature = { featureConfig() },
        common = { baseConfig(name, this@baseConfig) }
    )

fun Project.compose(enable: Boolean = true) = android {
    buildFeatures.compose = enable
    composeOptions {
        kotlinCompilerExtensionVersion = Config.composeCompilerVer
    }
}

private fun Project.android(
    app: BaseAppModuleExtension.() -> Unit = {},
    library: LibraryExtension.() -> Unit = {},
    feature: DynamicFeatureExtension.() -> Unit = {},
    common: BaseExtension.() -> Unit = {},
) = (this as ExtensionAware).extensions.run {

    findByType<BaseAppModuleExtension>()?.apply {
        app()
        common()
        return@run
    }

    findByType<LibraryExtension>()?.apply {
        library()
        common()
        return@run
    }

    findByType<DynamicFeatureExtension>()?.apply {
        feature()
        common()
        return@run
    }
}


fun BaseAppModuleExtension.baseAppModuleConfig() {

    compileSdk = Config.compileSdk

    defaultConfig {
        applicationId = Config.applicationId
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            signingConfig = signingConfigs.create("empty")
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
}

fun LibraryExtension.libraryConfig() {

    compileSdk = Config.compileSdk
}

fun DynamicFeatureExtension.featureConfig() {

}

fun BaseExtension.baseConfig(name: String, project: Project) {

    namespace = if(name == "app") Config.applicationId
    else if(project.rootProject.equals(project.parent))
        "${Config.namespacePrefix}.$name"
    else "${Config.namespacePrefix}.${project.parent!!.name}.$name"

    defaultConfig {
        minSdk = Config.minSdk
        targetSdk = Config.targetSdk
        versionCode = Config.versionCode
        versionName = Config.versionName
    }

    compileOptions {
        sourceCompatibility = Config.sourceCompatibility
        targetCompatibility = Config.targetCompatibility
    }
    (this as ExtensionAware).configure<KotlinJvmOptions> {
        jvmTarget = Config.jvmTarget
    }
}