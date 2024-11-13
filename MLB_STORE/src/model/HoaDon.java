package model;

import java.sql.Date;

/**
 *
 * @author Admin
 */
public class HoaDon {

    int idHD, idNV, idKH, idVC;
    String maHD, tenNV, tenKH, maNV, maKH, trangThai, ghiChu;
    float soTienGiam, tongTien;
    Date ngayTao;

    public HoaDon() {
    }

    public HoaDon(int idHD, int idNV, int idKH, int idVC, String maHD, String tenNV, String tenKH, String maNV, String maKH, String trangThai, String ghiChu, float soTienGiam, float tongTien, Date ngayTao) {
        this.idHD = idHD;
        this.idNV = idNV;
        this.idKH = idKH;
        this.idVC = idVC;
        this.maHD = maHD;
        this.tenNV = tenNV;
        this.tenKH = tenKH;
        this.maNV = maNV;
        this.maKH = maKH;
        this.trangThai = trangThai;
        this.ghiChu = ghiChu;
        this.soTienGiam = soTienGiam;
        this.tongTien = tongTien;
        this.ngayTao = ngayTao;
    }

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

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
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

    public float getSoTienGiam() {
        return soTienGiam;
    }

    public void setSoTienGiam(float soTienGiam) {
        this.soTienGiam = soTienGiam;
    }

    public float getTongTien() {
        return tongTien;
    }

    public void setTongTien(float tongTien) {
        this.tongTien = tongTien;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

}
