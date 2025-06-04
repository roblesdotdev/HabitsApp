plugins {
    `kotlin-dsl`
}

group = "com.roblesdotdev.habits.buildlogic"

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.ksp.gradlePlugin)
    compileOnly(libs.room.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = "habits.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }
        register("androidApplicationCompose") {
            id = "habits.android.application.compose"
            implementationClass = "AndroidApplicationComposeConventionPlugin"
        }
    }
}