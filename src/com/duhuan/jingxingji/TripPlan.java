package com.duhuan.jingxingji;

import java.util.ArrayList;

import android.location.Location;
import android.location.LocationManager;
import android.util.Log;

class ViewSpot {
	public Location location;
	public int locationRange;
	public long startTime;
	public long endTime;
};

public class TripPlan {
	public ArrayList<ViewSpot> viewSpots = new ArrayList<ViewSpot>();
	
	public TripPlan() {
		ViewSpot test1 = new ViewSpot();
		test1.location = new Location(LocationManager.GPS_PROVIDER);
		test1.location.setLongitude(120.0);
		test1.location.setLatitude(30.0);
		test1.location.setAccuracy(1000);
		test1.locationRange = 900;
		viewSpots.add(test1);		
	}
	
	public boolean inTripPlan(Location location)
	{
		for(int i=0; i<viewSpots.size(); i++) {
			float distance = location.distanceTo(viewSpots.get(i).location);
			Log.i("JingXingJi","distance "+distance);
			if( distance < viewSpots.get(i).locationRange) {
				return true;
			}
		}
		return false;
	}
}
