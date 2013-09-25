package com.bmarohnic.java2week4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class NextActivity extends Activity{

	TextView textView;
	EditText editText;
	String dealZip = null;
	int dealCategory;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_next);
		
		String dealType = null;
		
		Log.i("onCreate", "This is being called");
		Bundle data = getIntent().getExtras();
		if(data != null)
		{
			dealType = data.getString("dealType");
			dealCategory = data.getInt("dealCategory");
			
		}
		
		textView = (TextView) findViewById(R.id.dealTypeTextView);
		textView.setText("Enter the Zip Code to find " + dealType + " in that area.");
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
	public void finish() {
	    Intent data = new Intent();
	    data.putExtra("dealZip", dealZip);
	    data.putExtra("dealCategory", dealCategory);
	    setResult(RESULT_OK, data);
	    super.finish();
	}
	
	
	public void onClick(View view)
	{
		editText = (EditText) findViewById(R.id.searchField);
		dealZip = editText.getText().toString();
		
		finish();
	}
}
