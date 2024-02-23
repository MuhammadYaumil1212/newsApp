package yr.yaumilramadhani.newsapp.presentations.search

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import yr.yaumilramadhani.newsapp.domain.entity.Article

data class SearchState (
    val searchQuery:String = "",
    val articles:Flow<PagingData<Article>>?=null
)