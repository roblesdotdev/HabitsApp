plugins {
    alias(libs.plugins.habits.jvm.library)
}

dependencies {
    implementation(libs.kotlinx.coroutines.core)

    // Modules
    implementation(projects.core.domain)
}