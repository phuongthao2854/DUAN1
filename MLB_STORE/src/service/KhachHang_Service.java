/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.KhachHang;

/**
 *
 * @author 84358
 */
public class KhachHang_Service {

    private List<KhachHang> listKH;
    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private String sql = null;

    public List<KhachHang> getAll() {
        listKH = new ArrayList<>();
        sql = "select ID_KhachHang, MaKhachHang, TenKhachHang,  GioiTinh, SDT, DiaChi from KhachHang";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                KhachHang kh = new KhachHang(
                        rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6)
                );
                listKH.add(kh);
            }
            return listKH;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int insertKH(KhachHang kh) { //Thêm
        int kq = 0;
        sql = "insert into KhachHang(MaKhachHang, TenKhachHang, GioiTinh, SDT, DiaChi) values (?,?,?,?,?)";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, kh.getMa());
            ps.setString(2, kh.getTen());
            ps.setString(3, kh.getGioitinh());
            ps.setString(4, kh.getSdt());
            ps.setString(5, kh.getDiachi());
            kq = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            kq = 0;
        }
        return kq;
    }

    public int updateKH(KhachHang kh) {
        sql = "update KhachHang set TenKhachHang = ?, GioiTinh = ?, SDT = ?, DiaChi = ? where MaKhachHang like  ?";
        int kq = 0;
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql); // thực thi câu lệnh trong sql 
            ps.setString(1, kh.getTen());
            ps.setString(2, kh.getGioitinh());
            ps.setString(3, kh.getSdt());
            ps.setString(4, kh.getDiachi());
            ps.setString(5, kh.getMa());
            kq = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            kq = 0;
        }
        return kq;
    }

    public boolean isMaKhachHang(String ma) {
        con = DBConnect.getConnection();
        sql = " select count(*) from KhachHang where MaKhachHang like ?";
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

    public KhachHang timKhachHangTheoSDT(String sdt) {
        this.con = DBConnect.getConnection();
        String sql = "SELECT MaKhachHang, TenKhachHang, GioiTinh, SDT, DiaChi FROM KhachHang WHERE SDT = ?";
        try (PreparedStatement statement = con.prepareStatement(sql)) {
            statement.setString(1, sdt);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String maKhachHang = resultSet.getString("MaKhachHang");
                String tenKhachHang = resultSet.getString("TenKhachHang");
                String gioiTinh = resultSet.getString("GioiTinh");
                String diaChi = resultSet.getString("DiaChi");

                return new KhachHang(maKhachHang, tenKhachHang, gioiTinh, sdt, diaChi);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public int getIdKhachHang(String sdt) {
        this.con = DBConnect.getConnection();
        int ID_KhachHang = 0;
        String sql = "SELECT ID_KhachHang FROM KhachHang WHERE SDT = ?";
        try (PreparedStatement statement = con.prepareStatement(sql)) {
            statement.setString(1, sdt);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                ID_KhachHang = resultSet.getInt("ID_KhachHang");

                return ID_KhachHang;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ID_KhachHang;
    }

}
