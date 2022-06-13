package com.example.myjava.reference;

import android.util.Log;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

public class SoftReferenceTest extends AbstractBaseReference {

    private List<Object> list = new ArrayList<>();

    @Override
    public void testReference() {

        byte[] bytes;
        for (int i = 0; i < 30; i++) {
            bytes = new byte[1024 * 10240];
            SoftReference<byte[]> reference = new SoftReference<>(bytes);
            list.add(reference);
        }

        System.gc();
        System.gc();
        for (int j = 0; j < list.size(); j++) {
            Object object = ((SoftReference) (list.get(j))).get();
            Log.d("SoftReferenceTest", "object = " +j + " " + object);

        }


    }
}

