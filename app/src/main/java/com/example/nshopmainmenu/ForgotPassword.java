package com.example.nshopmainmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ForgotPassword extends AppCompatActivity {

    Button btnForgot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forgot_password);

        btnForgot = findViewById(R.id.forgot_password_next_button);

        btnForgot.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent nextForgot = new Intent(ForgotPassword.this,VerificationEmail.class);
                startActivity(nextForgot);
            }
        });
    }
}
