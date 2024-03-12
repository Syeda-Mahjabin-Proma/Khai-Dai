package com.smp.khai_dai;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class login extends AppCompatActivity {
    private RadioButton phone;
    private RadioButton email;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        findViews();
        onclick();
    }

    private void onclick() {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (email.isChecked()){
                    startActivity(new Intent(login.this, login_with_email.class));
                }
                else if (phone.isChecked()){
                    startActivity(new Intent(login.this, login_with_phone.class));
                }
                else {
                    Toast.makeText(login.this, "Please Select One", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void findViews() {
        email = findViewById(R.id.radioButtonEmail);
        phone = findViewById(R.id.radioButtonPhone);
        btn = findViewById(R.id.login_option_choose);
    }
}