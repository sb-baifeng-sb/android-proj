package com.example.ui;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;


import com.gc.materialdesign.views.ButtonRectangle;


public class UiStartActivity extends Activity implements View.OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.ui_start);
        final ButtonRectangle login_btn = (ButtonRectangle) findViewById(R.id.login_button);
        final ButtonRectangle register_btn = (ButtonRectangle) findViewById(R.id.register_button);
        login_btn.setBackgroundColor(Color.GREEN);
        login_btn.setOnClickListener(this);
        register_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login_button:
                startActivity(new Intent(UiStartActivity.this,UiLoginActivity.class));
                break;
            case R.id.register_button:
                startActivity(new Intent(UiStartActivity.this,UiRegisterActivity.class));
                break;
        }
    }

    @Override
    protected void onStart() {
        super.onStart();

    }


}
