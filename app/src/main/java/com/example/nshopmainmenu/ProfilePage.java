package com.example.nshopmainmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ProfilePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_page);

        ImageView userProfilePic = (ImageView) findViewById(R.id.profileImg);
        userProfilePic.setImageBitmap(ProfileEditor.savedUserProfile);

        TextView textUsername = (TextView) findViewById(R.id.username);
        textUsername.setText(ProfileEditor.savedUsername);

        TextView textEmail = (TextView) findViewById(R.id.email);
        textEmail.setText(ProfileEditor.savedEmail);

        if(ProfileEditor.savedGender == "Male"){
            ImageView imgGender = (ImageView) findViewById(R.id.gender);
            imgGender.setImageResource(R.drawable.male);
        }
        else if(ProfileEditor.savedGender == "Female"){
            ImageView imgGender = (ImageView) findViewById(R.id.gender);
            imgGender.setImageResource(R.drawable.female);
        }

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
