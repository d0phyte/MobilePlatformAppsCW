package com.example.test1;

import androidx.annotation.NonNull;
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
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth mAuth;
    Button button1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        mAuth = FirebaseAuth.getInstance();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         Button button = (Button) findViewById(R.id.button);
         button.setOnClickListener(this);


    }



    public void button1function(View view) {
        //button1.setText("Button has been clicked");
    }



    public void onClick(View v) {
        Intent intent = new Intent(MainActivity.this, Service_SelectionScreen.class);
        startActivity(intent);
    }

    public void GoToLogin(View view){
        Intent intent = new Intent(MainActivity.this, Login_SignUpScreen.class);
        startActivity(intent);
    }


    //@Override
    //public void onClick(View view) {


}