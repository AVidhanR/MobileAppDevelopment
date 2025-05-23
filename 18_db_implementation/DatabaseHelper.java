
package com.example.registrationformwithdb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * DatabaseHelper class to manage the SQLite database for the registration form
 * app
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    // Constructor to create the database with a name, version, and context
    public DatabaseHelper(Context context) {
        super(context, "Registration.db", null, 1);
    }

    // Method to create the table for storing registration details when the database
    // is created
    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL(
                "CREATE TABLE RegistrationDetails (username VARCHAR(50) PRIMARY KEY, address VARCHAR(50), gender VARCHAR(50), dob DATE, age INT, state VARCHAR(50));"
        );
    }

    // Method to drop the table and create a new one with updated schema if the
    // database version is upgraded
    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL("DROP TABLE IF EXISTS RegistrationDetails;");
        onCreate(DB);
    }

    // Method to insert user data into the database
    public Boolean insertUserData(
            String username,
            String address,
            String gender,
            String dob,
            String age,
            String state
    ) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("address", address);
        contentValues.put("gender", gender);
        contentValues.put("dob", dob);
        contentValues.put("age", age);
        contentValues.put("state", state);
        long result = DB.insert("RegistrationDetails", null, contentValues);

        // Return true if the data is inserted successfully, else false
        return result != -1;
    }

    // Method to retrieve all user data from the database
    public Cursor getUserData() {
        SQLiteDatabase DB = this.getWritableDatabase();
        return DB.rawQuery("SELECT * FROM RegistrationDetails", null);
    }
}
