package com.example.myjava.reference;

import android.util.Log;

import com.example.myjava.MyTest1;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class WeakReferenceTest extends AbstractBaseReference {

    private List<Object> list = new ArrayList<>();

    @Override
    public void testReference() {

        byte[] bytes;
        for (int i = 0; i < 30; i++) {
            bytes = new byte[10240 * 10240];
            WeakReference<byte[]> reference = new WeakReference<>(bytes);
            list.add(reference);
        }
        System.gc();
        System.gc();
        for (int j = 0; j < list.size(); j++) {
            Object object = ((WeakReference) (list.get(j))).get();
            Log.d("SoftReferenceTest", "object = " +j + " " + object);

        }


    }
}

