package com.example.tugasakhirmobileapp


import android.net.Uri.Builder
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val navController = rememberNavController()
            NavHost(navController = navController,startDestination = "LoginSign", builder = {
                    composable("LoginSign"){
                        LoginSign(navController)}

                    composable("LoginPage"){
                        Loginpage(navController)}

                    composable("Homescreen"){
                        Myapp(navController)}

                    composable("Graph1"){
                        Graph1(navController) }

                    composable("Graph2"){
                        Graph2(navController) }

                    composable("Graph3"){
                        Graph3(navController) }

            })
        }
    }
}






