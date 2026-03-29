package com.developer.coffeeshopapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.developer.coffeeshopapp.presentation.screens.detailsscreen.DetailsScreen
import com.developer.coffeeshopapp.presentation.screens.homescreen.HomeScreen
import com.developer.coffeeshopapp.presentation.theme.MyCoffeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyCoffeAppTheme {
                DetailsScreen()
            }
        }
    }
}

