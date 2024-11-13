package model;

import java.sql.Date;

public class HoaDon_M {

    //PK + FK :
    private int idHD;
    private int idNV;
    private int idKH;
    private int idVC;

    //    
    private String maHD;
    private Date ngayTao;
    private Float tongTien;
    private String trangThai;
    private String ghiChu;

    //Diff1
    private String tenNV;
    private String tenKH;
    private String maKH;

    //Diff1
    private String maNV;
    private String maVC;

    public HoaDon_M() {
    }

    public HoaDon_M(int idHD, int idNV, int idKH, int idVC, String maHD, Date ngayTao, Float tongTien, String trangThai, String ghiChu, String tenNV, String tenKH) {
        this.idHD = idHD;
        this.idNV = idNV;
        this.idKH = idKH;
        this.idVC = idVC;
        this.maHD = maHD;
        this.ngayTao = ngayTao;
        this.tongTien = tongTien;
        this.trangThai = trangThai;
        this.ghiChu = ghiChu;
        this.tenNV = tenNV;
        this.tenKH = tenKH;
    }

//    Getter +Setter
    public int getIdHD() {
        return idHD;
    }

    public void setIdHD(int idHD) {
        this.idHD = idHD;
    }

    public int getIdNV() {
        return idNV;
    }

    public void setIdNV(int idNV) {
        this.idNV = idNV;
    }

    public int getIdKH() {
        return idKH;
    }

    public void setIdKH(int idKH) {
        this.idKH = idKH;
    }

    public int getIdVC() {
        return idVC;
    }

    public void setIdVC(int idVC) {
        this.idVC = idVC;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Float getTongTien() {
        return tongTien;
    }

    public void setTongTien(Float tongTien) {
        this.tongTien = tongTien;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    //Getter + Setter : Diff
    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getMaVC() {
        return maVC;
    }

    public void setMaVC(String maVC) {
        this.maVC = maVC;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

}
