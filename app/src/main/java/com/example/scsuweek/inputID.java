package com.example.scsuweek;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class inputID extends AppCompatActivity {
    private Button mButton;
    private EditText mID;
    private TextView mtextView;
    String room;
    Bundle b;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b = this.getIntent().getExtras();
        room = b.get("id").toString();
        setContentView(R.layout.activity_input_id);
        mButton = findViewById(R.id.button2);
        mtextView =findViewById(R.id.textView);
        mtextView.setText(getRoomName(room));
        mID = findViewById(R.id.addID);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mID.getText().length()==0){
                    Toast.makeText(getApplicationContext(), "กรุณากรอกข้อมูลให้ครบถ้วน", Toast.LENGTH_LONG).show();
                    return;
                }
                String str = mID.getText().toString();
                String url = "https://us-central1-scweek62-7febd.cloudfunctions.net/api/checkin/" + room;
                new httphandler().execute(new String[]{url, str,"post"});
                Toast.makeText(getApplicationContext(), "success", Toast.LENGTH_LONG).show();

                AlertDialog.Builder builder = new AlertDialog.Builder(inputID.this);
                builder.setTitle("success");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mID.setText(null);
                    }
                });
                builder.setMessage(getRoomName(room)+"\nid: "+str );
                AlertDialog alert1 = builder.create();
                alert1.show();
            }
        });


    }
    String getRoomName(String room){
        switch (room){
            case "1" :
                return "ROOM 1: IOT";
            case "2" :
                return "ROOM 2: APP & GAME";
            case "3" :
                return "ROOM 3: ROBOT";
            case "4" :
                return "DATA SCIENCE";

        }
        return null;
    }
}
