package com.mxpj.bookquiz.data

import com.mxpj.bookquiz.domain.Book

class BookMapper {

    fun mapBookDbModelListToBookList(list: List<BookDbModel>): List<Book> {
        return list.map { mapBookDbModelToBook(it) }
    }

    fun mapBookDbModelToBook(bookDbModel: BookDbModel): Book {
        return Book(
            bookDbModel.bookName,
            bookDbModel.text,
            bookDbModel.imageResource
        )
    }
}