/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import com.raven.event.ThuocTinhlmpl;
import java.util.ArrayList;
import java.util.List;
import model.ChatLieu;
import model.DanhMuc;
import model.KichCo;
import model.MauSac;
import java.sql.*;
import javax.swing.*;

/**
 *
 * @author Admin
 */
public class ThuocTinh_Service implements ThuocTinhlmpl {

    List<MauSac> listMS = new ArrayList<>();
    List<ChatLieu> listCL = new ArrayList<>();
    List<KichCo> listKC = new ArrayList<>();
    List<DanhMuc> listDM = new ArrayList<>();

    @Override
    public List<MauSac> getAllMs() {
        listMS.clear();
        String sql = "Select ID_MauSac, TenMauSac, TrangThai from MauSac";
        try {
            Connection conn = DBConnect.getConnection();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                MauSac ms = new MauSac();
                ms.setId(rs.getInt(1));
                ms.setTen(rs.getString(2));
                ms.setTrangThai(rs.getString(3));
                listMS.add(ms);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listMS;
    }

    @Override
    public List<ChatLieu> getAllCl() {
        listCL.clear();
        String sql = "Select ID_ChatLieu, TenChatLieu, TrangThai from ChatLieu";
        try {
            Connection conn = DBConnect.getConnection();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
               ChatLieu cl = new ChatLieu();
                cl.setId(rs.getInt(1));
                cl.setTen(rs.getString(2));
                cl.setTrangthai(rs.getString(3));
                listCL.add(cl);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listCL;
    }

    @Override
    public List<KichCo> getAllKc() {
        listKC.clear();
        String sql = "Select ID_Size, TenSize, TrangThai from Size";
        try {
            Connection conn = DBConnect.getConnection();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
               KichCo kc = new KichCo();
                kc.setId(rs.getInt(1));
                kc.setTen(rs.getString(2));
                kc.setTrangThai(rs.getString(3));
                listKC.add(kc);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listKC;
    }

    @Override
    public List<DanhMuc> getAllDM() {
        listDM.clear();
        String sql = "Select ID_DanhMuc, TenDanhMuc, TrangThai from DanhMuc";
        try {
            Connection conn = DBConnect.getConnection();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                DanhMuc dm = new DanhMuc();
                dm.setId(rs.getInt(1));
                dm.setTen(rs.getString(2));
                dm.setTrangthai(rs.getString(3));
                listDM.add(dm);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listDM;
    }

    @Override
    public void addMauSac(MauSac ms) {
        listMS.clear();
        String sql ="insert into MauSac (TenMauSac, TrangThai) values (?, ?)";
        try {
            Connection conn = DBConnect.getConnection();
            PreparedStatement psm = conn.prepareStatement(sql);
            psm.setString(1, ms.getTen());
            psm.setString(2, "Hoạt động");
            psm.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addChatLieu(ChatLieu cl) {
        listCL.clear();
        String sql ="insert into ChatLieu (TenChatLieu, TrangThai) values (?, ?)";
        try {
            Connection conn = DBConnect.getConnection();
            PreparedStatement psm = conn.prepareStatement(sql);
            psm.setString(1, cl.getTen());
            psm.setString(2, "Hoạt động");
            psm.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addKichCo(KichCo kc) {
         listMS.clear();
        String sql ="insert into Size (TenSize, TrangThai) values (?, ?)";
        try {
            Connection conn = DBConnect.getConnection();
            PreparedStatement psm = conn.prepareStatement(sql);
            psm.setString(1, kc.getTen());
            psm.setString(2, "Hoạt động");
            psm.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addDanhMuc(DanhMuc dm) {
        listMS.clear();
        String sql ="insert into DanhMuc (TenDanhMuc, TrangThai) values (?, ?)";
        try {
            Connection conn = DBConnect.getConnection();
            PreparedStatement psm = conn.prepareStatement(sql);
            psm.setString(1, dm.getTen());
            psm.setString(2, "Hoạt động");
            psm.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
