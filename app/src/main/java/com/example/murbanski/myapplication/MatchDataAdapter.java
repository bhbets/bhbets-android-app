package com.example.murbanski.myapplication;

import android.content.Context;
import android.graphics.Movie;
import android.os.CountDownTimer;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MatchDataAdapter extends ArrayAdapter<MatchData> {

    private Context mContext;
    private List<MatchData> matches;

    public MatchDataAdapter(@NonNull Context context, List<MatchData> list) {
        super(context, 0 , list);
        mContext = context;
        matches = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;
        if(listItem == null)
            listItem = LayoutInflater.from(mContext).inflate(R.layout.match_list_item, parent,false);

        MatchData currentMatch = matches.get(position);

        TextView textViewHome = listItem.findViewById(R.id.txt_match_team_home);
        TextView textViewAway = listItem.findViewById(R.id.txt_match_team_away);
        final TextView textViewCounter = listItem.findViewById(R.id.txt_match_status);
        textViewHome.setText(currentMatch.getHomeTeam());
        textViewAway.setText(currentMatch.getAwayTeam());

        CountDownTimer Count = new CountDownTimer(30000, 1000) {
            public void onTick(long millisUntilFinished) {
                textViewCounter.setText("Match starts in: " + millisUntilFinished / 1000);
            }

            public void onFinish() {
                textViewCounter.setText("FINISHED");
            }
        };

        Count.start();

        return listItem;
    }
}
