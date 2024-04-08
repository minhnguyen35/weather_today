package com.minhnguyen.feature.settings

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SettingsScreen(
    modifier: Modifier = Modifier
){
    Text(
        text = "This is settings screen",
        style = MaterialTheme.typography.headlineLarge,
        modifier = modifier.padding(10.dp)
    )
}