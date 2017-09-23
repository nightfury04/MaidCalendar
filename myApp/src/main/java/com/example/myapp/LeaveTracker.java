package com.example.myapp;

public class LeaveTracker 
{
	String _monthDate;
	String _noOfLeave;
	String _attendance;

	public LeaveTracker()
	{
		
	}
	
	
	public LeaveTracker(String monthDate, String noOfLeave, String attendance)
	{
		this._monthDate = monthDate;
		this._noOfLeave = noOfLeave;
		this._attendance = attendance;
	}
	
	public String get_monthDate() {
		return _monthDate;
	}
	public void set_monthDate(String _monthDate) {
		this._monthDate = _monthDate;
	}
	public String get_noOfLeave() {
		return _noOfLeave;
	}
	public void set_noOfLeave(String _noOfLeave) {
		this._noOfLeave = _noOfLeave;
	}
	public String get_attendance() {
		return _attendance;
	}
    public void set_attendance(String _attendance) {
		this._attendance = _attendance;
	}

}
