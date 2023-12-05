package com.example.test1;

import androidx.appcompat.app.AppCompatActivity;
import android.app.AlertDialog;
import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.provider.Settings;
import androidx.core.app.NotificationCompat;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationManagerCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Payment_Screen extends AppCompatActivity implements View.OnClickListener {

    private final String CHANNEL_ID = "personal_notification";
    private final int NOTIFICATION_ID = 001;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Intent incomingIntent = getIntent();

        int service = incomingIntent.getIntExtra("service",1);
        String date = incomingIntent.getStringExtra("date");
        String time = incomingIntent.getStringExtra("time");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_screen);
        Button button = (Button) findViewById(R.id.button9);
        button.setOnClickListener(this);

        //TextView Test = (TextView)findViewById(R.id.textView3);
        //Test.setText("Hello World");




    }

    @Override
    public void onClick(View view) {

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this,CHANNEL_ID);
        builder.setSmallIcon(R.drawable.ic_baseline_notifications_24);
        builder.setContentTitle("CC BarberShop Booking Successful!");
        builder.setContentText("Your booking is complete.");



        builder.setPriority(NotificationCompat.PRIORITY_HIGH);

        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(this);
        notificationManagerCompat.notify(NOTIFICATION_ID, builder.build());

        Intent intent = new Intent(Payment_Screen.this, MainActivity.class);
        startActivity(intent);


    }



}