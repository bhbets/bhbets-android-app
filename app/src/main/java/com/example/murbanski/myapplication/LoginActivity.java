package com.example.murbanski.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;


public class LoginActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }

    public void login(View view){
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
    }

    public void registration(View view){
        startActivity(new Intent(getApplicationContext(), RegistrationActivity.class));
    }


}


