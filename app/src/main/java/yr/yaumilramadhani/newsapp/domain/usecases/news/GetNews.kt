package yr.yaumilramadhani.newsapp.domain.usecases.news

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import yr.yaumilramadhani.newsapp.domain.entity.Article
import yr.yaumilramadhani.newsapp.domain.repositories.NewsRepository

class GetNews(
    private val newsRepository: NewsRepository
) {
    operator fun invoke(sources:List<String>):Flow<PagingData<Article>>{
        return newsRepository.getNews(sources)
    }
}