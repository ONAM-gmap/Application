package com.example.tramway.simulator;

import android.app.Activity;
import android.app.TabActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TabHost;
import android.widget.AdapterView.OnItemSelectedListener;

public class Tab extends  Activity {

	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tab);


		
		TabHost tabs = (TabHost) findViewById(R.id.tabhost);
		tabs.setup();

		TabHost.TabSpec spec = tabs.newTabSpec("tag1");
		spec.setContent(R.id.Arret);
		spec.setIndicator("Arret");
		tabs.addTab(spec);

		spec = tabs.newTabSpec("tag2");
		spec.setContent(R.id.Echelle);
		spec.setIndicator("Echelle");
		tabs.addTab(spec);

		spec = tabs.newTabSpec("tag3");
		spec.setContent(R.id.Vitesse);
		spec.setIndicator("Vitesse");
		tabs.addTab(spec);

		spec = tabs.newTabSpec("tag4");
		spec.setContent(R.id.Voyage);
		spec.setIndicator("Voyage");
		tabs.addTab(spec);

		tabs.setCurrentTab(0);
		
		

	}
}
