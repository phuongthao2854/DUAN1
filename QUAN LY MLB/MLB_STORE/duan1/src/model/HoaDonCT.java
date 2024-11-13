/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class HoaDonCT {
    int Id_HDCT, id_HD, id_SP, soLuong;
    String ma_SPCT, maHDCT, tenSP, mauSac, chatLieu, kichCo;
    float giaban,thanhTien;
    
    public HoaDonCT() {
    }

    public HoaDonCT(int id_HD, float giaban, int soLuong, float thanhTien, String tenSP) {
        this.id_HD = id_HD;
        this.giaban = giaban;
        this.soLuong = soLuong;
        this.thanhTien = thanhTien;
        this.tenSP = tenSP;
    }
   
    public HoaDonCT(int id_HD, int id_SP, float giaban, int soLuong, float thanhTien, String tenSP) {
        this.id_HD = id_HD;
        this.id_SP = id_SP;
        this.giaban = giaban;
        this.soLuong = soLuong;
        this.thanhTien = thanhTien;
        this.tenSP = tenSP;
    }

    public HoaDonCT(int Id_HDCT, int id_HD, int id_SP, int soLuong, String ma_SPCT, String maHDCT, String tenSP, float giaban, float thanhTien) {
        this.Id_HDCT = Id_HDCT;
        this.id_HD = id_HD;
        this.id_SP = id_SP;
        this.soLuong = soLuong;
        this.ma_SPCT = ma_SPCT;
        this.maHDCT = maHDCT;
        this.tenSP = tenSP;
        this.giaban = giaban;
        this.thanhTien = thanhTien;
    }

    public HoaDonCT(int Id_HDCT, int id_HD, int id_SP, int soLuong, String ma_SPCT, String maHDCT, String tenSP, String mauSac, String chatLieu, String kichCo, float giaban, float thanhTien) {
        this.Id_HDCT = Id_HDCT;
        this.id_HD = id_HD;
        this.id_SP = id_SP;
        this.soLuong = soLuong;
        this.ma_SPCT = ma_SPCT;
        this.maHDCT = maHDCT;
        this.tenSP = tenSP;
        this.mauSac = mauSac;
        this.chatLieu = chatLieu;
        this.kichCo = kichCo;
        this.giaban = giaban;
        this.thanhTien = thanhTien;
    }

    public int getId_HDCT() {
        return Id_HDCT;
    }

    public void setId_HDCT(int Id_HDCT) {
        this.Id_HDCT = Id_HDCT;
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

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getMa_SPCT() {
        return ma_SPCT;
    }

    public void setMa_SPCT(String ma_SPCT) {
        this.ma_SPCT = ma_SPCT;
    }

    public String getMaHDCT() {
        return maHDCT;
    }

    public void setMaHDCT(String maHDCT) {
        this.maHDCT = maHDCT;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getMauSac() {
        return mauSac;
    }

    public void setMauSac(String mauSac) {
        this.mauSac = mauSac;
    }

    public String getChatLieu() {
        return chatLieu;
    }

    public void setChatLieu(String chatLieu) {
        this.chatLieu = chatLieu;
    }

    public String getKichCo() {
        return kichCo;
    }

    public void setKichCo(String kichCo) {
        this.kichCo = kichCo;
    }

    public float getGiaban() {
        return giaban;
    }

    public void setGiaban(float giaban) {
        this.giaban = giaban;
    }

    public float getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(float thanhTien) {
        this.thanhTien = thanhTien;
    }

    
   
}
