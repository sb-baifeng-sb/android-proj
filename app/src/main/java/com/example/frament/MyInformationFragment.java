package com.example.frament;


import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.base.FragmentBase;
import com.example.ui.R;
import com.example.view.CImageView;
import com.example.view.HeaderLayout;


/*
 * 我的fragment暂时未实现
 * 同恺负责
 */

@SuppressLint("SimpleDateFormat")
public class MyInformationFragment extends FragmentBase {
	private CImageView networkImageView;
	private TextView username_tv = null;
	private TextView userage_tv = null;
	private TextView userselfdes_tv = null;
	private ImageView usergender_im = null;
	private SharedPreferences sharedPrefs;
	 
	private Button updateInfor_btn = null;
	private Bitmap cacheBit = null;
	private HeaderLayout hlTitleBar;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
	 View view = inflater.inflate(R.layout.fragment_myinfor, container, false);
	 hlTitleBar = (HeaderLayout) view.findViewById(R.id.common_actionbar);
	 hlTitleBar.init(HeaderLayout.HeaderStyle.DEFAULT_TITLE);
	 hlTitleBar.setDefaultTitle("mine");
		return view;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);


	}
}
