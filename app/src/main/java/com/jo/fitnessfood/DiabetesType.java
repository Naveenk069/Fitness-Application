package com.jo.fitnessfood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DiabetesType extends AppCompatActivity {
    public static String diabeteType;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diabetes_type);
        TextView textView=findViewById(R.id.textView);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                diabeteType="1";
                Intent intent=new Intent(getApplicationContext(),SelectTime.class);
                startActivity(intent);
            }
        });
        TextView textView1=findViewById(R.id.textView2);
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                diabeteType="2";
                Intent intent=new Intent(getApplicationContext(),SelectTime.class);
                startActivity(intent);
            }
        });
    }
}