package yr.yaumilramadhani.newsapp.data.remote.dto

import yr.yaumilramadhani.newsapp.domain.entity.Article

data class NewsResponse(
    val articles: List<Article>,
    val status: String?, // ok
    val totalResults: Int? // 13558
)