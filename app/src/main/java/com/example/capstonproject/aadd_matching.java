package com.example.capstonproject;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ActionMenuView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class aadd_matching extends AppCompatActivity {
    BottomNavigationView bottomNavigationView; //바텀 네비게이션 뷰
    ActionMenuView actionMenuView;
    Button buttonEvent;
    chomeFragment chomeFragment;
    cmatch_addFragment cmatch_addFragment;
    cmatchFragment cmatchFragment;
    EditText match_subject, edittext_persons, edittext_major;
    Button btn_ok;
    RadioGroup radio_groupsex, radio_groupexercise, radio_group_type;
    DatePicker match_time;


    String str_sex, str_excercise, str_type;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aadd_matching);

        SharedPreferences USERINFO = getSharedPreferences("USERINFO", MODE_PRIVATE); //영준
        //처음화면


        NavigationBarView navigationBarView = findViewById(R.id.bottomNavi);
        //aad_matching 버튼 연결
        match_subject = (EditText) findViewById(R.id.match_subject);
        edittext_persons = (EditText) findViewById(R.id.edittext_persons);
        edittext_major = (EditText) findViewById(R.id.edittext_major);
        radio_groupsex = (RadioGroup) findViewById(R.id.radio_groupsex);
        btn_ok = (Button) findViewById(R.id.btn_ok);
        radio_groupexercise = (RadioGroup) findViewById(R.id.radio_groupexercise);
        radio_group_type = (RadioGroup) findViewById(R.id.radio_group_type);
        match_time = (DatePicker) findViewById(R.id.match_time);


        radio_groupsex.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rg_btnman:
                        str_sex = "man";
                        break;
                    case R.id.rg_btnfemale:
                        str_sex = "female";
                        break;
                }
            }
        });

        radio_groupexercise.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rg_btnsoccer:
                        str_excercise = "soccer";
                        break;
                    case R.id.rg_btnfootball:
                        str_excercise = "football";
                        break;
                }
            }
        });

        radio_group_type.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rg_btn_mercenary:
                        str_type = "merecenary";
                        break;
                    case R.id.rg_btn_rival:
                        str_type = "rival";
                        break;
                }
            }
        });


    }

}