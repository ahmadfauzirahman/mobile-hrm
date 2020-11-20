package ci.ahmadfauzirahman.hrm.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ModelPegawai {
    @SerializedName("pegawai_id")
    @Expose
    private Integer pegawaiId;
    @SerializedName("id_nip_nrp")
    @Expose
    private String idNipNrp;
    @SerializedName("nama_lengkap")
    @Expose
    private String namaLengkap;
    @SerializedName("gelar_sarjana_depan")
    @Expose
    private String gelarSarjanaDepan;
    @SerializedName("gelar_sarjana_belakang")
    @Expose
    private String gelarSarjanaBelakang;
    @SerializedName("tempat_lahir")
    @Expose
    private String tempatLahir;
    @SerializedName("tanggal_lahir")
    @Expose
    private String tanggalLahir;
    @SerializedName("jenis_kelamin")
    @Expose
    private String jenisKelamin;
    @SerializedName("status_perkawinan")
    @Expose
    private String statusPerkawinan;
    @SerializedName("agama")
    @Expose
    private String agama;
    @SerializedName("alamat_tempat_tinggal")
    @Expose
    private String alamatTempatTinggal;
    @SerializedName("rt_tempat_tinggal")
    @Expose
    private String rtTempatTinggal;
    @SerializedName("rw_tempat_tinggal")
    @Expose
    private String rwTempatTinggal;
    @SerializedName("desa_kelurahan")
    @Expose
    private String desaKelurahan;
    @SerializedName("kecamatan")
    @Expose
    private String kecamatan;
    @SerializedName("kabupaten_kota")
    @Expose
    private String kabupatenKota;
    @SerializedName("provinsi")
    @Expose
    private String provinsi;
    @SerializedName("kode_pos")
    @Expose
    private Object kodePos;
    @SerializedName("no_telepon_1")
    @Expose
    private String noTelepon1;
    @SerializedName("no_telepon_2")
    @Expose
    private Object noTelepon2;
    @SerializedName("golongan_darah")
    @Expose
    private String golonganDarah;
    @SerializedName("status_kepegawaian_id")
    @Expose
    private Integer statusKepegawaianId;
    @SerializedName("jenis_kepegawaian_id")
    @Expose
    private Integer jenisKepegawaianId;
    @SerializedName("nomor_karpeg")
    @Expose
    private Object nomorKarpeg;
    @SerializedName("nomor_kartu_askes")
    @Expose
    private Object nomorKartuAskes;
    @SerializedName("nomor_kartu_taspen")
    @Expose
    private Object nomorKartuTaspen;
    @SerializedName("nomor_karis_karsu")
    @Expose
    private Object nomorKarisKarsu;
    @SerializedName("npwp")
    @Expose
    private String npwp;
    @SerializedName("nomor_ktp")
    @Expose
    private String nomorKtp;
    @SerializedName("nota_persetujuan_bkn_nomor_cpns")
    @Expose
    private String notaPersetujuanBknNomorCpns;
    @SerializedName("nota_persetujuan_bkn_tanggal_cpns")
    @Expose
    private String notaPersetujuanBknTanggalCpns;
    @SerializedName("pejabat_yang_menetapkan_cpns")
    @Expose
    private String pejabatYangMenetapkanCpns;
    @SerializedName("sk_cpns_nomor_cpns")
    @Expose
    private String skCpnsNomorCpns;
    @SerializedName("sk_cpns_tanggal_cpns")
    @Expose
    private String skCpnsTanggalCpns;
    @SerializedName("kode_pangkat_cpns")
    @Expose
    private Integer kodePangkatCpns;
    @SerializedName("tmt_cpns")
    @Expose
    private String tmtCpns;
    @SerializedName("masa_kerja_tahun_cpns")
    @Expose
    private Object masaKerjaTahunCpns;
    @SerializedName("masa_kerja_bulan_cpns")
    @Expose
    private Object masaKerjaBulanCpns;
    @SerializedName("pejabat_yang_menetapkan_pns")
    @Expose
    private String pejabatYangMenetapkanPns;
    @SerializedName("sk_nomor_pns")
    @Expose
    private String skNomorPns;
    @SerializedName("sk_tanggal_pns")
    @Expose
    private String skTanggalPns;
    @SerializedName("kode_pangkat_pns")
    @Expose
    private String kodePangkatPns;
    @SerializedName("tmt_pns")
    @Expose
    private String tmtPns;
    @SerializedName("sumpah_janji_pns")
    @Expose
    private String sumpahJanjiPns;
    @SerializedName("masa_kerja_tahun_pns")
    @Expose
    private String masaKerjaTahunPns;
    @SerializedName("masa_kerja_bulan_pns")
    @Expose
    private String masaKerjaBulanPns;
    @SerializedName("tinggi_keterangan_badan")
    @Expose
    private Integer tinggiKeteranganBadan;
    @SerializedName("berat_badan_keterangan_badan")
    @Expose
    private Integer beratBadanKeteranganBadan;
    @SerializedName("rambut_keterangan_badan")
    @Expose
    private String rambutKeteranganBadan;
    @SerializedName("bentuk_muka_keterangan_badan")
    @Expose
    private String bentukMukaKeteranganBadan;
    @SerializedName("warna_kulit_keterangan_badan")
    @Expose
    private String warnaKulitKeteranganBadan;
    @SerializedName("ciri_ciri_khas_keterangan_badan")
    @Expose
    private String ciriCiriKhasKeteranganBadan;
    @SerializedName("cacat_tubuh_keterangan_badan")
    @Expose
    private String cacatTubuhKeteranganBadan;
    @SerializedName("kegemaran_1")
    @Expose
    private String kegemaran1;
    @SerializedName("kegemaran_2")
    @Expose
    private Object kegemaran2;
    @SerializedName("kegemaran_3")
    @Expose
    private Object kegemaran3;
    @SerializedName("photo")
    @Expose
    private Object photo;
    @SerializedName("status_aktif_pegawai")
    @Expose
    private Integer statusAktifPegawai;
    @SerializedName("kode_kategori_pegawai")
    @Expose
    private String kodeKategoriPegawai;
    @SerializedName("kode_jenis_kepegawaian_rl4")
    @Expose
    private String kodeJenisKepegawaianRl4;
    @SerializedName("masa_kerja_honorer")
    @Expose
    private Integer masaKerjaHonorer;
    @SerializedName("tipe_user")
    @Expose
    private Integer tipeUser;

    public Integer getPegawaiId() {
        return pegawaiId;
    }

    public void setPegawaiId(Integer pegawaiId) {
        this.pegawaiId = pegawaiId;
    }

    public String getIdNipNrp() {
        return idNipNrp;
    }

    public void setIdNipNrp(String idNipNrp) {
        this.idNipNrp = idNipNrp;
    }

    public String getNamaLengkap() {
        return namaLengkap;
    }

    public void setNamaLengkap(String namaLengkap) {
        this.namaLengkap = namaLengkap;
    }

    public String getGelarSarjanaDepan() {
        return gelarSarjanaDepan;
    }

    public void setGelarSarjanaDepan(String gelarSarjanaDepan) {
        this.gelarSarjanaDepan = gelarSarjanaDepan;
    }

    public String getGelarSarjanaBelakang() {
        return gelarSarjanaBelakang;
    }

    public void setGelarSarjanaBelakang(String gelarSarjanaBelakang) {
        this.gelarSarjanaBelakang = gelarSarjanaBelakang;
    }

    public String getTempatLahir() {
        return tempatLahir;
    }

    public void setTempatLahir(String tempatLahir) {
        this.tempatLahir = tempatLahir;
    }

    public String getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(String tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getStatusPerkawinan() {
        return statusPerkawinan;
    }

    public void setStatusPerkawinan(String statusPerkawinan) {
        this.statusPerkawinan = statusPerkawinan;
    }

    public String getAgama() {
        return agama;
    }

    public void setAgama(String agama) {
        this.agama = agama;
    }

    public String getAlamatTempatTinggal() {
        return alamatTempatTinggal;
    }

    public void setAlamatTempatTinggal(String alamatTempatTinggal) {
        this.alamatTempatTinggal = alamatTempatTinggal;
    }

    public String getRtTempatTinggal() {
        return rtTempatTinggal;
    }

    public void setRtTempatTinggal(String rtTempatTinggal) {
        this.rtTempatTinggal = rtTempatTinggal;
    }

    public String getRwTempatTinggal() {
        return rwTempatTinggal;
    }

    public void setRwTempatTinggal(String rwTempatTinggal) {
        this.rwTempatTinggal = rwTempatTinggal;
    }

    public String getDesaKelurahan() {
        return desaKelurahan;
    }

    public void setDesaKelurahan(String desaKelurahan) {
        this.desaKelurahan = desaKelurahan;
    }

    public String getKecamatan() {
        return kecamatan;
    }

    public void setKecamatan(String kecamatan) {
        this.kecamatan = kecamatan;
    }

    public String getKabupatenKota() {
        return kabupatenKota;
    }

    public void setKabupatenKota(String kabupatenKota) {
        this.kabupatenKota = kabupatenKota;
    }

    public String getProvinsi() {
        return provinsi;
    }

    public void setProvinsi(String provinsi) {
        this.provinsi = provinsi;
    }

    public Object getKodePos() {
        return kodePos;
    }

    public void setKodePos(Object kodePos) {
        this.kodePos = kodePos;
    }

    public String getNoTelepon1() {
        return noTelepon1;
    }

    public void setNoTelepon1(String noTelepon1) {
        this.noTelepon1 = noTelepon1;
    }

    public Object getNoTelepon2() {
        return noTelepon2;
    }

    public void setNoTelepon2(Object noTelepon2) {
        this.noTelepon2 = noTelepon2;
    }

    public String getGolonganDarah() {
        return golonganDarah;
    }

    public void setGolonganDarah(String golonganDarah) {
        this.golonganDarah = golonganDarah;
    }

    public Integer getStatusKepegawaianId() {
        return statusKepegawaianId;
    }

    public void setStatusKepegawaianId(Integer statusKepegawaianId) {
        this.statusKepegawaianId = statusKepegawaianId;
    }

    public Integer getJenisKepegawaianId() {
        return jenisKepegawaianId;
    }

    public void setJenisKepegawaianId(Integer jenisKepegawaianId) {
        this.jenisKepegawaianId = jenisKepegawaianId;
    }

    public Object getNomorKarpeg() {
        return nomorKarpeg;
    }

    public void setNomorKarpeg(Object nomorKarpeg) {
        this.nomorKarpeg = nomorKarpeg;
    }

    public Object getNomorKartuAskes() {
        return nomorKartuAskes;
    }

    public void setNomorKartuAskes(Object nomorKartuAskes) {
        this.nomorKartuAskes = nomorKartuAskes;
    }

    public Object getNomorKartuTaspen() {
        return nomorKartuTaspen;
    }

    public void setNomorKartuTaspen(Object nomorKartuTaspen) {
        this.nomorKartuTaspen = nomorKartuTaspen;
    }

    public Object getNomorKarisKarsu() {
        return nomorKarisKarsu;
    }

    public void setNomorKarisKarsu(Object nomorKarisKarsu) {
        this.nomorKarisKarsu = nomorKarisKarsu;
    }

    public String getNpwp() {
        return npwp;
    }

    public void setNpwp(String npwp) {
        this.npwp = npwp;
    }

    public String getNomorKtp() {
        return nomorKtp;
    }

    public void setNomorKtp(String nomorKtp) {
        this.nomorKtp = nomorKtp;
    }

    public String getNotaPersetujuanBknNomorCpns() {
        return notaPersetujuanBknNomorCpns;
    }

    public void setNotaPersetujuanBknNomorCpns(String notaPersetujuanBknNomorCpns) {
        this.notaPersetujuanBknNomorCpns = notaPersetujuanBknNomorCpns;
    }

    public String getNotaPersetujuanBknTanggalCpns() {
        return notaPersetujuanBknTanggalCpns;
    }

    public void setNotaPersetujuanBknTanggalCpns(String notaPersetujuanBknTanggalCpns) {
        this.notaPersetujuanBknTanggalCpns = notaPersetujuanBknTanggalCpns;
    }

    public String getPejabatYangMenetapkanCpns() {
        return pejabatYangMenetapkanCpns;
    }

    public void setPejabatYangMenetapkanCpns(String pejabatYangMenetapkanCpns) {
        this.pejabatYangMenetapkanCpns = pejabatYangMenetapkanCpns;
    }

    public String getSkCpnsNomorCpns() {
        return skCpnsNomorCpns;
    }

    public void setSkCpnsNomorCpns(String skCpnsNomorCpns) {
        this.skCpnsNomorCpns = skCpnsNomorCpns;
    }

    public String getSkCpnsTanggalCpns() {
        return skCpnsTanggalCpns;
    }

    public void setSkCpnsTanggalCpns(String skCpnsTanggalCpns) {
        this.skCpnsTanggalCpns = skCpnsTanggalCpns;
    }

    public Integer getKodePangkatCpns() {
        return kodePangkatCpns;
    }

    public void setKodePangkatCpns(Integer kodePangkatCpns) {
        this.kodePangkatCpns = kodePangkatCpns;
    }

    public String getTmtCpns() {
        return tmtCpns;
    }

    public void setTmtCpns(String tmtCpns) {
        this.tmtCpns = tmtCpns;
    }

    public Object getMasaKerjaTahunCpns() {
        return masaKerjaTahunCpns;
    }

    public void setMasaKerjaTahunCpns(Object masaKerjaTahunCpns) {
        this.masaKerjaTahunCpns = masaKerjaTahunCpns;
    }

    public Object getMasaKerjaBulanCpns() {
        return masaKerjaBulanCpns;
    }

    public void setMasaKerjaBulanCpns(Object masaKerjaBulanCpns) {
        this.masaKerjaBulanCpns = masaKerjaBulanCpns;
    }

    public String getPejabatYangMenetapkanPns() {
        return pejabatYangMenetapkanPns;
    }

    public void setPejabatYangMenetapkanPns(String pejabatYangMenetapkanPns) {
        this.pejabatYangMenetapkanPns = pejabatYangMenetapkanPns;
    }

    public String getSkNomorPns() {
        return skNomorPns;
    }

    public void setSkNomorPns(String skNomorPns) {
        this.skNomorPns = skNomorPns;
    }

    public String getSkTanggalPns() {
        return skTanggalPns;
    }

    public void setSkTanggalPns(String skTanggalPns) {
        this.skTanggalPns = skTanggalPns;
    }

    public String getKodePangkatPns() {
        return kodePangkatPns;
    }

    public void setKodePangkatPns(String kodePangkatPns) {
        this.kodePangkatPns = kodePangkatPns;
    }

    public String getTmtPns() {
        return tmtPns;
    }

    public void setTmtPns(String tmtPns) {
        this.tmtPns = tmtPns;
    }

    public String getSumpahJanjiPns() {
        return sumpahJanjiPns;
    }

    public void setSumpahJanjiPns(String sumpahJanjiPns) {
        this.sumpahJanjiPns = sumpahJanjiPns;
    }

    public String getMasaKerjaTahunPns() {
        return masaKerjaTahunPns;
    }

    public void setMasaKerjaTahunPns(String masaKerjaTahunPns) {
        this.masaKerjaTahunPns = masaKerjaTahunPns;
    }

    public String getMasaKerjaBulanPns() {
        return masaKerjaBulanPns;
    }

    public void setMasaKerjaBulanPns(String masaKerjaBulanPns) {
        this.masaKerjaBulanPns = masaKerjaBulanPns;
    }

    public Integer getTinggiKeteranganBadan() {
        return tinggiKeteranganBadan;
    }

    public void setTinggiKeteranganBadan(Integer tinggiKeteranganBadan) {
        this.tinggiKeteranganBadan = tinggiKeteranganBadan;
    }

    public Integer getBeratBadanKeteranganBadan() {
        return beratBadanKeteranganBadan;
    }

    public void setBeratBadanKeteranganBadan(Integer beratBadanKeteranganBadan) {
        this.beratBadanKeteranganBadan = beratBadanKeteranganBadan;
    }

    public String getRambutKeteranganBadan() {
        return rambutKeteranganBadan;
    }

    public void setRambutKeteranganBadan(String rambutKeteranganBadan) {
        this.rambutKeteranganBadan = rambutKeteranganBadan;
    }

    public String getBentukMukaKeteranganBadan() {
        return bentukMukaKeteranganBadan;
    }

    public void setBentukMukaKeteranganBadan(String bentukMukaKeteranganBadan) {
        this.bentukMukaKeteranganBadan = bentukMukaKeteranganBadan;
    }

    public String getWarnaKulitKeteranganBadan() {
        return warnaKulitKeteranganBadan;
    }

    public void setWarnaKulitKeteranganBadan(String warnaKulitKeteranganBadan) {
        this.warnaKulitKeteranganBadan = warnaKulitKeteranganBadan;
    }

    public String getCiriCiriKhasKeteranganBadan() {
        return ciriCiriKhasKeteranganBadan;
    }

    public void setCiriCiriKhasKeteranganBadan(String ciriCiriKhasKeteranganBadan) {
        this.ciriCiriKhasKeteranganBadan = ciriCiriKhasKeteranganBadan;
    }

    public String getCacatTubuhKeteranganBadan() {
        return cacatTubuhKeteranganBadan;
    }

    public void setCacatTubuhKeteranganBadan(String cacatTubuhKeteranganBadan) {
        this.cacatTubuhKeteranganBadan = cacatTubuhKeteranganBadan;
    }

    public String getKegemaran1() {
        return kegemaran1;
    }

    public void setKegemaran1(String kegemaran1) {
        this.kegemaran1 = kegemaran1;
    }

    public Object getKegemaran2() {
        return kegemaran2;
    }

    public void setKegemaran2(Object kegemaran2) {
        this.kegemaran2 = kegemaran2;
    }

    public Object getKegemaran3() {
        return kegemaran3;
    }

    public void setKegemaran3(Object kegemaran3) {
        this.kegemaran3 = kegemaran3;
    }

    public Object getPhoto() {
        return photo;
    }

    public void setPhoto(Object photo) {
        this.photo = photo;
    }

    public Integer getStatusAktifPegawai() {
        return statusAktifPegawai;
    }

    public void setStatusAktifPegawai(Integer statusAktifPegawai) {
        this.statusAktifPegawai = statusAktifPegawai;
    }

    public String getKodeKategoriPegawai() {
        return kodeKategoriPegawai;
    }

    public void setKodeKategoriPegawai(String kodeKategoriPegawai) {
        this.kodeKategoriPegawai = kodeKategoriPegawai;
    }

    public String getKodeJenisKepegawaianRl4() {
        return kodeJenisKepegawaianRl4;
    }

    public void setKodeJenisKepegawaianRl4(String kodeJenisKepegawaianRl4) {
        this.kodeJenisKepegawaianRl4 = kodeJenisKepegawaianRl4;
    }

    public Integer getMasaKerjaHonorer() {
        return masaKerjaHonorer;
    }

    public void setMasaKerjaHonorer(Integer masaKerjaHonorer) {
        this.masaKerjaHonorer = masaKerjaHonorer;
    }

    public Integer getTipeUser() {
        return tipeUser;
    }

    public void setTipeUser(Integer tipeUser) {
        this.tipeUser = tipeUser;
    }

}
