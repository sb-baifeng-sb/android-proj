package com.example.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.base.BaseActivity;
import com.example.model.User;
import com.example.utils.JsonUtils;

import org.json.JSONException;
import org.json.JSONObject;


public class UiLoginActivity extends BaseActivity implements View.OnClickListener{

    private EditText username_et;
    private EditText password_et;
    @Override
    public void onComplete(JSONObject response) {

        try {
            String result = response.getString("result");
            User user = (User)(JsonUtils.parseResult(result).get(0));
            Log.i("test",user.getPortrait());
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_login);
        username_et = (EditText) findViewById(R.id.id_et_username);
        password_et = (EditText) findViewById(R.id.id_et_password);
        final Button login_btn = (Button) findViewById(R.id.id_btn_login);
        login_btn.setOnClickListener(this);
    }
    @Override
    protected void onStart() {
        super.onStart();

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.id_btn_login:
         /*       HashMap<String,String> params = new HashMap<>();
                params.put("method",BaseConfig.RequestMethod.LOGIN);
                params.put("username",username_et.getText().toString());
                params.put("password", password_et.getText().toString());
                doAsyncHttpClientTask(BaseConfig.RequestPath.USER_REQUEST, params);*/
                forward(UiMyFramentActivity.class);
        }
    }
}
