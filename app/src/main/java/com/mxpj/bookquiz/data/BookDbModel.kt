package com.mxpj.bookquiz.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "books")
data class BookDbModel(
    @PrimaryKey val bookName: String,
    val text: String,
    val imageResource: Int
)