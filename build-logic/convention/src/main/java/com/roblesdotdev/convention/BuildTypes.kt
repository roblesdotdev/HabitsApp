package com.roblesdotdev.convention

import com.android.build.api.dsl.ApplicationExtension
import com.android.build.api.dsl.BuildType
import com.android.build.api.dsl.CommonExtension
import com.android.build.api.dsl.LibraryExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

internal fun Project.configureBuildTypes(
    commonExtension: CommonExtension<*, *, *, *, *, *>,
    extensionType: ExtensionType,
) {
    commonExtension.run {
        buildFeatures {
            buildConfig = true
        }
    }

    when (extensionType) {
        ExtensionType.APPLICATION -> {
            extensions.configure<ApplicationExtension> {
                buildTypes {
                    debug {
                        configureDebugBuildType()
                    }
                    release {
                        configureReleaseBuildType(commonExtension = commonExtension)
                    }
                }
            }
        }
        ExtensionType.LIBRARY -> {
            extensions.configure<LibraryExtension> {
                buildTypes {
                    debug {
                        configureDebugBuildType()
                    }
                    release {
                        configureReleaseBuildType(commonExtension = commonExtension)
                    }
                }

            }
        }
    }
}

private fun BuildType.configureDebugBuildType() {
    buildConfigField(type = "String", name = "BASE_URL", value = "\"localhost:3000\"")
}

private fun BuildType.configureReleaseBuildType(
    commonExtension: CommonExtension<*, *, *, *, *, *>,
) {
    buildConfigField(type = "String", name = "BASE_URL", value = "\"localhost:3000\"")

    isMinifyEnabled = true
    proguardFiles(
        commonExtension.getDefaultProguardFile("proguard-android-optimize.txt"),
        "proguard-rules.pro"
    )
}
