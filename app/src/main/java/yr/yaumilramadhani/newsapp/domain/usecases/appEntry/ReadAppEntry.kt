package yr.yaumilramadhani.newsapp.domain.usecases.appEntry

import kotlinx.coroutines.flow.Flow
import yr.yaumilramadhani.newsapp.domain.manager.LocalUserManager

class ReadAppEntry(
    private val localUserManager: LocalUserManager
) {
    operator fun invoke():Flow<Boolean>{
        return localUserManager.readAppEntry()
    }
}