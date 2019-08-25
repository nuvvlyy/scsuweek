package com.example.scsuweek;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class MainActivity extends AppCompatActivity {
    private TextView mTextMessage;
    private TextView mTextROOM;
    private TextView mTextCOUNT;
    private Button mButton;
    private ZXingScannerView zXingScannerView;
    private String room = "1" ;
    httphandler h = new httphandler();
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            getHTTP();
            try {


            switch (item.getItemId()) {
                case R.id.navigation_room1:
                    mTextMessage.setText("ROOM 1: IOT");
                    mTextCOUNT.setText(Integer.toString(h.ROOM1()));
                    setRoom("1");
                    Toast.makeText(getApplicationContext(),"ROOM 1: IOT", Toast.LENGTH_LONG).show();
                    return true;
                case R.id.navigation_room2:
                    mTextMessage.setText("ROOM 2: APP & GAME");
                    mTextCOUNT.setText(Integer.toString(h.ROOM2()));
                    setRoom("2");
                    Toast.makeText(getApplicationContext(),"ROOM 2: APP & GAME", Toast.LENGTH_LONG).show();
                    return true;
                case R.id.navigation_room3:
                    mTextMessage.setText("ROOM 3: ROBOT");
                    mTextCOUNT.setText(Integer.toString(h.ROOM3()));
                    setRoom("3");
                    Toast.makeText(getApplicationContext(),"ROOM 3: ROBOT", Toast.LENGTH_LONG).show();
                    return true;
                case R.id.navigation_room4:
                    mTextMessage.setText("DATA SCIENCE");
                    mTextCOUNT.setText(Integer.toString(h.ROOM4()));
                    setRoom("4");
                    Toast.makeText(getApplicationContext(),"DATA SCIENCE", Toast.LENGTH_LONG).show();
                    return true;
            }
            } catch (JSONException e) {
            e.printStackTrace();
        }
            return false;
        }
    };

    public void setRoom(String room) {
        this.room = room;
    }

    public String getRoom() {
        return room;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getHTTP();

        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        mTextMessage = findViewById(R.id.message);
        mTextROOM = findViewById(R.id.room1);
        mTextCOUNT = findViewById(R.id.room1_count);
//        mTextROOM2 = findViewById(R.id.room2_count);
//        mTextROOM3 = findViewById(R.id.room3_count);
//        mTextROOM4 = findViewById(R.id.room4_count);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        mButton = findViewById(R.id.button);
        mButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,QrCodeScannerActivity.class);
                i.putExtra("id", room);
                startActivity(i);
            }


        });

    }
    protected void onResume() {

        super.onResume();
        getHTTP();
    }
    void getHTTP() {
        String url = "http://us-central1-scweek62-7febd.cloudfunctions.net/api/getroom";
        new httphandler().execute(new String[]{url, "-", "get"});
    }




}



