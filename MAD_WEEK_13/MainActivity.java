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