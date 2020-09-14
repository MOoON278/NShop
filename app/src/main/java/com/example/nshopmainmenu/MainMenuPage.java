package com.example.nshopmainmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class MainMenuPage extends AppCompatActivity {

    Button btnLogout;
    FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu_page);

        btnLogout = findViewById(R.id.buttonLogout);

        btnLogout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                FirebaseAuth.getInstance().signOut();
                Intent toMain = new Intent(MainMenuPage.this,MainActivity.class);
                startActivity(toMain);
            }
        });

    }

    public void showMsg(View view){
        Toast toast = Toast.makeText(this, R.string.main_menu_message,Toast.LENGTH_SHORT);

        toast.show();
    }

    public void onBlackMaskClick(View view) {
        Intent intent = new Intent(this, ProductBlackMask.class);
        startActivity(intent);
    }

    public void onBlueMaskClick(View view){
        Intent intent = new Intent(this, ProductBlueMask.class);
        startActivity(intent);
    }

    public void onPurpleMaskClick(View view){
        Intent intent = new Intent(this, ProductPurpleMask.class);
        startActivity(intent);
    }

    public void onProfileClick(View view) {
        Intent intent = new Intent(this, ProfilePage.class);
        startActivity(intent);
    }

}