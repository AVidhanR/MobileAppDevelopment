package com.example.customtoast;

import android.os.Bundle;
import android.widget.Toast;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button toastBtn = findViewById(R.id.toastBtn);
        toastBtn.setOnClickListener(v -> {
            // Show toast message
            Toast.makeText(
                    MainActivity.this,
                    "Button clicked!",
                    Toast.LENGTH_SHORT
            ).show();
        });
    }
}