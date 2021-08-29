package com.example.myfirstcomposeapp.dashboard

import android.content.res.ColorStateList
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.myfirstcomposeapp.dashboard.ui.*
import com.example.myfirstcomposeapp.ui.theme.MyFirstComposeAppTheme

class DashBoardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyFirstComposeAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colors.background,
                    modifier = Modifier.fillMaxSize()
                ) {
                    val navController = rememberNavController()
                    Scaffold(
                        bottomBar = { BottomBarNavigation(navController) }
                    ) {
                        Navigation(navController)

                    }

                }
            }
        }
    }


}
@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController, startDestination = NavigationItems.Home.route) {
        composable(NavigationItems.Home.route) {
            HomeScreen()
        }
        composable(NavigationItems.Music.route) {
            MusicScreen()
        }
        composable(NavigationItems.Movies.route) {
            MoviesScreen()
        }
        composable(NavigationItems.Books.route) {
            BooksScreen()
        }
        composable(NavigationItems.Profile.route) {
            ProfileScreen()
        }
    }
}

@Composable
fun BottomBarNavigation(navController: NavController) {
    val items = listOf(
        NavigationItems.Home,
        NavigationItems.Music,
        NavigationItems.Movies,
        NavigationItems.Books,
        NavigationItems.Profile
    )
    BottomNavigation(
        backgroundColor = Color.LightGray,
        elevation = 1.dp,
        contentColor = Color.Magenta

    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        items.forEach { navigationItems ->
            BottomNavigationItem(
                selected = currentRoute == navigationItems.route,
                icon = {
                    Icon(
                        painterResource(id = navigationItems.Drawable),
                        contentDescription = navigationItems.Title
                    )
                },
                label = { Text(text = navigationItems.Title) },
                selectedContentColor = Color.Red,
                unselectedContentColor = Color.Blue.copy(0.4f),
                alwaysShowLabel = true,

                onClick = {
                    navController.navigate(navigationItems.route) {

                        // Pop up to the start destination of the graph to
                        // avoid building up a large stack of destinations
                        // on the back stack as users select items
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                        }
                        // Avoid multiple copies of the same destination when
                        // reselecting the same item
                        launchSingleTop = true
                        // Restore state when reselecting a previously selected item
                        restoreState = true
                    }
                })

        }
    }
}









@Preview(showBackground = false)
@Composable
fun DefaultPreview2() {
    MyFirstComposeAppTheme {
        //BottomBarNavigation(navController = )
    }
}