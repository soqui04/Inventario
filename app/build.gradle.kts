plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
<<<<<<< HEAD
=======
    alias(libs.plugins.google.gms.google.services)
>>>>>>> 264c246 (database first changes)
}

android {
    namespace = "mx.edu.itson.inventario"
    compileSdk = 35

    defaultConfig {
        applicationId = "mx.edu.itson.inventario"
        minSdk = 24
        targetSdk = 35
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
<<<<<<< HEAD
=======
    implementation(libs.firebase.firestore)
>>>>>>> 264c246 (database first changes)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    // MPAndroidChart
    implementation("com.github.PhilJay:MPAndroidChart:v3.1.0")
}
