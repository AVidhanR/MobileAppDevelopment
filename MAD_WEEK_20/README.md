# Get GPS Location Information

> Develop a native application that uses GPS location information.

- Create a new project in **Android Studio** named **GPS Location** (name should me absolute because in `MainActivity.java` the imported package name is **gpslocation**)
- Add the below `XML` code in `activity_main.xml` of your project.

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:gravity="center_horizontal"
    android:layout_margin="20dp"
    tools:context=".MainActivity"
    tools:ignore="ExtraText" >

    <!-- Title TextView to display "GPS Location" -->
    <TextView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:textSize="25dp"
        android:text="GPS Location"
        android:textAlignment="center"
        android:layout_margin="10dp" />

    <!-- TextView to display the GPS location output -->
    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:id="@+id/getGPSLocationView"
        android:textSize="20dp"
        android:hint="GPS Location Output"
        android:layout_margin="10dp" />

    <!-- Button to trigger the GPS location retrieval -->
    <Button
        android:layout_width="wrap_content"
        android:layout_height="48dp"
        android:text="Get Location"
        android:layout_margin="10dp"
        android:id="@+id/getGPSLocationBtn" />

    <!--    Created By AVidhanR-->

</LinearLayout>

```

- Now add the below `Java` code in `MainActivity.java` of your project.

```java
package com.example.gpslocation;

import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import android.Manifest;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public int GPS_REQUEST_CODE = 123;
    private LocationManager locationManager;
    private LocationListener locationListener;
    public String info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize TextView and Button
        TextView gpsLocationView = findViewById(R.id.getGPSLocationView);
        Button gpsLocationBtn = findViewById(R.id.getGPSLocationBtn);

        // Get the LocationManager system service
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        // Define the LocationListener for handling location updates
        locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(@NonNull Location location) {
                // Update the 'info' string with latitude and longitude
                info = "Latitude: " + location.getLatitude() +
                        "\nLongitude: " + location.getLongitude();
            }
            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {
                // Handle changes in location provider status
                // Mandatory Methods Do nothing
            }
            @Override
            public void onProviderEnabled(@NonNull String provider) {
                // Handle when the location provider is enabled
                // Mandatory Methods Do nothing
            }
            @Override
            public void onProviderDisabled(@NonNull String provider) {
                // Handle when the location provider is disabled
                // Mandatory Methods Do nothing
            }
        };

        // Request location updates if permission is granted, else request permission
        if (
            ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
            != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                    this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    GPS_REQUEST_CODE
            );
        } else {
            locationManager.requestLocationUpdates(
                    LocationManager.GPS_PROVIDER,
                    0, 0,
                    locationListener
            );
        }

        // Set a click listener for the button to display location info
        gpsLocationBtn.setOnClickListener(view -> gpsLocationView.setText(info));
    }

    @Override
    public void onRequestPermissionsResult(
            int requestCode,
            @NonNull String[] permissions,
            @NonNull int[] grantResults
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        // Handle permission request result for accessing fine location
        if (requestCode == GPS_REQUEST_CODE) {
            if (
                    grantResults.length > 0 &&
                    grantResults[0] == PackageManager.PERMISSION_GRANTED
            ) {
                if (
                        ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                         == PackageManager.PERMISSION_GRANTED
                ) {
                    locationManager.requestLocationUpdates(
                            LocationManager.GPS_PROVIDER,
                            0, 0,
                            locationListener
                    );
                }
            } else {
                // Display a toast message for permission denial
                Toast.makeText(
                        this,
                        "Permission Denied",
                        Toast.LENGTH_SHORT
                ).show();
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Remove location updates when the activity is destroyed
        locationManager.removeUpdates(locationListener);
    }
    // Created By AVidhanR
}

```

That's it now save the both files and run the app!

> **Note** :make sure to check the package name in java file `package com.example.gpslocation;` if you got another name other than `gpslocation` make sure to replace the first line of the code with yours.

---
