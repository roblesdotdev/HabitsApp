plugins {
    alias(libs.plugins.habits.android.library)
}

android {
    namespace = "com.roblesdotdev.auth.data"
}

dependencies {

    // Modules
    implementation(projects.core.domain)
    implementation(projects.core.data)
    implementation(projects.auth.domain)
}