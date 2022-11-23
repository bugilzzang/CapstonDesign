package com.example.capstonproject;

import static android.content.Context.MODE_PRIVATE;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class chomeFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private aMyRecyclerAdapter mRecyclerAdapter;
    private ArrayList<aFriendItem> mfriendItems;
    String id, major, team;

    TextView user_name, user_major, user_team;
    public chomeFragment(String id, String major, String team){
        super();
        this.id = id;
        this.major = major;
        this.team = team;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //USERINFO = getSharedPreferences("Userinfo", MODE_PRIVATE);
        View view = inflater.inflate(R.layout.fragment_chome, container, false);

        user_name = (TextView) view.findViewById(R.id.user_id);
        user_name.setText(id);
        user_major = (TextView) view.findViewById(R.id.user_major);
        user_major.setText(major);
        user_team = (TextView) view.findViewById(R.id.user_team);
        user_team.setText(team);

        return view;
    }


}