package com.jo.fitnessfood;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class ViewYogaPage extends AppCompatActivity {
    List<DataAdapter> ListOfdataAdapter;

    RecyclerView recyclerView;

    String HTTP_JSON_URL ="http://"+ServerConnect.serverip+"/Android/fitnessfood/viewyoga.php";

    String Image_Name_JSON = "pname";
    String Image_URL_JSON = "pimg";
    String Image_Type = "ptype";
    String Image_Category = "pcategory";
    String fromm = "fromm";
    String Image_Price = "price";
    String Image_Tax = "stax";
    String PID = "pid";
    String P_Name = "uid";
//    String P_Description = "udetail";
//    String P_Type = "sb_id";


    JsonArrayRequest RequestOfJSonArray ;

    RequestQueue requestQueue ;

    View view ;

    int RecyclerViewItemPosition ;

    RecyclerView.LayoutManager layoutManagerOfrecyclerView;

    RecyclerView.Adapter recyclerViewadapter;

    ArrayList<String> Product_Name;
    ArrayList<String> Product_Price;
    ArrayList<String> Product_Type;
    ArrayList<String> Product_Category;
    ArrayList<String> Product_Tax;
    ArrayList<String> Product_Id;

    ArrayList<String> Product_ImageURL;
    ArrayList<String> User_ID;
    ArrayList<String> User_Details;
    ArrayList<String> Sbook_Id;


    public static final String SHARED_PREFS1 = "";

    SharedPreferences sharedpreferences1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_yoga_page);
        sharedpreferences1 = getSharedPreferences(SHARED_PREFS1, Context.MODE_PRIVATE);

        Product_Name = new ArrayList<>();
        Product_Price = new ArrayList<>();
        Product_Type = new ArrayList<>();
        Product_Category = new ArrayList<>();
        Product_Tax = new ArrayList<>();
        Product_Id = new ArrayList<>();
        Product_ImageURL = new ArrayList<>();
        User_ID = new ArrayList<>();
//        User_Details = new ArrayList<>();
//        Sbook_Id = new ArrayList<>();

        ListOfdataAdapter = new ArrayList<>();

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview10);

        recyclerView.setHasFixedSize(true);

        layoutManagerOfrecyclerView = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManagerOfrecyclerView);



        JSON_HTTP_CALL();

        // Implementing Click Listener on RecyclerView.
        recyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {

            GestureDetector gestureDetector = new GestureDetector(ViewYogaPage.this, new GestureDetector.SimpleOnGestureListener() {

                @Override public boolean onSingleTapUp(MotionEvent motionEvent) {
                    return true;
                }

            });
            @Override
            public boolean onInterceptTouchEvent(RecyclerView Recyclerview, MotionEvent motionEvent) {

                view = Recyclerview.findChildViewUnder(motionEvent.getX(), motionEvent.getY());

                if(view != null && gestureDetector.onTouchEvent(motionEvent)) {

                    //Getting RecyclerView Clicked Item value.
                    RecyclerViewItemPosition = Recyclerview.getChildAdapterPosition(view);
//
//                    Intent ii = new Intent(ViewMachine.this,OneMachine.class);
//                    ii.putExtra("pid",Product_Id.get(RecyclerViewItemPosition));
//                    ii.putExtra("pname",Product_Name.get(RecyclerViewItemPosition));
//                    ii.putExtra("pimg",Product_ImageURL.get(RecyclerViewItemPosition));
//                    ii.putExtra("pcategory",Product_Category.get(RecyclerViewItemPosition));
//                    ii.putExtra("ptype",Product_Type.get(RecyclerViewItemPosition));
//                    ii.putExtra("stax",Product_Tax.get(RecyclerViewItemPosition));
//                    ii.putExtra("pprice",Product_Price.get(RecyclerViewItemPosition));
//                    ii.putExtra("uid",User_ID.get(RecyclerViewItemPosition));
////                    ii.putExtra("userdetail",User_Details.get(RecyclerViewItemPosition));
////                    ii.putExtra("sb_id",Sbook_Id.get(RecyclerViewItemPosition));
//
//                    startActivity(ii);

                    // alertDialog(ImageTitleNameArrayListForClick.get(RecyclerViewItemPosition),Price.get(RecyclerViewItemPosition),
                    //       Itemid.get(RecyclerViewItemPosition),Phone.get(RecyclerViewItemPosition),FID.get(RecyclerViewItemPosition));
                    //ImageTitleNameArrayListForClick.add(json.getString(Image_Name_JSON));
                    // Price.add(json.getString(Image_Price));
                    // Itemid.add(json.getString(GID));

                    // Showing RecyclerView Clicked Item value using Toast.
                    // Toast.makeText(UserHome.this, ImageTitleNameArrayListForClick.get(RecyclerViewItemPosition), Toast.LENGTH_LONG).show();
                }

                return false;
            }

            @Override
            public void onTouchEvent(RecyclerView Recyclerview, MotionEvent motionEvent) {

            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }
        });


    }


    public void JSON_HTTP_CALL(){
        RequestOfJSonArray = new JsonArrayRequest(HTTP_JSON_URL,

                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        ParseJSonResponse(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        requestQueue = Volley.newRequestQueue(ViewYogaPage.this);

        requestQueue.add(RequestOfJSonArray);
    }

    public void ParseJSonResponse(JSONArray array){

        for(int i = 0; i<array.length(); i++) {

            DataAdapter GetDataAdapter2 = new DataAdapter();

            JSONObject json = null;
            try {

                json = array.getJSONObject(i);

                GetDataAdapter2.setImageTitle(""+json.getString(PID));
                GetDataAdapter2.setImageType(""+json.getString(Image_Name_JSON));
                GetDataAdapter2.setImageSize("User Id : "+json.getString(Image_Tax));
                GetDataAdapter2.setImagePack("Count  : "+json.getString(Image_Type)+"\n  "+json.getString(fromm));
                GetDataAdapter2.setImagePrice("Price : \u20B9"+json.getString(Image_Price));
                GetDataAdapter2.setIMGID(json.getString(PID));
                GetDataAdapter2.setImageUrl("http://"+ServerConnect.serverip+"/Android/fitnessfood/upload/"+json.getString(Image_URL_JSON)+".jpg");
                // Adding image title name in array to display on RecyclerView click event.


                Product_Name.add(json.getString(Image_Name_JSON));
                Product_Price.add(json.getString(Image_Price));
                Product_Type .add(json.getString(Image_Type));
                Product_Category.add(json.getString(Image_Category));
                Product_Tax.add(json.getString(Image_Tax));
                Product_Id.add(json.getString(PID));
                Product_ImageURL.add(json.getString(Image_URL_JSON));
                User_ID.add(json.getString(P_Name));
//                User_Details.add(json.getString(P_Description));
//                Sbook_Id.add(json.getString(P_Type));








            } catch (JSONException e) {

                e.printStackTrace();
            }
            ListOfdataAdapter.add(GetDataAdapter2);
        }

        recyclerViewadapter = new RecyclerViewAdapter(ListOfdataAdapter, this);

        recyclerView.setAdapter(recyclerViewadapter);
    }



}