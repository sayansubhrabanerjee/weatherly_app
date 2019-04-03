package sayan.banerjee.weatherly.weather.model.listener

interface IFetchForecastWeatherListener {
    fun onForecastWeatherFetchSuccess(temp: String, date: String)
    fun onForecastWeatherFetchError(errorMessage: String)
}