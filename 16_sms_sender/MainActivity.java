package com.example.smssender;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final int PERMISSION_REQUEST_CODE = 1;
    private EditText userPhoneNumber, userMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the UI elements
        userPhoneNumber = findViewById(R.id.phoneNumber);
        userMessage = findViewById(R.id.message);
        Button sendButton = findViewById(R.id.sendBtn);

        // Set a click listener for the send button
        sendButton.setOnClickListener(view -> sendSMS());

        // Check if the app has the SEND_SMS permission
        if (checkSelfPermission(Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {
            // Request the SEND_SMS permission if it's not granted
            requestPermissions(new String[] { Manifest.permission.SEND_SMS }, PERMISSION_REQUEST_CODE);
        }
    }

    // Method to send the SMS
    private void sendSMS() {
        // Get the phone number and message from the UI
        String phoneNumber = userPhoneNumber.getText().toString();
        String message = userMessage.getText().toString();

        try {
            // Get the default SmsManager
            SmsManager smsManager = SmsManager.getDefault();
            // Send the SMS message
            smsManager.sendTextMessage(phoneNumber, null, message, null, null);
            // Show a success message
            Toast.makeText(getApplicationContext(), "SMS sent.", Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            // Show an error message if the SMS sending fails
            Toast.makeText(getApplicationContext(), "Failed to send SMS.", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
            @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        // Handle the result of the SEND_SMS permission request
        if (requestCode == PERMISSION_REQUEST_CODE && grantResults.length > 0
                && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            // Permission granted, show a success message
            Toast.makeText(getApplicationContext(), "Permission granted.", Toast.LENGTH_LONG).show();
        } else {
            // Permission denied, show an error message
            Toast.makeText(getApplicationContext(), "Permission denied.", Toast.LENGTH_LONG).show();
        }
    }
}
