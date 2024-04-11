### Registration form
> Develop an application which prompts a registration form with the fields User Name, Password, Address, Gender (radio buttons for male and female), Age (numeric), Date of Birth (Date Picker), State (Spinner) and a Submit button. On clicking the submit button, print all the data below the Submit Button. This application must contain UI controls like TextView, EditText, Radio Button, etc
- Create a new project in **Android Studio** named **Registration Form** (name should me absolute because in `MainActivity.java` the imported package name is **registrationform**)
- Add the below `XML` code in `activity_main.xml` of your project.

```xml
<?xml version="1.0" encoding="utf-8"?>
<!-- The root layout for the activity, using ConstraintLayout to manage UI components -->
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
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
                        android:layout_width="100dp"
                        android:layout_height="40dp"
                        android:text="Male" />
                    <RadioButton
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
                android:layout_height="match_parent"
                android:text="Submit" />
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

- Now add the below `Java` code in `MainActivity.java` of your project.

```java
// WEEK_10 (Java Functionality Code)

package com.example.registrationform;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Enable edge-to-edge display
        EdgeToEdge.enable(this);

        // Set the layout for the activity
        setContentView(R.layout.activity_main);

        // Apply window insets to adjust padding for system bars
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize the Spinner for countries
        Spinner spin = findViewById(R.id.countries);

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

        // Initialize EditText fields and DatePicker
        EditText userName = findViewById(R.id.userName);
        EditText address = findViewById(R.id.address);
        EditText age = findViewById(R.id.age);
        DatePicker dp = findViewById(R.id.datePicker);

        // Initialize TextView for output
        TextView output = findViewById(R.id.output);

        // Initialize Button for DatePicker visibility control
        Button buttonDatePicker = findViewById(R.id.dateButton);
        dp.setVisibility(View.GONE); // Hide DatePicker initially

        // Set OnClickListener for the button to show DatePicker
        buttonDatePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dp.setVisibility(View.VISIBLE); // Show DatePicker when button is pressed
            }
        });

        // Set OnClickListener for the submit button to display user information
        Button submit = findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String info = "Username : " + userName.getText().toString() +
                        "\nAge : " + age.getText().toString() +
                        "\nAddress : " + address.getText().toString() +
                        "\nDate of Birth : " + dp.getDayOfMonth() + "/" + (dp.getMonth() + 1) + "/" + dp.getYear() +
                        "\nState : " + spin.getSelectedItem().toString();
                output.setText(info); // Display user information
            }
        });
        // By AVidhanR
    }
}
```

That's it now save the both files and run app!

> Note: make sure to check the package name in java file `package com.example.registrationform;` if you got another name other than `registrationform` make sure to replace the first line of the code with yours.
