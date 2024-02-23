package yr.yaumilramadhani.newsapp.presentations.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.paging.compose.collectAsLazyPagingItems
import yr.yaumilramadhani.newsapp.presentations.common.ArticlesList
import yr.yaumilramadhani.newsapp.presentations.common.SearchBar
import yr.yaumilramadhani.newsapp.presentations.navgraph.Routes
import yr.yaumilramadhani.newsapp.presentations.onboarding.Dimens

@Composable
fun SearchScreen(
    state:SearchState,
    event: (SearchEvent)->Unit,
    navigate:(String)->Unit
) {
    Column(modifier = Modifier
        .padding(
            top = Dimens.mediumPadding1,
            start = Dimens.mediumPadding2,
            end = Dimens.mediumPadding1
        )
        .statusBarsPadding()
        .fillMaxSize()
    ) {
        SearchBar(
            text = state.searchQuery,
            readOnly = false,
            onValueChange = {event(SearchEvent.UpdateSearchQuery(it))},
            onSearch = {event(SearchEvent.searchNews)}
        )
        Spacer(modifier = Modifier.height(Dimens.mediumPadding1))
        state.articles?.let {
            val articles = it.collectAsLazyPagingItems()
            ArticlesList(articles = articles, onClick = {navigate(Routes.DetailScreen.route)})
        }
    }
}