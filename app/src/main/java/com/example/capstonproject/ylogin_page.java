package com.example.capstonproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ylogin_page extends AppCompatActivity {
    Button goSignupBtn, loginBtn;
    TextView textview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ylogin_page);


        goSignupBtn = (Button) findViewById(R.id.goSignupBtn);
        loginBtn = (Button) findViewById(R.id.loginbtn);
        TextView textview = (TextView) findViewById(R.id.textView);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //서버 통신 테스트
                String yMSG = "영준값"; //자신이 보내고싶은 값을 보내시면됩니다
                try{
                    yTask_test ytt = new yTask_test();
                    String rst = ytt.execute(yMSG).get();
                    Toast.makeText(getApplicationContext(), rst, Toast.LENGTH_SHORT).show();
                }catch (Exception e){
                    Log.i("loginpage custom-log",e.getMessage());
                    Toast.makeText(getApplicationContext(), "실패", Toast.LENGTH_SHORT).show();
                }
            }
        });



        goSignupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ysignup_page.class);
                startActivity(intent);
            }
        });



    }

}