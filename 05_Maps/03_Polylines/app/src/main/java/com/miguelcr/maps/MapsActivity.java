package com.miguelcr.maps;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMarkerDragListener {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        Marker marker = mMap.addMarker(
                new MarkerOptions()
                        .position(sydney)
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_marker))
                        .title("Marker in Sydney"));

        marker.setDraggable(true);

        mMap.setOnMarkerDragListener(this);

        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

        // Instantiates a new CircleOptions object and defines the center and radius
        CircleOptions circleOptions = new CircleOptions()
                .center(sydney)
                .fillColor(ContextCompat.getColor(this,R.color.colorAccentTransparent))
                .strokeWidth(10)
                .strokeColor(ContextCompat.getColor(this,R.color.colorAccent))
                .radius(1000);

        // Get back the mutable Circle
        Circle circle = mMap.addCircle(circleOptions);

    }

    @Override
    public void onMarkerDragStart(Marker marker) {
        Log.i("***LOC START***",marker.getPosition().latitude+","+marker.getPosition().longitude);
        marker.showInfoWindow();
    }

    @Override
    public void onMarkerDrag(Marker marker) {
        Log.i("***LOC MOVE***",marker.getPosition().latitude+","+marker.getPosition().longitude);
        marker.setSnippet(marker.getPosition().latitude+","+marker.getPosition().longitude);
    }

    @Override
    public void onMarkerDragEnd(Marker marker) {
        Log.i("***LOC FINISH***",marker.getPosition().latitude+","+marker.getPosition().longitude);
        marker.showInfoWindow();
    }
}
