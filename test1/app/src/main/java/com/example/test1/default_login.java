package com.example.test1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class default_login extends AppCompatActivity {
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_default_login);
        mAuth = FirebaseAuth.getInstance();


    }

    public void CreateAccount(View view){

        //SIGNUP WITH EMAIL BUTTON ON DEFAULT LOGIN XML

        EditText emailView = findViewById(R.id.email);
        EditText passwordView = findViewById(R.id.password);

        String password = passwordView.getText().toString();
        String email = emailView.getText().toString();

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(default_login.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("TAG", "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();

                            Intent intent = new Intent(default_login.this, Service_SelectionScreen.class);

                            startActivity(intent);

                            //updateUI(user); add stuff here intent
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("TAG", "createUserWithEmail:failure", task.getException());
                            Toast.makeText(default_login.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();

                            Intent intent = new Intent(default_login.this, Login_SignUpScreen.class);

                            startActivity(intent);
                            //updateUI(null); add stuff here intent
                        }
                    }
                });
    }


    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){

            Intent intent = new Intent(default_login.this, Login_SignUpScreen.class);

            startActivity(intent);
            //reload();
        }
    }







}