package com.example.me.sunshin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.me.sunshin.adapter.ListForecastAdapter;
import com.example.me.sunshin.model.DummyForecast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    @BindView(R.id.rv)
    RecyclerView recyclerView;
    ListForecastAdapter adapter;
    private List<DummyForecast> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setupRecyclerView();
    }

    public void setDummyData()
    {
        for (int i=0;i<20;i++){
            DummyForecast dummyForecast = new DummyForecast("Sunday","Sunny",25+i,20+i);
            list.add(dummyForecast);
        }
        adapter.notifyDataSetChanged();
    }

    private void setupRecyclerView()
    {
        adapter= new ListForecastAdapter(list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(adapter);
        //setDummyData();
        getDataFromApi();
    }

    public void getDataFromApi(){
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        final String url ="http://api.openweathermap.org/data/2.5/forecast/daily?lat=-8.650000&lon=115.216667&cnt=16&appid=797acf2b55bf9943d9594957a0832268&units=metric";


        Response.Listener<String> response = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d(TAG,"onResponse : "+response);
            }
        };

        Response.ErrorListener errorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                if (error != null){
                    Log.e(TAG, "onErrorResponse: "+error.getMessage());
                }else {
                    Log.e(TAG, "onErrorResponse: "+" something wrong happened" );
                }
            }
        };

        StringRequest request = new StringRequest(
                Request.Method.GET,
                url,
                response,
                errorListener
        );
        requestQueue.add(request);

    }


}
