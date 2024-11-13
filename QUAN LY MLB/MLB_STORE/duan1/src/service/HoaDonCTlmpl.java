/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import com.raven.event.HoaDonCTService;
import java.util.List;
import model.HoaDonCT;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class HoaDonCTlmpl implements HoaDonCTService {

    List<HoaDonCT> listHDCT = new ArrayList<>();

    @Override
    public List<HoaDonCT> getHoaDonCTAll(int idHDCT) {
        listHDCT.clear();
        try {
            String sql = "SELECT \n"
                    + "    ct.ID_HoaDonCT,  \n"
                    + "    sp.MaSanPham,  \n"
                    + "    sp.TenSP,  \n"
                    + "    ms.TenMauSac,  \n"
                    + "    cl.TenChatLieu, \n"
                    + "    sz.TenSize, \n"
                    + "    ct.GiaBan,  \n"
                    + "    ct.SoLuongMua,  \n"
                    + "    ct.ThanhTien  \n"
                    + "FROM \n"
                    + "    HoaDonCT ct\n"
                    + "JOIN \n"
                    + "    HoaDon hd ON ct.ID_HoaDon = hd.ID_Hoadon\n"
                    + "JOIN \n"
                    + "    SanPham sp ON ct.ID_SanPham = sp.ID_SanPham\n"
                    + "JOIN \n"
                    + "    MauSac ms ON sp.ID_MauSac = ms.ID_MauSac\n"
                    + "JOIN \n"
                    + "    ChatLieu cl ON sp.ID_ChatLieu = cl.ID_ChatLieu\n"
                    + "JOIN \n"
                    + "    Size sz ON sp.ID_Size = sz.ID_Size;";
            Connection conn = DBConnect.getConnection();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                HoaDonCT hdct = new HoaDonCT();
                hdct.setId_HD(rs.getInt("ID_HoaDonCT"));
                hdct.setMa_SPCT(rs.getString("MaSanPham"));
                hdct.setTenSP(rs.getString("TenSP"));
                hdct.setSoLuong(rs.getInt("SoLuongMua"));
                hdct.setGiaban(rs.getFloat("GiaBan"));
                hdct.setMauSac(rs.getString("TenMauSac"));
                hdct.setChatLieu(rs.getString("TenChatLieu"));
                hdct.setKichCo(rs.getString("TenSize"));
                hdct.setThanhTien(rs.getInt("ThanhTien"));
                listHDCT.add(hdct);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listHDCT;
    }

    @Override
    public void addHoaDonCT(HoaDonCT hdct) {
        try {
            String sql = "insert into HoaDonCT (ID_HoaDon, ID_SanPham, GiaBan, SoLuongMua, ThanhTien) values (?,?,?,?,?)";
            Connection conn = DBConnect.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, hdct.getId_HD());
            ps.setInt(2, hdct.getId_SP());
            ps.setFloat(3, hdct.getGiaban());
            ps.setInt(4, hdct.getSoLuong());
            ps.setFloat(5, hdct.getThanhTien());
            ps.executeUpdate();
            conn.close();;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<HoaDonCT> getSanPhamTonTai(int id_HD, int id_SP) {
        listHDCT.clear();
        try {
            String sql = "select ct.ID_HoaDonCT , TenSP, sp.GiaBan, ct.SoLuongMua, hd.ThanhTien from HoaDonCT ct \n"
                    + "join SanPham sp on ct.ID_SanPham = sp.ID_SanPham \n"
                    + "join HoaDon hd on ct.ID_HoaDon = hd.ID_HoaDon \n"
                    + "Where hd.ID_HoaDon = ? and sp.ID_SanPham = ? ";
            Connection conn = DBConnect.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id_HD);
            ps.setInt(2, id_SP);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDonCT hdct = new HoaDonCT();
                hdct.setId_HD(rs.getInt(1));
                hdct.setTenSP(rs.getString(2));
                hdct.setGiaban(rs.getFloat(3));
                hdct.setSoLuong(rs.getInt(4));
                hdct.setThanhTien(rs.getFloat(5));
                listHDCT.add(hdct);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listHDCT;
    }

    @Override
    public void gopSanPhamTonTai(int idHDCT, int soLuongMua, float ThanhTien) {
        try {
            String sql = " Update HoaDonCT set SoLuongMua = ?, ThanhTien = ? where ID_HoaDonCT = ? ";
            Connection conn = DBConnect.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, soLuongMua);
            ps.setFloat(2, ThanhTien);
            ps.setInt(3, idHDCT);
            ps.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public HoaDonCT getRowHDCT(int row) {
        return listHDCT.get(row);
    }

    @Override
    public void deleteHDCT(int idHDCT) {
        try {
            String sql = "Delete from HoaDonCT where ID_HoaDonCT = ?";
            Connection conn = DBConnect.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idHDCT);
            ps.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
