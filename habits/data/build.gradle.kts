plugins {
    alias(libs.plugins.habits.android.library)
    alias(libs.plugins.habits.android.hilt)
}

android {
    namespace = "com.roblesdotdev.habits.data"
}

dependencies {
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinx.serialization.json)

    // Modules
    implementation(projects.core.domain)
    implementation(projects.core.database)
    implementation(projects.habits.domain)
}