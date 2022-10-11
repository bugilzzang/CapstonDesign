package com.example.capstonproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import java.util.ArrayList;

public class yset_exercise_type extends AppCompatActivity {

    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yset_exercise_type);

        viewPager = findViewById(R.id.viewPager);

        //페이지 갯수
        viewPager.setOffscreenPageLimit(2);

        y_Adapter adapter = new y_Adapter(getSupportFragmentManager());

        set_exercise_page1 sep1 = new set_exercise_page1();
        set_exercise_page2 sep2 = new set_exercise_page2();
        adapter.addItem(sep1);
        adapter.addItem(sep2);

        viewPager.setAdapter(adapter);
    }




    //adapter class
    class y_Adapter extends FragmentStatePagerAdapter{
        ArrayList<Fragment> items = new ArrayList<Fragment>();

        public y_Adapter(FragmentManager fm){
            super(fm);
        }

        public void addItem(Fragment item){
            items.add(item);
        }

        public Fragment getItem(int position){
            return items.get(position);
        }

        public int getCount(){
            return items.size();
        }

        public CharSequence getPageTitle(int position){
            return "페이지" + position;
        }

    }
}