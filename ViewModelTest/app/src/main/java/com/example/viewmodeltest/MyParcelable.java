package com.example.viewmodeltest;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

public class MyParcelable implements Parcelable {
    private static final String TAG = "MyTest";
    private String mStringData;
    private int mIntData;

    public MyParcelable() {
        mStringData = "";
        mIntData = -1;
    }

    public String getStringData() {
        return mStringData;
    }
    public void setStringData(String stringData) {
        mStringData = stringData;
    }
    public int getIntData() {
        return mIntData;
    }
    public void setIntData(int intData) {
        mIntData = intData;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mStringData);
        dest.writeInt(mIntData);
    }


    public static final Parcelable.Creator<MyParcelable> CREATOR = new Parcelable.Creator<MyParcelable>() {
        public MyParcelable createFromParcel (Parcel in) {
            return new MyParcelable(in);
        }

        public MyParcelable[] newArray( int size) {
            return new MyParcelable[size];
        }
    };

    private MyParcelable(Parcel in) {
        mStringData = in.readString();
        mIntData = in.readInt();
    }

    @Override
    public String toString() {
        return "MyParcelable{" +
                "mStringData='" + mStringData + '\'' +
                ", mIntData=" + mIntData +
                '}';
    }
}
