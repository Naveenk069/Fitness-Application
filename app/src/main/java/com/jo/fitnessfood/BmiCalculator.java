package com.jo.fitnessfood;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class BmiCalculator extends AppCompatActivity {
    EditText weightEditText, heightEditText;
    TextView resultTextView;
    Button calculateButton;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_calculator);

        weightEditText = findViewById(R.id.weightEditText);
        heightEditText = findViewById(R.id.heightEditText);
        resultTextView = findViewById(R.id.resultTextView);
        calculateButton = findViewById(R.id.calculateButton);
        imageView =findViewById(R.id.imageView2);
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBMI();
                imageView.setVisibility(View.VISIBLE);
            }
        });
    }

    private void calculateBMI() {
        // Get weight and height from the EditText fields
        String weightStr = weightEditText.getText().toString();
        String heightStr = heightEditText.getText().toString();

        if (!weightStr.isEmpty() && !heightStr.isEmpty()) {
            // Convert weight and height to float values
            float weight = Float.parseFloat(weightStr);
            float height = Float.parseFloat(heightStr) / 100; // Convert height from cm to meters

            // Calculate BMI
            float bmi = weight / (height * height);

            // Display the result
            String resultText = getString(R.string.bmi_result, bmi);
            resultTextView.setText(resultText);
        } else {
            resultTextView.setText(R.string.error_message);
        }
    }
}