package com.lenovo.main;

import com.example.playerbasead.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Enter4Activity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_enter4);
		Button button=(Button) findViewById(R.id.enter);
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent=new Intent(Enter4Activity.this, LoginActivity.class);
				startActivity(intent);
				finish();
			}
		});
	}

	
}
