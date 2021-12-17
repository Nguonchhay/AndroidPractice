package com.nguonchhay.attractioncompose.ui.activities

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.nguonchhay.attractioncompose.R
import com.nguonchhay.attractioncompose.ui.fragments.AttractionFragment
import com.nguonchhay.attractioncompose.ui.fragments.HomeFragment
import com.nguonchhay.attractioncompose.ui.fragments.SettingFragment
import com.nguonchhay.attractioncompose.ui.theme.AttractionComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AttractionComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    MainScreen()
                }
            }
        }
    }
}

sealed class BottomNavItems(
    val title: String, val icon: Int, val route: String
) {
    object Home : BottomNavItems("Home", R.drawable.icon_home, "fragment_home")
    object Attraction : BottomNavItems("Attraction", R.drawable.icon_attraction, "fragment_attraction")
    object Setting : BottomNavItems("Setting", R.drawable.icon_setting, "fragment_setting")
}

val navItems = listOf(
    BottomNavItems.Home,
    BottomNavItems.Attraction,
    BottomNavItems.Setting
)

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = MaterialTheme.colors.background,
                elevation = 0.dp,
                content = { Text("Attraction App") }
            )
        },
        bottomBar = { BottomNavBar(navController = navController)},
        content = {
            NavigationHost(navController)
        }
    )
}

@Composable
fun NavigationHost(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = BottomNavItems.Home.route,
        modifier = Modifier.padding(all = 15.dp),
        builder = {
            composable(BottomNavItems.Home.route) {
                HomeFragment()
            }
            composable(BottomNavItems.Attraction.route) {
                AttractionFragment()
            }
            composable(BottomNavItems.Setting.route) {
                SettingFragment()
            }
        }
    )
}

@Composable
fun BottomNavBar(
    navController: NavController,
    items: List<BottomNavItems> = navItems
) {
    BottomNavigation {
        val navBackStackEntry = navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry.value?.destination?.route

        items.forEach { navItem ->
            BottomNavigationItem(
                label = { Text(navItem.title) },
                alwaysShowLabel = true,
                selected = currentRoute == navItem.route,
                icon = {
                  Icon(
                      painterResource(id = navItem.icon),
                      contentDescription = navItem.title
                  )
                },
                onClick = {
                    navController.navigate(navItem.route)
                    Log.d("MainActivity", "Nav: ${navItem.route}")
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AttractionComposeTheme {
        MainScreen()
    }
}