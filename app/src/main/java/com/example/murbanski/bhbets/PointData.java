package com.example.murbanski.bhbets;

import com.google.gson.annotations.SerializedName;

public class PointData {

    @SerializedName("name")
    private String name;

    @SerializedName("points")
    private int points;

    public PointData() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }


}
