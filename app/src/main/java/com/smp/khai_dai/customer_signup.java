package com.smp.khai_dai;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class customer_signup extends AppCompatActivity {
    private EditText customerFirstName;
    private EditText customerLastName;
    private EditText customerEmail;
    private EditText customerPhone;
    private EditText customerAddress;
    private EditText customerPass;
    private EditText customerPassConf;
    private CheckBox customerInfoCheck;
    private Button customerSignupBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customer_signup);
        findViews();
        onclick();
    }

    private void findViews() {
        customerFirstName = findViewById(R.id.customerFirstName);
        customerLastName = findViewById(R.id.customerLastName);
        customerEmail = findViewById(R.id.customerEmail);
        customerPhone = findViewById(R.id.customerPhone);
        customerAddress = findViewById(R.id.customerAddress);
        customerInfoCheck = findViewById(R.id.customerInfoCheck);
        customerPass = findViewById(R.id.customerPass);
        customerPassConf = findViewById(R.id.customerPassConf);
        customerSignupBtn = findViewById(R.id.customerSignupBtn);
    }

    private void onclick() {
        customerSignupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String customer_first_name = customerFirstName.getText().toString().trim();
                String customer_last_name = customerLastName.getText().toString().trim();
                String customer_email = customerEmail.getText().toString().trim();
                String customer_phone = customerPhone.getText().toString().trim();
                String customer_address = customerAddress.getText().toString().trim();
                String customer_pass = customerPass.getText().toString().trim();
                String customer_pass_conf = customerPassConf.getText().toString().trim();


                if (customer_first_name.isEmpty() || customer_last_name.isEmpty() || customer_email.isEmpty() || customer_phone.isEmpty() || customer_address.isEmpty() || customer_pass.isEmpty() || customer_pass_conf.isEmpty()){
                    Toast.makeText(customer_signup.this, "Please Fill-up all the Fields", Toast.LENGTH_SHORT).show();
                }
                else if (!Patterns.EMAIL_ADDRESS.matcher(customer_email).matches()) {
                    Toast.makeText(customer_signup.this, "Email is not Correct", Toast.LENGTH_SHORT).show();
                }
                else if (!customer_pass.equals(customer_pass_conf)) {
                    Toast.makeText(customer_signup.this, "Password Didn't Match. Please Re-Check", Toast.LENGTH_SHORT).show();
                }
                else if (!customerInfoCheck.isChecked()) {
                    Toast.makeText(customer_signup.this, "Please Check if all the info are correct and tick the box.", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(customer_signup.this, "Congratulations! Now, Login....", Toast.LENGTH_SHORT).show();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            startActivity(new Intent(customer_signup.this, login.class));
                        }
                    }, 2000); // 5000 milliseconds = 5 seconds delay

                }
            }
        });
    }


}
