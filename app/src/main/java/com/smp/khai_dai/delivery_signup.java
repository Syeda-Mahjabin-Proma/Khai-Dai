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

public class delivery_signup extends AppCompatActivity {
    private EditText deliveryManFirstName;
    private EditText deliveryManLastName;
    private EditText deliveryManEmail;
    private EditText deliveryManPhone;
    private EditText deliveryManPass;
    private EditText deliveryManPassConf;
    private CheckBox deliveryManInfoCheck;
    private Button deliveryManSignupBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delivery_signup);
        findViews();
        onclick();
    }

    private void findViews() {
        deliveryManFirstName = findViewById(R.id.deliveryManFirstName);
        deliveryManLastName = findViewById(R.id.deliveryManLastName);
        deliveryManEmail = findViewById(R.id.deliveryManEmail);
        deliveryManPhone = findViewById(R.id.deliveryManPhone);
        deliveryManInfoCheck = findViewById(R.id.deliveryManInfoCheck);
        deliveryManPass = findViewById(R.id.deliveryManPass);
        deliveryManPassConf = findViewById(R.id.deliveryManPassConf);
        deliveryManSignupBtn = findViewById(R.id.deliveryManSignupBtn);
    }

    private void onclick() {
        deliveryManSignupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String deliveryMan_first_name = deliveryManFirstName.getText().toString().trim();
                String deliveryMan_last_name = deliveryManLastName.getText().toString().trim();
                String deliveryMan_email = deliveryManEmail.getText().toString().trim();
                String deliveryMan_phone = deliveryManPhone.getText().toString().trim();
                String deliveryMan_pass = deliveryManPass.getText().toString().trim();
                String deliveryMan_pass_conf = deliveryManPassConf.getText().toString().trim();


                if (deliveryMan_first_name.isEmpty() || deliveryMan_last_name.isEmpty() || deliveryMan_email.isEmpty() || deliveryMan_phone.isEmpty() || deliveryMan_pass.isEmpty() || deliveryMan_pass_conf.isEmpty()){
                    Toast.makeText(delivery_signup.this, "Please Fill-up all the Fields", Toast.LENGTH_SHORT).show();
                }
                else if (!Patterns.EMAIL_ADDRESS.matcher(deliveryMan_email).matches()) {
                    Toast.makeText(delivery_signup.this, "Email is not Correct", Toast.LENGTH_SHORT).show();
                }
                else if (!deliveryMan_pass.equals(deliveryMan_pass_conf)) {
                    Toast.makeText(delivery_signup.this, "Password Didn't Match. Please Re-Check", Toast.LENGTH_SHORT).show();
                }
                else if (!deliveryManInfoCheck.isChecked()) {
                    Toast.makeText(delivery_signup.this, "Please Check if all the info are correct and tick the box.", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(delivery_signup.this, "Congratulations! Now, Login....", Toast.LENGTH_SHORT).show();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            startActivity(new Intent(delivery_signup.this, login.class));
                        }
                    }, 2000); // 5000 milliseconds = 5 seconds delay

                }
            }
        });
    }


}
