package com.webonise.friendsfinder;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;

import com.facebook.Session;
import com.webonise.friendsfinder.webservice.FacebookService;

public class MainActivity extends FragmentActivity {

	private static final String TAG = "MainActivity";
	MapFragment mapFragment;
	FriendListFragment fListFragment;
	FragmentManager fragmentManager=getSupportFragmentManager();
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		FragmentTransaction transaction=fragmentManager.beginTransaction();
		fListFragment= new FriendListFragment(this);
		mapFragment= new MapFragment(this);
		transaction.add(R.id.fragments, mapFragment);
		transaction.commit();
		
		//setTabContent();
		// start Facebook Login
		FacebookService mService =FacebookService.getIntance();
		mService.createFacebookSession(this);
	}

//	private void setTabContent() {
//		
//		mTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
//		mTabHost.setup(this, getSupportFragmentManager(), R.id.fragments);
//
//		mTabHost.addTab(mTabHost.newTabSpec("map").setIndicator("Map"),
//				MapFragment.class, null);
//		mTabHost.addTab(mTabHost.newTabSpec("friends").setIndicator("Friends"),
//				FriendListFragment.class, null);
//		mTabHost.setCurrentTab(1);
//	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		Session.getActiveSession().onActivityResult(this, requestCode,
				resultCode, data);
	}

	public void getLocationInMap(double longitude, double latitude, String name,String imageUrl) {

//		mTabHost.setCurrentTab(0);
//		MapFragment mapFragment= new MapFragment();
//		mapFragment.setMarker(latitude, longitude, name,imageUrl);
//		Log.v(null,"switched");
		
		
	}
}