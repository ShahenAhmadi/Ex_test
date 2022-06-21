package com.example.helloworld

import android.app.Activity
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.example.helloworld.ui.GameActivity
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class GameActivityTest {

    @Rule
    @JvmField
    var activityTestRule = ActivityTestRule(GameActivity::class.java)
    lateinit var activity: Activity

    @Before
    fun setUp() {
        activity = activityTestRule.activity
    }

    @Test
    fun checkQuestionVisibility(){
        onView(withId(R.id.game_question))
            .check(matches(isDisplayed()))
    }

    @Test
    fun checkAnswerVisibility(){
        onView(withId(R.id.game_answers))
            .check(matches(isDisplayed()))
    }

    @After
    fun tearDown() {
    }
}