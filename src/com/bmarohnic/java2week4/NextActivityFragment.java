package com.bmarohnic.java2week4;

import com.bmarohnic.java2week4.MainActivityFragment.OnDealTypeButtonClicked;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class NextActivityFragment extends Fragment implements OnClickListener{

	TextView textView;
	EditText editText;
	Button zipButton;
	String dealZip = null;
	
	public interface OnGoButtonClicked
	{

		void onGoButtonClicked(String dealZip);
		
	}
	
	private OnGoButtonClicked parentActivity;
	
	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		super.onAttach(activity);
		
		if (activity instanceof OnGoButtonClicked)
		{
			parentActivity = (OnGoButtonClicked) activity;
		}
		else
		{
			throw new ClassCastException(activity.toString() + " must implement onGoButtonClicked");
		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.activity_next, container);
		
		textView = (TextView) view.findViewById(R.id.dealTypeTextView);
		editText = (EditText) view.findViewById(R.id.searchField);
		
		zipButton = (Button) view.findViewById(R.id.searchButton);
		zipButton.setOnClickListener(this);
		
		return view;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		dealZip = editText.getText().toString();
		parentActivity.onGoButtonClicked(dealZip);
	}
	
	public void displayResults(String dealTyp, int deatCat)
	{
		
		textView.setText("Enter the Zip Code to find " + dealTyp + " in that area.");
		
		
	}
	
}
