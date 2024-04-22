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