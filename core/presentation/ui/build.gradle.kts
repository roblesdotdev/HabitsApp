plugins {
    alias(libs.plugins.habits.android.library.compose)
}

android {
    namespace = "com.roblesdotdev.core.presentation.ui"
}

dependencies {
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.lifecycle.runtime.compose)
    implementation(libs.androidx.lifecycle.viewmodel.compose)
    implementation(libs.androidx.compose.ui.tooling.preview)
    debugImplementation(libs.androidx.compose.ui.tooling)

    // Modules
    implementation(projects.core.domain)
    implementation(projects.core.presentation.designsystem)
}