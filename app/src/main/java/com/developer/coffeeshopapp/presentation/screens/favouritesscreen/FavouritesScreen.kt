package com.developer.coffeeshopapp.presentation.screens.favouritesscreen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.developer.coffeeshopapp.R
import com.developer.coffeeshopapp.domain.model.Product
import com.developer.coffeeshopapp.presentation.ui_components.MyBottomaNavBar

@Composable
fun FavouritesScreen(navController: NavHostController) {
    var favouritesItems by remember { mutableStateOf(listOf(
        Product(id = 1,name="Espresso", description = "Strong and Rich",320.0,R.drawable.coffee_2),
        Product(id = 2,name="Latte", description = "Smooth and Creamy",150.0,R.drawable.coffee_3),
        Product(id = 3,name="Cappuccino", description = "With Chocolate",200.0,R.drawable.coffee_1),
    )
    )
    }

    Scaffold(
        topBar ={ FavouritesScreenTopBar()},
        bottomBar = { MyBottomaNavBar(navController,"Favorites" ) }

    ) {innerPadding->
        LazyColumn(modifier = Modifier.fillMaxSize()
            .padding(16.dp)
            .padding(innerPadding))
        {
            item {
                favouritesItems.forEach { product->
                    FavouritesItemCard(product,
                        onRemove = {
                            favouritesItems=favouritesItems-product
                        })
                }
            }


        }
    }


}