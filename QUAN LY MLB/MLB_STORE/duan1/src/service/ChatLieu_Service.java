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

/**
 *
 * @author Admin
 */
public class ChatLieu_Service {

    private List<ChatLieu> listCL;
    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private String sql = null;

    public List<ChatLieu> getAll() {
        listCL = new ArrayList<>();
        sql = "SELECT * from ChatLieu";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                ChatLieu cl = new ChatLieu();
                cl.setId(rs.getInt(1));
                cl.setTen(rs.getString(2));
                cl.setTrangthai(rs.getString(3));
                listCL.add(cl);
            }
        } catch (Exception e) {
        }
        try (PreparedStatement statement = con.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listCL;
    }

    public int insertCL(ChatLieu cl) {
        int kq = 0;
        sql = "insert into ChatLieu (TenChatLieu) values (?)";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);

            ps.setString(1, cl.getTen());
            kq = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            kq = 0;
        }
        return kq;
    }

    public int updateCL(int id, ChatLieu cl) {
        int kq = 0;
        sql = "update ChatLieu set TenChatLieu = ? where ID_ChatLieu like ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, cl.getTen());
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
        sql = " select count(*) from ChatLieu where TenChatLieu like ?";
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
