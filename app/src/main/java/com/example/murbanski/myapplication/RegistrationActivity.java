package com.example.murbanski.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegistrationActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

    }

    public void register(View view){

        EditText editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        EditText editTextConfirmPassword = (EditText) findViewById(R.id.editTextConfirmPassword);

        if(editTextPassword.getText().toString().equals(editTextConfirmPassword.getText().toString())){
            startActivity(new Intent(getApplicationContext(), LoginActivity.class));

        }else{
            Toast.makeText(RegistrationActivity.this, "Passwords do not match.", Toast.LENGTH_LONG).show();
        }

    }

    public void sendData(){

        EditText editTextLogin = (EditText) findViewById(R.id.editTextLogin);
        EditText editTextPassword = (EditText) findViewById(R.id.editTextPassword);

        RegisterRequest request = new RegisterRequest(editTextLogin.getText().toString(), editTextPassword.getText().toString());

    }


}
