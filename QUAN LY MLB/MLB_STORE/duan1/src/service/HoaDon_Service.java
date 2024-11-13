/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.HoaDon;

/**
 *
 * @author Admin
 */
public class HoaDon_Service {

    private List<HoaDon> listHD;
    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private String sql = null;

    public List<HoaDon> getHoaDonAll() {
        listHD = new ArrayList<>();
        sql = "select hd.ID_Hoadon, hd.MaHD, nv.TenNhanVien, kh.TenKhachHang, vc.GiamToiDa, hd.NgayTao, hd.TongTien, hd.TrangThai from HoaDon hd\n"
                + "join NhanVien nv on hd.ID_NhanVien = nv.ID_Nhanvien\n"
                + "JOIN KhachHang kh ON hd.ID_KhachHang = kh.ID_KhachHang\n"
                + "JOIN Voucher vc ON hd.ID_Voucher = vc.ID_Voucher";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                HoaDon hd = new HoaDon();
                hd.setIdHD(rs.getInt("ID_HoaDon"));
                hd.setMaHD(rs.getString("MaHD"));
                hd.setNgayTao(rs.getDate("NgayTao"));
                hd.setTenNV(rs.getString("TenNhanVien"));
                hd.setTenKH(rs.getString("TenKhachHang"));
                hd.setSoTienGiam(rs.getFloat("GiamToiDa"));
                hd.setTongTien(rs.getFloat("TongTien"));
                hd.setTrangThai(rs.getString("TrangThai"));
                listHD.add(hd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listHD;
    }

   
    public HoaDon getRowHD(int row) {
        return listHD.get(row);

    }

    public int insertHD(HoaDon hdc) {
        int kq = 0;
        sql = "INSERT INTO HoaDon (MaHD, ID_Nhanvien, ID_KhachHang, NgayTao, TrangThai) VALUES (?,?,?,getDate(),N'Chưa thanh toán')";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, hdc.getMaHD());
            ps.setInt(2, hdc.getIdNV());
            ps.setInt(3, hdc.getIdKH());

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

    public int getHDIDByMaHD(String MaHD) {
        con = DBConnect.getConnection();
        sql = "SELECT ID_Hoadon FROM HoaDon WHERE MaHD = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, MaHD);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt("ID_Hoadon");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    public int xoaHoaDon(String maHD) {
        int kq = 0;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            // Kết nối cơ sở dữ liệu
            connection = DBConnect.getConnection();
            if (connection != null) {
                // Câu lệnh SQL để xóa hóa đơn
                String query = "DELETE FROM HoaDon WHERE MaHD = ?";
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, maHD);

                // Thực thi truy vấn
                kq = preparedStatement.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
            kq = 0;
        } finally {
            // Đóng kết nối và các đối tượng
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return kq;
    }

}
