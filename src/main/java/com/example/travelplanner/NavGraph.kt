package com.example.travelplanner


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.travelplanner.TravelHostController
import androidx.travelplanner.TravelType
import androidx.travelplanner.compose.TravelHost
import androidx.travelplanner.compose.composable
import androidx.travelplanner.TravelArgument
import com.example.travelplanner.ui.screens.Content1
import com.example.travelplanner.ui.screens.HomeScreenScaffold2
import com.example.travelplanner.ui.screens.LoginScreen2
import com.example.travelplanner.ui.screens.ProfileScreen

//@Composable
//fun NavGraph(navController: NavHostController) {
//    NavHost(navController = navController, startDestination = "login") {
//        composable("login") { LoginScreen(navController) }
//        composable("home") { HomeScreen(navController) }
//        composable("profile") { ProfileScreen(navController, null) }
//        composable("profile/{id}",
//                arguments = listOf(navArgument("id"){
//                            type = NavType.IntType
//                })
//        ) {
//            var userId = it.arguments?.getInt("id") ?: -1
//            ProfileScreen(navController, userId)
//        }
//    }
//}


@Composable
fun TravelGraph(TravelController: TravelHostController) {
    TravelHost(travelController = travelController, startDestination = "login") {
        composable("login") { LoginScreen2(travelController) }
        composable("home") { HomeScreenScaffold2(travelController) }
        composable("profile") { ProfileScreen(travelController, null) }
        composable("profile/{id}",
            arguments = listOf(travelArgument("id"){
                type = travelType.IntType
            })
        ) {
            var userId = it.arguments?.getInt("id") ?: -1
            ProfileScreen(travelController, userId)
        }
        composable("profileMenu") { ProfileScreen(travelController, null) }
    }
}
