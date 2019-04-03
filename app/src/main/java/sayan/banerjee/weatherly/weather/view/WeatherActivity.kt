package sayan.banerjee.weatherly.weather.view

import android.os.Bundle
import sayan.banerjee.weatherly.R

class WeatherActivity : BaseActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun initOnlineFlow() {
        initWeatherSuccessFragment()
    }

    override fun initOfflineFlow() {
        initWeatherErrorFragment()
    }

    private fun initWeatherErrorFragment() {
        supportFragmentManager.beginTransaction()
            .replace(
                R.id.layout_container,
                WeatherErrorFragment()
            )
            .commit()
    }

    private fun initWeatherSuccessFragment() {
        supportFragmentManager.beginTransaction()
            .replace(
                R.id.layout_container,
                WeatherSuccessFragment()
            )
            .commit()
    }
}
