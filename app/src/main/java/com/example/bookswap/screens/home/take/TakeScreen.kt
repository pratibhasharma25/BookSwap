package com.example.bookswap.screens.home.take

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.bookswap.R
import com.example.bookswap.model.Book
import com.example.bookswap.model.getBook
import com.example.bookswap.widgets.BookRow

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TakeScreen(navController: NavController){
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
    ) {
        TakeContent(navController = navController)
    }
}
@Composable
fun TakeContent(navController: NavController, bookList: List<Book> = getBook()) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = colorResource(id = R.color.base)
    ) {
        Column(modifier = Modifier.padding(top = 70.dp)) {

            LazyColumn {
                items(items = bookList) {
                    BookRow(book = it
//                        , onItemClick = {
//                        navController.navigate("${AppScreens.BookDetails.name}/$it")
//                    }
                    )
                }
            }
        }
    }
}

    @Composable
    fun BookImage(modifier: Modifier) {
        Box(
            modifier = modifier
                .padding(16.dp)
                .wrapContentSize(align = Alignment.TopCenter)
                .border(BorderStroke(1.dp, Color.Gray), shape = RoundedCornerShape(5.dp)),
        ) {
            Image(
                painter = painterResource(id = R.drawable.icon3),
                contentDescription = "Profile Picture",
                modifier = modifier
                    .size(150.dp)
                    .clip(RoundedCornerShape(5.dp)), // Adjust the size as needed
                contentScale = ContentScale.Crop
            )
        }
    }


        
        