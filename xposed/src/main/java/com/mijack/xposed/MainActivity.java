package com.mijack.xposed;

import android.app.Activity;
import android.os.Bundle;


public class MainActivity extends Activity /*implements View.OnClickListener*/ {

	private static final int REQUEST_CODE = 1;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//		setContentView(R.layout.activity_main);
//		findViewById(R.id.btn).setOnClickListener(this);
	}

}
