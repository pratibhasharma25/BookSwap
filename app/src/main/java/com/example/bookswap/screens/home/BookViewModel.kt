package com.example.bookswap.screens.home

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bookswap.model.Book
import com.example.bookswap.repository.BookRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel

class BookViewModel @Inject constructor(private val repository: BookRepository): ViewModel() {
    private val _bookList = MutableStateFlow<List<Book>>(emptyList())
    val bookList = _bookList.asStateFlow()

    init{
        viewModelScope.launch ( Dispatchers.IO ) {
            repository.getAllBooks().distinctUntilChanged()
                .collect { listOfBook ->
                    if (listOfBook.isNullOrEmpty())
                    {
                        Log.d("Empty", ": Empty List")
                    }else{
                        _bookList.value = listOfBook
                    }
                }
        }
    }

    suspend fun addBook(book: Book) = viewModelScope.launch { repository.addBook(book) }
    suspend fun updateBook(book: Book) = viewModelScope.launch { repository.updateBook(book) }
    suspend fun removeBook(book: Book) = viewModelScope.launch { repository.deleteBook(book)}







}