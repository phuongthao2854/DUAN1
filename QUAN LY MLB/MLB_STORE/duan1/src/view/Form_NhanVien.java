/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.KhachHang;
import model.NhanVien;
import model.SanPham;
import service.NhanVien_Service;

/**
 *
 * @author
 */
public class Form_NhanVien extends javax.swing.JPanel {

    private NhanVien_Service ns = new NhanVien_Service();
    private DefaultTableModel model = new DefaultTableModel();
    private int index = -1;

    /**
     * Creates new form Form_1
     */
    public Form_NhanVien() {
        initComponents();
        cb_TrangThai.removeAllItems();
        cb_TrangThai.addItem("Đang làm việc");
        cb_TrangThai.addItem("Nghỉ việc");
        cb_GioiTinh.addItem("Nam");
        cb_GioiTinh.addItem("Nữ");
        cb_VaiTro.addItem("Quản lý");
        cb_VaiTro.addItem("Nhân viên");
        cb_LocTrangThai.addItem("Đang làm việc");
        cb_LocTrangThai.addItem("Nghỉ việc");
        this.fillTable(ns.getAll());
    }

    public void fillTable(List<NhanVien> list) {
        model = (DefaultTableModel) tbl_NhanVien.getModel();
        model.setRowCount(0);
        for (NhanVien nv : list) {
            model.addRow(nv.toDataRow());

        }

    }

    public void showForm(NhanVien nv) {
        index = tbl_NhanVien.getSelectedRow();
        txt_Ma.setText(tbl_NhanVien.getValueAt(index, 0).toString());
        txt_Ten.setText(tbl_NhanVien.getValueAt(index, 1).toString());
        String vt = (String) tbl_NhanVien.getValueAt(index, 2);
        if (vt.equals("Nhân viên")) {
            rd_NhanVien.setSelected(true);
        }
        if (vt.equals("Quản lý")) {
            rd_QuanLy.setSelected(true);
        }
        txt_TaiKhoan.setText(tbl_NhanVien.getValueAt(index, 3).toString());
        txt_MatKhau.setText(tbl_NhanVien.getValueAt(index, 4).toString());
        String gt = (String) tbl_NhanVien.getValueAt(index, 5);
        if (gt.equals("Nam")) {
            rd_Nam.setSelected(true);
        }
        if (gt.equals("Nữ")) {
            rd_Nu.setSelected(true);
        }
        txt_NgaySinh.setText(tbl_NhanVien.getValueAt(index, 6).toString());
        txt_DienThoai.setText(tbl_NhanVien.getValueAt(index, 7).toString());
        txt_Email.setText(tbl_NhanVien.getValueAt(index, 8).toString());
        txt_DiaChi.setText(tbl_NhanVien.getValueAt(index, 9).toString());
        cb_TrangThai.setSelectedItem(tbl_NhanVien.getValueAt(index, 10));

    }

    public boolean validateForm() {
        if (txt_Ma.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Mã nhân viên không được để trống !");
            return false;
        }
        if (txt_Ten.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Tên nhân viên không được để trống !");
            return false;
        }
        if (!rd_QuanLy.isSelected() && !rd_NhanVien.isSelected()) {
            JOptionPane.showMessageDialog(this, "Vai trò không được để trống !");
            return false;
        }
        if (txt_TaiKhoan.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Tài khoản không được để trống !");
            return false;
        }
        if (txt_MatKhau.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Mật khẩu không được để trống !");
            return false;
        }
        String pass = txt_MatKhau.getText();
        if(pass.length() < 8 || pass.length() > 12){
            JOptionPane.showMessageDialog(this, "Mật khẩu phải từ 8- 12 kí tự !");
            return false;
        }
      
        if (!rd_Nam.isSelected() && !rd_Nu.isSelected()) {
            JOptionPane.showMessageDialog(this, "Giới tính không được để trống !");
            return false;
        }
        if (txt_NgaySinh.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Ngày sinh không được để trống !");
            return false;
        } else {
            String ngay = txt_NgaySinh.getText();
            SimpleDateFormat dateForm = new SimpleDateFormat("yyyy-MM-dd");
            dateForm.setLenient(false);
            try {
                Date date = dateForm.parse(ngay);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Ngày sản xuất không đúng định dạng !");
                return false;
            }
        }

        if (txt_DienThoai.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Điện thoại không được để trống !");
            return false;
        }
        if (txt_Email.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Email không được để trống !");
            return false;
        }
        if (txt_DiaChi.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Địa chỉ không được để trống !");
            return false;
        }
        return true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        btn_Them = new javax.swing.JButton();
        btn_Sua = new javax.swing.JButton();
        btn_LamMoi = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_Ten = new javax.swing.JTextField();
        txt_TaiKhoan = new javax.swing.JTextField();
        txt_DiaChi = new javax.swing.JTextField();
        txt_Email = new javax.swing.JTextField();
        txt_Ma = new javax.swing.JTextField();
        rd_Nam = new javax.swing.JRadioButton();
        rd_Nu = new javax.swing.JRadioButton();
        txt_MatKhau = new javax.swing.JTextField();
        txt_DienThoai = new javax.swing.JTextField();
        txt_NgaySinh = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        rd_QuanLy = new javax.swing.JRadioButton();
        rd_NhanVien = new javax.swing.JRadioButton();
        cb_TrangThai = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        cb_GioiTinh = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        cb_VaiTro = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        cb_LocTrangThai = new javax.swing.JComboBox<>();
        jPanel6 = new javax.swing.JPanel();
        txt_TimKiem = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_NhanVien = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(1066, 710));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thiết lập thông tin nhân viên ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 16))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Mã NV : ");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Tên NV : ");

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        btn_Them.setBackground(new java.awt.Color(153, 204, 255));
        btn_Them.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_Them.setText("Thêm");
        btn_Them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThemActionPerformed(evt);
            }
        });

        btn_Sua.setBackground(new java.awt.Color(153, 204, 255));
        btn_Sua.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_Sua.setText("Sửa");
        btn_Sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SuaActionPerformed(evt);
            }
        });

        btn_LamMoi.setBackground(new java.awt.Color(153, 204, 255));
        btn_LamMoi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_LamMoi.setText("Làm mới ");
        btn_LamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_LamMoiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_Them, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(btn_Sua, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(btn_LamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btn_LamMoi, btn_Sua, btn_Them});

        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Them, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Sua)
                    .addComponent(btn_LamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 4, Short.MAX_VALUE))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btn_LamMoi, btn_Sua, btn_Them});

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Tài khoản : ");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Mật khẩu : ");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Giới tính : ");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Địa chỉ : ");

        txt_Ten.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txt_TaiKhoan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txt_DiaChi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txt_Email.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txt_Ma.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        buttonGroup1.add(rd_Nam);
        rd_Nam.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rd_Nam.setText("Nam ");

        buttonGroup1.add(rd_Nu);
        rd_Nu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rd_Nu.setText("Nữ ");

        txt_MatKhau.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txt_DienThoai.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txt_NgaySinh.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Điện thoại : ");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Ngày sinh : ");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Email : ");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("Trạng thái : ");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setText("Vai trò : ");

        buttonGroup2.add(rd_QuanLy);
        rd_QuanLy.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rd_QuanLy.setText("Quản lý");

        buttonGroup2.add(rd_NhanVien);
        rd_NhanVien.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rd_NhanVien.setText("Nhân viên ");

        cb_TrangThai.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cb_TrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addGap(40, 40, 40))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(27, 27, 27))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txt_Ten)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(rd_Nam)
                                    .addGap(41, 41, 41)
                                    .addComponent(rd_Nu))
                                .addComponent(txt_TaiKhoan)
                                .addComponent(txt_DiaChi)
                                .addComponent(txt_MatKhau, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE))
                            .addComponent(txt_Ma, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel4))
                .addGap(222, 222, 222)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13)
                            .addComponent(jLabel10))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_DienThoai)
                            .addComponent(txt_Email)
                            .addComponent(txt_NgaySinh)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(rd_QuanLy)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                                .addComponent(rd_NhanVien)
                                .addGap(73, 73, 73))
                            .addComponent(cb_TrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel7)
                    .addComponent(txt_DienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_Ma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_Ten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel8)
                    .addComponent(txt_NgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_TaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(txt_Email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_MatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(rd_NhanVien)
                        .addComponent(rd_QuanLy)
                        .addComponent(jLabel13))
                    .addComponent(jLabel4))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rd_Nam)
                            .addComponent(rd_Nu)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(cb_TrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(txt_DiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lọc ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setText("Giới tính : ");

        cb_GioiTinh.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cb_GioiTinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_GioiTinhActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setText("Vai trò : ");

        cb_VaiTro.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cb_VaiTro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_VaiTroActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setText("Trạng thái : ");

        cb_LocTrangThai.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cb_LocTrangThai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_LocTrangThaiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(cb_GioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cb_VaiTro, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(60, 60, 60)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cb_LocTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel11)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb_GioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_VaiTro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_LocTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        txt_TimKiem.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_TimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_TimKiemActionPerformed(evt);
            }
        });
        txt_TimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_TimKiemKeyReleased(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setText("Tìm kiếm :");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_TimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_TimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addGap(17, 17, 17))
        );

        tbl_NhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã NV", "Tên NV", "Vai trò ", "Tài khoản", "Mật khẩu", "Giới tính ", "Ngày Sinh", "SĐT", "Email", "Địa chỉ", "Trạng thái "
            }
        ));
        tbl_NhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_NhanVienMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_NhanVien);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_ThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThemActionPerformed
        //TODO add your handling code here:
        int chon = JOptionPane.showConfirmDialog(this, "Bạn có muốn thêm không ?", "Thêm nhân viên :", JOptionPane.YES_NO_CANCEL_OPTION,
                3, null);
        if (chon == 0) {
            if (validateForm()) {
                try {
                    String maNV = txt_Ma.getText();
                    if (ns.isMaNhanVien(maNV)) {
                        JOptionPane.showMessageDialog(this, "Mã nhân viên đã tồn tại !");
                        return;
                    } else if (ns.insertNV(this.readForm()) > 0) {
                        JOptionPane.showMessageDialog(this, "Thêm thành công!");
                        this.fillTable(ns.getAll());
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Thêm thất bại !");
                }
            }
        }
    }//GEN-LAST:event_btn_ThemActionPerformed
    NhanVien readForm() {
        String ma, ten, tk, mk, gt = null, ns, sdt, email, dc, vt = null, tt = null;
        ma = txt_Ma.getText().trim();
        ten = txt_Ten.getText().trim();
        tk = txt_TaiKhoan.getText().trim();
        mk = txt_MatKhau.getText().trim();
        if (rd_Nam.isSelected()) {
            gt = "Nam";
        } else if (rd_Nu.isSelected()) {
            gt = "Nữ";
        }
        ns = txt_NgaySinh.getText().trim();
        sdt = txt_DienThoai.getText().trim();
        email = txt_Email.getText().trim();
        dc = txt_DiaChi.getText().trim();
        if (rd_NhanVien.isSelected()) {
            vt = "Nhân viên";
        } else if (rd_QuanLy.isSelected()) {
            vt = "Quản lý";
        }
        tt = cb_TrangThai.getSelectedItem().toString();
        return new NhanVien(ma, ten, gt, ns, dc, email, sdt, tk, mk, vt, tt);
    }

    private void btn_LamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_LamMoiActionPerformed
        // TODO add your handling code here:
        txt_Ma.setText("");
        txt_Ten.setText("");
        txt_DiaChi.setText("");
        txt_DienThoai.setText("");
        txt_Email.setText("");
        txt_MatKhau.setText("");
        txt_NgaySinh.setText("");
        txt_TaiKhoan.setText("");
        buttonGroup1.clearSelection();
        buttonGroup2.clearSelection();

        index = -1;
    }//GEN-LAST:event_btn_LamMoiActionPerformed

    private void tbl_NhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_NhanVienMouseClicked
        // TODO add your handling code here:
        index = tbl_NhanVien.getSelectedRow();
        if (index > -1) {
            showForm(ns.getAll().get(index));
        }
    }//GEN-LAST:event_tbl_NhanVienMouseClicked

    private void btn_SuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SuaActionPerformed
        // TODO add your handling code here:
        int chon = JOptionPane.showConfirmDialog(this, "Bạn có muốn sửa không ?", "Sửa Nhân viên",
                JOptionPane.YES_NO_CANCEL_OPTION, 3, null);
        if (chon == 0) {
            if (index == -1) {
                JOptionPane.showMessageDialog(this, "Bạn chưa chọn dòng nào !");
            } else if (validateForm()) {//có chọn
                index = tbl_NhanVien.getSelectedRow();
                NhanVien nv = readForm();
                if (ns.updateNV(nv) > 0) {
                    JOptionPane.showMessageDialog(this, "Sửa thành công !");
                    this.fillTable(ns.getAll());
                } else {
                    JOptionPane.showMessageDialog(this, "Sửa thất bại !");
                }
            }
        }
    }//GEN-LAST:event_btn_SuaActionPerformed

    private void cb_GioiTinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_GioiTinhActionPerformed
        // TODO add your handling code here:
        String selectedGt = (String) cb_GioiTinh.getSelectedItem();

        // Gọi phương thức locTheoTt từ service để lọc danh sách nhân viên theo trạng thái đã chọn
        List<NhanVien> listNhanVien = ns.locGT(selectedGt);

        // Cập nhật bảng hiển thị danh sách nhân viên với danh sách đã lọc
        fillTable(listNhanVien);
    }//GEN-LAST:event_cb_GioiTinhActionPerformed

    private void cb_VaiTroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_VaiTroActionPerformed
        // TODO add your handling code here:
        String selectedVt = (String) cb_VaiTro.getSelectedItem();

        // Gọi phương thức locTheoTt từ service để lọc danh sách nhân viên theo trạng thái đã chọn
        List<NhanVien> listNhanVien = ns.locVT(selectedVt);

        // Cập nhật bảng hiển thị danh sách nhân viên với danh sách đã lọc
        fillTable(listNhanVien);
    }//GEN-LAST:event_cb_VaiTroActionPerformed

    private void cb_LocTrangThaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_LocTrangThaiActionPerformed
        // TODO add your handling code here:
        String selectedTt = (String) cb_LocTrangThai.getSelectedItem();

        // Gọi phương thức locTheoTt từ service để lọc danh sách nhân viên theo trạng thái đã chọn
        List<NhanVien> listNhanVien = ns.locTT(selectedTt);

        // Cập nhật bảng hiển thị danh sách nhân viên với danh sách đã lọc
        fillTable(listNhanVien);
    }//GEN-LAST:event_cb_LocTrangThaiActionPerformed

    private void txt_TimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_TimKiemActionPerformed
        // TODO add your handling code here:
        String searchText = txt_TimKiem.getText();

        // Thực hiện tìm kiếm dựa trên dữ liệu này
        // Ví dụ: Tìm kiếm trong danh sách nhân viên
        List<NhanVien> listNhanVien = ns.searchTenNV(searchText);

        // Cập nhật bảng hiển thị danh sách nhân viên với danh sách đã tìm kiếm
        fillTable(listNhanVien);

    }//GEN-LAST:event_txt_TimKiemActionPerformed

    private void txt_TimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_TimKiemKeyReleased
        // TODO add your handling code here:
        DefaultTableModel ob = (DefaultTableModel) tbl_NhanVien.getModel();
        TableRowSorter<DefaultTableModel> obj = new TableRowSorter<>(ob);
        tbl_NhanVien.setRowSorter(obj);
        obj.setRowFilter(RowFilter.regexFilter(txt_TimKiem.getText()));
    }//GEN-LAST:event_txt_TimKiemKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_LamMoi;
    private javax.swing.JButton btn_Sua;
    private javax.swing.JButton btn_Them;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JComboBox<String> cb_GioiTinh;
    private javax.swing.JComboBox<String> cb_LocTrangThai;
    private javax.swing.JComboBox<String> cb_TrangThai;
    private javax.swing.JComboBox<String> cb_VaiTro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rd_Nam;
    private javax.swing.JRadioButton rd_NhanVien;
    private javax.swing.JRadioButton rd_Nu;
    private javax.swing.JRadioButton rd_QuanLy;
    private javax.swing.JTable tbl_NhanVien;
    private javax.swing.JTextField txt_DiaChi;
    private javax.swing.JTextField txt_DienThoai;
    private javax.swing.JTextField txt_Email;
    private javax.swing.JTextField txt_Ma;
    private javax.swing.JTextField txt_MatKhau;
    private javax.swing.JTextField txt_NgaySinh;
    private javax.swing.JTextField txt_TaiKhoan;
    private javax.swing.JTextField txt_Ten;
    private javax.swing.JTextField txt_TimKiem;
    // End of variables declaration//GEN-END:variables
}
