package com.jo.fitnessfood;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.DataInputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class LoginPage extends AppCompatActivity {
    ImageView dl;
    static EditText dlt,dlp;
    ProgressDialog pDialog;

    TextView e11;
    static ArrayList<String> FID;
    SharedPreferences sharedPreferences;
    SharedPreferences sp1;
    public static final String SHARED_PREFS1 = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        sp1 = getSharedPreferences(SHARED_PREFS1, Context.MODE_PRIVATE);
        dlt = (EditText) findViewById(R.id.editTextTextPersonName2);
        dlp =(EditText) findViewById(R.id.editTextTextPersonName3);
        dl= (ImageView) findViewById(R.id.imageView7);
        e11 = (TextView) findViewById(R.id.textView7);
        e11.setOnClickListener(v -> {
            Intent in = new Intent(getApplicationContext(), Register.class);

            startActivity(in);
        });
        dl.setOnClickListener(v -> {

            if(dlt.getText().toString().equals("")&&dlp.getText().toString().equals("")) {
                dlt.setError("Fill User Name");
                dlp.setError("Fill Password");
                Toast.makeText(getApplicationContext(), "Fill All Fields", Toast.LENGTH_SHORT).show();

            }else if(dlt.getText().toString().equals("")){
                dlt.setError("Fill User Name");
                Toast.makeText(getApplicationContext(), "Fill User Name Field", Toast.LENGTH_SHORT).show();
            }else if(dlp.getText().toString().equals("")){
                dlp.setError("Fill Password");
                Toast.makeText(getApplicationContext(), "Fill Password Field", Toast.LENGTH_SHORT).show();
            }else {
                new dlogin().execute();
            }
        });


    }








    public class dlogin extends AsyncTask<String, String, String> {


        final String eusername = dlt.getText().toString();
        final String  epassword = dlp.getText().toString();
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(LoginPage.this);
            pDialog.setMessage("Requesting");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(true);
            pDialog.show();
        }
        @SuppressWarnings("deprecation")

        protected String doInBackground(String... args) {
            //Log.i("Read",eusername.get(RecyclerViewItemPosition));

            String txt = "";
            try {
                String ur = "http://"+ServerConnect.serverip +"/Android/fitnessfood/userlogin.php?eusername="+eusername
                        +"&epassword="+epassword;
                Log.i("URL", ur);

                URL url = new URL(ur);
                HttpURLConnection uc = (HttpURLConnection) url.openConnection();
                DataInputStream dis = new DataInputStream(uc.getInputStream());
                String t = "";
                while ((t = dis.readLine()) != null) {
                    txt += t;
                }
                Log.i("Read", txt);
                // dis.close();
            } catch (Exception e) {
                Log.i("Login Ex", e.getMessage());
            }
            return txt;
        }


        protected void onPostExecute(String file_url) {

            if (file_url.trim().equals("Success")) {

                Toast.makeText(getApplicationContext(), "Login Success!", Toast.LENGTH_LONG).show();
                Intent in = new Intent(LoginPage.this, HomePage.class);
                SharedPreferences.Editor editor = sp1.edit();
                //UserHome2.putExtra("name",eusername);
                editor.putString("UID",eusername);
                editor.commit();
                startActivity(in);

            }


            else if(file_url.trim().equals("failed")) {
                Toast.makeText(getApplicationContext(), "User name OR password wrong", Toast.LENGTH_LONG).show();
                dlt.setText("");
                dlp.setText("");

            }
            else
            { Toast.makeText(getApplicationContext(), "Connection Error!", Toast.LENGTH_LONG).show();}

            pDialog.dismiss();
        }
    }




}