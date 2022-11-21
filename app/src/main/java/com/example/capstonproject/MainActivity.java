package com.example.capstonproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
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
    Button buttonEvent;
    chomeFragment chomeFragment;
    cmatch_addFragment cmatch_addFragment;
    cmatchFragment cmatchFragment;
    cchattingFragment cchattingFragment;
    private RecyclerView mRecyclerView;
    private aMyRecyclerAdapter mRecyclerAdapter;
    private ArrayList<aFriendItem> mfriendItems;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

        //처음화면

        NavigationBarView navigationBarView = findViewById(R.id.bottomNavi);
        getSupportFragmentManager().beginTransaction().add(R.id.main_frame, new chomeFragment()).commit(); //FrameLayout에 fragment.xml 띄우기


        //바텀 네비게이션뷰 안의 아이템 설정
        navigationBarView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.home_fragment:
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, new chomeFragment()).commit();
                        return true;
                    case R.id.match_add_fragment:
                        //getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, new cmatch_addFragment()).commit();
                        Intent intent = new Intent(getApplicationContext(),a_add_match.class);
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