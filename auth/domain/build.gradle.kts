plugins {
    alias(libs.plugins.habits.jvm.library)
}

dependencies {
    implementation(projects.core.domain)
}