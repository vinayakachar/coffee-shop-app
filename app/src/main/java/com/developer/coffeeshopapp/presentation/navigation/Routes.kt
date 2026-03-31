package com.developer.coffeeshopapp.presentation.navigation

import kotlinx.serialization.Serializable

sealed class Routes {

    @Serializable
    object WelcomeScreen : Routes()

    @Serializable
    object HomeScreen : Routes()

    @Serializable
    data class DetailsScreen(val productId: Int) : Routes()

}
