package com.example.nshopmainmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class ProfilePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_page);

        TextView textUsername = (TextView) findViewById(R.id.username);
        textUsername.setText(ProfileEditor.savedUsername);

        TextView textEmail = (TextView) findViewById(R.id.email);
        textEmail.setText(ProfileEditor.savedEmail);

    }

    public void onReturnClick(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void onEditClick(View view) {
        Intent intent = new Intent(this, ProfileEditor.class);
        startActivity(intent);
    }

    public void showMsg(View view){
        Toast toast = Toast.makeText(this, R.string.profile_page_message,Toast.LENGTH_SHORT);

        toast.show();
    }

}
