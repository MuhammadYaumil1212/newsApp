package yr.yaumilramadhani.newsapp.presentations.onboarding.components

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import yr.yaumilramadhani.newsapp.R
import yr.yaumilramadhani.newsapp.presentations.onboarding.Dimens
import yr.yaumilramadhani.newsapp.presentations.onboarding.Page
import yr.yaumilramadhani.newsapp.presentations.onboarding.pages
import yr.yaumilramadhani.newsapp.ui.theme.NewsAppTheme

@Composable
fun OnBoardingPage(
    modifier:Modifier = Modifier,
    page:Page
) {
    Column(modifier = modifier) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxSize(fraction = 0.60f),
            painter = painterResource(id = page.image),
            contentScale = ContentScale.Crop,
            contentDescription = null
        )
        Spacer(modifier = Modifier.height(Dimens.mediumPadding1))
        Text(
            text = page.title,
            modifier = Modifier.padding(horizontal = Dimens.mediumPadding2),
            style = MaterialTheme.typography.displaySmall.copy(fontWeight = FontWeight.Bold),
            color = colorResource(id = R.color.display_small)
        )
        Text(
            text = page.description,
            modifier = Modifier.padding(horizontal = Dimens.mediumPadding2),
            style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold),
            color = colorResource(id = R.color.text_medium)
        )
    }
}

@Preview(showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun onBoardingPagePreview() {
    NewsAppTheme {
        OnBoardingPage(page = pages[0])
    }
}