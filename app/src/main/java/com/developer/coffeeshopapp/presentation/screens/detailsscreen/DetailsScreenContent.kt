package com.developer.coffeeshopapp.presentation.screens.detailsscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.developer.coffeeshopapp.R
import com.developer.coffeeshopapp.domain.model.Product
import com.developer.coffeeshopapp.presentation.theme.IvoryWhite
import com.developer.coffeeshopapp.presentation.theme.LightGray


@Composable
fun DetailsScreenContent(product: Product, innerPadding: PaddingValues) {
    Column(
        modifier = Modifier.fillMaxSize()
            .padding(innerPadding)
            .padding(16.dp)
    ) {
        Image(
            painter = painterResource(product.imageResource),
            contentDescription = product.description,
            modifier = Modifier.fillMaxWidth()
                .height(250.dp)
                .clip(RoundedCornerShape(16.dp)),
            contentScale = ContentScale.Crop)

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = product.name,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black)

        Row() {
            Text(text = "Ice / Hot",
                fontSize =16.sp,
                color = LightGray,
                fontWeight = FontWeight.Medium
            )

            Icon(
                painter = painterResource(product.imageResource),
                contentDescription = "Bean Icon",
                modifier = Modifier.background(
                    color = IvoryWhite,
                    shape = RoundedCornerShape(10.dp)
                )
                    .size(36.dp)
                    .padding(6.dp)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        HorizontalDivider(
            color = Color.LightGray.copy(alpha = 0.5f),
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Description",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black)

        Text(text = product.description,
            fontSize = 16.sp,
            color = LightGray,
            fontWeight = FontWeight.Medium)

        Spacer(modifier = Modifier.height(24.dp))

        Text(text = "Size",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black)

        Spacer(modifier = Modifier.height(12.dp))

        var selectedSizeText by remember { mutableStateOf("M") }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(30.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
           listOf("S","M","L").forEach {size->
               SelectSizeChip(
                    size,
                   selectedSizeText==size,
                   onClick = {selectedSizeText=size},
                   modifier = Modifier.weight(1f)
                       .height(46.dp)
               )
           }
        }
    }
}
