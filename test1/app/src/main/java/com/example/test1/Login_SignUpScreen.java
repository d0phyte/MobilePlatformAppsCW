package com.example.test1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Login_SignUpScreen extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_sign_up_screen);
        Button button = (Button) findViewById(R.id.button2);
        button.setOnClickListener(this);
    }
    public void onClick(View v) {
        Intent intent = new Intent(Login_SignUpScreen.this, default_login.class);
        startActivity(intent);
    }
    public void GoToLogin2 (View view){
        Intent intent = new Intent(Login_SignUpScreen.this, default_login.class);
        startActivity(intent);
    }

    public void GoogleLogin (View view){
        //Intent intent = new Intent(MainActivity.this, Login_SignUpScreen.class);
        //startActivity(intent);
    }
}