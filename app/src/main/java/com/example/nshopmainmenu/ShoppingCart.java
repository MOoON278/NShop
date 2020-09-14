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

public class ShoppingCart extends AppCompatActivity {

    TextView product_name, price, qty, total;
    com.google.firebase.database.DatabaseReference reff;
    private int a = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shopping_cart);



        while (a <= ConfirmOrder.numOrd) {
            if (a == 1) {

                String x = String.valueOf(a);
                product_name = (TextView) findViewById(R.id.productName1);
                price = (TextView) findViewById(R.id.productPrice1);
                qty = (TextView) findViewById(R.id.productQty1);
                total = (TextView) findViewById(R.id.price);


                reff = FirebaseDatabase.getInstance().getReference().child("Shopping Cart").child("C0001").child(x);
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
            else if (a == 2) {
                String x = String.valueOf(a);
                product_name = (TextView) findViewById(R.id.productName2);
                price = (TextView) findViewById(R.id.productPrice2);
                qty = (TextView) findViewById(R.id.productQty2);
                total = (TextView) findViewById(R.id.price);


                reff = FirebaseDatabase.getInstance().getReference().child("Shopping Cart").child("C0001").child(x);
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
            else if (a == 3) {
                String x = String.valueOf(a);
                product_name = (TextView) findViewById(R.id.productName3);
                price = (TextView) findViewById(R.id.productPrice3);
                qty = (TextView) findViewById(R.id.productQty3);
                total = (TextView) findViewById(R.id.price);


                reff = FirebaseDatabase.getInstance().getReference().child("Shopping Cart").child("C0001").child(x);
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
            else if (a == 4) {
                String x = String.valueOf(a);
                product_name = (TextView) findViewById(R.id.productName4);
                price = (TextView) findViewById(R.id.productPrice4);
                qty = (TextView) findViewById(R.id.productQty4);
                total = (TextView) findViewById(R.id.price);


                reff = FirebaseDatabase.getInstance().getReference().child("Shopping Cart").child("C0001").child(x);
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
            else if (a == 5) {
                String x = String.valueOf(a);
                product_name = (TextView) findViewById(R.id.productName5);
                price = (TextView) findViewById(R.id.productPrice5);
                qty = (TextView) findViewById(R.id.productQty5);
                total = (TextView) findViewById(R.id.price);


                reff = FirebaseDatabase.getInstance().getReference().child("Shopping Cart").child("C0001").child(x);
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
            else if (a == 6) {
                String x = String.valueOf(a);
                product_name = (TextView) findViewById(R.id.productName6);
                price = (TextView) findViewById(R.id.productPrice6);
                qty = (TextView) findViewById(R.id.productQty6);
                total = (TextView) findViewById(R.id.price);


                reff = FirebaseDatabase.getInstance().getReference().child("Shopping Cart").child("C0001").child(x);
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
            else if (a == 7) {
                String x = String.valueOf(a);
                product_name = (TextView) findViewById(R.id.productName7);
                price = (TextView) findViewById(R.id.productPrice7);
                qty = (TextView) findViewById(R.id.productQty7);
                total = (TextView) findViewById(R.id.price);


                reff = FirebaseDatabase.getInstance().getReference().child("Shopping Cart").child("C0001").child(x);
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
            else if (a == 8) {
                String x = String.valueOf(a);
                product_name = (TextView) findViewById(R.id.productName8);
                price = (TextView) findViewById(R.id.productPrice8);
                qty = (TextView) findViewById(R.id.productQty8);
                total = (TextView) findViewById(R.id.price);


                reff = FirebaseDatabase.getInstance().getReference().child("Shopping Cart").child("C0001").child(x);
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
            else if (a == 9) {
                String x = String.valueOf(a);
                product_name = (TextView) findViewById(R.id.productName9);
                price = (TextView) findViewById(R.id.productPrice9);
                qty = (TextView) findViewById(R.id.productQty9);
                total = (TextView) findViewById(R.id.price);


                reff = FirebaseDatabase.getInstance().getReference().child("Shopping Cart").child("C0001").child(x);
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
            else if (a == 10) {
                String x = String.valueOf(a);
                product_name = (TextView) findViewById(R.id.productName10);
                price = (TextView) findViewById(R.id.productPrice10);
                qty = (TextView) findViewById(R.id.productQty10);
                total = (TextView) findViewById(R.id.price);


                reff = FirebaseDatabase.getInstance().getReference().child("Shopping Cart").child("C0001").child(x);
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
            else if (a == 11) {
                String x = String.valueOf(a);
                product_name = (TextView) findViewById(R.id.productName11);
                price = (TextView) findViewById(R.id.productPrice11);
                qty = (TextView) findViewById(R.id.productQty11);
                total = (TextView) findViewById(R.id.price);


                reff = FirebaseDatabase.getInstance().getReference().child("Shopping Cart").child("C0001").child(x);
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
            else if (a == 12) {
                String x = String.valueOf(a);
                product_name = (TextView) findViewById(R.id.productName12);
                price = (TextView) findViewById(R.id.productPrice12);
                qty = (TextView) findViewById(R.id.productQty12);
                total = (TextView) findViewById(R.id.price);


                reff = FirebaseDatabase.getInstance().getReference().child("Shopping Cart").child("C0001").child(x);
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
            a++;
        }
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
