/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import com.raven.event.Method_SanPham;
import com.sun.jdi.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import jdk.internal.org.jline.terminal.Size;
import model.NhanVien;
import model.SanPham;
import java.sql.*;
import javax.swing.text.html.parser.Entity;

/**
 *
 * @author Admin
 */
public class SanPham_Service {

    private List<SanPham> listSP;
    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private String sql = null;

    public List<SanPham> getAll() {
        listSP = new ArrayList<>();
        sql = "SELECT sp.MaSanPham, sp.TenSP, sp.GiaBan, sp.SoLuong, s.TenSize, ms.TenMauSac, cl.TenChatLieu, dm.TenDanhMuc, sp.TrangThai FROM SanPham sp JOIN Size s ON sp.ID_Size = s.ID_Size JOIN ChatLieu cl ON sp.ID_ChatLieu = cl.ID_ChatLieu JOIN MauSac ms ON sp.ID_MauSac = ms.ID_MauSac JOIN DanhMuc dm ON sp.ID_DanhMuc = dm.ID_DanhMuc";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                SanPham sp = new SanPham();
                sp.setMaSanPham(rs.getString("MaSanPham"));
                sp.setTenSanPham(rs.getString("TenSP"));
                sp.setGiaBan(rs.getInt("GiaBan"));
                sp.setSoLuong(rs.getInt("SoLuong"));
                sp.setSize(rs.getString("TenSize"));
                sp.setMauSac(rs.getString("TenMauSac"));
                sp.setChatLieu(rs.getString("TenChatLieu"));
                sp.setDanhMuc(rs.getString("TenDanhMuc"));
                sp.setTrangThai(rs.getString("TrangThai"));
                listSP.add(sp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
       
        return listSP;
    }

    public int insertSP(SanPham sp) {
        int kq = 0;
        sql = "INSERT INTO SanPham ( MaSanPham, TenSP, GiaBan, SoLuong, ID_Size, ID_ChatLieu, ID_MauSac, ID_DanhMuc, TrangThai) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, sp.getMaSanPham());
            ps.setString(2, sp.getTenSanPham());
            ps.setFloat(3, sp.getGiaBan());
            ps.setInt(4, sp.getSoLuong());
            ps.setString(5, sp.getSize());
            ps.setString(6, sp.getChatLieu());
            ps.setString(7, sp.getMauSac());
            ps.setString(8, sp.getDanhMuc());
            ps.setString(9, sp.getTrangThai());
            kq = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            kq = 0;
        }
        return kq;
    }

    public int updateSP(SanPham sp) {
        int kq = 0;
        sql = "update SanPham set TenSP = ?, GiaBan = ?, SoLuong = ?, ID_Size = ?, ID_ChatLieu = ?, ID_MauSac = ?, ID_DanhMuc = ?, TrangThai = ? where MaSanPham like ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, sp.getTenSanPham());
            ps.setFloat(2, sp.getGiaBan());
            ps.setInt(3, sp.getSoLuong());
            ps.setString(4, sp.getSize());
            ps.setString(5, sp.getChatLieu());
            ps.setString(6, sp.getMauSac());
            ps.setString(7, sp.getDanhMuc());
            ps.setString(8, sp.getTrangThai());
            ps.setString(8, sp.getTrangThai());
            ps.setString(9, sp.getMaSanPham());
            kq = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            kq = 0;
        }
        return kq;
    }

    public boolean isMaSanPham(String ma) {
        con = DBConnect.getConnection();
        sql = " select count(*) from SanPham where MaSanPham like ?";
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

    public List<SanPham> locDM(String danhmuc) {
        listSP = new ArrayList<>();
        con = DBConnect.getConnection();
        sql = "select sp.MaSanPham, sp.TenSP, s.TenSize, ms.TenMauSac, cl.TenChatLieu, sp.SoLuong, sp.GiaBan, dm.TenDanhMuc, sp.TrangThai from SanPham sp\n"
                + "join Size s on sp.ID_Size = s.ID_Size\n"
                + "join ChatLieu cl on sp.ID_ChatLieu = cl.ID_ChatLieu\n"
                + "join MauSac ms on sp.ID_MauSac = ms.ID_MauSac\n"
                + "join DanhMuc dm on sp.ID_DanhMuc = dm.ID_DanhMuc\n"
                + "where dm.TenDanhMuc like ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, danhmuc);
            rs = ps.executeQuery();
            while (rs.next()) {
                SanPham sp = new SanPham();
                sp.setMaSanPham(rs.getString("MaSanPham"));
                sp.setTenSanPham(rs.getString("TenSP"));
                sp.setGiaBan(rs.getFloat("GiaBan"));
                sp.setSoLuong(rs.getInt("SoLuong"));
                sp.setSize(rs.getString("TenSize"));
                sp.setMauSac(rs.getString("TenMauSac"));
                sp.setChatLieu(rs.getString("TenChatLieu"));
                sp.setDanhMuc(rs.getString("TenDanhMuc"));
                sp.setTrangThai(rs.getString("TrangThai"));
                listSP.add(sp);
            }// đóng while 

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return listSP;
    }

    public List<SanPham> locMS(String mausac) {
        listSP = new ArrayList<>();
        con = DBConnect.getConnection();
        sql = "select sp.MaSanPham, sp.TenSP, s.TenSize, ms.TenMauSac, cl.TenChatLieu, sp.SoLuong, sp.GiaBan, dm.TenDanhMuc, sp.TrangThai from SanPham sp\n"
                + "join Size s on sp.ID_Size = s.ID_Size\n"
                + "join ChatLieu cl on sp.ID_ChatLieu = cl.ID_ChatLieu\n"
                + "join MauSac ms on sp.ID_MauSac = ms.ID_MauSac\n"
                + "join DanhMuc dm on sp.ID_DanhMuc = dm.ID_DanhMuc\n"
                + "where ms.TenMauSac like ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, mausac);
            rs = ps.executeQuery();
            while (rs.next()) {
                SanPham sp = new SanPham();
                sp.setMaSanPham(rs.getString("MaSanPham"));
                sp.setTenSanPham(rs.getString("TenSP"));
                sp.setGiaBan(rs.getFloat("GiaBan"));
                sp.setSoLuong(rs.getInt("SoLuong"));
                sp.setSize(rs.getString("TenSize"));
                sp.setMauSac(rs.getString("TenMauSac"));
                sp.setChatLieu(rs.getString("TenChatLieu"));
                sp.setDanhMuc(rs.getString("TenDanhMuc"));
                sp.setTrangThai(rs.getString("TrangThai"));
                listSP.add(sp);
            }// đóng while 

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return listSP;
    }

    public List<SanPham> locCL(String chatlieu) {
        listSP = new ArrayList<>();
        con = DBConnect.getConnection();
        sql = "select sp.MaSanPham, sp.TenSP, s.TenSize, ms.TenMauSac, cl.TenChatLieu, sp.SoLuong, sp.GiaBan, dm.TenDanhMuc, sp.TrangThai from SanPham sp\n"
                + "join Size s on sp.ID_Size = s.ID_Size\n"
                + "join ChatLieu cl on sp.ID_ChatLieu = cl.ID_ChatLieu\n"
                + "join MauSac ms on sp.ID_MauSac = ms.ID_MauSac\n"
                + "join DanhMuc dm on sp.ID_DanhMuc = dm.ID_DanhMuc\n"
                + "where cl.TenChatLieu like ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, chatlieu);
            rs = ps.executeQuery();
            while (rs.next()) {
                SanPham sp = new SanPham();
                sp.setMaSanPham(rs.getString("MaSanPham"));
                sp.setTenSanPham(rs.getString("TenSP"));
                sp.setGiaBan(rs.getFloat("GiaBan"));
                sp.setSoLuong(rs.getInt("SoLuong"));
                sp.setSize(rs.getString("TenSize"));
                sp.setMauSac(rs.getString("TenMauSac"));
                sp.setChatLieu(rs.getString("TenChatLieu"));
                sp.setDanhMuc(rs.getString("TenDanhMuc"));
                sp.setTrangThai(rs.getString("TrangThai"));
                listSP.add(sp);
            }// đóng while 

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return listSP;
    }

    public List<SanPham> locKC(String kichco) {
        listSP = new ArrayList<>();
        con = DBConnect.getConnection();
        sql = "select sp.MaSanPham, sp.TenSP, s.TenSize, ms.TenMauSac, cl.TenChatLieu, sp.SoLuong, sp.GiaBan, dm.TenDanhMuc, sp.TrangThai from SanPham sp\n"
                + "join Size s on sp.ID_Size = s.ID_Size\n"
                + "join ChatLieu cl on sp.ID_ChatLieu = cl.ID_ChatLieu\n"
                + "join MauSac ms on sp.ID_MauSac = ms.ID_MauSac\n"
                + "join DanhMuc dm on sp.ID_DanhMuc = dm.ID_DanhMuc\n"
                + "where s.TenSize like ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, kichco);
            rs = ps.executeQuery();
            while (rs.next()) {
                SanPham sp = new SanPham();
                sp.setMaSanPham(rs.getString("MaSanPham"));
                sp.setTenSanPham(rs.getString("TenSP"));
                sp.setGiaBan(rs.getFloat("GiaBan"));
                sp.setSoLuong(rs.getInt("SoLuong"));
                sp.setSize(rs.getString("TenSize"));
                sp.setMauSac(rs.getString("TenMauSac"));
                sp.setChatLieu(rs.getString("TenChatLieu"));
                sp.setDanhMuc(rs.getString("TenDanhMuc"));
                sp.setTrangThai(rs.getString("TrangThai"));
                listSP.add(sp);
            }// đóng while 

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return listSP;
    }

    public List<SanPham> locTT(String trangthai) {
        listSP = new ArrayList<>();
        con = DBConnect.getConnection();
        sql = "select sp.MaSanPham, sp.TenSP, s.TenSize, ms.TenMauSac, cl.TenChatLieu, sp.SoLuong, sp.GiaBan, dm.TenDanhMuc, sp.TrangThai from SanPham sp\n"
                + "join Size s on sp.ID_Size = s.ID_Size\n"
                + "join ChatLieu cl on sp.ID_ChatLieu = cl.ID_ChatLieu\n"
                + "join MauSac ms on sp.ID_MauSac = ms.ID_MauSac\n"
                + "join DanhMuc dm on sp.ID_DanhMuc = dm.ID_DanhMuc\n"
                + "where sp.TrangThai like ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, trangthai);
            rs = ps.executeQuery();
            while (rs.next()) {
                SanPham sp = new SanPham();
                sp.setMaSanPham(rs.getString("MaSanPham"));
                sp.setTenSanPham(rs.getString("TenSP"));
                sp.setGiaBan(rs.getFloat("GiaBan"));
                sp.setSoLuong(rs.getInt("SoLuong"));
                sp.setSize(rs.getString("TenSize"));
                sp.setMauSac(rs.getString("TenMauSac"));
                sp.setChatLieu(rs.getString("TenChatLieu"));
                sp.setDanhMuc(rs.getString("TenDanhMuc"));
                sp.setTrangThai(rs.getString("TrangThai"));
                listSP.add(sp);
            }// đóng while 

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return listSP;
    }

    
    public int sLSPTheoma(String ma) {
        int sl = 0;
        String Selete_All_sql = "select SoLuong from SanPham where MaSanPham like ?";
        Connection cn = DBConnect.getConnection();
        try {
            PreparedStatement ps = cn.prepareStatement(Selete_All_sql);
            ps.setString(1, ma);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                sl = rs.getInt("SoLuong");
            }
        } catch (Exception e) {
            System.out.print(e);
        }
        return sl;

    }

    
}
