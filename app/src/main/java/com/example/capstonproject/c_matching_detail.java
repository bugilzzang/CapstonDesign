package com.example.capstonproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class c_matching_detail extends AppCompatActivity {
    TextView textview_match_number;


    private Intent intent;
    String match_number;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cmatching_detail);

        intent = getIntent();
        match_number = intent.getStringExtra("match_number");

        textview_match_number = (TextView) findViewById(R.id.match_number);

        textview_match_number.setText(match_number);



    }
}