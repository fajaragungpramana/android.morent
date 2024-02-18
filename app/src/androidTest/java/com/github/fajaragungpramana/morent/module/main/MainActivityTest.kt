package com.github.fajaragungpramana.morent.module.main

import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.By
import androidx.test.uiautomator.UiDevice
import androidx.test.uiautomator.Until
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest {

    private lateinit var uiDevice: UiDevice

    @Before
    fun setUp() {
        uiDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())
        assertNotNull(uiDevice)
    }

    @Test
    fun startMainActivityFromHomeScreen() {
        uiDevice.pressHome()

        val moRent = uiDevice.findObject(By.text("MoRent"))
        val opened = moRent.clickAndWait(Until.newWindow(), 5000)
        assertTrue(opened)
    }

}