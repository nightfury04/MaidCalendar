package com.example.myapp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.roomorama.caldroid.CaldroidFragment;
import com.roomorama.caldroid.CaldroidListener;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends FragmentActivity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks {

    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;
    final SimpleDateFormat formatter = new SimpleDateFormat("dd MMM yyyy");
    /**
     * Used to store the last screen title. For use in {@link #restoreActionBar()}.
     */
    private CharSequence mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getFragmentManager().findFragmentById(R.id.navigation_drawer);
        mTitle = getTitle();

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));

    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        // update the main content by replacing fragments
    	 
        updateFragment(position);
        
        
    }

    public void onSectionAttached(int number) {
        switch (number) {
            case 1:
                mTitle = getString(R.string.title_section1);
               
                break;
            case 2:
                mTitle = getString(R.string.title_section2);
               
                break;
            case 3:
                mTitle = getString(R.string.title_section3);
               
                break;
            case 4:
                mTitle = getString(R.string.title_section4);
              
                break;
        }
    }
    
    
    public void updateFragment(int position)
    {
    	
    	position = position +1;
    	FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        
        
    	 switch (position) {
         case 1:
        	 
        	
        	 final CaldroidFragment caldroidFragment = new CaldroidFragment();
             
             final CaldroidListener listener = new CaldroidListener() {
            	LeaveTrackerDBHandler dbHandler = new LeaveTrackerDBHandler(MainActivity.this);

     			@Override
     			public void onSelectDate(Date date, View view) {
//     				Toast.makeText(getApplicationContext(), formatter.format(date),
//     						Toast.LENGTH_SHORT).show();
     				
     				System.out.println(date);
     				
     				final Dialog dialog = new Dialog(MainActivity.this);
     				final Date tempDate = date;
     				dialog.setContentView(R.layout.dialog_box);
     				dialog.setTitle(formatter.format(date));
     			    dialog.setCancelable(true);
     			    
     			   RadioButton rd1 = (RadioButton) dialog.findViewById(R.id.radioButton1);
     			   rd1.setOnClickListener(new OnClickListener() {
					
					public void onClick(View v) {
						// TODO Auto-generated method stub
						
						caldroidFragment.setBackgroundResourceForDate(R.color.caldroid_green, tempDate);
						
						int noOfEntryPresent = dbHandler.getLeaveCount(formatter.format(tempDate));
						if(noOfEntryPresent >= 1)
						{
							dbHandler.updateLeaveTrackerEntry(new LeaveTracker(formatter.format(tempDate),"0","2"));
						}
						else
						{
							dbHandler.addLeaveTrackerEntry(new LeaveTracker(formatter.format(tempDate),"0","2"));
						}
						dialog.dismiss();
						caldroidFragment.refreshView();
						Toast.makeText(getApplicationContext(),formatter.format(tempDate)+": Full Attendance", Toast.LENGTH_SHORT).show();
					}
				});
     			   RadioButton rd2 = (RadioButton) dialog.findViewById(R.id.radioButton2);
     			  rd2.setOnClickListener(new OnClickListener() {
  					
  					public void onClick(View v) {
  						// TODO Auto-generated method stub
  						caldroidFragment.setBackgroundResourceForDate(R.color.caldroid_yellow, tempDate);
  						int noOfEntryPresent = dbHandler.getLeaveCount(formatter.format(tempDate));
						if(noOfEntryPresent >= 1)
						{
							dbHandler.updateLeaveTrackerEntry(new LeaveTracker(formatter.format(tempDate),"1","1"));
						}
						else
						{
							dbHandler.addLeaveTrackerEntry(new LeaveTracker(formatter.format(tempDate),"1","1"));
						}
  						dialog.dismiss();
  						caldroidFragment.refreshView();
  						Toast.makeText(getApplicationContext(),formatter.format(tempDate)+": Half Day Leave", Toast.LENGTH_SHORT).show();
  					}
  				});
     			   
     			   RadioButton rd3 = (RadioButton) dialog.findViewById(R.id.radioButton3);
     			  rd3.setOnClickListener(new OnClickListener() {
    					
    					public void onClick(View v) {
    						// TODO Auto-generated method stub
    						caldroidFragment.setBackgroundResourceForDate(R.color.caldroid_red, tempDate);
    						int noOfEntryPresent = dbHandler.getLeaveCount(formatter.format(tempDate));
    						if(noOfEntryPresent >= 1)
    						{
    							dbHandler.updateLeaveTrackerEntry(new LeaveTracker(formatter.format(tempDate),"2","0"));
    						}
    						else
    						{
    							dbHandler.addLeaveTrackerEntry(new LeaveTracker(formatter.format(tempDate),"2","0"));
    						}
    						dialog.dismiss();
    						caldroidFragment.refreshView();
    						Toast.makeText(getApplicationContext(),formatter.format(tempDate)+": Full Day Leave", Toast.LENGTH_SHORT).show();
    					}
    				});
     			   dialog.show();
     				
     				
     				caldroidFragment.refreshView();

     			}

     			@Override
     			public void onChangeMonth(int month, int year) {
     				String text = "month: " + month + " year: " + year;
//     				Toast.makeText(getApplicationContext(), text,
//     						Toast.LENGTH_SHORT).show();
     	        	 
     			}

     			@Override
     			public void onLongClickDate(Date date, View view) {
     				Toast.makeText(getApplicationContext(),
     						"Long click " + formatter.format(date),
     						Toast.LENGTH_SHORT).show();
     				List<LeaveTracker> lstLTracker = dbHandler.getAllLeaveTrackerEntries();
    	        	 for(LeaveTracker lt : lstLTracker)
    	        	 {
    	        		 String log = "Date : " + lt._monthDate + " , Leave: " + lt._noOfLeave + ", Attendance: "+lt._attendance;
    	        		 Log.d("LOG: ", log);
    	        	 }
     			}

     			@Override
     			public void onCaldroidViewCreated() {
     				if (caldroidFragment.getLeftArrowButton() != null) {
//     					Toast.makeText(getApplicationContext(),
//     							"Caldroid view is created", Toast.LENGTH_SHORT)
//     							.show();
     				}
     			}

     		};
     		
     		caldroidFragment.setCaldroidListener(listener);
     		
     		
     		// Setting colors/holidays on calendar refresh
     		
     		 LeaveTrackerDBHandler dbHandler = new LeaveTrackerDBHandler(MainActivity.this);
        	 Log.d("Reading: ", "Reading all entries..");
        	 List<LeaveTracker> lstLTracker = dbHandler.getAllLeaveTrackerEntries();
			if (!lstLTracker.isEmpty()) {
				for (LeaveTracker lt : lstLTracker) {
					String log = "Date : " + lt._monthDate + " , Leave: "
							+ lt._noOfLeave;
					Log.d("LOG: ", log);

					try {
						Date objDate = formatter.parse(lt._monthDate);
						int noOfLeave = Integer.parseInt(lt._noOfLeave);
						if(noOfLeave==0)
						{
							caldroidFragment.setBackgroundResourceForDate(R.color.caldroid_green, objDate);
						}else 
							if(noOfLeave==1)
							{
								caldroidFragment.setBackgroundResourceForDate(R.color.caldroid_yellow, objDate);
							}else
								if(noOfLeave==2)
								{
									caldroidFragment.setBackgroundResourceForDate(R.color.caldroid_red, objDate);
								}

					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
        	 ft.replace(R.id.container, caldroidFragment);
        	 ft.commit();            
             break;
         case 2:

        	 HolidayList_fragment hlFragment = new HolidayList_fragment();
        	 ft.replace(R.id.container, hlFragment);
        	 ft.commit();
        	 
             break;
         case 3:
            
        	 SalaryDetails_fragment sdFragment = new SalaryDetails_fragment();
        	 ft.replace(R.id.container, sdFragment);
        	 ft.commit();
        	 
             break;
         case 4:
             Tariff_fragment tfragment = new Tariff_fragment(); 
             ft.replace(R.id.container, tfragment);
             ft.commit();
             break;
    	 }
    }
    
    

    
    public void restoreActionBar() {
        ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            getMenuInflater().inflate(R.menu.main, menu);
            restoreActionBar();
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends DialogFragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            //TextView textView = (TextView) rootView.findViewById(R.id.section_label);
            //textView.setText(Integer.toString(getArguments().getInt(ARG_SECTION_NUMBER)));
            return rootView;
        }

        @Override
        public void onAttach(Activity activity) {
            super.onAttach(activity);
            ((MainActivity) activity).onSectionAttached(
                    getArguments().getInt(ARG_SECTION_NUMBER));
        }
    }

}
