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

public class chef_signup extends AppCompatActivity {
    private EditText chefFirstName;
    private EditText chefLastName;
    private EditText chefEmail;
    private EditText chefPhone;
    private EditText chefAddress;
    private EditText chefPass;
    private EditText chefPassConf;
    private CheckBox chefInfoCheck;
    private Button chefSignupBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chef_signup);
        findViews();
        onclick();
    }

    private void findViews() {
        chefFirstName = findViewById(R.id.chefFirstName);
        chefLastName = findViewById(R.id.chefLastName);
        chefEmail = findViewById(R.id.chefEmail);
        chefPhone = findViewById(R.id.chefPhone);
        chefAddress = findViewById(R.id.chefAddress);
        chefInfoCheck = findViewById(R.id.chefInfoCheck);
        chefPass = findViewById(R.id.chefPass);
        chefPassConf = findViewById(R.id.chefPassConf);
        chefSignupBtn = findViewById(R.id.chefSignupBtn);
    }

    private void onclick() {
        chefSignupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String chef_first_name = chefFirstName.getText().toString().trim();
                String chef_last_name = chefLastName.getText().toString().trim();
                String chef_email = chefEmail.getText().toString().trim();
                String chef_phone = chefPhone.getText().toString().trim();
                String chef_address = chefAddress.getText().toString().trim();
                String chef_pass = chefPass.getText().toString().trim();
                String chef_pass_conf = chefPassConf.getText().toString().trim();


                if (chef_first_name.isEmpty() || chef_last_name.isEmpty() || chef_email.isEmpty() || chef_phone.isEmpty() || chef_address.isEmpty() || chef_pass.isEmpty() || chef_pass_conf.isEmpty()){
                    Toast.makeText(chef_signup.this, "Please Fill-up all the Fields", Toast.LENGTH_SHORT).show();
                }
                else if (!Patterns.EMAIL_ADDRESS.matcher(chef_email).matches()) {
                    Toast.makeText(chef_signup.this, "Email is not Correct", Toast.LENGTH_SHORT).show();
                }
                else if (!chef_pass.equals(chef_pass_conf)) {
                    Toast.makeText(chef_signup.this, "Password Didn't Match. Please Re-Check", Toast.LENGTH_SHORT).show();
                }
                else if (!chefInfoCheck.isChecked()) {
                    Toast.makeText(chef_signup.this, "Please Check if all the info are correct and tick the box.", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(chef_signup.this, "Congratulations! Now, Login....", Toast.LENGTH_SHORT).show();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            startActivity(new Intent(chef_signup.this, login.class));
                        }
                    }, 2000); // 5000 milliseconds = 5 seconds delay

                }
            }
        });
    }


}
