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
import model.DanhMuc;
import model.KichCo;


/**
 *
 * @author Admin
 */
public class DanhMuc_Service {
    private List<DanhMuc> listDM;
    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private String sql = null;
    
    public List<DanhMuc> getAll(){
       listDM = new ArrayList<>();
        sql = "SELECT * from DanhMuc";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                DanhMuc dm = new DanhMuc();
                dm.setId(rs.getInt(1));
                dm.setTen(rs.getString(2));
                dm.setTrangthai(rs.getString(3)); 
                listDM.add(dm);
            }
        } catch (Exception e) {
        }
        try (PreparedStatement statement = con.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listDM;
    }
    
    public int insertDM(DanhMuc dm) {
        int kq = 0;
        sql = "insert into DanhMuc (TenDanhMuc) values (?)";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
           
            ps.setString(1, dm.getTen());
            kq = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            kq = 0;
        }
        return kq;
    }
     public int updateDM(int id, DanhMuc dm) {
        int kq = 0;
        sql = "update DanhMuc set TenDanhMuc = ?  where ID_DanhMuc like ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(2, id);
            ps.setString(1, dm.getTen());
            kq = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            kq = 0;
        }
        return kq;
    }
     public boolean isTenTT(String ten) {
        con = DBConnect.getConnection();
        sql = " select count(*) from DanhMuc where TenDanhMuc like ?";
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
