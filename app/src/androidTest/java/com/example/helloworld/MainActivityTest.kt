package com.example.helloworld

import android.app.Activity
import androidx.test.rule.ActivityTestRule

import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.helloworld.ui.MainActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Rule
    @JvmField
    var activityTestRule = ActivityTestRule(MainActivity::class.java)
    lateinit var activity: Activity

    @Before
    fun setUp() {
        activity = activityTestRule.activity
    }

    @Test
    fun checkActivityVisibility(){

        onView(withId(activity.main.id))
    }

    @Test
    fun checkLoginTextVisibility(){

        onView(withId(R.id.login))
            .check(matches(isDisplayed()))
    }

    @Test
    fun checkUserNameVisibility(){

        onView(withId(R.id.userName))
            .check(matches(isDisplayed()))
    }

    @Test
    fun checkPasswordVisibility(){

        onView(withId(R.id.password))
            .check(matches(isDisplayed()))
    }

    @Test
    fun checkButtonSignInVisibility(){

        onView(withId(R.id.sign_in))
            .check(matches(isDisplayed()))
    }

    @Test
    fun checkTitleLogin(){

        onView(withId(R.id.login))
            .check(matches(isDisplayed()))
        onView(withId(R.id.login))
            .check(matches(withText(R.string.login)))
    }

    @Test
    fun checkLoginClickVisibility(){

        onView(withId(R.id.sign_in))
            .perform(click())
    }

    @After
    fun tearDown() {
    }
}