package yr.yaumilramadhani.newsapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import yr.yaumilramadhani.newsapp.domain.usecases.AppEntryUsecases
import yr.yaumilramadhani.newsapp.presentations.onboarding.OnBoardingScreen
import yr.yaumilramadhani.newsapp.presentations.onboarding.OnBoardingViewModel
import yr.yaumilramadhani.newsapp.ui.theme.NewsAppTheme
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var useCases: AppEntryUsecases
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window,false)
        installSplashScreen()
        lifecycleScope.launch {
            useCases.readAppEntry().collect{
                Log.d("test",it.toString())
            }
        }
        setContent {
            NewsAppTheme {
                val onBoardingViewModel:OnBoardingViewModel = hiltViewModel()
                Box(modifier = Modifier.background(color=MaterialTheme.colorScheme.background)){
                    OnBoardingScreen(
                        event=onBoardingViewModel::onEvent
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NewsAppTheme {

    }
}