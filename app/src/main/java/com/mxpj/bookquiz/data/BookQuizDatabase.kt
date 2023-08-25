package com.mxpj.bookquiz.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [BookDbModel::class], version = 1, exportSchema = false)
abstract class BookQuizDatabase: RoomDatabase() {

    abstract fun bookDao(): BookDao

    companion object {
        @Volatile
        private var INSTANCE: BookQuizDatabase? = null

        fun getDatabase(context: Context): BookQuizDatabase {
            val tempDatabase = INSTANCE
            if(tempDatabase != null){
                return tempDatabase
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    BookQuizDatabase::class.java,
                    "book_quiz_database.db"
                ).createFromAsset("database/book_quiz_database.db").build()
                INSTANCE = instance
                return instance
            }
        }
    }
}