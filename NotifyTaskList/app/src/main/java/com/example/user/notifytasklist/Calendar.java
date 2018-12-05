package com.example.user.notifytasklist;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;

public class Calendar extends AppCompatActivity {


    //private static final String TAG = "Calendar";
    CalendarView calendarView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendar);

        calendarView = findViewById(R.id.calendarView);


        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
           public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                String date = i2 + "/" + i1 + "/" + i;
                //Log.d(TAG,"onSelectedDayChange: mm/dd/yyyy: "+ date);


              Intent intent = new Intent(Calendar.this, AddShow.class);
              intent.putExtra("date", date);
              startActivity(intent);
            }
        });

    }


}
