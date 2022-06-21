package com.example.helloworld.data

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "IQ_table")
data class Question(
    @ColumnInfo(name = "q_text") val question: String,
    @ColumnInfo(name = "answers") val answers: String,
    @ColumnInfo(name = "correct_answer") val correctAnswer: String
    )
{
    @PrimaryKey(autoGenerate = true)
    var id: Int = 1
}


