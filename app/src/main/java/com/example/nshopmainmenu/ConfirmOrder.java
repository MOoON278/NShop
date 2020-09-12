package com.example.nshopmainmenu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ConfirmOrder extends AppCompatActivity {


    private TextView name = (TextView) findViewById(R.id.nameOfProd);
    private TextView qty = (TextView) findViewById(R.id.numOfProd);
    private TextView total = (TextView) findViewById(R.id.totalPrice);

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.confirm_order);

        name.setText(String.format("%s", ProductVariable.prodName));
        qty.setText(String.format("%s", ProductVariable.prodQty));
        total.setText(String.format("%s", ProductVariable.prodTotalPrice));
    }

    public void onReturnClick(View view) {
        if (ProductVariable.prodName.equals("Black Mask")) {
            Intent intent = new Intent(this, ProductBlackMask.class);
            startActivity(intent);
        }
        else if (ProductVariable.prodName.equals("Blue Mask")) {
            Intent intent = new Intent(this, ProductBlackMask.class);
            startActivity(intent);
        }
        else if (ProductVariable.prodName.equals("Purple Mask")) {
            Intent intent = new Intent(this, ProductBlackMask.class);
            startActivity(intent);
        }
    }

    public void onConfirmClick(){

    }
}
