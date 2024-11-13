/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author 84358
 */
public class KhachHang {

    private int id_KH;
    private String ma;
    private String ten;
    private String gioitinh;
    private String sdt;
    private String diachi;

    public Object[] todataRow() {
        return new Object[]{
            id_KH, ma, ten, gioitinh, sdt, diachi
        };
    }

    public KhachHang() {
    }

    public KhachHang(String ma, String ten) {
        this.ma = ma;
        this.ten = ten;
    }

    public KhachHang(String ma, String ten, String gioitinh, String sdt, String diachi) {
        this.ma = ma;
        this.ten = ten;
        this.gioitinh = gioitinh;
        this.sdt = sdt;
        this.diachi = diachi;
    }

    public KhachHang(int id_KH, String ma, String ten, String gioitinh, String sdt, String diachi) {
        this.id_KH = id_KH;
        this.ma = ma;
        this.ten = ten;
        this.gioitinh = gioitinh;
        this.sdt = sdt;
        this.diachi = diachi;
    }

    public int getId_KH() {
        return id_KH;
    }

    public void setId_KH(int id_KH) {
        this.id_KH = id_KH;
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

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    @Override
    public String toString() {
        return "KhachHang{" + "id_KH=" + id_KH + ", ma=" + ma + ", ten=" + ten + ", gioitinh=" + gioitinh + ", sdt=" + sdt + ", diachi=" + diachi + '}';
    }

    public Object[] toDataRow() {
        return new Object[]{
            this.getId_KH(), this.getMa(), this.getTen(), this.getGioitinh(), this.getSdt(), this.getDiachi()
        };
    }
}
