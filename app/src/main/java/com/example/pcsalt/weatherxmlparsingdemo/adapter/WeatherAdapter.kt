package com.example.pcsalt.weatherxmlparsingdemo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pcsalt.weatherxmlparsingdemo.R
import com.example.pcsalt.weatherxmlparsingdemo.databinding.ItemWeatherBinding
import com.example.pcsalt.weatherxmlparsingdemo.dto.Weather
import com.example.pcsalt.weatherxmlparsingdemo.extension.setMsgTemp

class WeatherAdapter : RecyclerView.Adapter<WeatherAdapter.ItemVH>() {

    val weatherList = ArrayList<Weather>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemVH {
        val binding = ItemWeatherBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemVH(binding)
    }

    override fun onBindViewHolder(holder: ItemVH, position: Int) {
        holder.setData(weatherList[position])
    }

    override fun getItemCount(): Int {
        return weatherList.size
    }

    inner class ItemVH(private val binding: ItemWeatherBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun setData(data: Weather) {
            binding.tvDate.text = data.date

            binding.tvWeatherMin.setMsgTemp(
                R.string.msg_c_and_f,
                R.string.min,
                data.mintempC,
                data.mintempF
            )

            binding.tvWeatherMax.setMsgTemp(
                R.string.msg_c_and_f,
                R.string.max,
                data.maxtempC,
                data.mintempC
            )
            binding.tvWeatherAvg.setMsgTemp(
                R.string.msg_c_and_f,
                R.string.avg,
                data.avgtempC,
                data.avgtempF
            )
        }
    }
}