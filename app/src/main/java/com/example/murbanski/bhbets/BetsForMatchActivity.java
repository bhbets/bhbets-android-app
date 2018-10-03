package com.example.murbanski.bhbets;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BetsForMatchActivity extends AppCompatActivity implements Callback<GetSingleMatchResponse> {

    private final CompetitionApi competitionApi = new CompetitionClient();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bets);

        competitionApi.getMatch(getIntent().getStringExtra("MATCH_ID")).enqueue(this);
    }

    @Override
    public void onResponse(Call<GetSingleMatchResponse> call, Response<GetSingleMatchResponse> response) {
        if (!response.isSuccessful()) {
            Toast
                    .makeText(this, "Error: " + response.message(), Toast.LENGTH_SHORT)
                    .show();

            return;
        }

        final MatchData matchData = response.body().getMatch();
        displayMatchInformation(matchData.getHomeTeam(), matchData.getAwayTeam());

        if (matchData.getBet() != null) {
            displayBetForLoggedUser("Player", matchData.getBet());
        }

        if ("FINISHED".equals(matchData.getStatus())) {
            displayMatchResult(matchData.getResult());
        }

        if ("LOCKED".equals(matchData.getStatus()) || "FINISHED".equals(matchData.getStatus())) {
            displayOtherBets(matchData.getOtherBets());
        }
    }

    @Override
    public void onFailure(Call<GetSingleMatchResponse> call, Throwable t) {

    }

    private void displayMatchInformation(String homeTeam, String awayTeam){
        TextView txtTeams = findViewById(R.id.txtTeams);
        txtTeams.setText(String.format("%s - %s", homeTeam, awayTeam));
    }

    private void displayMatchResult(Score result) {
        TextView txtResult = findViewById(R.id.txtResult);
        txtResult.setText(String.format("%s : %s", result.getHomeTeam(), result.getAwayTeam()));
    }

    private void displayBetForLoggedUser(String player, Score bet){
        TextView txtPlayer = findViewById(R.id.txtPlayer);
        txtPlayer.setText(player);

        TextView txtBet = findViewById(R.id.txtBet);
        txtBet.setText(String.format("%s : %s", bet.getHomeTeam(), bet.getAwayTeam()));
    }

    private void displayOtherBets(List<BetData> bets) {
        final ListView listView = findViewById(R.id.betsView);
        listView.setAdapter(new BetDataAdapter(this, bets));
    }
}
