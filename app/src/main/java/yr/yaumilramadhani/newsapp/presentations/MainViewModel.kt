package yr.yaumilramadhani.newsapp.presentations

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import yr.yaumilramadhani.newsapp.domain.usecases.AppEntryUsecases
import yr.yaumilramadhani.newsapp.presentations.navgraph.Routes
import javax.inject.Inject
import kotlin.coroutines.coroutineContext

@HiltViewModel
class MainViewModel @Inject constructor(
    private val appEntryUsecases: AppEntryUsecases
):ViewModel() {
    var splashCondition by mutableStateOf(true)
        private set
    var startDestionation by mutableStateOf(Routes.AppStartNavigation.route)
        private set
    init {
        CoroutineScope(Dispatchers.Main).launch {
            appEntryUsecases.readAppEntry().onEach { shouldStartFromHomeScreen ->
                if(shouldStartFromHomeScreen){
                    startDestionation = Routes.NewsNavigation.route
                }else{
                    startDestionation = Routes.AppStartNavigation.route
                }
                delay(300)
                splashCondition = false
            }
        }

    }
}