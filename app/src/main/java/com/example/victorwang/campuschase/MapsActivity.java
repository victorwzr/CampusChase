package com.example.victorwang.campuschase;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.test.mock.MockPackageManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback{

    private GoogleMap mMap;
    private static final int REQUEST_CODE_PERMISSION = 2;
    String mPermission = Manifest.permission.ACCESS_FINE_LOCATION;

    // GPSTracker class
    GPSTracker gps;
    public double latitude;
    public double longitude;
    public double latitudeS;
    public double longitudeS;
    public int NoT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        try {
            if (ActivityCompat.checkSelfPermission(this, mPermission)
                    != MockPackageManager.PERMISSION_GRANTED) {

                ActivityCompat.requestPermissions(this, new String[]{mPermission},
                        REQUEST_CODE_PERMISSION);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        Button buttonmc = (Button) findViewById(R.id.btn_mc);
        buttonmc.setOnClickListener(mc);
        Button buttonmhint = (Button) findViewById(R.id.btn_mhint);
        buttonmhint.setOnClickListener(mhint);
        Button buttonms = (Button) findViewById(R.id.btn_ms);
        buttonms.setOnClickListener(ms);
        Button buttonclue = (Button) findViewById(R.id.btn_clue);
        buttonclue.setOnClickListener(mclue);
        Button buttonmm = (Button) findViewById(R.id.btn_Menu);
        buttonmm.setOnClickListener(mmac);

        gps = new GPSTracker(MapsActivity.this);

        if(gps.canGetLocation()){
            latitude = gps.getLatitude();
            longitude = gps.getLongitude();
            latitudeS = latitude;
            longitudeS = longitude;
        }else{
            gps.showSettingsAlert();
        }
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
        LatLng my = new LatLng(latitude, longitude);

        mMap.addMarker(new MarkerOptions().position(my).title("Marker in Your Location"));
        for (int i = 0;i<NoT;i++){
            //NoT is Number of Team member, by change latitudeS and longitudeS for each member location and add mark on map, need change here
            LatLng team = new LatLng(latitudeS,longitudeS);
            mMap.addMarker(new MarkerOptions().position(team).title("Team Member Location"));
        }
        mMap.moveCamera(CameraUpdateFactory.newLatLng(my));
    }

    private View.OnClickListener mclue = new View.OnClickListener(){
        public void onClick(View v){
            new AlertDialog.Builder(MapsActivity.this)
                    .setTitle("Clue")
                    .setMessage("Clue here")
                    .setNegativeButton("Next Clue",null)
                    .setPositiveButton("Sure",null)
                    .show();

        }
    };


    private View.OnClickListener mhint = new View.OnClickListener(){
        public void onClick(View v){
            new AlertDialog.Builder(MapsActivity.this)
                    .setTitle("Hint")
                    .setMessage("Hint Here")
                    .setNegativeButton("Next Hint",null)
                    .setPositiveButton("Sure",null)
                    .show();

        }
    };
    private View.OnClickListener mc = new View.OnClickListener(){
        public void onClick(View v){
            new AlertDialog.Builder(MapsActivity.this)
                    .setMessage("Change to Cam")
                    .setPositiveButton("Sure",null)
                    .show();

        }
    };
    private View.OnClickListener  ms = new View.OnClickListener(){
        public void onClick(View v){
            Intent msIntent = new Intent(MapsActivity.this,ScoresActivity.class);
            MapsActivity.this.startActivity(msIntent);
        }
    };
    private View.OnClickListener  mmac = new View.OnClickListener(){
        public void onClick(View v){
            Intent mmacIntent = new Intent(MapsActivity.this,MainMenuActivity.class);
            MapsActivity.this.startActivity(mmacIntent);
        }
    };
}
