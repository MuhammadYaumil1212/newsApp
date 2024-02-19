package yr.yaumilramadhani.newsapp.presentations.navgraph

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import yr.yaumilramadhani.newsapp.presentations.onboarding.OnBoardingScreen
import yr.yaumilramadhani.newsapp.presentations.onboarding.OnBoardingViewModel

@Composable
fun NavGraph(
    startDestination:String
) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = startDestination){
        navigation(
            route= Routes.AppStartNavigation.route,
            startDestination = Routes.OnBoardingScreen.route
        ){
            composable(
                route=Routes.OnBoardingScreen.route
            ){
                val onBoardingViewModel: OnBoardingViewModel = hiltViewModel()
                Box(modifier = Modifier.background(color= MaterialTheme.colorScheme.background)){
                    OnBoardingScreen(
                        event=onBoardingViewModel::onEvent
                    )
                }
            }
            navigation(
                route = Routes.NewsNavigation.route,
                startDestination = Routes.NewsNavigatorScreen.route
            ){
                composable(route=Routes.NewsNavigatorScreen.route){
                    Text(text = "News navigator screen")
                }
            }
        }
    }
}