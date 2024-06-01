package com.example.bookswap.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity(tableName = "book_tbl")
data class Book(
    @PrimaryKey
    val id: UUID = UUID.randomUUID(),
    @ColumnInfo(name = "book_name")
    val name: String,
    @ColumnInfo(name = "book_author")
    val author: String,
    @ColumnInfo(name = "book_price")
    val price: Double,
    @ColumnInfo(name = "book_edition")
    val edition: Int,
    @ColumnInfo(name = "book_phone")
    val phone: Long,
    @ColumnInfo(name = "book_description")
    val description: String,
    @ColumnInfo(name = "book_images")
    val images: String,
    @ColumnInfo(name = "book_giver")
    val giver: String
)
fun getBook(): List<Book>{
    return listOf(
        Book(
            name = "Mental Maths",
            author = "RS Aggarwal",
            price = 300.0,
            edition = 2019,
            phone = 9453856296,
            description = "nice condition",
            images = "https://ia800208.us.archive.org/BookReader/BookReaderImages.php?zip=/7/items/SecretsOfMentalMath/Secrets%20of%20Mental%20Math_jp2.zip&file=Secrets%20of%20Mental%20Math_jp2/Secrets%20of%20Mental%20Math_0000.jp2&id=SecretsOfMentalMath&scale=4&rotate=0",
            giver = "Harry Styles"
        ),
        Book(
            name = "Science",
            author = "Pratibha Sharma",
            price = 600.0,
            edition = 2024,
            phone = 9529563267,
            description = "nice condition",
            images = "https://rukminim2.flixcart.com/image/850/1000/l0jwbrk0/book/w/o/b/the-science-book-original-imagcb8wrfy9emhq.jpeg?q=20&crop=false",
            giver = "Harry Styles"
        ),
        Book(
            name = "Physics",
            author = "Taylor Swift",
            price = 550.0,
            edition = 2013,
            phone = 9364537537,
            description = "nice condition",
            images = "https://rukminim2.flixcart.com/image/850/1000/xif0q/book/q/o/1/the-easiest-quantum-physics-book-ever-original-imagzr4ezhzxzkfy.jpeg?q=20&crop=false",
            giver = "Harry Styles"
        ),
        Book(
            name = "Biology",
            author = "Radhika Shindey",
            price = 390.0,
            edition = 2011,
            phone = 8465294638,
            description = "nice condition",
            images = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTtE0otf1YtXLsefJ9z-ek2i_ubtTvBRKu87TldZPWeeQ&s",
            giver = "Harry Styles"
        ),
        Book(
            name = "Chemistry",
            author = "Kapil Sharma",
            price = 750.0,
            edition = 2020,
            phone = 8462749836,
            description = "nice condition",
            images = "https://m.media-amazon.com/images/I/51jrR4YIOgL._AC_UF1000,1000_QL80_.jpg",
            giver = "Harry Styles"
        ),
        Book(
            name = "Geography",
            author = "Virat Kohli",
            price = 450.0,
            edition = 2019,
            phone = 6936281648,
            description = "nice condition",
            images = "https://m.media-amazon.com/images/I/91cQZnfKPVL._AC_UF1000,1000_QL80_.jpg",
            giver = "Harry Styles"
        ),
        Book(
            name = "Zoology",
            author = "Ananya Pandey",
            price = 800.0,
            edition = 2021,
            phone = 9362945392,
            description = "nice condition",
            images = "https://m.media-amazon.com/images/I/81RhbmlWB5L._AC_UF1000,1000_QL80_.jpg",
            giver = "Harry Styles"
        ),
        Book(
            name = "History",
            author = "Aditya Roy Kapoor",
            price = 400.0,
            edition = 2018,
            phone = 6203759270,
            description = "nice condition",
            images = "https://m.media-amazon.com/images/I/51NAVbHmeSL._AC_UF1000,1000_QL80_.jpg",
            giver = "Harry Styles"
        ),
        Book(
            name = "Astrology",
            author = "Harry Styles",
            price = 750.0,
            edition = 2024,
            phone = 8372940264,
            description = "nice condition",
            images = "https://s2.r29static.com/bin/shop/963/x,80/2162128/image.jpg",
            giver = "Harry Styles"
        )
    )




}
