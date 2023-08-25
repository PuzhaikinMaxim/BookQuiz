package com.mxpj.bookquiz.domain

class GetBookListUseCase(private val bookRepository: BookRepository) {

    suspend operator fun invoke(): List<Book> {
        return bookRepository.getBookList()
    }
}