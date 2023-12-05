package com.example.test1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.view.View;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class Service_SelectionScreen extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_selection_screen);




        Button button1 = (Button) findViewById(R.id.buttonCut);
        Button button2 = (Button) findViewById(R.id.buttonWash);
        Button button3 = (Button) findViewById(R.id.buttonCutAndWash);
        Button button4 = (Button) findViewById(R.id.buttonStyle);
        Button button5 = (Button) findViewById(R.id.buttonCustom);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);


    }

    public void onClick(View v) {
    int service;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("service");

    //myRef.addValueEventListener(new ValueEventListener() {
            //@Override
            //public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                //String value = dataSnapshot.getValue(String.class);
                //Log.d("TAG", "Value is: " + value);
            //}

            //@Override
            //public void onCancelled(DatabaseError error) {
                // Failed to read value
                //Log.w("TAG", "Failed to read value.", error.toException());
            //}
    //});




        switch(v.getId())
            {
                case R.id.buttonCut:
                    service = 1;
                    myRef.setValue(service);

                    break;
                case R.id.buttonWash:
                    service = 2;
                    myRef.setValue(service);


                    break;
                case R.id.buttonCutAndWash:
                    service = 3;
                    myRef.setValue(service);


                    break;
                case R.id.buttonStyle:
                    service = 4;
                    myRef.setValue(service);


                    break;
                case R.id.buttonCustom:
                    service = 5;
                    myRef.setValue(service);


                    break;


                default:
                    throw new RuntimeException("Unknown button ID");
            }




            Intent intent = new Intent(Service_SelectionScreen.this, Schedule_Calendar.class);
            intent.putExtra("service", service);
            startActivity(intent);

        }

    }











