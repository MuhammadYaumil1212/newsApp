package yr.yaumilramadhani.newsapp.data.repositories

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import yr.yaumilramadhani.newsapp.data.remote.NewsPagingSource
import yr.yaumilramadhani.newsapp.data.remote.api.NewsApi
import yr.yaumilramadhani.newsapp.domain.entity.Article
import yr.yaumilramadhani.newsapp.domain.repositories.NewsRepository

class NewsRepositoryImpl(
    private val newsApi: NewsApi
): NewsRepository {
    override fun getNews(sources: List<String>): Flow<PagingData<Article>> {
        return Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = {
                NewsPagingSource(
                    newsApi = newsApi,
                    sources = sources.joinToString(separator = ",")
                )
            }
        ).flow
    }
}