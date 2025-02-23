### Attend a Meeting

> Develop an android application which asks the user pick a time and date to attend a meeting (Use Date and Time Picker) and display it back to user on clicking on submit button.

- Create a new project in **Android Studio** named **Meeting Schedule** (name should me absolute because in `MainActivity.java` the imported package name is **meetingschedule**)
- Add the below `XML` code in `activity_main.xml` of your project.

```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/main"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <!-- ScrollView to allow scrolling through the layout -->
    <ScrollView
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        tools:ignore="MissingConstraints"
        tools:layout_editor_absoluteX="1dp"
        tools:layout_editor_absoluteY="1dp">

        <!-- LinearLayout to stack UI - vertically -->
        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:orientation="vertical"
            android:layout_margin="10dp"
            android:gravity="center_horizontal">

            <!-- Title TextView -->
            <TextView
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                android:textAlignment="center"
                android:text="Attend a meeting"
                android:textSize="30dp"
                android:textColor="@color/white"
                android:background="@color/black" />

            <!-- LinearLayout to stack UI - horizontally -->
            <LinearLayout
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                android:orientation="vertical"
                android:gravity="center_horizontal">

                <!-- Pick time TextView -->
                <TextView
                    android:layout_width="match_parent"
                    android:layout_height="35dp"
                    android:layout_margin="10dp"
                    android:text="Pick time"
                    android:textAlignment="center"
                    android:textSize="25dp" />

                <!-- TimePicker button -->
                <Button
                    android:id="@+id/timeBtn"
                    android:layout_width="130dp"
                    android:layout_height="50dp"
                    android:text="Time picker" />

                <!-- TimePicker widget -->
                <TimePicker
                    android:id="@+id/timePicker"
                    android:layout_width="300dp"
                    android:layout_height="400dp"
                    android:layout_margin="10dp"
                    android:visibility="gone" />
            </LinearLayout>

            <!-- LinearLayout to stack UI - horizontally -->
            <LinearLayout
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                android:orientation="vertical"
                android:gravity="center_horizontal">

                <!-- Pick date TextView -->
                <TextView
                    android:layout_width="match_parent"
                    android:layout_height="35dp"
                    android:layout_margin="10dp"
                    android:text="Pick date"
                    android:textAlignment="center"
                    android:textSize="25dp" />

                <!-- DatePicker button -->
                <Button
                    android:id="@+id/dateBtn"
                    android:layout_width="130dp"
                    android:layout_height="50dp"
                    android:text="Date picker" />

                <!-- DatePicker widget -->
                <DatePicker
                    android:id="@+id/datePicker"
                    android:layout_width="300dp"
                    android:layout_height="400dp"
                    android:layout_margin="10dp"
                    android:visibility="gone"/>
            </LinearLayout>

            <!-- LinearLayout to stack UI - horizontally -->
            <LinearLayout
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                android:orientation="vertical"
                android:gravity="center_horizontal">

                <!-- Instructions TextView -->
                <TextView
                    android:layout_width="match_parent"
                    android:layout_height="match_parent"
                    android:text="Click the below button to reveal the meeting time and date you picked."
                    android:textSize="20dp"
                    android:textAlignment="center"
                    android:padding="15dp" />

                <!-- Submit button -->
                <Button
                    android:layout_width="130dp"
                    android:layout_height="50dp"
                    android:id="@+id/submit"
                    android:text="Submit" />
            </LinearLayout>

            <!-- Output TextView -->
            <TextView
                android:id="@+id/output"
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                android:textSize="20dp"
                android:visibility="gone"
                android:padding="20dp"/>
        </LinearLayout>
    </ScrollView>
    <!-- By AVidhanR -->
</androidx.constraintlayout.widget.ConstraintLayout>
```

- Now add the below `Java` code in `MainActivity.java` of your project.

```java
package com.example.meetingschedule;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import androidx.appcompat.app.AppCompatActivity;

// MainActivity class for the Meeting Schedule app
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the layout for the activity
        setContentView(R.layout.activity_main);

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

        // Set up the OnClickListener for the Submit Button to display the selected time and date
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                output.setVisibility(View.VISIBLE);
                String info = "Meeting time picked: " + timePicker.getHour() + ":" + timePicker.getMinute() +
                        "\nMeeting date picked: " + datePicker.getDayOfMonth() + "/" + (datePicker.getMonth() + 1) + "/" + datePicker.getYear();
                output.setText(info);
            }
        });
    }
    //By AVidhanR
}
```

That's it now save the both files and run the app!

> [!NOTE]
> Make sure to check the package name in the java file `package com.example.meetingschedule;` if you got another name other than `meetingschedule` make sure to replace the first line of the code with yours.
