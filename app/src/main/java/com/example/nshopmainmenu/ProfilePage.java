package com.example.nshopmainmenu;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ProfilePage extends AppCompatActivity {

    TextView user_name, user_email;
    com.google.firebase.database.DatabaseReference reff;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_page);

        user_name = (TextView) findViewById (R.id.username);
        user_email = (TextView) findViewById (R.id.email);

        reff = FirebaseDatabase.getInstance().getReference().child("Users").child("1");
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot){
                String name = dataSnapshot.child("Username").getValue().toString();
                String email = dataSnapshot.child("Email").getValue().toString();
                String imgGen = dataSnapshot.child("Gender").getValue().toString();
                user_name.setText(name);
                user_email.setText(email);
                if (imgGen.equals("M")) {
                    ImageView imgGender = (ImageView) findViewById(R.id.gender);
                    imgGender.setImageResource(R.drawable.male);
                }
                else if (imgGen.equals("F")) {
                    ImageView imgGender = (ImageView) findViewById(R.id.gender);
                    imgGender.setImageResource(R.drawable.female);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError){

            }
        });


        if (ProfileEditor.imageSetChecker == 1) {
            ImageView userProfilePic = (ImageView) findViewById(R.id.profileImg);
            userProfilePic.setImageBitmap(ProfileEditor.savedUserProfile);
        }
        else if (ProfileEditor.imageSetChecker == 0){
            ImageView userProfilePic = (ImageView) findViewById(R.id.profileImg);
            userProfilePic.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.profile));
        }

        /*TextView textUsername = (TextView) findViewById(R.id.username);
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
        }*/

    }


    public void onReturnClick(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void onAboutUsClick(View view) {
        Intent intent = new Intent(this, AboutUs.class);
        startActivity(intent);
    }

    public void onContactUsClick(View view) {
        Intent intent = new Intent(this, ContactUs.class);
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



















































