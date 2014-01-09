package com.example.tramway.simulator;

import java.util.ArrayList;
import java.util.List;

import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import classes.TramStop;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class DefaultMap extends FragmentActivity {
	static final LatLng AIN_DIAB = new LatLng(33.587489, -7.680834);
	public static DefaultMap mA;
	private AnM anm= new AnM();
	SupportMapFragment mMap;
	GoogleMap googleMap;
	Marker tM;
	boolean aller = true;
	List<TramStop> lll = new ArrayList<TramStop>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.map);
		mA = this;
		mMap = (SupportMapFragment) getSupportFragmentManager()
				.findFragmentById(R.id.map);
		googleMap = mMap.getMap();

		tM = googleMap.addMarker(new MarkerOptions()
				.position(AIN_DIAB)
				.anchor(Float.valueOf((float) 0.5), Float.valueOf((float) 0.5))
				.icon(BitmapDescriptorFactory
						.fromResource(R.drawable.train_icon)).flat(true));
		if (googleMap != null) {
			googleMap.moveCamera(CameraUpdateFactory
					.newLatLngZoom(AIN_DIAB, 15));
		} else {
			Log.v("JMF", "map == null");
		}
		lll.add(new TramStop(true,new LatLng(33.587489, -7.680834)));
		lll.add(new TramStop(false, new LatLng(33.585854, -7.678909)));
		lll.add(new TramStop(false, new LatLng(33.583494, -7.677449)));
		lll.add(new TramStop(false, new LatLng(33.582234, -7.675121)));
		lll.add(new TramStop(true, new LatLng(33.58092, -7.674799)));
		lll.add(new TramStop(false, new LatLng(33.57864, -7.674275)));
		lll.add(new TramStop(true, new LatLng(33.576728, -7.673031)));
		lll.add(new TramStop(false, new LatLng(33.573831, -7.671035)));
		lll.add(new TramStop(false, new LatLng(33.573134, -7.670134)));
		lll.add(new TramStop(true, new LatLng(33.571954, -7.669383)));
		lll.add(new TramStop(false, new LatLng(33.570345, -7.668181)));
		lll.add(new TramStop(true, new LatLng(33.5682, -7.664255)));
		drawCircuit();
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();

	}

	public void animerIcone(View view) {
		if (aller) {
			aller = false;
		} else {
			aller = true;
		}
		TextView tv = (TextView) findViewById(R.id.textView1);
		anm.aM(tM, new LatLng(33.585854, -7.678909), tv, 0);
		Button btn = (Button) findViewById(R.id.button_animer);
		btn.setEnabled(false);

	}

	public void animateByLatLng(LatLng ll, int i) {
		TextView tv = (TextView) findViewById(R.id.textView1);
		anm.aM(tM, ll, tv, i);
		

	}
	
	public void drawCircuit() {
		for(int i=0;i<lll.size()-1;i++){			
		 googleMap.addPolyline(new PolylineOptions()
	     .add(lll.get(i).ll, lll.get(i+1).ll)
	     .width(5)
	     .color(Color.RED));
		}
	}

	public void sleep() {
		SystemClock.sleep(4000);
	}
	

}
