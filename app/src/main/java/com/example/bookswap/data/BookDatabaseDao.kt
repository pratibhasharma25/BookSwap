package com.example.bookswap.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.bookswap.model.Book
import java.util.concurrent.Flow

@Dao
interface BookDatabaseDao {
@Query("SELECT * FROM book_tbl")
suspend fun getBook():
        kotlinx.coroutines.flow.Flow<List<Book>>

@Query("SELECT * from book_tbl where id=:id")
suspend fun getBookById(id: String): Book

@Insert(onConflict = OnConflictStrategy.REPLACE)
suspend fun insert(book:Book)

@Update(onConflict = OnConflictStrategy.REPLACE)
suspend fun update(book: Book)

@Query("DELETE from book_tbl")
suspend fun deleteAll()

@Delete
suspend fun delete(book: Book)

}
