package sayan.banerjee.weatherly.weather.viewmodel

import org.junit.Test
import org.mockito.Mockito
import sayan.banerjee.weatherly.common.BaseUnitTest
import sayan.banerjee.weatherly.weather.model.listener.IFetchCurrentWeatherListener
import sayan.banerjee.weatherly.weather.model.listener.IFetchForecastWeatherListener
import sayan.banerjee.weatherly.weather.view.ForecastAdapter

class WeatherViewModelTest: BaseUnitTest() {

    @Test
    fun getCurrentTempAndLocation() {
        mCurrentWeatherListener = Mockito.mock(IFetchCurrentWeatherListener::class.java)
        mWeatherViewModel?.getCurrentTempAndLocation(mCurrentWeatherListener!!)
    }

    @Test
    fun getWeatherForecast() {
        mForecastWeatherListener = Mockito.mock(IFetchForecastWeatherListener::class.java)
        mForecastAdapter = Mockito.mock(ForecastAdapter::class.java)
        mWeatherViewModel?.getWeatherForecast(mForecastAdapter!!, mForecastWeatherListener!!)
    }
}