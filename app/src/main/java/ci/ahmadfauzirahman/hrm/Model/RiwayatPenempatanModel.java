package ci.ahmadfauzirahman.hrm.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RiwayatPenempatanModel {
    @SerializedName("id_nip_nrp")
    @Expose
    private String idNipNrp;
    @SerializedName("nota_dinas")
    @Expose
    private String notaDinas;
    @SerializedName("tanggal")
    @Expose
    private String tanggal;
    @SerializedName("BagianPenempatan")
    @Expose
    private String bagianPenempatan;
    @SerializedName("sdmrumpun")
    @Expose
    private String sdmrumpun;
    @SerializedName("sdmsubrumpun")
    @Expose
    private String sdmsubrumpun;
    @SerializedName("sdmjennis")
    @Expose
    private String sdmjennis;
    @SerializedName("unitkerja")
    @Expose
    private String unitkerja;

    public String getIdNipNrp() {
        return idNipNrp;
    }

    public void setIdNipNrp(String idNipNrp) {
        this.idNipNrp = idNipNrp;
    }

    public String getNotaDinas() {
        return notaDinas;
    }

    public void setNotaDinas(String notaDinas) {
        this.notaDinas = notaDinas;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getBagianPenempatan() {
        return bagianPenempatan;
    }

    public void setBagianPenempatan(String bagianPenempatan) {
        this.bagianPenempatan = bagianPenempatan;
    }

    public String getSdmrumpun() {
        return sdmrumpun;
    }

    public void setSdmrumpun(String sdmrumpun) {
        this.sdmrumpun = sdmrumpun;
    }

    public String getSdmsubrumpun() {
        return sdmsubrumpun;
    }

    public void setSdmsubrumpun(String sdmsubrumpun) {
        this.sdmsubrumpun = sdmsubrumpun;
    }

    public String getSdmjennis() {
        return sdmjennis;
    }

    public void setSdmjennis(String sdmjennis) {
        this.sdmjennis = sdmjennis;
    }

    public String getUnitkerja() {
        return unitkerja;
    }

    public void setUnitkerja(String unitkerja) {
        this.unitkerja = unitkerja;
    }
}
