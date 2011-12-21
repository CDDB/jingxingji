package com.duhuan.jingxingji;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.os.Bundle;
import android.widget.TextView;

public class Tracker extends Activity {
	TextView tv;
	TripPlan tripPlan;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tv = new TextView(this);
        tv.setText("Hello Travler!");
        setContentView(tv);
        tripPlan = new TripPlan();
    	LocationManager locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
     // Define a listener that responds to location updates
        LocationListener locationListener = new LocationListener() {
            public void onLocationChanged(Location location) {
              // Called when a new location is found by the network location provider.
              makeUseOfNewLocation(location);
            }
            public void onStatusChanged(String provider, int status, Bundle extras) {}

            public void onProviderEnabled(String provider) {}

            public void onProviderDisabled(String provider) {}
          };

        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);    
    }
    
    private void makeUseOfNewLocation(Location location) {
    	if(tripPlan.inTripPlan(location)) {
    		tv.setText("In Plan! \n"+location.toString());
    	} else {
    		tv.setText("Not In Plan!\n"+location.toString());
    	}
    }
}