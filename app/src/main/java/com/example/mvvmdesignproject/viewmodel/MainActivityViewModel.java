package com.example.mvvmdesignproject.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.mvvmdesignproject.model.User;
import com.example.mvvmdesignproject.model.UserRepository;

public class MainActivityViewModel extends AndroidViewModel {

    UserRepository userRepository;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        userRepository = new UserRepository(application);
    }

    public LiveData<User[]> getAllUserData(){
        return userRepository.getUserData();
    }
}
