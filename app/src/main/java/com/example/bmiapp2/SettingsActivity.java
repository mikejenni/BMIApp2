package com.example.bmiapp2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;

import com.example.bmiapp2.utilities.MenuActivity;

public class SettingsActivity extends MenuActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Button button = findViewById(R.id.button_createUser);
        button.setOnClickListener(view ->{
            Intent intent = new Intent(this, UserSettingsActivity.class);
            startActivity(intent);
        });
    }


}