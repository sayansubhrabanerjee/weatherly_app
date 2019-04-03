package sayan.banerjee.weatherly.common

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import sayan.banerjee.weatherly.R
import sayan.banerjee.weatherly.common.APIConstants.Companion.IMAGE_FORMAT
import sayan.banerjee.weatherly.common.APIConstants.Companion.WEATHER_ICON_BASE


class CommonUtils {

    companion object {

        fun getWeatherAPIKey(): String = WeatherAPIKey.WEATHER_APP_ID

        fun getWeatherBaseURL(): String = APIConstants.WEATHER_BASE_URL

        fun getWeatherTempScale(): String = APIConstants.TEMP_SCALE

        fun getCityId(): Int = APIConstants.CITY_ID

        fun configureGlideForWeatherIcon(imageView: ImageView
                                         , iconUrl: String
                                         , context: Context
                                         , width: Int = 50
                                         , height: Int = 50) {

            val requestOptions = RequestOptions()
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.weather_icon_error)

            Glide
                .with(context)
                .applyDefaultRequestOptions(requestOptions
                    .override(width, height)
                    .centerCrop()
                    .diskCacheStrategy(DiskCacheStrategy.ALL))
                .load(WEATHER_ICON_BASE.plus(iconUrl).plus(IMAGE_FORMAT))
                .into(imageView)
        }
    }
}