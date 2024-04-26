package com.example.registrationformwithdb;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // Initialize the database helper
    DatabaseHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        // Set the layout for the activity
        setContentView(R.layout.activity_main);

        // Initialize the Spinner for countries
        Spinner spin = findViewById(R.id.countries);
        DB = new DatabaseHelper(this); // Initialize the database helper

        // Initialize EditText fields and DatePicker
        EditText userName = findViewById(R.id.userName);
        EditText address = findViewById(R.id.address);
        EditText age = findViewById(R.id.age);
        DatePicker dp = findViewById(R.id.datePicker);
        RadioButton male = findViewById(R.id.male);

        // Initialize TextView for output
        TextView output = findViewById(R.id.output);

        // Initialize Button for DatePicker visibility control
        Button buttonDatePicker = findViewById(R.id.dateButton);
        Button storeBtn = findViewById(R.id.storeBtn);
        Button retrieveBtn = findViewById(R.id.retrieveBtn);
        Button submit = findViewById(R.id.submit);

        // Create an ArrayList to store the items
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Andhra Pradesh");
        arrayList.add("Telangana");
        arrayList.add("Uttar Pradesh");
        arrayList.add("Tamil Nadu");
        arrayList.add("Kerala");
        arrayList.add("Karnataka");

        // Create an ArrayAdapter and bind the data to the spinner
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                arrayList);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(arrayAdapter);

        dp.setVisibility(View.GONE); // Hide DatePicker initially

        storeBtn.setOnClickListener(view -> {
            String username = userName.getText().toString();
            String userAge = age.getText().toString();
            String userAddress = address.getText().toString();
            String userDate = dp.getDayOfMonth() + "/" + (dp.getMonth() + 1) + "/" + dp.getYear();
            String userState = spin.getSelectedItem().toString();
            String userGender = male.isChecked() ? "Male" : "Female";

            Boolean checkInsertData = DB.insertUserDate(
                    username,
                    userAddress,
                    userGender,
                    userAge,
                    userDate,
                    userState);

            if (checkInsertData) {
                Toast.makeText(
                        MainActivity.this,
                        "New Entry confirmed",
                        Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(
                        MainActivity.this,
                        "New Entry not inserted",
                        Toast.LENGTH_SHORT).show();
            }
        });

        retrieveBtn.setOnClickListener(view -> {
            Cursor cursor = DB.getUserData();
            if (cursor.getCount() == 0) {
                Toast.makeText(
                        MainActivity.this,
                        "No Entry found",
                        Toast.LENGTH_SHORT).show();
            }
            StringBuffer buffer = new StringBuffer();
            while (cursor.moveToNext()) {
                buffer.append("Name : " + cursor.getString(0) + "\n")
                        .append("Address : " + cursor.getString(1) + "\n")
                        .append("Gender : " + cursor.getString(2) + "\n")
                        .append("Age : " + cursor.getString(3) + "\n");
            }

            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("User Data");
            builder.setMessage(buffer.toString());
            builder.show();
            builder.setCancelable(true);

        });

        // Set OnClickListener for the button to show DatePicker
        buttonDatePicker.setOnClickListener(v -> {
            dp.setVisibility(View.VISIBLE); // Show DatePicker when button is pressed
        });

        // Set OnClickListener for the submit button to display user information
        submit.setOnClickListener(view -> {
            String info = "Username : " + userName.getText().toString() +
                    "\nAge : " + age.getText().toString() +
                    "\nAddress : " + address.getText().toString() +
                    "\nDate of Birth : " + dp.getDayOfMonth() + "/" + (dp.getMonth() + 1) + "/" + dp.getYear() +
                    "\nState : " + spin.getSelectedItem().toString();
            output.setText(info); // Display user information
        });
        // By AVidhanR
    }
}