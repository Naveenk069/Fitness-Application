package com.jo.fitnessfood;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class BPHome extends AppCompatActivity {
   public static String selectedItem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bphome);

        Spinner spinner = findViewById(R.id.spinner);
        Button button = findViewById(R.id.button);

        // Create a list of items for the spinner
        List<String> items = new ArrayList<>();
        items.add("Low");
        items.add("Normal");
        items.add("Pre High");
        items.add("High BP");

        // Create an ArrayAdapter using the string list and a default spinner layout
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, items);

        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        // Set up the button click listener
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 selectedItem = spinner.getSelectedItem().toString();
                Intent intent=new Intent(getApplicationContext(),ViewBp.class);
                startActivity(intent);
               // Toast.makeText(BPHome.this, "Selected: " + selectedItem, Toast.LENGTH_SHORT).show();
            }
        });
    }
}