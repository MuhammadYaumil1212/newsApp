package yr.yaumilramadhani.newsapp.presentations.mainActivity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import dagger.hilt.android.AndroidEntryPoint
import yr.yaumilramadhani.newsapp.presentations.navgraph.NavGraph
import yr.yaumilramadhani.newsapp.ui.theme.NewsAppTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel by viewModels<MainViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window,false)
        installSplashScreen().apply {
            setKeepOnScreenCondition{
                viewModel.splashCondition.value
            }
        }
        setContent {
            NewsAppTheme {
                NavGraph(startDestination = viewModel.startDestination.value)
            }
        }
    }
}