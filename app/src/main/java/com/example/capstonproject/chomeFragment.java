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
    c_all_match_listFragment c_all_match_listFragment;
    c_my_match_listFragment c_my_match_listFragment;

    chomeFragment chomeFragment = this;

    TextView user_name, user_major, user_team;
    public chomeFragment(String id, String major, String team){
        super();
        this.id = id;
        this.major = major;
        this.team = team;
    }



    Context ct;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        //USERINFO = getSharedPreferences("Userinfo", MODE_PRIVATE);
        View view = inflater.inflate(R.layout.fragment_chome, container, false);

        all_match_list_btn = (Button) view.findViewById(R.id.all_match_list_btn);
        my_match_list_btn = (Button) view.findViewById(R.id.my_match_list_btn);


        user_name = (TextView) view.findViewById(R.id.user_id);
        user_name.setText(id);
        user_major = (TextView) view.findViewById(R.id.user_major);
        user_major.setText(major);
        user_team = (TextView) view.findViewById(R.id.user_team);
        user_team.setText(team);



        FragmentTransaction ft = getFragmentManager().beginTransaction();

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

    public void set_all_match_list(){

    }

    public void set_my_match_list(){

    }
}