package sayan.banerjee.weatherly.weather.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import sayan.banerjee.weatherly.weather.model.listener.IFetchCurrentWeatherListener
import sayan.banerjee.weatherly.weather.model.listener.IFetchForecastWeatherListener
import sayan.banerjee.weatherly.weather.model.repository.WeatherRepository
import sayan.banerjee.weatherly.weather.view.ForecastAdapter

class WeatherViewModel(application: Application) : AndroidViewModel(application) {
    private var mWeatherRepo: WeatherRepository = WeatherRepository(application)

    fun getCurrentTempAndLocation(listener: IFetchCurrentWeatherListener) {
        mWeatherRepo.getCurrentTempAndLocation(listener)
    }

    fun getWeatherForecast(adapter: ForecastAdapter, listener: IFetchForecastWeatherListener) {
        mWeatherRepo.getWeatherForecast(adapter, listener)
    }
}