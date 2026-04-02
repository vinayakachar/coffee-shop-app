package com.developer.coffeeshopapp.presentation.screens.welcomescreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.developer.coffeeshopapp.R
import com.developer.coffeeshopapp.presentation.navigation.Routes
import com.developer.coffeeshopapp.presentation.theme.LightBrown

@Composable
fun WelcomeScreen(navController: NavHostController) {
    Box(modifier = Modifier.fillMaxSize().background(color = Color.Black)){

       Image(painter = painterResource(R.drawable.image_splash),
           contentDescription = "Welcome Image")

        Column(modifier = Modifier.fillMaxSize().padding(vertical = 70.dp, horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom) {

            Text(text = "Fall in Love with Coffee in Blissful Delight",
                fontSize = 28.sp,
                lineHeight = 38.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                textAlign = TextAlign.Center,
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(text = "Welcome to our cozy coffee corner, where every cup is a delight for you",
                fontSize = 15.sp,
                color = Color.LightGray,
                textAlign = TextAlign.Center)

            Spacer(modifier = Modifier.height(50.dp))

            Button(onClick = {navController.navigate(Routes.HomeScreen)}, modifier = Modifier.fillMaxWidth()
                .height(50.dp)
                , shape = RoundedCornerShape(8.dp)
                , colors = ButtonDefaults.buttonColors(
                    containerColor = LightBrown,
                    contentColor = Color.White
                )
            ) {
                Text(text = "Get Started",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    )
            }

        }
    }
}
