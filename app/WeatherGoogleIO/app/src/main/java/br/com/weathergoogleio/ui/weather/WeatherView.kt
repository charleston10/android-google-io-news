package br.com.weathergoogleio.ui.weather

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import br.com.weathergoogleio.R
import butterknife.bindView

/**
 * Created by Charleston Anjos
 */
class WeatherView(context: Context, attrs: AttributeSet?) : LinearLayout(context, attrs) {

    val txtTemperature: TextView by bindView(R.id.weather_view_txt_temperature)
    val txtDayWeek: TextView by bindView(R.id.weather_view_txt_day_week)
    val imgClime: ImageView by bindView(R.id.weather_view_img_clime)

    init {
        LayoutInflater.from(context).inflate(R.layout.weather_view, this, true)

        if (attrs != null) {
            val typeArray = context.obtainStyledAttributes(R.styleable.WeatherView)

            if (typeArray.hasValue(R.styleable.WeatherView_weather_temperature)) {
                val temperature = typeArray.getInt(R.styleable.WeatherView_weather_temperature, 0)
                txtTemperature.text = formatTemperature(temperature)
            }

            if (typeArray.hasValue(R.styleable.WeatherView_weather_day_week)) {
                val dayWeek = typeArray.getInt(R.styleable.WeatherView_weather_day_week, 0)
                txtDayWeek.text = dayWeek.toString()
            }

            if (typeArray.hasValue(R.styleable.WeatherView_weather_clime)) {
                val clime = typeArray.getInt(R.styleable.WeatherView_weather_clime, 0)
                imgClime.setImageResource(clime)
            }
        }
    }

    fun setTemperature(temperature: Int) {
        txtTemperature.text = formatTemperature(temperature)
    }

    fun setDayWeek(day: Int) {
        txtDayWeek.text = day.toString()
    }

    private fun formatTemperature(temperature: Int): String {
        return String.format("%dºC", temperature)
    }
}