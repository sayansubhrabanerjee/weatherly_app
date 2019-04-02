package sayan.banerjee.weatherly.weather.view


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import sayan.banerjee.weatherly.R

class WeatherSuccessFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_weather_success_container, container, false)
        initViews(view)
        return view
    }

    private fun initViews(v: View) {
    }

}
