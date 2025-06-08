plugins {
    alias(libs.plugins.habits.android.library)
    alias(libs.plugins.habits.android.hilt)
}

android {
    namespace = "com.roblesdotdev.core.data"
}

dependencies {

    implementation(libs.androidx.datastore.preferences)

    // Modules
    implementation(projects.core.domain)
}