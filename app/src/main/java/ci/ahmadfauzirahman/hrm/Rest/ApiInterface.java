package ci.ahmadfauzirahman.hrm.Rest;


import ci.ahmadfauzirahman.hrm.Response.LogAbsensiResponse;
import ci.ahmadfauzirahman.hrm.Response.UserResponse;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiInterface {

    //Absen List Log

    @FormUrlEncoded
    @POST("v1/auth/login")
    Call<UserResponse> login(
            @Field("kodeAkun") String kode,
            @Field("password") String password
    );

    @FormUrlEncoded
    @POST("v1/absen/ambil-data-absen")
    Call<LogAbsensiResponse> list_absensi(
            @Field("kode") String kode
    );

    /*@FormUrlEncoded
    @POST("v1/service/login")
    Call<LoginResponse> login(
            @Field("kode") String kode,
            @Field("password") String password
    );


    //lpj list
    @FormUrlEncoded
    @POST("v1/api-lpj/list")
    Call<LpjResponse> lpjlist(
            @Field("nomor_satker") String nomor_satker
    );

    //laporan keuangan list
    @FormUrlEncoded
    @POST("v1/service/list-laporan-keuangan")
    Call<LaporanKeuanganResponse> laporankeuanganlist(
            @Field("nomor_satker") String nomor_satker
    );

    //tup list
    @FormUrlEncoded
    @POST("v1/service/list-tup")
    Call<TupResponse> tuplist(
            @Field("nomor_satker") String nomor_satker
    );

    // konfirmasi penerimaan list
    @FormUrlEncoded
    @POST("v1/service/list-konfirmasi-penerimaan")
    Call<KonfirmasiPenerimaanResponse> konfirmasipenerimaanlist(
            @Field("nomor_satker") String nomor_satker
    );

    //koreksi penerimaan list
    @FormUrlEncoded
    @POST("v1/service/list-koreksi-penerimaan")
    Call<KoreksiPenerimaanResponse> koreksipenerimaanlist(
            @Field("nomor_satker") String nomor_satker
    );


    // save lpj
    @FormUrlEncoded
    @POST("v1/api-lpj/save")
    Call<LpjResponse> savelpj(
            @Field("nomor_satker") String nomor_satker,
            @Field("nomor_surat") String nomor_surat
    );


    //save laporan keuangan
    @FormUrlEncoded
    @POST("v1/service/save-laporan-keuangan")
    Call<LaporanKeuanganResponse> savelaporankeuangan(
            @Field("nomor_satker") String nomor_satker,
            @Field("nomor_surat") String nomor_surat
    );

    //save tup
    @FormUrlEncoded
    @POST("v1/service/save-tup")
    Call<TupResponse> saveTup(
            @Field("nomor_satker") String nomor_satker,
            @Field("nomor_surat") String nomor_surat
    );

    // konfirmasi save
    @FormUrlEncoded
    @POST("v1/service/save-konfirmasi")
    Call<KonfirmasiPenerimaanResponse> saveKonfirmasi(
            @Field("nomor_satker") String nomor_satker,
            @Field("nomor_surat") String nomor_surat
    );

    //koreksi save
    @FormUrlEncoded
    @POST("v1/service/save-koreksi")
    Call<KoreksiPenerimaanResponse> saveKoreksi(
            @Field("nomor_satker") String nomor_satker,
            @Field("nomor_surat") String nomor_surat
    );


    @FormUrlEncoded
    @POST("api-spm/getonedatasmp")
    Call<SpmResponse> getAllSpm(
            @Field("kode_stakeholder") String kode_stakeholder
    );

    @FormUrlEncoded
    @POST("api-kontrak/getmobilekontrakapi")
    Call<SpmResponse> getAllKontrak(
            @Field("kode_stakeholder") String kode_stakeholder
    );
    @FormUrlEncoded
    @POST("api-skpp/alldatabystakeholder")
    Call<SkppResponse> getAllSkpp(
            @Field("kode_stakeholder") String kode_stakeholder
    );
    @FormUrlEncoded
    @POST("api-spm/addspm")
    Call<SpmResponse> spmDaftar(
            @Field("kode_stakeholder") String kode_stakeholder,
            @Field("nomor_spm") String nomor_spm,
            @Field("jenis_notif") String jenis_notif
    );

    @FormUrlEncoded
    @POST("api-skpp/addskpp")
    Call<SkppResponse> skppDaftar(
            @Field("kode_stakeholder") String kode_stakeholder,
            @Field("nomor_skpp") String nomor_skpp
    );


    @FormUrlEncoded
    @POST("api-all-sikaping/getspm")
    Call<SpmResponse> getOneSpm(
            @Field("nomor_spm") String nomor_spm
    );

    @FormUrlEncoded
    @POST("api-all-sikaping/getskpp")
    Call<SkppResponse> getOneSkpp(
            @Field("nomor_skpp") String nomor_skpp
    );
*/



}
