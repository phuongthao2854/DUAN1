/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.sql.*;
import model.Logine;

/**
 *
 * @author Admin
 */
public class Login_Service {

    public static String maNV, tenNV;// trả về mã và tên 

    public static int getIdNV() {//Mạnh :v
        return lg.getId_NV();
    }

    public static String layThongTin_maNV() {
        return maNV;
    }

    public static String layThongTin_tenNV() {
        return tenNV;
    }

    public Logine selectById(String tk, String mk) {
        String sql = "SELECT * FROM NhanVien WHERE TaiKhoan LIKE ? and MatKhau like ?";
//        System.out.println(sql);
        try {
            Connection con = DBConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, tk);
            ps.setString(2, mk);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    maNV = rs.getString("MaNhanVien").trim();
                    tenNV = rs.getString("TenNhanVien").trim();
                    Logine login = new Logine();
                    login.setId_NV(rs.getInt("ID_Nhanvien"));
                    login.setMaNV(rs.getString("MaNhanVien"));
                    login.setTenNV(rs.getString("TenNhanVien"));
                    login.setGioiTinh(rs.getString("GioiTinh"));
                    login.setNgaySinh(rs.getString("NgaySinh"));
                    login.setDiaChi(rs.getString("DiaChi"));
                    login.setEmail(rs.getString("Email"));
                    login.setTaiKhoan(rs.getString("TaiKhoan"));
                    login.setMatKhau(rs.getString("MatKhau"));
                    login.setVaiTro(rs.getString("VaiTro"));
                    login.setTrangThai(rs.getString("TrangThai"));
                    return login;
                } else {
                    return null;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public static Logine lg = null;

}
