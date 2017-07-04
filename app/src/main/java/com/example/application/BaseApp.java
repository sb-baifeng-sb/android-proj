package com.example.application;

import org.litepal.LitePalApplication;
/*
 * 应用的核心application类，初始化了加载网络图片的
 * imageloader
 * 
 */
public class BaseApp  extends LitePalApplication{
//	public static ServiceManager serviceManager;

	public static boolean isQuickIn = false;
	
	public static BaseApp mInstance;


	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();

		mInstance = this;

	}

	public static BaseApp getInstance() {
		return mInstance;
	}
	


}
