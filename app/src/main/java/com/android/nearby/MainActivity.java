package com.android.nearby;

import android.content.Intent;
import android.location.Location;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.akhgupta.easylocation.EasyLocationAppCompatActivity;
import com.akhgupta.easylocation.EasyLocationRequest;
import com.akhgupta.easylocation.EasyLocationRequestBuilder;
import com.google.android.gms.location.LocationRequest;

import java.util.ArrayList;

public class MainActivity extends EasyLocationAppCompatActivity {
 ArrayList<String>names;
    RecyclerView recyclerView;
    RecyclerAdapter recyclerAdapter;
    LinearLayoutManager linearLayoutManager;
    EasyLocationRequest easyLocationRequest;
    LocationRequest locationRequest;
    Integer current_position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        names = new ArrayList<>();
        names.add("ATM");
        names.add("HOSPITAL");
        names.add("PETROL BUNK");
        names.add("LODGING");
        names.add("POLICE");
        names.add("RESTAURANT");
        names.add("TRAIN STATION");

        recyclerView = (RecyclerView)findViewById(R.id.recycler);

        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerAdapter = new RecyclerAdapter(names,MainActivity.this);
        recyclerView.setAdapter(recyclerAdapter);




         locationRequest = new LocationRequest()
                .setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);
               // .setInterval(5000)
               // .setFastestInterval(5000);


         easyLocationRequest = new EasyLocationRequestBuilder()
                .setLocationRequest(locationRequest)
                .setFallBackToLastLocationTime(3000)
                .build();


    }
    public void location_fetch(Integer position){
        current_position = position;
        requestLocationUpdates(easyLocationRequest);
    }

    public void pop(Location location,Integer position){

        Uri gmmIntentUri = Uri.parse("geo:" + location.getLatitude() + "," + location.getLongitude() + "?q=" + names.get(position));
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);
    }


    @Override
    public void onLocationPermissionGranted() {

    }

    @Override
    public void onLocationPermissionDenied() {

    }

    @Override
    public void onLocationReceived(Location location) {
pop(location,current_position);
    }

    @Override
    public void onLocationProviderEnabled() {

    }

    @Override
    public void onLocationProviderDisabled() {

    }
}
