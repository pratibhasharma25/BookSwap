package com.example.bookswap.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.bookswap.model.Book

@Database(entities = [Book::class], version = 1, exportSchema = false)
abstract class BookDatabase(): RoomDatabase() {
    abstract fun bookDao(): BookDatabaseDao

}