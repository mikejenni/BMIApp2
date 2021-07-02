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
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bmiapp2.utilities.DatabaseAdapter;
import com.example.bmiapp2.utilities.MenuActivity;

import java.util.List;

public class UserSettingsActivity extends MenuActivity {

    EditText userNameInput;
    Button saveUserButton;
    SharedPreferences sp;
    TextView currentUserText;
    List<String> userList;
    Spinner spinner;

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
        setContentView(R.layout.activity_usersettings);

        userNameInput = findViewById(R.id.editText_newUser);
        saveUserButton = findViewById(R.id.button_saveNewUser);
        currentUserText = findViewById(R.id.textView_currentUserText);


        sp = getSharedPreferences("prefs", Context.MODE_PRIVATE);





        DatabaseAdapter databaseAdapter = new DatabaseAdapter(UserSettingsActivity.this);
        databaseAdapter.open();

        userList = databaseAdapter.selectAllUser();



        spinner = (Spinner) findViewById(R.id.spinner_userList);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<String> adapter = new ArrayAdapter<> (this, android.R.layout.simple_spinner_item, userList);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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
        saveUserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userNameText = userNameInput.getText().toString();

                SharedPreferences.Editor editor = sp.edit();

                DatabaseAdapter databaseAdapter = new DatabaseAdapter(UserSettingsActivity.this);
                databaseAdapter.open();
                databaseAdapter.insertUser(userNameText);

                editor.putString("userName", userNameText);
                Toast.makeText(UserSettingsActivity.this, "User saved", Toast.LENGTH_SHORT).show();
                editor.apply();
                currentUserText.setText(userNameText);
                userList.add(userNameText);
                //adapter.add(userNameText);
                adapter.notifyDataSetChanged();
                spinner.setSelection(userList.size()-1);



            }
        });
    }


}