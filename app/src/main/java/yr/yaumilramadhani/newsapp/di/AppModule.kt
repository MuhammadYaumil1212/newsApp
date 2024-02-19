package yr.yaumilramadhani.newsapp.di

import android.app.Application
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import yr.yaumilramadhani.newsapp.data.manager.LocalUserManagerImpl
import yr.yaumilramadhani.newsapp.domain.manager.LocalUserManager
import yr.yaumilramadhani.newsapp.domain.usecases.AppEntryUsecases
import yr.yaumilramadhani.newsapp.domain.usecases.ReadAppEntry
import yr.yaumilramadhani.newsapp.domain.usecases.SaveAppEntry
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

}