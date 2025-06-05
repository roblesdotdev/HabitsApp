plugins {
    alias(libs.plugins.habits.android.library)
}

android {
    namespace = "com.roblesdotdev.core.data"
}

dependencies {

    // Modules
    implementation(projects.core.domain)
}