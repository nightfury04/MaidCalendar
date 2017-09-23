package com.example.myapp;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

public class HolidayList_fragment extends DialogFragment implements
		OnItemSelectedListener {
	
	List<LeaveTracker> lstLTracker;
	LeaveTrackerDBHandler dbhandler;
	ListView lv;
	ArrayAdapter<String> arrayAdapter;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View rootView = inflater.inflate(R.layout.fragment_holidaylist, null);
		lv = (ListView)rootView.findViewById(R.id.listView1);
		Spinner spinner = (Spinner) rootView.findViewById(R.id.spinner1);
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
				getActivity(), R.array.monthsName_array, R.layout.spinner_layout);
		adapter.setDropDownViewResource(R.layout.spinner_layout);
		spinner.setAdapter(adapter);
		spinner.setOnItemSelectedListener(this);
		return rootView;
	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub
		// Toast.makeText(getActivity(), Integer.toString(position),
		// Toast.LENGTH_LONG).show();
		 
		
		
		switch (position) {

		case 0:
			dbhandler = new LeaveTrackerDBHandler(
					getActivity());
			lstLTracker = dbhandler.getLstLeave("JAN");
			arrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, convertToStringList(lstLTracker));		
			lv.setAdapter(arrayAdapter);
			break;

		case 1:
			dbhandler = new LeaveTrackerDBHandler(
					getActivity());
			lstLTracker = dbhandler.getLstLeave("FEB");
			arrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, convertToStringList(lstLTracker));		
			lv.setAdapter(arrayAdapter);
			break;
		case 2:
			dbhandler = new LeaveTrackerDBHandler(
					getActivity());
			lstLTracker = dbhandler.getLstLeave("MAR");
			arrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, convertToStringList(lstLTracker));		
			lv.setAdapter(arrayAdapter);
			break;
		case 3:
			dbhandler = new LeaveTrackerDBHandler(
					getActivity());
			lstLTracker = dbhandler.getLstLeave("APR");
			
			arrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, convertToStringList(lstLTracker));		
			lv.setAdapter(arrayAdapter);
			break;
			
		case 4:
			dbhandler = new LeaveTrackerDBHandler(
					getActivity());
			lstLTracker = dbhandler.getLstLeave("MAY");
			arrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, convertToStringList(lstLTracker));		
			lv.setAdapter(arrayAdapter);
			break;
			
		case 5:
			dbhandler = new LeaveTrackerDBHandler(
					getActivity());
			lstLTracker = dbhandler.getLstLeave("JUN");
			arrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, convertToStringList(lstLTracker));		
			lv.setAdapter(arrayAdapter);
			break;
		case 6:
			dbhandler = new LeaveTrackerDBHandler(
					getActivity());
			lstLTracker = dbhandler.getLstLeave("JUL");
			arrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, convertToStringList(lstLTracker));		
			lv.setAdapter(arrayAdapter);
			break;
		case 7:
			dbhandler = new LeaveTrackerDBHandler(
					getActivity());
			lstLTracker = dbhandler.getLstLeave("AUG");
			arrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, convertToStringList(lstLTracker));		
			lv.setAdapter(arrayAdapter);
			break;
		case 8:
			dbhandler = new LeaveTrackerDBHandler(
					getActivity());
			lstLTracker = dbhandler.getLstLeave("SEP");
			arrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, convertToStringList(lstLTracker));		
			lv.setAdapter(arrayAdapter);
			break;
		case 9:
			dbhandler = new LeaveTrackerDBHandler(
					getActivity());
			lstLTracker = dbhandler.getLstLeave("OCT");
			arrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, convertToStringList(lstLTracker));		
			lv.setAdapter(arrayAdapter);
			break;
		case 10:
			dbhandler = new LeaveTrackerDBHandler(
					getActivity());
			lstLTracker = dbhandler.getLstLeave("NOV");
			arrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, convertToStringList(lstLTracker));		
			lv.setAdapter(arrayAdapter);
			break;
		case 11:
			dbhandler = new LeaveTrackerDBHandler(
					getActivity());
			lstLTracker = dbhandler.getLstLeave("DEC");
			arrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, convertToStringList(lstLTracker));		
			lv.setAdapter(arrayAdapter);
			break;
			
		}

	}

	@Override
	public void onNothingSelected(AdapterView<?> parent) {
		// TODO Auto-generated method stub

	}
	
	public ArrayList<String> convertToStringList(List<LeaveTracker> lst)
	{
		ArrayList<String> lstStr = new ArrayList<String>();
		for(LeaveTracker ltr : lst)
		{
			String temp = "Date: "+ltr.get_monthDate()+", Leave: "+ltr.get_noOfLeave();
			lstStr.add(temp);
		}
		
		return lstStr;
	}

}
