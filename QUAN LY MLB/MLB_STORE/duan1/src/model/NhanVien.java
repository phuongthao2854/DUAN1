/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Arrays;

/**
 *
 * @author Admin
 */
public class NhanVien {
  
    private String ma;
    private String ten;
    private String gioiTinh;
    private String ngaySinh;
    private String diaChi;
    private String email;
    private String sdt;
    private String taiKhoan;
    private String matKhau;
    private String vaiTro;
    private String trangThai;

    public NhanVien() {
    }

    public NhanVien(String ma, String ten, String gioiTinh, String ngaySinh, String diaChi, String email, String sdt, String taiKhoan, String matKhau, String vaiTro, String trangThai) {
        this.ma = ma;
        this.ten = ten;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.email = email;
        this.sdt = sdt;
        this.taiKhoan = taiKhoan;
        this.matKhau = matKhau;
        this.vaiTro = vaiTro;
        this.trangThai = trangThai;
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

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(String taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getVaiTro() {
        return vaiTro;
    }

    public void setVaiTro(String vaiTro) {
        this.vaiTro = vaiTro;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "NhanVien{  ma=" + ma + ", ten=" + ten + ", gioiTinh=" + gioiTinh + ", ngaySinh=" + ngaySinh + ", diaChi=" + diaChi + ", email=" + email + ", sdt=" + sdt + ", taiKhoan=" + taiKhoan + ", matKhau=" + matKhau + ", vaiTro=" + vaiTro + ", trangThai=" + trangThai + '}';
    }

    public Object[] todataRow() {
        return new Object[]{
            this.getMa(), this.getTen(), this.getGioiTinh(), this.getNgaySinh(),
            this.getDiaChi(), this.getEmail(), this.getSdt(), this.getTaiKhoan(), this.getMatKhau(),
            this.getVaiTro(), this.getTrangThai()
        };
    }

    public Object[] toDataRow() {
        Object[] dataRow = Arrays.copyOf(new Object[]{ this.getMa(), this.getTen(), this.getGioiTinh(), this.getNgaySinh(),
            this.getDiaChi(), this.getEmail(), this.getSdt(), this.getTaiKhoan(), this.getMatKhau(),
            this.getVaiTro(), this.getTrangThai()}, 11);
        dataRow[4] = encryptMatKhau(this.matKhau);
        return dataRow;
    }

    private String encryptMatKhau(String matKhau) {

        return "********";
    }
}
