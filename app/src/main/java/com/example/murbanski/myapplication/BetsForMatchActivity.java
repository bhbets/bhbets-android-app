package com.example.murbanski.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.error.VolleyError;
import com.android.volley.request.GsonRequest;
import com.android.volley.request.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;

public class BetsForMatchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bets);

        final ListView listView = findViewById(R.id.betsView);

        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = String.format("https://mundial2018.000webhostapp.com/mundial/getBetsWithScores.php?id_match=%s", getIntent().getStringExtra("MATCH_ID"));

        GsonRequest<GetBetsWithScoresResponse> request = new GsonRequest<>(url, GetBetsWithScoresResponse.class, new HashMap<String, String>(),
                new Response.Listener<GetBetsWithScoresResponse>() {
                    @Override
                    public void onResponse(GetBetsWithScoresResponse response) {
                        listView.setAdapter(new BetDataAdapter(BetsForMatchActivity.this, response.getBets()));
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                    }
                });

        // Add the request to the RequestQueue.
        queue.add(request);
    }
}
