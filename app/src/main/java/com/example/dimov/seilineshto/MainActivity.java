package com.example.dimov.seilineshto;

import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.provider.Settings;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import android.widget.Toast;

import java.sql.Time;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private NotificationManager mNotificationManager;
    private static final int NOTIFICATION_ID = 0;
    Button setting;

    private AdView mAdView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        MobileAds.initialize(this, "ca-app-pub-7387387981734551~9074572688");
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        setting = findViewById(R.id.buttonSettings);
        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(setting.getContext(), com.example.dimov.seilineshto.Settings.class);
                startActivity(i);
            }
        });


        SharedPreferences sharedPref =
                PreferenceManager.getDefaultSharedPreferences(this);
        Boolean set = sharedPref.getBoolean
                ("switch_preference_1", false);



        mNotificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        Intent notifyIntent = new Intent(this, AlarmReceiver.class);
        final PendingIntent notifyPendingIntent = PendingIntent.getBroadcast
                (this, NOTIFICATION_ID, notifyIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        String toastMessage;


        if(set){

            long triggerTime = SystemClock.elapsedRealtime()
                    + 1000*20;

            long repeatInterval = AlarmManager.INTERVAL_FIFTEEN_MINUTES;

            //If the Toggle is turned on, set the repeating alarm with a 15 minute interval
            alarmManager.setInexactRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP,
                    triggerTime, repeatInterval, notifyPendingIntent);

            //Set the toast message for the "on" case
            toastMessage = "alarm ON";
        } else {
            //Cancel the alarm and notification if the alarm is turned off
            alarmManager.cancel(notifyPendingIntent);
            mNotificationManager.cancelAll();

            //Set the toast message for the "off" case
            toastMessage = "alarm OFF";
        }

        //Show a toast to say the alarm is turned on or off
        Toast.makeText(MainActivity.this, toastMessage, Toast.LENGTH_SHORT)
                .show();

    }



    public void izlez(View view){
        boolean set =true;
        mNotificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        Intent notifyIntent = new Intent(this, AlarmReceiver.class);
        final PendingIntent notifyPendingIntent = PendingIntent.getBroadcast
                (this, NOTIFICATION_ID, notifyIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        String toastMessage;


        if(set){

            long triggerTime = SystemClock.elapsedRealtime()
                    + 1000*20;

            long repeatInterval = AlarmManager.INTERVAL_FIFTEEN_MINUTES;

            //If the Toggle is turned on, set the repeating alarm with a 15 minute interval
            alarmManager.setInexactRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP,
                    triggerTime, repeatInterval, notifyPendingIntent);

            //Set the toast message for the "on" case
            toastMessage = "alarm ON";
        } else {
            //Cancel the alarm and notification if the alarm is turned off
            alarmManager.cancel(notifyPendingIntent);
            mNotificationManager.cancelAll();

            //Set the toast message for the "off" case
            toastMessage = "alarm OFF";
        }

        //Show a toast to say the alarm is turned on or off
        Toast.makeText(MainActivity.this, toastMessage, Toast.LENGTH_SHORT)
                .show();
            System.exit(0);

        }










    public void rekord(View view){
        final Intent i = new Intent(this, ScoreTable.class);
        startActivity(i);
    }

    public void igraj(View view){

        final Intent i = new Intent(this, Igraj.class);
        startActivity(i);

    }










    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            hideSystemUI();
        }
    }

    private void hideSystemUI() {
        // Enables regular immersive mode.
        // For "lean back" mode, remove SYSTEM_UI_FLAG_IMMERSIVE.
        // Or for "sticky immersive," replace it with SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE
                        // Set the content to appear under the system bars so that the
                        // content doesn't resize when the system bars hide and show.
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        // Hide the nav bar and status bar
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN);
    }

    // Shows the system bars by removing all the flags
// except for the ones that make the content appear under the system bars.
    private void showSystemUI() {
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
    }


}
