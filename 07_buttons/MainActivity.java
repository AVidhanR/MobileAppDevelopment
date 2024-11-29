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
                Toast.LENGTH_SHORT).show());

        // Set an OnClickListener for the ToggleButton
        toggleBtn.setOnClickListener(view -> Toast.makeText(
                MainActivity.this,
                "ToggleButton Clicked!",
                Toast.LENGTH_SHORT).show());
    }
}