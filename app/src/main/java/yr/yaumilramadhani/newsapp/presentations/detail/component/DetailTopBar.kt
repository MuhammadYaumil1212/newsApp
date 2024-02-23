package yr.yaumilramadhani.newsapp.presentations.detail.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import yr.yaumilramadhani.newsapp.R
import yr.yaumilramadhani.newsapp.ui.theme.NewsAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailTopBar(
    onBrowsingClick:()->Unit,
    onShareClick:()->Unit,
    onBookmark:()->Unit,
    onBackClick:()->Unit
) {
    TopAppBar(
        title = {},
        modifier=Modifier.fillMaxWidth(),
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = Color.Transparent,
            actionIconContentColor = colorResource(id = R.color.body),
            navigationIconContentColor = colorResource(id = R.color.body)
        ),
        navigationIcon = {
            IconButton(onClick = onBackClick) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_back_arrow),
                    contentDescription = "Icon AppBar"
                )
            }
        },
        actions = {
            IconButton(onClick = onBrowsingClick) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_bookmark),
                    contentDescription = "Icon Bookmark"
                )
            }
            IconButton(onClick = onShareClick) {
                Icon(
                    imageVector= Icons.Default.Share,
                    contentDescription = "Icon search"
                )
            }
            IconButton(onClick = onBrowsingClick) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_network),
                    contentDescription = "Icon network"
                )
            }
        }

    )

}

@Preview(showBackground = true)
@Composable
fun DetailTopBarPreview() {
    NewsAppTheme {
        DetailTopBar(
            onBrowsingClick = { /*TODO*/ },
            onShareClick = { /*TODO*/ },
            onBookmark = { /*TODO*/ }) {
        }
    }
}