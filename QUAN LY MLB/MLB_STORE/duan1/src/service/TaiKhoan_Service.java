/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.sql.*;
import javax.management.Notification;
import view.Main_QuanLy;

/**
 *
 * @author Admin
 */
public class TaiKhoan_Service {

    public static String maNV, tenNV;// trả về mã và tên 

    public static String layThongTin_maNV() {
        return maNV;
    }

    public static String layThongTin_tenNV() {
        return tenNV;
    }

    public boolean dangnhap(String taikhoan, String matkhau) {
        String sql = "select TaiKhoan, MatKhau, VaiTro, MaNhanVien, TenNhanVien from NhanVien Where TaiKhoan = ?, and MatKhau = ? and TrangThai = N'Đang làm việc'";
        try {
            Connection con = DBConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, taikhoan);
            ps.setString(2, matkhau);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String vaitro = rs.getString("VaiTro").trim();
                maNV = rs.getString("MaNhanVien").trim();
                tenNV = rs.getString("TenNhanVien").trim();
                if (vaitro.equals("Quản lý")) {
                    Main_QuanLy mql = new Main_QuanLy();
                    mql.setVisible(true);
                    mql.setLocationRelativeTo(null);
                }
            }
        } catch (Exception e) {
        }
        return false;
    }
}
