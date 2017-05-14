package com.example.me.sunshin.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.me.sunshin.R;
import com.example.me.sunshin.model.DummyForecast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Me on 5/7/2017.
 */

public class ListForecastAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private List<DummyForecast> model = new ArrayList<>();

    public ListForecastAdapter(List<DummyForecast> model) {
        this.model = model;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ForecastItemViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.row_forecast_item,parent,false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ForecastItemViewHolder forecastItemViewHolder = (ForecastItemViewHolder) holder;
        DummyForecast data = model.get(position);
        forecastItemViewHolder.bind(data);
    }

    @Override
    public int getItemCount() {
        return model.size();
    }
}
