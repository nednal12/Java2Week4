package com.bmarohnic.java2week4;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;



public class LaunchScreen extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_launch);
	}

	/* (non-Javadoc)
	 * @see android.app.Activity#onCreateOptionsMenu(android.view.Menu)
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void searchClick(View view) {

		Intent mainActivity = new Intent(this, MainActivity.class);
		
		startActivity(mainActivity);
	}
	
	public void implicitClick(View view) {

		Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://8coupons.com"));
		
		startActivity(intent);
	}
}

