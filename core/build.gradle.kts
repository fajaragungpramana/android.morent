plugins {
    id(Plugin.LIBRARY)
    id(Plugin.KOTLIN)
    id(Plugin.KOTLIN_KAPT)
    id(Plugin.HILT)
}

android {
    namespace = "com.github.fajaragungpramana.morent.core"
    compileSdk = Version.TARGET_SDK

    defaultConfig {
        minSdk = Version.MIN_SDK

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = true
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
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(Dependency.AndroidX.RECYCLER_VIEW)

    implementation(Dependency.Google.HILT)
    kapt(Dependency.Google.HILT_COMPILER)

}

kapt {
    correctErrorTypes = true
}