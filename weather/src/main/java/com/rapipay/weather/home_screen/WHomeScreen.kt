package com.rapipay.weather.home_screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.rapipay.weather.weather_common.WUtils

@Composable
fun WHomeScreen(viewModel: WHomeViewModel){
    val context = LocalContext.current
    val scaffoldState = rememberScaffoldState()
    LaunchedEffect(key1 = Unit, block = {
        if(WUtils.isNetworkAvailable(context)) {
            viewModel.getWeatherDetails()
        }else{
            scaffoldState.snackbarHostState.showSnackbar("No Network")
        }
    })
    Box{
        Scaffold (topBar = {
            TopAppBar() {
                Text(text = "RapiPay Money")
            }
        }, scaffoldState = scaffoldState){
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                Column (Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally){
                    Row() {
                        Text(text = "Name of the City: ", style = MaterialTheme.typography.h6.copy(color = MaterialTheme.colors.primary))
                        Text(text = viewModel.state.weatherResponse.name?:"NA", style = MaterialTheme.typography.h6.copy(color = MaterialTheme.colors.primary))
                    }
                    Row() {
                        Text(text = "Temperature: ")
                        Text(text = viewModel.state.weatherResponse.main?.temp.toString()?:"NA")
                    }
                    Row() {
                        Text(text = "Feels Like: ")
                        Text(text = viewModel.state.weatherResponse.main?.feelsLike.toString()?:"NA")
                    }
                    Row() {
                        Text(text = "Humidity: ")
                        Text(text = viewModel.state.weatherResponse.main?.humidity.toString()?:"NA")
                    }

                    Spacer(Modifier.height(16.dp))
                  Button(onClick = { viewModel.getWeatherDetails() }) {
                      Text(text = "Refresh The Data")
                  }
                }
                if(viewModel.state.isLoading) {
                    CircularProgressIndicator()
                }
            }
        }
    }
}