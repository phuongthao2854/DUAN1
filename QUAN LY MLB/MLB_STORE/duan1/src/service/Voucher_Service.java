/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.List;
import model.Voucher;
import java.sql.*;
import java.util.ArrayList;
import model.NhanVien;

/**
 *
 * @author Admin
 */
public class Voucher_Service {

    private List<Voucher> listVC;
    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private String sql = null;

    public List<Voucher> getAll() {
        listVC = new ArrayList<>();
        sql = "  select MaVoucher, TenVoucher, NgayBatDau, NgayKetThuc, TiLeGiam,  DonHangToiThieu, GiamToiDa,SoLuong, TrangThai from Voucher ";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Voucher vc = new Voucher();
                vc.setMa(rs.getString("MaVoucher"));
                vc.setTen(rs.getString("TenVoucher"));
                vc.setNgaybd(rs.getDate("NgayBatDau"));
                vc.setNgaykt(rs.getDate("NgayKetThuc"));
                vc.setTlgiam(rs.getFloat("TiLeGiam"));
                vc.setDhtoithieu(rs.getFloat("DonHangToiThieu"));
                vc.setGiamtoida(rs.getFloat("GiamToiDa"));
                vc.setSoluong(rs.getInt("SoLuong"));
                vc.setTrangthai(rs.getString("TrangThai"));
                listVC.add(vc);
            }
            return listVC;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int insertVC(Voucher vc) {
        int kq = 0;
        sql = "INSERT INTO Voucher (MaVoucher, TenVoucher, NgayBatDau, NgayKetThuc, TiLeGiam,  DonHangToiThieu, GiamToiDa, SoLuong, TrangThai) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, vc.getMa());
            ps.setString(2, vc.getTen());
            ps.setDate(3, new java.sql.Date(vc.getNgaybd().getTime()));
            ps.setDate(4, new java.sql.Date(vc.getNgaykt().getTime()));
            ps.setFloat(5, vc.getTlgiam());
            ps.setFloat(6, vc.getDhtoithieu());
            ps.setFloat(7, vc.getGiamtoida());
            ps.setInt(8, vc.getSoluong());
            ps.setString(9, vc.getTrangthai());
            kq = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            kq = 0;
        }
        return kq;
    }

    public boolean isMaVoucher(String ma) {
        con = DBConnect.getConnection();
        sql = " select count(*) from Voucher where MaVoucher like ?";
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

    public int updateVC(Voucher vc) {
        int kq = 0;
        sql = "update Voucher set TenVoucher = ?, NgayBatDau = ?, NgayKetThuc = ?, TiLeGiam = ?,DonHangToiThieu = ?, GiamToiDa = ?,  SoLuong = ?, TrangThai = ? where MaVoucher like ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(9, vc.getMa());
            ps.setString(1, vc.getTen());
            ps.setDate(2, new java.sql.Date(vc.getNgaybd().getTime()));
            ps.setDate(3, new java.sql.Date(vc.getNgaykt().getTime()));
            ps.setFloat(4, vc.getTlgiam());
            ps.setFloat(5, vc.getDhtoithieu());
            ps.setFloat(6, vc.getGiamtoida());
            ps.setInt(7, vc.getSoluong());
            ps.setString(8, vc.getTrangthai());
            kq = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            kq = 0;
        }
        return kq;
    }

    public List<Voucher> locTT(String trangthai) {
        listVC = new ArrayList<>();
        con = DBConnect.getConnection();
        sql = "select MaVoucher, TenVoucher, NgayBatDau, NgayKetThuc, TiLeGiam, SoLuong, DonHangToiThieu, GiamToiDa, TrangThai from Voucher where TrangThai like ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, trangthai);
            rs = ps.executeQuery();
            while (rs.next()) {
                Voucher vc = new Voucher();
                vc.setMa(rs.getString("MaVoucher"));
                vc.setTen(rs.getString("TenVoucher"));
                vc.setNgaybd(rs.getDate("NgayBatDau"));
                vc.setNgaykt(rs.getDate("NgayKetThuc"));
                vc.setTlgiam(rs.getFloat("TiLeGiam"));
                vc.setDhtoithieu(rs.getFloat("DonHangToiThieu"));
                vc.setGiamtoida(rs.getFloat("GiamToiDa"));
                vc.setSoluong(rs.getInt("SoLuong"));
                vc.setTrangthai(rs.getString("TrangThai"));
                listVC.add(vc);
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
        return listVC;
    }

    public ArrayList<Voucher> vcTheoMa(String mavc) {
        ArrayList<Voucher> list = new ArrayList<>();
        String sql = "select *from Voucher where MaVoucher like ?";
        Connection cn = DBConnect.getConnection();
        try {
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setString(1, mavc);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Voucher t = new Voucher();
                t.setMa(rs.getString("MaVoucher"));
                t.setTen(rs.getString("TenVoucher"));
                t.setNgaybd(rs.getDate("NgayBatDau"));
                t.setNgaykt(rs.getDate("NgayKetThuc"));
                t.setSoluong(rs.getInt("SoLuong"));
                t.setTlgiam(rs.getFloat("TiLeGiam"));
                t.setDhtoithieu(rs.getFloat("DonHangToiThieu"));
                t.setGiamtoida(rs.getFloat("GiamToiDa"));
                t.setTrangthai(rs.getString("TrangThai"));
                list.add(t);
            }
        } catch (Exception e) {
            System.out.print(e);
        }
        return list;
    }
    
    public int getIdVCByCode(String mavc) {
        int ID_Voucher = 0;
        con = DBConnect.getConnection();
        sql = "SELECT ID_Voucher FROM Voucher WHERE MaVoucher = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, mavc);
            rs = ps.executeQuery();
            while (rs.next()) {
                ID_Voucher = rs.getInt("ID_Voucher");
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
        return ID_Voucher;
    }

    public Voucher getVoucherByCode(String mavc){
        con = DBConnect.getConnection();
        sql = "select MaVoucher, NgayBatDau, NgayKetThuc, TiLeGiam, SoLuong, DonHangToiThieu, GiamToiDa, TrangThai from Voucher where MaVoucher = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, mavc);
            rs = ps.executeQuery();
            while (rs.next()) {
                 Voucher vc = new Voucher();
                vc.setMa(rs.getString("MaVoucher"));
                vc.setNgaybd(rs.getDate("NgayBatDau"));
                vc.setNgaykt(rs.getDate("NgayKetThuc"));
                vc.setTlgiam(rs.getFloat("TiLeGiam"));
                vc.setDhtoithieu(rs.getFloat("DonHangToiThieu"));
                vc.setGiamtoida(rs.getFloat("GiamToiDa"));
                vc.setSoluong(rs.getInt("SoLuong"));
                vc.setTrangthai(rs.getString("TrangThai"));
                listVC.add(vc);
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
        return null;
    }
    
}
