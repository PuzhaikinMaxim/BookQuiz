package com.mxpj.bookquiz.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface BookDao {

    @Query("SELECT * FROM books")
    fun getBookList(): List<BookDbModel>

    @Insert
    fun addBooks(list: List<BookDbModel>)
}