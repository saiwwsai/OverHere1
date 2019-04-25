package com.example.saiwei.overhere;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MsgSendActivity extends AppCompatActivity {

  //  final int SEND_SMS_PERMISSION_REQUEST_CODE = 111;
    private Button mSendMessageBtn;
    private String message;
    private String phoneNo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_msg_send);


        mSendMessageBtn = (Button) findViewById(R.id.btn_send_message);
        final EditText messagetEt = (EditText) findViewById(R.id.et_message);
        final EditText mPhoneNoEt = (EditText) findViewById(R.id.et_phoneNum);


        // it is disabled by default
        mSendMessageBtn.setEnabled(false);

        // get message body and phoneNo
        message = messagetEt.getText().toString();
        phoneNo = mPhoneNoEt.getText().toString();

        // if the user key not matching, get toast
        if (!message.equals(WelcomeActivity.userKey)) {
            Toast.makeText(MsgSendActivity.this,
                    "You can't ring your lost device. " +
                            "Please enter your own Key!", Toast.LENGTH_SHORT).show();
        }
        // if text & receiver not null enable it
        if (message.equals(WelcomeActivity.userKey) && !phoneNo.isEmpty()) {
            mSendMessageBtn.setEnabled(true);
        }

        mSendMessageBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage(phoneNo,
                        null, message, null, null);
            }
        });
    }
    

}
