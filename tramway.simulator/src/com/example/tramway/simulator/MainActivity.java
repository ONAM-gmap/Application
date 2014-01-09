package com.example.tramway.simulator;

import java.util.jar.JarFile;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends FragmentActivity {

	// buttons
	private Button btn_def_sim;
	private Button btn_conf;
	private Button btn_exit;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		

		// button de simulation par defaut
		btn_def_sim = (Button) findViewById(R.id.voyage);
		btn_def_sim.setOnClickListener(new View.OnClickListener() {
			Intent i = new Intent(MainActivity.this, DefaultMap.class);

		
			@Override
			public void onClick(View v) {
				 
				
				startActivity(i);

			}
		});
		
		btn_exit = (Button) findViewById(R.id.exit);
		btn_exit.setOnClickListener(new View.OnClickListener() {

		
			@Override
			public void onClick(View v) {
				MainActivity.this.finish(); 
				
			

			}
		});

		// button de configuration
		btn_conf = (Button) findViewById(R.id.configuration);
		btn_conf.setOnClickListener(new View.OnClickListener() {
			Intent i = new Intent(MainActivity.this, Tab.class);

			@Override
			public void onClick(View v) {
				startActivity(i);
				

			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void finish() {
        
		super.finish();
	}
}
