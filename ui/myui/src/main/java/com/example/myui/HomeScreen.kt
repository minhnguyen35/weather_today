package com.example.myui

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun Greeting(name: String,
             viewModel: ForecastsByCityViewModel = hiltViewModel(),
             modifier: Modifier = Modifier
) {
    val state by viewModel.state.collectAsState()
    Text(
        text = "Hello $state! $name",
        modifier = modifier
    )
    Button(
        onClick = {viewModel.getForecasts()}
    ) {
        Text(text = "get fore cast")
    }
}