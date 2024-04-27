package com.minhnguyen.search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

private val mockData = listOf(
    "Ho Chi Minh City",
    "Dong Nai",
    "Ha Noi",
    "Beijing"
)
@Composable
fun SearchRoute(modifier: Modifier = Modifier) {
    Column(modifier) {
        SearchBar(modifier)
        SearchSuggestion(modifier, mockData)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun SearchBar(modifier: Modifier = Modifier) {
    Row {
        TextField(
            value = "",
            onValueChange = {},
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = null
                )
            },
            colors = TextFieldDefaults.textFieldColors(
                placeholderColor = Color(0xff7fb2f5)
            ),
            placeholder = {
                Text(
                    stringResource(R.string.city_search),
                    color = Color.Gray
                )
            },
            modifier = modifier
                .fillMaxWidth()
                .heightIn(min = 56.dp)
                .padding(start = 5.dp, end = 5.dp, top = 5.dp)
        )
    }
}

@Composable
internal fun SearchSuggestion(
    modifier: Modifier = Modifier,
    suggestions: List<String>
) {
    Box (
        modifier = Modifier
    ){
        LazyColumn(
            modifier = modifier
                .padding(5.dp)
                .background(
                    color = MaterialTheme.colorScheme.primaryContainer,
                    shape = RoundedCornerShape(3.dp)
                    )
                .fillMaxWidth()
        ) {
            items(suggestions){ item ->
                Text(
                    text = item,
                    style = MaterialTheme.typography.bodyMedium,
                    fontFamily = FontFamily.Monospace,
                    modifier = modifier.padding(start = 5.dp)
                )
            }
        }
    }

}

@Preview
@Composable
fun PreviewSearchScreen() {
    SearchRoute()
}