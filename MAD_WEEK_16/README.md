# SMS Sender

> Design an android application to send an SMS using SMS Manager.

- Create a new project in **Android Studio** named **SMS Sender** (name should me absolute because in `MainActivity.java` the imported package name is **smssender**)
- Add the below `XML` code in `activity_main.xml` of your project.

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:layout_margin="20dp"
    android:gravity="center_horizontal"
    tools:context=".MainActivity" >

    <!-- TextView to display the title "SMS Sender" -->
    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="SMS Sender"
        android:textSize="20dp"
        android:textAlignment="center"
        android:layout_margin="10dp" />

    <!-- EditText for entering the phone number -->
    <EditText
        android:id="@+id/phoneNumber"
        android:inputType="number"
        android:layout_width="200dp"
        android:layout_height="wrap_content"
        android:hint="Phone Number" />

    <!-- EditText for entering the message -->
    <EditText
        android:id="@+id/message"
        android:inputType="text"
        android:layout_width="200dp"
        android:layout_height="wrap_content"
        android:hint="Message" />

    <!-- Button to send the SMS -->
    <Button
        android:id="@+id/sendBtn"
        android:layout_width="150dp"
        android:layout_height="wrap_content"
        android:text="Send SMS"
        android:layout_margin="10dp" />
<!-- Created By AVidhanR -->
</LinearLayout>

```

- Now add the below `Java` code in `MainActivity.java` of your project.

```java
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
            requestPermissions(new String[]{Manifest.permission.SEND_SMS}, PERMISSION_REQUEST_CODE);
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
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        // Handle the result of the SEND_SMS permission request
        if (requestCode == PERMISSION_REQUEST_CODE && grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            // Permission granted, show a success message
            Toast.makeText(getApplicationContext(), "Permission granted.", Toast.LENGTH_LONG).show();
        } else {
            // Permission denied, show an error message
            Toast.makeText(getApplicationContext(), "Permission denied.", Toast.LENGTH_LONG).show();
        }
    }
}

```

- In `AndroidManifest.xml` (**Just add these below lines** don't remove all and paste it)

```xml
<uses-feature
        android:name="android.hardware.telephony"
        android:required="true" />
    <uses-permission android:name="android.permission.SEND_SMS" />
    <uses-permission android:name="android.permission.READ_PHONE_STATE" />
    <uses-permission android:name="android.permission.READ_CONTACTS" />

```

That's it now save the above files and run the app!

> **Note** :make sure to check the package name in java file `package com.example.smssender;` if you got another name other than `smssender` make sure to replace the first line of the code with yours.
