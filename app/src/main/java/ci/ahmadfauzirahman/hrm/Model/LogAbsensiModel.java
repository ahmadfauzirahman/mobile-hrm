package ci.ahmadfauzirahman.hrm.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LogAbsensiModel {

    @SerializedName("IdAbsensi")
    @Expose
    private Integer idAbsensi;
    @SerializedName("idPegawai")
    @Expose
    private String idPegawai;
    @SerializedName("Nip")
    @Expose
    private String nip;
    @SerializedName("TanggalMasuk")
    @Expose
    private String tanggalMasuk;
    @SerializedName("Hari")
    @Expose
    private String hari;
    @SerializedName("StatusMasuk")
    @Expose
    private String statusMasuk;
    @SerializedName("lat")
    @Expose
    private String lat;
    @SerializedName("long")
    @Expose
    private String _long;
    @SerializedName("jamMasuk")
    @Expose
    private String jamMasuk;

    public Integer getIdAbsensi() {
        return idAbsensi;
    }

    public void setIdAbsensi(Integer idAbsensi) {
        this.idAbsensi = idAbsensi;
    }

    public String getIdPegawai() {
        return idPegawai;
    }

    public void setIdPegawai(String idPegawai) {
        this.idPegawai = idPegawai;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getTanggalMasuk() {
        return tanggalMasuk;
    }

    public void setTanggalMasuk(String tanggalMasuk) {
        this.tanggalMasuk = tanggalMasuk;
    }

    public String getHari() {
        return hari;
    }

    public void setHari(String hari) {
        this.hari = hari;
    }

    public String getStatusMasuk() {
        return statusMasuk;
    }

    public void setStatusMasuk(String statusMasuk) {
        this.statusMasuk = statusMasuk;
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

    public String getJamMasuk() {
        return jamMasuk;
    }

    public void setJamMasuk(String jamMasuk) {
        this.jamMasuk = jamMasuk;
    }
}
