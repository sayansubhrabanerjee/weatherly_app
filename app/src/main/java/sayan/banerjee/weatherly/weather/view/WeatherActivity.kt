package sayan.banerjee.weatherly.weather.view

import android.os.Bundle
import sayan.banerjee.weatherly.R

class WeatherActivity : BaseActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun initOnlineFlow() {
        addWeatherSuccessFragment()
    }

    override fun initOfflineFlow() {
        addWeatherErrorFragment()
    }

    private fun addWeatherSuccessFragment() {
        supportFragmentManager.beginTransaction()
            .replace(
                R.id.layout_container,
                WeatherSuccessFragment()
            )
            .commit()
    }

    private fun addWeatherErrorFragment() {
        supportFragmentManager.beginTransaction()
            .replace(
                R.id.layout_container,
                WeatherErrorFragment()
            )
            .commit()
    }
}
