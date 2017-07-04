package com.example.frament;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.base.FragmentBase;
import com.example.ui.R;
import com.example.view.HeaderLayout;


@TargetApi(Build.VERSION_CODES.FROYO)
@SuppressLint("SimpleDateFormat")
public class ContactFragment extends FragmentBase {
	private HeaderLayout hlTitleBar;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		final View view = inflater.inflate(R.layout.fragment_contacts,
				container, false);
		hlTitleBar = (HeaderLayout) view.findViewById(R.id.common_actionbar);
		hlTitleBar.init(HeaderLayout.HeaderStyle.DEFAULT_TITLE);
		hlTitleBar.setDefaultTitle("find");
		return view;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		// SourceDateList =
		// filledData(getActivity().getResources().getStringArray(R.array.date));
		super.onActivityCreated(savedInstanceState);

	}

	private boolean hidden;

	@Override
	public void onHiddenChanged(boolean hidden) {
		super.onHiddenChanged(hidden);
		this.hidden = hidden;
		if (!hidden) {
			Log.i("frament", "create ContactFragment onCreateView view hidden");
		}
	}

	@Override
	public void onResume() {
		super.onResume();

	}

}
