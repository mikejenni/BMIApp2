package com.example.bmiapp2.utilities;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class BMIData {
    private long id;
    private long user;
    private long timestamp;
    private float height;
    private float weight;

    public BMIData(long id, long user, long timestamp, float height, float weight) {
        this.id = id;
        this.user = user;
        this.timestamp = timestamp;
        this.height = height;
        this.weight = weight;
    }

    public long getId() {
        return id;
    }

    public long getUser() {
        return user;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public float getHeight() {
        return height;
    }

    public float getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        Date date = new Date(this.timestamp);
        return format.format(date) + ": " + height + "m, " + weight + "kg | " + Math.round(weight / (height * height)) + " BMI";
    }
}
