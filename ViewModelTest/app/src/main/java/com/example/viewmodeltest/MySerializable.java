package com.example.viewmodeltest;

import java.io.Serializable;

public class MySerializable implements Serializable {
    private String mStringData;
    private int mIntData;

    public MySerializable() {

    }

    public void setIntData(int intData) {
        mIntData = intData;
    }

    public int getIntData() {
        return mIntData;
    }

    public void setStringData(String stringData) {
        mStringData = stringData;
    }

    public String getStringData() {
        return mStringData;
    }

    @Override
    public String toString() {
        return "MySerializable{" +
                "mStringData='" + mStringData + '\'' +
                ", mIntData=" + mIntData +
                '}';
    }
}
