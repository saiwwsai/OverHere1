package com.example.saiwei.overhere;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WelcomeActivity extends AppCompatActivity {

    private Button RINGbttn;
    private Button GPSbttn;
    private Button MESGbttn;

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

                Intent intent = new Intent(WelcomeActivity.this, MsgSendActivity.class);
                startActivity(intent);
            }
        });
    }



}
