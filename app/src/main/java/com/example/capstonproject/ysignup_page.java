package com.example.capstonproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class ysignup_page extends AppCompatActivity {

    Button confirm_id, btn_submit;
    EditText user_id, user_pw, user_pw2, user_name, user_phone;
    RadioGroup sex_group;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ysignup_page);


        confirm_id = (Button) findViewById(R.id.confirm_id);
        btn_submit = (Button) findViewById(R.id.btn_submit);
        user_id = (EditText) findViewById(R.id.user_id);
        user_pw = (EditText) findViewById(R.id.user_pw);
        user_pw2 = (EditText) findViewById(R.id.user_pw2);
        user_name = (EditText) findViewById(R.id.user_name);
        user_phone = (EditText) findViewById(R.id.user_phonenumber);
        sex_group = (RadioGroup) findViewById(R.id.sex_group);


        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), yset_exercise_type.class);
                startActivity(intent);
            }
        });
    }
}