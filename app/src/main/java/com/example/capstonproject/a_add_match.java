package com.example.capstonproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ActionMenuView;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class a_add_match extends AppCompatActivity {
    BottomNavigationView bottomNavigationView; //바텀 네비게이션 뷰
    ActionMenuView actionMenuView;
    Button buttonEvent;
    chomeFragment chomeFragment;
    cmatch_addFragment cmatch_addFragment;
    cmatchFragment cmatchFragment;
    cchattingFragment cchattingFragment;


        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.a_add_matching);

            //처음화면

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

        }

