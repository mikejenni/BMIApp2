package com.example.bmiapp2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.bmiapp2.utilities.DatabaseAdapter;
import com.example.bmiapp2.utilities.BMIHistoryList;
import com.example.bmiapp2.utilities.MenuActivity;
import com.example.bmiapp2.utilities.RatingText;

import java.util.List;

public class HistoryActivity extends MenuActivity {

    EditText userNameInput;
    SharedPreferences sp;
    TextView currentUserText;
    List<String> userList;
    Spinner spinner;

    private ListView list;

    ListView listView_RatingLegend;
    BMIHistoryList historyList = new BMIHistoryList();
    RatingText ratingText = new RatingText();

    /*Spinner spinner = (Spinner) findViewById(R.id.spinner);
    // Create an ArrayAdapter using the string array and a default spinner layout
    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
            R.array.planets_array, android.R.layout.simple_spinner_item);
    // Specify the layout to use when the list of choices appears
    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    // Apply the adapter to the spinner
    spinner.setAdapter(adapter);*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        userNameInput = findViewById(R.id.editText_newUser);
        currentUserText = findViewById(R.id.textView_currentUserText);

        // Listview
        listView_RatingLegend = (ListView)findViewById(R.id.listView_History);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, historyList.GetList());
        listView_RatingLegend.setAdapter(arrayAdapter);



        sp = getSharedPreferences("prefs", Context.MODE_PRIVATE);





        DatabaseAdapter databaseAdapter = new DatabaseAdapter(HistoryActivity.this);
        databaseAdapter.open();

        userList = databaseAdapter.selectAllBMIData();




        //spinner = (Spinner) findViewById(R.id.spinner_userList);
        list = findViewById(R.id.listView_History);

// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<String> adapter = new ArrayAdapter<> (this, android.R.layout.simple_spinner_item, userList);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        list.setAdapter(adapter);
        //spinner.setAdapter(adapter);
        list.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String curentUser = userList.get(position);
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("userName", curentUser);
                editor.apply();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }


}