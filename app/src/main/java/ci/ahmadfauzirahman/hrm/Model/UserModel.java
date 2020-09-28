package ci.ahmadfauzirahman.hrm.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserModel {
    @SerializedName("userid")
    @Expose
    private Integer userid;
    @SerializedName("id_pegawai")
    @Expose
    private Integer idPegawai;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("nama")
    @Expose
    private String nama;
    @SerializedName("tanggal_pendaftaran")
    @Expose
    private String tanggalPendaftaran;
    @SerializedName("role")
    @Expose
    private String role;
    @SerializedName("token_aktivasi")
    @Expose
    private Object tokenAktivasi;
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("foto")
    @Expose
    private Object foto;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getIdPegawai() {
        return idPegawai;
    }

    public void setIdPegawai(Integer idPegawai) {
        this.idPegawai = idPegawai;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTanggalPendaftaran() {
        return tanggalPendaftaran;
    }

    public void setTanggalPendaftaran(String tanggalPendaftaran) {
        this.tanggalPendaftaran = tanggalPendaftaran;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Object getTokenAktivasi() {
        return tokenAktivasi;
    }

    public void setTokenAktivasi(Object tokenAktivasi) {
        this.tokenAktivasi = tokenAktivasi;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Object getFoto() {
        return foto;
    }

    public void setFoto(Object foto) {
        this.foto = foto;
    }
}
