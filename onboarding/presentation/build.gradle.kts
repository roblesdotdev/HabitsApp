plugins {
    alias(libs.plugins.habits.android.feature.ui)
}

android {
    namespace = "com.roblesdotdev.onboarding.presentation"
}

dependencies {
    // Modules
    implementation(projects.core.presentation.designsystem)
    implementation(projects.core.presentation.ui)
    implementation(projects.core.domain)
    implementation(projects.core.data)
    implementation(projects.onboarding.domain)
}