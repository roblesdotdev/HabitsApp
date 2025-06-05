plugins {
    alias(libs.plugins.habits.android.feature.ui)
}

android {
    namespace = "com.roblesdotdev.habits.presentation"
}

dependencies {
    implementation(libs.kotlinx.coroutines.core)

    // Modules
    implementation(projects.core.presentation.designsystem)
    implementation(projects.core.presentation.ui)
    implementation(projects.core.domain)
    implementation(projects.habits.domain)
    implementation(projects.habits.data)
}