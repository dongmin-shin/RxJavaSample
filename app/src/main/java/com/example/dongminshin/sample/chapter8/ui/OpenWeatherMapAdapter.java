package com.example.dongminshin.sample.chapter8.ui;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dongminshin.rxjavasample.R;
import com.example.dongminshin.sample.chapter8.models.openweathermap.WeatherItem;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by DongMinShin on 16. 6. 4..
 */
public class OpenWeatherMapAdapter extends RecyclerView.Adapter<OpenWeatherMapAdapter.ViewHolder> {

    private List<WeatherItem> weatherList = new ArrayList<>();

    public OpenWeatherMapAdapter(List<WeatherItem> weatherList) {
        this.weatherList = weatherList;
    }

    public void updateWeatherInfoList(List<WeatherItem> weatherInfoList) {
        this.weatherList.clear();
        this.weatherList.addAll(weatherInfoList);
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.open_weathermap_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        WeatherItem weatherItem = weatherList.get(position);

        holder.date.setText(weatherItem.getDateTime().toString());
        holder.temperature.setText(weatherItem.getTemperature());

    }

    @Override
    public int getItemCount() {
        return weatherList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.weather_icon)
        ImageView weatherIcon;

        @BindView(R.id.weather_date)
        TextView date;

        @BindView(R.id.weather_temperature)
        TextView temperature;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
