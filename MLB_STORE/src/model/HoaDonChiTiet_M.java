package model;

public class HoaDonChiTiet_M {

    private int id_HDCT;
    private int id_HD;
    private int id_SP;

    private Float giaBan;
    private int soLuongMua;
    private Float thanhTien;

    //Dif
    private String maSP;
    private String tenSP;

    public HoaDonChiTiet_M() {
    }

    public HoaDonChiTiet_M(int id_HDCT, int id_HD, int id_SP, Float giaBan, int soLuongMua, Float thanhTien) {
        this.id_HDCT = id_HDCT;
        this.id_HD = id_HD;
        this.id_SP = id_SP;
        this.giaBan = giaBan;
        this.soLuongMua = soLuongMua;
        this.thanhTien = thanhTien;
    }

    public int getId_HDCT() {
        return id_HDCT;
    }

    public void setId_HDCT(int id_HDCT) {
        this.id_HDCT = id_HDCT;
    }

    public int getId_HD() {
        return id_HD;
    }

    public void setId_HD(int id_HD) {
        this.id_HD = id_HD;
    }

    public int getId_SP() {
        return id_SP;
    }

    public void setId_SP(int id_SP) {
        this.id_SP = id_SP;
    }

    public Float getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(Float giaBan) {
        this.giaBan = giaBan;
    }

    public int getSoLuongMua() {
        return soLuongMua;
    }

    public void setSoLuongMua(int soLuongMua) {
        this.soLuongMua = soLuongMua;
    }

    public Float getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(Float thanhTien) {
        this.thanhTien = thanhTien;
    }

    //Getter-Setter Dif
    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

}
