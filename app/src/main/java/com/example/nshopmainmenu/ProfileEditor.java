package com.example.nshopmainmenu;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Picture;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.FileNotFoundException;
import java.io.IOException;

public class ProfileEditor extends AppCompatActivity {

    private RadioButton radioGenderButton1;
    private RadioButton radioGenderButton2;

    public static final int GET_FROM_GALLERY = 3;

    static String savedUsername = "MOoON";
    static String savedEmail = "planetmoon@galaxymail.com";
    static String savedPostal = "04022001";
    static String savedAddress = "Milky Way, Solar System, Planet Earth, Orbit 1, Moon";
    static String savedGender = "Male";
    static Bitmap savedUserProfile = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_editor);
    }

    public void onSaveClick(View view) {
        EditText email = (EditText) findViewById(R.id.email);
        EditText postal = (EditText) findViewById(R.id.postal);
        EditText address = (EditText) findViewById(R.id.address);
        EditText username = (EditText) findViewById(R.id.username);

        radioGenderButton1 = (RadioButton) findViewById(R.id.male);
        radioGenderButton2 = (RadioButton) findViewById(R.id.female);

        savedUsername = username.getText().toString();
        savedEmail = email.getText().toString();
        savedPostal = postal.getText().toString();
        savedAddress = address.getText().toString();

        if (radioGenderButton1.isChecked())
        {
            savedGender = "Male";
        }
        else if (radioGenderButton2.isChecked())
        {
            savedGender = "Female";
        }
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

    public void onUploadClick(View view) {
        startActivityForResult(new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.INTERNAL_CONTENT_URI), GET_FROM_GALLERY);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //Detects request codes
        if(requestCode==GET_FROM_GALLERY && resultCode == Activity.RESULT_OK) {
            Uri selectedImage = data.getData();
            Bitmap bitmap = null;
            try {
                bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), selectedImage);
                savedUserProfile = bitmap;
                Toast toast = Toast.makeText(this, (R.string.profile_pic_update),Toast.LENGTH_SHORT);
                toast.show();
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
