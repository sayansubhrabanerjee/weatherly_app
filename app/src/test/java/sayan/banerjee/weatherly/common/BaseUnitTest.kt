package sayan.banerjee.weatherly.common

import android.content.Context
import org.mockito.Mock
import org.mockito.Mockito
import sayan.banerjee.weatherly.weather.model.listener.IFetchCurrentWeatherListener
import sayan.banerjee.weatherly.weather.model.listener.IFetchForecastWeatherListener
import sayan.banerjee.weatherly.weather.view.ForecastAdapter
import sayan.banerjee.weatherly.weather.viewmodel.WeatherViewModel

open class BaseUnitTest {
    @Mock
    var mContext: Context = Mockito.mock(Context::class.java)
    val mWeatherViewModel: WeatherViewModel? = null
    var mCurrentWeatherListener: IFetchCurrentWeatherListener? = null
    var mForecastWeatherListener: IFetchForecastWeatherListener? = null
    var mForecastAdapter: ForecastAdapter?= null
}