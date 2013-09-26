package com.bmarohnic.java2week4;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
 
public class NextActivity extends Activity implements NextActivityFragment.OnGoButtonClicked{

	
	String dealZip = null;
	int dealCategory;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE)
		{
			finish();
			return;
		}
		
		setContentView(R.layout.act_next);
		
		String dealType = null;
		
		Log.i("onCreate", "This is being called");
		Bundle data = getIntent().getExtras();
		if(data != null)
		{
			dealType = data.getString("dealType");
			dealCategory = data.getInt("dealCategory");
			
		}
		
		NextActivityFragment fragment = (NextActivityFragment) getFragmentManager().findFragmentById(R.id.fragmentResults);
		fragment.displayResults(dealType, dealCategory);
		
		
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
	 
	
	@Override
	public void onGoButtonClicked(String dealZipCode)
	{
		dealZip = dealZipCode;
		finish();
	}
	
	/*
	public void onClick(View view)
	{
		editText = (EditText) findViewById(R.id.searchField);
		dealZip = editText.getText().toString();
		
		finish();
	}
	*/
}
