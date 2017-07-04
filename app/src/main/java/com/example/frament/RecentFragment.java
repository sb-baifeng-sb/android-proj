package com.example.frament;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.base.FragmentBase;
import com.example.ui.R;
import com.example.view.HeaderLayout;



 /*
  * 最近聊天的fragement
  * 桂深负责
  */

@SuppressLint("SimpleDateFormat")
public class RecentFragment extends FragmentBase {
	private HeaderLayout hlTitleBar;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_recent, container, false);
		hlTitleBar = (HeaderLayout) view.findViewById(R.id.common_actionbar);
		hlTitleBar.init(HeaderLayout.HeaderStyle.DEFAULT_TITLE);
		hlTitleBar.setDefaultTitle("recommend");
		return view;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);

	}

	 


	private boolean hidden;
	@Override
	public void onHiddenChanged(boolean hidden) {
		super.onHiddenChanged(hidden);
		this.hidden = hidden;
		if(!hidden){
			refresh();
		}
	}
	
	@Override
	public void onResume() {
		super.onResume();
		if(!hidden){
			refresh();
		}
	}
	
	public void refresh(){
		try {
			getActivity().runOnUiThread(new Runnable() {
				public void run() {
					 
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	



	 
	 

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();

	}
	


	@Override
	public void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		
	}

	

}
