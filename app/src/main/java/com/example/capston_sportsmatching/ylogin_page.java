package com.example.capston_sportsmatching;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ylogin_page extends AppCompatActivity {
    Button goSignupBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ylogin_page);

        goSignupBtn = (Button) findViewById(R.id.goSignupBtn);

        goSignupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ysignup_page.class);
                startActivity(intent);
            }
        });
    }

}