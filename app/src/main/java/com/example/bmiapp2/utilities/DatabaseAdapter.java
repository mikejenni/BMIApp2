package com.example.bmiapp2.utilities;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class DatabaseAdapter {

    private static final int databaseVersion = 1;
    private static final String databaseName = "data";
    private static final String tableName = "user";
    private static final String bmiTable = "bmiTable";
    private BMICalculator bmiCalculator = new BMICalculator();

    private DatabaseHelper databaseHelper;
    private SQLiteDatabase database;

    public DatabaseAdapter(Context context){
        databaseHelper = new DatabaseHelper(context, databaseName, null, databaseVersion);
    }

    public void open(){
        database = databaseHelper.getWritableDatabase();
    }

    public void insertUser(String name){
        ContentValues values = new ContentValues();
        values.put("name", name);
        database.insert(tableName, null, values);
    }
    public List<String> selectAllUser(){
        String[] columns =  { "name" };

        Cursor result = database.query(tableName, columns, null, null, null, null, null);

        List<String> results = new ArrayList<>();
        result.moveToFirst();
        while(!result.isAfterLast()) {
            results.add(result.getString(0));
            result.moveToNext();
        }
        result.close();
        return results;
    }
    public List<String> selectAllBMIData(){
        String[] columns =  { "id", "user", "timestamp", "height", "weight" };


        Cursor result = database.query(bmiTable, columns, null, null, null, null, null);

        List<String> results = new ArrayList<>();
        result.moveToFirst();
        while(!result.isAfterLast()) {

            String bmiValue = String.format("%.2f",bmiCalculator.BMICalculate(result.getDouble(3), result.getDouble(4)));

            results.add(result.getString( 0)+ " "+ result.getString( 1) + ": " + formatDate(result.getString(2)) + " | " + result.getString( 4) + "cm " + result.getString( 3) + "kg | " + bmiValue + " BMI");
            //results.add(result.getString( 1));
            //results.add(result.getString( 2));
            //results.add(result.getString( 3));
            //results.add(result.getString( 4));



            result.moveToNext();
        }
        result.close();
        return results;
    }
    private String formatDate(String timestamp) {
        long timestamplong = Long.parseLong(timestamp);
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        java.sql.Date date1 = new java.sql.Date(timestamplong);

        return format.format(date1) ;
    }


    public void insertBmi(String user, float height, float weight) {
        ContentValues values = new ContentValues();
        values.put("user", user);
        values.put("timestamp", new Date().getTime());
        values.put("height", height);
        values.put("weight", weight);
        database.insert(bmiTable, null, values);
    }
    /*
    public String selectUser(int id){
        String[] columns =  { "name" };
        String selection = "id = ?";
        String[] selectionArgs = { Integer.toString(id) };
        Cursor result = database.query(tableName, columns, selection, selectionArgs, null, null, null);
        return result.getString(0);
    }

    public void updateUser(int id, String name) {
        ContentValues values = new ContentValues();
        values.put("name", name);
        String selection = "id = ?";
        String[] selectionArgs = { Integer.toString(id) };
        database.update(tableName, values, selection, selectionArgs);
    }

    public void deleteUser(int id){
        String selection = "id = ?";
        String[] selectionArgs = { Integer.toString(id) };
        database.delete(tableName, selection, selectionArgs);
    }

     */

    private static class DatabaseHelper extends SQLiteOpenHelper   {

        private static final String createTablesQuery = String.format("CREATE TABLE IF NOT EXISTS %s (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT);", tableName);
        private static final String dropTablesQuery = String.format("DROP TABLE IF EXISTS %s;", tableName);
        private static final String createBmiTableQuery = String.format("CREATE TABLE IF NOT EXISTS %s (id INTEGER PRIMARY KEY AUTOINCREMENT, user TEXT, timestamp INTEGER, weight FLOAT, height FLOAT);", bmiTable);
        private static final String dropBmiTablesQuery = String.format("DROP TABLE IF EXISTS %s;", bmiTable);




        public DatabaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(createTablesQuery);
            db.execSQL(createBmiTableQuery);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL(dropTablesQuery);
            db.execSQL(dropBmiTablesQuery);
            onCreate(db);
        }
    }

}


