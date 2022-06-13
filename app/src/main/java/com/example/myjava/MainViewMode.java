package com.example.myjava;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class MainViewMode extends ViewModel {
    public MutableLiveData<String> mText = new MutableLiveData<>();

    private MutableLiveData<List<String>> users;
    public LiveData<List<String>> getUsers() {
        if (users == null) {
            users = new MutableLiveData<>();
            //loadUsers()
        }
        return users;
    }


}
