plugins {
    alias(libs.plugins.habits.android.application.compose)
    alias(libs.plugins.habits.android.hilt)
    alias(libs.plugins.kotlin.serialization)
}

android {
    namespace = "com.roblesdotdev.habitsapp"

    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
}

dependencies {
    // Core
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)

    // Compose
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.lifecycle.viewmodel.compose)
    implementation(libs.androidx.lifecycle.runtime.compose)

    // Navigation
    implementation(libs.androidx.compose.navigation)

    // Splash Screen
    implementation(libs.androidx.core.splashscreen)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    debugImplementation(libs.androidx.compose.ui.tooling)
    debugImplementation(libs.androidx.compose.ui.test.manifest)

    // Modules
    implementation(projects.core.domain)
    implementation(projects.core.data)
    implementation(projects.core.presentation.ui)
    implementation(projects.core.presentation.designsystem)
    implementation(projects.onboarding.domain)
    implementation(projects.onboarding.presentation)
    implementation(projects.auth.domain)
    implementation(projects.auth.data)
    implementation(projects.auth.presentation)
    implementation(projects.habits.domain)
    implementation(projects.habits.data)
    implementation(projects.habits.presentation)
}