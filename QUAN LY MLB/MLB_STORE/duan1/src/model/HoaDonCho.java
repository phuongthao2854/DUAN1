/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;

/**
 *
 * @author Admin
 */
public class HoaDonCho {
    private int id_NV;
    private int id_KH;
    private String MaNV;
    private String maHDC;
    private String tenNV;
    private Date ngaytao;
    private String tenKH;
    private String  trangthai;

    public Object[] toDataRow(){
        return new Object[]{
            maHDC, tenNV,  tenKH, ngaytao, trangthai
        };
    }
    public HoaDonCho() {
    }

    public HoaDonCho(String MaNV, String maHDC) {
        this.MaNV = MaNV;
        this.maHDC = maHDC;
    }

    public HoaDonCho(String maHDC, String tenNV, Date ngaytao, String tenKH, String trangthai) {
        this.maHDC = maHDC;
        this.tenNV = tenNV;
        this.ngaytao = ngaytao;
        this.tenKH = tenKH;
        this.trangthai = trangthai;
    }

    public HoaDonCho(String maHDC, String tenNV, Date ngaytao, String trangthai) {
        this.maHDC = maHDC;
        this.tenNV = tenNV;
        this.ngaytao = ngaytao;
        this.trangthai = trangthai;
    }

   
    public HoaDonCho(int id_NV, int id_KH, String MaNV, String maHDC, String tenNV, Date ngaytao, String tenKH, String trangthai) {
        this.id_NV = id_NV;
        this.id_KH = id_KH;
        this.MaNV = MaNV;
        this.maHDC = maHDC;
        this.tenNV = tenNV;
        this.ngaytao = ngaytao;
        this.tenKH = tenKH;
        this.trangthai = trangthai;
    }

    public int getId_NV() {
        return id_NV;
    }

    public void setId_NV(int id_NV) {
        this.id_NV = id_NV;
    }

    public int getId_KH() {
        return id_KH;
    }

    public void setId_KH(int id_KH) {
        this.id_KH = id_KH;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getMaHDC() {
        return maHDC;
    }

    public void setMaHDC(String maHDC) {
        this.maHDC = maHDC;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public Date getNgaytao() {
        return ngaytao;
    }

    public void setNgaytao(Date ngaytao) {
        this.ngaytao = ngaytao;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }

   
    

    
    
    
    
}
