package service;

import com.raven.event.HoaDonService;
import java.util.ArrayList;
import java.util.List;
import model.HoaDon;
import java.sql.*;
import DAO.JDBCHelper;
import model.SanPham;
import model.Voucher;

public class HoaDonlmpl implements HoaDonService {

    List<HoaDon> listHoaDon = new ArrayList<>();
    List<SanPham> listSP = new ArrayList<>();

    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private String sql = null;

    public List<HoaDon> getHoaDonAll3(String trangThai, String nbd, String nkt) {//Đã thanh toán
        listHoaDon.clear();
        try {
            sql = "SELECT HD.ID_Hoadon , HD.MaHD , HD.NgayTao , NV.TenNhanVien , KH.TenKhachHang, HD.TongTien\n"
                    + "FROM HoaDon HD\n"
                    + "INNER JOIN NhanVien NV   On NV.ID_Nhanvien = HD.ID_Nhanvien\n"
                    + "INNER JOIN KhachHang KH  On KH.ID_KhachHang = HD.ID_KhachHang\n"
                    + "WHERE HD.TrangThai = ? AND HD.NgayTao >= ? AND HD.NgayTao <= ? ";

            rs = JDBCHelper.executeQuery(sql, trangThai, nbd, nkt);
            while (rs.next()) {
                HoaDon hd = new HoaDon();
                hd.setIdHD(rs.getInt("ID_HoaDon"));
                hd.setMaHD(rs.getString("MaHD"));
                hd.setNgayTao(rs.getDate("NgayTao"));
                hd.setTenNV(rs.getString("TenNhanVien"));
                hd.setTenKH(rs.getString("TenKhachHang"));
                hd.setTongTien(rs.getFloat("TongTien"));
                listHoaDon.add(hd);
            }
            rs.getStatement().getConnection().close();
        } catch (SQLException e) {
        }
        return listHoaDon;
    }

    public List<SanPham> getListSP_BY_MaHD(String maHD) {
        listSP.clear();
        try {
            sql = "SELECT SP.MaSanPham , SP.TenSP , HDCT.SoLuongMua  , HDCT.GiaBan ,\n"
                    + "Ms.TenMauSac , S.TenSize , CL.TenChatLieu \n"
                    + "FROM SanPham SP\n"
                    + "INNER JOIN HoaDonCT HDCT On HDCT.ID_SanPham = SP.ID_SanPham\n"
                    + "INNER JOIN HoaDon HD On HD.ID_Hoadon = HDCT.ID_HoaDon\n"
                    + "INNER JOIN MauSac MS ON MS.ID_MauSac = SP.ID_MauSac\n"
                    + "INNER JOIN ChatLieu CL ON CL.ID_ChatLieu = SP.ID_ChatLieu \n"
                    + "INNER JOIN Size S ON S.ID_Size = SP.ID_Size\n"
                    + "INNER JOIN DanhMuc DM ON DM.ID_DanhMuc = SP.ID_DanhMuc\n"
                    + "WHERE HD.MaHD = ?";
            rs = JDBCHelper.executeQuery(sql, maHD);
            while (rs.next()) {
                SanPham sp = new SanPham();
                sp.setMaSanPham(rs.getString("MaSanPham"));
                sp.setTenSanPham(rs.getString("TenSP"));
                sp.setSoLuong(rs.getInt("SoLuongMua"));
                sp.setGiaBan(rs.getFloat("GiaBan"));
                sp.setMauSac(rs.getString("TenMauSac"));
                sp.setSize(rs.getString("TenSize"));
                sp.setChatLieu(rs.getString("TenChatLieu"));
                listSP.add(sp);
            }
            rs.getStatement().getConnection().close();
        } catch (SQLException e) {
        }
        return listSP;
    }

    public List<HoaDon> getHoaDonAll2(String trangThai) {//Đã thanh toán
        listHoaDon.clear();
        try {
            sql = "SELECT HD.ID_Hoadon , HD.MaHD , HD.NgayTao , NV.TenNhanVien , KH.TenKhachHang, HD.TongTien\n"
                    + "FROM HoaDon HD\n"
                    + "INNER JOIN NhanVien NV   On NV.ID_Nhanvien = HD.ID_Nhanvien\n"
                    + "INNER JOIN KhachHang KH  On KH.ID_KhachHang = HD.ID_KhachHang\n"
                    + "WHERE HD.TrangThai = ?";

            rs = JDBCHelper.executeQuery(sql, trangThai);
            while (rs.next()) {
                HoaDon hd = new HoaDon();
                hd.setIdHD(rs.getInt("ID_HoaDon"));
                hd.setMaHD(rs.getString("MaHD"));
                hd.setNgayTao(rs.getDate("NgayTao"));
                hd.setTenNV(rs.getString("TenNhanVien"));
                hd.setTenKH(rs.getString("TenKhachHang"));
                hd.setTongTien(rs.getFloat("TongTien"));
                listHoaDon.add(hd);
            }
            rs.getStatement().getConnection().close();
        } catch (SQLException e) {
        }
        return listHoaDon;
    }

    public Voucher getVoucher_BY_MaHD(String maHD) {

        try {
            sql = "SELECT V.TenVoucher , V.TiLeGiam , V.GiamToiDa \n"
                    + "FROM Voucher V\n"
                    + "INNER JOIN HoaDon HD On HD.ID_Voucher = V.ID_Voucher\n"
                    + "WHERE HD.MaHD = ?";
            rs = JDBCHelper.executeQuery(sql, maHD);
            Voucher V = new Voucher();
            while (rs.next()) {
                V.setTen(rs.getString("TenVoucher"));
                V.setTlgiam(rs.getFloat("TiLeGiam"));
                V.setGiamtoida(rs.getFloat("GiamToiDa"));
            }
            rs.getStatement().getConnection().close();
            return V;
        } catch (SQLException e) {
        }
        return null;
    }

    @Override
    public HoaDon getRowHD(int row) {
        return listHoaDon.get(row);
    }

    @Override
    public void addHoaDon(HoaDon hd) {
        try {
            String sql = "Insert into HoaDon (MaHD, ID_NhanVien, ID_KhachHang, ID_Vocher, NgayTao, TrangThai) values (?,?,?,?,?) ";
            Connection conn = DBConnect.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, hd.getMaHD());
            ps.setInt(2, hd.getIdNV());
            ps.setInt(3, hd.getIdKH());
            ps.setInt(4, hd.getIdVC());
            ps.setDate(5, hd.getNgayTao());
            ps.setString(6, hd.getTrangThai());
            ps.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void upDateHoaDon(HoaDon hd) {
        try {
            String sql = "update HoaDon set ID_NhanVien = ?, ID_KhachHang = ? ,ID_Voucher = ?, NgayTao = ? , TrangThai = ? where MaHD like ?";
            Connection conn = DBConnect.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(6, hd.getMaHD());
            ps.setInt(1, hd.getIdNV());
            ps.setInt(2, hd.getIdKH());
            ps.setInt(3, hd.getIdVC());
            ps.setDate(4, hd.getNgayTao());
            ps.setString(5, hd.getTrangThai());
            ps.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<HoaDon> getAllHoaDonAdmin() {
        listHoaDon.clear();
        try {
            String sql = "SELECT hd.ID_Hoadon, \n"
                    + "                          hd.MaHD, \n"
                    + "                           nv.TenNhanVien, \n"
                    + "                         kh.TenKhachHang, \n"
                    + "                         vc.GiamToiDa, \n"
                    + "                           hd.NgayTao, \n"
                    + "			   hd.TongTien ,\n"
                    + "                           hd.TrangThai, \n"
                    + "                          hd.GhiChu\n"
                    + "                    FROM HoaDon hd\n"
                    + "                    JOIN NhanVien nv ON hd.ID_NhanVien = nv.ID_Nhanvien\n"
                    + "                    JOIN KhachHang kh ON hd.ID_KhachHang = kh.ID_KhachHang\n"
                    + "                    JOIN Voucher vc ON hd.ID_Voucher = vc.ID_Voucher\n";
            Connection conn = DBConnect.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDon hd = new HoaDon();
                hd.setIdHD(rs.getInt("ID_HoaDon"));
                hd.setMaHD(rs.getString("MaHD"));
                hd.setNgayTao(rs.getDate("NgayTao"));
                hd.setTenNV(rs.getString("TenNhanVien"));
                hd.setTenKH(rs.getString("TenKhachHang"));
                hd.setSoTienGiam(rs.getFloat("GiamToiDa"));
                hd.setTongTien(rs.getFloat("TongTien"));
                hd.setTrangThai(rs.getString("TrangThai"));
                listHoaDon.add(hd);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listHoaDon;
    }

    public boolean isMaHD(String ma) {
        con = DBConnect.getConnection();
        sql = " select count(*) from HoaDon where MaHD like ?";
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

    @Override
    public List<HoaDon> Search(String key) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<HoaDon> SearchTime(String key) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean randomMaHoaDon(String MaHD) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<HoaDon> getHoaDonAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
