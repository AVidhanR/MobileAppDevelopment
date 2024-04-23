# Android Table and Grid Layouts

> Design an Android application program that demonstrates the following: Table Layout and Grid Layout

- Create a new project in **Android Studio** named **`Table And Grid Layout`** (name should me absolute because in `MainActivity.java` the imported package name is **tableandgridlayout**)
- Add the below `XML` code in `activity_main.xml` of your project.

```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/main"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity" >

    <!-- ScrollView to enable scrolling if the content exceeds the screen size -->
    <ScrollView
        android:layout_width="match_parent"
        android:layout_height="match_parent" >

        <!-- LinearLayout to hold the TableLayout and GridLayout -->
        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:orientation="vertical"
            android:gravity="center_horizontal">

            <!-- TableLayout Example -->
            <TableLayout
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                android:layout_margin="10dp">

                <!-- TextView for the title -->
                <TextView android:layout_width="match_parent"
                    android:layout_height="50dp"
                    android:text="Table Layout"
                    android:textAlignment="center"
                    android:textSize="20dp"
                    android:padding="10dp"
                    android:background="@color/black"
                    android:textColor="@color/white"/>

                <!-- TableRow with a single TextView -->
                <TableRow
                    android:layout_width="353dp"
                    android:layout_height="match_parent"
                    android:layout_marginTop="30dp">
                    <TextView
                        android:layout_width="match_parent"
                        android:layout_height="55dp"
                        android:padding="10dp"
                        android:layout_weight="1"
                        android:text="Row_1"
                        android:textAlignment="center"
                        android:background="#D3D3D3" />
                </TableRow>

                <!-- TableRow with two TextViews -->
                <TableRow android:layout_marginTop="30dp">
                    <TextView
                        android:layout_width="match_parent"
                        android:layout_height="55dp"
                        android:padding="10dp"
                        android:layout_weight="1"
                        android:text="Row_2\nCol_1"
                        android:textAlignment="center"
                        android:layout_marginEnd="10dp"
                        android:background="#D3D3D3" />
                    <TextView
                        android:layout_width="match_parent"
                        android:layout_height="55dp"
                        android:padding="10dp"
                        android:layout_weight="2"
                        android:text="Row_2\nCol_2"
                        android:textAlignment="center"
                        android:background="#D3D3D3" />
                </TableRow>

                <!-- TableRow with three TextViews -->
                <TableRow android:layout_marginTop="30dp">
                    <TextView
                        android:layout_width="match_parent"
                        android:layout_height="55dp"
                        android:padding="10dp"
                        android:layout_weight="1"
                        android:text="Row_3\nCol_1"
                        android:textAlignment="center"
                        android:layout_marginEnd="10dp"
                        android:background="#D3D3D3" />
                    <TextView
                        android:layout_width="match_parent"
                        android:layout_height="55dp"
                        android:padding="10dp"
                        android:layout_weight="1"
                        android:text="Row_3\nCol_2"
                        android:textAlignment="center"
                        android:layout_marginEnd="10dp"
                        android:background="#D3D3D3" />
                    <TextView
                        android:layout_width="match_parent"
                        android:layout_height="55dp"
                        android:padding="10dp"
                        android:layout_weight="1"
                        android:text="Row_3\nCol_3"
                        android:textAlignment="center"
                        android:background="#D3D3D3" />
                </TableRow>

                <!-- TableRow with a single TextView -->
                <TableRow android:layout_marginTop="30dp">
                    <TextView
                        android:layout_width="match_parent"
                        android:layout_height="55dp"
                        android:padding="10dp"
                        android:layout_weight="1"
                        android:text="Row_4"
                        android:textAlignment="center"
                        android:background="#D3D3D3" />
                </TableRow>

            </TableLayout>

            <!-- TextView for the title -->
            <TextView android:layout_width="match_parent"
                android:layout_margin="10dp"
                android:layout_height="50dp"
                android:text="Grid Layout"
                android:textAlignment="center"
                android:textSize="20dp"
                android:padding="10dp"
                android:background="@color/black"
                android:textColor="@color/white" />

            <!-- GridLayout Example -->
            <androidx.gridlayout.widget.GridLayout
                xmlns:android="http://schemas.android.com/apk/res/android"
                xmlns:app="http://schemas.android.com/apk/res-auto"
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                app:columnCount="3"
                android:layout_gravity="center_horizontal">

                <!-- Button with text "Item 1" -->
                <Button
                    android:text="Item 1"
                    android:layout_width="100dp"
                    android:layout_height="48dp"
                    android:layout_margin="10dp" />

                <!-- Button with text "Item 2" -->
                <Button
                    android:text="Item 2"
                    android:layout_width="100dp"
                    android:layout_height="48dp"
                    android:layout_margin="10dp" />

                <!-- Button with text "Item 3" -->
                <Button
                    android:text="Item 3"
                    android:layout_width="100dp"
                    android:layout_height="48dp"
                    android:layout_margin="10dp" />

                <!-- Button with text "Item 4" -->
                <Button
                    android:text="Item 4"
                    android:layout_width="100dp"
                    android:layout_height="48dp"
                    android:layout_margin="10dp" />

                <!-- Button with text "Item 5" -->
                <Button
                    android:text="Item 5"
                    android:layout_width="100dp"
                    android:layout_height="48dp"
                    android:layout_margin="10dp" />

            </androidx.gridlayout.widget.GridLayout>
        </LinearLayout>
    </ScrollView>

</androidx.constraintlayout.widget.ConstraintLayout>

```

- Now add the below `Java` code in `MainActivity.java` of your project.

```java
package com.example.tableandgridlayout;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Call the superclass onCreate method
        super.onCreate(savedInstanceState);

        // Set the content view to the activity_main layout
        setContentView(R.layout.activity_main);
    }
}

```

That's it now save the both files and run the app!

> **Note** :make sure to check the package name in java file `package com.example.tableandgridlayout;` if you got another name other than `tableandgridlayout` make sure to replace the first line of the code with yours.
