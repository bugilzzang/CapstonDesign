package com.example.capstonproject;

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

        //서버 통신 테스트
        String sendmsg = "vision_write";
        String result = "영준값"; //자신이 보내고싶은 값을 보내시면됩니다
        try{
            String rst = new yTask_test(sendmsg).execute(result,"vision_write").get();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}