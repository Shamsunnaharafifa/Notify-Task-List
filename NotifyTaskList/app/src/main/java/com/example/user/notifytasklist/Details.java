package com.example.user.notifytasklist;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;
import static com.example.user.notifytasklist.App.ADD_ID;

public class Details extends AppCompatActivity {

    private NotificationManagerCompat notificationManager;
    private EditText titleET,descriptionET;
    private Button addET,cancelET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        notificationManager = NotificationManagerCompat.from(this);

        titleET = findViewById(R.id.titleET);
        descriptionET = findViewById(R.id.descriptionET);
        addET = findViewById(R.id.addBtn);
        cancelET = findViewById(R.id.cancelBtn);


        Bundle bundle = getIntent().getExtras();

        if (bundle != null){
            String value = bundle.getString("details");
            titleET.setText(value);
        }
        cancelET.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Details.this,Show.class);
                startActivity(intent);
            }
        });
    }


    public void addBTN(View view) {
        String title = titleET.getText().toString();
        String description = descriptionET.getText().toString();

        Intent intent = new Intent(this,Show.class);
        PendingIntent contentTntent = PendingIntent.getActivity(this,0,intent,0);

        Intent broadCastIntent = new Intent(this,NotificationReceiver.class);
        PendingIntent actionIntent = PendingIntent.getBroadcast(this,0
                                        ,broadCastIntent,PendingIntent.FLAG_UPDATE_CURRENT);

        Bitmap largeIcon = BitmapFactory.decodeResource(getResources(),R.drawable.girl);

        Notification notification = new NotificationCompat.Builder(this, ADD_ID)
                .setSmallIcon(R.drawable.ic_message)
                .setContentTitle(title)
                .setContentText(description)
                .setLargeIcon(largeIcon)
                .setStyle(new NotificationCompat.BigTextStyle()
                            .bigText(getString(R.string.longText))
                            .setBigContentTitle("Title")
                            .setSummaryText("Summary text")
                )
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .setColor(Color.BLUE)
                .setContentIntent(contentTntent)
                .setAutoCancel(true)
                .setOnlyAlertOnce(true)
                .addAction(R.mipmap.ic_launcher,"Toast",actionIntent)
                .build();
        notificationManager.notify(1,notification);
    }



}
