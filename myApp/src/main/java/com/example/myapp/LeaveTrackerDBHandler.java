package com.example.myapp;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

public final class LeaveTrackerDBHandler extends SQLiteOpenHelper{


	// Database Version
    private static final int DATABASE_VERSION = 1;
 
    // Database Name
    private static final String DATABASE_NAME = "LeaveTrackerDB";
	
	
	public static final String TABLE_NAME = "LeaveTracker";
	public static final String COLUMN_NAME_MONTHDATE = "monthdate";
	public static final String COLUMN_NAME_LEAVE = "noOfLeave";
	public static final String COLUMN_NAME_ATTENDANCE = "attendance";
	public static final String COLUMN_NAME_NULLABLE = "nullable";
	
	public static final String TABLE_NAME2 = "TariffDetails";
	public static final String COLUMN_NAME_SALARY = "MonthlySalary";
	public static final String COLUMN_NAME_ALLOWEDLEAVE = "AllowedLeave";
	
	
	public LeaveTrackerDBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		String CREATE_LEAVETRACKER_TABLE = "CREATE TABLE " + TABLE_NAME + " ( "
				+ COLUMN_NAME_MONTHDATE + " DATE, " + COLUMN_NAME_LEAVE
				+ " NUMBER, " + COLUMN_NAME_ATTENDANCE
				+ " NUMBER " + ")";
		System.out.println("Create Table sql: " +CREATE_LEAVETRACKER_TABLE);
		db.execSQL(CREATE_LEAVETRACKER_TABLE);
		
		String CREATE_SALARYDETAILS_TABLE = "CREATE TABLE " + TABLE_NAME2 + " ( "
				+ COLUMN_NAME_SALARY + " NUMBER, " + COLUMN_NAME_ALLOWEDLEAVE
				+ " NUMBER " + ")";
		System.out.println("Create Table sql: " +CREATE_SALARYDETAILS_TABLE);
		db.execSQL(CREATE_SALARYDETAILS_TABLE);
	}


	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
		onCreate(db);
		
	}
	
	
	public void addLeaveTrackerEntry(LeaveTracker objLeaveTracker)
	{
		SQLiteDatabase db = this.getWritableDatabase();
	    ContentValues values = new ContentValues();
	    values.put(COLUMN_NAME_MONTHDATE, objLeaveTracker.get_monthDate());
	    values.put(COLUMN_NAME_LEAVE, objLeaveTracker.get_noOfLeave());
	    values.put(COLUMN_NAME_ATTENDANCE, objLeaveTracker.get_attendance());
	    db.insert(TABLE_NAME, COLUMN_NAME_NULLABLE, values);
	    db.close();
	}
	
	
	public LeaveTracker getLeaveTrackerEntry(String date)
	{
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.query(TABLE_NAME, null, COLUMN_NAME_MONTHDATE + "=?", new String[] { date }, null, null, null, null);
		 if (cursor != null)
		        cursor.moveToFirst();
		 
		 LeaveTracker objLeaveTracker = new LeaveTracker(cursor.getString(0) , cursor.getString(1), cursor.getString(2));
		 return objLeaveTracker;
	}
	
	
	
	public List<LeaveTracker> getSpecificLeaveTrackerEntries(String month)
	{
		SQLiteDatabase db = this.getReadableDatabase();
		List<LeaveTracker> leaveTrackerEntryList = new ArrayList<LeaveTracker>();
		String sql = "select * from LeaveTracker where upper(monthdate) like '%"+month+"%'";
		Cursor cursor = db.rawQuery(sql, null);
		if (cursor.moveToFirst()) {
			do {
				LeaveTracker objLeaveTracker = new LeaveTracker();
				objLeaveTracker.set_monthDate(cursor.getString(0));
				objLeaveTracker.set_noOfLeave(cursor.getString(1));
				objLeaveTracker.set_attendance(cursor.getString(2));

				leaveTrackerEntryList.add(objLeaveTracker);
			} while (cursor.moveToNext());
		}
		
		return leaveTrackerEntryList;
		
	}
	
	
	public List<LeaveTracker> getLstLeave(String month)
	{
		SQLiteDatabase db = this.getReadableDatabase();
		List<LeaveTracker> leaveTrackerEntryList = new ArrayList<LeaveTracker>();
		String sql = "select * from LeaveTracker where upper(monthdate) like '%"+month+"%' and noOfLeave in (1,2)";
		Cursor cursor = db.rawQuery(sql, null);
		if (cursor.moveToFirst()) {
			do {
				LeaveTracker objLeaveTracker = new LeaveTracker();
				objLeaveTracker.set_monthDate(cursor.getString(0));
				objLeaveTracker.set_noOfLeave(cursor.getString(1));
				objLeaveTracker.set_attendance(cursor.getString(2));

				leaveTrackerEntryList.add(objLeaveTracker);
			} while (cursor.moveToNext());
		}
		
		return leaveTrackerEntryList;
		
	}
	
	
	
	public int getNoOfEntriesMadePerMonth(String month)
	{
		SQLiteDatabase db = this.getReadableDatabase();
		String sql = "select * from LeaveTracker where upper(monthdate) like '%"+month+"%'";
		Cursor cursor = db.rawQuery(sql, null);
		return cursor.getCount();
	}
	
	
	
	public List<LeaveTracker> getAllLeaveTrackerEntries() {
		List<LeaveTracker> leaveTrackerEntryList = new ArrayList<LeaveTracker>();

		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.query(TABLE_NAME, null, null, null, null, null, null);

		if (cursor.moveToFirst()) {
			do {
				LeaveTracker objLeaveTracker = new LeaveTracker();
				objLeaveTracker.set_monthDate(cursor.getString(0));
				objLeaveTracker.set_noOfLeave(cursor.getString(1));
				objLeaveTracker.set_attendance(cursor.getString(2));

				leaveTrackerEntryList.add(objLeaveTracker);
			} while (cursor.moveToNext());
		}
		    return leaveTrackerEntryList;
	}
	
	public int updateLeaveTrackerEntry(LeaveTracker objLeaveTracker) {
	    SQLiteDatabase db = this.getWritableDatabase();
	 
	    ContentValues values = new ContentValues();
	    values.put(COLUMN_NAME_MONTHDATE, objLeaveTracker.get_monthDate());
	    values.put(COLUMN_NAME_LEAVE, objLeaveTracker.get_noOfLeave());
	    values.put(COLUMN_NAME_ATTENDANCE, objLeaveTracker.get_attendance());
	 
	    // updating row
	    return db.update(TABLE_NAME, values, COLUMN_NAME_MONTHDATE + " = ?",
	            new String[] { String.valueOf(objLeaveTracker.get_monthDate()) });
	}
	
	
	public void deleteLeaveTrackerEntry(LeaveTracker objLeaveTracker) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, COLUMN_NAME_MONTHDATE + " = ?",
                new String[] { String.valueOf(objLeaveTracker.get_monthDate()) });
        db.close();
    }
	
	public int getLeaveCount(String monthDate)
	{
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.query(TABLE_NAME, null, COLUMN_NAME_MONTHDATE + " = ?", new String[] { monthDate }, null, null, null);	
		return cursor.getCount();
	}
	
	
	
	public void addTariffDetailsEntry(TariffDetails objTariffDetails)
	{
		SQLiteDatabase db = this.getWritableDatabase();
	    ContentValues values = new ContentValues();
	    values.put(COLUMN_NAME_SALARY, objTariffDetails.get_salary());
	    values.put(COLUMN_NAME_ALLOWEDLEAVE, objTariffDetails.get_allowedLeave());
	    db.insert(TABLE_NAME2, COLUMN_NAME_NULLABLE, values);
	    db.close();
	}
	
	public int getTariffDetailsCount()
	{
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.query(TABLE_NAME2, null, null, null, null, null, null);	
		return cursor.getCount();
	}
	
	
	public void deleteAllTariffEntries()
	{
		 SQLiteDatabase db = this.getWritableDatabase();
		 db.delete(TABLE_NAME2, null, null);
		 db.close();
	}

	public TariffDetails getTariffDetailsEntry() {
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.query(TABLE_NAME2, null, null, null, null, null,
				null);
		TariffDetails objTariffDetails = new TariffDetails();
		if (cursor != null) {
			cursor.moveToFirst();
			objTariffDetails.set_salary(cursor.getString(0));
			objTariffDetails.set_allowedLeave(cursor.getString(1));
		}
		return objTariffDetails;
	}
	
	public boolean doesTableExists(String tablename)
	{
		SQLiteDatabase db = this.getReadableDatabase();
		String sql = "SELECT name FROM sqlite_master WHERE type='table' AND name='"+tablename+"' ORDER BY name";
		Cursor cursor = db.rawQuery(sql, null);
		if(cursor.getCount()>0)
		{
			return true;
		}
		else
			return false;
		
	}

}

