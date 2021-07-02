package com.example.bmiapp2.utilities;

public class BMICalculator {

    public double BMICalculate(double weight, double height){
        double result = 0;
        result = weight/((height/100) * (height/100));
        return result;
    }

    public String BMIRater(double rating) {

        String output = "";

        if (rating <= 15)
            output = "Very severely underweight";

        else if (rating <= 16)
            output = "Severely underweight";

        else if (rating <= 18.5)
            output = "Underweight";

        else if (rating <= 25)
            output = "Normal (healthy weight)";

        else if (rating <= 30)
            output = "Overweight";

        else if (rating <= 35)
            output = "Obese Class I (Moderately obese)";

        else if (rating <= 40)
            output = "Obese Class II (Severely obese)";

        else if (rating > 40)
            output = "Obese Class III (Very severely obese)";

        return output;

    }
}
