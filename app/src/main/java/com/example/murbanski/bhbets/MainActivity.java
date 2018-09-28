package com.example.murbanski.bhbets;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;

public class MainActivity extends AppCompatActivity implements Callback<GetMatchesResponse> {

    private final CompetitionApi competitionApi = new CompetitionClient();

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

        competitionApi.getMatches().enqueue(this);
    }

    @Override
    public void onResponse(Call<GetMatchesResponse> call, retrofit2.Response<GetMatchesResponse> response) {
        final ListView listView = findViewById(R.id.cardListView);
        listView.setAdapter(new MatchDataAdapter(this, response.body().getMatches()));
    }

    @Override
    public void onFailure(Call<GetMatchesResponse> call, Throwable t) {
        Toast.makeText(getApplicationContext(), "Got error: " + t.getLocalizedMessage(), Toast.LENGTH_LONG)
                .show();
    }

    public void goToPoints (View view) {

        Intent intent = new Intent(getApplicationContext(), PointsActivity.class);
        startActivity(intent);

    }
}
