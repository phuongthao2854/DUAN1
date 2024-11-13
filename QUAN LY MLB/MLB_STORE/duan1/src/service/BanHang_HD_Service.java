package service;

import DAO.JDBCHelper;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.HoaDon_M;
import model.KhachHang;

public class BanHang_HD_Service {

    private ResultSet rs = null;
    private String sql = null;

    //Update lại Id_KH cho HD dựa vào maHD + idKH cần update
    public int update_IdKH_For_HD(String maHD, int id_KH) {
        sql = "update HoaDon\n"
                + "set ID_KhachHang  = ?\n"
                + "where MaHD = ?";
        return JDBCHelper.excuteUpdate(sql, id_KH, maHD);
    }

    //Đang chưa dùng
    public KhachHang find_SDT_KH_BY_MaKH(String maKH) {
        List<KhachHang> listKH = new ArrayList<>();
        sql = "select ID_KhachHang, MaKhachHang, TenKhachHang, SDT from KhachHang\n"
                + "where KhachHang.MaKhachHang = ?";
        try {
            rs = JDBCHelper.executeQuery(sql, maKH);
            KhachHang kh = new KhachHang();
            while (rs.next()) {
                kh.setId_KH(rs.getInt("ID_KhachHang"));
                kh.setMa(rs.getString("MaKhachHang"));
                kh.setTen(rs.getString("TenKhachHang"));
                kh.setSdt(rs.getString("SDT"));
                listKH.add(kh);
            }
            return kh;
        } catch (SQLException e) {
            return null;
        }
    }

    //Xóa HD theo Mã HĐ
    public int delete_HD_BY_MaHD(String maHD) {
        sql = "delete from HoaDon\n"
                + "where MaHD  = ? ";
        return JDBCHelper.excuteUpdate(sql, maHD);
    }

//    update lại SL hóa đơn khi thực hiện thanh toán có áp dụng hóa đơn
    public void update_SL_Voucher_BY_ID_Voucher(int id_Voucher) {
        sql = "update Voucher\n"
                + "set SoLuong = SoLuong - 1\n"
                + "where ID_Voucher = ?";
        JDBCHelper.excuteUpdate(sql, id_Voucher);
    }

//Update HĐ khi thanh toán với ID_Voucher + Trạng thái == Đã thanh toán.
    public int update_ThanhToan_HD_BY_IdHD(int idHD, int id_Voucher, String ghiChu) {
        if (id_Voucher == 0) {//TH ko có voucher áp cho HĐ đó.
            sql = "update HoaDon\n"
                    + "set GhiChu = ? , TrangThai = N'Đã thanh toán'\n"
                    + "where ID_Hoadon = ?";
            return JDBCHelper.excuteUpdate(sql, ghiChu, idHD);
        } else {
            sql = "update HoaDon\n"
                    + "set  GhiChu = ? , ID_Voucher = ? , TrangThai = N'Đã thanh toán'\n"
                    + "where ID_Hoadon = ?";
            return JDBCHelper.excuteUpdate(sql, ghiChu, id_Voucher, idHD);
        }
    }

//Update lại tổng tiền hóa đơn
    public int update_TT_HD_BY_idHD(int id_HD, long tongTien) {
        sql = "update HoaDon\n"
                + "set TongTien = ? \n"
                + "where ID_Hoadon = ?";
        return JDBCHelper.excuteUpdate(sql, tongTien, id_HD);
    }

    //Lấy tổng tiền hóa đơn : Dựa vào SUM(hdct.thanhTien) --> Up lại tổng tiền hóa đơn.
    public long get_TongTien_HD_BY_IdHD(int Id_HD) {
        try {
            sql = "Select SUM(hdct.ThanhTien) as N'TongTien' from HoaDon hd\n"
                    + "INNER JOIN HoaDonCT hdct on hdct.ID_HoaDon = hd.ID_Hoadon\n"
                    + "where hd.ID_Hoadon = ?";
            rs = JDBCHelper.executeQuery(sql, Id_HD);
            rs.next();
            return (long) rs.getFloat("TongTien");
        } catch (SQLException ex) {
            Logger.getLogger(BanHang_HD_Service.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 1;
    }

    public HoaDon_M getHD_BY_MaHD(String maHD) {
        sql = "select * from HoaDon\n"
                + "where MaHD = ?";
        List<HoaDon_M> listHD = selectBySQL(sql, maHD);
        return (listHD != null && !listHD.isEmpty()) ? listHD.get(0) : null;
    }

//Insert Voucher
    public int insertVoucherForInvoice(int IDVoucher) {
        sql = "update HoaDon set HoaDon.ID_Voucher = ?";
        int result = JDBCHelper.excuteUpdate(sql, IDVoucher);
        return result;
    }

//CRUD dữ liệu    
    public int insertHD(HoaDon_M HoaDon) {
        sql = ""
                + "INSERT INTO HoaDon (MaHD , ID_Nhanvien , ID_KhachHang  , TrangThai )\n"
                + "VALUES \n"
                + "(?,?,?,?)";
        return JDBCHelper.excuteUpdate(sql,
                HoaDon.getMaHD(),
                HoaDon.getIdNV(),
                HoaDon.getIdKH(),
                HoaDon.getTrangThai()
        );
    }
//Truy xuất dữ liệu

    public HoaDon_M getHDByID(String maHD) {//2.Evt : khi click vào 1 HD --> fill lên in4 hóa đơn
        sql = "SELECT KH.ID_KhachHang , KH.TenKhachHang , HD.MaHD , NV.MaNhanVien , HD.NgayTao , \n"
                + "HD.TongTien , V.MaVoucher , KH.MaKhachHang\n"
                + "FROM HoaDon HD\n"
                + "INNER JOIN KhachHang KH on kh.ID_KhachHang = HD.ID_KhachHang\n"
                + "INNER JOIN NhanVien NV on NV.ID_Nhanvien = hd.ID_Nhanvien\n"
                + "LEFT JOIN Voucher V on V.ID_Voucher = hd.ID_Voucher\n"
                + "WHERE HD.MaHD = ? ";
        HoaDon_M hd = (selectBySQL(sql, maHD) != null && !selectBySQL(sql, maHD).isEmpty()) ? selectBySQL(sql, maHD).get(0) : null;
        return hd;
    }

    public List<HoaDon_M> getListHD() {//1.Fill hóa đơn lên bảng
        sql = ""
                + "SELECT HD.MaHD , NV.TenNhanVien ,KH.TenKhachHang ,HD.NgayTao , HD.TrangThai\n"
                + "FROM HoaDon HD\n"
                + "INNER JOIN KhachHang KH on kh.ID_KhachHang = HD.ID_KhachHang\n"
                + "INNER JOIN NhanVien NV on NV.ID_Nhanvien = hd.ID_Nhanvien\n"
                + "WHERE HD.TrangThai = N'Chờ thanh toán'";
        List<HoaDon_M> listHD = selectBySQL(sql);
        return listHD;
    }

    public List<HoaDon_M> selectBySQL(String sql, Object... args) {
        List<HoaDon_M> listHD = new ArrayList<>();
        try {
            rs = JDBCHelper.executeQuery(sql, args);
            ResultSetMetaData rsmd = rs.getMetaData();
//          để lấy ResultSetMetaData của ResultSet.
//          ResultSetMetaData cung cấp thông tin về các cột trong ResultSet.
            int columnCount = rsmd.getColumnCount();

            while (rs.next()) {
                HoaDon_M hd = new HoaDon_M();
                for (int i = 1; i <= columnCount; i++) {
                    String columnName = rsmd.getColumnName(i);
                    switch (columnName) {//Gán giá trị cho các thuộc tính của HoaDon dựa trên tên cột
                        case "ID_Hoadon":
                            hd.setIdHD(rs.getInt(i));
                            break;
                        case "ID_KhachHang":
                            hd.setIdKH(rs.getInt(i));
                            break;
                        case "ID_Nhanvien":
                            hd.setIdNV(rs.getInt(i));
                            break;
                        case "ID_Voucher":
                            hd.setIdVC(rs.getInt(i));
                            break;
                        case "MaHD":
                            hd.setMaHD(rs.getString(i));
                            break;
                        //---------------------------
                        case "NgayTao":
                            hd.setNgayTao(rs.getDate(i));
                            break;
                        case "TongTien":
                            hd.setTongTien(rs.getFloat(i));
                            break;
                        case "TrangThai":
                            hd.setTrangThai(rs.getString(i));
                            break;
                        case "GhiChu":
                            hd.setGhiChu(rs.getString(i));
                            break;
                        //---------------------------Diff
                        case "TenNhanVien":
                            hd.setTenNV(rs.getString(i));
                            break;
                        case "MaNhanVien":
                            hd.setMaNV(rs.getString(i));
                            break;
                        case "TenKhachHang":
                            hd.setTenKH(rs.getString(i));
                            break;
                        case "MaKhachHang":
                            hd.setMaKH(rs.getString(i));
                            break;
                    }
                }
                listHD.add(hd);
            }
            rs.getStatement().getConnection().close();
        } catch (SQLException ex) {
            Logger.getLogger(BanHang_HD_Service.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listHD;
    }
}
