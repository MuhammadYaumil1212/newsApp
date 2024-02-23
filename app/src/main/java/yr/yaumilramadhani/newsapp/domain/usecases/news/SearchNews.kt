package yr.yaumilramadhani.newsapp.domain.usecases.news

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import yr.yaumilramadhani.newsapp.domain.entity.Article
import yr.yaumilramadhani.newsapp.domain.repositories.NewsRepository

class SearchNews(
    private val newsRepository:NewsRepository
) {
    operator fun invoke(searchQuery:String, sources:List<String>):Flow<PagingData<Article>>{
        return newsRepository.searchNews(searchQuery = searchQuery, sources = sources)
    }
}