package com.jo.fitnessfood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ServerConnect extends AppCompatActivity {
    EditText eip;
    Button dreg;
    public static String serverip ="";

    public static final String SHARED_PREFS = "";
    SharedPreferences sharedpreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_server_connect);
        sharedpreferences = getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);
        eip= (EditText) findViewById(R.id.sip);
        eip.setText("192.168.1.3");
        dreg=(Button) findViewById(R.id.con);
        eip.setText(sharedpreferences.getString("eip",null));




        dreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                serverip = eip.getText().toString().trim();
                if(serverip.equals(""))
                {

                    Toast.makeText(getApplicationContext(),"Enter Server ip ",Toast.LENGTH_SHORT).show();
                    eip.setError("Enter Server ip", getDrawable(R.drawable.ic_launcher_background));

                }
                else {
                    SharedPreferences.Editor editor = sharedpreferences.edit();
                    editor.putString("eip", eip.getText().toString());

                    editor.commit();

                    Intent nlogs = new Intent(ServerConnect.this, LoginPage.class);


                    startActivity(nlogs);
                }
            }
        });


    }


}