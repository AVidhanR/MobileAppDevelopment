# Android Buttons

> Develop a program to implement Button, Image Button and Toggle Button.

- Create a new project in **Android Studio** named **`Android Buttons`** (name should me absolute because in `MainActivity.java` the imported package name is **androidbuttons**)
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
        android:layout_margin="10dp"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical"
        android:gravity="center_horizontal">
        <TextView
            android:layout_width="match_parent"
            android:layout_height="40dp"
            android:textColor="@color/white"
            android:background="@color/black"
            android:textAlignment="center"
            android:text="Android Buttons"
            android:textSize="25dp"
            android:layout_margin="10dp"/>

        <!-- A TextView to label the Button -->
        <TextView
            android:layout_width="match_parent"
            android:layout_height="35dp"
            android:text="Button"
            android:textAlignment="center"
            android:textSize="20dp"/>

        <!-- A standard Button -->
        <Button
            android:layout_margin="10dp"
            android:layout_width="100dp"
            android:layout_height="50dp"
            android:text="Button"
            android:textAlignment="center"
            android:id="@+id/btn" />

        <!-- A TextView to label the ImageButton -->
        <TextView
            android:layout_width="match_parent"
            android:layout_height="35dp"
            android:text="Image Button"
            android:textAlignment="center"
            android:textSize="20dp"/>

        <!-- An ImageButton with a default image -->
        <ImageButton
            android:layout_margin="10dp"
            android:id="@+id/imgBtn"
            android:contentDescription="Image Button"
            android:layout_width="150dp"
            android:layout_height="100dp"
            android:src="@drawable/ic_launcher_foreground" />

        <!-- A TextView to label the ToggleButton -->
        <TextView
            android:layout_width="match_parent"
            android:layout_height="35dp"
            android:text="Toggle Button"
            android:textAlignment="center"
            android:textSize="20dp"/>

        <!-- A ToggleButton -->
        <ToggleButton
            android:layout_margin="10dp"
            android:layout_width="100dp"
            android:layout_height="50dp"
            android:text="Toggle"
            android:textAlignment="center"
            android:id="@+id/toggleBtn" />

    </LinearLayout>

</androidx.constraintlayout.widget.ConstraintLayout>

```

- Now add the below `Java` code in `MainActivity.java` of your project.

```java
package com.example.androidbuttons;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;
import android.widget.ToggleButton;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Set the content view to the activity_main layout

        // Find the Button, ImageButton and ToggleButton views by their respective IDs
        Button btn = findViewById(R.id.btn);
        ImageButton imageBtn = findViewById(R.id.imgBtn);
        ToggleButton toggleBtn = findViewById(R.id.toggleBtn);

        // Set an OnClickListener for the Button
        btn.setOnClickListener(view -> Toast.makeText(
                MainActivity.this, // Get the current activity context
                "Button Clicked!", // Toast message
                Toast.LENGTH_SHORT // Duration of the Toast
        ).show());

        // Set an OnClickListener for the ImageButton
        imageBtn.setOnClickListener(view -> Toast.makeText(
                MainActivity.this,
                "ImageButton Clicked!",
                Toast.LENGTH_SHORT
        ).show());

        // Set an OnClickListener for the ToggleButton
        toggleBtn.setOnClickListener(view -> Toast.makeText(
                MainActivity.this,
                "ToggleButton Clicked!",
                Toast.LENGTH_SHORT
        ).show());
    }
}

```

That's it now save the both files and run the app!

> [!NOTE]
> Make sure to check the package name in the java file `package com.example.androidbuttons;` if you got another name other than `androidbuttons` make sure to replace the first line of the code with yours.
