package com.lenovo.myadapter;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.playerbasead.R;
import com.lenovo.vo.SongInfo;

public class MyAdapter extends BaseAdapter {

	Context context;
	ArrayList<SongInfo> list = new ArrayList<SongInfo>();

	public MyAdapter(Context context, ArrayList<SongInfo> list) {
		this.context = context;
		this.list = list;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		// View view = convertView;
		// LayoutInflater Inflater = LayoutInflater.from(context);
		// view = Inflater.inflate(R.layout.item, null);

		View view;
		ViewHold viewHold = new ViewHold();
		if (convertView == null) {
			LayoutInflater Inflater = LayoutInflater.from(context);
			view = Inflater.inflate(R.layout.item, null);
			viewHold.textView = (TextView) view.findViewById(R.id.name);
			viewHold.textView2 = (TextView) view.findViewById(R.id.singer);
			view.setTag(viewHold);
		} else {
			view = convertView;
			viewHold = (ViewHold) view.getTag();
		}
		viewHold.textView.setText(list.get(position).getSong());
		viewHold.textView2.setText(list.get(position).getSinger());
		return view;
	}

	class ViewHold {
		TextView textView;
		TextView textView2;
	}
}
