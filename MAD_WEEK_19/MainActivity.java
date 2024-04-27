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