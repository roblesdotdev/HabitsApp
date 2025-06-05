plugins {
    alias(libs.plugins.habits.android.feature.ui)
}

android {
    namespace = "com.roblesdotdev.auth.presentation"
}

dependencies {
    implementation(projects.core.presentation.designsystem)
    implementation(projects.core.presentation.ui)
    implementation(projects.core.domain)
    implementation(projects.auth.domain)
}