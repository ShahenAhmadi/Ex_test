package com.example.helloworld

import android.arch.persistence.room.Room
import android.content.Context
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.helloworld.data.Question
import com.example.helloworld.logic.QuestionDao
import com.example.helloworld.logic.DatabaseHandler

import junit.framework.TestCase

import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class DatabaseHandlerTest : TestCase() {

    private lateinit var db: DatabaseHandler
    private lateinit var dao: QuestionDao


    @Before
    public override fun setUp() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(context, DatabaseHandler::class.java).build()
        dao = db.getQuestionDao()
    }

    @Test
    fun writeAndReadQuestion() {
        val question = Question("Is this a question1?", "Yes, No", "Yes")
        dao.add(question)
        val questions = dao.getAll()
        assertTrue(questions.contains(question))
    }

    @After
    fun closeDb() {
        db.close()
    }
}