package com.example.test1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;

public class Schedule_Calendar extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "CalendarActivity";

    private CalendarView mCalendarView;

    //Intent incomingIntent = getIntent();
    //int service = incomingIntent.getIntExtra("service",1);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_calendar);

        Intent incomingIntent = getIntent();
        int service = incomingIntent.getIntExtra("service",1);

        Button buttonConfirm = (Button) findViewById(R.id.buttonConfirm1);
        buttonConfirm.setOnClickListener(this);

        mCalendarView = (CalendarView) findViewById(R.id.calendarView);

        mCalendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener(){

            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                String date = i2 + "/" + (i1+1) + "/" + i;
                Log.d(TAG, date);
                //"onSelectedDayChange: dd/mm/yyyy: "

                Intent intent = new Intent(Schedule_Calendar.this, Schedule_HourSelector.class);
                intent.putExtra("date", date);
                intent.putExtra("service",service);



            }



        });


    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(Schedule_Calendar.this, Schedule_HourSelector.class);


        startActivity(intent);
    }


    //Intent intent = new Intent(Schedule_Calendar.this, Schedule_HourSelector.class);
        //startActivity(intent);

}