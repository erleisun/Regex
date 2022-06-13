package com.example.myjava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;

import com.example.myjava.reference.ReferenceFactory;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        testSoftReference(2);

        ThreadLocal<Looper> threadLocal = new ThreadLocal<>();
        threadLocal.set(Looper.getMainLooper());
        Looper looper = threadLocal.get();
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("123");

        getLifecycle().addObserver(new MainPresenter());

        ViewModelProvider.AndroidViewModelFactory instance
                = ViewModelProvider.AndroidViewModelFactory.getInstance(this.getApplication());
        MainViewMode mainViewMode = instance.create(MainViewMode.class);
        mainViewMode.mText.setValue("1");
        mainViewMode.mText.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {

            }
        });
    }

    private void testSoftReference(int type) {
        ReferenceFactory.getInstance().getReference(type).testReference();


        startActivity(new Intent());
    }

    private void startService() {
        Intent intent = new Intent("android.intent.action.MyService");

        bindService(intent, new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {

                IMyAidlInterface iMyAidlInterface = IMyAidlInterface.Stub.asInterface(service);
                try {
                    iMyAidlInterface.basicTypes(1, 1, true, 1, 1, "aa");
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {

            }
        }, BIND_AUTO_CREATE);


    }


}
