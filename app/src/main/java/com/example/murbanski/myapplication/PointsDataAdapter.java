package com.example.murbanski.myapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

public class PointsDataAdapter extends ArrayAdapter<PointData> {

    private Context mContext;
    private List<PointData> points;

    public PointsDataAdapter(@NonNull Context context, List<PointData> list) {
        super(context, 0 , list);
        mContext = context;
        points = list;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;

        if (listItem == null) {
            listItem = LayoutInflater.from(mContext).inflate(R.layout.bets_list_item, parent, false);
        }
        PointData currentPoint = points.get(position);

        TextView textViewNick = listItem.findViewById(R.id.txt_nick);
        TextView textViewPoints = listItem.findViewById(R.id.txt_points);
        textViewNick.setText(Integer.toString(position+1) + ". " + currentPoint.getName());
        textViewPoints.setText(Integer.toString(currentPoint.getPoints()));

        return listItem;
    }

}
