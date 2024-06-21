package com.jo.fitnessfood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class HomePage extends AppCompatActivity {
    public  static String food;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        TextView textView=findViewById(R.id.textView);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                food="yes";
                Intent intent=new Intent(getApplicationContext(),DiabetesType.class);
                startActivity(intent);
            }
        });
        TextView textView1=findViewById(R.id.textView2);
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                food="no";
                Intent intent=new Intent(getApplicationContext(),SelectTime1.class);
                startActivity(intent);
            }
        });
        TextView textView2=findViewById(R.id.textView3);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                food="no";
                Intent intent=new Intent(getApplicationContext(),BmiCalculator.class);
                startActivity(intent);
            }
        });
        TextView textView3=findViewById(R.id.textView4);
        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                food="no";
                Intent intent=new Intent(getApplicationContext(),BPHome.class);
                startActivity(intent);
            }
        });
        TextView textView4=findViewById(R.id.textView5);
        textView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                food="no";
                Intent intent=new Intent(getApplicationContext(),ViewYogaPage.class);
                startActivity(intent);
            }
        });
    }
}