plugins {
    alias(libs.plugins.habits.jvm.library)
}

dependencies {
    // Modules
    implementation(projects.core.domain)
}