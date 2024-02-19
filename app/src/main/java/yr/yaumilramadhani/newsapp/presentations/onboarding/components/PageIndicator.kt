package yr.yaumilramadhani.newsapp.presentations.onboarding.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import yr.yaumilramadhani.newsapp.presentations.onboarding.Dimens
import yr.yaumilramadhani.newsapp.ui.theme.BlueGray

@Composable
fun PageIndicator(
    pageSize:Int,
    selectedPage:Int,
    selectedColor:Color = MaterialTheme.colorScheme.primary,
    unselectedColor:Color = BlueGray
) {
    Row(modifier=Modifier, horizontalArrangement = Arrangement.SpaceBetween) {
        repeat(times = pageSize) { page ->
            Box(
                modifier = Modifier
                    .padding(start = Dimens.indicatorPadding)
                    .size(Dimens.indicatorSize)
                    .clip(CircleShape)
                    .background(color = if (page == selectedPage) selectedColor else unselectedColor)
            )
        }
    }
}