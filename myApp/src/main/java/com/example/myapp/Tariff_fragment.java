package com.example.myapp;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class Tariff_fragment extends DialogFragment implements OnClickListener{
	
	EditText et1;
	EditText et2;
	Button bt1;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		View rootView = inflater.inflate(R.layout.tariff_details, null);
		et1 = (EditText)rootView.findViewById(R.id.editText1);
		et2 = (EditText)rootView.findViewById(R.id.editText2);
		bt1 = (Button)rootView.findViewById(R.id.button1);
		bt1.setOnClickListener(this);
		
		Context ct = getActivity();
        LeaveTrackerDBHandler dbHandler = new LeaveTrackerDBHandler(ct);
        
        //if entry exists in database populate the editTexts
        if(dbHandler.getTariffDetailsCount()>=1)
        {
        	TariffDetails objDetails = dbHandler.getTariffDetailsEntry();
        	et1.setText(objDetails.get_salary());
        	et2.setText(objDetails.get_allowedLeave());
        }
		return rootView;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		int monthlySalary = Integer.parseInt(et1.getText().toString());
        int allowedLeave = Integer.parseInt(et2.getText().toString());
        
        TariffDetails objTariffDetails = new TariffDetails();
        objTariffDetails.set_salary(Integer.toString(monthlySalary));
        objTariffDetails.set_allowedLeave(Integer.toString(allowedLeave));
        Context ct = getActivity();
        LeaveTrackerDBHandler dbHandler = new LeaveTrackerDBHandler(ct);
        
        
        if(dbHandler.getTariffDetailsCount()>=1)
        {
        	dbHandler.deleteAllTariffEntries();
        }
        	dbHandler.addTariffDetailsEntry(objTariffDetails);
        
        int temp = dbHandler.getTariffDetailsCount();
        
        String log = "Monthly Salary: " + monthlySalary + " Allowed Leave: " + allowedLeave + " Entry: " + temp;
        Log.d("LOG: ", log);
        
	}
	
	

}
