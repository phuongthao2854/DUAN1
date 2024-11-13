package service;

import DAO.JDBCHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.SanPham;
import model.Voucher;

public class SP_BanHang_Service {
    
    private String sql = null;
    
    public int updateSL_SP_BY_IDSP(int idSP, int SL) {
        sql = "update SanPham\n"
                + "set SoLuong = ? \n"
                + "where ID_SanPham = ?";
        int result = JDBCHelper.excuteUpdate(sql, SL, idSP);
        return result;
    }
    
    public List<SanPham> getALL() {//Truy vấn DSSP
        sql = ""
                + "SELECT SP.ID_SanPham , SP.MaSanPham , SP.TenSP , size.TenSize , MS.TenMauSac , DM.TenDanhMuc \n"
                + ", CL.TenChatLieu , SP.SoLuong , SP.GiaBan , SP.TrangThai\n"
                + "FROM SanPham SP \n"
                + "inner join Size size on size.ID_Size = sp.ID_Size\n"
                + "inner join MauSac ms on ms.ID_MauSac = sp.ID_MauSac\n"
                + "inner join DanhMuc dm on dm.ID_DanhMuc = sp.ID_DanhMuc\n"
                + "inner join ChatLieu cl on cl.ID_ChatLieu = sp.ID_ChatLieu\n"
                + "where sp.TrangThai = N'Đang bán' and SP.SoLuong > 0 ";
        return selectBySQL(sql);
    }
    
    public SanPham getSP_BY_MaSP(String maSP) {//Truy vấn SP
        sql = "SELECT SP.ID_SanPham , SP.MaSanPham , SP.TenSP , size.TenSize , MS.TenMauSac , DM.TenDanhMuc \n"
                + ", CL.TenChatLieu , SP.SoLuong , SP.GiaBan \n"
                + "FROM SanPham SP \n"
                + "inner join Size size on size.ID_Size = sp.ID_Size\n"
                + "inner join MauSac ms on ms.ID_MauSac = sp.ID_MauSac\n"
                + "inner join DanhMuc dm on dm.ID_DanhMuc = sp.ID_DanhMuc\n"
                + "inner join ChatLieu cl on cl.ID_ChatLieu = sp.ID_ChatLieu\n"
                + "where sp.MaSanPham = ?";
        return selectBySQL(sql, maSP).get(0);
    }

    //Truy vấn danh sách SP theo Size
    public List<SanPham> getALLBySize(String size) {//Truy vấn DSSP
        sql = "SELECT SP.ID_SanPham , SP.MaSanPham , SP.TenSP , size.TenSize , MS.TenMauSac , DM.TenDanhMuc \n"
                + ", CL.TenChatLieu , SP.SoLuong , SP.GiaBan \n"
                + "FROM SanPham SP \n"
                + "inner join Size size on size.ID_Size = sp.ID_Size\n"
                + "inner join MauSac ms on ms.ID_MauSac = sp.ID_MauSac\n"
                + "inner join DanhMuc dm on dm.ID_DanhMuc = sp.ID_DanhMuc\n"
                + "inner join ChatLieu cl on cl.ID_ChatLieu = sp.ID_ChatLieu\n"
                + "where sp.TrangThai = N'Đang bán' and size.TenSize = ?";
        List<SanPham> listSP = selectBySQL(sql, size);
        return listSP;
    }

    //Truy vấn danh sách SP theo Màu Sác
    public List<SanPham> getALLByMS(String mauSac) {//Truy vấn DSSP
        sql = "SELECT SP.ID_SanPham , SP.MaSanPham , SP.TenSP , size.TenSize , MS.TenMauSac , DM.TenDanhMuc \n"
                + ", CL.TenChatLieu , SP.SoLuong , SP.GiaBan \n"
                + "FROM SanPham SP \n"
                + "inner join Size size on size.ID_Size = sp.ID_Size\n"
                + "inner join MauSac ms on ms.ID_MauSac = sp.ID_MauSac\n"
                + "inner join DanhMuc dm on dm.ID_DanhMuc = sp.ID_DanhMuc\n"
                + "inner join ChatLieu cl on cl.ID_ChatLieu = sp.ID_ChatLieu\n"
                + "where sp.TrangThai = N'Đang bán' and MS.TenMauSac = ?";
        List<SanPham> listSP = selectBySQL(sql, mauSac);
        return listSP;
    }

    //Truy vấn danh sách SP theo Size
    public List<SanPham> getALLByDM(String danhMuc) {//Truy vấn DSSP
        sql = "SELECT SP.ID_SanPham , SP.MaSanPham , SP.TenSP , size.TenSize , MS.TenMauSac , DM.TenDanhMuc \n"
                + ", CL.TenChatLieu , SP.SoLuong , SP.GiaBan \n"
                + "FROM SanPham SP \n"
                + "inner join Size size on size.ID_Size = sp.ID_Size\n"
                + "inner join MauSac ms on ms.ID_MauSac = sp.ID_MauSac\n"
                + "inner join DanhMuc dm on dm.ID_DanhMuc = sp.ID_DanhMuc\n"
                + "inner join ChatLieu cl on cl.ID_ChatLieu = sp.ID_ChatLieu\n"
                + "where sp.TrangThai = N'Đang bán' and dm.TenDanhMuc = ?";
        List< SanPham> listSP = selectBySQL(sql, danhMuc);
        return listSP;
    }
    
    public List<SanPham> selectBySQL(String sql, Object... args) {
        List<SanPham> listSP = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.executeQuery(sql, args);
            while (rs.next()) {
                SanPham sp = new SanPham();
                sp.setIdSP(rs.getInt("ID_SanPham"));
                sp.setMaSanPham(rs.getString("MaSanPham"));
                sp.setTenSanPham(rs.getString("TenSP"));
                sp.setGiaBan(rs.getInt("GiaBan"));
                sp.setSoLuong(rs.getInt("SoLuong"));
                sp.setSize(rs.getString("TenSize"));
                sp.setMauSac(rs.getString("TenMauSac"));
                sp.setChatLieu(rs.getString("TenChatLieu"));
                sp.setDanhMuc(rs.getString("TenDanhMuc"));
                listSP.add(sp);
            }
            return listSP;
        } catch (SQLException e) {
        }
        return null;
    }
    
    List<Voucher> listVC = new ArrayList<>();
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public List<Voucher> getAll_Voucher() {//Lấy các voucher hợp lệ cho bán hàng
        
        sql = "SELECT * FROM Voucher V where V.TrangThai = N'Đang áp dụng' \n"
                + "AND	V.NgayBatDau <= CURRENT_TIMESTAMP \n"
                + "AND V.NgayKetThuc > CURRENT_TIMESTAMP\n"
                + "AND V.SoLuong > 0";
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
        } catch (SQLException e) {
            return null;
        }
    }
    
    public Voucher getVoucherByMaVoucher(String maVoucher) {//Lấy các voucher hợp lệ cho bán hàng
        sql = "SELECT * FROM Voucher V where V.MaVoucher = ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, maVoucher);
            rs = ps.executeQuery();
            Voucher vc = new Voucher();
            while (rs.next()) {
                vc.setIDVoucher(rs.getInt("ID_Voucher"));
                vc.setMa(rs.getString("MaVoucher"));
                vc.setTen(rs.getString("TenVoucher"));
                vc.setNgaybd(rs.getDate("NgayBatDau"));
                vc.setNgaykt(rs.getDate("NgayKetThuc"));
                vc.setTlgiam(rs.getFloat("TiLeGiam"));
                vc.setDhtoithieu(rs.getFloat("DonHangToiThieu"));
                vc.setGiamtoida(rs.getFloat("GiamToiDa"));
                vc.setSoluong(rs.getInt("SoLuong"));
                vc.setTrangthai(rs.getString("TrangThai"));
            }
            return vc;
        } catch (SQLException e) {
            return null;
        }
    }
    
}
