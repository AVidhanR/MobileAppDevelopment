# Send an Email

> Develop an application to send and receive e-mail.

- Create a new project in **Android Studio** named **Email Sender** (name should me absolute because in `MainActivity.java` the imported package name is **emailsender**)
- Add the below `XML` code in `activity_main.xml` of your project.

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity"
    android:orientation="vertical"
    android:gravity="center_horizontal"
    android:layout_margin="20dp" >

    <!-- Title TextView for the Email Sender -->
    <TextView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:textSize="25sp"
        android:text="Email Sender"
        android:gravity="center_horizontal"
        android:layout_margin="10dp"/>

    <!-- EditText for entering the sender email address -->
    <EditText
        android:layout_width="300dp"
        android:layout_height="48dp"
        android:hint="Enter the sender email address"
        android:id="@+id/senderEmail"
        android:layout_margin="10dp" />

    <!-- EditText for entering the subject of the email -->
    <EditText
        android:layout_width="300dp"
        android:layout_height="48dp"
        android:hint="Enter the subject of the email"
        android:id="@+id/emailSubject"
        android:layout_margin="10dp" />

    <!-- EditText for entering the body of the email -->
    <EditText
        android:layout_width="300dp"
        android:layout_height="48dp"
        android:hint="Enter the body of the email"
        android:id="@+id/emailBody"
        android:layout_margin="10dp" />

    <!-- Button to send the email -->
    <Button
        android:layout_width="wrap_content"
        android:layout_height="48dp"
        android:text="Send Email"
        android:id="@+id/sendEmailBtn"
        android:layout_margin="10dp" />

<!--    Created by AVidhanR -->
</LinearLayout>

```

- Now add the below `Java` code in `MainActivity.java` of your project.

```java
package com.example.emailsender;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the EditText views for the sender email, subject, and body
        EditText senderEmail = findViewById(R.id.senderEmail);
        EditText emailSubject = findViewById(R.id.emailSubject);
        EditText emailBody = findViewById(R.id.emailBody);

        // Find the send email button
        Button sendEmailBtn = findViewById(R.id.sendEmailBtn);

        // Set an OnClickListener for the send email button
        sendEmailBtn.setOnClickListener(view -> {
            // Get the text from the EditText views
            String sendTo = senderEmail.getText().toString();
            String subject = emailSubject.getText().toString();
            String body = emailBody.getText().toString();

            // Create a new Intent with the ACTION_SEND action
            Intent intent = new Intent(Intent.ACTION_SEND);

            // Set the MIME type of the Intent to "message/rfc822" to indicate that it's an email
            intent.setType("message/rfc822");

            // Add the recipient email address to the Intent using the EXTRA_EMAIL key
            intent.putExtra(Intent.EXTRA_EMAIL, new String[]{sendTo});
            // Add the email subject to the Intent using the EXTRA_SUBJECT key
            intent.putExtra(Intent.EXTRA_SUBJECT, subject);
            // Add the email body to the Intent using the EXTRA_TEXT key
            intent.putExtra(Intent.EXTRA_TEXT, body);

            // Start the activity to send the email, using the createChooser method to show the user a list of available email apps
            startActivity(
                    Intent.createChooser(intent, "Send Email")
            );
        });
    }
    // Created By AVidhanR
}

```

That's it now save the both files and run the app!

> **Note** :make sure to check the package name in java file `package com.example.emailsender;` if you got another name other than `emailsender` make sure to replace the first line of the code with yours.
