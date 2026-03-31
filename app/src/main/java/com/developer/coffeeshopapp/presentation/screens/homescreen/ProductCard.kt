package com.developer.coffeeshopapp.presentation.screens.homescreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.developer.coffeeshopapp.R
import com.developer.coffeeshopapp.domain.model.Product
import com.developer.coffeeshopapp.presentation.navigation.Routes
import com.developer.coffeeshopapp.presentation.theme.IvoryWhite
import com.developer.coffeeshopapp.presentation.theme.LightBrown

@Composable
fun ProductCard(product: Product,
                modifier: Modifier,
                navController: NavHostController) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable(onClick = {navController.navigate(Routes.DetailsScreen(product.id))}),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp
        )
    ) {
        Column(
            modifier = Modifier.padding(8.dp))
        {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(160.dp),
                contentAlignment = Alignment.Center,
            )
            {
                Image(
                    painter = painterResource(id = product.imageResource),
                    contentDescription = "Product Image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(RoundedCornerShape(24.dp))
                )

                Box(
                    modifier= Modifier.align(Alignment.TopEnd)
                        .padding(horizontal = 8.dp, vertical = 8.dp)
                        .width(30.dp)
                    .background(color = Color.White.copy(alpha = 0.7f),
                        shape = RoundedCornerShape(16.dp)),
                    contentAlignment = Alignment.Center
                )
                {
                    Icon(painter = painterResource(R.drawable.regular_outline_heart),
                        contentDescription = "Add to Favourites",
                        modifier= Modifier.size(24.dp)
                            .padding(2.dp),
                        tint = LightBrown
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = product.name,
                style = MaterialTheme.typography.titleMedium.copy(
                    color = Color.Black,
                    fontWeight = FontWeight.SemiBold,
                )
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = product.description,
                style = MaterialTheme.typography.bodySmall.copy(
                    color = Color.Gray,
                ),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically) {

                Text(
                    text = "₹${product.price}",
                    style = MaterialTheme.typography.titleMedium.copy(
                        color = LightBrown,
                        fontWeight = FontWeight.Bold,
                        )
                )

                IconButton(
                    onClick = {},
                    modifier = Modifier.background(
                        color = LightBrown,
                        shape = RoundedCornerShape(10.dp)
                    )
                )
                {
                    Icon(imageVector = Icons.Default.Add,
                        contentDescription = "Add",
                        tint = IvoryWhite
                    )
                }

            }
        }
    }
}
