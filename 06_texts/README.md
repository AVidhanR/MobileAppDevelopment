# Android Texts

> Develop a program to implement Text View, Edit Text and Auto Complete Text View.

- Create a new project in **Android Studio** named **`Android Texts`** (name should me absolute because in `MainActivity.java` the imported package name is **androidtexts**)
- Add the below `XML` code in `activity_main.xml` of your project.

```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/main"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <!-- A LinearLayout to hold all the UI elements -->
    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical"
        android:gravity="center_horizontal"
        android:layout_margin="15dp">

        <!-- A TextView to display the title -->
        <TextView
            android:layout_width="match_parent"
            android:layout_height="50dp"
            android:text="Android Texts"
            android:padding="10dp"
            android:background="@color/black"
            android:textSize="25dp"
            android:textColor="@color/white"
            android:textAlignment="center"/>

        <!-- A TextView to label the AutoCompleteTextView -->
        <TextView
            android:layout_width="match_parent"
            android:layout_height="35dp"
            android:text="AutoCompleteTextView"
            android:textAlignment="center"
            android:textSize="20dp"
            android:layout_marginTop="8dp" />
        <!-- An AutoCompleteTextView for user input -->
        <AutoCompleteTextView
            android:layout_width="match_parent"
            android:layout_height="55dp"
            android:id="@+id/autoCompleteTextView"
            android:hint="Enter country name"
            android:layout_margin="10dp" />

        <!-- A TextView to label the EditText -->
        <TextView
            android:layout_width="match_parent"
            android:layout_height="35dp"
            android:text="EditText"
            android:textAlignment="center"
            android:textSize="20dp"
            android:layout_marginTop="8dp" />
        <!-- An EditText for user input -->
        <EditText
            android:layout_width="match_parent"
            android:layout_height="55dp"
            android:id="@+id/editText"
            android:hint="Enter any text"
            android:layout_margin="10dp" />

        <!-- A Button to submit the input -->
        <Button
            android:id="@+id/submit"
            android:layout_width="100dp"
            android:layout_height="48dp"
            android:layout_margin="6dp"
            android:text="Submit" />

        <!-- A TextView to label the output TextView -->
        <TextView
            android:layout_width="match_parent"
            android:layout_height="35dp"
            android:text="TextView"
            android:textAlignment="center"
            android:textSize="20dp"
            android:layout_marginTop="8dp" />
        <!-- A TextView to display output -->
        <TextView
            android:layout_width="match_parent"
            android:layout_height="100dp"
            android:id="@+id/output"
            android:hint="This is a text view"
            android:textSize="20dp"
            android:layout_margin="10dp"
            android:padding="10dp"
            android:textAlignment="center" />

    </LinearLayout>
</androidx.constraintlayout.widget.ConstraintLayout>

```

- Now add the below `Java` code in `MainActivity.java` of your project.

```java
package com.example.androidtexts;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
   // Array of country names for AutoCompleteTextView suggestions
   String[] countryNameList = {"India", "USA", "China", "Japan", "Russia", "Australia", "South Africa"};

   @Override
   protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_main); // Set the content view to the activity_main layout

       // Find the AutoCompleteTextView, EditText, TextView, and Button views by their respective IDs
       AutoCompleteTextView autoCompleteTextView = findViewById(R.id.autoCompleteTextView);
       EditText editText = findViewById(R.id.editText);
       TextView output = findViewById(R.id.output);
       Button submit = findViewById(R.id.submit);

       // Create an ArrayAdapter with the countryNameList and set it as the adapter for the AutoCompleteTextView
       ArrayAdapter adapter = new ArrayAdapter(
               this,
               android.R.layout.simple_list_item_1,
               countryNameList
       );
       autoCompleteTextView.setAdapter(adapter);

       // Set an OnClickListener for the submit button
       submit.setOnClickListener(view -> {
           // Create a string containing the entered country name and the text typed in the EditText
           String info = "County Name: " + autoCompleteTextView.getText().toString() +
                   "\nText typed in: " + editText.getText().toString();
           // Set the info string as the text of the output TextView
           output.setText(info);
       });
   }
}

```

That's it now save the both files and run the app!

> **Note** :make sure to check the package name in java file `package com.example.androidtexts;` if you got another name other than `androidtexts` make sure to replace the first line of the code with yours.
