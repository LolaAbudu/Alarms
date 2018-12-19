package com.example.lolaabudu.standup;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
//    private ToggleButton alarmToggle;
//    private NotificationManager notificationManager;
//    private static final String PRIMARY_CHANNEL_ID =
//            "primary_notification_channel";


    //this is how you create an alarm to be sent to a broadcast receiver
    private static final int NOTIFICATION_ID = 0;
    final long repeatInterval=1000;
    final long triggerTime= SystemClock.elapsedRealtime() + repeatInterval;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(this, NotificationManager.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, NOTIFICATION_ID, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarmManager.setInexactRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP, triggerTime, repeatInterval, pendingIntent);


//        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
//        deliverNotification(null);
//
//        alarmToggle = findViewById(R.id.alarmToggle);
//        alarmToggle.setOnCheckedChangeListener(
//                new CompoundButton.OnCheckedChangeListener() {
//                    @Override
//                    public void onCheckedChanged(CompoundButton compoundButton,
//                                                 boolean isChecked) {
//                        if(isChecked){
//                            Toast.makeText(MainActivity.this, "Toggle on", Toast.LENGTH_SHORT).show();
//                            deliverNotification(MainActivity.this);   //call this when the button is checked, so it will send a new notification everytime
//                        }else {
//                            Toast.makeText(MainActivity.this, "Toggle off", Toast.LENGTH_SHORT).show();
//                            notificationManager.cancelAll();
//                        }
//                    }
//                });
    }


//    public void createNotificationChannel() {
//
//        // Create a notification manager object.
//        notificationManager =
//                (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
//
//        // Notification channels are only available in OREO and higher.
//        // So, add a check on SDK version.
//        if (android.os.Build.VERSION.SDK_INT >=
//                android.os.Build.VERSION_CODES.O) {
//
//            // Create the NotificationChannel with all the parameters.
//            NotificationChannel notificationChannel = new NotificationChannel
//                    (PRIMARY_CHANNEL_ID,
//                            "Stand up notification",
//                            NotificationManager.IMPORTANCE_HIGH);
//
//            notificationChannel.enableLights(true);
//            notificationChannel.setLightColor(Color.RED);
//            notificationChannel.enableVibration(true);
//            notificationChannel.setDescription
//                    ("Notifies every 15 minutes to stand up and walk");
//            notificationManager.createNotificationChannel(notificationChannel);
//        }
//    }
//
//
//    private void deliverNotification(@NonNull Context context){
//        Intent intent =new Intent(context, MainActivity.class);
//        //PendingIntent takes context, notification id, intent and flag update
//        //for pending intent, first create your intent, then wrap itin a pending intent
//        PendingIntent pendingIntent = PendingIntent.getActivity(
//                context,
//                NOTIFICATION_ID,
//                intent,
//                PendingIntent.FLAG_UPDATE_CURRENT);
//
//        //this is how you always screate a notification
//        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, PRIMARY_CHANNEL_ID)
//                .setSmallIcon(R.drawable.ic_stand_up)
//                .setContentTitle("Stand Up Alert")
//                .setContentText("You should stand up and walk around now!")
//                .setContentIntent(pendingIntent)
//                .setPriority(NotificationCompat.PRIORITY_HIGH)
//                .setAutoCancel(true)
//                .setDefaults(NotificationCompat.DEFAULT_ALL);
//        notificationManager.notify(NOTIFICATION_ID, builder.build());   //this is what
//    }
}
