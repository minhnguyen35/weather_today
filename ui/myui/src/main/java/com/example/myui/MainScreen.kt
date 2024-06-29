package com.example.myui

import android.widget.TextClock
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
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
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
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.models.WeatherForecast
import com.minhnguyen.ui.myui.R

@Composable
internal fun MainScreen(
    modifier: Modifier = Modifier,
    viewModel: ForecastsByCityViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    Box(
        modifier = modifier
            .background(Color.Black)
    ) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(top = 15.dp),
            horizontalAlignment = Alignment.CenterHorizontally) {
            Spacer(Modifier.height(16.dp))
            MainInformation(state=state)
//            ForecastByHoursView(
//                timestamp = state.dayTimestamp,
//                forecast = state.todayForecasts
//            )
            ForecastByDaysView(
                timestamp = state.dayTimestamp,
                forecast = state.todayForecasts
            )
        }
    }

}

@Composable
fun ForecastByDaysView(
    modifier: Modifier = Modifier,
    timestamp: String,
    forecast: List<WeatherForecast> = mockData
) {
    Box (
        modifier = modifier
            .padding(start = 15.dp, end = 15.dp, top = 5.dp, bottom = 20.dp)
            .wrapContentHeight()
            .background(
//                Brush.horizontalGradient(
//                    colorStops = colorStops
//                ),
                color = Color(0xff4a5463),
                shape = RoundedCornerShape(8.dp)
            )
    ) {
        Column(
            modifier = modifier
        ) {
            Text(text = timestamp,
                color = Color.White,
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
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
    Row(modifier = modifier.padding(bottom = 5.dp)){
        Column(modifier = modifier
            .wrapContentHeight()
            .wrapContentWidth(Alignment.Start)
            .weight(0.3f)
        ) {
            Text(
                text = forecast.forecastTime,
                color = Color.White,
                style = MaterialTheme.typography.bodyLarge,
            )

        }

        Image(painter = painterResource(
            id = R.drawable.night_cloudy),
            contentDescription = "Icon for current weather",
            modifier = modifier
                .padding(start = 10.dp)
                .weight(0.2f),
        )
        Text(
            text = "${forecast.feelsLikeTemperature.toInt()} °F",
            color = Color.White,
            style = MaterialTheme.typography.bodyLarge,
            modifier = modifier
                .padding(start = 10.dp)
//                .weight(0.4f)
        )
    }
}

@Composable
fun ForecastByHoursView(
    modifier: Modifier = Modifier,
    timestamp: String,
    forecast: List<WeatherForecast> = mockData) {
    Box (
        modifier = modifier
            .padding(15.dp)
            .wrapContentHeight()
            .background(
                color = Color(0xff4a5463),
                shape = RoundedCornerShape(8.dp)
            )
    ){
        Column(modifier = modifier.wrapContentHeight()){
            Row {
                Text(text = timestamp,
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
            .width(150.dp)
            .height(100.dp)
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
fun MainInformation(modifier: Modifier = Modifier, state: HomeScreenState) {
    Column (
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally){
        Text(text = state.cityName,
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            color = Color.White,)
        ClockView()
        Text(text = state.avgTemperature,
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            color = Color.White,
        )
        Text(
            textAlign = TextAlign.Center,
            text = state.descriptionForecast,
            style = MaterialTheme.typography.bodyLarge,
            color = Color.White,
            modifier = modifier.padding(start=5.dp, end = 5.dp)
            )
//        Row {
//            Text(text = "Max: ${state.maxTemperature}",
//                style = MaterialTheme.typography.headlineSmall,
//                color = Color.White,
//            )
//            Spacer(Modifier.width(30.dp))
//            Text(
//                text = "Min: ${state.minTemperature}",
//                style = MaterialTheme.typography.headlineSmall,
//                color = Color.White
//            )
//        }

    }
}

@Composable
fun ClockView() {
    println("nhbm clockview rendering...")
    AndroidView(factory = {context ->
        TextClock(context).apply {
            // on below line we are setting 12 hour format.
            format12Hour?.let { this.format12Hour = "hh:mm:ss a" }
            // on below line we are setting time zone.
            timeZone?.let { this.timeZone = it }
            // on below line we are setting text size.
            textSize.let { this.textSize = 30f }
            setTextColor(ContextCompat.getColor(context, com.google.android.material.R.color.m3_ref_palette_white))
        }
    })
}

@Preview(showBackground = true, widthDp = 500)
@Composable
fun PreviewMainScreen(){
    MainScreen()
}

@Preview(showBackground = true)
@Composable
fun PreviewCardView() {
    ForecastByDaysView(timestamp = "2024-06-29 00:00:00",forecast = mockData)
}

@Preview(showBackground = true, backgroundColor = 4287925128L)
@Composable
fun TestElement() {
    ForecastDayItem(forecast = WeatherForecast("San francisco","18oC", 300.0, 230.0, 27.0, "2024-06-28 15:00:00", 12345L))
}

