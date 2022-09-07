package com.rapipay.weather

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

//App Disptcher
data class AppDispatchers(val IO: CoroutineDispatcher = Dispatchers.IO,val MAIN: CoroutineDispatcher = Dispatchers.Main)
