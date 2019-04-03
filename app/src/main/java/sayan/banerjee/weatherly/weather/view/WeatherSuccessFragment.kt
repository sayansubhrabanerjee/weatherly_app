package sayan.banerjee.weatherly.weather.view


import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.fragment_weather_success.*
import kotlinx.android.synthetic.main.fragment_weather_success.view.*
import sayan.banerjee.weatherly.R
import sayan.banerjee.weatherly.common.CommonUtils
import sayan.banerjee.weatherly.weather.model.forecast.ListWeather
import sayan.banerjee.weatherly.weather.model.listener.IFetchCurrentWeatherListener
import sayan.banerjee.weatherly.weather.model.listener.IFetchForecastWeatherListener
import sayan.banerjee.weatherly.weather.viewmodel.WeatherViewModel

class WeatherSuccessFragment : Fragment(), IFetchCurrentWeatherListener, IFetchForecastWeatherListener {

    private var mContext: Context? = null
    private var mWeatherViewModel: WeatherViewModel? = null
    private var mForecastAdapter: ForecastAdapter? = null
    private var mForecastDays: MutableList<ListWeather> = mutableListOf()

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        this.mContext = context
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_weather_success_container, container, false)
        initViews(view)
        initWeatherViewModel()
        makeRequestForCurrentWeather()
        setAdapter(view)
        makeRequestForForecastWeather(view)
        return view
    }

    private fun initViews(v: View) {
        val linearLayoutManager = LinearLayoutManager(v.context)
        v.recyclerView_weather_forecast.addItemDecoration(
            DividerItemDecoration(
                v.context,
                DividerItemDecoration.VERTICAL
            )
        )
        v.recyclerView_weather_forecast.layoutManager = linearLayoutManager
    }

    private fun initWeatherViewModel() {
        mWeatherViewModel = ViewModelProviders.of(this@WeatherSuccessFragment).get(WeatherViewModel::class.java)
    }

    private fun makeRequestForCurrentWeather() {
        mWeatherViewModel!!.getCurrentTempAndLocation(this)
    }

    private fun makeRequestForForecastWeather(v: View) {
        showProgress(v)
        mWeatherViewModel!!.getWeatherForecast(mForecastAdapter!!, this)
    }


    private fun setAdapter(v: View) {
        mForecastAdapter = ForecastAdapter(mContext!!, mForecastDays)
        v.recyclerView_weather_forecast.adapter = mForecastAdapter
    }

    private fun showProgress(v: View) {
        v.imageView_loading.visibility = View.VISIBLE
        animateProgressImage(v)
    }

    private fun hideProgress(v: View) {
        clearProgressImageAnimation(v)
        v.imageView_loading.visibility = View.GONE
    }

    private fun animateProgressImage(v: View) {
        val rotateClockWise = AnimationUtils.loadAnimation(v.imageView_loading.context, R.anim.rotate_clockwise)
        v.imageView_loading.startAnimation(rotateClockWise)
    }

    private fun clearProgressImageAnimation(v: View) {
        v.imageView_loading.clearAnimation()
    }

    override fun onCurrentWeatherFetchSuccess(currentTemp: String, currentCity: String, currentIcon: String) {
        Log.i(TAG, "current:: temp:: $currentTemp")
        Log.i(TAG, "current:: city:: $currentCity")
        Log.i(TAG, "current:: icon:: $currentIcon")
        if (currentTemp.isNullOrEmpty() || currentCity.isNullOrEmpty() || currentIcon.isNullOrEmpty()) {
            //Should be handled based on the requirements
        } else {
            textView_current_temp.text = currentTemp.plus(getString(R.string.degree))
            textView_current_city.text = currentCity
            CommonUtils.configureGlideForWeatherIcon(imageview_current_icon, currentIcon, mContext!!)
        }
        hideProgress(view!!)
    }

    override fun onCurrentWeatherFetchError(errorMessage: String) {
        Log.i(TAG, "current: errorMessage:: $errorMessage")
        hideProgress(view!!)
    }

    override fun onForecastWeatherFetchSuccess(temp: String, date: String) {
        Log.i(TAG, "forecast:: temp:: $temp")
        Log.i(TAG, "forecast:: city:: $date")
        hideProgress(view!!)
    }

    override fun onForecastWeatherFetchError(errorMessage: String) {
        Log.i(TAG, "forecast: errorMessage:: $errorMessage")
        hideProgress(view!!)
    }

    companion object {
        val TAG: String = WeatherSuccessFragment::class.java.simpleName
    }

}
