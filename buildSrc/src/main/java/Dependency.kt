object Dependency {

    object AndroidX {
        const val APP_COMPAT = "androidx.appcompat:appcompat:1.6.1"
        const val CORE_KTX = "androidx.core:core-ktx:1.12.0"
        const val SPLASH_SCREEN = "androidx.core:core-splashscreen:1.0.1"
        const val ACTIVITY_KTX = "androidx.activity:activity-ktx:1.8.2"
    }

    object Google {
        const val MATERIAL = "com.google.android.material:material:1.11.0"
        const val HILT = "com.google.dagger:hilt-android:${Version.HILT}"
        const val HILT_COMPILER = "com.google.dagger:hilt-compiler:${Version.HILT}"
    }

}