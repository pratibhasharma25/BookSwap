package com.example.bookswap.screens.home.give

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.bookswap.R
import com.example.bookswap.model.getBook
import com.example.bookswap.navigation.AppNavigation
import com.example.bookswap.navigation.AppScreens
import com.example.bookswap.ui.theme.BookSwapTheme
import java.util.UUID

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookDetails(navController: NavController, name: String){

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

        BookContent(navController = navController, name)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookContent(navController: NavController, name: String, ) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = colorResource(id = R.color.base)
    ) {
       Text(text = "giveeeee", modifier = Modifier.padding(100.dp))
        Card(modifier = Modifier
            .height(140.dp)
            .width(200.dp),
            onClick = {
                navController.navigate(route = AppScreens.GiveScreen.name)
            }) {
            Image(
                painter = painterResource(id = R.drawable.give1),
                contentDescription = "give",
                contentScale = ContentScale.Crop
            )
        }
    }
}


//@Preview
//@Composable
//fun BookDetailPreview(){
//    BookSwapTheme {
//        AppNavigation(bookViewModel)
//    }
//}