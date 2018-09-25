package com.example.murbanski.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LoginActivity extends AppCompatActivity implements View.OnClickListener, Callback<LoginResponse> {

    private final AuthorizationApi authorizationApi = new AuthorizationClient();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        EditText editTextPassword = findViewById(R.id.etPassword);
        findViewById(R.id.btnLogin).setOnClickListener(this);
        findViewById(R.id.btnRegistration).setOnClickListener(this);
        if (hasSavedCredentials()) {
            authorizationApi.login(loadCredentials()).enqueue(this);
        }
        editTextPassword.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                boolean handled = false;
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    login();
                    handled = true;
                }
                return handled;
            }
        });
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
            saveCredentials();
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

    private void saveCredentials() {
        EditText editTextLogin = findViewById(R.id.etLogin);
        EditText editTextPassword = findViewById(R.id.etPassword);
        SharedPreferences saveGame = getSharedPreferences("Save", MODE_PRIVATE);
        SharedPreferences.Editor save = saveGame.edit();
        save.putString("login", editTextLogin.getText().toString());
        save.putString("password", editTextPassword.getText().toString());
        save.apply();
    }

    private Credentials loadCredentials() {
        SharedPreferences preferences = getSharedPreferences("Save", MODE_PRIVATE);
        return new Credentials(
                preferences.getString("login", null),
                preferences.getString("password", null)
        );
    }

    private boolean hasSavedCredentials() {
        SharedPreferences preferences = getSharedPreferences("Save", MODE_PRIVATE);
        return preferences.contains("login") && preferences.contains("password");
    }
}


