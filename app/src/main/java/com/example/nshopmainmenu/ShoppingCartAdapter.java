/*package com.example.nshopmainmenu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.firebase.ui.database.FirebaseRecyclerAdapter;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

// Create the basic adapter extending from RecyclerView.Adapter
// Note that we specify the custom ViewHolder which gives us access to our views
public class ShoppingCartAdapter extends RecyclerView.Adapter<ShoppingCartAdapter.ViewHolder> {

    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        static public TextView nameTextView;
        static public TextView quantityTextView;
        static public TextView priceTextView;


        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            nameTextView = (TextView) itemView.findViewById(R.id.product_name);
            quantityTextView = (TextView) itemView.findViewById(R.id.product_quantity);
            priceTextView = (TextView) itemView.findViewById(R.id.product_price);
        }
    }


        // Store a member variable for the contacts
        private List<ShoppingCart.Cart> mProducts;

        // Pass in the contact array into the constructor
        public ShoppingCartAdapter(ArrayList<ShoppingCart.Cart> products) {
            mProducts = products;
        }
    // ... constructor and member variables

    // Usually involves inflating a layout from XML and returning the holder
    @Override
    public ShoppingCartAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View productView = inflater.inflate(R.layout.shopping_cart_item, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(productView);
        return viewHolder;
    }

    // Involves populating data into the item through holder
    @Override
    public void onBindViewHolder(ShoppingCartAdapter.ViewHolder holder, int position) {
        // Get the data model based on position
        ShoppingCart.Cart products = mProducts.get(position);

        // Set item views based on your views and data model
        TextView textView1 = holder.nameTextView;
        textView1.setText(products.getName());
        TextView textView2 = holder.quantityTextView;
        textView2.setText(products.getQuantity());
        TextView textView3 = holder.priceTextView;
        textView3.setText(products.getPrice());


    }

    // Returns the total count of items in the list
    @Override
    public int getItemCount() {
        return mProducts.size();
    }
}*/