package ci.ahmadfauzirahman.hrm.Activity.ModulAbsensi;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import ci.ahmadfauzirahman.hrm.Activity.DetailPage.DetailMyTeamActivity;
import ci.ahmadfauzirahman.hrm.Activity.LoginActivity;
import ci.ahmadfauzirahman.hrm.Activity.MainActivity;
import ci.ahmadfauzirahman.hrm.R;
import ci.ahmadfauzirahman.hrm.Response.AbsensiResponse;
import ci.ahmadfauzirahman.hrm.Rest.ApiClient;
import ci.ahmadfauzirahman.hrm.Rest.ApiInterface;
import ci.ahmadfauzirahman.hrm.Utils.SessionManager;
import cn.pedant.SweetAlert.SweetAlertDialog;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailAbsenScannerActivity extends AppCompatActivity {

    private static final String TAG = DetailMyTeamActivity.class.getSimpleName();
    SessionManager sessionManager;
    String nama, username;
    TextView namaKaryawan, nipPegawai;
    Button btnAbsenQrcode;
    ApiInterface apiService =
            ApiClient.getClient().create(ApiInterface.class);
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_absen_scanner);
        sessionManager = new SessionManager(getApplicationContext());
        final String nip_pegawai = getIntent().getStringExtra("nip");

        String valid = getIntent().getStringExtra("valid");
        nama = sessionManager.getUserDetail().get("nama").toString();
        username = sessionManager.getUserDetail().get("username").toString();
        namaKaryawan = findViewById(R.id.namaKaryawan);
        btnAbsenQrcode = findViewById(R.id.btnAbsenQrcode);
        nipPegawai = findViewById(R.id.nipPegawai);
        namaKaryawan.setText(nama);
        nipPegawai.setText(nip_pegawai);
        assert nip_pegawai != null;
        btnAbsenQrcode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertAbsenBarcode(username);
            }
        });


    }

    private void insertAbsenBarcode(String nip_pegawai) {
        apiService.absensiByBarcode(nip_pegawai).enqueue(new Callback<AbsensiResponse>() {
            @Override
            public void onResponse(Call<AbsensiResponse> call, Response<AbsensiResponse> response) {
                if (response.isSuccessful()) {
                    if (response.body().getCon()) {
                        Toast.makeText(getApplicationContext(), response.body().getMsg(), Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), OptionsAbsenActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(getApplicationContext(), response.body().getMsg(), Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), OptionsAbsenActivity.class);
                        startActivity(intent);
                    }
                } else {
                    System.out.println("Ini Masalahnya" + response);
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

    public void onBackPressed() {
        Intent intent = new Intent(getApplicationContext(), OptionsAbsenActivity.class);
        startActivity(intent);
    }
}