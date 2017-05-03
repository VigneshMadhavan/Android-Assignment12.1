package com.example.vimadhavan.assignment121;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements Listener {

    private TextView mBatteryLevelText;
    private ProgressBar mBatteryLevelProgress;
    private BatteryBroadcastReceiver batterLevelReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBatteryLevelText = (TextView) findViewById(R.id.textView);
        mBatteryLevelProgress = (ProgressBar) findViewById(R.id.progressBar);
        batterLevelReceiver=new BatteryBroadcastReceiver(this);

    }

    @Override
    protected void onStart() {
        //register the receiver
        registerReceiver(batterLevelReceiver, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));

        super.onStart();
    }

    @Override
    protected void onStop() {
        //unregister the receiver
        unregisterReceiver(batterLevelReceiver);
        super.onStop();
    }

    @Override
    public void onRecievedBatterLevel(int level) {
        //update the battery level when battery level changes
        mBatteryLevelText.setText( getString(R.string.battery_level)+" "+level+"%");
        mBatteryLevelProgress.setProgress(level);
    }
}
