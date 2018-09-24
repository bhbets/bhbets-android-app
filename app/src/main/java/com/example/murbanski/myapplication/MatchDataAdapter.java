package com.example.murbanski.myapplication;

import android.content.Context;
import android.graphics.Movie;
import android.os.Bundle;
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

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MatchDataAdapter extends ArrayAdapter<MatchData> {

    private Context mContext;
    private List<MatchData> matches;
    private long diff, oldLong, newLong;

    SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy HH:mm");
    SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

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

        final MatchData currentMatch = matches.get(position);
        TextView textViewHome = listItem.findViewById(R.id.txt_match_team_home);
        TextView textViewAway = listItem.findViewById(R.id.txt_match_team_away);
        TextView textViewDate = listItem.findViewById(R.id.txt_match_date);
        TextView textViewResultHome = listItem.findViewById(R.id.txt_match_result_home);
        TextView textViewResultAway = listItem.findViewById(R.id.txt_match_result_away);

        textViewHome.setText(currentMatch.getHomeTeam());
        textViewAway.setText(currentMatch.getAwayTeam());
        textViewDate.setText(matchDate(currentMatch.getStartDate()));

        if(currentMatch.getBet() != null){
            textViewResultHome.setText(Integer.toString(currentMatch.getBet().getHomeTeam()));
            textViewResultAway.setText(Integer.toString(currentMatch.getBet().getAwayTeam()));
        }else {
            textViewResultHome.setText("?");
            textViewResultAway.setText("?");
        }

        return listItem;
    }

    private String matchDate(String matchTime){
        try {
            Date dateMatch = formatter2.parse(matchTime);
            return formatter.format(dateMatch);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
