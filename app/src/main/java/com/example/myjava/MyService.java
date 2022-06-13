package com.example.myjava;


import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.HashMap;
import java.util.HashSet;

public class MyService extends Service {
    private MyBinder myBinder;
    Handler handler = new Handler();
    HashMap<String,String> hashMap = new HashMap<>();

    HashSet<String> hashSet = new HashSet<>();

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new MyBinder();
    }

    static class MyBinder extends IMyAidlInterface.Stub {

        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {
            Log.d("MyService", "basicTypes");
        }
    }

}
