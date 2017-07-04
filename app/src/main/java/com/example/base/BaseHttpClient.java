package com.example.base;

import com.loopj.android.http.AsyncHttpClient;

/**
 * Created by admin on 2015/7/3.
 */
public class BaseHttpClient extends AsyncHttpClient {
    private static BaseHttpClient syncHttpClient = new BaseHttpClient();
    private BaseHttpClient(){

    }
    public static BaseHttpClient getInstance(){
        return syncHttpClient;
    }
}
