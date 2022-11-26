package com.example.capstonproject;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class chomeFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private aMyRecyclerAdapter mRecyclerAdapter;
    private ArrayList<aFriendItem> mfriendItems;
    String id, major, team;
    Button all_match_list_btn, my_match_list_btn;

    chomeFragment chomeFragment = this;

    TextView user_name, user_major, user_team;
    public chomeFragment(String id, String major){
        super();
        this.id = id;
        this.major = major;
    }



    Context ct;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //매칭정보 요청
        try{
            String request; //모든 매칭 정보 요청
            yTask ytask = new yTask("match_info");
            String result = ytask.execute().get();
        }catch (Exception e){
            Log.i("chome-customLog", e.getMessage());
        }
        //USERINFO = getSharedPreferences("Userinfo", MODE_PRIVATE);
        View view = inflater.inflate(R.layout.fragment_chome, container, false);

        all_match_list_btn = (Button) view.findViewById(R.id.all_match_list_btn);
        my_match_list_btn = (Button) view.findViewById(R.id.my_match_list_btn);


        user_name = (TextView) view.findViewById(R.id.user_id);
        user_name.setText(id);
        user_major = (TextView) view.findViewById(R.id.user_major);
        user_major.setText(major);




        mRecyclerView = (RecyclerView) view.findViewById(R.id.match_list_container);

        mRecyclerAdapter = new aMyRecyclerAdapter();


        mRecyclerView.setAdapter(mRecyclerAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(ct = container.getContext()));
        mRecyclerView.setLayoutManager(new LinearLayoutManager(ct = container.getContext(), RecyclerView.VERTICAL,false));

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






        all_match_list_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result;
                try{
                    SharedPreferences USERINFO = ct.getSharedPreferences("USERINFO", MODE_PRIVATE);
                    String request; //내 매칭만 정보 요청
                    // 매칭 번호, 매칭 제목,
                    yTask ytask = new yTask("match_info");
                    result = ytask.execute(USERINFO.getString("id", "")).get();
                }catch (Exception e){
                    Log.i("chome-customLog", e.getMessage());
                }


                //매칭리스트 reload시점
                mfriendItems.clear();
                for(int i=1;i<=10;i++){
                    if(i%2==0) {

                        mfriendItems.add(new aFriendItem(R.drawable.afemaleimage, i + "번째 사람", i + "번째 상태메시지"));
                    }
                    else {
                        mfriendItems.add(new aFriendItem(R.drawable.amerecenaryimage, i + "번째 사람", i + "번째 상태메시지"));
                    }
                }
                mRecyclerAdapter.setFriendList(mfriendItems);

            }
        });

        my_match_list_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mfriendItems.clear();
                for(int i=1;i<=10;i++){
                    if(i%2==0) {

                        mfriendItems.add(new aFriendItem(R.drawable.afemaleimage, i + "번째 사람", i + "번째 상태메시지"));
                    }
                    else {
                        mfriendItems.add(new aFriendItem(R.drawable.afemaleimage, i + "번째 사람", i + "번째 상태메시지"));
                    }
                }
                mRecyclerAdapter.setFriendList(mfriendItems);

            }
        });


        return view;
    }
}