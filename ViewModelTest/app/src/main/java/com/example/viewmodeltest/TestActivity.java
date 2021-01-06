package com.example.viewmodeltest;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class TestActivity extends AppCompatActivity {
    private static final String TAG = "MyTest";
    private TextView mTextView_Parcelable;
    private TextView mTextView_Serializable;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        mTextView_Parcelable = (TextView) findViewById(R.id.textview_parcelable);
        mTextView_Serializable = (TextView)findViewById(R.id.textview_serializable);
        Intent intent = getIntent();
        if (intent != null) {
            MyParcelable myParcelable = intent.getParcelableExtra("MyParcelable");
            if (myParcelable != null) {
                Log.d(TAG, "MyParcelable :" + myParcelable.toString());
                mTextView_Parcelable.setText(myParcelable.getStringData() + ":" + myParcelable.getIntData());
            }

            MySerializable mySerializable = (MySerializable) intent.getSerializableExtra("MySerializable");
            if (mySerializable != null) {
                Log.d(TAG, "MySerializable :" + mySerializable.toString());
                mTextView_Serializable.setText(mySerializable.getStringData() + ":" + mySerializable.getIntData());
            }

        }
    }
}
