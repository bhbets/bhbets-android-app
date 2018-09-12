package com.example.murbanski.myapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class BetDataAdapter extends ArrayAdapter<BetData> {

    private Context mContext;
    private List<BetData> bets;

    public BetDataAdapter(@NonNull Context context, List<BetData> list) {
        super(context, 0 , list);
        mContext = context;
        bets = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;
        View listItem2 = convertView;
        if (listItem == null) {
            listItem = LayoutInflater.from(mContext).inflate(R.layout.bets_list_item, parent, false);
            listItem2 = LayoutInflater.from(mContext).inflate(R.layout.match_list_item, parent, false);
        }
        BetData currentBet = bets.get(position);

        /*if (position == 0){


            TextView textViewHome = listItem2.findViewById(R.id.txt_match_team_home);
            TextView textViewAway = listItem2.findViewById(R.id.txt_match_team_away);
            textViewHome.setText(currentBet.getHomeTeamName());
            textViewAway.setText(currentBet.getAwayTeamName());
        }*/

        TextView textViewNick = listItem.findViewById(R.id.txt_nick);
        TextView textViewBet = listItem.findViewById(R.id.txt_bet);
        TextView textViewPoints = listItem.findViewById(R.id.txt_points);
        textViewNick.setText("Nick");
        textViewBet.setText("5 : 0");
        //textViewBet.setText(String.format("%s : %s", currentBet.getHomeTeamResult(), currentBet.getAwayTeamBet()));
        textViewPoints.setText("5");


        return listItem;
    }
}
