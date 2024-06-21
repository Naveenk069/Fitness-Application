package com.jo.fitnessfood;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.DataInputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

public class Register extends AppCompatActivity {
    EditText e1,e12,e2,e3,e7;
    ImageView bb;
    TextView e11;
    int pos;
    ArrayList<String> FID;
    ArrayList<String> FID1;
    ProgressDialog pDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        FID = new ArrayList<>();
        FID1 = new ArrayList<>();
        e1 = (EditText) findViewById(R.id.editTextNumber);
        e12 = (EditText) findViewById(R.id.editTextNumber1);
        e2 = (EditText) findViewById(R.id.editTextTextPersonName7);
        e3 = (EditText) findViewById(R.id.editTextTextPersonName2);
        e7 = (EditText) findViewById(R.id.editTextTextPersonName3);

        bb = (ImageView) findViewById(R.id.imageView7);

        e11 = (TextView) findViewById(R.id.textView7);
        e11.setOnClickListener(v -> {
            Intent in = new Intent(getApplicationContext(), LoginPage.class);
            startActivity(in);

        });


        bb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String dname = e1.getText().toString();
                final String demail = e2.getText().toString();
                final String dcontact = e3.getText().toString();

                final String ddob = e7.getText().toString();


                if(dname.equals("")&&demail.equals("")&&dcontact.equals("")
                        &&ddob.equals(""))
                {
                    e1.setError("Fill Name");
                    e2.setError("Fill Email");
                    e3.setError("Fill User Name");
                    e7.setError("Fill Password");
                    Toast.makeText(getApplicationContext(),"Fill All Fields",Toast.LENGTH_LONG).show();
                }else if(dname.equals("")){
                    e1.setError("Fill Name");
                }else if(demail.equals("")){
                    e2.setError("Fill Email");
                }else if(dcontact.equals("")){
                    e3.setError("Fill User Name");
                }else if(ddob.equals("")){
                    e7.setError("Fill Password");
                }
                else {

                    new registeration().execute();
                }


            }
        });

    }



    public class registeration extends AsyncTask<String, String, String> {

        final String name = e1.getText().toString();
        final String height = e12.getText().toString();
        final String email = e2.getText().toString();
        final String username = e3.getText().toString();
        final String password = e7.getText().toString();
        //  String  gender = selected_gender.getText().toString();
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(Register.this);
            pDialog.setMessage("Requesting " + name + ")...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(true);
            pDialog.show();
        }

        @SuppressWarnings("deprecation")

        protected String doInBackground(String... args) {

            String txt = "";
            try {
                String ur="http://"+ServerConnect.serverip+"/Android/fitnessfood/userregister.php?name="+ URLEncoder.encode(name)
                        +"&height="+ URLEncoder.encode(height)
                        +"&email="+ URLEncoder.encode(email)
                        +"&username="+URLEncoder.encode(username)+
                        "&password="+URLEncoder.encode(password);
                Log.i("URL", ur);
                URL url = new URL(ur);
                HttpURLConnection uc = (HttpURLConnection) url.openConnection();
                DataInputStream dis = new DataInputStream(uc.getInputStream());
                String t = "";
                while ((t = dis.readLine()) != null) {
                    txt += t;
                }
                Log.i("Read", txt);
                dis.close();
            } catch (Exception e) {
                Log.i("Login Ex", e.getMessage());
            }
            return txt;
        }


        protected void onPostExecute(String file_url) {
            // String ss= file_url.trim();
            // Toast.makeText(getApplicationContext(), ss, Toast.LENGTH_LONG).show();

            if (file_url.trim().equals("You are registered successfully")) {


                Toast.makeText(getApplicationContext(), "Registration Success!", Toast.LENGTH_LONG).show();
                finish();
                Intent in = new Intent(getApplicationContext(), LoginPage.class);
                // in.putExtra("si",serverip);
                startActivity(in);

            }


            else if(file_url.trim().equals("User name allready used type another one")) {
                Toast.makeText(getApplicationContext(), "User name already used type another one", Toast.LENGTH_LONG).show();



            }
            else
            { Toast.makeText(getApplicationContext(), "Please Check Login...!", Toast.LENGTH_LONG).show();}

            pDialog.dismiss();
        }
    }


}
