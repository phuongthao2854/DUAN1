package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.HoaDonCT;


public class HoaDonChiTiet_Service {
    public int themHoaDonChiTiet(HoaDonCT hdct) {
        Connection conn = null;
        PreparedStatement ps = null;
        int rowsInserted = 0;

        try {
            conn = DBConnect.getConnection();
            String sql = "INSERT INTO HoaDonCT (ID_HoaDon, ID_SanPham, GiaBan, SoLuong, ThanhTien) VALUES (?, ?, ?, ?, ?)";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, hdct.getId_HD());
            ps.setInt(2, hdct.getId_SP());
            ps.setFloat(3, hdct.getGiaban());
            ps.setInt(4, hdct.getSoLuong());
            ps.setFloat(5, hdct.getThanhTien());

            rowsInserted = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return rowsInserted;
    }

    public int xoaHoaDonChiTietTheoIDHoaDon(int idHoaDon) {
        Connection conn = null;
        PreparedStatement ps = null;
        int rowsDeleted = 0;

        try {
            conn = DBConnect.getConnection();
            String sql = "DELETE FROM HoaDonCT WHERE ID_HoaDon = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, idHoaDon);

            rowsDeleted = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return rowsDeleted;
    }

    public List<HoaDonCT> layDSHoaDonChiTietTheoMaHoaDon(int maHoaDon) {
        List<HoaDonCT> danhSachHoaDonChiTiet = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            // Kết nối cơ sở dữ liệu
            connection = DBConnect.getConnection();
            if (connection != null) {
                // Câu truy vấn SQL để lấy danh sách chi tiết hóa đơn dựa trên mã hóa đơn
                String query = "SELECT * FROM HoaDonCT WHERE ID_HoaDon = ?";
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setInt(1, maHoaDon);

                // Thực thi truy vấn
                resultSet = preparedStatement.executeQuery();

                // Duyệt qua kết quả và thêm vào danh sách
                while (resultSet.next()) {
                    HoaDonCT dhct = new HoaDonCT();
                    dhct.setId_HDCT(resultSet.getInt("ID_HoaDonCT"));
                    dhct.setId_HD(resultSet.getInt("ID_HoaDon"));
                    
                    dhct.setId_SP(resultSet.getInt("ID_SanPham"));
                    
                    dhct.setGiaban(resultSet.getInt("GiaBan"));
                    dhct.setSoLuong(resultSet.getInt("SoLuongMua"));
                    dhct.setThanhTien(resultSet.getInt("ThanhTien"));
                    danhSachHoaDonChiTiet.add(dhct);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Đóng kết nối và các đối tượng
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return danhSachHoaDonChiTiet;
    }
}
