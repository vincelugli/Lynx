package com.lynx;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.os.Build;

public class LynxAppActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lynx_app);
		
		LinearLayout fragmentContainer = (LinearLayout) findViewById(R.id.userLinearLayout);
		
		LinearLayout layout = new LinearLayout(this);
		layout.setOrientation(LinearLayout.VERTICAL);
		
		layout.setId(9999);
		
		getFragmentManager().beginTransaction().add(layout.getId(), UserFragment.newInstance("TESTING"), "user 1").commit();
		getFragmentManager().beginTransaction().add(layout.getId(), UserFragment.newInstance("USER 2"), "user 2").commit();
		getFragmentManager().beginTransaction().add(layout.getId(), UserFragment.newInstance("USER 3"), "user 3").commit();
		getFragmentManager().beginTransaction().add(layout.getId(), UserFragment.newInstance("USER 4"), "user 4").commit();

		fragmentContainer.addView(layout);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.lynx_app, menu);
		return true;
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
	 * A User fragment containing a simple view.
	 */
	public static class UserFragment extends Fragment {

		public UserFragment() {
		}

	    public static UserFragment newInstance(String text) {

	    	UserFragment fragment = new UserFragment();

	        Bundle b = new Bundle();
	        b.putString("text", text);
	        fragment.setArguments(b);
	        return fragment;
	    }

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_lynx_app,
					container, false);

	        ((TextView) rootView.findViewById(R.id.userText)).setText(getArguments().getString("text"));
			return rootView;
		}
	}
}
