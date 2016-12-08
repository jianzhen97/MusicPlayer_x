package com.lenovo.myadapter;

import java.util.ArrayList;

import com.example.playerbasead.R;
import com.lenovo.vo.GridMainMenu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;



public class GridAdapter extends BaseAdapter {
Context context;
ArrayList<GridMainMenu> list=new ArrayList<GridMainMenu>();

 public  GridAdapter(Context context,ArrayList<GridMainMenu> list) {
	this.context=context;
	this.list=list;
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
		
		View view=convertView;
		
	 //  view=View.inflate(this, R.layout.griditem, null);
		//view.inflate(this,R.layout.griditem, null);
		LayoutInflater inflater=LayoutInflater.from(context);
		view=inflater.inflate(R.layout.griditem, null);
		
		TextView textView=(TextView) view.findViewById(R.id.tv1_griditem);
		TextView textView2=(TextView) view.findViewById(R.id.tv2_griditem);
		ImageView imageView=(ImageView) view.findViewById(R.id.image_griditem);
		
		
		textView.setText(list.get(position).getNum());
		textView2.setText(list.get(position).getText());
		imageView.setImageResource(list.get(position).getImage());
		
		return view;
	}
    
}
