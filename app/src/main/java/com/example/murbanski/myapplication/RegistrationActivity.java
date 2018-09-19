package com.example.murbanski.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class RegistrationActivity extends AppCompatActivity {

    RegisterObject user;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

    }

    public void register(View view){

        startActivity(new Intent(getApplicationContext(), MainActivity.class));
        finish();
    }

    public void sendData(){

        EditText editTextLogin = (EditText) findViewById(R.id.editTextLogin);
        EditText editTextPassword = (EditText) findViewById(R.id.editTextPassword);

        user.setUsername(editTextLogin.getText().toString());
        user.setPassword(editTextPassword.getText().toString());

    }


}
