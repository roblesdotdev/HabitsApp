plugins {
    alias(libs.plugins.habits.android.library)
    alias(libs.plugins.habits.android.room)
    alias(libs.plugins.habits.android.hilt)
}

android {
    namespace = "com.roblesdotdev.core.database"
}

dependencies {
    // Modules
    implementation(projects.core.domain)
}