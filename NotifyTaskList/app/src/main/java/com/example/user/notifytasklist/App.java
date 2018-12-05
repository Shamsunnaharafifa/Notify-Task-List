package com.example.user.notifytasklist;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

public class App extends Application {

    public static final String ADD_ID = "Add";

    @Override
    public void onCreate() {
        super.onCreate();

        createNotificationChannel();
    }

    private void createNotificationChannel(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){

            NotificationChannel add = new NotificationChannel(
                    ADD_ID,
                    "Add",
                    NotificationManager.IMPORTANCE_HIGH

            );
            add.setDescription("Added");
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(add);

        }
    }
}
