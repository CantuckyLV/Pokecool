package com.example.pokecool

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.filters.SmallTest
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.rule.ActivityTestRule
import com.example.pokecool.View.MainActivity
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.AdditionalMatchers.not

@RunWith(AndroidJUnit4ClassRunner::class)
@SmallTest
class MainActivityTest {
    @get:Rule
    var activityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun testIsListContainerShowing() {
        Espresso.onView(ViewMatchers.withId(R.id.fl_fragment_ph)).check(
            ViewAssertions.matches(
                ViewMatchers.isDisplayed()))
    }

    @Test
    fun testIsListLoaded() {
        //TODO Implement Idling Resource
        Thread.sleep(10000)
        Espresso.onView(withId(R.id.rv_pokes)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, ViewActions.click()))
        Thread.sleep(2000)
        Espresso.onView(ViewMatchers.withId(R.id.tv_pokemon_dexNum)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
}