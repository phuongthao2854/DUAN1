package component;

import DAO.MSGHelper;
import java.awt.Color;
import java.awt.Font;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.KhachHang;
import service.KhachHang_Service;
import view.Form_BanHang;

public class KhachHang_List extends javax.swing.JDialog {

    private KhachHang_Service kh = new KhachHang_Service();
    private DefaultTableModel model = new DefaultTableModel();
    public static String maKH;
    private int index = -1;
    private String maHD;
    private Form_BanHang Obj_UI_Sell;

    public KhachHang_List(Form_BanHang Obj_UI_Sell, String maHD) {
        initComponents();
        setLocationRelativeTo(null);
        this.maHD = maHD;
        this.Obj_UI_Sell = Obj_UI_Sell;
        init();
    }

    public void fillTable(List<KhachHang> list) {
        model = (DefaultTableModel) tbl_KhachHang.getModel();
        model.setRowCount(0);
        for (KhachHang kh : list) {
            model.addRow(kh.todataRow());

        }

    }

    public void showForm(KhachHang kh) {
        index = tbl_KhachHang.getSelectedRow();
        txt_Ma.setText(tbl_KhachHang.getValueAt(index, 0).toString());
        txt_TenKH.setText(tbl_KhachHang.getValueAt(index, 1).toString());
        String gt = (String) tbl_KhachHang.getValueAt(index, 2);
        if (gt.equals("Nam")) {
            rd_Nam.setSelected(true);
        }
        if (gt.equals("Nữ")) {
            rd_Nu.setSelected(true);
        }
        txt_SDT.setText(tbl_KhachHang.getValueAt(index, 3).toString());
        txt_DiaChi.setText(tbl_KhachHang.getValueAt(index, 4).toString());

    }

    public boolean validateForm() {
        if (txt_Ma.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ma khong duoc de trong");
            return false;
        }
        if (txt_TenKH.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ho ten khong duoc de trong");
            return false;
        }
        if (txt_SDT.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "SDT khong duoc de trong!");
            return false;
        }
        if (txt_DiaChi.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Dia chi khong duoc de trong!");
            return false;
        }
        if (!rd_Nam.isSelected() && !rd_Nu.isSelected()) {
            JOptionPane.showMessageDialog(this, "Vai tro khong duoc de trong !");
            return false;
        }
        return true;

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        panel_Tong = new javax.swing.JTabbedPane();
        pn_DanhSach = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_KhachHang = new javax.swing.JTable();
        btn_ChonKH = new javax.swing.JButton();
        txt_searchSPCT = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        pn_CapNhatKH = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_Ma = new javax.swing.JTextField();
        txt_TenKH = new javax.swing.JTextField();
        txt_SDT = new javax.swing.JTextField();
        txt_DiaChi = new javax.swing.JTextField();
        btn_Them = new javax.swing.JButton();
        btn_Sua = new javax.swing.JButton();
        btn_LamMoi = new javax.swing.JButton();
        rd_Nam = new javax.swing.JRadioButton();
        rd_Nu = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Khách hàng");

        pn_DanhSach.setBackground(new java.awt.Color(255, 255, 255));

        tbl_KhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID_KH", "Mã KH", "Tên KH", "Giới tính", "SĐT", "Địa chỉ"
            }
        ));
        tbl_KhachHang.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tbl_KhachHangFocusLost(evt);
            }
        });
        tbl_KhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_KhachHangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_KhachHang);

        btn_ChonKH.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_ChonKH.setText("Chọn ");
        btn_ChonKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ChonKHActionPerformed(evt);
            }
        });

        txt_searchSPCT.setForeground(java.awt.Color.gray);
        txt_searchSPCT.setText("Tìm kiếm khách hàng theo ID , Mã KH , SĐT ....");
        txt_searchSPCT.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(51, 51, 255)));
        txt_searchSPCT.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_searchSPCTFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_searchSPCTFocusLost(evt);
            }
        });
        txt_searchSPCT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_searchSPCTKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout pn_DanhSachLayout = new javax.swing.GroupLayout(pn_DanhSach);
        pn_DanhSach.setLayout(pn_DanhSachLayout);
        pn_DanhSachLayout.setHorizontalGroup(
            pn_DanhSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_DanhSachLayout.createSequentialGroup()
                .addGap(301, 301, 301)
                .addComponent(btn_ChonKH, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(289, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_DanhSachLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(pn_DanhSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 637, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_searchSPCT, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );
        pn_DanhSachLayout.setVerticalGroup(
            pn_DanhSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_DanhSachLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(txt_searchSPCT, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_ChonKH, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        panel_Tong.addTab("Danh sách khách hàng ", pn_DanhSach);

        pn_CapNhatKH.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Mã khách hàng : ");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Tên khách hàng : ");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Giới tính : ");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Số điện thoại : ");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Địa chỉ : ");

        txt_Ma.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txt_TenKH.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txt_SDT.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txt_DiaChi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_DiaChi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_DiaChiActionPerformed(evt);
            }
        });

        btn_Them.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_Them.setText("Thêm ");
        btn_Them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThemActionPerformed(evt);
            }
        });

        btn_Sua.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_Sua.setText("Sửa");
        btn_Sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SuaActionPerformed(evt);
            }
        });

        btn_LamMoi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_LamMoi.setText("Làm mới ");
        btn_LamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_LamMoiActionPerformed(evt);
            }
        });

        buttonGroup1.add(rd_Nam);
        rd_Nam.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rd_Nam.setText("Nam");

        buttonGroup1.add(rd_Nu);
        rd_Nu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rd_Nu.setText("Nữ");

        javax.swing.GroupLayout pn_CapNhatKHLayout = new javax.swing.GroupLayout(pn_CapNhatKH);
        pn_CapNhatKH.setLayout(pn_CapNhatKHLayout);
        pn_CapNhatKHLayout.setHorizontalGroup(
            pn_CapNhatKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_CapNhatKHLayout.createSequentialGroup()
                .addGroup(pn_CapNhatKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_CapNhatKHLayout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addGroup(pn_CapNhatKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(pn_CapNhatKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_TenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_Ma, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_SDT, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_DiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pn_CapNhatKHLayout.createSequentialGroup()
                                .addComponent(rd_Nam, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(rd_Nu, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_CapNhatKHLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btn_Them, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_Sua)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_LamMoi)))
                .addContainerGap(149, Short.MAX_VALUE))
        );
        pn_CapNhatKHLayout.setVerticalGroup(
            pn_CapNhatKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_CapNhatKHLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(pn_CapNhatKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_Ma, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(pn_CapNhatKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_TenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pn_CapNhatKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(rd_Nam)
                    .addComponent(rd_Nu))
                .addGap(18, 18, 18)
                .addGroup(pn_CapNhatKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_SDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pn_CapNhatKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txt_DiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(pn_CapNhatKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Them, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Sua)
                    .addComponent(btn_LamMoi))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 678, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pn_CapNhatKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 353, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pn_CapNhatKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        panel_Tong.addTab("Cập nhật lhách hàng ", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_Tong)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_Tong)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_ChonKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ChonKHActionPerformed
        if (indexRowSelected != -1) {
            //Gọi tới đối tượng của giao diện kia 
            //Truyền tới thông tin MaHD , id_KH cần update
            //Thực hiện đóng giao diện này
            this.Obj_UI_Sell.update_HD_With_Id_KH(maHD, id_KH);
            this.dispose();
        } else {
            MSGHelper.alert(this, "Vui lòng chọn khách hàng");
        }
    }//GEN-LAST:event_btn_ChonKHActionPerformed

    private void tbl_KhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_KhachHangMouseClicked
        this.indexRowSelected = tbl_KhachHang.getSelectedRow();
        this.id_KH = Integer.valueOf(String.valueOf(dtm_KH.getValueAt(this.indexRowSelected, 0)));
         index = tbl_KhachHang.getSelectedRow();
        if (index > -1) {
            showForm(kh.getAll().get(index));
        }
    }//GEN-LAST:event_tbl_KhachHangMouseClicked

    private void txt_searchSPCTFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_searchSPCTFocusGained
        //Sự kiện xảy ra khi thành phần txt_timKiemSP UI nhận đc trạng thái focus.
        if (txt_searchSPCT.getText().equals("Tìm kiếm khách hàng theo ID , Mã KH , SĐT ....")) {
            txt_searchSPCT.setText(null);
            txt_searchSPCT.requestFocus(); //Yêu cầu tập trung Focus vào 1 component nào đó.
            //remove placeholder style
            removePlaceholderStyle(txt_searchSPCT);
            //TH Focus vào search --> Bỏ focust ở bảng.
            this.tbl_KhachHang.clearSelection();
            this.indexRowSelected = -1;
            this.id_KH = 0;
        }
    }//GEN-LAST:event_txt_searchSPCTFocusGained

    private void txt_searchSPCTFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_searchSPCTFocusLost
        //Sự kiện xảy ra khi thành phần txt_timKiemSP UI nhận đc trạng thái focusLost.
        if (txt_searchSPCT.getText().length() == 0) {
            //add Placeholder style
            addPlaceholderStyle(txt_searchSPCT);
            txt_searchSPCT.setText("Tìm kiếm khách hàng theo ID , Mã KH , SĐT ....");
        } else {
            txt_searchSPCT.setColumns(25); // Số lượng ký tự hiển thị
        }
    }//GEN-LAST:event_txt_searchSPCTFocusLost

    private void txt_searchSPCTKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_searchSPCTKeyReleased
        String searchString = txt_searchSPCT.getText();
        dtm_KH = (DefaultTableModel) this.tbl_KhachHang.getModel();
        search(searchString, dtm_KH, this.tbl_KhachHang);
    }//GEN-LAST:event_txt_searchSPCTKeyReleased

    private void tbl_KhachHangFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tbl_KhachHangFocusLost

    }//GEN-LAST:event_tbl_KhachHangFocusLost

    private void txt_DiaChiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_DiaChiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_DiaChiActionPerformed

    private void btn_ThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThemActionPerformed
        // TODO add your handling code here:
        int chon = JOptionPane.showConfirmDialog(this, "Bạn có muốn thêm không ?", "Thêm khách hàng :", JOptionPane.YES_NO_CANCEL_OPTION,
                3, null);
        if (chon == 0) {
            if (validateForm()) {
                try {
                    String maKH = txt_Ma.getText();
                    if (kh.isMaKhachHang(maKH)) {
                        JOptionPane.showMessageDialog(this, "Mã khách hàng đã tồn tại !");
                        return;
                    } else if (kh.insertKH(this.readForm()) > 0) {
                        JOptionPane.showMessageDialog(this, "Thêm thành công!");
                        this.fillTable(kh.getAll());
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Thêm thất bại !");
                }
            }
        }
    }//GEN-LAST:event_btn_ThemActionPerformed

    private void btn_SuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SuaActionPerformed
        // TODO add your handling code here:
        if (index == -1) {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn dòng nào !");
        } else if (validateForm()) {//có chọn
            index = tbl_KhachHang.getSelectedRow();
            KhachHang hh = readForm();
            if (kh.updateKH(hh) > 0) {
                JOptionPane.showMessageDialog(this, "Cập nhật thành công !");
                this.fillTable(kh.getAll());
            } else {
                JOptionPane.showMessageDialog(this, "Cập nhật thất bại !");
            }
        }
    }//GEN-LAST:event_btn_SuaActionPerformed

    private void btn_LamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_LamMoiActionPerformed
        // TODO add your handling code here:
        txt_Ma.setText("");
        txt_TenKH.setText("");
        txt_SDT.setText("");
        txt_DiaChi.setText("");
        buttonGroup1.clearSelection();
        index = -1;
    }//GEN-LAST:event_btn_LamMoiActionPerformed
    KhachHang readForm() {
        String ma, ten, sdt, diachi, gt = null;
        ma = txt_Ma.getText().trim();
        ten = txt_TenKH.getText().trim();
        sdt = txt_SDT.getText().trim();
        diachi = txt_DiaChi.getText().trim();
        if (rd_Nam.isSelected()) {
            gt = "Nam";
        } else if (rd_Nu.isSelected()) {
            gt = "Nữ";
        }
        return new KhachHang(ma, ten, gt, sdt, diachi);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_ChonKH;
    private javax.swing.JButton btn_LamMoi;
    private javax.swing.JButton btn_Sua;
    private javax.swing.JButton btn_Them;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane panel_Tong;
    private javax.swing.JPanel pn_CapNhatKH;
    private javax.swing.JPanel pn_DanhSach;
    private javax.swing.JRadioButton rd_Nam;
    private javax.swing.JRadioButton rd_Nu;
    private javax.swing.JTable tbl_KhachHang;
    private javax.swing.JTextField txt_DiaChi;
    private javax.swing.JTextField txt_Ma;
    private javax.swing.JTextField txt_SDT;
    private javax.swing.JTextField txt_TenKH;
    private javax.swing.JTextField txt_searchSPCT;
    // End of variables declaration//GEN-END:variables
    private DefaultTableModel dtm_KH;
    private int indexRowSelected = -1;
    private int id_KH = 0;
    private KhachHang_Service khs = new KhachHang_Service();

    private void init() {
        fill_ALL_KH();
    }

    public void fill_ALL_KH() {
        List<KhachHang> listKH = khs.getAll();
        fill_Tabel_KH(listKH);
    }

    //Hàm chung
    public void fill_Tabel_KH(List<KhachHang> list) {
        dtm_KH = (DefaultTableModel) tbl_KhachHang.getModel();
        dtm_KH.setRowCount(0);
        for (KhachHang kh : list) {
            // Kiểm tra nếu mã khách hàng không phải là "KH01" thì mới thêm vào bảng
            if (!kh.getMa().equals("KH01")) {
                dtm_KH.addRow(kh.todataRow());
            }
        }
    }

    //Search------------------------------------------------------------------------
    public void search(String str, DefaultTableModel dtmTable, JTable table) {
        dtmTable = (DefaultTableModel) table.getModel();
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(dtmTable); //Tạo 1 TablerowSorter và liên kết với bảng DTM. TableRowSoft : Quản lý việc sắp xếp và lọc các hàng trong JTable.
        table.setRowSorter(trs); //Gán TableRowSorter vừa tạo cho JTable. -> Kích hoạt việc sắp xếp và lọc cho JTable. 
        //Sử dụng biểu thức chính quy để không phân biệt chữ hoa chữ thường
        Pattern pattern = Pattern.compile(Pattern.quote(str), Pattern.CASE_INSENSITIVE);
//        trs.setRowFilter(RowFilter.regexFilter(str));//Đặc bộ lọc cho TableRowSorter để thực hiện tìm kiếm dựa trên biểu thức chính quy ( Regex ). Nó sẽ tạo 1 bộ lọc dựa trên chuỗi str.
        trs.setRowFilter(new RowFilter<DefaultTableModel, Object>() {
            @Override
            public boolean include(RowFilter.Entry<? extends DefaultTableModel, ? extends Object> entry) {
                // Duyệt qua từng cột trong hàng
                for (int i = entry.getValueCount() - 1; i >= 0; i--) {
                    Object value = entry.getValue(i);
                    if (value != null) {
                        // Kiểm tra nếu giá trị của cột chứa ký tự tìm kiếm
                        Matcher matcher = pattern.matcher(value.toString());
                        if (matcher.find()) {
                            return true;
                        }
                    }
                }
                return false;
            }
        });
    }

    private void removePlaceholderStyle(JTextField txt_searchSPCT) {
        Font font = txt_searchSPCT.getFont();
        font = font.deriveFont(Font.PLAIN);
        txt_searchSPCT.setFont(font);
        txt_searchSPCT.setForeground(Color.BLACK);
    }

    private void addPlaceholderStyle(JTextField txt_searchSPCT) {
        Font font = txt_searchSPCT.getFont();//Lấy font hiện tại của JTextField
        font = font.deriveFont(Font.ITALIC);//Tạo 1 bản sao mới của Font với kiểu in nghiêng ( Italic )
        txt_searchSPCT.setFont(font); //Đặt font mới cho JTextField
        txt_searchSPCT.setForeground(Color.GRAY); //Đặt màu chữ là Gray ( Xám ) 
    }

}
