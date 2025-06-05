import com.roblesdotdev.convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class AndroidFeatureUIConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        target.run {
            pluginManager.run {
                apply("habits.android.library.compose")
            }

            dependencies {
                "implementation"(libs.findBundle("compose").get())
                "debugImplementation"(libs.findBundle("compose.debug").get())
                "androidTestImplementation"(
                    libs.findLibrary("androidx.compose.ui.test.junit4").get()
                )
            }
        }
    }
}