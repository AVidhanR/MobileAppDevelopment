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
