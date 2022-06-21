package com.example.helloworld

import android.app.Activity
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.example.helloworld.ui.HomeActivity
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class HomeActivityTest {

    @Rule
    @JvmField
    var activityTestRule = ActivityTestRule(HomeActivity::class.java)
    lateinit var activitiy: Activity

    @Before
    fun setUp() {

        activitiy = activityTestRule.activity
    }


    @Test
    fun checkEasyVisibility(){

        onView(withId(R.id.easy))
            .check(matches(isDisplayed()))
    }

    @Test
    fun checkMediumVisibility(){

        onView(withId(R.id.medium))
            .check(matches(isDisplayed()))
    }

    @Test
    fun checkHardVisibility(){

        onView(withId(R.id.hard))
            .check(matches(isDisplayed()))
    }

    @Test
    fun checkEasyClickVisibility(){

        onView(withId(R.id.easy))
            .check(matches(isDisplayed()))
        onView(withId(R.id.easy))
            .perform(click())
    }


    @After
    fun tearDown() {
    }
}