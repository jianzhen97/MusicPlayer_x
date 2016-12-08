package com.lenovo.main;

import java.util.ArrayList;


import com.example.playerbasead.R;
import com.lenovo.myadapter.GridAdapter;
import com.lenovo.vo.GridMainMenu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

public class MainGridActivity extends Activity implements OnItemClickListener{
	GridView gridView;
	ArrayList<GridMainMenu> list=new ArrayList<GridMainMenu>();
	GridAdapter griAdapter;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.mainmenu1grid);
		init();
		gridView = (GridView) findViewById(R.id.gridView1_mainmenu1);
        gridView.setOnItemClickListener(this);
		griAdapter = new GridAdapter(this, list);
		gridView.setAdapter(griAdapter);
	}

	public void init() {
		GridMainMenu g = new GridMainMenu("4", "我的音乐",
				R.drawable.icon_local_music);
		GridMainMenu g2 = new GridMainMenu("4", "我的最爱",
				R.drawable.icon_favorites);
		GridMainMenu g3 = new GridMainMenu("4", "文件夹",
				R.drawable.icon_folder_plus);
		GridMainMenu g4 = new GridMainMenu("4", "歌手",
				R.drawable.icon_artist_plus);
		GridMainMenu g5 = new GridMainMenu("4", "风格",
				R.drawable.icon_local_music);
		GridMainMenu g6 = new GridMainMenu("4", "专辑",
				R.drawable.icon_album_plus);
		GridMainMenu g7 = new GridMainMenu("4", "下载管理",
				R.drawable.icon_download);
		GridMainMenu g8 = new GridMainMenu("4", "音乐圈",
				R.drawable.icon_list_item_sort);
		GridMainMenu g9 = new GridMainMenu("4", "定制首页",
				R.drawable.icon_home_custom);
		
		list.add(g);
		list.add(g2);
		list.add(g3);
		list.add(g4);
		list.add(g5);
		list.add(g6);
		list.add(g7);
		list.add(g8);
		list.add(g9);
		//
		//也可以这样一步下来
//		list.add(new GridMainMenu("2", "听歌识曲", R.drawable.a4));
//		list.add(new GridMainMenu("2", "听歌识曲", R.drawable.a4));
//		list.add(new GridMainMenu("2", "听歌识曲", R.drawable.a4));
	}
	


	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
		switch (position) {
		case 0:
			Intent intent=new Intent(this, MusicListActivity.class);
			startActivity(intent);
			break;

		default:
			break;
		}
	}
 
}
