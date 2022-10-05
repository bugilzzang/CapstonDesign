package com.example.capston_sportsmatching;

import static android.graphics.Color.TRANSPARENT;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.app.FragmentManager;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ActionMenuView;
import android.widget.Button;
import android.widget.Toast;

import com.example.capston_sportsmatching.R;
import com.example.capston_sportsmatching.c_chattingFragment;
import com.example.capston_sportsmatching.c_communityFragment;
import com.example.capston_sportsmatching.c_homeFragment;
import com.example.capston_sportsmatching.c_rankingFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView; //바텀 네비게이션 뷰
    ActionMenuView actionMenuView;
    Button buttonEvent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        bottomNavigationView = findViewById(R.id.bottomNavi);
        //처음화면
        getSupportFragmentManager().beginTransaction().add(R.id.main_frame, new c_homeFragment()).commit(); //FrameLayout에 fragment.xml 띄우기

        //바텀 네비게이션뷰 안의 아이템 설정
        bottomNavigationView.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()) {
                    case R.id.home_fragment:
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, new c_homeFragment()).commit();
                        break;
                    case R.id.chatting_fragment:
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, new c_chattingFragment()).commit();
                        break;
                    case R.id.community_fragment:
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, new c_communityFragment()).commit();
                        break;
                    case R.id.ranking_fragment:
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, new c_rankingFragment()).commit();
                        break;
                }
                return;
            }


        });
    }

    //타이틀 메뉴바에 관한 코드
    @Override
    public boolean onCreateOptionsMenu(Menu action_menu) {
        getMenuInflater().inflate(R.menu.c_menu_title_navi,action_menu);
        return true;
    }

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
}
