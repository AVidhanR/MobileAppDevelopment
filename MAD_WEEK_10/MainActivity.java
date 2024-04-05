// WEEK_10 (Java Functionality Code)

package com.example.registrationform;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Spinner spin = findViewById(R.id.countries);

        // Create an ArrayList to store the items
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Andhra Pradesh");
        arrayList.add("Telangana");
        arrayList.add("Uttar Pradesh");
        arrayList.add("Tami Nadu");
        arrayList.add("Kerala");
        arrayList.add("Karnataka");

        // Create an ArrayAdapter and bind the data to the spinner
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                arrayList);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(arrayAdapter);

        EditText userName = findViewById(R.id.userName);
        EditText address = findViewById(R.id.address);
        EditText age = findViewById(R.id.age);
        DatePicker dp = findViewById(R.id.datePicker);
        // To display the output
        TextView output = findViewById(R.id.output);
        Button buttonDatePicker = findViewById(R.id.dateButton);
        dp.setVisibility(View.GONE);
        // should not show the DatePicker until, One clicked the button

        buttonDatePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dp.setVisibility(View.VISIBLE);
                // should be (DatePicker) displayed when the button is pressed
            }
        });

        // after clicking the button "Submit"
        Button submit = findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String info = "Username : " + userName.getText().toString() +
                        "\nAge : " + age.getText().toString() +
                        "\nAddress : " + address.getText().toString() +
                        "\nDate of Birth : " + dp.getDayOfMonth() + "/" + (dp.getMonth() + 1) + "/" + dp.getYear() +
                        "\nState : " + spin.getSelectedItem().toString();
                output.setText(info);
            }
        });

        // By AVidhanR
    }
}