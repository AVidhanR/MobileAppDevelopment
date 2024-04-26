> MainActivitty.java

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

        userPhoneNumber = findViewById(R.id.phoneNumber);
        userMessage = findViewById(R.id.message);
        Button sendButton = findViewById(R.id.sendBtn);

        sendButton.setOnClickListener(v -> sendSMS());

        // Check SMS permission
        if (
                checkSelfPermission(
                        Manifest.permission.SEND_SMS
                ) != PackageManager.PERMISSION_GRANTED
        ) {
            // Request permission
            requestPermissions(
                    new String[]{Manifest.permission.SEND_SMS},
                    PERMISSION_REQUEST_CODE
            );
        }
    }

    private void sendSMS() {
        String phoneNumber = userPhoneNumber.getText().toString();
        String message = userMessage.getText().toString();

        try {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(
                    phoneNumber,
                    null,
                    message,
                    null,
                    null
            );
            Toast.makeText(
                    getApplicationContext(),
                    "SMS sent.",
                    Toast.LENGTH_LONG
            ).show();
        } catch (Exception e) {
            Toast.makeText(
                    getApplicationContext(),
                    "Failed to send SMS.",
                    Toast.LENGTH_LONG
            ).show();
            e.printStackTrace();
        }
    }

    @Override
    public void onRequestPermissionsResult(
            int requestCode,
            @NonNull String[] permissions,
            @NonNull int[] grantResults
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (
                requestCode == PERMISSION_REQUEST_CODE &&
                grantResults.length > 0 &&
                grantResults[0] == PackageManager.PERMISSION_GRANTED)
        {
            Toast.makeText(
                    getApplicationContext(),
                    "Permission granted.",
                    Toast.LENGTH_LONG
            ).show();
        } else {
            Toast.makeText(
                    getApplicationContext(),
                    "Permission denied.",
                    Toast.LENGTH_LONG
            ).show();
        }
    }
}
```

> activity_main.xml

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

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="SMS Sender"
        android:textSize="20dp"
        android:textAlignment="center"
        android:layout_margin="10dp" />

    <EditText
        android:id="@+id/phoneNumber"
        android:inputType="number"
        android:layout_width="200dp"
        android:layout_height="wrap_content"
        android:hint="Phone Number" />

    <EditText
        android:id="@+id/message"
        android:inputType="text"
        android:layout_width="200dp"
        android:layout_height="wrap_content"
        android:hint="Message" />

    <Button
        android:id="@+id/sendBtn"
        android:layout_width="150dp"
        android:layout_height="wrap_content"
        android:text="Send SMS"
        android:layout_margin="10dp" />

</LinearLayout>
```

> In AndroidManifest.xml (Just add these below lines don't remove all and paste it)

```xml
<uses-feature
        android:name="android.hardware.telephony"
        android:required="true" />
    <uses-permission android:name="android.permission.SEND_SMS" />
    <uses-permission android:name="android.permission.READ_PHONE_STATE" />
    <uses-permission android:name="android.permission.READ_CONTACTS" />
```
