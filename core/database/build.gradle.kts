plugins {
    alias(libs.plugins.habits.android.library)
    alias(libs.plugins.habits.android.room)
}

android {
    namespace = "com.roblesdotdev.core.database"
}

dependencies {
    // Modules
    implementation(projects.core.domain)
}