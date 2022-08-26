package com.example.mvvmdesignproject.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.util.Log;

import com.example.mvvmdesignproject.R;
import com.example.mvvmdesignproject.adapter.UserAdapter;
import com.example.mvvmdesignproject.model.User;
import com.example.mvvmdesignproject.viewmodel.MainActivityViewModel;
import android.support.v4.app.Fragment;
public class MainActivity extends AppCompatActivity {

    MainActivityViewModel mainActivityViewModel;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recerler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //mainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);
        //mainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);



        mainActivityViewModel.getAllUserData().observe(this, new Observer<User[]>() {
            @Override
            public void onChanged(User[] users) {

                recyclerView.setAdapter(new UserAdapter(users));
            }
        });
    }
}