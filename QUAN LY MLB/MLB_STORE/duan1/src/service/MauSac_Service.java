/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import com.raven.event.Method_SanPham;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.ChatLieu;
import model.KichCo;
import model.MauSac;
import model.NhanVien;

/**
 *
 * @author Admin
 */
public class MauSac_Service{

    private List<MauSac> listMS;
    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private String sql = null;

    public List<MauSac> getAll() {
        listMS = new ArrayList<>();
        sql = "SELECT * from MauSac";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                MauSac ms = new MauSac();
                ms.setId(rs.getInt(1));
                ms.setTen(rs.getString(2));
                ms.setTrangThai(rs.getString(3));
                listMS.add(ms);
            }
        } catch (Exception e) {
        }
        try (PreparedStatement statement = con.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listMS;
    }

    public int insertMS(MauSac ms) {
        int kq = 0;
        sql = "insert into MauSac (TenMauSac) values (?)";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);

            ps.setString(1, ms.getTen());
            kq = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            kq = 0;
        }
        return kq;
    }

    public int updateMS(int id, MauSac ms) {
        int kq = 0;
        sql = "update MauSac set TenMauSac = ? where ID_MauSac like ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, ms.getTen());
            ps.setInt(2, id);
            kq = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            kq = 0;
        }
        return kq;
    }
    public boolean isTenTT(String ten) {
        con = DBConnect.getConnection();
        sql = " select count(*) from MauSac where TenMauSac like ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, ten);
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
