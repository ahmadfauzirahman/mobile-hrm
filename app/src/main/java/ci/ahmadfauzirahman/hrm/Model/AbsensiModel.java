package ci.ahmadfauzirahman.hrm.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AbsensiModel {
    @SerializedName("id_tb_absensi")
    @Expose
    private Integer idTbAbsensi;
    @SerializedName("id_pegawai")
    @Expose
    private String idPegawai;
    @SerializedName("nip_nik")
    @Expose
    private String nipNik;
    @SerializedName("jam_masuk")
    @Expose
    private String jamMasuk;
    @SerializedName("jam_keluar")
    @Expose
    private String jamKeluar;
    @SerializedName("tanggal_masuk")
    @Expose
    private String tanggalMasuk;
    @SerializedName("lat")
    @Expose
    private String lat;
    @SerializedName("long")
    @Expose
    private String _long;
    @SerializedName("status")
    @Expose
    private String status;

    public Integer getIdTbAbsensi() {
        return idTbAbsensi;
    }

    public void setIdTbAbsensi(Integer idTbAbsensi) {
        this.idTbAbsensi = idTbAbsensi;
    }

    public String getIdPegawai() {
        return idPegawai;
    }

    public void setIdPegawai(String idPegawai) {
        this.idPegawai = idPegawai;
    }

    public String getNipNik() {
        return nipNik;
    }

    public void setNipNik(String nipNik) {
        this.nipNik = nipNik;
    }

    public String getJamMasuk() {
        return jamMasuk;
    }

    public void setJamMasuk(String jamMasuk) {
        this.jamMasuk = jamMasuk;
    }

    public String getJamKeluar() {
        return jamKeluar;
    }

    public void setJamKeluar(String jamKeluar) {
        this.jamKeluar = jamKeluar;
    }

    public String getTanggalMasuk() {
        return tanggalMasuk;
    }

    public void setTanggalMasuk(String tanggalMasuk) {
        this.tanggalMasuk = tanggalMasuk;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLong() {
        return _long;
    }

    public void setLong(String _long) {
        this._long = _long;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
