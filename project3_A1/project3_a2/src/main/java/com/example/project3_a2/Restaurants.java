package com.example.project3_a2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class Restaurants extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        Intent intent1 = new Intent(context, ActivityRestaurants.class);
        context.startActivity(intent1);

    }
}
