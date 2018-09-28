package com.example.murbanski.bhbets;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

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

        final MatchData currentMatch = matches.get(position);
        TextView textViewHome = listItem.findViewById(R.id.txt_match_team_home);
        TextView textViewAway = listItem.findViewById(R.id.txt_match_team_away);
        TextView textViewDate = listItem.findViewById(R.id.txt_match_date);
        TextView textViewResultHome = listItem.findViewById(R.id.txt_match_result_home);
        TextView textViewResultAway = listItem.findViewById(R.id.txt_match_result_away);

        textViewHome.setText(currentMatch.getHomeTeam());
        textViewAway.setText(currentMatch.getAwayTeam());
        textViewDate.setText(currentMatch.getStartDate());

        if (currentMatch.getBet() != null) {
            textViewResultHome.setText(String.valueOf(currentMatch.getBet().getHomeTeam()));
            textViewResultAway.setText(String.valueOf(currentMatch.getBet().getAwayTeam()));
        } else {
            textViewResultHome.setText("?");
            textViewResultAway.setText("?");
        }

        return listItem;
    }
}
