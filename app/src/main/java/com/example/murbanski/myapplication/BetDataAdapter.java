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
        if (listItem == null) {
            listItem = LayoutInflater.from(mContext).inflate(android.R.layout.simple_list_item_1, parent, false);
        }

        BetData currentBet = bets.get(position);

        TextView textView = listItem.findViewById(android.R.id.text1);
        textView.setText(String.format("%s: %s:%s", currentBet.getLogin(), currentBet.getHomeTeamBet(), currentBet.getAwayTeamBet()));

        return listItem;
    }
}
