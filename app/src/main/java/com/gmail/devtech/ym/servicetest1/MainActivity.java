package com.gmail.devtech.ym.servicetest1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    final static String TAG = "ServiceTest4";
    Button startButton;
    IntentFilter intentFilter;
    MyBroadcastReceiver receiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startButton = (Button)findViewById(R.id.start_button);
        startButton.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v) {
                startService(new Intent(getBaseContext(), MyIntentService.class));
            }
        });

        receiver = new MyBroadcastReceiver();
        intentFilter = new IntentFilter();
        intentFilter.addAction("MY_ACTION");
        registerReceiver(receiver, intentFilter);
    }
}
