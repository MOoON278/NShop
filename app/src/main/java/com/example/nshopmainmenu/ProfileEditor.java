package com.example.nshopmainmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class ProfileEditor extends AppCompatActivity {

    char gender;
    Button save;

    static String savedUsername = "MOoON";
    static String savedEmail = "planetmoon@galaxymail.com";
    static String savedPostal = "04022001";
    static String savedAddress = "Milky Way, Solar System, Planet Earth, Orbit 1, Moon";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_editor);
    }

    public void onSaveClick(View view){
        EditText email = (EditText)findViewById(R.id.email);
        EditText postal = (EditText)findViewById(R.id.postal);
        EditText address = (EditText)findViewById(R.id.address);
        EditText username = (EditText)findViewById(R.id.username);

        savedUsername = username.getText().toString();
        savedEmail = email.getText().toString();
        savedPostal = postal.getText().toString();
        savedAddress = address.getText().toString();

        showMsg(view);
        onReturnClick(view);
    }

    public void showMsg(View view){
        Toast toast = Toast.makeText(this, R.string.saved,Toast.LENGTH_SHORT);

        toast.show();
    }

    public void onReturnClick(View view) {
        Intent intent = new Intent(this, ProfilePage.class);
        startActivity(intent);
    }
}
