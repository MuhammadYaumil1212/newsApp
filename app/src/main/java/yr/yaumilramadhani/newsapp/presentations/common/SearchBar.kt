package yr.yaumilramadhani.newsapp.presentations.common

import android.content.res.Configuration
import androidx.annotation.ColorRes
import androidx.compose.foundation.border
import androidx.compose.foundation.indication
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TextFieldDefaults.indicatorLine
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import yr.yaumilramadhani.newsapp.R
import yr.yaumilramadhani.newsapp.presentations.onboarding.Dimens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(
    modifier:Modifier = Modifier,
    text:String,
    readOnly:Boolean,
    onClick:(()->Unit)? =null,
    onValueChange:(String)->Unit,
    onSearch:()->Unit
) {
    val interactionSource = remember {
        MutableInteractionSource()
    }
    val isClicked = interactionSource.collectIsPressedAsState().value
    LaunchedEffect(key1 = isClicked){
        if(isClicked){
            onClick?.invoke()
        }
    }

    Box(modifier = modifier){
        val containerColor = colorResource(id = R.color.input_background)
        val colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = Color.Gray
        )
        TextField(
            modifier=Modifier
                .fillMaxWidth()
                .searchBarBorder(),
            value = text,
            onValueChange = onValueChange,
            readOnly=readOnly,
            leadingIcon = {
                Icon(
                    modifier=Modifier.size(Dimens.IconSize),
                    painter = painterResource(id = R.drawable.ic_search),
                    contentDescription = "ic-search",
                    tint = colorResource(id = R.color.body)
                )
            },
            placeholder = {
                Text(text = "Search", style = MaterialTheme.typography.bodySmall, color = colorResource(
                    id = R.color.placeholder
                ))
            },
            shape = MaterialTheme.shapes.medium,
            colors = TextFieldDefaults.colors(
                focusedTextColor = if(isSystemInDarkTheme())Color.White else Color.Black,
                focusedContainerColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                disabledContainerColor = Color.Transparent,
                cursorColor = if(isSystemInDarkTheme())Color.White else Color.Black,
                disabledIndicatorColor = Color.Transparent,
            ),
            singleLine = true,
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
            keyboardActions = KeyboardActions(onSearch={
                onSearch()
            }),
            textStyle = MaterialTheme.typography.bodySmall,
            interactionSource = interactionSource
        )
    }
}

fun Modifier.searchBarBorder() = composed {
    if(!isSystemInDarkTheme()){
        border(
            width = 1.dp,
            color = Color.Black,
            shape = MaterialTheme.shapes.medium,
        )
    }else{
        this
    }
}

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun SearchBarPreview() {
    SearchBar(text = "search", readOnly = false, onValueChange = {}) {

    }
}