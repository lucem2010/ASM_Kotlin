package com.example.lucdtph31250_asm1

import Profile
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.lucdtph31250_asm1.ui.theme.Lucdtph31250_asm1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lucdtph31250_asm1Theme {
                // A surface container using the 'background' color from the theme
                MyApp()
            }

        }


    }

    @Composable
    fun MyApp() {

        val navController = rememberNavController()

        var isLoggedIn by remember { mutableStateOf(false) }

        Scaffold(

            bottomBar = {

                    if (isLoggedIn) {
                        BottomNavigationBar(navController)

                }


            }
        ) { innerPadding ->
            Box(modifier = Modifier.padding(innerPadding)) {
                NavHost(navController = navController, startDestination = "home") {
                    composable("welcome") { Welcome(navController) }
                    composable("login") {
                        Login(navController){
                            isLoggedIn = true

                            navController.navigate("home") {
                                popUpTo(navController.graph.startDestinationId) {
                                    saveState = true
                                }
                                launchSingleTop = true
                            }
                        }
                    } // Truyền callback vào Login
                    composable("sign_up") { Sign_up(navController) }
                    composable("home") { Home(navController) }
                    composable("favorite") { Favorite(navController) }
                    composable("notification") { Notification(navController) }
                    composable("profile") { Profile(navController) }
                    composable("Detail") { Detail(navController) }
                }
            }
        }
    }


    @Composable
    fun BottomNavigationBar(navController: NavHostController) {
        val items = listOf(
            NavigationItem.Home,
            NavigationItem.Favorite,
            NavigationItem.Notification,
            NavigationItem.Profile
        )
        NavigationBar {
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry?.destination?.route
            items.forEach { item ->
                NavigationBarItem(
                    icon = { Icon(imageVector = item.icon, contentDescription = item.title) },
                    label = { Text(item.title) },
                    selected = currentRoute == item.route,
                    onClick = {
                        navController.navigate(item.route) {
                            popUpTo(navController.graph.startDestinationId) { saveState = true }
                            restoreState = true
                            launchSingleTop = true
                        }
                    }
                )
            }
        }
    }


    sealed class NavigationItem(var route: String, var icon: ImageVector, var title: String) {
        object Home : NavigationItem("home", Icons.Default.Home, "Home")
        object Favorite : NavigationItem("favorite", Icons.Default.Favorite, "Favorite")
        object Notification :
            NavigationItem("notification", Icons.Default.Notifications, "Notification")

        object Profile : NavigationItem("profile", Icons.Default.Person, "Profile")

    }

    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        Lucdtph31250_asm1Theme {
            MyApp()
        }
    }
}