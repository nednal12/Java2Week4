package com.bmarohnic.java2week4;

import android.app.Activity;
import android.app.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivityFragment extends Fragment implements OnClickListener {

	ListView listview;
	TextView textview;
	private EditText editText;
	private Spinner dealSpinner;
	ArrayAdapter adapter;
	Button goButton;
	
	public interface onDealTypeButtonClicked
	{
		void startResultActivity(String tempString, int tempInt);
	}
	
	private onDealTypeButtonClicked parentActivity;
	
	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		super.onAttach(activity);
		
		if (activity instanceof onDealTypeButtonClicked)
		{
			parentActivity = (onDealTypeButtonClicked) activity;
		}
		else
		{
			throw new ClassCastException(activity.toString() + " must implement onDealTypeButtonClicked");
		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
		View view = inflater.inflate(R.layout.activity_main, container);
		
		dealSpinner = (Spinner) view.findViewById(R.id.dealSpinner);
		Log.i("From onCreate", "This is running too");
		adapter = ArrayAdapter.createFromResource(getActivity(), R.array.dealCategory, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		
		dealSpinner.setAdapter(adapter);
//		editText = (EditText) findViewById(R.id.searchField);

		listview = (ListView) view.findViewById(R.id.list);
		View listHeader = getActivity().getLayoutInflater().inflate(R.layout.list_header, null);
		listview.addHeaderView(listHeader);
		
		goButton = (Button) view.findViewById(R.id.searchButton);
		goButton.setOnClickListener(this);
		return view;
		
	}
	
	public void onClick(View view)
	{
		
		String tempString = dealSpinner.getSelectedItem().toString();
		int tempInt = dealSpinner.getSelectedItemPosition() + 1;
		Log.i("onClick", "The Value Selected is " + tempString + "from position " + tempInt);
		
		parentActivity.startResultActivity(tempString, tempInt);
		
	}
	
}
