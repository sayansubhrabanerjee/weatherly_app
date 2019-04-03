package sayan.banerjee.weatherly.weather.model.listener

interface IFetchCurrentWeatherListener {
    fun onCurrentWeatherFetchSuccess(currentTemp: String, currentCity: String, currentIcon: String)
    fun onCurrentWeatherFetchError(errorMessage: String)
}