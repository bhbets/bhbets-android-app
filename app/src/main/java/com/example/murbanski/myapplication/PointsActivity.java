package com.example.murbanski.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.error.VolleyError;
import com.android.volley.request.GsonRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;

public class PointsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_points);

        final ListView listView = findViewById(R.id.cardListView);

        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "http://5b59a29cf294400014c9b82a.mockapi.io/points";

        GsonRequest<GetPointsResponse> request = new GsonRequest<>(url, GetPointsResponse.class, new HashMap<String, String>(),
                new Response.Listener<GetPointsResponse>() {
                    @Override
                    public void onResponse(GetPointsResponse response) {
                        listView.setAdapter(new PointsDataAdapter(PointsActivity.this, response.getPoints()));
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
