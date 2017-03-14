package com.gmail.devtech.ym.servicetest1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        Bundle bundle = intent.getExtras();
        String message = bundle.getString("message");

        Toast.makeText(
                context,
                "onReceive! " + message,
                Toast.LENGTH_LONG).show();
    }

}