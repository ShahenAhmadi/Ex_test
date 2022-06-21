package com.example.helloworld.ui

import android.content.Intent
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.helloworld.R
import com.example.helloworld.data.Question
import com.example.helloworld.logic.DatabaseHandler
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var counterQuestion = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sign_in.setOnClickListener {
            val vUserName = userName.text.toString()
            val vPassword = password.text.toString()

            if (vUserName.isNotEmpty() && vPassword.isNotEmpty()){

                saveQuestion()

                var intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
                finish()
            }

            else {
                userName.hint = "Required"
                password.hint = "Required"
                userName.setTextColor(resources.getColor(R.color.red))
                password.setTextColor(resources.getColor(R.color.red))
            }
        }

    }
    private fun saveQuestion(){
        class SaveQuestion: AsyncTask<Void, Void, Void>(){
            override fun doInBackground(vararg p0: Void?): Void? {
                DatabaseHandler(applicationContext).getQuestionDao().add(questionsForAddToDb(counterQuestion))
                return null
            }

            override fun onPostExecute(result: Void?) {
                super.onPostExecute(result)
                Toast.makeText(applicationContext, "Questions saved", Toast.LENGTH_LONG).show()
            }
        }
        SaveQuestion().execute()
    }

    private fun questionsForAddToDb(id: Int): Question{
        var correct = "No"

        if(id % 3 == 0)
            correct = "Yes"

        var quest = Question("This is a $id th question?", "yes, No", correct)

        counterQuestion ++
        return  quest

    }
}