package yr.yaumilramadhani.newsapp.presentations.mainActivity

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import androidx.compose.runtime.State
import yr.yaumilramadhani.newsapp.domain.usecases.appEntry.AppEntryUsecases
import yr.yaumilramadhani.newsapp.presentations.navgraph.Routes
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    appEntryUsecases: AppEntryUsecases
):ViewModel() {
    private val _splashCondition = mutableStateOf(true)
    val splashCondition: State<Boolean> = _splashCondition

    private val _startDestination = mutableStateOf(Routes.AppStartNavigation.route)
    val startDestination: State<String> = _startDestination
    init {
        appEntryUsecases.readAppEntry().onEach { shouldStartFromHomeScreen ->
            if(shouldStartFromHomeScreen){
                _startDestination.value = Routes.NewsNavigation.route
            }else{
                _startDestination.value = Routes.AppStartNavigation.route
            }
            delay(200) //Without this delay, the onBoarding screen will show for a momentum.
            _splashCondition.value = false
        }.launchIn(viewModelScope)
    }
}