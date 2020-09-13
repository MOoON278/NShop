package com.example.nshopmainmenu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ShoppingCart extends AppCompatActivity {

    private RecyclerView recyclerView;
    ShoppingCartAdapter2
            adapter; // Create Object of the Adapter class
    DatabaseReference reff;

    /*ArrayList<Cart> products;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shopping_cart);

        /*// Lookup the recyclerview in activity layout
        RecyclerView rvShoppingCart = (RecyclerView) findViewById(R.id.rvShoppingCart);

        products = Cart.createProductsList(ConfirmOrder.numOrd);
        // Create adapter passing in the sample user data
        ShoppingCartAdapter adapter = new ShoppingCartAdapter(products);
        // Attach the adapter to the recyclerview to populate items
        rvShoppingCart.setAdapter(adapter);
        // Set layout manager to position the items
        rvShoppingCart.setLayoutManager(new LinearLayoutManager(this));*/

        String num = String.valueOf(ConfirmOrder.numOrd);

        reff = FirebaseDatabase.getInstance().getReference().child("Shopping Cart").child("C0001").child("1");

        recyclerView = findViewById(R.id.rvShoppingCart);

        // To display the Recycler view linearly
        recyclerView.setLayoutManager(
                new LinearLayoutManager(this));

        // It is a class provide by the FirebaseUI to make a
        // query in the database to fetch appropriate data
        FirebaseRecyclerOptions<shoppingcartproduct> options
                = new FirebaseRecyclerOptions.Builder<shoppingcartproduct>()
                .setQuery(reff, shoppingcartproduct.class)
                .build();
        // Connecting object of required Adapter class to
        // the Adapter class itself
        adapter = new ShoppingCartAdapter2(options);
        // Connecting Adapter class with the Recycler view*/
        recyclerView.setAdapter(adapter);
    }

    // Function to tell the app to start getting
    // data from database on starting of the activity
    @Override protected void onStart()
    {
        super.onStart();
        adapter.startListening();
    }

    // Function to tell the app to stop getting
    // data from database on stoping of the activity
    @Override protected void onStop()
    {
        super.onStop();
        adapter.stopListening();
    }


    /*public static class Cart {
        private static String pQty;
        private static String pPrice;
        private String mName;
        private String mPrice;
        private String mQuantity;

        public Cart(){}

        public Cart(String name, String qty, String price) {
            mName = name;
            mPrice = price;
            mQuantity = qty;
        }

        public String getName() {
            return mName;
        }

        public String getPrice() {
            return mPrice;
        }

        public String getQuantity() {
            return mQuantity;
        }

        public static ArrayList<Cart> createProductsList(int numOfProducts) {
            ArrayList<Cart> products = new ArrayList<Cart>();

            for (int i = 1; i <= numOfProducts; i++) {
                pQty = String.valueOf(ConfirmOrder.scpQty[i]);
                pPrice = String.valueOf(ConfirmOrder.scpPrice[i]);

                products.add(new Cart("Product Name: " + ConfirmOrder.scpName[i], "Quantity: " + pQty, "Price: RM" + pPrice));
            }

            return products;
        }
    }*/


    public void onReturnClick(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void onProfileClick(View view) {
        Intent intent = new Intent(this, ProfilePage.class);
        startActivity(intent);
    }

}
