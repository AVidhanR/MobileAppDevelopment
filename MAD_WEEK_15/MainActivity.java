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
                        Toast.LENGTH_SHORT).show();
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