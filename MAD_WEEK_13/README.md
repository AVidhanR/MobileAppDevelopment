# Notification Concept

- Create a new project in **Android Studio** named **Colors Menu** (name should me absolute because in `MainActivity.java` the imported package name is **colorsmenu**)
- Add the below `XML` code in `activity_main.xml` of your project.

```xml
<?xml version="1.0" encoding="utf-8"?>

<!-- RelativeLayout to organize views -->
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:id="@+id/activity_main"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <!-- Toolbar for displaying menu options -->
    <androidx.appcompat.widget.Toolbar
        android:id="@+id/toolbar"
        android:layout_width="match_parent"
        android:layout_height="60dp"
        app:title="Colors Menu"
        android:background="@color/black"
        app:titleTextColor="@color/white" />

</RelativeLayout>
```

- Now, in order to add a menu context; create a new **Android resource file** named `menu` under `res` directory.
- Create a new file named `main_menu.xml` in `menu` directory.
- Add the below `XML` code in `main_menu.xml` of your project.

```xml
<?xml version="1.0" encoding="utf-8"?>

<!-- In order to create a menu we use <menu></menu tag -->
<menu xmlns:android="http://schemas.android.com/apk/res/android">

    <!-- Red color option -->
    <item
        android:id="@+id/redItem"
        android:title="Red" />

    <!-- Green color option -->
    <item
        android:id="@+id/greenItem"
        android:title="Green" />

    <!-- Blue color option -->
    <item
        android:id="@+id/blueItem"
        android:title="Blue" />

    <!-- Black color option -->
    <item
        android:id="@+id/blackItem"
        android:title="Black" />

    <!-- Reset color option -->
    <item
        android:id="@+id/whiteItem"
        android:title="Reset" />
</menu>

```

- Now add the below `Java` code in `MainActivity.java` of your project.

```java
package com.example.colorsmenu;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    // Initialize the main layout view
    private View mainLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the toolbar and set it as the support action bar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Initialize the main layout view
        mainLayout = findViewById(R.id.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu resource file and add it to the menu object
        MenuInflater menuInflater = new MenuInflater(this);
        menuInflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem menuItem) {
        // Get the ID of the selected menu item
        int menuItemId = menuItem.getItemId();

        // Change the background color based on the selected menu item
        if (menuItemId == R.id.redItem) {
            changeBackgroundColor(Color.RED);
        } else if (menuItemId == R.id.greenItem) {
            changeBackgroundColor(Color.GREEN);
        } else if (menuItemId == R.id.blueItem) {
            changeBackgroundColor(Color.BLUE);
        } else if (menuItemId == R.id.blackItem) {
            changeBackgroundColor(Color.BLACK);
        } else if (menuItemId == R.id.whiteItem) {
            changeBackgroundColor(Color.WHITE);
        }

        // Call the superclass method to handle any additional menu item selections
        return super.onOptionsItemSelected(menuItem);
    }

    // Method to change the background color of the main layout
    private void changeBackgroundColor(int color) {
        mainLayout.setBackgroundColor(color);
    }
    // By AVidhanR
}
```

That's it now save the above files and run the app!

> **Note** :make sure to check the package name in java file `package com.example.colorsmenu;` if you got another name other than `colorsmenu` make sure to replace the first line of the code with yours.
