package com.example.vimadhavan.assignment121;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.BatteryManager;

/**
 * Created by vimadhavan on 5/3/2017.
 */

public class BatteryBroadcastReceiver extends BroadcastReceiver {

    private Listener myListener;

    public BatteryBroadcastReceiver(Listener myListener) {
        this.myListener = myListener;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        //will trigger once battery level changed
        int level=intent.getIntExtra(BatteryManager.EXTRA_LEVEL,0);
        this.myListener.onRecievedBatterLevel(level);


    }
}
