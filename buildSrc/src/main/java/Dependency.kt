object Dependency {

    object AndroidX {
        const val APP_COMPAT = "androidx.appcompat:appcompat:1.6.1"
        const val CORE_KTX = "androidx.core:core-ktx:1.12.0"
        const val SPLASH_SCREEN = "androidx.core:core-splashscreen:1.0.1"
        const val ACTIVITY_KTX = "androidx.activity:activity-ktx:1.8.2"
        const val RECYCLER_VIEW = "androidx.recyclerview:recyclerview:1.3.2"

        const val UI_AUTOMATOR = "androidx.test.uiautomator:uiautomator:2.3.0-rc01"
        const val ESPRESSO_CORE = "androidx.test.espresso:espresso-core:3.5.1"
        const val ESPRESSO_CONTRIB = "androidx.test.espresso:espresso-contrib:3.5.1"
        const val TEST_CORE_KTX = "androidx.test:core-ktx:1.5.0"
        const val RUNNER = "androidx.test:runner:1.5.2"
        const val RULES = "androidx.test:rules:1.5.0"

        const val CORE_TESTING = "androidx.arch.core:core-testing:2.2.0"
    }

    object Common {
        const val COIL = "io.coil-kt:coil:2.5.0"
    }

    object Google {
        const val MATERIAL = "com.google.android.material:material:1.11.0"
        const val HILT = "com.google.dagger:hilt-android:${Version.HILT}"
        const val HILT_COMPILER = "com.google.dagger:hilt-compiler:${Version.HILT}"
    }

    object JetBrains {
        const val COROUTINE_TEST = "org.jetbrains.kotlinx:kotlinx-coroutines-test:1.8.0"
    }

    object Mockito {
        const val MOCKITO_CORE = "org.mockito:mockito-core:5.10.0"
        const val MOCKITO_INLINE = "org.mockito:mockito-inline:5.2.0"
    }

}