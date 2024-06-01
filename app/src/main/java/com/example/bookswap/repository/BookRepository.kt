package com.example.bookswap.repository

import com.example.bookswap.data.BookDatabase
import com.example.bookswap.data.BookDatabaseDao
import com.example.bookswap.model.Book
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class BookRepository @Inject constructor(private val bookDatabaseDao: BookDatabaseDao) {
    suspend fun addBook(book: Book) = bookDatabaseDao.insert(book)
    suspend fun updateBook(book: Book) = bookDatabaseDao.update(book)
    suspend fun deleteBook(book: Book) = bookDatabaseDao.delete(book)
    suspend fun deleteAllBooks(book: Book) = bookDatabaseDao.deleteAll()
    suspend fun getAllBooks(): Flow<List<Book>> = bookDatabaseDao.getBook().flowOn(Dispatchers.IO)
        .conflate()
}