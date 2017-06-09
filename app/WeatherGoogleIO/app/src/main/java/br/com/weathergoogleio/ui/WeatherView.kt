package br.com.weathergoogleio.ui

import android.content.Context
import android.support.annotation.IntegerRes
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import br.com.weathergoogleio.R
import butterknife.bindView

/**
 * Created by Charleston Anjos on 08/06/2017.
 */
class WeatherView : LinearLayout {

    val txtTemperature: TextView by bindView(R.id.weather_view_txt_temperature)
    val txtDayWeek: TextView by bindView(R.id.weather_view_txt_week_day)
    val imgClime: ImageView by bindView(R.id.weather_view_img_clime)

    constructor(context: Context) : super(context) {
        init(context)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(context, attrs)
    }

    fun init(context: Context, attrs: AttributeSet? = null) {
        LayoutInflater.from(context).inflate(R.layout.weather_view, this, true)

        if (attrs != null) {
            val typeArray = context.theme.obtainStyledAttributes(R.styleable.WeatherView)

            if (typeArray.hasValue(R.styleable.WeatherView_temperature)) {
                val temperature = typeArray.getString(R.styleable.WeatherView_temperature)
                txtTemperature.text = formatTemperature(temperature)
            }

            if (typeArray.hasValue(R.styleable.WeatherView_dayWeek)) {
                val dayWeek = typeArray.getString(R.styleable.WeatherView_dayWeek)
                txtDayWeek.text = dayWeek
            }

            if (typeArray.hasValue(R.styleable.WeatherView_clime)) {
                val clime = typeArray.getInt(R.styleable.WeatherView_clime, 0)
                imgClime.setImageResource(clime)
            }
        }
    }

    private fun formatTemperature(temperature: String): String {
        return String.format("%sºC", temperature)
    }
}