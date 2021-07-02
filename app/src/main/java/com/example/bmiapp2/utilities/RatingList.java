package com.example.bmiapp2.utilities;

import java.util.ArrayList;
import java.util.List;

public class RatingList {

    ArrayList<String> arrayList;

    public RatingList() {
        arrayList = new ArrayList<>();

        arrayList.add("Very severely underweight");
        arrayList.add("Severely underweight");
        arrayList.add("Underweight");
        arrayList.add("Normal (healthy weight)");
        arrayList.add("Overweight");
        arrayList.add("Obese Class I (Moderately obese)");
        arrayList.add("Obese Class II (Severely obese)");
        arrayList.add("Obese Class III (Very severely obese)");
    }
    public ArrayList<String> GetList()
    {
        return arrayList;
    }
    public String GetItem(int index)
    {
        return arrayList.get(index);
    }

}
