package com.example.capstonproject;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ActionMenuView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

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
    NumberPicker match_day, match_month;
    TimePicker match_time;
    Spinner match_major;

    String str_sex = "", str_exercise = "", str_type = "", str_month= "", str_day= "", str_hour= "", str_minute= "", str_time= "", str_major= "";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aadd_matching);

        SharedPreferences USERINFO = getSharedPreferences("USERINFO", MODE_PRIVATE); //영준
        //처음화면



        //aad_matching 버튼 연결
        match_subject = (EditText) findViewById(R.id.match_subject);
        edittext_persons = (EditText) findViewById(R.id.edittext_persons);
        match_major = (Spinner) findViewById(R.id.match_major);
        radio_groupsex = (RadioGroup) findViewById(R.id.radio_groupsex);
        btn_ok = (Button) findViewById(R.id.btn_ok);
        radio_groupexercise = (RadioGroup) findViewById(R.id.radio_groupexercise);
        radio_group_type = (RadioGroup) findViewById(R.id.radio_group_type);
        match_month = (NumberPicker) findViewById(R.id.match_month);
        match_day = (NumberPicker) findViewById(R.id.match_day);
        match_time = (TimePicker) findViewById(R.id.match_time);

        
        //매칭 날짜 설정
        match_month.setMaxValue(12);
        match_month.setMinValue(1);
        match_day.setMaxValue(31);
        match_day.setMinValue(1);

        match_month.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                str_month = "";
                if(newVal>=10){
                    str_month += newVal;
                }else{
                    str_month += "0" + newVal;
                }
            }
        });

        match_day.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                str_day = "";
                if(newVal>=10){
                    str_day += newVal;
                }else{
                    str_day += "0" + newVal;
                }
            }
        });

        //시간설정
        match_time.setIs24HourView(true);
        match_time.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {

                str_hour = "";
                str_minute = "";

                if(hourOfDay>=10){
                    str_hour += hourOfDay;
                }else{
                    str_hour += "0" + hourOfDay;
                }

                if(minute >= 10){
                    str_minute += minute;
                 }else{
                    str_minute += "0" + minute;
                }

            }
        });


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
                        str_exercise = "soccer";
                        break;
                    case R.id.rg_btnfootball:
                        str_exercise = "football";
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

        match_major.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                str_major = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });




        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str_time = str_month + str_day + str_hour + str_minute;
                str_major = edittext_major.getText().toString();


                try{
                    yTask summit_task = new yTask("addMatching");
                    String result;
                    StringBuilder param = new StringBuilder();
                    param.append("&a='1'," + "&match_owner=" + USERINFO.getString("id", "")
                            + "&match_title=" + match_subject.getText() + "&exercise_type=" + str_exercise
                            + "&match_type=" + str_type + "&match_time=" + str_time + "&match_persons=" + edittext_persons.getText()
                            + "&match_sex=" + str_sex+ "&match_major=" + str_major);

                    result =  summit_task.execute(param.toString()).get();
                    Log.i("addMatching-customLog", result);

                    if(result.equals("삽입성공")){

                        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(intent);
                    }
                }catch(Exception e){
                    Log.i("addMatching-customLog", e.getMessage());
                }


            }
        });



    }

}