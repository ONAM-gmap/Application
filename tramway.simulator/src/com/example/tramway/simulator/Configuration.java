package com.example.tramway.simulator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Configuration extends Activity {

	Button btn_config;
	private Button btn_voyage;
	private Button btn_echelle;
	private Button btn_arret_imp;
	private Button btn_vitesse;
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
	    setContentView(R.layout.configuration);
	    
	    btn_voyage=(Button) findViewById(R.id.voyage);
	    btn_voyage.setOnClickListener(new View.OnClickListener() {
			Intent i= new Intent(Configuration.this,Voyage.class); 
			@Override
			public void onClick(View v) {
				startActivity(i);
				
			}
		});
	    
	    btn_echelle=(Button) findViewById(R.id.configuration);
	    btn_echelle.setOnClickListener(new View.OnClickListener() {
			Intent i= new Intent(Configuration.this,Echelle.class); 
			@Override
			public void onClick(View v) {
				startActivity(i);
				
			}
		});
	    
	    btn_arret_imp=(Button) findViewById(R.id.arret_imp);
	    btn_arret_imp.setOnClickListener(new View.OnClickListener() {
			Intent i= new Intent(Configuration.this,ArretImp.class); 
			@Override
			public void onClick(View v) {
				startActivity(i);
				
			}
		});
	    
	    
	    btn_vitesse=(Button) findViewById(R.id.vitesse);
	    btn_vitesse.setOnClickListener(new View.OnClickListener() {
			Intent i= new Intent(Configuration.this,Vitesse.class); 
			@Override
			public void onClick(View v) {
				startActivity(i);
				
			}
		});
	    
	    
	    
	}
}
