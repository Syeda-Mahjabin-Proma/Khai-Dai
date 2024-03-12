package com.smp.khai_dai;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class login_with_phone extends AppCompatActivity {
    private EditText phone;
    private EditText pass;
    private Button login_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_with_phone);
        findViews();
        onclick();
    }

    private void onclick() {
        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber = phone.getText().toString().trim();
                String password = pass.getText().toString().trim();
                if (password.isEmpty() || phoneNumber.isEmpty()){
                    Toast.makeText(login_with_phone.this, "Please Fill-up Both", Toast.LENGTH_SHORT).show();
                }
                else {
                    startActivity(new Intent(login_with_phone.this, user_home.class));
                }
            }
        });
    }

    private void findViews() {
        login_btn = findViewById(R.id.loginBtn);
        phone = findViewById(R.id.phone_number);
        pass = findViewById(R.id.phone_pass);
    }
}
