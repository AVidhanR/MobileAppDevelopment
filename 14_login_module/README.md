## Login Module

> Create sample application with login module. Validate username and password, on successful login, Change TextView "Login Successful". And on login fail, alert user using Toast "Login fail".

- Create a new project in **Android Studio** named **Login Module** (name should me absolute because in `MainActivity.java` the imported package name is **loginmodule**)
- Add the below `XML` code in `activity_main.xml` of your project.

```xml
<?xml version="1.0" encoding="utf-8"?>

<!-- This is the root constraint layout for the activity -->
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/main"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <!-- This is a ScrollView to allow the user to scroll the content -->
    <ScrollView
        android:layout_width="match_parent"
        android:layout_height="match_parent" >

        <!-- This is a LinearLayout that contains all the UI elements -->
        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:orientation="vertical"
            android:gravity="center_horizontal">

            <!-- This is the title of the login module -->
            <TextView
                android:layout_width="match_parent"
                android:layout_height="70dp"
                android:text="Login Module"
                android:textAlignment="center"
                android:textSize="30dp"
                android:background="@color/black"
                android:textColor="@color/white"
                android:paddingTop="13dp" />

            <!-- This is the username input field -->
            <LinearLayout
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                android:orientation="horizontal"
                android:layout_margin="15dp"
                android:gravity="center_horizontal">
                <TextView
                    android:layout_width="130dp"
                    android:layout_height="30dp"
                    android:text="Username "
                    android:textSize="20dp" />
                <EditText
                    android:id="@+id/userName"
                    android:layout_width="200dp"
                    android:layout_height="50dp"
                    android:hint="Enter username here..."/>
            </LinearLayout>

            <!-- This is the password input field -->
            <LinearLayout
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                android:orientation="horizontal"
                android:layout_margin="15dp"
                android:gravity="center_horizontal">
                <TextView
                    android:layout_width="130dp"
                    android:layout_height="30dp"
                    android:text="Password "
                    android:textSize="20dp" />
                <EditText
                    android:id="@+id/password"
                    android:layout_width="200dp"
                    android:layout_height="50dp"
                    android:hint="Enter password here..."
                    android:inputType="textPassword" />
            </LinearLayout>

            <!-- This is the login button -->
            <Button
                android:visibility="visible"
                android:id="@+id/login"
                android:layout_width="150dp"
                android:layout_height="50dp"
                android:text="LogIn"
                android:layout_margin="15dp"
                android:textSize="20dp" />

            <!-- This is the login successful text view -->
            <TextView
                android:id="@+id/loginSuccessful"
                android:layout_width="350dp"
                android:layout_height="100dp"
                android:layout_margin="20dp"
                android:text="Login Successful"
                android:textAlignment="center"
                android:padding="10dp"
                android:textSize="25dp"
                android:visibility="gone" />
        </LinearLayout>
    </ScrollView>

</androidx.constraintlayout.widget.ConstraintLayout>

```

- Now add the below `Java` code in `MainActivity.java` of your project.

```java
package com.example.loginmodule;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import org.jetbrains.annotations.NotNull;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the login button, username and password EditTexts, and login successful TextView
        Button loginBtn = findViewById(R.id.login);
        EditText userName = findViewById(R.id.userName);
        EditText password = findViewById(R.id.password);
        TextView loginSuccessful = findViewById(R.id.loginSuccessful);

        // Set an OnClickListener on the login button
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Get the username and password entered by the user
                String username = userName.getText().toString();
                String pwd = password.getText().toString();

                // Validate the username and password
                if (validateUsernameAndPassword(username, pwd)) {

                    // If the credentials are valid, show the "Login Successful" TextView
                    loginSuccessful.setVisibility(View.VISIBLE);
                } else {

                    // If the credentials are invalid, hide the "Login Successful" TextView
                    // and show a toast message
                    loginSuccessful.setVisibility(View.GONE);
                    Toast.makeText(
                            MainActivity.this,
                            "Login fail",
                            Toast.LENGTH_SHORT
                    ).show();
                }
            }
        });
    }

    // Helper method to validate the username and password
    public boolean validateUsernameAndPassword(@NotNull String u, @NotNull String p) {

        // Here, I'm hardcoding the valid username and password you can change it guys.
        return u.equals("AVidhanR") && p.equals("vinnu");
    }

    // By AVidhanR
}
```

That's it now save the both files and run the app!

> [!NOTE]
> Make sure to check the package name in the java file `package com.example.loginmodule;` if you got another name other than `loginmodule` make sure to replace the first line of the code with yours.
