package com.developer.coffeeshopapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.developer.coffeeshopapp.presentation.navigation.NavGraph
import com.developer.coffeeshopapp.presentation.screens.cartscreen.CartScreen
import com.developer.coffeeshopapp.presentation.theme.MyCoffeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyCoffeAppTheme {
                NavGraph()
            }
        }
    }
}

