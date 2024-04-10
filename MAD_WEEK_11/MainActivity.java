package com.example.meetingschedule;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

// MainActivity class for the Meeting Schedule app
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Enable edge-to-edge display
        EdgeToEdge.enable(this);

        // Set the layout for the activity
        setContentView(R.layout.activity_main);

        // Set up the OnApplyWindowInsetsListener to adjust padding for system bars
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize UI elements
        TextView output = findViewById(R.id.output);
        Button dateBtn = findViewById(R.id.dateBtn);
        Button timeBtn = findViewById(R.id.timeBtn);
        Button submit = findViewById(R.id.submit);
        DatePicker datePicker = findViewById(R.id.datePicker);
        TimePicker timePicker = findViewById(R.id.timePicker);

        // Hide the DatePicker, TimePicker, and Output TextView initially
        datePicker.setVisibility(View.GONE);
        timePicker.setVisibility(View.GONE);
        output.setVisibility(View.GONE);

        // Set up the OnClickListener for the Date Button to show the DatePicker
        dateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePicker.setVisibility(View.VISIBLE);
            }
        });

        // Set up the OnClickListener for the Time Button to show the TimePicker
        timeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timePicker.setVisibility(View.VISIBLE);
            }
        });

        // Set up the OnClickListener for the Submit Button to display the selected time
        // and date
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                output.setVisibility((View.VISIBLE));
                String info = "Meeting time picked: " + timePicker.getHour() + ":" + timePicker.getMinute() +
                        "\nMeeting date picked: " + datePicker.getDayOfMonth() + "/" + (datePicker.getMonth() + 1) + "/"
                        + datePicker.getYear();
                output.setText(info);
            }
        });
    }
    // By AVidhanR
}
