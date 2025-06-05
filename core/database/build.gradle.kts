plugins {
    alias(libs.plugins.habits.android.library)
}

android {
    namespace = "com.roblesdotdev.core.database"
}

dependencies {
    // Modules
    implementation(projects.core.domain)
}