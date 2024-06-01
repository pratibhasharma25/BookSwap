package com.example.bookswap.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.bookswap.data.BookDatabase
import com.example.bookswap.data.BookDatabaseDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Singleton
    @Provides
    fun providesBookDao(bookDatabase: BookDatabase):BookDatabaseDao
    = bookDatabase.bookDao()

    @Singleton
    @Provides
    fun providesAppDao(@ApplicationContext context: Context): BookDatabase
    = Room.databaseBuilder(
        context,
        BookDatabase::class.java,
        "book_db")
        .fallbackToDestructiveMigration()
        .build()
}