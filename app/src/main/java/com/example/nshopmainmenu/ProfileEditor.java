package com.example.nshopmainmenu;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.FileNotFoundException;
import java.io.IOException;

public class ProfileEditor extends AppCompatActivity {

    TextView user_name, user_email, user_postal, user_address;
    RadioGroup radio_pick;
    RadioButton picked1, picked2;
    private DatabaseReference reff;
    private Button btn, btnUpdate;



    public static final int GET_FROM_GALLERY = 3;


    static int imageSetChecker = 0;
    static String savedUsername = "MOoON";
    static String savedEmail = "planetmoon@galaxymail.com";
    static String savedPostal = "04022001";
    static String savedAddress = "Milky Way, Solar System, Planet Earth, Orbit 1, Moon";
    static String savedGender = "Male";
    static Bitmap savedUserProfile = null;

    String newUsername;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_editor);

        user_name = (EditText) findViewById (R.id.username);
        user_email = (EditText) findViewById (R.id.email);
        user_postal = (EditText) findViewById (R.id.postal);
        user_address = (EditText) findViewById (R.id.address);
        radio_pick = (RadioGroup) findViewById(R.id.radio);



        reff = FirebaseDatabase.getInstance().getReference().child("Users").child("1");
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot){
                String name = dataSnapshot.child("Username").getValue().toString();
                String email = dataSnapshot.child("Email").getValue().toString();
                String postal = dataSnapshot.child("Postal").getValue().toString();
                String address = dataSnapshot.child("Address").getValue().toString();
                user_name.setText(name);
                user_email.setText(email);
                user_postal.setText(postal);
                user_address.setText(address);
                if (dataSnapshot.child("Gender").getValue().toString().equals("M")) {
                    radio_pick.check(R.id.Male);
                }
                else if (dataSnapshot.child("Gender").getValue().toString().equals("F")) {
                    radio_pick.check(R.id.Female);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError){

            }
        });

        if (imageSetChecker == 1) {
            ImageView userProfilePic = (ImageView) findViewById(R.id.image);
            userProfilePic.setImageBitmap(ProfileEditor.savedUserProfile);
        }
        else if (imageSetChecker == 0){
            ImageView userProfilePic = (ImageView) findViewById(R.id.image);
            userProfilePic.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.profile));
        }
    }

    public void onSaveClick(View view) {
        reff = FirebaseDatabase.getInstance().getReference().child("Users").child("1");

        String name = user_name.getText().toString();
        String email = user_email.getText().toString();
        String postal = user_postal.getText().toString();
        String address = user_address.getText().toString();

        reff.child("Username").setValue(name);
        reff.child("Email").setValue(email);
        reff.child("Postal").setValue(postal);
        reff.child("Address").setValue(address);

        radio_pick = (RadioGroup) findViewById(R.id.radio);
        picked1 = (RadioButton) findViewById(R.id.Male);
        picked2 = (RadioButton) findViewById(R.id.Female);

        if(radio_pick.getCheckedRadioButtonId() != -1) {
            if (picked1.isChecked()) {
                reff.child("Gender").setValue("M");
            }
            else if (picked2.isChecked()) {
                reff.child("Gender").setValue("F");
            }
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

    public void changePic() {
        ImageView userProfilePic = (ImageView) findViewById(R.id.image);
        userProfilePic.setImageBitmap(ProfileEditor.savedUserProfile);
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
                changePic();
                Toast toast = Toast.makeText(this, (R.string.profile_pic_update),Toast.LENGTH_SHORT);
                toast.show();
                imageSetChecker = 1;
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
