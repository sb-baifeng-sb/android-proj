package com.example.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;



public class UiSlashActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.ui_slash);
    }
    @Override
    protected void onStart() {
        super.onStart();
        new Handler().postDelayed(new Thread() {
            @Override
            public void run() {
                startActivity(new Intent(UiSlashActivity.this,UiStartActivity.class));
                finish();
            }
        }, 500);
    }
}
