# Login With Disable

- Create a new project in **Android Studio** named **Login With Disable** (name should me absolute because in `MainActivity.java` the imported package name is **loginwithdisable**)
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
                android:text="Login Module with disable"
                android:textAlignment="center"
                android:textSize="28dp"
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
        </LinearLayout>
    </ScrollView>

</androidx.constraintlayout.widget.ConstraintLayout>

```

- Now add the below `Java` code in `MainActivity.java` of your project.

```java
package com.example.loginwithdisable;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import org.jetbrains.annotations.NotNull;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the login button, username and password EditTexts
        Button loginBtn = findViewById(R.id.login);
        EditText userName = findViewById(R.id.userName);
        EditText password = findViewById(R.id.password);

        // Add TextWatchers to the username and password EditTexts
        userName.addTextChangedListener(textWatcher);
        password.addTextChangedListener(textWatcher);

        // Set an OnClickListener on the login button
        loginBtn.setOnClickListener(view -> {
            String username = userName.getText().toString();
            String pwd = password.getText().toString();

            // Validate the username and password
            if (validateUsernameAndPassword(username, pwd)) {

                // If the credentials are valid, show a success toast message
                Toast.makeText(
                        MainActivity.this,
                        "Login Successful",
                        Toast.LENGTH_SHORT
                ).show();
            }
        });
    }

    // Helper method to validate the username and password
    public boolean validateUsernameAndPassword(@NotNull String u, @NotNull String p) {

        // Here, we're hardcoding the valid username and password
        // You can change these to your own values
        return u.equals("AVidhanR") && p.equals("vinnu");
    }

    // TextWatcher to enable/disable the login button
    private final TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            // Do nothing, required method
        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            // Do nothing, required method
        }

        @Override
        public void afterTextChanged(Editable editable) {

            // Find the login button, username and password EditTexts
            // Can't take them globally due various reasons
            Button loginBtn = findViewById(R.id.login);
            EditText userName = findViewById(R.id.userName);
            EditText password = findViewById(R.id.password);

            // Get the current values of the username and password fields
            String username = userName.getText().toString();
            String pwd = password.getText().toString();

            // Enable the login button only if the username and password are valid
            loginBtn.setEnabled(validateUsernameAndPassword(username, pwd));
        }
    };
    // By AVidhanR

}
```

That's it now save the both files and run app!

> **Note** :make sure to check the package name in java file `package com.example.loginwithdisable;` if you got another name other than `loginwithdisable` make sure to replace the first line of the code with yours.
