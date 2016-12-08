package com.lenovo.main;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.LocalActivityManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.View;
import android.view.Window;

import com.example.playerbasead.R;
import com.lenovo.myadapter.MyFirstPagerAda;

public class FirstActivity extends Activity {
	private ViewPager viewPager;
	private List<View> viewlisList = new ArrayList<View>();
	private MyFirstPagerAda firstPagerAda;
	LocalActivityManager manager;
	Bundle savedInstanceState;
	SharedPreferences.Editor editor;
	SharedPreferences sharedPreferences;
	boolean flag;
	
	Handler handler=new Handler(){
		public void handleMessage(android.os.Message msg) {
			switch (msg.what) {
			case 0:
				sharedPreferences=getSharedPreferences("info", 0);
				flag=sharedPreferences.getBoolean("flag", false);
				if (flag) {
					Intent intent=new Intent(FirstActivity.this, LoginActivity.class);
					startActivity(intent);
				}
				else {
					setContentView(R.layout.first);
					viewPager = (ViewPager) findViewById(R.id.viewpager_first);
					manager = new LocalActivityManager(FirstActivity.this, true);
					manager.dispatchCreate(savedInstanceState);
					initview();
					firstPagerAda = new MyFirstPagerAda(viewlisList);
					viewPager.setAdapter(firstPagerAda);
					editor=getSharedPreferences("info", 0).edit();
					editor.putBoolean("flag", true);
					editor.commit();
					
				}
					
				
			
				break;

			default:
				break;
			}
			
		}

		private void pagerlistener() {
			viewPager.setOnPageChangeListener(new OnPageChangeListener() {

				@Override
				public void onPageSelected(int arg0) {
					switch (arg0) {
					case 0:
	                
						break;
					case 1:

						break;
					case 2:

						break;

					default:
						break;
					}
				}

				@Override
				public void onPageScrolled(int arg0, float arg1, int arg2) {
	                 Log.i("infoint", arg0+"");
	                 Log.i("infofloat", arg1+"");
	                 Log.i("infoint2", arg2+"");
				}

				@Override
				public void onPageScrollStateChanged(int arg0) {

				}
			});
		};
	};

	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.one);		
		
		
		new Thread(){
			public void run() {
				try {
					sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				handler.sendEmptyMessage(0);
				
			};
		}.start();

	}

	private void initview() {
		Intent intent = new Intent(this, Enter1Activity.class);
		Intent intent2 = new Intent(this, Enter2Activity.class);
		Intent intent3 = new Intent(this, Enter3Activity.class);
		Intent intent4 = new Intent(this, Enter4Activity.class);

		View view = manager.startActivity("1", intent).getDecorView();
		View view2 = manager.startActivity("2", intent2).getDecorView();
		View view3 = manager.startActivity("3", intent3).getDecorView();
		View view4 = manager.startActivity("4", intent4).getDecorView();

		viewlisList.add(view);
		viewlisList.add(view2);
		viewlisList.add(view3);
		viewlisList.add(view4);
	}
}
