package com.rapipay.weather.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.rapipay.weather.navigation.Routes.W_HOME_SCREEN
import com.rapipay.weather.home_screen.WHomeScreen
import com.rapipay.weather.home_screen.WHomeViewModel

@Composable
fun InitWeatherApp(key:String = "xyz"){
    WeatherNavigationHost(navHostController = rememberNavController())
}
@Composable
private fun WeatherNavigationHost(navHostController: NavHostController){
    Box {
        NavHost(
            navController = navHostController,
            startDestination = W_HOME_SCREEN,
            builder = navGraph(navHostController)
        )
    }
}
private fun navGraph(navHostController: NavHostController): NavGraphBuilder.() -> Unit {
    return {
        composable(route = W_HOME_SCREEN) {
            val viewModel: WHomeViewModel = hiltViewModel()
            WHomeScreen(
                viewModel = viewModel,
            )
        }
    }
}