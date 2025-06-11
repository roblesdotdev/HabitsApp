plugins {
    alias(libs.plugins.habits.android.library)
    alias(libs.plugins.habits.android.hilt)
}

android {
    namespace = "com.roblesdotdev.auth.data"
}

dependencies {
    implementation(platform(libs.firebase.bom))
    implementation(libs.firebase.auth.ktx)

    // Modules
    implementation(projects.core.domain)
    implementation(projects.core.data)
    implementation(projects.auth.domain)
}