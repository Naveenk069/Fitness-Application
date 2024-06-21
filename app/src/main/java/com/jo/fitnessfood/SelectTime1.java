package com.jo.fitnessfood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SelectTime1 extends AppCompatActivity {
    public static String time;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_time);
        TextView textView=findViewById(R.id.textView);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                time="breakfast";
                Intent intent=new Intent(getApplicationContext(),ViewData1.class);
                startActivity(intent);
            }
        });
        TextView textView1=findViewById(R.id.textView2);
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                time="lunch";
                Intent intent=new Intent(getApplicationContext(),ViewData1.class);
                startActivity(intent);
            }
        });
        TextView textView2=findViewById(R.id.textView3);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                time="dinner";
                Intent intent=new Intent(getApplicationContext(),ViewData1.class);
                startActivity(intent);
            }
        });
    }
}