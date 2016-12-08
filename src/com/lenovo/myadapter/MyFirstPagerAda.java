package com.lenovo.myadapter;

import java.util.ArrayList;
import java.util.List;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

public class MyFirstPagerAda extends PagerAdapter {
	List<View> viewlistList = new ArrayList<View>();

	public MyFirstPagerAda(List<View> viewList) {
            this.viewlistList=viewList;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return viewlistList.size();
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		// TODO Auto-generated method stub
		return arg0 == arg1;
	}

	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		container.addView(viewlistList.get(position));
		return viewlistList.get(position);
	}

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		container.removeView(viewlistList.get(position));
	}

}
