package com.example.bankly.presentation.navigation

sealed class Screens(val route: String) {
    object PersonalDetailsScreen: Screens("personal_details_screen")
}