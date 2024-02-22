package yr.yaumilramadhani.newsapp.domain.repositories

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import yr.yaumilramadhani.newsapp.domain.entity.Article

interface NewsRepository {

    fun getNews(sources:List<String>):Flow<PagingData<Article>>
}