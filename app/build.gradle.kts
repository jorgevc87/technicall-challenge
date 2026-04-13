plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.hilt)
    alias(libs.plugins.ksp)
}

android {
    namespace = "com.technical.myapplication"
    compileSdk {
        version = release(36)
    }

    defaultConfig {
        applicationId = "com.technical.myapplication"
        minSdk = 31
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlin {
        compilerOptions {
            jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_17)
        }
    }
    packaging {
        resources {
            // Excluye los archivos de configuración de procesadores duplicados
            excludes += "/META-INF/gradle/incremental.annotation.processors"
            // Opcionalmente, para evitar errores similares con licencias
            excludes += "/META-INF/LICENSE*"
            excludes += "/META-INF/NOTICE*"
            excludes += "/META-INF/DEPENDENCIES"
        }
    }
    sourceSets.configureEach {
        kotlin.srcDir("build/generated/ksp/$name/kotlin")
    }
    buildFeatures {
        compose = true
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.compose.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    debugImplementation(libs.androidx.compose.ui.tooling)
    debugImplementation(libs.androidx.compose.ui.test.manifest)

    implementation(project(":domain"))
    implementation(project(":core"))

    implementation(libs.lifecycle.viewmodel.ktx)
    implementation(libs.hilt.android)
    implementation(libs.hilt.navigation.compose)
    implementation(libs.hilt.compiler)
}