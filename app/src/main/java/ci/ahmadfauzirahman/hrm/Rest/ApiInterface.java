package ci.ahmadfauzirahman.hrm.Rest;


import ci.ahmadfauzirahman.hrm.Response.AbsensiResponse;
import ci.ahmadfauzirahman.hrm.Response.LogAbsensiResponse;
import ci.ahmadfauzirahman.hrm.Response.PegawaiResponse;
import ci.ahmadfauzirahman.hrm.Response.RiwayatPenempatanResponse;
import ci.ahmadfauzirahman.hrm.Response.UserResponse;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {

    //Absen List Log

    @FormUrlEncoded
    @POST("v1/auth/login")
    Call<UserResponse> login(
            @Field("kodeAkun") String kode,
            @Field("password") String password
    );

    @FormUrlEncoded
    @POST("v1/absensi/ambil-data-absen")
    Call<LogAbsensiResponse> list_absensi(
            @Field("kode") String kode
    );

    @FormUrlEncoded
    @POST("v1/pegawai/index")
    Call<PegawaiResponse> getStrukturInstansi(
            @Field("nipnik") String kode
    );

    @FormUrlEncoded
    @POST("v1/absensi/simpan-absen")
    Call<AbsensiResponse> absenMasuk(
            @Field("nip") String nip,
            @Field("lat") String lat,
            @Field("long") String lng
    );

    @FormUrlEncoded
    @POST("v1/absensi/simpan-absen-keluar")
    Call<AbsensiResponse> absenPuLang(
            @Field("nip") String nip,
            @Field("lat") String lat,
            @Field("long") String lng
    );

    @FormUrlEncoded
    @POST("v1/absensi/ambil-absen-barcode")
    Call<AbsensiResponse> absensiByBarcode(
            @Field("nip") String nip

    );

    @GET("v1/pegawai/identitas-pegawai?id")
    Call<PegawaiResponse> getDataPegawai(@Query("id") String id);

    @GET("v1/pegawai/get-jabatan-golongan-penempatan-terakhir?id")
    Call<RiwayatPenempatanResponse> getRiwayat(@Query("id") String id);

    @FormUrlEncoded
    @POST("v1/auth/change-password")
    Call<UserResponse> changePassword(
            @Field("nip") String nip,
            @Field("password_lama") String password_lama,
            @Field("password_baru") String password_baru,
            @Field("password_confirm") String password_confirm
    );

}
