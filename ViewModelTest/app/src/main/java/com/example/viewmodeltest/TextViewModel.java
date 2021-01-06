package com.example.viewmodeltest;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

public class TextViewModel extends AndroidViewModel {
    private static final String TAG = "MyTest";

    private MutableLiveData<String> mText;
    public TextViewModel(Application application) {
        super(application);
    }

    public MutableLiveData<String> getText() {
        if (mText == null) {
            mText = new MutableLiveData<String>();
        }
        return mText;
    }
}
