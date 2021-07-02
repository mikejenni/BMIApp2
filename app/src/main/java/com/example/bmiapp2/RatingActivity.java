package com.example.bmiapp2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.bmiapp2.utilities.MenuActivity;
import com.example.bmiapp2.utilities.RatingList;
import com.example.bmiapp2.utilities.RatingText;

public class RatingActivity extends MenuActivity {


    ListView listView_RatingLegend;
    RatingList ratingList = new RatingList();
    RatingText ratingText = new RatingText();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);

        listView_RatingLegend = (ListView)findViewById(R.id.listView_History);

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, ratingList.GetList());

        listView_RatingLegend.setAdapter(arrayAdapter);

        listView_RatingLegend.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {


                String getItem = parent.getItemAtPosition(position).toString();
                String getItem1 = ratingText.GetItem(position);

                Intent intentRating = new Intent(getBaseContext(), RatingDetailActivity.class);

                intentRating.putExtra("position", getItem);
                intentRating.putExtra("text", getItem1);
                startActivity(intentRating);

            }

        });
    }


}