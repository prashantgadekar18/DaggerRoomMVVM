plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    id("kotlin-kapt")
}

android {
    namespace = "com.pg.mvvmwithdagger2example"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.pg.mvvmwithdagger2example"
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
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

//    Retrofit
    implementation (libs.retrofit)
    implementation (libs.converter.gson)

//    Dagger 2
    implementation(libs.dagger) // Replace "x" with the latest version
    kapt(libs.dagger.compiler)

    // Kotlin Coroutines Core
    implementation (libs.kotlinx.coroutines.core)
    // Coroutines support for Android
    implementation (libs.kotlinx.coroutines.android)
//    Lifecycle ViewModel Dependency
    implementation (libs.androidx.lifecycle.viewmodel.ktx)



    // Room components
    implementation (libs.androidx.room.runtime)
    annotationProcessor (libs.room.compiler)

    // Kotlin Extensions and Coroutines support for Room
    implementation (libs.androidx.room.ktx)

    // Use kapt instead of annotationProcessor if using Kotlin
    kapt (libs.room.compiler)

//    RecyclerView dependency
    implementation (libs.androidx.recyclerview)



}