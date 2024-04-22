# Android Views

> Develop a program to implement List View, Grid View, Image View and Scroll View.

- Create a new project in **Android Studio** named **Android Views** (name should me absolute because in `MainActivity.java` the imported package name is **androidviews**)
- Add the below `XML` code in `activity_main.xml` of your project.

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!-- This is the main layout file for the activity. -->
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <!-- This is a ScrollView that contains all the views. -->
    <ScrollView
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:layout_margin="10dp">

        <!-- This is a LinearLayout that contains all the child views. -->
        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:orientation="vertical">

            <!-- This is a TextView that displays the title "Android Views". -->
            <TextView
                android:layout_width="match_parent"
                android:layout_height="50dp"
                android:text="Android Views"
                android:textSize="25sp"
                android:textColor="#ffffff"
                android:gravity="center"
                android:background="@color/black"/>

            <!-- This is a TextView that displays the title "List View". -->
            <TextView
                android:layout_width="match_parent"
                android:layout_height="40dp"
                android:layout_margin="10dp"
                android:text="List View"
                android:textSize="20dp"
                android:textAlignment="center"/>

            <!-- This is a ListView that displays a list of items. -->
            <ListView
                android:id="@+id/listView"
                android:layout_width="match_parent"
                android:layout_height="750dp" />

            <!-- This is a TextView that displays the title "Grid View". -->
            <TextView
                android:layout_width="match_parent"
                android:layout_height="40dp"
                android:layout_margin="10dp"
                android:text="Grid View"
                android:textSize="20dp"
                android:textAlignment="center"/>

            <!-- This is a GridView that displays a grid of items. -->
            <GridView
                android:id="@+id/gridView"
                android:layout_width="match_parent"
                android:layout_height="240dp"
                android:numColumns="3"
                android:layout_below="@id/listView" />

            <!-- This is a TextView that displays the title "Image View". -->
            <TextView
                android:layout_width="match_parent"
                android:layout_height="40dp"
                android:layout_margin="10dp"
                android:text="Image View"
                android:textSize="20dp"
                android:textAlignment="center"/>

            <!-- This is an ImageView that displays an image. -->
            <ImageView
                android:id="@+id/imageView"
                android:layout_width="match_parent"
                android:layout_height="130dp"
                android:src="@drawable/ic_launcher_foreground"
                android:layout_below="@id/gridView" />

        </LinearLayout>
    </ScrollView>

</RelativeLayout>

```

- Now add the below `Java` code in `MainActivity.java` of your project.

```java
package com.example.androidviews;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    String[] data = {
            "Item 1",
            "Item 2",
            "Item 3",
            "Item 4",
            "Item 5",
            "Item 6",
            "Item 7",
            "Item 8",
            "Item 9",
            "Item 10",
            "Item 11",
            "Item 12",
            "Item 13",
            "Item 14",
            "Item 15"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // List View
        ListView listView = findViewById(R.id.listView);
        ArrayAdapter<String> listAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                data
        );
        listView.setAdapter(listAdapter);

        // Grid View
        GridView gridView = findViewById(R.id.gridView);
        ArrayAdapter<String> gridAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                data
        );
        gridView.setAdapter(gridAdapter);
    }
}

```

That's it now save the both files and run app!

> **Note** :make sure to check the package name in java file `package com.example.androidviews;` if you got another name other than `androidviews` make sure to replace the first line of the code with yours.
