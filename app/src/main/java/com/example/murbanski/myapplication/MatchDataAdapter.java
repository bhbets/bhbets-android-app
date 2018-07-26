package com.example.murbanski.myapplication;

import android.content.Context;
import android.graphics.Movie;
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
            listItem = LayoutInflater.from(mContext).inflate(android.R.layout.simple_list_item_1, parent,false);

        MatchData currentMatch = matches.get(position);

        TextView textView = listItem.findViewById(android.R.id.text1);
        textView.setText(String.format("%s VS %s", currentMatch.getHomeTeam(), currentMatch.getAwayTeam()));

        return listItem;
    }
}
