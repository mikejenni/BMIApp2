package com.example.bmiapp2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.bmiapp2.utilities.MenuActivity;

public class RatingDetailActivity extends MenuActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ratingdetail);



        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        String textTitle = extras.getString("position");
        String textText = extras.getString("text");
        TextView textViewTitle = findViewById(R.id.textView_0_rating);
        TextView textViewText = findViewById(R.id.textView_0_ratingText);
        textViewTitle.setText(textTitle);
        textViewText.setText(textText);
    }

}
