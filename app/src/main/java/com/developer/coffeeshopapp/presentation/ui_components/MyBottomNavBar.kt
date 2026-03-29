package com.developer.coffeeshopapp.presentation.ui_components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.developer.coffeeshopapp.R
import com.developer.coffeeshopapp.presentation.theme.LightBrown
import com.developer.coffeeshopapp.presentation.theme.LightGray

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MyBottomaNavBar() {
   val navItems=listOf(
       NavItem("Home",R.drawable.regular_outline_home),
       NavItem("Cart",R.drawable.regular_outline_bag),
       NavItem("Favorites",R.drawable.regular_outline_heart),
       NavItem("Profile",R.drawable.outline_account_circle_24)
   )
    NavigationBar(
        contentColor = MaterialTheme.colorScheme.surface,
        modifier = Modifier.height(100.dp)
    ) {
        navItems.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = true,
                onClick = {  },
                icon = { Icon(
                    painter = painterResource(id = item.icon),
                    contentDescription = item.title
                ) },
                label = { Text(item.title) },
                alwaysShowLabel = false,
                modifier = Modifier.size(50.dp),
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = LightBrown,
                    selectedTextColor = LightBrown,
                   unselectedIconColor = Color.DarkGray,
                    unselectedTextColor = Color.DarkGray,
                    indicatorColor = LightGray.copy(alpha = 0.3f),

                )
            )
        }
    }
}

data class NavItem(
    val title: String,
    val icon: Int
)
