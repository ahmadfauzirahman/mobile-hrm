package ci.ahmadfauzirahman.hrm.Activity.ModulAbsensi;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import ci.ahmadfauzirahman.hrm.R;
import ci.ahmadfauzirahman.hrm.Response.AbsensiResponse;
import ci.ahmadfauzirahman.hrm.Rest.ApiClient;
import ci.ahmadfauzirahman.hrm.Rest.ApiInterface;
import ci.ahmadfauzirahman.hrm.Utils.SessionManager;
import cn.pedant.SweetAlert.SweetAlertDialog;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AbsenMapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private String TAG = this.getClass().getName();
    String mLatitudeRSUD = "0.5233203";
    String mLongitudeRSUD = "101.451869";
    String pLatitude, pLongitude, kode;
    double hasilJarak;
    TextView chekIn, chekOut;
    SessionManager sessionManager;
    ApiInterface apiService =
            ApiClient.getClient().create(ApiInterface.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_absen_maps);
        sessionManager = new SessionManager(this);
        kode = sessionManager.getUserDetail().get("username").toString();

        pLatitude = getIntent().getStringExtra("Lat");
        pLongitude = getIntent().getStringExtra("Long");

        chekIn = findViewById(R.id.chekIn);
        chekOut = findViewById(R.id.chekOut);

        hasilJarak = hitungjarak(pLatitude, pLongitude, mLatitudeRSUD, mLongitudeRSUD);
        System.out.println("Hasil Jarak " + hasilJarak);
//        String h = "Kurang Dari 1 KM";
//        if (hasilJarak < 1.0) {
//            new SweetAlertDialog(AbsenMapsActivity.this, SweetAlertDialog.SUCCESS_TYPE)
//                    .setTitleText("Berhasil")
//                    .setContentText("Anda DiJarak Presensi ")
//                    .show();
//        } else {
//            new SweetAlertDialog(AbsenMapsActivity.this, SweetAlertDialog.ERROR_TYPE)
//                    .setTitleText("Oops... Anda Dimana Ya!!")
//                    .setContentText("Jarak Anda Dari RSUD " + hasilJarak + " Km")
//                    .show();
////            Toast.makeText(getApplicationContext(), "Jarak RSUD DARI LOKASI SAYA SEKARANG " + +hasilJarak + " Km", Toast.LENGTH_SHORT).show();
//        }
        System.out.println("Latitude " + pLatitude + " Longitude " + pLongitude);


        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


        // absen masuk

        chekIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                absenMasuk(kode, pLatitude, pLongitude);
            }
        });

        chekOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                absenKeluar(kode, pLatitude, pLongitude);
            }
        });
    }

    private void absenKeluar(String kode, String pLatitude, String pLongitude) {
        apiService.absenPuLang(kode, pLatitude, pLongitude).enqueue(new Callback<AbsensiResponse>() {
            @Override
            public void onResponse(Call<AbsensiResponse> call, Response<AbsensiResponse> response) {
                if (response.isSuccessful()) {
                    if (response.body().getCon()) {
                        new SweetAlertDialog(AbsenMapsActivity.this, SweetAlertDialog.SUCCESS_TYPE)
                                .setTitleText("Hai")
                                .setContentText(response.body().getMsg())
                                .show();
                    } else {
                        new SweetAlertDialog(AbsenMapsActivity.this, SweetAlertDialog.ERROR_TYPE)
                                .setTitleText("Oops... Maaf Boy!!")
                                .setContentText(response.body().getMsg())
                                .show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Opps, Terjadi Masalah Hubungi Admin EDP", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<AbsensiResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Opss, Something Wrong", Toast.LENGTH_SHORT).show();
                Log.e(TAG, t.getLocalizedMessage());
            }
        });
    }

    private void absenMasuk(String nip, String pLatitude, String pLongitude) {
        apiService.absenMasuk(nip, pLatitude, pLongitude).enqueue(new Callback<AbsensiResponse>() {
            @Override
            public void onResponse(Call<AbsensiResponse> call, Response<AbsensiResponse> response) {
                if (response.isSuccessful()) {
                    if (response.body().getCon()) {
                        new SweetAlertDialog(AbsenMapsActivity.this, SweetAlertDialog.SUCCESS_TYPE)
                                .setTitleText("Hai")
                                .setContentText(response.body().getMsg())
                                .show();
                    } else {
                        new SweetAlertDialog(AbsenMapsActivity.this, SweetAlertDialog.ERROR_TYPE)
                                .setTitleText("Oops... Maaf Boy!!")
                                .setContentText(response.body().getMsg())
                                .show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Opps, Terjadi Masalah Hubungi Admin EDP", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<AbsensiResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Opss Something Wrong", Toast.LENGTH_SHORT).show();
                Log.e(TAG, t.getLocalizedMessage());
            }
        });
    }

    private static double hitungjarak(String slat1, String slng1, String slat2, String slng2) {

        double lat2 = Double.parseDouble(slat2);
        double lat1 = Double.parseDouble(slat1);
        double lng2 = Double.parseDouble(slng2);
        double lng1 = Double.parseDouble(slng1);
        double earthRadius = 3958.75;
        double dLat = Math.toRadians(lat2 - lat1);
        double dLng = Math.toRadians(lng2 - lng1);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
                        Math.sin(dLng / 2) * Math.sin(dLng / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double dist = earthRadius * c;

        int meterConversion = 1609;
        double myjr = dist * meterConversion;
        return Math.floor(myjr / 1000);
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

        Double t = Double.parseDouble(pLatitude);
        Double l = Double.parseDouble(pLongitude);
        // Add a marker in Sydney and move the camera
        mMap.setMinZoomPreference(17);
        createMarker(pLatitude, pLongitude, "Lokasi saya");
        LatLng sydney = new LatLng(t, l);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }

    protected Marker createMarker(String latitude, String longtitude, String title) {
        return mMap.addMarker(new MarkerOptions()
                .position(new LatLng(Double.parseDouble(latitude), Double.parseDouble(longtitude)))
                .title(title));
    }
}
