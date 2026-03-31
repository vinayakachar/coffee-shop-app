package com.developer.coffeeshopapp.presentation.screens.detailsscreen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.developer.coffeeshopapp.R
import com.developer.coffeeshopapp.domain.model.Product

@Composable
fun DetailsScreen(productId: Int,navController: NavHostController) {
    val products=listOf(
        Product(id = 1,name="Espresso", description = "strong and Rich",320.0,R.drawable.coffee_2),
        Product(id = 2,name="Latte", description = "Smooth and Creamy",150.0,R.drawable.coffee_3),
        Product(id = 3,name="Cappuccino", description = "With Chocolate",200.0,R.drawable.coffee_1),
        Product(id = 4,name="Mocha", description = "Bold and Milky",240.0,R.drawable.coffee_4),
        Product(id = 5,name="Macchiato", description = "Velvety Smooth",180.0,R.drawable.coffee_5),
        Product(id = 6,name="Flat White", description = "Refreshing and Rich",120.0,R.drawable.coffee_6),
    )

    val selectedProduct=products.find { it.id==productId }

    if(selectedProduct==null){
        Text(text="Product not found",color = Color.Red)
        return
    }

    Scaffold(
        topBar = { DetailsScreenTopAppBar(navController) }
        , bottomBar = { DetailsScreenBottomAppBar() }
    ) {innerPadding->
        LazyColumn() {
            item {
                DetailsScreenContent(selectedProduct,innerPadding)
            }
        }

    }
}