# Custom Toast Alert

> Develop a program to implement Custom Toast Alert.

- Create a new project in **Android Studio** named **Custom Toast** (name should me absolute because in `MainActivity.java` the imported package name is **customtoast**)
- Add the below `XML` code in `activity_main.xml` of your project.

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:gravity="center_horizontal">
<!--    android:gravity="center">-->
    <TextView
        android:layout_width="match_parent"
        android:layout_height="50dp"
        android:text="Custom Toast Alert"
        android:textAlignment="center"
        android:layout_margin="10dp"
        android:background="@color/black"
        android:textColor="@color/white"
        android:textSize="25dp"
        android:padding="10dp"/>
    <Button
        android:id="@+id/toastBtn"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Custom Toast" />

</LinearLayout>

```

- Now add the below `Java` code in `MainActivity.java` of your project.

```java
package com.example.customtoast;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button toastBtn = findViewById(R.id.toastBtn);
        toastBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Show toast message
                Toast.makeText(
                        MainActivity.this,
                        "Button clicked!",
                        Toast.LENGTH_SHORT
                ).show();
            }
        });
    }
}

```

That's it now save the both files and run app!

> **Note** :make sure to check the package name in java file `package com.example.customtoast;` if you got another name other than `customtoast` make sure to replace the first line of the code with yours.
