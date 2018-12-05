package com.example.user.notifytasklist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Show extends AppCompatActivity {
    private ListView listID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        listID = findViewById(R.id.listID);

        final String[] Names = getResources().getStringArray(R.array.names);
        final String[] Details = getResources().getStringArray(R.array.details);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(Show.this,
               R.layout.sample_list,R.id.sampleTV,Names);
        listID.setAdapter(adapter);

        listID.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
               Intent intent = new Intent(Show.this, Details.class);
               intent.putExtra("names", Names[i]);
               intent.putExtra("details",Details[i]);

               startActivity(intent);
           }
           });


        }
}
