import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.dependencies

class DataPlugin: Plugin<Project> {
    override fun apply(target: Project) {
        target.pluginManager.apply("io.realm.kotlin")
    }
}