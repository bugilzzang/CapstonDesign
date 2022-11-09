package com.example.capstonproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
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
    cmatch_addFragment cmatch_addFragment;
    cmatchFragment cmatchFragment;
    cchattingFragment cchattingFragment;
    activity_amatchinglist activity_amatchinglist;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chomeFragment = new chomeFragment();
        cmatch_addFragment = new cmatch_addFragment();
        cchattingFragment = new cchattingFragment();




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
                    case R.id.match_add_fragment:
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, new cmatch_addFragment()).commit();
                        return true;
                    case R.id.chatting_fragment:
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, new cchattingFragment()).commit();
                        return true;
                }
                return false;
            }
        });


    }  //oncreate
    //타이틀 메뉴바 관한 코드
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.c_menu_title_navi , menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
// 추가로 버튼에 동작 넣을거면 if 해서 넣으면 됩니다.
        if( id == R.id.longin_btn) {
            Intent intent = new Intent(getApplicationContext(), ylogin_page.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}