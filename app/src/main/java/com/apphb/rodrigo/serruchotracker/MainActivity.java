package com.apphb.rodrigo.serruchotracker;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import javax.xml.datatype.Duration;

public class MainActivity extends Activity
        implements OnMapReadyCallback {

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        boolean handled;
        int itemId = item.getItemId();
        switch (itemId) {
            case R.id.action_exit:
                handled = menuClickActionExit(item);
                break;
            default:
                handled = super.onOptionsItemSelected(item);
        }
        return handled;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.mapFragment);
        mapFragment.getMapAsync(this);
    }

    boolean menuClickActionExit(MenuItem item) {
        finish();
        return true;
    }

    public void buttonClickShowToast01(View view) {
        Toast toast = Toast.makeText(this, "Toast 01", Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        LatLng torreMadol = new LatLng(20.6513633, -103.4073563);
        googleMap.addMarker(new MarkerOptions().position(torreMadol)
                .title("Marker in Work")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN)));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(torreMadol, 15));
    }
}
