/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class SanPham {
    private int idSP, idMS, idCL, idKC, idDM;
    private String maSanPham;
    private String tenSanPham;
    private float giaBan;
    private int soLuong;
    private String size;
    private String mauSac;
    private String chatLieu;
    private String danhMuc;
    private String trangThai;
    
    
    
    public Object[] toDataRow(){
        return new Object[]{
            maSanPham, tenSanPham, giaBan, soLuong,size, mauSac,chatLieu, danhMuc, trangThai 
        };
    }

    // Constructors, Getters và Setters
  
    public Object[] todataRow(){
        return new Object[]{
           maSanPham, tenSanPham, size, mauSac,chatLieu, danhMuc, soLuong, giaBan
        };
    }

    public SanPham() {
    }

    public SanPham(String maSanPham, String tenSanPham, float giaBan, int soLuong, String size, String mauSac, String chatLieu, String danhMuc, String trangThai) {
        this.maSanPham = maSanPham;
        this.tenSanPham = tenSanPham;
        this.giaBan = giaBan;
        this.soLuong = soLuong;
        this.size = size;
        this.mauSac = mauSac;
        this.chatLieu = chatLieu;
        this.danhMuc = danhMuc;
        this.trangThai = trangThai;
    }

    public SanPham(int idSP, String maSanPham, String tenSanPham, float giaBan, int soLuong, String size, String mauSac, String chatLieu, String danhMuc, String trangThai) {
        this.idSP = idSP;
        this.maSanPham = maSanPham;
        this.tenSanPham = tenSanPham;
        this.giaBan = giaBan;
        this.soLuong = soLuong;
        this.size = size;
        this.mauSac = mauSac;
        this.chatLieu = chatLieu;
        this.danhMuc = danhMuc;
        this.trangThai = trangThai;
    }

    public int getIdSP() {
        return idSP;
    }

    public void setIdSP(int idSP) {
        this.idSP = idSP;
    }

    public int getIdMS() {
        return idMS;
    }

    public void setIdMS(int idMS) {
        this.idMS = idMS;
    }

    public int getIdCL() {
        return idCL;
    }

    public void setIdCL(int idCL) {
        this.idCL = idCL;
    }

    public int getIdKC() {
        return idKC;
    }

    public void setIdKC(int idKC) {
        this.idKC = idKC;
    }

    public int getIdDM() {
        return idDM;
    }

    public void setIdDM(int idDM) {
        this.idDM = idDM;
    }

    public String getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(String maSanPham) {
        this.maSanPham = maSanPham;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public float getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(float giaBan) {
        this.giaBan = giaBan;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
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

    public String getDanhMuc() {
        return danhMuc;
    }

    public void setDanhMuc(String danhMuc) {
        this.danhMuc = danhMuc;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
    
    
    @Override
    public String toString() {
        return "SanPham{" + "maSanPham=" + maSanPham + ", tenSanPham=" + tenSanPham + ", giaBan=" + giaBan + ", soLuong=" + soLuong + ", size=" + size + ", mauSac=" + mauSac + ", chatLieu=" + chatLieu + ", danhMuc=" + danhMuc + ", trangThai=" + trangThai + '}';
    }

    
    
    
   
    
}
