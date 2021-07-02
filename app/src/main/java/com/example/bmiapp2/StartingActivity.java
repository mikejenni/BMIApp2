package com.example.bmiapp2;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.bmiapp2.utilities.MenuActivity;


public class StartingActivity extends MenuActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starting);
        Button button = findViewById(R.id.button_bmi_calculator);
        button.setOnClickListener(view ->{
                Intent intent = new Intent(this, CalculatorActivity.class);
                startActivity(intent);

        });
    }


}