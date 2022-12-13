package com.example.gpslocation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements LocationListener {
    TextView tv_lat, tv_log;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final Button getButton = (Button) findViewById(R.id.bt_get);
        final EditText locationText = (EditText) findViewById(R.id.et_name);
        tv_lat = (TextView) findViewById(R.id.tv_lat);
        tv_log = (TextView) findViewById(R.id.tv_log);
        LocationManager lcMg = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        lcMg.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, (LocationListener) this);
        getButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Geocoder geocoder = new Geocoder(MainActivity.this);
                    List<Address> list = geocoder.getFromLocationName(locationText.getText().toString(), 1);
                    if(list!=null && list.size()>0){
                        Address adr=list.get(0);
                        tv_lat.setText(Double.toString(adr.getLatitude()));
                        tv_log.setText(Double.toString(adr.getLongitude()));
                    }
                }
                catch (Exception e){
                    e.printStackTrace();
                }

            }
        });
    }


    @Override
    public void onLocationChanged(Location location) {
        tv_lat.setText(Double.toString(location.getLatitude()));
        tv_log.setText(Double.toString(location.getLongitude()));
    }
}