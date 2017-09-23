package com.example.myapp;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.TextView;

public class SalaryDetails_fragment extends DialogFragment implements
OnItemSelectedListener{
	
	

	
	List<LeaveTracker> lstLTracker;
	LeaveTrackerDBHandler dbhandler;
	ArrayAdapter<String> arrayAdapter;
	TextView tv;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View rootView = inflater.inflate(R.layout.salarydetails, null);
		Spinner spinner = (Spinner) rootView.findViewById(R.id.spinner5);
		tv = (TextView)rootView.findViewById(R.id.textView5);
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
		 
		float salary = 0;
		int noOfEntry = 0;
		
		switch (position) {

		case 0:
			dbhandler = new LeaveTrackerDBHandler(
					getActivity());
			lstLTracker = dbhandler.getSpecificLeaveTrackerEntries("JAN");
			noOfEntry = dbhandler.getNoOfEntriesMadePerMonth("JAN");
			if (noOfEntry >= 1) {
				salary = calculateSalary(lstLTracker,"JAN");
				tv.setText("Rs. "+Float.toString(salary));

			} else
			{
				tv.setText("No salary record for this month.");
			}
			break;

		case 1:
			dbhandler = new LeaveTrackerDBHandler(
					getActivity());
			lstLTracker = dbhandler.getSpecificLeaveTrackerEntries("FEB");
			noOfEntry = dbhandler.getNoOfEntriesMadePerMonth("FEB");
			if (noOfEntry >= 1) {
				salary = calculateSalary(lstLTracker,"FEB");
				tv.setText("Rs. "+Float.toString(salary));

			} else
			{
				tv.setText("No salary record for this month.");
			}
			break;
		case 2:
			dbhandler = new LeaveTrackerDBHandler(
					getActivity());
			lstLTracker = dbhandler.getSpecificLeaveTrackerEntries("MAR");
			noOfEntry = dbhandler.getNoOfEntriesMadePerMonth("MAR");
			if (noOfEntry >= 1) {
				salary = calculateSalary(lstLTracker,"MAR");
				tv.setText("Rs. "+Float.toString(salary));

			} else
			{
				tv.setText("No salary record for this month.");
			}
			break;
		case 3:
			dbhandler = new LeaveTrackerDBHandler(
					getActivity());
			lstLTracker = dbhandler.getSpecificLeaveTrackerEntries("APR");
			noOfEntry = dbhandler.getNoOfEntriesMadePerMonth("APR");
			if (noOfEntry >= 1) {
				salary = calculateSalary(lstLTracker,"APR");
				tv.setText("Rs. "+Float.toString(salary));

			} else
			{
				tv.setText("No salary record for this month.");
			}
			break;
			
		case 4:
			dbhandler = new LeaveTrackerDBHandler(
					getActivity());
			lstLTracker = dbhandler.getSpecificLeaveTrackerEntries("MAY");
			noOfEntry = dbhandler.getNoOfEntriesMadePerMonth("MAY");
			if (noOfEntry >= 1) {
				salary = calculateSalary(lstLTracker,"MAY");
				tv.setText("Rs. "+Float.toString(salary));

			} else
			{
				tv.setText("No salary record for this month.");
			}
			break;
			
		case 5:
			dbhandler = new LeaveTrackerDBHandler(
					getActivity());
			lstLTracker = dbhandler.getSpecificLeaveTrackerEntries("JUN");
			noOfEntry = dbhandler.getNoOfEntriesMadePerMonth("JUN");
			if (noOfEntry >= 1) {
				salary = calculateSalary(lstLTracker,"JUN");
				tv.setText("Rs. "+Float.toString(salary));

			} else
			{
				tv.setText("No salary record for this month.");
			}
			break;
		case 6:
			dbhandler = new LeaveTrackerDBHandler(
					getActivity());
			lstLTracker = dbhandler.getSpecificLeaveTrackerEntries("JUL");
			noOfEntry = dbhandler.getNoOfEntriesMadePerMonth("JUL");
			if (noOfEntry >= 1) {
				salary = calculateSalary(lstLTracker,"JUL");
				tv.setText("Rs. "+Float.toString(salary));

			} else
			{
				tv.setText("No salary record for this month.");
			}
			break;
		case 7:
			dbhandler = new LeaveTrackerDBHandler(
					getActivity());
			lstLTracker = dbhandler.getSpecificLeaveTrackerEntries("AUG");
			noOfEntry = dbhandler.getNoOfEntriesMadePerMonth("AUG");
			if (noOfEntry >= 1) {
				salary = calculateSalary(lstLTracker,"AUG");
				tv.setText("Rs. "+Float.toString(salary));

			} else
			{
				tv.setText("No salary record for this month.");
			}
			break;
		case 8:
			dbhandler = new LeaveTrackerDBHandler(
					getActivity());
			lstLTracker = dbhandler.getSpecificLeaveTrackerEntries("SEP");
			noOfEntry = dbhandler.getNoOfEntriesMadePerMonth("SEP");
			if (noOfEntry >= 1) {
				salary = calculateSalary(lstLTracker,"SEP");
				tv.setText("Rs. "+Float.toString(salary));

			} else
			{
				tv.setText("No salary record for this month.");
			}
			break;
		case 9:
			dbhandler = new LeaveTrackerDBHandler(
					getActivity());
			lstLTracker = dbhandler.getSpecificLeaveTrackerEntries("OCT");
			noOfEntry = dbhandler.getNoOfEntriesMadePerMonth("OCT");
			if (noOfEntry >= 1) {
				salary = calculateSalary(lstLTracker,"OCT");
				tv.setText("Rs. "+Float.toString(salary));

			} else
			{
				tv.setText("No salary record for this month.");
			}
			break;
		case 10:
			dbhandler = new LeaveTrackerDBHandler(
					getActivity());
			lstLTracker = dbhandler.getSpecificLeaveTrackerEntries("NOV");
			noOfEntry = dbhandler.getNoOfEntriesMadePerMonth("NOV");
			if (noOfEntry >= 1) {
				salary = calculateSalary(lstLTracker,"NOV");
				tv.setText("Rs. "+Float.toString(salary));

			} else
			{
				tv.setText("No salary record for this month.");
			}
			break;
		case 11:
			dbhandler = new LeaveTrackerDBHandler(
					getActivity());
			lstLTracker = dbhandler.getSpecificLeaveTrackerEntries("DEC");
			noOfEntry = dbhandler.getNoOfEntriesMadePerMonth("DEC");
			if (noOfEntry >= 1) {
				salary = calculateSalary(lstLTracker,"DEC");
				tv.setText("Rs. "+Float.toString(salary));

			} else
			{
				tv.setText("No salary record for this month.");
			}
			break;
			
		}

	}

	@Override
	public void onNothingSelected(AdapterView<?> parent) {
		// TODO Auto-generated method stub

	}
	
	
	public float calculateSalary(List<LeaveTracker> lstLTracker, String month)
	{
		dbhandler = new LeaveTrackerDBHandler(getActivity());
		TariffDetails td = dbhandler.getTariffDetailsEntry();
		float salary = Integer.parseInt(td.get_salary());
		float amtToBeDeducted=0;
		float noOfLeaves = 0;
		float noOfPresents = 0;
		float oneDaySalary = salary/30;
		int noOfentriesmade = dbhandler.getNoOfEntriesMadePerMonth(month);
		for(LeaveTracker lt : lstLTracker)
		{
			noOfLeaves = noOfLeaves + Integer.parseInt(lt.get_noOfLeave());
			noOfPresents = noOfPresents + Integer.parseInt(lt.get_attendance());
		}
		//if leaves exceed allowed leaves
		if(noOfLeaves>(2*Integer.parseInt(td.get_allowedLeave())))
		{
			amtToBeDeducted = oneDaySalary *((noOfLeaves/2) - Integer.parseInt(td.get_allowedLeave()));
			salary = oneDaySalary * ((noOfPresents/2) - ((noOfLeaves/2) - Integer.parseInt(td.get_allowedLeave())));
		}
		else
		{
			salary = oneDaySalary * (noOfPresents/2);
		}
		
		if(noOfentriesmade >= 30 && (noOfLeaves<=(2*Integer.parseInt(td.get_allowedLeave()))))
		{
			salary = Integer.parseInt(td.get_salary());
		}
		if(noOfentriesmade >=30)
		{
			salary = Integer.parseInt(td.get_salary()) - amtToBeDeducted;
		}
	    return salary;
	}


}
