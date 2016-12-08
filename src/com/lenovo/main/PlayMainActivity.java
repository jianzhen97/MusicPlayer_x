package com.lenovo.main;

import java.io.File;
import java.io.IOException;

import com.example.playerbasead.R;

import android.R.string;
import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class PlayMainActivity extends Activity {

	ImageView imageView;
	private MediaPlayer mediaPlayer = new MediaPlayer();
	private String url;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.play);
		imageView = (ImageView) findViewById(R.id.imageView_play);
		Intent intent = getIntent();
		url = intent.getStringExtra("url");
		Button button1 = (Button) findViewById(R.id.play);
		Button button2 = (Button) findViewById(R.id.pause);
		Button button3 = (Button) findViewById(R.id.stop);
		// button1.setOnClickListener(PlayMainActivity.this);
		// button2.setOnClickListener(PlayMainActivity.this);
		// button3.setOnClickListener(PlayMainActivity.this);
		init();
	}

	public void init() {
		// File file=new
		// File(Environment.getExternalStorageDirectory(),"oldAndsea.mp3");
		try {
			mediaPlayer.setDataSource(url);
			mediaPlayer.prepare();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void doclick(View v) {
		switch (v.getId()) {
		case R.id.play:
			// if(!mediaPlayer.isPlaying()){
			// mediaPlayer.start();
			// imageView.setImageResource(R.drawable.)
			// }
			// break;
		case R.id.pause:
			if (mediaPlayer.isPlaying()) {
				mediaPlayer.pause();
			}
			break;
		case R.id.stop:
			if (mediaPlayer.isPlaying()) {
				mediaPlayer.reset();
				init();
			}
			break;
		/**
		 * 一个/**回车； vo entity
		 */

		}

	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		if (mediaPlayer != null) {
			mediaPlayer.stop();
			mediaPlayer.release();
		}
	}

}
