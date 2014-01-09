package com.example.tramway.simulator;

import android.os.Build;
import android.os.Parcel;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.graphics.Color;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.maps.model.TileOverlayOptions;

public class AnM {
	private DefaultMap defmap = DefaultMap.mA;
	private int count = 0;
	private boolean stop = false;
	private LatLng lastPosition = defmap.mA.AIN_DIAB;
	private LatLng newPosition;

	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	void aM(final Marker marker, final LatLng finalPosition, final TextView TV,
			int i) {

		final LatLng startPosition = marker.getPosition();
		ValueAnimator valueAnimator = new ValueAnimator();
		TimeInterpolator interp = (i == 0) ? new AccelerateInterpolator()
				: (i == 1) ? new DecelerateInterpolator()
						: (i == 2) ? new LinearInterpolator()
								: new AccelerateDecelerateInterpolator();
		valueAnimator.setInterpolator(interp);
		valueAnimator
				.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
					@TargetApi(Build.VERSION_CODES.HONEYCOMB_MR1)
					@Override
					public void onAnimationUpdate(ValueAnimator animation) {
						float v = animation.getAnimatedFraction();
						newPosition = linear(v, startPosition, finalPosition);
						marker.setPosition(newPosition);
						//drawTrack();
						DefaultMap.mA.googleMap.moveCamera(CameraUpdateFactory
								.newLatLng(newPosition));
						if (v == Float.valueOf(1)) {
							int iINT = 2;
							if (DefaultMap.mA.lll.get(count).iSt) {
								if (DefaultMap.mA.lll.size() - 1 > count) {
									if (DefaultMap.mA.lll.get(count + 1).iSt) {
										iINT = 3;
									} else {
										iINT = 0;
									}
								}
							} else {
								if (DefaultMap.mA.lll.size() - 1 > count) {
									if (DefaultMap.mA.lll.get(count + 1).iSt) {
										iINT = 1;
									} else {
										iINT = 2;
									}
								}
							}
							if (DefaultMap.mA.lll.size() - 1 > count) {
								count++;
								DefaultMap.mA.animateByLatLng(
										DefaultMap.mA.lll.get(count).ll, iINT);
							}
						}
					}
				});
		valueAnimator.setFloatValues(0, 1);
		valueAnimator.setDuration(6000);
		valueAnimator.start();
	}

	public LatLng linear(float fraction, LatLng a, LatLng b) {
		double lat = (b.latitude - a.latitude) * fraction + a.latitude;
		double lng = (b.longitude - a.longitude) * fraction + a.longitude;
		return new LatLng(lat, lng);
	}

	public void drawTrack() {

		defmap.mA.googleMap.addPolyline(new PolylineOptions().add(lastPosition, newPosition)
				.width(7).color(Color.BLUE));
		lastPosition = newPosition;

	}

}
