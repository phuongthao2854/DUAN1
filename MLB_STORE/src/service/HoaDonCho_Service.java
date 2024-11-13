/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.HoaDon;
import model.HoaDonCho;

/**
 *
 * @author Admin
 */
public class HoaDonCho_Service {

    private List<HoaDonCho> listHDC;
    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private String sql = null;

    public List<HoaDonCho> getAll() {
        listHDC = new ArrayList<>();
        sql = "select hd.MaHD, nv.TenNhanVien, hd.NgayTao, hd.TrangThai from HoaDon hd\n"
                + "join NhanVien nv on hd.ID_Nhanvien = nv.ID_Nhanvien";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                HoaDonCho hdc = new HoaDonCho();
                hdc.setMaHDC(rs.getString(1));
                hdc.setTenNV(rs.getString(2));
                hdc.setNgaytao(rs.getDate(3));
                hdc.setTrangthai(rs.getString(4));
                listHDC.add(hdc);
            }
            return listHDC;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public int insertHDC(HoaDonCho hdc) {
        int kq = 0;
        sql = "insert into HoaDon (MaHD, ID_NhanVien,ID_KhachHang, NgayTao, TrangThai) values (?,?,?,getDate(),N'Chưa thanh toán')";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, hdc.getMaHDC());
            ps.setInt(2, hdc.getId_KH());
            ps.setInt(3, hdc.getId_KH());
           
            
            kq = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            kq = 0;
        }
        return kq;
    }

    public boolean isMaHD(String ma) {
        con = DBConnect.getConnection();
        sql = " select count(*) from HoaDon where MaHD like ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, ma);
            rs = ps.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
