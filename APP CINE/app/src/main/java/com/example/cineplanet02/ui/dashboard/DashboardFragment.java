package com.example.cineplanet02.ui.dashboard;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.cineplanet02.DetallePelicula;
import com.example.cineplanet02.R;
import com.example.cineplanet02.databinding.FragmentDashboardBinding;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class DashboardFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;
    private FragmentDashboardBinding binding;
    private GoogleMap mMap ;
    private static final int REQUEST_LOCATION = 1;
    LatLng marker, gps;
    ArrayList<String> lstsedes = new ArrayList<>();
    Spinner spn;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);

        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);

        SupportMapFragment supportMapFragment = (SupportMapFragment)getChildFragmentManager().findFragmentById(R.id.google);

        supportMapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(@NonNull GoogleMap googleMap) {
                mMap = googleMap;
                if( Build.VERSION.SDK_INT >= 23) {
                    if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions(getActivity(), new String[]{android.Manifest.permission.ACCESS_COARSE_LOCATION, android.Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LOCATION);
                        onMapReady(googleMap);
                    } else {
                        getMap();
                    }
                }else {
                    getMap();
                }
            }
        });

        spn = view.findViewById(R.id.spnSedesMap);

        Sede();

        spn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                if (!spn.getSelectedItem().toString().equals("Selecciona una Sede")){
                    spnSEDE();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        return view;
    }


    private  void getMap() {
        if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            mMap.setMyLocationEnabled(true);
            LocationManager locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);
            Location location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
            gps = new LatLng(location.getLatitude(),location.getLongitude());
            CameraPosition CameraPosition = new CameraPosition.Builder().target(gps).zoom(12).build();
            CameraUpdate update = CameraUpdateFactory.newCameraPosition(CameraPosition);
            mMap.animateCamera(update);
        }
        mMap.getUiSettings().setZoomControlsEnabled(true);
    }

    public void spnSEDE(){
        String url = "http://192.168.100.21/CinePlanet/API/SedeBusqueda.php?nom="+spn.getSelectedItem().toString()+"";
        JsonObjectRequest get = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    mMap.clear();
                    JSONArray sede = response.getJSONArray("sede");
                    for (int i = 0 ; i<sede.length() ; i++){
                        JSONObject index = sede.getJSONObject(i);
                        marker = new LatLng(index.getDouble("Lat"),index.getDouble("Lng"));
                        mMap.addMarker(new MarkerOptions().position(marker).title(index.getString("Sede")));
                        CameraPosition CameraPosition = new CameraPosition.Builder().target(marker).zoom(12).build();
                        CameraUpdate update = CameraUpdateFactory.newCameraPosition(CameraPosition);
                        mMap.animateCamera(update);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println(error);
            }
        });
        Volley.newRequestQueue(getContext()).add(get);
    }



    public void Sede(){
        String url = "http://192.168.100.21/CinePlanet/API/MapsSede.php";
        JsonObjectRequest get = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    lstsedes.add("Selecciona una Sede");
                    JSONArray sede = response.getJSONArray("sede");
                    for (int i = 0 ; i<sede.length() ; i++){
                        JSONObject index = sede.getJSONObject(i);
                        lstsedes.add(index.getString("Sede"));
                        marker = new LatLng(index.getDouble("Lat"),index.getDouble("Lng"));
                        mMap.addMarker(new MarkerOptions().position(marker).title(index.getString("Sede")));
                    }
                    spn.setAdapter(new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_dropdown_item, lstsedes));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });

        Volley.newRequestQueue(getContext()).add(get);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}