package com.example.me.sunshin.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.me.sunshin.R;
import com.example.me.sunshin.model.DummyForecast;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Me on 5/7/2017.
 */

public class ForecastItemViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.img) ImageView img;
    @BindView(R.id.tvDay) TextView tvDay;
    @BindView(R.id.tvForecast) TextView tvForecast;
    @BindView(R.id.tvMax) TextView tvMax;
    @BindView(R.id.tvMin) TextView tvMin;

    public ForecastItemViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }

    public void bind(final DummyForecast data){
        tvDay.setText(data.getDay());
        tvForecast.setText(data.getForecast());
        tvMax.setText(String.valueOf(data.getMaxTemp()+"\u00b0"));
        tvMin.setText(String.valueOf(data.getMinTemp()+"\u00b0"));
    }

}
