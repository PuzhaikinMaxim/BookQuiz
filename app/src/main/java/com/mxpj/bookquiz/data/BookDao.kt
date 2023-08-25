package com.mxpj.bookquiz.data

import androidx.room.Dao
import androidx.room.Query

@Dao
interface BookDao {

    @Query("SELECT * FROM books")
    fun getAllBooks(): List<BookDbModel>
}