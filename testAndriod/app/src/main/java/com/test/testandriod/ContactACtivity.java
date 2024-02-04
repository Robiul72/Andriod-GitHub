package com.test.testandriod;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ContactACtivity extends AppCompatActivity {
    private Button buttontest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);



        buttontest=findViewById(R.id.contbtn);

        buttontest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ContactACtivity.this, HomeActivity.class);

                startActivity(intent);
            }

        });
    }
}