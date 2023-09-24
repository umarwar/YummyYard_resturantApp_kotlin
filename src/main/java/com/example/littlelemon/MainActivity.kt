package com.example.littlelemon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }
}


@Composable
fun MyApp() {
    val navController = rememberNavController()
    Box(Modifier.fillMaxSize()) {
        NavHost(navController = navController, startDestination = LoginScreen.route) {
            composable(LoginScreen.route) {
                LoginScreen(navController = navController)
            }
            composable(Home.route) {
                HomeScreen(navController = navController)
            }
            composable(Menu.route) {
                MenuScreen(navController = navController)
            }
            composable(Location.route) {
                LocationScreen(navController = navController)
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewApp() {
    MyApp()
}