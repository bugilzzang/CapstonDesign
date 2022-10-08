package com.example.capstonproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ActionMenuView;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView; //바텀 네비게이션 뷰
    ActionMenuView actionMenuView;
    Button buttonEvent;
    chomeFragment chomeFragment;
    ccommunityFragment ccommunityFragment;
    cchattingFragment cchattingFragment;
    crankingFragment crankingFragment;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chomeFragment = new chomeFragment();
        ccommunityFragment = new ccommunityFragment();
        cchattingFragment = new cchattingFragment();
        crankingFragment = new crankingFragment();


        //처음화면
        getSupportFragmentManager().beginTransaction().add(R.id.main_frame, new chomeFragment()).commit(); //FrameLayout에 fragment.xml 띄우기
        NavigationBarView navigationBarView = findViewById(R.id.bottomNavi);


        //바텀 네비게이션뷰 안의 아이템 설정
        navigationBarView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.home_fragment:
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, new chomeFragment()).commit();
                        return true;
                    case R.id.chatting_fragment:
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, new cchattingFragment()).commit();
                        return true;
                    case R.id.community_fragment:
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, new ccommunityFragment()).commit();
                        return true;
                    case R.id.ranking_fragment:
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, new crankingFragment()).commit();
                        return true;
                }
                return false;
            }
        });


    }  //oncreate
/*
    //타이틀 메뉴바에 관한 코드
    @Override
    public boolean onCreateOptionsMenu(Menu action_menu) {
        getMenuInflater().inflate(R.menu.menu_title_navi,action_menu);
        return true;
    }

 */
/*
    //@Override 오버라이딩이 안돼 시발 해결해줘
    public boolean onOptionsItemsSelected(@NonNull MenuItem item) {
        int curId = item.getItemId();
        switch (curId) {
            case R.id.action_btn1:
                Toast.makeText(this,"내정보" , Toast.LENGTH_SHORT).show();
            case R.id.action_btn2:
                Toast.makeText(this,"로그아웃" , Toast.LENGTH_SHORT).show();
            case R.id.action_btn3:
                Toast.makeText(this,"설정" , Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

 */
}