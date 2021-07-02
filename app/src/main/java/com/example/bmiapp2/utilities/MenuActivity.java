package com.example.bmiapp2.utilities;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.bmiapp2.CalculatorActivity;
import com.example.bmiapp2.HistoryActivity;
import com.example.bmiapp2.R;
import com.example.bmiapp2.RatingActivity;
import com.example.bmiapp2.SettingsActivity;
import com.example.bmiapp2.StartingActivity;

public abstract class MenuActivity extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_starting:
                startActivity(new Intent(this, StartingActivity.class));
                return true;
            case R.id.item_calculator:
                startActivity(new Intent(this, CalculatorActivity.class));
                return true;
            case R.id.item_rating:
                startActivity(new Intent(this, RatingActivity.class));
                return true;
            case R.id.item_settings:
                startActivity(new Intent(this, SettingsActivity.class));
                return true;
            case R.id.item_history:
                startActivity(new Intent(this, HistoryActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
