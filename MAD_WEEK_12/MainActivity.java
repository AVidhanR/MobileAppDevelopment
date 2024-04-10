package com.example.notificationconcept;

import android.Manifest;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;

// MainActivity class that demonstrates the notification concept.
public class MainActivity extends AppCompatActivity {

    // Constant string for the notification channel ID.
    private static final String CHANNEL_ID = "my_channel_id";

    // Constant string for the notification channel description.
    private static final String CHANNEL_DESCRIPTION = "my channel description";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Check for the POST_NOTIFICATIONS permission for devices with Android 13 and
        // above.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (ContextCompat.checkSelfPermission(
                    MainActivity.this,
                    Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(
                        MainActivity.this,
                        new String[] { Manifest.permission.POST_NOTIFICATIONS }, 101);
            }
        }

        // Get the start button from the layout and set an OnClickListener to display
        // the notification.
        Button start = findViewById(R.id.start);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayNotification();
            }
        });
    }

    // Method to display the notification.
    public void displayNotification() {
        // Create a NotificationCompat.Builder object to build the notification.
        NotificationCompat.Builder myBuilder = new NotificationCompat.Builder(getApplicationContext(), CHANNEL_ID);

        // Set the content title, text, priority, small icon, and auto-cancel flag for
        // the notification.
        myBuilder.setContentTitle("Notification Title 🔔")
                .setContentText("Notification content goes here 💬")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setSmallIcon(R.drawable.notification)
                .setAutoCancel(true);

        /**
         * Get the NotificationManager service and create a notification channel
         * if the device is running Android 8.0 or higher.
         */
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            // Get the existing notification channel, if any.
            NotificationChannel notificationChannel = notificationManager.getNotificationChannel(CHANNEL_ID);

            // If the notification channel does not exist, create a new one.
            if (notificationChannel == null) {
                int importance = NotificationManager.IMPORTANCE_HIGH;

                /**
                 * Create a new notification channel with the specified ID, name,
                 * importance, light color, and vibration settings.
                 */
                notificationChannel = new NotificationChannel(CHANNEL_ID, CHANNEL_DESCRIPTION, importance);
                notificationChannel.setLightColor(Color.GREEN);
                notificationChannel.enableVibration(true);

                // Create the notification channel.
                notificationManager.createNotificationChannel(notificationChannel);
            }
        }
        // Notify the user with the notification.
        notificationManager.notify(0, myBuilder.build());
    }
    // By AVidhanR
}