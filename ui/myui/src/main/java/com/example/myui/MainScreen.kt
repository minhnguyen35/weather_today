package com.example.myui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.models.WeatherForecast
import com.minhnguyen.ui.myui.R

@Composable
internal fun MainScreen(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .background(
                Brush.verticalGradient(
                    colorStops = colorStopsMain)
            )
    ) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(top = 15.dp),
            horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(id = R.drawable.cloudy),
                contentDescription = stringResource(R.string.cloudy_weather)
            )
            Spacer(Modifier.height(16.dp))
            MainInformation()
            ForecastByHoursView()
            ForecastByDaysView()
        }
    }

}

@Composable
fun ForecastByDaysView(
    modifier: Modifier = Modifier,
    forecast: List<WeatherForecast> = mockData
) {
    Box (
        modifier = modifier
            .padding(start = 15.dp, end = 15.dp, top = 5.dp)
            .wrapContentHeight()
            .background(
                Brush.horizontalGradient(
                    colorStops = colorStops
                )
            )
    ) {
        Column(
            modifier = modifier
        ) {
            Text(text = stringResource(id = R.string.five_day_forecast_section),
                color = Color.White,
                style = MaterialTheme.typography.bodyLarge,
                modifier = modifier.padding(start = 10.dp, top = 5.dp)
            )
            Divider(
                modifier = modifier.padding(start =10.dp, end = 10.dp, top = 5.dp),
                thickness = 1.dp, color = Color(0xFF696665))
            LazyColumn(modifier = modifier.padding(10.dp)) {
                items(forecast) { item ->
                    ForecastDayItem(forecast = item)
                }
            }
        }
    }

}

@Composable
fun ForecastDayItem(
    modifier: Modifier = Modifier,
    forecast: WeatherForecast
) {
    Row(modifier = modifier){
        Text(
            text = "Today",
            color = Color.White,
            style = MaterialTheme.typography.bodyLarge,
            modifier = modifier.weight(0.5f)
        )
        Image(painter = painterResource(
            id = R.drawable.night_cloudy),
            contentDescription = "Icon for current weather",
            modifier = modifier.padding(start = 10.dp).weight(0.5f),
        )
        Text(
            text = "${forecast.minTemperature}°C",
            color = Color.White,
            style = MaterialTheme.typography.bodyLarge,
            modifier = modifier.padding(start = 10.dp).weight(0.3f)
        )
        Text(
            text = "${forecast.maxTemperature}°C",
            color = Color.White,
            style = MaterialTheme.typography.bodyLarge,
            modifier = modifier.padding(start = 10.dp).weight(0.3f),
        )
    }
}

@Composable
fun ForecastByHoursView(
    modifier: Modifier = Modifier,
    forecast: List<WeatherForecast> = mockData) {
    Box (
        modifier = modifier
            .padding(15.dp)
            .wrapContentHeight()
            .background(
                Brush.horizontalGradient(
                    colorStops = colorStops
                )
            )
    ){
        Column(modifier = modifier.wrapContentHeight()){
            Row {
                Text(text = "April, 01",
                    color = Color.White,
                    modifier = modifier.padding(start = 10.dp, top = 3.dp)
                    )
                Spacer(modifier = modifier.width(200.dp))

            }
            Divider(
                modifier = modifier.padding(10.dp),
                thickness = 1.dp, color = Color.White)
            LazyRow (modifier){
                items(forecast) {item ->
                    ForecastHourItem(forecast = item)
                }
            }
        }

    }
}

@Composable
fun ForecastHourItem(modifier: Modifier = Modifier,
                     forecast: WeatherForecast) {
    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .width(100.dp)
            .padding(5.dp)
    ){
        Text(
            text = forecast.description,
            color = Color.White,
            style = MaterialTheme.typography.bodyLarge
        )
        Spacer(modifier = modifier.height(5.dp))
        Image(painter = painterResource(id = R.drawable.weather_ic),
            contentDescription = "something")
        Spacer(modifier = modifier.height(5.dp))
        Text(text = forecast.forecastTime,
             color = Color.White,
             style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Composable
fun MainInformation(modifier: Modifier = Modifier) {
    Column (
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally){
        Text(text = "Ho Chi Minh City",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            color = Color.White,)
        Text(text = "19°C",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            )
        Text(
            textAlign = TextAlign.Center,
            text = "Description Description Description Description Description",
            style = MaterialTheme.typography.headlineSmall,
            color = Color.White,
            modifier = modifier.padding(start=5.dp, end = 5.dp)
            )
        Spacer(Modifier.height(10.dp))
        Row {
            Text(text = "Max: 23",
                style = MaterialTheme.typography.headlineSmall,
                color = Color.White,
            )
            Spacer(Modifier.width(30.dp))
            Text(
                text = "Min: 17",
                style = MaterialTheme.typography.headlineSmall,
                color = Color.White
            )
        }
    }
}

@Preview(showBackground = true, widthDp = 500)
@Composable
fun PreviewMainScreen(){
    MainScreen()
}

@Preview(showBackground = true)
@Composable
fun PreviewCardView() {
    ForecastByHoursView(forecast = mockData)
}

@Preview(showBackground = true, backgroundColor = 4287925128L)
@Composable
fun TestElement() {
    ForecastDayItem(forecast = WeatherForecast(1,"San francisco","18oC", 30.0, 23.0, 27.0, "112233"))
}

