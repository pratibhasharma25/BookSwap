package com.example.bookswap.screens.home.give

import android.R.attr.backdropColor
import android.R.attr.textColor
import android.R.attr.title
import android.annotation.SuppressLint
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.data.UiToolingDataApi
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColor
import androidx.navigation.NavController
import com.example.bookswap.R
import com.example.bookswap.model.Book
import com.example.bookswap.model.getBook
import com.example.bookswap.navigation.AppNavigation
import com.example.bookswap.screens.home.BookViewModel
import com.example.bookswap.ui.theme.BookSwapTheme



// Define a data class to represent the form data

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class, UiToolingDataApi::class)
@Composable

fun GiveScreen(navController: NavController, bookList: List<Book> = getBook()){

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "BookSwap", fontFamily = FontFamily.Cursive, fontSize = 40.sp, modifier = Modifier.padding(start = 20.dp)) },
                navigationIcon = {
                    androidx.compose.material3.Icon(
                        imageVector = Icons.Default.ArrowBack,
                        tint = colorResource(id = R.color.base),
                        contentDescription = "Go Back",
                        modifier = Modifier.clickable {
                            navController.popBackStack()
                        }
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = colorResource(id = R.color.darkBase),
                    titleContentColor = colorResource(id = R.color.base),
                )
            )
        }
    ){
        val books = remember {
            mutableStateListOf<Book>()
        }
        GiveContent(navController = navController,
            books = bookList, onAddBook = {
                books.add(it)
            })
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable


fun GiveContent(navController: NavController,
                books: List<Book>,
                onAddBook: (Book) -> Unit) {
    var giver by remember {
        mutableStateOf("")
    }
    var phone by remember {
        mutableStateOf("")
    }
    var name by remember {
        mutableStateOf("")
    }
    var author by remember {
        mutableStateOf("")
    }
    var price by remember {
        mutableStateOf("")
    }
    var edition by remember {
        mutableStateOf("")
    }
    var description by remember {
        mutableStateOf("")
    }
    var images by remember {
        mutableStateOf("")
    }
    val context = LocalContext.current
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = colorResource(id = R.color.base)
    ) {
        LazyColumn(
            modifier = Modifier.padding(top = 70.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {

                // Composable elements for the form
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    GiveInputText(modifier = Modifier.fillMaxWidth(),
                        text = giver, label = "Your Name", onTextChange = {
                            if (it.all { char -> char.isLetter() || char.isWhitespace() })
                                giver = it
                        })
                    GiveInputText(modifier = Modifier.fillMaxWidth(),
                        text = phone, label = "Your Contact Number", onTextChange = {
                            if (it.all { char -> char.isDigit() || char.isWhitespace() })
                                phone = it
                        })
                    GiveInputText(modifier = Modifier.fillMaxWidth(),
                        text = name, label = "Book Name", onTextChange = {
                            if (it.all { char -> char.isLetterOrDigit() || char.isWhitespace() })
                                name = it
                        })
                    GiveInputText(modifier = Modifier.fillMaxWidth(),
                        text = author, label = "Book Author", onTextChange = {
                            if (it.all { char -> char.isLetter() || char.isWhitespace() })
                                author = it
                        })
                    GiveInputText(modifier = Modifier.fillMaxWidth(),
                        text = price, label = "Book Price", onTextChange = {
                            if (it.all { char -> char.isDigit() || char.isWhitespace() })
                                price = it
                        })
                    GiveInputText(modifier = Modifier.fillMaxWidth(),
                        text = description, label = "Book Description", onTextChange = {
                            if (it.all { char -> char.isLetterOrDigit() || char.isWhitespace() })
                                description = it
                        })
                    GiveInputText(modifier = Modifier.fillMaxWidth(),
                        text = edition, label = "Book Edition", onTextChange = {
                            if (it.all { char -> char.isDigit() || char.isWhitespace() })
                                edition = it
                        })
                    GiveInputText(modifier = Modifier.fillMaxWidth(),
                        text = images, label = "Book Images", onTextChange = {
                            images = it
                        })
                    GiveButton(modifier = Modifier.wrapContentSize(Alignment.Center),
                        text = "Submit",
                        onClick = {
                            Log.d("submit", "GiveContent: submit ")
                            if (giver.isNotEmpty()
                                && phone.isNotEmpty()
                                && name.isNotEmpty()
                                && author.isNotEmpty()
                                && price.isNotEmpty()
                                && edition.isNotEmpty()
                                && images.isNotEmpty()
                                && description.isNotEmpty()
                            ) {
                                onAddBook(
                                    Book(
                                        name = name, author = author, price = price.toDouble(),
                                        edition = edition.toInt(), phone = phone.toLong(),
                                        description = description, giver = giver, images = images
                                    )
                                )
//                        giver = ""
//                        phone = ""
//                        name = ""
//                        author = ""
//                        price = ""
//                        edition = ""
//                        description = ""
//                        images = ""
                                Toast.makeText(context, "Book Added", Toast.LENGTH_SHORT).show()

                            }
//                })

                        }
                    )


                }
            }
        }
    }

}
//@Preview
//@Composable
//fun GivePreview(){
//    BookSwapTheme {
//        GiveContent(navController = navController, books = emptyList(), onAddBook = {}, onRemoveBook = {})
//    }
//}