package com.example.helloworld.logic

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.example.helloworld.data.Question

@Dao
interface QuestionDao {

    @Insert
    fun add(question: Question)

    @Query("SELECT * FROM IQ_table")
    fun getAll(): List<Question>
}