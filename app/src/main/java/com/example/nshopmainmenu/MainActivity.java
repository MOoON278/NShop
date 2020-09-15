package com.example.nshopmainmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    //The login page which allows user to pick their ways to get into the menu.

    EditText emailId, password;
    Button btnLogIn;
    TextView tvSignUp, tvForgotPassword;
    FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;
    String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFirebaseAuth = FirebaseAuth.getInstance();
        emailId = findViewById(R.id.editTextEmail);
        password = findViewById(R.id.editTextPassword);
        tvSignUp = findViewById(R.id.textSignUp);
        tvForgotPassword = findViewById(R.id.textForgotPassword);
        btnLogIn = findViewById(R.id.buttonLogIn);

        mAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser mFirebaseUser = mFirebaseAuth.getCurrentUser();
                Toast.makeText(MainActivity.this,"Please login",Toast.LENGTH_SHORT).show();
            }
        };

        btnLogIn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                email = emailId.getText().toString();
                String pwd = password.getText().toString();
                if (email.isEmpty()){
                    emailId.setError("Please enter email id");
                    emailId.requestFocus();
                }
                else if (pwd.isEmpty()){
                    password.setError("Please enter your password");
                    password.requestFocus();
                }
                else if (email.isEmpty() && pwd.isEmpty()){
                    Toast.makeText(MainActivity.this, "Fields are empty!",Toast.LENGTH_SHORT).show();
                }
                else if (!(email.isEmpty() && pwd.isEmpty())){
                    mFirebaseAuth.signInWithEmailAndPassword(email, pwd).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (!task.isSuccessful()){
                                Toast.makeText(MainActivity.this, "Login Error, Please login again",Toast.LENGTH_SHORT).show();

                            }
                            else{
                                Intent toHome = new Intent(MainActivity.this,Menu.class);
                                startActivity(toHome);
                                SignUp.cusNum++; //When login successfully, it will add a value to cusNum (to 1) (Used as counter)
                                //It is used to determine which user information should the Firebase fetch for the user.
                                //But due to Firebase cannot create child with variable? The code was scrapped and change to hard coded one.
                                //In the Firebase database, we have allowed 3 user spaces.
                                //First login will use the data stored in the 1 child in database which is aloha chan.
                                //After logout and login again will use second stored data which is MOoON2.
                                //Third one is empty, allowing the user to create account with it.
                                //But still can sign up in first login tho, it only overwrites the first user's data.
                            }
                        }
                    });
                }
                else{
                    Toast.makeText(MainActivity.this, "Error Occurred!",Toast.LENGTH_SHORT).show();
                }
            }


        });

        tvSignUp.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent signUp = new Intent(MainActivity.this,SignUp.class);
                startActivity(signUp);
            }
        });

        tvForgotPassword.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent forgotPassword = new Intent(MainActivity.this,ForgotPassword.class);
                startActivity(forgotPassword);
            }
        });

    }

    @Override
    protected void onStart(){
        super.onStart();
        mFirebaseAuth.addAuthStateListener(mAuthStateListener);
    }

    public void onShoppingCartClick(View view) {
        Intent intent = new Intent(this, ShoppingCart.class);
        startActivity(intent);
    }

    public void onCheckoutClick(View view) {
        Intent intent = new Intent(this, PaymentPage.class);
        startActivity(intent);
    }
}
