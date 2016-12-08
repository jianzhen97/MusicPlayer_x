package com.lenovo.main;

import java.util.ArrayList;
import java.util.List;


import com.example.playerbasead.R;
import com.lenovo.myadapter.GridAdapter;
import com.lenovo.myadapter.MyPagerAda;
import com.lenovo.vo.GridMainMenu;

import android.app.Activity;
import android.app.LocalActivityManager;
import android.content.Intent;
import android.graphics.Color;
import android.location.GpsStatus.Listener;
import android.os.Bundle;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainMenuActivity extends Activity implements OnClickListener {

	List<View> pagerList = new ArrayList<View>();
	List<String> tabList = new ArrayList<String>();
	MyPagerAda pagerAda;
	ViewPager viewPager;
	long exitTime = 0;
	private LocalActivityManager manager;
	TextView textView1;
	TextView textView2;
	TextView textView3;
	TextView textView4;
	TextView textView5;
	TextView textView6;
	TextView textView7;
	TextView textView8;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.mainmenu);
		//�����࣬��Activityת��ΪView
		manager = new LocalActivityManager(MainMenuActivity.this, true);
		manager.dispatchCreate(savedInstanceState);
        //��ʼ��4��ҳ��
		initView();
		//��ID
		bindID();
		//���������ҳ����ת���»�����ɫ�ı�
		buttonListener();

		pagerAda = new MyPagerAda(pagerList);
		viewPager.setAdapter(pagerAda);

	}

	private void buttonListener() {
		textView5.setOnClickListener(this);
		textView6.setOnClickListener(this);
		textView7.setOnClickListener(this);
		textView8.setOnClickListener(this);
		viewPager.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int arg0) {
				textView1.setBackgroundColor(Color.BLACK);
				textView2.setBackgroundColor(Color.BLACK);
				textView3.setBackgroundColor(Color.BLACK);
				textView4.setBackgroundColor(Color.BLACK);
				switch (arg0) {
				case 0:
					textView1.setBackgroundColor(Color.RED);
					break;
				case 1:
					textView2.setBackgroundColor(Color.RED);
					break;
				case 2:
					textView3.setBackgroundColor(Color.RED);
					break;
				case 3:
					textView4.setBackgroundColor(Color.RED);
					break;

				default:
					break;
				}
			}

			@Override
			public void onPageScrollStateChanged(int arg0) {

			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {

			}
		});
	}

	private void bindID() {
		viewPager = (ViewPager) findViewById(R.id.viewpager);
		textView1 = (TextView) findViewById(R.id.line1);
		textView2 = (TextView) findViewById(R.id.line2);
		textView3 = (TextView) findViewById(R.id.line3);
		textView4 = (TextView) findViewById(R.id.line4);
		textView5 = (TextView) findViewById(R.id.textView1_mainmenu);
		textView6 = (TextView) findViewById(R.id.textView2_menu);
		textView7 = (TextView) findViewById(R.id.textView3_menu);
		textView8 = (TextView) findViewById(R.id.textView4_menu);
	}

	private void initView() {

		Intent intent1 = new Intent(this, MainGridActivity.class);
		Intent intent2 = new Intent(this, MusicListActivity.class);
		Intent intent3 = new Intent(this, FirstPublish.class);
		Intent intent4 = new Intent(this, RecommendActivity.class);
		// LocalActivityManager
		// ��Activityת����View
		View v1 = manager.startActivity("1", intent1).getDecorView();
		View v2 = manager.startActivity("2", intent2).getDecorView();
		View v3 = manager.startActivity("3", intent3).getDecorView();
		View v4 = manager.startActivity("4", intent4).getDecorView();

		pagerList.add(v1);
		pagerList.add(v2);
		pagerList.add(v3);
		pagerList.add(v4);

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.textView1_mainmenu:
			viewPager.setCurrentItem(0);
			break;
		case R.id.textView2_menu:
			viewPager.setCurrentItem(1);
			break;
		case R.id.textView3_menu:
			viewPager.setCurrentItem(2);
			break;
		case R.id.textView4_menu:
			viewPager.setCurrentItem(3);
			break;

		default:
			break;
		}
	}

	public boolean onKeyDown(int keyCode, KeyEvent event) {

		if (keyCode == KeyEvent.KEYCODE_BACK
			&& event.getAction() == KeyEvent.ACTION_DOWN) {
			if ((System.currentTimeMillis() - exitTime) > 2000) {
				Toast.makeText(getApplicationContext(), "再按一次退出鉴真云音乐",
						Toast.LENGTH_SHORT).show();
				exitTime = System.currentTimeMillis();
			} else {
				finish();
				System.exit(0);
			}
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}

}
