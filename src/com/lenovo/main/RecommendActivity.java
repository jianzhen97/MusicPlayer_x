package com.lenovo.main;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import android.view.Window;
import android.widget.TextView;

import com.example.playerbasead.R;

public class RecommendActivity extends Activity {
	TextView textView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_recommend);

	}

	public void showdailog(View V) {
		AlertDialog.Builder builder = new Builder(RecommendActivity.this);
		builder.setTitle("权限");
		builder.setMessage("调用电话");
		builder.setPositiveButton("允许", new OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				Intent intent = new Intent(Intent.ACTION_DIAL);
				intent.setData(Uri.parse("tel:10086"));
				startActivity(intent);

			}
		});
		builder.setNegativeButton("拒绝", new OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				
			}
		});
		builder.show();

	}

}
