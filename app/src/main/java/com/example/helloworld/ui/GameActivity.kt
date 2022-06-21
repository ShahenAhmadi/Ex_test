package com.example.helloworld.ui

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.helloworld.data.Question
import com.example.helloworld.databinding.ActivityGameBinding
import com.example.helloworld.logic.DatabaseHandler

class GameActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGameBinding
    private lateinit var listOfQuestions: ArrayList<Question>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityGameBinding.inflate(layoutInflater)

        fetchQuestion()

        binding.gameQuestion.text = listOfQuestions[0].question
        binding.gameAnswers.text = listOfQuestions[0].answers

        setContentView(binding.root)
    }

    private fun fetchQuestion(){
        class FetchQuestion: AsyncTask<Void, Void, Void>(){
            override fun doInBackground(vararg p0: Void?): Void? {
                val questions = DatabaseHandler(applicationContext).getQuestionDao().getAll()
                listOfQuestions = questions as ArrayList<Question>
                return null
            }

            override fun onPostExecute(result: Void?) {
                super.onPostExecute(result)
                Toast.makeText(applicationContext, "Questions Fetched", Toast.LENGTH_LONG).show()
            }
        }
        FetchQuestion().execute()
    }
}