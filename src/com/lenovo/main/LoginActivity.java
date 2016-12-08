package com.lenovo.main;

import com.example.playerbasead.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class LoginActivity extends Activity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.login);
		Button button=(Button) findViewById(R.id.Login);
		button.setOnClickListener(this);
	}
	
//	@Override
//	protected void onPause() {
//		finish();
//	}

	@Override
	public void onClick(View v) {
		
	 switch (v.getId()) {
	case R.id.Login:
		
		Intent intent=new Intent(LoginActivity.this, MainMenuActivity.class);
		startActivity(intent);
		finish();
		break;

	
	}
		
	}

	
}
