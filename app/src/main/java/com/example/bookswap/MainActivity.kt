package com.example.bookswap

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels

import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.bookswap.navigation.AppNavigation
import com.example.bookswap.screens.home.BookViewModel
import com.example.bookswap.ui.theme.BookSwapTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

//            enableEdgeToEdge()
            // Set status bar color

            BookSwapTheme{
                Surface {
                    // A surface container using the 'background' color from the theme
                    AppNavigation()
                }
            }
        }
    }
}

//
//@Composable
//fun GreetingPreview() {
//
//    BookSwapTheme{
//
//        AppNavigation()
//    }
//}