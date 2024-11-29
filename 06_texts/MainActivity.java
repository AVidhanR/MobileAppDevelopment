package com.example.androidtexts;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    // Array of country names for AutoCompleteTextView suggestions
    String[] countryNameList = { "India", "USA", "China", "Japan", "Russia", "Australia", "South Africa" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Set the content view to the activity_main layout

        // Find the AutoCompleteTextView, EditText, TextView, and Button views by their
        // respective IDs
        AutoCompleteTextView autoCompleteTextView = findViewById(R.id.autoCompleteTextView);
        EditText editText = findViewById(R.id.editText);
        TextView output = findViewById(R.id.output);
        Button submit = findViewById(R.id.submit);

        // Create an ArrayAdapter with the countryNameList and set it as the adapter for
        // the AutoCompleteTextView
        ArrayAdapter adapter = new ArrayAdapter(
                this,
                android.R.layout.simple_list_item_1,
                countryNameList);
        autoCompleteTextView.setAdapter(adapter);

        // Set an OnClickListener for the submit button
        submit.setOnClickListener(view -> {
            // Create a string containing the entered country name and the text typed in the
            // EditText
            String info = "County Name: " + autoCompleteTextView.getText().toString() +
                    "\nText typed in: " + editText.getText().toString();
            // Set the info string as the text of the output TextView
            output.setText(info);
        });
    }
}