package com.example.bmiapp2;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.bmiapp2.utilities.MenuActivity;

public class CalculatorActivity extends MenuActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        Button button = findViewById(R.id.button_calculate);
        EditText weightText = findViewById(R.id.inputWeight);
        EditText heightText = findViewById(R.id.inputSize);
        button.setOnClickListener(view -> {
            Intent intent = new Intent(this, ResultActivity.class);
            String text1 = weightText.getText().toString();
            String text2 = heightText.getText().toString();
            intent.putExtra("weight", text1);
            intent.putExtra("height", text2);
            startActivity(intent);
        });
    }

}