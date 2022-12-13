package com.example.sms;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText phnnum = (EditText) findViewById(R.id.contact_number);
        final EditText usermsg = (EditText) findViewById(R.id.user_message);
        final Button sendButton = (Button) findViewById(R.id.sendButton);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendMsg(phnnum.getText().toString(),usermsg.getText().toString());
            }
        });

    }

    public void sendMsg(String phnnumber,String message){
        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(phnnumber,null,message,null,null);
    }
}