package com.example.bbcodetohtmlconverter;

import java.util.HashMap;
import java.util.Map;


import android.os.Bundle;
import android.os.Handler;
import android.R.string;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Gallery.LayoutParams;

public class MainActivity extends Activity {


	private Handler mHandler = new Handler();
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button btn = (Button) findViewById(R.id.button1);
		btn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				EditText text = (EditText) findViewById(R.id.editeText111);
				WebView webView = (WebView) findViewById(R.id.webView1);
				webView.getSettings().setJavaScriptEnabled(true);
				webView.addJavascriptInterface(new MyJavaScriptInterface(), "Android");
				webView.loadUrl("about:blank");
				//webView.loadData(BBcodeToHtmlConverter.bbcode(summary,this), "text/html; charset=UTF-8", null);
				webView.loadDataWithBaseURL("fake://not/needed",BBcodeToHtmlConverter.bbcode(text.getText().toString(),MainActivity.this), "text/html","utf-8", "");
		
		}
				
			

		});
		
		Button btn_test = (Button) findViewById(R.id.Button_test);
		btn_test.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(MainActivity.this,Test.class);
				startActivity(intent); 
			}
		});
		
		
	}

	 final class MyJavaScriptInterface
	    {
	        public void ProcessJavaScript(final String scriptname, final String args)
	            {             
	                mHandler.post(new Runnable()
	                    {
	                        public void run()
	                            {
	                                //Do your activities
                            }
	                    });
	            }
	    }
	 
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
