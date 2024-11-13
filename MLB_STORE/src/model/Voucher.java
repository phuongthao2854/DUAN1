/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class Voucher {
    //--------------------------Mạnh
    private int IDVoucher;

    public int getIDVoucher() {
        return IDVoucher;
    }

    public void setIDVoucher(int IDVoucher) {
        this.IDVoucher = IDVoucher;
    }
    //--------------------------Mạnh
    private String ma;
    private String ten;
    private Date ngaybd;
    private Date ngaykt;
    private float tlgiam;
    private int soluong;
    private float dhtoithieu;
    private float giamtoida;
    private String trangthai;

    public Object[] toDataRow() {
        return new Object[]{
            ma, ten, ngaybd, ngaykt, tlgiam, dhtoithieu, giamtoida, soluong, trangthai
        };
    }

    public Voucher() {
    }

    public Voucher(String ma, String ten, Date ngaybd, Date ngaykt, float tlgiam, int soluong, float dhtoithieu, float giamtoida, String trangthai) {
        this.ma = ma;
        this.ten = ten;
        this.ngaybd = ngaybd;
        this.ngaykt = ngaykt;
        this.tlgiam = tlgiam;
        this.soluong = soluong;
        this.dhtoithieu = dhtoithieu;
        this.giamtoida = giamtoida;
        this.trangthai = trangthai;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public Date getNgaybd() {
        return ngaybd;
    }

    public void setNgaybd(Date ngaybd) {
        this.ngaybd = ngaybd;
    }

    public Date getNgaykt() {
        return ngaykt;
    }

    public void setNgaykt(Date ngaykt) {
        this.ngaykt = ngaykt;
    }

    public float getTlgiam() {
        return tlgiam;
    }

    public void setTlgiam(float tlgiam) {
        this.tlgiam = tlgiam;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public float getDhtoithieu() {
        return dhtoithieu;
    }

    public void setDhtoithieu(float dhtoithieu) {
        this.dhtoithieu = dhtoithieu;
    }

    public float getGiamtoida() {
        return giamtoida;
    }

    public void setGiamtoida(float giamtoida) {
        this.giamtoida = giamtoida;
    }

    public String getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }

    @Override
    public String toString() {//Mạnh :v
        return "Voucher" + "= " + ma + " : " + ten;
    }

}
