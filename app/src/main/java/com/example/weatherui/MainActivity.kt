package com.example.weatherui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.weatherui.ui.theme.WeatherUiTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherUiTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BoxInfo()
                }
            }
        }
    }
    @Composable
    fun BoxInfo(
        witherViewModel: WitherViewModel = hiltViewModel()

    ) {
        val infoCity =witherViewModel.witherdata.collectAsState().value
        Box( modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Card() {
                Column() {


                        if (infoCity != null) {
                            Text(text = "City Name : ${infoCity.name}")
                            Text(text = "Main Wither: ${infoCity.weather[0].main}")
                            Text(text = "Main Wither description: ${infoCity.weather[0].description}")
                            Text(text = "Wind Speed: ${infoCity.wind.speed}")
                        }

                }
            }
        }
    }
}

