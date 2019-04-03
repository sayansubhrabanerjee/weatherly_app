package sayan.banerjee.weatherly.weather.model.repository

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import sayan.banerjee.weatherly.common.CommonUtils
import sayan.banerjee.weatherly.weather.model.listener.IFetchCurrentWeatherListener
import sayan.banerjee.weatherly.weather.model.listener.IFetchForecastWeatherListener
import sayan.banerjee.weatherly.weather.model.service.IWeatherService
import sayan.banerjee.weatherly.weather.model.service.ServiceGenerator
import sayan.banerjee.weatherly.weather.view.ForecastAdapter

open class BaseRepository {

    companion object {

        private val TAG: String = BaseRepository::class.java.simpleName

        fun getCurrentWeatherData(listener: IFetchCurrentWeatherListener) {
            val weatherService = ServiceGenerator.createService(IWeatherService::class.java)
            weatherService.getCurrentWeather(
                CommonUtils.getCityId(),
                CommonUtils.getWeatherTempScale(),
                CommonUtils.getWeatherAPIKey()
            )
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    listener.onCurrentWeatherFetchSuccess(
                        it.main?.temp.toString(),
                        it.name!!,
                        it.weather?.get(0)!!.icon!!
                    )
                }, {
                    listener.onCurrentWeatherFetchError(it.message.toString())
                })!!
        }

        fun getForecastWeatherData(adapter: ForecastAdapter, listener: IFetchForecastWeatherListener) {
            val weatherService = ServiceGenerator.createService(IWeatherService::class.java)
            weatherService.getForecastWeather(
                CommonUtils.getCityId(),
                CommonUtils.getWeatherTempScale(),
                CommonUtils.getWeatherAPIKey()
            )
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    it.list?.forEach { listener.onForecastWeatherFetchSuccess(it.main?.temp.toString(), it.dtTxt.toString()) }
                    adapter.setData(it.list!!)
                }, {
                    listener.onForecastWeatherFetchError(it.message.toString())
                })!!
        }
    }
}