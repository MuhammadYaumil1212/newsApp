package yr.yaumilramadhani.newsapp.di

import android.app.Application
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import yr.yaumilramadhani.newsapp.data.manager.LocalUserManagerImpl
import yr.yaumilramadhani.newsapp.data.remote.api.NewsApi
import yr.yaumilramadhani.newsapp.data.repositories.NewsRepositoryImpl
import yr.yaumilramadhani.newsapp.domain.manager.LocalUserManager
import yr.yaumilramadhani.newsapp.domain.repositories.NewsRepository
import yr.yaumilramadhani.newsapp.domain.usecases.appEntry.AppEntryUsecases
import yr.yaumilramadhani.newsapp.domain.usecases.appEntry.ReadAppEntry
import yr.yaumilramadhani.newsapp.domain.usecases.appEntry.SaveAppEntry
import yr.yaumilramadhani.newsapp.domain.usecases.news.GetNews
import yr.yaumilramadhani.newsapp.domain.usecases.news.NewsUseCase
import yr.yaumilramadhani.newsapp.domain.usecases.news.SearchNews
import yr.yaumilramadhani.newsapp.util.Constants
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideLocaluserManager(
        application:Application
    ):LocalUserManager = LocalUserManagerImpl(context = application)

    @Provides
    @Singleton
    fun provideAppEntryUsecases(
        localUserManager: LocalUserManager
    ) = AppEntryUsecases(
        readAppEntry = ReadAppEntry(localUserManager),
        saveAppEntry = SaveAppEntry(localUserManager)
    )

    @Provides
    @Singleton
    fun provideNewsApi(): NewsApi{
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideNewsRepository(
        newsApi: NewsApi,
    ) : NewsRepository = NewsRepositoryImpl(newsApi)

    @Provides
    @Singleton
    fun provideNewsUseCase(
        newsRepository: NewsRepository
    ): NewsUseCase{
        return  NewsUseCase(
            getNews = GetNews(newsRepository),
            searchNews = SearchNews(newsRepository)
        )
    }

}