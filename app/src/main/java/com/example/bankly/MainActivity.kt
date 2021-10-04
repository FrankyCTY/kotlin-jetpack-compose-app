package com.example.bankly

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bankly.presentation.navigation.Screens
import com.example.bankly.presentation.screens.PersonalDetailsScreen.PersonalDetailsScreen
import com.example.bankly.ui.theme.BanklyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BanklyTheme {
                Surface(color = MaterialTheme.colors.background, modifier = Modifier.fillMaxSize()) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screens.PersonalDetailsScreen.route
                    ) {
                        composable(route = Screens.PersonalDetailsScreen.route)
                        {
                            PersonalDetailsScreen()
                        }
                    }
                }
            }
        }
    }
}