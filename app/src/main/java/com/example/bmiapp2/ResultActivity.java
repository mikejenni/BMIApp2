package com.example.bmiapp2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.bmiapp2.utilities.BMICalculator;
import com.example.bmiapp2.utilities.DatabaseAdapter;
import com.example.bmiapp2.utilities.MenuActivity;

public class ResultActivity extends MenuActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Intent intentMain3 = getIntent();
        Bundle extras = intentMain3.getExtras();

        String textWeight = extras.getString("weight");
        String textHeight = extras.getString("height");
        TextView textViewHeight = findViewById(R.id.textView_resultHeight);
        TextView textViewWeight = findViewById(R.id.textView_resultWeight);
        textViewHeight.setText(textWeight);
        textViewWeight.setText(textHeight);

        TextView bmiResult = findViewById(R.id.textView_resultBmi);
        BMICalculator cal = new BMICalculator();
        double doubleResult = cal.BMICalculate(Double.parseDouble(textHeight), Double.parseDouble(textWeight));
        String stringResultRounded = String.format("%.2f",doubleResult);
        bmiResult.setText(stringResultRounded);

        BMICalculator rat = new BMICalculator();
        TextView textViewRating = findViewById(R.id.textView_resultRating);
        textViewRating.setText(rat.BMIRater(doubleResult));





        Button button = findViewById(R.id.button_goToRatingView);
        button.setOnClickListener(view ->{
            Intent intentMain4 = new Intent(this, RatingActivity.class);
            startActivity(intentMain4);



        });
        Button buttonSave = findViewById(R.id.button_saveBmi);
        buttonSave.setOnClickListener(view ->{
            DatabaseAdapter databaseAdapter = new DatabaseAdapter(this);
            databaseAdapter.open();
            SharedPreferences sp = getSharedPreferences("prefs", Context.MODE_PRIVATE);
            String user = sp.getString("userName","");
            databaseAdapter.insertBmi(user, Float.parseFloat(textHeight), Float.parseFloat(textWeight));




        });
    }


}