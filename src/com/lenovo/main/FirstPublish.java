package com.lenovo.main;



import com.example.playerbasead.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class FirstPublish extends Activity {
	WebView webView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.firstpublish);
		
	       webView=(WebView) findViewById(R.id.webView1_firstpublish);
	        webView.loadUrl("http://y.qq.com");
	        webView.setWebViewClient(new WebViewClient(){
	        	@Override
	        	public boolean shouldOverrideUrlLoading(WebView view, String url) {
	        		view.loadUrl(url);
	        		
	        		return true;
	        		
//	        		return super.shouldOverrideUrlLoading(view, url);
	        	}
	        });
	        WebSettings webSettings=webView.getSettings();
			webSettings.setJavaScriptEnabled(true);
	}
	
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode==KeyEvent.KEYCODE_BACK) {
			if (webView.canGoBack()) {
				webView.goBack();
				return true;
			}
			else {
				System.exit(0);
			}
		}
		return super.onKeyDown(keyCode, event);
		
	}

	
}
