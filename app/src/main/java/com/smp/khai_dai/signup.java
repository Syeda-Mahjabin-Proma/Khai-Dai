package com.smp.khai_dai;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class signup extends AppCompatActivity {
    private RadioButton customer;
    private RadioButton chef;
    private RadioButton deliveryMan;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        findViews();
        onclick();
    }

    private void onclick() {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (customer.isChecked()){
                    startActivity(new Intent(signup.this, customer_signup.class));
                }
                else if (chef.isChecked()){
                    startActivity(new Intent(signup.this, chef_signup.class));
                }
                else if (deliveryMan.isChecked()){
                    startActivity(new Intent(signup.this, delivery_signup.class));
                }
                else {
                    Toast.makeText(signup.this, "Please Select One", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void findViews() {
        chef = findViewById(R.id.radioButtonChef);
        customer = findViewById(R.id.radioButtonCustomer);
        deliveryMan = findViewById(R.id.radioButtonDelivery);
        btn = findViewById(R.id.signup_option_choose);
    }
}