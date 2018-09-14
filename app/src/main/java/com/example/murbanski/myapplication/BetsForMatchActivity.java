package com.example.murbanski.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.error.VolleyError;
import com.android.volley.request.GsonRequest;
import com.android.volley.request.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class BetsForMatchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bets);

        final ListView listView = findViewById(R.id.betsView);

        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = String.format("http://5b59a29cf294400014c9b82a.mockapi.io/matches/%s", getIntent().getStringExtra("MATCH_ID"));

        GsonRequest<GetSingleMatchResponse> request = new GsonRequest<>(url, GetSingleMatchResponse.class, new HashMap<String, String>(),
                new Response.Listener<GetSingleMatchResponse>() {
                    @Override
                    public void onResponse(GetSingleMatchResponse response) {
                        if(!response.getStatus().equals("CREATED") && !response.getStatus().equals("LOCKED")) {
                            listView.setAdapter(new BetDataAdapter(BetsForMatchActivity.this, response.getOtherBets()));
                            displayBetForLoggedUser("Player", response.getBet().getHomeTeam(), response.getBet().getAwayTeam());
                            displayMatchInformation(response.getHomeTeam(), response.getAwayTeam(), response.getResult().getHomeTeam(), response.getResult().getAwayTeam());
                        }
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

    public void displayMatchInformation(String homeTeam, String awayTeam, int homeTeamScore, int awayTeamScore){
        TextView txtTeams = (TextView)findViewById(R.id.txtTeams);
        TextView txtResult = (TextView)findViewById(R.id.txtResult);
        txtTeams.setText(String.format("%s - %s", homeTeam, awayTeam));
        txtResult.setText(String.format("%s : %s", homeTeamScore, awayTeamScore));
    }

    public void displayBetForLoggedUser(String player, int homeTeamBet, int awayTeamBet){
        TextView txtPlayer = (TextView)findViewById(R.id.txtPlayer);
        TextView txtBet = (TextView)findViewById(R.id.txtBet);
        txtPlayer.setText(player);
        txtBet.setText(String.format("%s : %s", homeTeamBet, awayTeamBet));
    }
}
