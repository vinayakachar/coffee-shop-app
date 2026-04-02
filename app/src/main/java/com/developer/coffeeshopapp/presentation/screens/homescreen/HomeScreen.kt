package com.developer.coffeeshopapp.presentation.screens.homescreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.developer.coffeeshopapp.R
import com.developer.coffeeshopapp.presentation.ui_components.MyBottomaNavBar
import com.developer.coffeeshopapp.domain.model.Product

@Composable
fun HomeScreen(navController: NavHostController) {

    val location="PurnaprajnaLayout, Uttarahalli"
    Scaffold(
        bottomBar = {
            MyBottomaNavBar(navController,"Home")
        }
    ) {innerPadding->
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(1f/3f)
                .background(
                    brush = Brush.linearGradient(
                         colors = listOf(
                             Color(0xFF303030),
                             Color(0xFF1F1F1F),
                             Color(0xFF121212)
                         )
                    )
                )
        )
        Column(modifier = Modifier
            .padding(innerPadding)
            .padding(16.dp)) {


            //Displaying Products

            val products=listOf(
                Product(id = 1,name="Espresso", description = "Strong and Rich",320.0,R.drawable.coffee_2),
                Product(id = 2,name="Latte", description = "Smooth and Creamy",150.0,R.drawable.coffee_3),
                Product(id = 3,name="Cappuccino", description = "With Chocolate",200.0,R.drawable.coffee_1),
                Product(id = 4,name="Mocha", description = "Bold and Milky",240.0,R.drawable.coffee_4),
                Product(id = 5,name="Macchiato", description = "Velvety Smooth",180.0,R.drawable.coffee_5),
                Product(id = 6,name="Flat White", description = "Refreshing and Rich",120.0,R.drawable.coffee_6),
                )

            ProductGrid(products = products,navController=navController){
                Text(text = "Location",
                    color = Color.Gray,
                    fontSize = 14.sp
                )

                Spacer(modifier = Modifier.height(4.dp))

                Row(verticalAlignment = Alignment.CenterVertically){
                    Text(text = location,
                        color = Color.White,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 16.sp)
                    Icon(imageVector = Icons.Default.KeyboardArrowDown,
                        contentDescription = "changeLocation",
                        tint = Color.White)
                }
                Spacer(modifier = Modifier.height(30.dp))
                MySearchBar()

                Spacer(modifier = Modifier.height(40.dp))
                Image(painter = painterResource(R.drawable.banner_1),
                    contentDescription = "Home Banner")

                Spacer(modifier = Modifier.height(16.dp))

                HomeScreenCategories()
            }



        }
    }
}