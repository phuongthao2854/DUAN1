package service;

import DAO.JDBCHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.SanPham;

public class ThongKeService {

    String sql;
    List<SanPham> listSP = new ArrayList<>();
    ResultSet rs;

    public long getTongHoaDon(String nbd, String nkt) {
        sql = "SELECT COUNT(HD.ID_Hoadon) as N'Tong_SoDonHang'  \n"
                + "FROM HoaDon HD \n"
                + "WHERE HD.TrangThai = N'Đã thanh toán' AND HD.NgayTao >= ? AND HD.NgayTao <= ?";
        try {
            rs = JDBCHelper.executeQuery(sql, nbd, nkt);
            while (rs.next()) {
                return rs.getLong("Tong_SoDonHang");
            }
            rs.getStatement().getConnection().close();
        } catch (SQLException e) {
        }
        return 1;
    }

    public long getSL_SP_Ban(String nbd, String nkt) {
        sql = "SELECT SUM(HDCT.SoLuongMua) as N'SL_SP_Ban' FROM HoaDonCT HDCT \n"
                + "INNER JOIN HoaDon HD ON HD.ID_Hoadon = HDCT.ID_HoaDon\n"
                + "WHERE HD.TrangThai = N'Đã thanh toán' AND HD.NgayTao >= ? AND HD.NgayTao <= ?";
        try {
            rs = JDBCHelper.executeQuery(sql, nbd, nkt);
            while (rs.next()) {
                return rs.getLong("SL_SP_Ban");
            }
            rs.getStatement().getConnection().close();
        } catch (SQLException e) {
        }
        return 1;
    }

    public long getDoanhThu(String nbd, String nkt) {
        sql = "Select SUM(HD.TongTien) as N'DoanhThu'  from HoaDon HD\n"
                + "WHERE HD.TrangThai = N'Đã thanh toán' AND HD.NgayTao >= ? AND HD.NgayTao <= ? ";
        try {
            rs = JDBCHelper.executeQuery(sql, nbd, nkt);
            while (rs.next()) {
                return rs.getLong("DoanhThu");
            }
            rs.getStatement().getConnection().close();
        } catch (SQLException e) {
        }
        return 1;
    }

    public List<SanPham> getAll_SP_BanChay() {
        listSP = new ArrayList<>();
        sql = "SELECT SP.ID_SanPham , SP.MaSanPham , SP.TenSP  , MS.TenMauSac , CL.TenChatLieu , S.TenSize, DM.TenDanhMuc\n"
                + ", SUM(HDCT.SoLuongMua) as N'SLBanDuoc'\n"
                + "FROM HoaDonCT HDCT \n"
                + "INNER JOIN SanPham SP on SP.ID_SanPham = HDCT.ID_SanPham\n"
                + "INNER JOIN HoaDon HD on HD.ID_Hoadon = HDCT.ID_HoaDon\n"
                + "INNER JOIN MauSac MS ON MS.ID_MauSac = SP.ID_MauSac\n"
                + "INNER JOIN ChatLieu CL ON CL.ID_ChatLieu = SP.ID_ChatLieu \n"
                + "INNER JOIN Size S ON S.ID_Size = SP.ID_Size\n"
                + "INNER JOIN DanhMuc DM ON DM.ID_DanhMuc = SP.ID_DanhMuc\n"
                + "GROUP BY SP.ID_SanPham , SP.TenSP , HD.TrangThai ,MS.TenMauSac \n"
                + ", CL.TenChatLieu , S.TenSize, DM.TenDanhMuc	, SP.MaSanPham \n"
                + "HAVING HD.TrangThai = N'Đã thanh toán'\n"
                + "Order by SUM(HDCT.SoLuongMua) desc;";
        try {
            rs = JDBCHelper.executeQuery(sql);
            while (rs.next()) {
                SanPham sp = new SanPham();
                sp.setIdSP(rs.getInt("ID_SanPham"));
                sp.setMaSanPham(rs.getString("MaSanPham"));
                sp.setTenSanPham(rs.getString("TenSP"));
                sp.setMauSac(rs.getString("TenMauSac"));
                sp.setChatLieu(rs.getString("TenChatLieu"));
                sp.setSize(rs.getString("TenSize"));
                sp.setDanhMuc(rs.getString("TenDanhMuc"));
                sp.setSoLuong(rs.getInt("SLBanDuoc"));//= SL bán được
                listSP.add(sp);
            }
            rs.getStatement().getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listSP;
    }

    public List<SanPham> getAll_SP_SapHet() {
        listSP = new ArrayList<>();
        sql = "SELECT SP.ID_SanPham , SP.MaSanPham , SP.TenSP  , MS.TenMauSac \n"
                + ", CL.TenChatLieu , S.TenSize, DM.TenDanhMuc , SP.SoLuong\n"
                + "FROM SanPham SP\n"
                + "INNER JOIN MauSac MS ON MS.ID_MauSac = SP.ID_MauSac\n"
                + "INNER JOIN ChatLieu CL ON CL.ID_ChatLieu = SP.ID_ChatLieu \n"
                + "INNER JOIN Size S ON S.ID_Size = SP.ID_Size\n"
                + "INNER JOIN DanhMuc DM ON DM.ID_DanhMuc = SP.ID_DanhMuc\n"
                + "WHERE SP.SoLuong <= 5 AND SP.SoLuong > 0 AND  SP.TrangThai = N'Đang bán'";
        try {
            rs = JDBCHelper.executeQuery(sql);
            while (rs.next()) {
                SanPham sp = new SanPham();
                sp.setIdSP(rs.getInt("ID_SanPham"));
                sp.setMaSanPham(rs.getString("MaSanPham"));
                sp.setTenSanPham(rs.getString("TenSP"));
                sp.setMauSac(rs.getString("TenMauSac"));
                sp.setChatLieu(rs.getString("TenChatLieu"));
                sp.setSize(rs.getString("TenSize"));
                sp.setDanhMuc(rs.getString("TenDanhMuc"));
                sp.setSoLuong(rs.getInt("SoLuong"));
                listSP.add(sp);
            }
            rs.getStatement().getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listSP;
    }

}
