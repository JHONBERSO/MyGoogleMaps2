plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.mygooglemaps2"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.mygooglemaps2"
        minSdk = 24
        targetSdk = 34
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
    // Librería de Google Maps: permite integrar y mostrar mapas en la aplicación.
    implementation("com.google.android.gms:play-services-maps:19.0.0")
    // Librería para acceder a los servicios de ubicación de Google: obtiene la posición actual del usuario.
    implementation("com.google.android.gms:play-services-location:20.0.0")
}