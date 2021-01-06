package com.example.viewmodeltest;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.viewmodeltest.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MyTest";

    private TextViewModel mTextViewModel;
    private TextView mTextView;
    private Button mButton;
    private Button mButton_Test;
    private Button mButton_serializable;
    private static int mTimes = 0;
    private ActivityMainBinding mBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mTextViewModel = new TextViewModel(getApplication());
        mTextView = mBinding.textview;

        final Observer<String> textobserver = new Observer<String>() {

            @Override
            public void onChanged(String s) {
                mTextView.setText(s);
            }
        };
        mTextViewModel.getText().observe(this, textobserver);
        mButton = mBinding.button;
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newText = "new Text" + String.valueOf(mTimes++);
                mTextViewModel.getText().setValue(newText);
            }
        });

        mButton_Test = mBinding.buttonTest;
        mButton_Test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TestActivity.class);
                MyParcelable myParcelable = new MyParcelable();
                myParcelable.setIntData(22);
                myParcelable.setStringData("test MyParcelable");
                intent.putExtra("MyParcelable", myParcelable);
                startActivity(intent);
            }
        });

        mButton_serializable = mBinding.buttonSerializable;
        mButton_serializable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TestActivity.class);
                MySerializable mySerializable = new MySerializable();
                mySerializable.setIntData(33);
                mySerializable.setStringData("test MySerializable");
                intent.putExtra("MySerializable", mySerializable);
                startActivity(intent);
            }
        });



        Log.d(TAG, "MainActivity::onCreate");
    }

    @Override
    public void onEnterAnimationComplete() {
    }
}