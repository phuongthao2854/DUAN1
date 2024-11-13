  /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.List;
import model.NhanVien;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class NhanVien_Service {

    private List<NhanVien> listNV;
    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private String sql = null;

    public List<NhanVien> getAll() {
        listNV = new ArrayList<>();
        sql = "select MaNhanVien, TenNhanVien, VaiTro, TaiKhoan, MatKhau, GioiTinh, NgaySinh, SDT, Email, DiaChi, TrangThai from NhanVien";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                NhanVien nv = new NhanVien(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
                        rs.getString(10), rs.getString(11)
                );
                listNV.add(nv);
            }
            return listNV;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int insertNV(NhanVien nv) {
        int kq = 0;
        sql = "insert into NhanVien (MaNhanVien, TenNhanVien, VaiTro, TaiKhoan, MatKhau, GioiTinh, NgaySinh, SDT, Email, DiaChi, TrangThai) values (?,?,?,?,?,?,?,?,?,?,?)";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, nv.getMa());
            ps.setString(2, nv.getTen());
            ps.setString(3, nv.getVaiTro());
            ps.setString(4, nv.getTaiKhoan());
            ps.setString(5, nv.getMatKhau());
            ps.setString(6, nv.getGioiTinh());
            ps.setString(7, nv.getNgaySinh());
            ps.setString(8, nv.getSdt());
            ps.setString(9, nv.getEmail());
            ps.setString(10, nv.getDiaChi());
            ps.setString(11, nv.getTrangThai());
            kq = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            kq = 0;
        }
        return kq;
    }

    public boolean isMaNhanVien(String ma) {
        con = DBConnect.getConnection();
        sql = " select count(*) from NhanVien where MaNhanVien like ?";
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

    public int updateNV(NhanVien nv) {
        int kq = 0;
        sql = "update NhanVien set TenNhanVien = ?, VaiTro = ?, TaiKhoan = ?, MatKhau = ?, GioiTinh = ?, NgaySinh = ?, SDT = ?, Email = ?, DiaChi = ?, TrangThai = ? where MaNhanVien like ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(11, nv.getMa());
            ps.setString(1, nv.getTen());
            ps.setString(2, nv.getVaiTro());
            ps.setString(3, nv.getTaiKhoan());
            ps.setString(4, nv.getMatKhau());
            ps.setString(5, nv.getGioiTinh());
            ps.setString(6, nv.getNgaySinh());
            ps.setString(7, nv.getSdt());
            ps.setString(8, nv.getEmail());
            ps.setString(9, nv.getDiaChi());
            ps.setString(10, nv.getTrangThai());
            kq = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            kq = 0;
        }
        return kq;
    }
    public List<NhanVien> TimKiem(String ma) {
        listNV = new ArrayList<>();
        sql = "SELECT MaNhanVien, TenNhanVien, VaiTro, TaiKhoan, MatKhau, GioiTinh, NgaySinh, SDT, Email, DiaChi, TrangThai FROM NhanVien WHERE MaNhanVien like ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, ma);
            rs = ps.executeQuery();
            while (rs.next()) {
                 NhanVien nv = new NhanVien(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
                        rs.getString(10), rs.getString(11)
                );
                listNV.add(nv);
            }
            return listNV;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public List<NhanVien> locGT(String gioitinh) {
        listNV = new ArrayList<>();
        con = DBConnect.getConnection();
        sql = "select MaNhanVien, TenNhanVien, VaiTro, TaiKhoan, MatKhau, GioiTinh, NgaySinh, SDT, Email, DiaChi, TrangThai from NhanVien where GioiTinh like ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, gioitinh);
            rs = ps.executeQuery();
            while (rs.next()) {

                NhanVien nv = new NhanVien(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
                        rs.getString(10), rs.getString(11)
                );
                listNV.add(nv);  
            }// đóng while 

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return listNV;
    }
    public List<NhanVien> locVT(String vaitro) {
        listNV = new ArrayList<>();
        con = DBConnect.getConnection();
        sql = "select MaNhanVien, TenNhanVien, VaiTro, TaiKhoan, MatKhau, GioiTinh, NgaySinh, SDT, Email, DiaChi, TrangThai from NhanVien where VaiTro like ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, vaitro);
            rs = ps.executeQuery();
            while (rs.next()) {

                NhanVien nv = new NhanVien(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
                        rs.getString(10), rs.getString(11)
                );
                listNV.add(nv);  
            }// đóng while 

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return listNV;
    }
     public List<NhanVien> locTT(String trangthai) {
        listNV = new ArrayList<>();
        con = DBConnect.getConnection();
        sql = "select MaNhanVien, TenNhanVien, VaiTro, TaiKhoan, MatKhau, GioiTinh, NgaySinh, SDT, Email, DiaChi, TrangThai from NhanVien where TrangThai like ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, trangthai);
            rs = ps.executeQuery();
            while (rs.next()) {

                NhanVien nv = new NhanVien(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
                        rs.getString(10), rs.getString(11)
                );
                listNV.add(nv);  
            }// đóng while 

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return listNV;
    }
    
     public List<NhanVien> searchTenNV(String ten) {
        listNV = new ArrayList<>();
        con = DBConnect.getConnection();
        sql = "select MaNhanVien, TenNhanVien, VaiTro, TaiKhoan, MatKhau, GioiTinh, NgaySinh, SDT, Email, DiaChi, TrangThai from NhanVien where TenNhanVien like ? ";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + ten + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                // public HangHoa(long id, String ma, String ten, double donGia, int soLuong, String donVT, int xuatXu) {
                 NhanVien nv = new NhanVien(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
                        rs.getString(10), rs.getString(11)
                );
                listNV.add(nv);  
            }// đóng while 

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return listNV;
    }
     public List<NhanVien> getByEmail(String email) {
        listNV = new ArrayList<>();
        sql = "SELECT MaNhanVien, TenNhanVien, VaiTro, TaiKhoan, MatKhau, GioiTinh, NgaySinh, SDT, Email, DiaChi, TrangThai FROM NhanVien WHERE Email like ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql); 
            ps.setString(1, email);
            rs = ps.executeQuery();
            while (rs.next()) {
                 NhanVien nv = new NhanVien(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
                        rs.getString(10), rs.getString(11)
                );
                listNV.add(nv);
            }
            return listNV;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
