package com.example.nshopmainmenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

// FirebaseRecyclerAdapter is a class provided by
// FirebaseUI. it provides functions to bind, adapt and show
// database contents in a Recycler View
public class ShoppingCartAdapter2 extends FirebaseRecyclerAdapter<
        shoppingcartproduct, ShoppingCartAdapter2.shoppingCartsViewholder> {

    public ShoppingCartAdapter2(@NonNull FirebaseRecyclerOptions<shoppingcartproduct> options)
    {
        super(options);
    }

    // Function to bind the view in Card view(here
    // "person.xml") iwth data in
    // model class(here "person.class")
    @Override
    protected void
    onBindViewHolder(@NonNull shoppingCartsViewholder holder,
                     int position, @NonNull shoppingcartproduct model)
    {

        // Add firstname from model class (here
        // "person.class")to appropriate view in Card
        // view (here "person.xml")
        holder.prodName.setText(model.getProductName());

        // Add lastname from model class (here
        // "person.class")to appropriate view in Card
        // view (here "person.xml")
        holder.prodQty.setText(model.getProductQuantity());

        // Add age from model class (here
        // "person.class")to appropriate view in Card
        // view (here "person.xml")
        holder.prodPrice.setText(model.getProductPrice());
    }

    // Function to tell the class about the Card view (here
    // "person.xml")in
    // which the data will be shown
    @NonNull
    @Override
    public shoppingCartsViewholder
    onCreateViewHolder(@NonNull ViewGroup parent,
                       int viewType)
    {
        View view
                = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.shopping_cart_item, parent, false);
        return new ShoppingCartAdapter2.shoppingCartsViewholder(view);
    }

    // Sub Class to create references of the views in Crad
    // view (here "person.xml")
    class shoppingCartsViewholder
            extends RecyclerView.ViewHolder {
        TextView prodName, prodQty, prodPrice;
        public shoppingCartsViewholder(@NonNull View itemView)
        {
            super(itemView);

            prodName
                    = itemView.findViewById(R.id.firstname);
            prodQty = itemView.findViewById(R.id.lastname);
            prodPrice = itemView.findViewById(R.id.age);
        }
    }
}
