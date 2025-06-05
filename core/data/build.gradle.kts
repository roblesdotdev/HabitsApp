plugins {
    alias(libs.plugins.habits.android.library)
    alias(libs.plugins.habits.android.hilt)
}

android {
    namespace = "com.roblesdotdev.core.data"
}

dependencies {

    // Modules
    implementation(projects.core.domain)
}