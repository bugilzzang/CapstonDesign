package com.example.capstonproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.adapter.FragmentViewHolder;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ActionMenuView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView; //바텀 네비게이션 뷰
    ActionMenuView actionMenuView;
    Button all_match_list_btn , my_match_list_btn;
    chomeFragment chomeFragment;
    cmatch_addFragment cmatch_addFragment;
    cmatchFragment cmatchFragment;
    c_all_match_listFragment c_all_match_listFragment;
    c_my_match_listFragment c_my_match_listFragment;
    private RecyclerView mRecyclerView;
    private aMyRecyclerAdapter mRecyclerAdapter;
    private ArrayList<aFriendItem> mfriendItems;
    private RecyclerView.LayoutManager mLayoutManager;

    String is_login, user_id, user_name, user_team;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //매칭 리스트 프래그먼트 전환
        c_all_match_listFragment = new c_all_match_listFragment();
        c_my_match_listFragment = new c_my_match_listFragment();

        all_match_list_btn = (Button) findViewById(R.id.all_match_list_btn);  //동훈 수정할 것 널포인트 에러
        all_match_list_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.match_list_container, c_all_match_listFragment).commit();
            }
        });

        Button my_match_list_btn = findViewById(R.id.my_match_list_btn);
        my_match_list_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.match_list_container,c_my_match_listFragment).commit();
            }
        });
        //매칭 리스트 프래그먼트 전환


        //유저정보 스토리지
        SharedPreferences USERINFO = getSharedPreferences("USERINFO", MODE_PRIVATE);
        SharedPreferences.Editor editor = USERINFO.edit();

        is_login = USERINFO.getString("is_login", "로그인 안됨");
        user_id = USERINFO.getString("id", "아이디 없음");
        user_name = USERINFO.getString("name", "이름 없음");
        user_team = USERINFO.getString("team", "팀 없음");


        /**
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        mRecyclerAdapter = new aMyRecyclerAdapter();


        mRecyclerView.setAdapter(mRecyclerAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL,false));

        mfriendItems = new ArrayList<>();
        for(int i=1;i<=10;i++){
            if(i%2==0) {

                mfriendItems.add(new aFriendItem(R.drawable.afemaleimage, i + "번째 사람", i + "번째 상태메시지"));
            }
            else {
                mfriendItems.add(new aFriendItem(R.drawable.amerecenaryimage, i + "번째 사람", i + "번째 상태메시지"));
            }
        }
        mRecyclerAdapter.setFriendList(mfriendItems);
         **/

        //처음화면
        NavigationBarView navigationBarView = findViewById(R.id.bottomNavi);

        //오류확인
        Log.i("custom-home-log", USERINFO.getString("is_login", "로그인없음"));
        Log.i("custom-home-log", USERINFO.getString("id", "아이디없음"));
        Log.i("custom-home-log", USERINFO.getString("name", "이름없음"));
        Log.i("custom-home-log", USERINFO.getString("team", "팀없음"));

        if(is_login.equals("로그인상태")){
            getSupportFragmentManager().beginTransaction().add(R.id.main_frame, new chomeFragment(user_id, user_name, user_team)).commit();

        }else{
            getSupportFragmentManager().beginTransaction().add(R.id.main_frame, new chomeFragment("", "", "")).commit();

        }

        //바텀 네비게이션뷰 안의 아이템 설정
        navigationBarView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.home_fragment:
                        //로그인 시도가 true일때만 유저정보 뜨게 하기, 로그인 안됐으면 빈칸
                        if(is_login.equals("로그인상태")){
                            getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, new chomeFragment(user_id, user_name, user_team)).commit();

                        }else{
                            getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, new chomeFragment("유저아이디", "유저이름", "유저팀")).commit();

                        }
                        return true;
                    case R.id.match_add_fragment:
                        //getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, new cmatch_addFragment()).commit();
                        Intent intent = new Intent(getApplicationContext(),aadd_matching.class);
                        startActivity(intent);
                        return true;
                    case R.id.chatting_fragment:
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, new cchattingFragment()).commit();
                        return true;
                }
                return false;
            }
        });

        navigationBarView.bringToFront();
    }  //oncreate


    //매칭 프래그먼트 전환
    public void onFragmentChange(int num) {
        if (num == 0) {
            getSupportFragmentManager().beginTransaction().replace(R.id.match_list_container,c_all_match_listFragment).commit();
        }
        else if (num == 1) {
            getSupportFragmentManager().beginTransaction().replace(R.id.match_list_container,c_my_match_listFragment).commit();
        }
    }



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