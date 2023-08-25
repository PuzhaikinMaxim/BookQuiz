package com.mxpj.bookquiz.data

import com.mxpj.bookquiz.domain.Book
import com.mxpj.bookquiz.domain.BookRepository

class BookRepositoryImpl(
    private val bookDao: BookDao,
    private val bookMapper: BookMapper
    ): BookRepository {

    override suspend fun getAllBooks(): List<Book> {
        return bookMapper.mapBookDbModelListToBookList(bookDao.getAllBooks())
    }
}