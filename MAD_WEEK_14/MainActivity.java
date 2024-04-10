package com.example.loginmodule;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the login button, username and password EditTexts, and login successful
        // TextView
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
                            Toast.LENGTH_SHORT).show();
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