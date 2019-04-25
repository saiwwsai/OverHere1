package com.example.saiwei.overhere;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.ColorSpace;
import android.os.Build;
import android.provider.Telephony;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

public class MsgReceiver extends BroadcastReceiver {

    private String messageBody = "";


    @Override
    public void onReceive(Context context, Intent intent) {
        System.out.println("FIRST UNDER onReceive");

        if (Telephony.Sms.Intents.SMS_RECEIVED_ACTION.equals(intent.getAction())) {
            for (SmsMessage smsMessage : Telephony.Sms.Intents.getMessagesFromIntent(intent)) {
                messageBody = smsMessage.getMessageBody();
            }

            if (messageBody.equals(WelcomeActivity.userKey)){
                System.out.println("MATCHED");
            }

        }
    }

}
