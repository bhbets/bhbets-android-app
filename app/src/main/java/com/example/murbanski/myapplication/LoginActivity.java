package com.example.murbanski.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LoginActivity extends AppCompatActivity implements View.OnClickListener, Callback<LoginResponse> {

    private final AuthorizationApi authorizationApi = new AuthorizationClient();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        findViewById(R.id.btnLogin).setOnClickListener(this);
        findViewById(R.id.btnRegistration).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnLogin) {
            login();
        } else if (view.getId() == R.id.btnRegistration) {
            startActivity(new Intent(this, RegistrationActivity.class));
        }
    }

    @Override
    public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
        if (response.isSuccessful()) {
            startActivity(new Intent(this, MainActivity.class));
        } else {
            Toast.makeText(this, "Something went wrong: " + response.message(), Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onFailure(Call<LoginResponse> call, Throwable t) {
        Toast.makeText(this, "Bad credentials", Toast.LENGTH_LONG).show();
    }

    private void login() {
        EditText editTextLogin = findViewById(R.id.etLogin);
        EditText editTextPassword = findViewById(R.id.etPassword);

        Credentials credentials = new Credentials(
            editTextLogin.getText().toString(),
            editTextPassword.getText().toString()
        );

        authorizationApi.login(credentials).enqueue(this);
    }
}


