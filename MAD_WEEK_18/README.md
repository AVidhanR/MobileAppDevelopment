# Login With Disable

> Question WEEK_18

- Create a new project in **Android Studio** named **Registration Foem with dB** (name should me absolute because in `MainActivity.java` the imported package name is **registrationformwithdb**)
- Add the below `XML` code in `activity_main.xml` of your project.

```xml
<?xml version="1.0" encoding="utf-8"?>
<!-- The root layout for the activity, using ConstraintLayout to manage UI components -->
<androidx.constraintlayout.widget.ConstraintLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/main"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <!-- ScrollView to enable scrolling if the content exceeds the screen height -->
    <ScrollView
        android:layout_width="409dp"
        android:layout_height="729dp"
        tools:ignore="MissingConstraints"
        tools:layout_editor_absoluteX="1dp"
        tools:layout_editor_absoluteY="1dp">
        <!-- LinearLayout to stack UI elements vertically -->
        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:orientation="vertical">
            <!-- TextView to display the title "Registration Form" -->
            <TextView
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                android:text="Registration Form"
                android:textAlignment="center"
                android:layout_margin="10dp"
                android:textSize="30dp" />
            <!-- LinearLayout to arrange Username TextView and EditText horizontally -->
            <LinearLayout
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                android:orientation="horizontal">
                <!-- TextView for "Username" label -->
                <TextView
                    android:layout_width="100dp"
                    android:layout_height="30dp"
                    android:text="Username : "
                    android:layout_margin="10dp"
                    android:textAlignment="center" />
                <!-- EditText for user input -->
                <EditText
                    android:id="@+id/userName"
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    android:ems="10"
                    android:inputType="text"
                    android:layout_margin="10dp"
                    android:hint="Enter Username" />
            </LinearLayout>
            <!-- Similar LinearLayouts for Password and Confirm Password -->
            <LinearLayout
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                android:orientation="horizontal">
                <TextView
                    android:layout_width="100dp"
                    android:layout_height="30dp"
                    android:text="Password : "
                    android:layout_margin="10dp"
                    android:textAlignment="center" />
                <EditText
                    android:id="@+id/pwd"
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    android:layout_weight="1"
                    android:ems="10"
                    android:hint="Enter Password"
                    android:layout_margin="10dp"
                    android:inputType="textPassword" />
            </LinearLayout>
            <LinearLayout
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                android:orientation="horizontal">
                <TextView
                    android:layout_width="100dp"
                    android:layout_height="40dp"
                    android:text="Confirm\nPassword "
                    android:layout_margin="10dp"
                    android:textAlignment="center" />
                <EditText
                    android:id="@+id/confirm"
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    android:ems="10"
                    android:inputType="text"
                    android:layout_margin="10dp"
                    android:hint="Confirm Password" />
            </LinearLayout>

            <LinearLayout
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                android:orientation="horizontal">
                <TextView
                    android:layout_width="100dp"
                    android:layout_height="30dp"
                    android:text="Address : "
                    android:layout_margin="10dp"
                    android:textAlignment="center"
                    />
                <EditText
                    android:id="@+id/address"
                    android:layout_width="match_parent"
                    android:layout_height="50dp"
                    android:ems="10"
                    android:inputType="text"
                    android:layout_margin="10dp"
                    android:hint="Enter address here" />
            </LinearLayout>
            <!-- LinearLayout to arrange Gender TextView and RadioButtons horizontally -->
            <LinearLayout
                android:layout_width="300dp"
                android:layout_height="match_parent"
                android:orientation="horizontal"
                android:layout_marginStart="20dp">
                <TextView
                    android:layout_width="wrap_content"
                    android:layout_height="match_parent"
                    android:layout_margin="10dp"
                    android:textAlignment="center"
                    android:text="Gender : " />
                <!-- LinearLayout to arrange RadioButtons for Male and Female -->
                <LinearLayout
                    android:layout_width="match_parent"
                    android:layout_height="match_parent"
                    android:orientation="horizontal"
                    android:layout_marginStart="40dp">
                    <RadioButton
                        android:id="@+id/male"
                        android:layout_width="100dp"
                        android:layout_height="40dp"
                        android:text="Male" />
                    <RadioButton
                        android:id="@+id/female"
                        android:layout_width="100dp"
                        android:layout_height="40dp"
                        android:text="Female" />
                </LinearLayout>
            </LinearLayout>
            <!-- LinearLayout for Date of Birth section -->
            <LinearLayout
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                android:orientation="vertical"
                android:layout_margin="20dp"
                android:textAlignment="center">
                <TextView
                    android:layout_width="match_parent"
                    android:layout_height="30dp"
                    android:textAlignment="center"
                    android:text="Date of Birth" />
                <Button
                    android:layout_width="match_parent"
                    android:layout_height="match_parent"
                    android:text="Select Date"
                    android:id="@+id/dateButton" />
                <DatePicker
                    android:id="@+id/datePicker"
                    android:layout_width="match_parent"
                    android:layout_height="400dp"
                    android:layout_margin="10dp"
                    android:visibility="gone" />
            </LinearLayout>
            <!-- LinearLayout for Age section -->
            <LinearLayout
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                android:orientation="horizontal">
                <TextView
                    android:layout_width="100dp"
                    android:layout_height="30dp"
                    android:text="Age : "
                    android:layout_margin="10dp"
                    android:textAlignment="center" />
                <EditText
                    android:id="@+id/age"
                    android:layout_width="match_parent"
                    android:layout_height="50dp"
                    android:ems="10"
                    android:inputType="number"
                    android:layout_margin="10dp"
                    android:hint="Enter age here" />
            </LinearLayout>
            <!-- LinearLayout for State selection Spinner -->
            <LinearLayout
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                android:orientation="horizontal"
                android:layout_margin="10dp">
                <TextView
                    android:layout_width="100dp"
                    android:layout_height="30dp"
                    android:text="State : "
                    android:textAlignment="center" />
                <Spinner
                    android:layout_width="150dp"
                    android:layout_height="50dp"
                    android:layout_marginStart="25dp"
                    android:id="@+id/countries" />
            </LinearLayout>
            <!-- Button to submit the form -->
            <Button
                android:id="@+id/submit"
                android:layout_width="match_parent"
                android:layout_height="48dp"
                android:layout_marginHorizontal="100dp"
                android:layout_marginBottom="8dp"
                android:text="Submit" />
            <LinearLayout
                android:layout_width="match_parent"
                android:layout_height="50dp"
                android:orientation="horizontal"
                android:gravity="center_horizontal">

                <!--Button to store the user data in db-->
                <Button
                    android:id="@+id/storeBtn"
                    android:text="Store"
                    android:layout_width="100dp"
                    android:layout_height="48dp"
                    android:layout_marginHorizontal="8dp"/>

               <!-- Button to retrieve the user data from db -->
                <Button
                    android:id="@+id/retrieveBtn"
                    android:text="Retrieve"
                    android:layout_width="100dp"
                    android:layout_height="48dp"
                    android:layout_marginHorizontal="8dp"/>

            </LinearLayout>
            <!-- TextView to display the output or preview -->
            <TextView
                android:id="@+id/output"
                android:layout_width="match_parent"
                android:layout_height="100dp"
                android:textAlignment="textStart"
                android:layout_margin="30dp"
                android:hint="Preview" />
        </LinearLayout>
    </ScrollView>
</androidx.constraintlayout.widget.ConstraintLayout>

```

- Now add the below `Java` code in `DatabaseHelper.java` of your project.

```java
package com.example.registrationformwithdb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * DatabaseHelper class to manage the SQLite database for the registration form app
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    // Constructor to create the database with a name, version, and context
    public DatabaseHelper(Context context) {
        super(
                context,
                "Registration.db",
                null,
                1
        );
    }

    // Method to create the table for storing registration details when the database is created
    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL(
                "Create table RegistrationDetails (username varchar(50) primary key, address varchar(50), gender varchar(50), dob date, age int, state varchar(50));");
    }

    // Method to drop the table and create a new one with updated schema if the database version is upgraded
    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL("drop table if exists RegistrationDetails;");
        onCreate(DB);
    }

    // Method to insert user data into the database
    public Boolean insertUserDate(
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
        return DB.rawQuery("select * from RegistrationDetails", null);
    }
}

```

- Now add the below `Java` code in `MainActivity.java` of your project.

```java
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
                    userState
            );

            if (checkInsertData) {
                Toast.makeText(
                        MainActivity.this,
                        "New Entry confirmed",
                        Toast.LENGTH_SHORT
                ).show();
            } else {
                Toast.makeText(
                        MainActivity.this,
                        "New Entry not inserted",
                        Toast.LENGTH_SHORT
                ).show();
            }
        });

        retrieveBtn.setOnClickListener(view -> {
            Cursor cursor = DB.getUserData();
            if (cursor.getCount() == 0) {
                Toast.makeText(
                        MainActivity.this,
                        "No Entry found",
                        Toast.LENGTH_SHORT
                ).show();
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

```

That's it now save the above files and run the app!

> **Note** :make sure to check the package name in java file `package com.example.registrationformwithdb;` if you got another name other than `registrationformwithdb` make sure to replace the first line of the code with yours.
