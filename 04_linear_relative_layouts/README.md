# Android Relative and Linear Layouts

> Design an Android application program that demonstrates the following: Table Layout and Grid Layout

- Create a new project in **Android Studio** named **`Linear and Relative Layout`** (name should me absolute because in `MainActivity.java` the imported package name is **linearandrelativelayout**)
- Add the below `XML` code in `activity_main.xml` of your project.

```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/main"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <!-- ScrollView to enable scrolling if the content exceeds the screen size -->
    <ScrollView
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:layout_margin="10dp">

        <!-- LinearLayout to hold the UI elements -->
        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:orientation="vertical"
            android:gravity="center_horizontal">

            <!-- TextView for the title -->
            <TextView
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:text="Relative Layout"
                android:textAlignment="center"
                android:textSize="25dp"
                android:padding="10dp" />

            <!-- RelativeLayout example -->
            <RelativeLayout
                android:layout_width="match_parent"
                android:layout_height="100dp"
                android:gravity="center_horizontal">
                <Button
                    android:id="@+id/item1"
                    android:layout_width="100dp"
                    android:layout_height="48dp"
                    android:text="Item 1" />
                <Button
                    android:id="@+id/item2"
                    android:layout_width="100dp"
                    android:layout_height="48dp"
                    android:text="Item 2"
                    android:layout_below="@+id/item1" />
                <Button
                    android:id="@+id/item3"
                    android:layout_width="100dp"
                    android:layout_height="48dp"
                    android:text="Item 3"
                    android:layout_toRightOf="@id/item2"/>
            </RelativeLayout>

            <!-- TextView for the title -->
            <TextView
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:text="Linear Layout Vertical Orientation"
                android:textAlignment="center"
                android:textSize="25dp"
                android:padding="10dp" />

            <!-- LinearLayout with vertical orientation -->
            <LinearLayout
                android:layout_width="match_parent"
                android:layout_height="150dp"
                android:orientation="vertical"
                android:gravity="center_horizontal">
                <Button
                    android:layout_width="100dp"
                    android:layout_height="48dp"
                    android:text="Item 4" />
                <Button
                    android:layout_width="100dp"
                    android:layout_height="48dp"
                    android:text="Item 5" />
                <Button
                    android:layout_width="100dp"
                    android:layout_height="48dp"
                    android:text="Item 6" />
            </LinearLayout>

            <!-- TextView for the title -->
            <TextView
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:text="Linear Layout Horizontal Orientation"
                android:textAlignment="center"
                android:textSize="25dp"
                android:padding="10dp" />

            <!-- LinearLayout with horizontal orientation -->
            <LinearLayout
                android:layout_width="match_parent"
                android:layout_height="80dp"
                android:orientation="horizontal"
                android:gravity="center_horizontal">
                <Button
                    android:layout_width="100dp"
                    android:layout_height="48dp"
                    android:text="Item 7" />
                <Button
                    android:layout_width="100dp"
                    android:layout_height="48dp"
                    android:text="Item 8" />
                <Button
                    android:layout_width="100dp"
                    android:layout_height="48dp"
                    android:text="Item 9" />
            </LinearLayout>

        </LinearLayout>
    </ScrollView>
</androidx.constraintlayout.widget.ConstraintLayout>

```

- Now add the below `Java` code in `MainActivity.java` of your project.

```java
package com.example.linearandrelativelayout;

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

> [!NOTE] 
> Make sure to check the package name in the java file `package com.example.linearandrelativelayout;` if you got another name other than `linearandrelativelayout` make sure to replace the first line of the code with yours.
