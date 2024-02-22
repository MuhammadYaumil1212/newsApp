package yr.yaumilramadhani.newsapp.presentations.navgraph

import androidx.navigation.NamedNavArgument

sealed class Routes(
    val route:String,
    val arguments: List<NamedNavArgument> = emptyList()
){
    object OnBoardingScreen:Routes(route = "onBoardingScreen")
    object HomeScreen:Routes(route="homeScreen")
    object SearchScreen:Routes(route="searchScreen")
    object BookmarkScreen:Routes(route="bookmarkScreen")
    object DetailScreen:Routes(route="detailScreen")
    object AppStartNavigation:Routes(route="appStartNavigation")
    object NewsNavigation:Routes(route="newsNavigation")
    object NewsNavigatorScreen:Routes(route="newsNavigator")
}
