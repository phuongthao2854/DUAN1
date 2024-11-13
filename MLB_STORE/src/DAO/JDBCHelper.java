/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import service.DBConnect;

/**
 *
 * @author Admin
 */
public class JDBCHelper {

    //kết nối với DBConnect
    public static PreparedStatement preparedStatement(String sql, Object... args) {
        try {
            Connection cn = DBConnect.getConnection();
            PreparedStatement pstm = null;
            if (sql.trim().startsWith("{")) {
                pstm = cn.prepareCall(sql);
            }
            pstm = cn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                pstm.setObject(i + 1, args[i]);
            }
            return pstm;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
//        return null;
    }

    //hàm để select(getALL()), tìm kiếm
    public static ResultSet executeQuery(String sql, Object... args) {
        try {
            PreparedStatement pstm = preparedStatement(sql, args);
            try {
                return pstm.executeQuery();
            } finally {
//                pstm.getConnection().close();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
//        return null;
    }

    //hàm thêm , sửa , xóa
    public static int excuteUpdate(String sql, Object... args) {
        try {
            PreparedStatement pstm = preparedStatement(sql, args);
            try {
                int result = pstm.executeUpdate();
                return result;
            } finally {
                pstm.getConnection().close();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
