package com.example.nshopmainmenu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ShoppingCart2 extends AppCompatActivity {

    TextView product_name, price, qty, total;
    com.google.firebase.database.DatabaseReference reff;

    private int times = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shopping_cart);


        product_name = (TextView) findViewById (R.id.productName1);
        price = (TextView) findViewById (R.id.productPrice1);
        qty = (TextView) findViewById (R.id.productQty1);
        total = (TextView) findViewById (R.id.price);

        String a = String.valueOf(ConfirmOrder.numOrd);

        reff = FirebaseDatabase.getInstance().getReference().child("Shopping Cart").child("C0001").child("1");
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String pName = dataSnapshot.child("Product Name").getValue().toString();
                String pPrice = dataSnapshot.child("Price").getValue().toString();
                String pQty = dataSnapshot.child("Quantity").getValue().toString();
                product_name.setText(pName);
                price.setText(pPrice);
                qty.setText(pQty);

                String pTotal = dataSnapshot.child("Current Total").getValue().toString();
                total.setText(pTotal);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }


    public void onReturnClick(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void onProfileClick(View view) {
        Intent intent = new Intent(this, ProfilePage.class);
        startActivity(intent);
    }

    public void onCheckoutClick(View view) {
        Intent intent = new Intent(this, PaymentPage.class);
        startActivity(intent);
    }
}
