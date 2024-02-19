package yr.yaumilramadhani.newsapp.domain.usecases

import yr.yaumilramadhani.newsapp.domain.manager.LocalUserManager

class SaveAppEntry(
    private val localUserManager: LocalUserManager
) {
    suspend operator fun invoke(){
        localUserManager.saveAppEntry()
    }
}