package yr.yaumilramadhani.newsapp.presentations.navgraph

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.paging.compose.collectAsLazyPagingItems
import yr.yaumilramadhani.newsapp.presentations.home.HomeScreen
import yr.yaumilramadhani.newsapp.presentations.home.HomeViewModel
import yr.yaumilramadhani.newsapp.presentations.onboarding.OnBoardingScreen
import yr.yaumilramadhani.newsapp.presentations.onboarding.OnBoardingViewModel
import yr.yaumilramadhani.newsapp.presentations.search.SearchScreen
import yr.yaumilramadhani.newsapp.presentations.search.SearchViewModel

@Composable
fun NavGraph(
    startDestination: String
) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = startDestination) {
        navigation(
            route = Routes.AppStartNavigation.route,
            startDestination = Routes.OnBoardingScreen.route
        ) {
            composable(
                route = Routes.OnBoardingScreen.route
            ) {
                val onBoardingViewModel: OnBoardingViewModel = hiltViewModel()
                Box(modifier = Modifier.background(color = MaterialTheme.colorScheme.background)) {
                    OnBoardingScreen(
                        event = onBoardingViewModel::onEvent
                    )
                }
            }
        }
            navigation(
                route = Routes.NewsNavigation.route,
                startDestination = Routes.NewsNavigatorScreen.route
            ) {
                composable(
                    route = Routes.NewsNavigatorScreen.route,
                ) {
                    val viewModel: SearchViewModel = hiltViewModel()
                    SearchScreen(state = viewModel.state.value, event = viewModel::onEvent, navigate = {})
                }
            }
    }
}
