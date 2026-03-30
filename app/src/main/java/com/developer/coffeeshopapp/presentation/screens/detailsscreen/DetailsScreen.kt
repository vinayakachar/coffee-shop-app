package com.developer.coffeeshopapp.presentation.screens.detailsscreen

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.developer.coffeeshopapp.R
import com.developer.coffeeshopapp.domain.model.Product

@Composable
fun DetailsScreen() {
    val products=listOf(
        Product(id = 1,name="Espresso", description = "strong and Rich",320.0,R.drawable.coffee_2),
        Product(id = 2,name="Latte", description = "Smooth and Creamy",150.0,R.drawable.coffee_3),
        Product(id = 3,name="Cappuccino", description = "With Chocolate",200.0,R.drawable.coffee_1),
        Product(id = 4,name="Mocha", description = "Bold and Milky",240.0,R.drawable.coffee_4),
        Product(id = 5,name="Macchiato", description = "Velvety Smooth",180.0,R.drawable.coffee_5),
        Product(id = 6,name="Flat White", description = "Refreshing and Rich",120.0,R.drawable.coffee_6),
    )

    val selectedProduct=products.find { it.id==1 }

    Scaffold(
        topBar = { DetailsScreenTopAppBar() }
        , bottomBar = { DetailsScreenBottomAppBar() }
    ) {innerPadding->
        LazyColumn() {
            item {
                DetailsScreenContent(selectedProduct,innerPadding)
            }
        }

    }
}