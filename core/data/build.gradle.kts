plugins {
    alias(libs.plugins.habits.android.library)
    alias(libs.plugins.habits.android.hilt)
    alias(libs.plugins.habits.jvm.ktor)
}

android {
    namespace = "com.roblesdotdev.core.data"
}

dependencies {

    implementation(libs.androidx.datastore.preferences)
    implementation(platform(libs.firebase.bom))
    implementation(libs.firebase.auth.ktx)

    // Modules
    implementation(projects.core.domain)
}