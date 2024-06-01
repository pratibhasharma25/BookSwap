package com.example.bookswap.screens.home

import android.annotation.SuppressLint

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.bookswap.R
import com.example.bookswap.navigation.AppNavigation
import com.example.bookswap.navigation.AppScreens
import com.example.bookswap.ui.theme.BookSwapTheme

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "BookSwap", fontFamily = FontFamily.Cursive, fontSize = 40.sp) },

        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = colorResource(id = R.color.darkBase),
            titleContentColor = colorResource(id = R.color.base),
        ))}
    ) {
        MainContent(navController = navController)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainContent(navController: NavController) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = colorResource(id = R.color.base)
    ) {
        Text(text = "You want to...",
            Modifier
                .fillMaxWidth()
                .padding(top = 160.dp),
            style = TextStyle(
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Serif,
                color = colorResource(id = R.color.darkBase)
            ),
            textAlign = TextAlign.Center)
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentSize(align = Alignment.Center)
        ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 30.dp)
                    .wrapContentSize(align = Alignment.Center)
            ) {
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
            Text(text = "Or",
                Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp),
                style = TextStyle(
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Normal,
                    fontFamily = FontFamily.Serif,
                    color = colorResource(id = R.color.darkBase)
                ),
                textAlign = TextAlign.Center)
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 30.dp)
                    .wrapContentSize(align = Alignment.Center)
            ) {
                Card(modifier = Modifier
                    .height(140.dp)
                    .width(200.dp),
                    onClick = {
                        navController.navigate(route = AppScreens.TakeScreen.name)
                    }) {
                    Image(
                        painter = painterResource(id = R.drawable.take1),
                        contentDescription = "take",
                        contentScale = ContentScale.Crop
                    )
                }
            }
        }
    }
}
//@Composable
//fun HomePreview() {
//    BookSwapTheme {
//        AppNavigation(bookViewModel = )
//    }
//}


