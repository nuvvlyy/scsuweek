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

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class MainActivity extends AppCompatActivity {
    private TextView mTextMessage;
    private Button mButton;
    private ZXingScannerView zXingScannerView;
    private String room = "1" ;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_room1:
                    mTextMessage.setText("ROOM 1: IOT");
                    setRoom("1");
                    Toast.makeText(getApplicationContext(),"ROOM 1: IOT", Toast.LENGTH_LONG).show();
//                    mButton.setText("scan QR code");
                    return true;
                case R.id.navigation_room2:
                    mTextMessage.setText("ROOM 2: APP & GAME");
                    setRoom("2");
                    Toast.makeText(getApplicationContext(),"ROOM 2: APP & GAME", Toast.LENGTH_LONG).show();
                    return true;
                case R.id.navigation_room3:
                    mTextMessage.setText("ROOM 3: ROBOT");

                    setRoom("3");
                    Toast.makeText(getApplicationContext(),"ROOM 3: ROBOT", Toast.LENGTH_LONG).show();
                    return true;
                case R.id.navigation_room4:
                    mTextMessage.setText("DATA SCIENCE");

                    setRoom("4");
                    Toast.makeText(getApplicationContext(),"DATA SCIENCE", Toast.LENGTH_LONG).show();
                    return true;
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
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        mTextMessage = findViewById(R.id.message);
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


}



