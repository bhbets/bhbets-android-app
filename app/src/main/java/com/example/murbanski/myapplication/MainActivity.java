package com.example.murbanski.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.error.VolleyError;
import com.android.volley.request.GsonRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ListView listView = findViewById(R.id.cardListView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                MatchData selectedMatch = (MatchData) listView.getItemAtPosition(position);

                Intent intent = new Intent(getApplicationContext(), BetsForMatchActivity.class);
                intent.putExtra("MATCH_ID", selectedMatch.getId());
                startActivity(intent);

            }
        });

        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "http://5b59a29cf294400014c9b82a.mockapi.io/matches";

        GsonRequest<GetMatchesResponse> request = new GsonRequest<>(url, GetMatchesResponse.class, new HashMap<String, String>(),
                new Response.Listener<GetMatchesResponse>() {
                    @Override
                    public void onResponse(GetMatchesResponse response) {
                        listView.setAdapter(new MatchDataAdapter(MainActivity.this, response.getMatches()));
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

    public void goToPoints (View view) {

        Intent intent = new Intent(getApplicationContext(), PointsActivity.class);
        startActivity(intent);

    }

}
