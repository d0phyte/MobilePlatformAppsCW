package com.example.test1;
import android.content.Intent;
import android.os.Build;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Schedule_HourSelector extends AppCompatActivity implements View.OnClickListener {





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_hour_selector);

        TimePicker picker;
        Button btnGet;
        TextView tvw;

        Button button = (Button) findViewById(R.id.button8);
        button.setOnClickListener(this);

        Intent incomingIntent = getIntent();
        int service = incomingIntent.getIntExtra("service",1);
        String date = incomingIntent.getStringExtra("date");

        tvw=(TextView)findViewById(R.id.editTextTextPersonName2);
        picker=(TimePicker)findViewById(R.id.timePicker1);
        picker.setIs24HourView(true);
        btnGet=(Button)findViewById(R.id.buttonConfirm2);
        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int hour, minute;
                String am_pm;
                if (Build.VERSION.SDK_INT >= 23 ){
                    hour = picker.getHour();
                    minute = picker.getMinute();
                }
                else{
                    hour = picker.getCurrentHour();
                    minute = picker.getCurrentMinute();
                }
                if(hour > 12) {
                    am_pm = "PM";
                    hour = hour - 12;
                }
                else
                {
                    am_pm="AM";
                }
                tvw.setText("Selected Date: "+ hour +":"+ minute+" "+am_pm);
                String time = hour + " " + minute;

                Intent intent = new Intent(Schedule_HourSelector.this, Payment_Screen.class);
                //intent.putExtra("time", time);
                //intent.putExtra("service", service);
                //intent.putExtra("date", date);


            }
        });
    }

    @Override
    public void onClick(View v) {

        Intent intent = new Intent(Schedule_HourSelector.this, Payment_Screen.class);


        startActivity(intent);

    }
}

