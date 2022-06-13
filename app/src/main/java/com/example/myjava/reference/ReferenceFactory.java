package com.example.myjava.reference;

public class ReferenceFactory {

    private AbstractBaseReference abstractBaseReference;
    private static ReferenceFactory mInstance;

    public static ReferenceFactory getInstance() {
        if (mInstance == null) {
            mInstance = new ReferenceFactory();
        }
        return mInstance;
    }

    private ReferenceFactory() {

    }

    public AbstractBaseReference getReference(int type) {
        switch (type) {
            case 1:
                abstractBaseReference = new SoftReferenceTest();
                break;
            case 2:
                abstractBaseReference = new WeakReferenceTest();
                break;
        }

        return abstractBaseReference;
    }


}
