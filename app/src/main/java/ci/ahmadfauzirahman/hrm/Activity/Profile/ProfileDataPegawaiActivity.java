package ci.ahmadfauzirahman.hrm.Activity.Profile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import ci.ahmadfauzirahman.hrm.Model.ModelPegawai;
import ci.ahmadfauzirahman.hrm.Model.RiwayatPenempatanModel;
import ci.ahmadfauzirahman.hrm.R;
import ci.ahmadfauzirahman.hrm.Response.PegawaiResponse;
import ci.ahmadfauzirahman.hrm.Response.RiwayatPenempatanResponse;
import ci.ahmadfauzirahman.hrm.Rest.ApiClient;
import ci.ahmadfauzirahman.hrm.Rest.ApiInterface;
import ci.ahmadfauzirahman.hrm.Utils.SessionManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileDataPegawaiActivity extends AppCompatActivity {
    ApiInterface apiService =
            ApiClient.getClient().create(ApiInterface.class);
    SessionManager sessionManager;
    private String TAG = this.getClass().getName();
    String nama, username;
    TextView no_ktp, no_npwp, nm_lengkap, tmp_tgl_lahir, jenis_kelamin, st_perkawainan, agama, kode_pos, rt_rw, alamat, kelurahan, kecamatan, kabupaten, provinsi;
    TextView tinggi_cm, berat_kg, rambutt, bentuk_muka, warna_kulit, ciri_khas, cacat_tubuh;
    TextView penempatan_sdm, rumpun_sdm, sub_rumpun, jenis_sdm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_data_pegawai);
        sessionManager = new SessionManager(this);

        username = sessionManager.getUserDetail().get("username");
        no_npwp = findViewById(R.id.no_npwp);
        no_ktp = findViewById(R.id.no_ktp);
        nm_lengkap = findViewById(R.id.nm_lengkap);
        tmp_tgl_lahir = findViewById(R.id.jenis_kelamin);
        jenis_kelamin = findViewById(R.id.tmp_tgl_lahir);
        st_perkawainan = findViewById(R.id.st_perkawainan);

        kode_pos = findViewById(R.id.kode_pos);
        rt_rw = findViewById(R.id.rt_rw);
        alamat = findViewById(R.id.alamat);
        kelurahan = findViewById(R.id.kelurahan);
        kecamatan = findViewById(R.id.kecamatan);
        kabupaten = findViewById(R.id.kabupaten);
        provinsi = findViewById(R.id.provinsi);


        tinggi_cm = findViewById(R.id.tinggi_cm);
        berat_kg = findViewById(R.id.berat_kg);
        rambutt = findViewById(R.id.rambutt);
        bentuk_muka = findViewById(R.id.bentuk_muka);
        warna_kulit = findViewById(R.id.warna_kulit);
        ciri_khas = findViewById(R.id.ciri_khas);
        cacat_tubuh = findViewById(R.id.cacat_tubuh);

        penempatan_sdm = findViewById(R.id.penempatan_sdm);
        rumpun_sdm = findViewById(R.id.rumpun_sdm);
        sub_rumpun = findViewById(R.id.sub_rumpun);
        jenis_sdm = findViewById(R.id.jenis_sdm);
        agama = findViewById(R.id.agama);

        riwayat_penempatan(username);
        detail(username);

    }

    private void riwayat_penempatan(String username) {
        apiService.getRiwayat(username).enqueue(new Callback<RiwayatPenempatanResponse>() {
            @Override
            public void onResponse(Call<RiwayatPenempatanResponse> call, Response<RiwayatPenempatanResponse> response) {
                if (response.isSuccessful()) {
                    if (response.body().getCon()) {
                        List<RiwayatPenempatanModel> riwayatPenempatanModels = response.body().getResults();
                        RiwayatPenempatanModel riwayatPenempatanModel = riwayatPenempatanModels.get(0);
                        penempatan_sdm.setText(riwayatPenempatanModel.getBagianPenempatan());
                        rumpun_sdm.setText(riwayatPenempatanModel.getSdmrumpun());
                        sub_rumpun.setText(riwayatPenempatanModel.getSdmsubrumpun());
                        jenis_sdm.setText(riwayatPenempatanModel.getSdmjennis());
                    } else {
                        Toast.makeText(getApplicationContext(), "Opps, Terjadi Masalah Hubungi Admin EDP", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Opps, Terjadi Masalah Hubungi Admin EDP", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<RiwayatPenempatanResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Opss, Something Wrong", Toast.LENGTH_SHORT).show();
                Log.e(TAG, t.getLocalizedMessage());
            }
        });
    }

    private void detail(String username) {
        final String nulls = "";
        apiService.getDataPegawai(username).enqueue(new Callback<PegawaiResponse>() {
            @Override
            public void onResponse(Call<PegawaiResponse> call, Response<PegawaiResponse> response) {
                if (response.isSuccessful()) {
                    if (response.body().getCon()) {
                        List<ModelPegawai> modelPegawais = response.body().getResults();
                        ModelPegawai modelPegawai = modelPegawais.get(0);


                        cacat_tubuh.setText(modelPegawai.getCacatTubuhKeteranganBadan());
                        ciri_khas.setText(modelPegawai.getCiriCiriKhasKeteranganBadan());
                        warna_kulit.setText(modelPegawai.getWarnaKulitKeteranganBadan());
                        bentuk_muka.setText(modelPegawai.getBentukMukaKeteranganBadan());
                        rambutt.setText(modelPegawai.getRambutKeteranganBadan());
                        berat_kg.setText(modelPegawai.getBeratBadanKeteranganBadan());
                        tinggi_cm.setText(modelPegawai.getTinggiKeteranganBadan());

                        kode_pos.setText(modelPegawai.getKodePos());
                        alamat.setText(modelPegawai.getAlamatTempatTinggal());
                        kecamatan.setText(modelPegawai.getKeca());
                        kelurahan.setText(modelPegawai.getKelurahan().trim());
                        kabupaten.setText(modelPegawai.getKabupaten());
                        provinsi.setText(modelPegawai.getPro());
                        rt_rw.setText(modelPegawai.getRwTempatTinggal() + " / " + modelPegawai.getRtTempatTinggal());

                        agama.setText(modelPegawai.getAgma());
                        st_perkawainan.setText(modelPegawai.getStatusPerkawinan());
                        tmp_tgl_lahir.setText(modelPegawai.getTanggalLahir());
                        jenis_kelamin.setText(modelPegawai.getJenisKelamin());
                        no_ktp.setText(modelPegawai.getNomorKtp());
                        nm_lengkap.setText(modelPegawai.getNamaLengkap() + " " + modelPegawai.getGelarSarjanaBelakang());
                        no_npwp.setText(modelPegawai.getNpwp().equals(nulls) ? "Npwp Tidak Ada" : modelPegawai.getNpwp());


                        System.out.println("ModelPegawai" + modelPegawai);
                    } else {
                        Toast.makeText(getApplicationContext(), "Opps, Terjadi Masalah Hubungi Admin EDP", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Opps, Terjadi Masalah Hubungi Admin EDP", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<PegawaiResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Opss, Something Wrong", Toast.LENGTH_SHORT).show();
                Log.e(TAG, t.getLocalizedMessage());
            }
        });
    }
}