package com.lenovo.main;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;

import com.example.playerbasead.R;
import com.lenovo.myadapter.MyAdapter;
import com.lenovo.vo.SongInfo;

public class MusicListActivity extends Activity implements OnItemClickListener,
		OnClickListener {
	private ContentResolver contentResolver;
	private ArrayList<SongInfo> list = new ArrayList<SongInfo>();
	private ListView listView;
	private MyAdapter myadapter;
	private MediaPlayer mediaPlayer = new MediaPlayer();
	private ImageView imageView, imageView2, imageView3, imageView4;
	private TextView textView1, textView2;
	private TextView currentshow, totalshow;
	private SeekBar seekBar;
	private boolean player = true;
	int currentposition;
	SensorManager sensorManager;
	// ����UI
	Handler handler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			switch (msg.what) {

			case 0:

				int position = mediaPlayer.getCurrentPosition();
				int time = mediaPlayer.getDuration();
				seekBar.setMax(time);
				seekBar.setProgress(position);
				
				
				int current = mediaPlayer.getCurrentPosition();
				int total = mediaPlayer.getDuration();
				// int cminute=current/60000;
				// int csecond=current/1000;
				SimpleDateFormat format = new SimpleDateFormat("mm:ss");

				Date currenttext = new Date(current);
				String currenttime = format.format(currenttext);
				currentshow.setText(currenttime);

				Date totaltext = new Date(total);
				String totalttime = format.format(totaltext);
				totalshow.setText(totalttime);

//				if (position == time) {
//					mediaPlayer.seekTo(0);
//					//mediaPlayer.start();
//					if (player == false) {
//						mediaPlayer.start();
//					} else {
//						next();
//					}
//				}
//				break;

			default:
				break;
			}
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.musiclist);
		// 初始化数据
		initdata();
		// 绑定ID
		bindID();
		// 按钮时间
		buttonlistener();
		// 进度条监听
		seekbarlistener();
		// 传感器 无序播放
		sensor();
		complete();

		
		textView1.setSelected(true);

		myadapter = new MyAdapter(this, list);
		listView.setOnItemClickListener(this);
		listView.setAdapter(myadapter);

	}

	private void complete() {
		mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
			
			@Override
			public void onCompletion(MediaPlayer mp) {
				mediaPlayer.seekTo(0);
				//mediaPlayer.start();
				if (player == false) {
					mediaPlayer.start();
				} else {
					next();
				}
			}
		});
	}

	private void sensor() {
		// 传感器
		sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
		Sensor sensor = sensorManager
				.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
		sensorManager.registerListener(listener, sensor,
				SensorManager.SENSOR_DELAY_NORMAL);
	}

	SensorEventListener listener = new SensorEventListener() {

		@Override
		public void onSensorChanged(SensorEvent event) {
			float xvalue = Math.abs(event.values[0]);
			float yvalue = Math.abs(event.values[1]);
			float zvalue = Math.abs(event.values[2]);
			if (xvalue > 15 || yvalue > 15 || zvalue > 15) {
				Toast.makeText(MusicListActivity.this, "摇一摇，为您随机换歌",
						Toast.LENGTH_SHORT).show();
				currentposition = (int) (Math.random() * 10);
				commonplay();

			}
		}

		@Override
		public void onAccuracyChanged(Sensor sensor, int accuracy) {

		}

	};

	private void seekbarlistener() {
		seekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {

				int dest = seekBar.getProgress();
				int time = mediaPlayer.getDuration();

				seekBar.setMax(time);

				// seekBar.setProgress(dest);
				mediaPlayer.seekTo(dest);

			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {

			}

			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {

			}
		});

	}

	private void buttonlistener() {
		imageView.setOnClickListener(this);
		imageView2.setOnClickListener(this);
		imageView3.setOnClickListener(this);
		imageView4.setOnClickListener(this);
	}

	private void bindID() {
		listView = (ListView) findViewById(R.id.listView1);
		imageView = (ImageView) findViewById(R.id.back);
		imageView2 = (ImageView) findViewById(R.id.play);
		imageView3 = (ImageView) findViewById(R.id.next);
		imageView4 = (ImageView) findViewById(R.id.nowplay);
		textView1 = (TextView) findViewById(R.id.nowsong);
		textView2 = (TextView) findViewById(R.id.nowsinger);
		seekBar = (SeekBar) findViewById(R.id.seekBar1);
		currentshow = (TextView) findViewById(R.id.textView1_current);
		totalshow = (TextView) findViewById(R.id.textView2_total);

	}

	private void initdata() {
		contentResolver = getContentResolver();
		Cursor cursor = contentResolver.query(
				MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, null, null, null,
				null);
		cursor.moveToFirst();

		for (int i = 0; i < cursor.getCount(); i++) {
			String title = cursor.getString(cursor
					.getColumnIndex(MediaStore.Audio.Media.TITLE));
			String singer = cursor.getString(cursor
					.getColumnIndex(MediaStore.Audio.Media.ARTIST));

			String url = cursor.getString(cursor
					.getColumnIndex(MediaStore.Audio.Media.DATA));

			SongInfo s = new SongInfo(title, singer, url);
			list.add(s);

			cursor.moveToNext();
		}

	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		currentposition = position;
		commonplay();

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.back:
			back();
			break;
		case R.id.play:
			if (mediaPlayer.isPlaying()) {
				mediaPlayer.pause();

				imageView2
						.setImageResource(R.drawable.musicplayer_item_play_pressed);

			} else {
				mediaPlayer.start();
				imageView2.setImageResource(R.drawable.icon_music_circle_pause);
			}

			break;
		case R.id.next:
			next();
			break;
		case R.id.nowplay:
			if (player) {
				player = false;
				Toast.makeText(this, "已切换为单曲播放", Toast.LENGTH_SHORT).show();
			} else {
				player = true;
				Toast.makeText(this, "已切换为顺序播放", Toast.LENGTH_SHORT).show();
			}
			break;
		default:
			break;
		}
	}

	private void back() {
		if (currentposition == 0) {
			currentposition = list.size() - 1;
		} else {
			currentposition--;
		}
		commonplay();
	}

	private void next() {
		if (currentposition == list.size() - 1) {
			currentposition = 0;
		} else {
			currentposition++;
		}
		commonplay();
	}

	void commonplay() {
		try {

			mediaPlayer.reset();
			mediaPlayer.setDataSource(list.get(currentposition).getUrl());
			mediaPlayer.prepare();
			mediaPlayer.start();
			mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
			imageView2.setImageResource(R.drawable.icon_music_circle_pause);
			textView1.setText(list.get(currentposition).getSong());
			textView2.setText(list.get(currentposition).getSinger());
			final int millsecond = 100;

			new Thread() {
				public void run() {
					while (true) {
						try {
							sleep(millsecond);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						handler.sendEmptyMessage(0);
					}
				};
			}.start();

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

}
