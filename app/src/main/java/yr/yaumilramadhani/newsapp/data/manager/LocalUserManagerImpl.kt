package yr.yaumilramadhani.newsapp.data.manager

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import yr.yaumilramadhani.newsapp.domain.manager.LocalUserManager
import yr.yaumilramadhani.newsapp.util.Constants

class LocalUserManagerImpl(
    private val context:Context
):LocalUserManager {
    override suspend fun saveAppEntry() {
        context.dataStore.edit {
            setting->setting[PreferencesKey.APP_ENTRY] = true
        }
    }

    override fun readAppEntry(): Flow<Boolean> {
        return context.dataStore.data.map {
            preferences->preferences[PreferencesKey.APP_ENTRY] ?: false
        }
    }

}

private val Context.dataStore:DataStore<Preferences> by preferencesDataStore(
    name = Constants.USER_SETTING
)

private object PreferencesKey{
    val APP_ENTRY = booleanPreferencesKey(name = Constants.APP_ENTRY)
}