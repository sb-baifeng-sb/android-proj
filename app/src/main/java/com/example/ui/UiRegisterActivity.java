package com.example.ui;

import android.os.Bundle;
import android.os.Handler;

import com.example.base.BaseActivity;

import org.json.JSONObject;


public class UiRegisterActivity extends BaseActivity {


    @Override
    public void onComplete(JSONObject response) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_register);
    }

    @Override
    protected void onStart() {
        super.onStart();
        new Handler().postDelayed(new Thread() {
            @Override
            public void run() {


            }
        }, 500);
    }


}
