package com.lenovo.myadapter;

import java.util.ArrayList;
import java.util.List;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

public class MyPagerAda extends PagerAdapter {
	private List<View> list = new ArrayList<View>();
//	private List<String> tab=new ArrayList<String>();

	public MyPagerAda(List<View> list) {
		this.list = list;
		//this.tab=tab;
	}

	@Override
	public int getCount() {
		return list.size();
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		return arg0 == arg1;
	}

	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		container.addView(list.get(position));
		return list.get(position);

	}

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		container.removeView(list.get(position));
	}

//	public CharSequence getPageTitle(int position) {
//		return tab.get(position);
//
//	}

}
