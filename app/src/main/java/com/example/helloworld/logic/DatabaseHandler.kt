package com.example.helloworld.logic

import android.arch.persistence.room.*
import android.content.Context
import com.example.helloworld.data.Question


@Database(
    entities = [Question::class],
    version = 1
)
abstract class DatabaseHandler : RoomDatabase(){

    abstract fun getQuestionDao(): QuestionDao

    companion object{
        //private const val DB_NAME = "Question-Database.db"

        @Volatile
        private var instance: DatabaseHandler? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK){
            instance ?: buildDatabase(context).also {
                instance = it
            }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            DatabaseHandler::class.java,
            "IQ_table"
        ).build()

    }

}