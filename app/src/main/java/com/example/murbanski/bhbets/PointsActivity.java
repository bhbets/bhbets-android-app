package com.example.murbanski.bhbets;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PointsActivity extends AppCompatActivity implements Callback<GetPointsResponse> {

    private final CompetitionApi competitionApi = new CompetitionClient();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_points);

        competitionApi.getPoints().enqueue(this);
    }

    @Override
    public void onResponse(Call<GetPointsResponse> call, Response<GetPointsResponse> response) {
        final ListView listView = findViewById(R.id.cardListView);
        listView.setAdapter(new PointsDataAdapter(this, response.body().getPoints()));
    }

    @Override
    public void onFailure(Call<GetPointsResponse> call, Throwable t) {

    }
}
