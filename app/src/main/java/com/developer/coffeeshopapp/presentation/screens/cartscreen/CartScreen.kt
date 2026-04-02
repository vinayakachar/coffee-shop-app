package com.developer.coffeeshopapp.presentation.screens.cartscreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.developer.coffeeshopapp.R
import com.developer.coffeeshopapp.domain.model.Product
import com.developer.coffeeshopapp.presentation.theme.CoffeeBrown
import com.developer.coffeeshopapp.presentation.ui_components.MyBottomaNavBar


@Composable
fun CartScreen(navController: NavHostController) {
    val cartProducts=listOf(
        Product(id = 1,name="Espresso", description = "Strong and Rich",320.0,R.drawable.coffee_2),
        Product(id = 2,name="Latte", description = "Smooth and Creamy",150.0,R.drawable.coffee_3),
        Product(id = 3,name="Cappuccino", description = "With Chocolate",200.0,R.drawable.coffee_1),
    )

    var amount by remember { mutableStateOf(120.0) }
    var deliveryFee by remember { mutableStateOf(20.0) }
    var totalamount by remember { mutableStateOf(amount+deliveryFee) }

    Scaffold(
        topBar = { CartScreenTopBar(navController) },
        bottomBar = { MyBottomaNavBar(navController,"Cart") }
    ) {innerPadding->

        LazyColumn(modifier = Modifier.padding(16.dp).padding(innerPadding)) {
            item {
                Row() {
                    Text(text = "Deliver",
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold,
                        color = CoffeeBrown,
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))


                cartProducts.forEach { product->
                    CartItemCard(product = product)
                }

                Spacer(modifier = Modifier.height(16.dp))

                Text(text = "Payment Summary",
                    style = MaterialTheme.typography.titleMedium.copy(
                        color = Color.Black,
                        fontWeight = FontWeight.SemiBold))

                Spacer(modifier = Modifier.height(8.dp))

                Row(modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween) {

                    Text(text="Price", fontSize = 18.sp)

                    Text(text="$amount", fontSize = 18.sp)
                }

                Spacer(modifier = Modifier.height(2.dp))

                Row(modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween) {
                    Text(text = "Delivery Fee", fontSize = 18.sp)
                    Text(text="$deliveryFee", fontSize = 18.sp)
                }

                Spacer(modifier = Modifier.height(16.dp))

            PaymentModeSelectionCard(totalamount)
            }
        }
                
            }
}