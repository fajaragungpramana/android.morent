package com.github.fajaragungpramana.morent.module.main

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.filters.LargeTest
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.UiDevice
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import com.github.fajaragungpramana.morent.R
import com.github.fajaragungpramana.morent.module.adapter.HouseAdapter

@RunWith(AndroidJUnit4ClassRunner::class)
@LargeTest
class MainActivityTest {

    private lateinit var uiDevice: UiDevice

    @Before
    fun setUp() {
        uiDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())

        ActivityScenario.launch(MainActivity::class.java)
    }

    @Test
    fun checkUsernameAndScrollHouse() {
        Espresso.onIdle()

        Espresso.onView(ViewMatchers.withId(R.id.mtv_user_name))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
            .check(ViewAssertions.matches(ViewMatchers.withText("Fajar Agung Pramana")))

        Espresso.onView(ViewMatchers.withId(R.id.rv_house))
            .perform(RecyclerViewActions.scrollToPosition<HouseAdapter.ViewHolder>(9))
    }

    @Test
    fun navigateToAboutUser() {
        Espresso.onView(ViewMatchers.withId(R.id.ll_about_user))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
            .perform(ViewActions.click())

        Thread.sleep(3000)

        uiDevice.setOrientationLandscape()

        Thread.sleep(3000)

        uiDevice.setOrientationPortrait()

        Espresso.pressBack()
    }

    @Test
    fun navigateToDetail() {
        Espresso.onView(ViewMatchers.withId(R.id.rv_house))
            .perform(RecyclerViewActions.actionOnItemAtPosition<HouseAdapter.ViewHolder>(9, ViewActions.click()))

        Thread.sleep(3000)

        uiDevice.setOrientationLandscape()

        Thread.sleep(3000)

        uiDevice.setOrientationPortrait()

        Espresso.pressBack()
    }

}