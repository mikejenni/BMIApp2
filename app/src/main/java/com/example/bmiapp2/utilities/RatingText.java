package com.example.bmiapp2.utilities;

import java.util.ArrayList;

public class RatingText {

    ArrayList<String> arrayListText;

    public RatingText() {
        arrayListText = new ArrayList<>();

        arrayListText.add("BMI under 15");
        arrayListText.add("BMI from 15 to 16");
        arrayListText.add("BMI from 16 to 18.5");
        arrayListText.add("BMI from 18.5 to 25");
        arrayListText.add("BMI from 25 to 30");
        arrayListText.add("BMI from 30 to 35");
        arrayListText.add("BMI from 35 to 40");
        arrayListText.add("BMI more then 40");
    }
    public ArrayList<String> GetList()
    {
        return arrayListText;
    }
    public String GetItem(int index)
    {
        return arrayListText.get(index);
    }
}
