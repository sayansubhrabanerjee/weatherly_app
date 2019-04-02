package sayan.banerjee.weatherly.weather.view


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_weather_error.view.*
import sayan.banerjee.weatherly.R

class WeatherErrorFragment : Fragment(), View.OnClickListener {
    override fun onClick(v: View?) {
        when(v?.id){
            R.id.button_click -> inflateWeatherSuccessFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_weather_error_container, container, false)
        initViews(view)
        return view
    }

    private fun initViews(v: View) {
        v.button_click.setOnClickListener(this)
    }

    private fun inflateWeatherSuccessFragment() {
        activity!!.supportFragmentManager.beginTransaction()
            .replace(
                R.id.layout_container,
                WeatherSuccessFragment()
            )
            .addToBackStack(null)
            .commit()
    }

}
