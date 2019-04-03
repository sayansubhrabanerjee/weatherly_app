package sayan.banerjee.weatherly.weather.model.repository

import android.app.Application
import sayan.banerjee.weatherly.weather.model.listener.IFetchCurrentWeatherListener
import sayan.banerjee.weatherly.weather.model.listener.IFetchForecastWeatherListener
import sayan.banerjee.weatherly.weather.view.ForecastAdapter

class WeatherRepository(application: Application) : BaseRepository() {

    fun getCurrentTempAndLocation(listener: IFetchCurrentWeatherListener) = getCurrentWeatherData(listener)

    fun getWeatherForecast(adapter: ForecastAdapter, listener: IFetchForecastWeatherListener) =
        getForecastWeatherData(adapter, listener)

    companion object {
        val TAG: String = WeatherRepository::class.java.simpleName
    }
}