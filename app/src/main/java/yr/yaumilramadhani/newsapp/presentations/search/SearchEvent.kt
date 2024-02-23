package yr.yaumilramadhani.newsapp.presentations.search

sealed class SearchEvent {
    data class UpdateSearchQuery(val searchQuery:String):SearchEvent()
    object searchNews : SearchEvent()
}