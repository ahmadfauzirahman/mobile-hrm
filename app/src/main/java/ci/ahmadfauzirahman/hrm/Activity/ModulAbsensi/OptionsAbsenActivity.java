package ci.ahmadfauzirahman.hrm.Activity.ModulAbsensi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.tasks.OnSuccessListener;

import java.util.Locale;

import ci.ahmadfauzirahman.hrm.R;
import ci.ahmadfauzirahman.hrm.Utils.AppConstants;
import ci.ahmadfauzirahman.hrm.Utils.GpsUtils;

public class OptionsAbsenActivity extends AppCompatActivity {
    private FusedLocationProviderClient mFusedLocationClient;
    private double wayLatitude = 0.0, wayLongitude = 0.0;
    private LocationRequest locationRequest;
    private LocationCallback locationCallback;
    private android.widget.Button btnLocation;
    private TextView txtLocation;
    private android.widget.Button btnContinueLocation;
    private TextView txtContinueLocation;
    private StringBuilder stringBuilder;
    private GoogleMap googleMap;
    private boolean isContinue = false;
    private boolean isGPS = false;
    SwipeRefreshLayout swipeRefreshLayout;
    private GoogleMap mMap;
    int MY_PERMISSION_ACCESS_COURSE_LOCATION = 11;
    int MY_PERMISSIONS_REQUEST_LOCATION = 99;
    private MapView mapView;
    private static final String MAP_VIEW_BUNDLE_KEY = "AIzaSyArirdNnJ-ekSdArK8eC_jIwbXQjQdnj7s";
    String Lat, Long;
    TextView dLatitude, dLongitude;
    CardView cardAmbilAbsenByLokasi, cardMap;
    private ProgressDialog pDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options_absen);
        cardAmbilAbsenByLokasi = findViewById(R.id.cardAmbilAbsenByLokasi);
        cardMap = findViewById(R.id.cardMap);

        this.txtLocation = (TextView) findViewById(R.id.txtLocation);
        this.dLatitude = (TextView) findViewById(R.id.dLatitude);
        this.dLongitude = (TextView) findViewById(R.id.dLongitude);
        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
        locationRequest = LocationRequest.create();
        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        locationRequest.setInterval(10 * 1000); // 10 seconds
        locationRequest.setFastestInterval(5 * 1000); // 5 seconds

        new GpsUtils(this).turnGPSOn(new GpsUtils.onGpsListener() {
            @Override
            public void gpsStatus(boolean isGPSEnable) {
                // turn on GPS
                isGPS = isGPSEnable;
            }
        });

        locationCallback = new LocationCallback() {
            @Override
            public void onLocationResult(LocationResult locationResult) {
                if (locationResult == null) {
                    return;
                }
                for (Location location : locationResult.getLocations()) {
                    if (location != null) {
                        wayLatitude = location.getLatitude();
                        wayLongitude = location.getLongitude();
                        Lat = Double.toString(wayLatitude);
                        Long = Double.toString(wayLongitude);
                        dLatitude.setText(Lat);
                        dLongitude.setText(Long);
                        if (!isContinue) {
                            txtLocation.setText(String.format(Locale.US, "%s - %s", wayLatitude, wayLongitude));
                        } else {
                            stringBuilder.append(wayLatitude);
                            stringBuilder.append("-");
                            stringBuilder.append(wayLongitude);
                            stringBuilder.append("\n\n");
                            txtContinueLocation.setText(stringBuilder.toString());

                        }
                        if (!isContinue && mFusedLocationClient != null) {
                            mFusedLocationClient.removeLocationUpdates(locationCallback);
                        }
                    }
                }
            }
        };

        getLocation();
        cardAmbilAbsenByLokasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pDialog = new ProgressDialog(OptionsAbsenActivity.this);
                pDialog.setCancelable(false);
                pDialog.setMax(100);
                pDialog.setMessage("Mohon menunggu, Sedang Menyiapkan Map");
                pDialog.show();

                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    public void run() {
                        pDialog.dismiss();
                    }
                }, 8000);
//                Toast.makeText(getApplicationContext(),"Latitude " + dLatitude.getText(),Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), AbsenMapsActivity.class);
                intent.setFlags(intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("Lat", dLatitude.getText());
                intent.putExtra("Long", dLongitude.getText());
                startActivity(intent);
            }
        });

        cardMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), AbsenScannerActivity.class));
            }
        });
    }

    private void getLocation() {
        if (ActivityCompat.checkSelfPermission(OptionsAbsenActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(OptionsAbsenActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(OptionsAbsenActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION},
                    AppConstants.LOCATION_REQUEST);
            ActivityCompat.requestPermissions(OptionsAbsenActivity.this, new String[]{Manifest.permission.CAMERA}, Integer.parseInt(Manifest.permission.CAMERA));
        } else {
            if (isContinue) {
                mFusedLocationClient.requestLocationUpdates(locationRequest, locationCallback, null);
            } else {
                mFusedLocationClient.getLastLocation().addOnSuccessListener(OptionsAbsenActivity.this, new OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(Location location) {
                        if (location != null) {
                            wayLatitude = location.getLatitude();
                            wayLongitude = location.getLongitude();
                            txtLocation.setText(String.format(Locale.US, "%s - %s", wayLatitude, wayLongitude));
                            dLatitude.setText(Double.toString(wayLatitude));
                            dLongitude.setText(Double.toString(wayLongitude));
                        } else {
                            mFusedLocationClient.requestLocationUpdates(locationRequest, locationCallback, null);
                        }
                    }
                });
            }
        }
    }

    @SuppressLint("MissingPermission")
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 1000: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    if (isContinue) {
                        mFusedLocationClient.requestLocationUpdates(locationRequest, locationCallback, null);
                    } else {
                        mFusedLocationClient.getLastLocation().addOnSuccessListener(OptionsAbsenActivity.this, new OnSuccessListener<Location>() {
                            @Override
                            public void onSuccess(Location location) {
                                if (location != null) {
                                    wayLatitude = location.getLatitude();
                                    wayLongitude = location.getLongitude();
                                    txtLocation.setText(String.format(Locale.US, "%s - %s", wayLatitude, wayLongitude));
                                } else {
                                    mFusedLocationClient.requestLocationUpdates(locationRequest, locationCallback, null);
                                }
                            }
                        });
                    }
                } else {
                    Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show();
                }
                break;
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == AppConstants.GPS_REQUEST) {
                isGPS = true; // flag maintain before get location
            }
        }
    }
}
