package com.example.user.notifytasklist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AddShow extends AppCompatActivity {

     TextView dateTV;
     private Button showBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_show);

        dateTV = findViewById(R.id.dateTV);

        showBtn = findViewById(R.id.showBtn);


        //Intent incomingIntent = getIntent();
        String date = getIntent().getStringExtra("date");
        if(date!=null)
            dateTV.setText(date);



        showBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddShow.this,Show.class);
                startActivity(intent);
            }
        });
    }



}
