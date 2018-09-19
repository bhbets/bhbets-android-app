package com.example.murbanski.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegistrationActivity extends AppCompatActivity implements View.OnClickListener, Callback<ResponseBody> {

    private final AuthorizationApi authorizationApi = new AuthorizationClient();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        findViewById(R.id.buttonRegister).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        EditText editTextLogin = findViewById(R.id.editTextLogin);
        EditText editTextPassword = findViewById(R.id.editTextPassword);

        Credentials credentials = new Credentials(
                editTextLogin.getText().toString(),
                editTextPassword.getText().toString()
        );

        authorizationApi.register(credentials)
                .enqueue(this);
    }

    @Override
    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
        if (response.isSuccessful()) {
            startActivity(new Intent(getApplicationContext(), LoginActivity.class));
        } else {
            Toast.makeText(this, "registration failed: " + response.message(), Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onFailure(Call<ResponseBody> call, Throwable t) {
        Toast.makeText(this, "registration failed: " + t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
    }
}
