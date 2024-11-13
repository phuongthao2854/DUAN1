package service;

import DAO.JDBCHelper;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.HoaDonChiTiet_M;

public class BanHang_HDCT_Service {

    private ResultSet rs = null;
    private String sql = null;

    //Lây HĐCT theo ID_HĐCT
    public HoaDonChiTiet_M getHDCT_BY_Id_HDCT(int id_HDCT) {
        sql = ""
                + "select * from HoaDonCT\n"
                + "where ID_HoaDonCT = ?";
        List<HoaDonChiTiet_M> listHDCT = selectBySQL(sql, id_HDCT);
        if (listHDCT != null && !listHDCT.isEmpty()) {
            return listHDCT.get(0);
        }
        throw new ArithmeticException("Lỗi ko truy vấn ra đc HĐCT theo ID_HĐCT");
    }

    //Fill Giỏ hàng bởi Id_HĐ
    public List<HoaDonChiTiet_M> getList_HDCT_BY_IdHD(int Id_HD) {
        sql = "SELECT hdct.ID_HoaDonCT , sp.MaSanPham , sp.TenSP , hdct.SoLuongMua , hdct.GiaBan , hdct.ThanhTien FROM HoaDonCT hdct \n"
                + "INNER JOIN HoaDon hd on hdct.ID_HoaDon = hd.ID_Hoadon\n"
                + "INNER JOIN SanPham sp on hdct.ID_SanPham =  sp.ID_SanPham \n"
                + "where hd.ID_Hoadon  = ?";
        return selectBySQL(sql, Id_HD);
    }

    //-------CRUD-------------
    public int insertHDCT(HoaDonChiTiet_M hdct) {
        sql = "INSERT INTO HoaDonCT (ID_HoaDon , ID_SanPham , GiaBan , SoLuongMua , ThanhTien ) \n"
                + "VALUES ( ? , ? , ? , ? , ? ) ";
        int result = JDBCHelper.excuteUpdate(sql,
                hdct.getId_HD(),
                hdct.getId_SP(),
                hdct.getGiaBan(),
                hdct.getSoLuongMua(),
                hdct.getThanhTien()
        );
        return result;
    }

    public int updateSL_HDCT(int idHDCT, int SL, long thanhTien) {
        sql = "update HoaDonCT\n"
                + "set SoLuongMua = ? , ThanhTien = ? \n"
                + "where ID_HoaDonCT = ?";
        int result = JDBCHelper.excuteUpdate(sql, SL, thanhTien, idHDCT);
        return result;
    }

    public int delete_HDCT(int idHDCT) {
        sql = "delete HoaDonCT\n"
                + "where ID_HoaDonCT = ?";
        int result = JDBCHelper.excuteUpdate(sql, idHDCT);
        return result;
    }
    //-------CRUD-------------

    public HoaDonChiTiet_M getHDCT_BY_IdHD_IdSP(int id_HD, int idSP) {//Kiểm tra tồn tại trong giỏ hàng
        sql = "select * from HoaDonCT\n"
                + "where ID_HoaDon = ? and ID_SanPham = ?";
        List<HoaDonChiTiet_M> list_HDCT = selectBySQL(sql, id_HD, idSP);
        if (list_HDCT != null && !list_HDCT.isEmpty()) {
            return list_HDCT.get(0);
        } else {
            return null;
        }
    }

    public List<HoaDonChiTiet_M> selectBySQL(String sql, Object... args) {
        List<HoaDonChiTiet_M> listHDCT = new ArrayList<>();
        try {
            rs = JDBCHelper.executeQuery(sql, args);
            ResultSetMetaData rsmd = rs.getMetaData();
//          để lấy ResultSetMetaData của ResultSet.
//          ResultSetMetaData cung cấp thông tin về các cột trong ResultSet.
            int columnCount = rsmd.getColumnCount();

            while (rs.next()) {
                HoaDonChiTiet_M hd = new HoaDonChiTiet_M();
                for (int i = 1; i <= columnCount; i++) {
                    String columnName = rsmd.getColumnName(i);
                    switch (columnName) {//Gán giá trị cho các thuộc tính của HoaDon dựa trên tên cột
                        case "ID_HoaDonCT":
                            hd.setId_HDCT(rs.getInt(i));
                            break;
                        case "ID_HoaDon":
                            hd.setId_HD(rs.getInt(i));
                            break;
                        case "ID_SanPham":
                            hd.setId_SP(rs.getInt(i));
                            break;
                        case "GiaBan":
                            hd.setGiaBan(rs.getFloat(i));
                            break;
                        case "SoLuongMua":
                            hd.setSoLuongMua(rs.getInt(i));
                            break;
                        //---------------------------
                        case "ThanhTien":
                            hd.setThanhTien(rs.getFloat(i));
                            break;
                        case "MaSanPham":
                            hd.setMaSP(rs.getString(i));
                            break;
                        case "TenSP":
                            hd.setTenSP(rs.getString(i));
                            break;
                    }
                }
                listHDCT.add(hd);
            }
            rs.getStatement().getConnection().close();
        } catch (SQLException ex) {
            Logger.getLogger(BanHang_HDCT_Service.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listHDCT;
    }
}
