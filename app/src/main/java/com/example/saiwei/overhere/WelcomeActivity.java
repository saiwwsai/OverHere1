package com.example.saiwei.overhere;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class WelcomeActivity extends AppCompatActivity {

    private Button RINGbttn;
    private Button GPSbttn;
    private Button MESGbttn;
    public static String userKey;  // todo this could be google password

    final int SEND_SMS_PERMISSION_REQUEST_CODE = 111;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        RINGbttn = findViewById(R.id.bt_ring);
        GPSbttn = findViewById(R.id.bt_gps);
        MESGbttn = findViewById(R.id.bt_msg);

        RINGbttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(WelcomeActivity.this,
                        MsgSendActivity.class);
                startActivity(intent);

            }
        });

        Intent i = new Intent(WelcomeActivity.this, MsgReceiver.class);
        WelcomeActivity.this.sendBroadcast(i);

        userKey = "stlawu1920";  // todo hardcoded message


        // permission checking for sending
        if (checkPermission(Manifest.permission.SEND_SMS)) {
            RINGbttn.setEnabled(true);
        } else {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.SEND_SMS},
                    SEND_SMS_PERMISSION_REQUEST_CODE);
        }
        // permission checking for receiving sms
        if(!checkPermission(Manifest.permission.RECEIVE_SMS)) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.RECEIVE_SMS}, 222);
        }

    }

    private boolean checkPermission(String permission) {
        int checkPermission = ContextCompat.checkSelfPermission(this, permission);
        return (checkPermission == PackageManager.PERMISSION_GRANTED);
    }


    @Override
    public void onRequestPermissionsResult(
            int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case SEND_SMS_PERMISSION_REQUEST_CODE: {
                if(grantResults.length > 0 &&
                        (grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                    RINGbttn.setEnabled(true);
                }

            }
        }
    }




    }
