# User Greeting

> Design an Android application program that accepts a name from the user and displays the hello name to the user in response as output.

- Create a new project in **Android Studio** named **`User Input`** (name should me absolute because in `MainActivity.java` the imported package name is **userinput**)
- Add the below `XML` code in `activity_main.xml` of your project.

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:layout_margin="10dp"
    android:gravity="center_horizontal"
    tools:context=".MainActivity" >

    <!-- Title TextView for user input section -->
    <TextView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:textSize="25dp"
        android:textAlignment="center"
        android:text="User Input"
        android:layout_margin="10dp" />

    <!-- EditText for user input -->
    <EditText
        android:id="@+id/input"
        android:layout_width="300dp"
        android:layout_height="50dp"
        android:hint="Enter your name"
        android:textSize="25dp" />

    <!-- Button to submit user input -->
    <Button
        android:layout_width="100dp"
        android:layout_height="48dp"
        android:text="Submit"
        android:layout_margin="10dp"
        android:id="@+id/submit" />

    <!-- TextView to display output or greeting -->
    <TextView
        android:id="@+id/output"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:textSize="25dp"
        android:hint="Greeting"
        android:textAlignment="center"
        android:layout_margin="10dp" />
</LinearLayout>


```

- Now add the below `Java` code in `MainActivity.java` of your project.

```java
package com.example.userinput;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the EditText, TextView, and Button views in the layout
        EditText input = findViewById(R.id.input);
        TextView output = findViewById(R.id.output);
        Button submitBtn = findViewById(R.id.submit);

        // Set a click listener on the submit button
        submitBtn.setOnClickListener(view -> {
            // Get the text from the EditText and concatenate it with "Hello"
            String inputText = "Hello " + input.getText().toString();
            // Set the concatenated text to the TextView
            output.setText(inputText);
        });
    }
}


```

That's it now save the both files and run the app!

> [!NOTE]
> Make sure to check the package name in the java file `package com.example.userinput;` if you got another name other than `userinput` make sure to replace the first line of the code with yours.
