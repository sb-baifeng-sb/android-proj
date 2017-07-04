package com.example.base;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.ui.R;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;


/**
 * Created by admin on 2015/6/21.
 */
abstract public class BaseActivity extends ActionBarActivity {
    public static final int GETALLDRIVERS = 1;
    protected boolean showLoadBar = false;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case GETALLDRIVERS:
                    onComplete((JSONObject) msg.obj);
                    break;
            }
        }
    };

    public void doAsyncHttpClientTask(String url, HashMap<String, String> params) {
        AsyncHttpClient client = BaseHttpClient.getInstance();
        RequestParams requestParams = new RequestParams(params);

        client.post(BaseConfig.api + url, requestParams, new JsonHttpResponseHandler() {
            @Override
            public void onStart() {
                super.onStart();
                showLoadBar();
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                // If the response is JSONObject instead of expected JSONArray
                handler.obtainMessage(GETALLDRIVERS, response).sendToTarget();
                hideLoadBar();
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray timeline) {
                // Pull out the first event on the public timeline
                try {
                    JSONObject firstEvent = (JSONObject) timeline.get(0);
                    String tweetText = firstEvent.getString("message");
                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    hideLoadBar();
                }


            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                hideLoadBar();
                toast("connectfail");
                Log.i("fail", "failing mission");
            }
        });
    }
    public void toast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
    public void hideLoadBar() {
        if (showLoadBar) {
            this.findViewById(R.id.main_load_bar).setVisibility(View.GONE);
            showLoadBar = false;
        }
    }
    public void showLoadBar() {
        this.findViewById(R.id.main_load_bar).setVisibility(View.VISIBLE);
        this.findViewById(R.id.main_load_bar).bringToFront();
        showLoadBar = true;
    }
    public void forward(Class<?> clazz){
        Intent intent = new Intent();
        intent.setClass(this, clazz);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        this.startActivity(intent);
        this.finish();
    }
    public void forward (Class<?> classObj, Bundle params) {
        Intent intent = new Intent();
        intent.setClass(this, classObj);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtras(params);
        this.startActivity(intent);
        this.finish();
    }
    public void overlay(Class<?> classObj) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
        intent.setClass(this, classObj);
        startActivity(intent);
    }

    public void overlay(Class<?> classObj, Bundle params) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
        intent.setClass(this, classObj);
        intent.putExtras(params);
        startActivity(intent);
    }

    public abstract void onComplete(JSONObject response);
}
