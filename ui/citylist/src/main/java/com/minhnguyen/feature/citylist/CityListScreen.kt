package com.minhnguyen.feature.citylist

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.models.UICity

private val listColors = arrayOf(
        0.0f to Color(0xfff5f8fa),
        1f to Color(0xff95d6fc)
)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun CityListRoute(
    modifier: Modifier = Modifier,
    favoritesCity: List<UICity> = mockData
//    viewModel: CityListViewModel = hiltViewModel()
){
//    val feedState by viewModel.state.collectAsState()
    Box(
        modifier = Modifier.background(Color.Black)
    ) {
        Column(modifier) {
            Row(modifier.padding(top = 10.dp, start = 5.dp, end = 5.dp)) {
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
                )
            }
            LazyColumn(modifier = modifier
                .weight(1f)
                .padding(top = 10.dp)){
                items(favoritesCity) {item ->
                    CityCardView(city = item)
                }
            }
        }

    }
}

@Composable
fun CityCardView(
    modifier: Modifier = Modifier,
    city: UICity
) {
    Box (
        modifier = Modifier
            .padding(start = 10.dp, end = 10.dp, bottom = 5.dp)
            .background(
                Brush.horizontalGradient(
                    colorStops = listColors
                ),
                shape = RoundedCornerShape(5.dp)
            )
    ){
        Row(
            modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            Column(modifier = modifier
                .padding(start = 5.dp)
                .weight(1f)) {
                Text(
                    text = city.name,
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold
                )
                Text(text = "21:19")
                Text(
                    text = city.weatherDescription,
                    modifier = modifier.padding(top = 10.dp),
                )
            }
            Column(modifier = modifier
                .weight(1f)
                .padding(end = 10.dp),
                horizontalAlignment = Alignment.End) {
                Text(text = "${city.averageTemperature}°C",
                    textAlign = TextAlign.End,
                    style = MaterialTheme.typography.headlineLarge,
                    )
                Row (modifier = modifier
                                .padding(top = 20.dp)
                                .fillMaxWidth(0.7f),
                    horizontalArrangement = Arrangement.End
                ){
                    Text(
                        text = "H: ${city.maxTemperature}°C",
                        modifier = modifier.padding(end = 5.dp)
                    )
                    Text(text = "M: ${city.minTemperature}°C")
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewScreen() {
    CityListRoute(favoritesCity =mockData)
}

@Preview
@Composable
fun PreviewCityCard() {
    CityCardView(
        city = UICity("1", "Los Angeles",
            "Cloudy",
            "30",
            "27",
            "35",
            R.drawable.city_cloudy)
    )
}