package com.smp.khai_dai;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Pattern;

public class login_with_email extends AppCompatActivity {
    private EditText email;
    private EditText pass;
    private Button login_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_with_email);
        findViews();
        onclick();
    }

    private void onclick() {
        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailAddress = email.getText().toString().trim();
                String password = pass.getText().toString().trim();

                if (password.isEmpty() || emailAddress.isEmpty()){
                    Toast.makeText(login_with_email.this, "Please Fill-up Both", Toast.LENGTH_SHORT).show();
                }

                else if (!Patterns.EMAIL_ADDRESS.matcher(emailAddress).matches()) {
                    Toast.makeText(login_with_email.this, "Email is not Correct", Toast.LENGTH_SHORT).show();
                }
                else {
                    startActivity(new Intent(login_with_email.this, user_home.class));
                }
            }
        });
    }

    private void findViews() {
        login_btn = findViewById(R.id.loginBtn);
        email = findViewById(R.id.email_address);
        pass = findViewById(R.id.email_pass);
    }
}
