/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import com.raven.event.ThuocTinhlmpl;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.ChatLieu;
import model.DanhMuc;
import model.KichCo;
import model.MauSac;
import model.SanPham;
import service.ChatLieu_Service;
import service.DanhMuc_Service;
import service.KichCo_Service;
import service.MauSac_Service;
import service.SanPham_Service;
import service.ThuocTinh_Service;

/**
 *
 * @author RAVEN
 */
public class Form_SanPham extends javax.swing.JPanel {

    KichCo_Service ks = new KichCo_Service();
    ChatLieu_Service cs = new ChatLieu_Service();
    MauSac_Service ms = new MauSac_Service();
    DanhMuc_Service ds = new DanhMuc_Service();
    SanPham_Service ss = new SanPham_Service();
    DefaultTableModel model = new DefaultTableModel();
    int index = -1;

    /**
     * Creates new form Form_1
     */
    DefaultTableModel modeltt;
    ThuocTinhlmpl svTT = new ThuocTinh_Service();

    public Form_SanPham() {
        initComponents();
        cb_LocTT.removeAllItems();
        cb_LocTT.addItem("Đang bán");
        cb_LocTT.addItem("Dừng bán");
        fillSanPham(ss.getAll());
        fillSize(ks.getAll());
        fillChatLieu(cs.getAll());
        fillMauSac(ms.getAll());
        fillDanhMuc(ds.getAll());
        fillLocSize(ks.getAll());
        fillLocChatLieu(cs.getAll());
        fillLocMauSac(ms.getAll());
        fillLocDanhMuc(ds.getAll());
        this.fillTable(ss.getAll());
    }
    
//    Viết hàm fill riêng cho SP ko nên lấy hàm đó bên bán hàng. Ví để các ui ko phụ thuộc vào nhau.
    SanPham_Service dataSP = new SanPham_Service();
    public void fillSanPham(List<SanPham> list) {
        dataSP.getAll();
        model.setRowCount(0);
        model = (DefaultTableModel) tbl_SanPham.getModel();
        for (SanPham sp : list) {
            model.addRow(sp.toDataRow());
        }
    }
    
    public void fillTable(List<SanPham> list) {
        model = (DefaultTableModel) tbl_SanPham.getModel();
        model.setRowCount(0);
        for (SanPham sp : list) {
            model.addRow(sp.toDataRow());
            
        }

    }

    public void fillSize(List<KichCo> listKC) {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cb_KichThuoc.getModel();
        model.removeAllElements();
        for (KichCo kc : listKC) {
            model.addElement(kc.getTen());
        }
    }

    public void fillLocSize(List<KichCo> listLS) {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cb_LocKT.getModel();
        model.removeAllElements();
        for (KichCo kc : listLS) {
            model.addElement(kc.getTen());
        }
    }

    public void fillChatLieu(List<ChatLieu> listCL) {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cb_ChatLieu.getModel();
        model.removeAllElements();
        for (ChatLieu cl : listCL) {
            model.addElement(cl.getTen());
        }
    }

    public void fillLocChatLieu(List<ChatLieu> listLC) {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cb_LocCL.getModel();
        model.removeAllElements();
        for (ChatLieu cl : listLC) {
            model.addElement(cl.getTen());
        }
    }

    public void fillMauSac(List<MauSac> listMS) {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cb_MauSac.getModel();
        model.removeAllElements();
        for (MauSac ms : listMS) {
            model.addElement(ms.getTen());
        }
    }

    public void fillLocMauSac(List<MauSac> listLM) {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cb_LocMS.getModel();
        model.removeAllElements();
        for (MauSac ms : listLM) {
            model.addElement(ms.getTen());
        }
    }

    public void fillDanhMuc(List<DanhMuc> listDM) {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cb_DanhMuc.getModel();
        model.removeAllElements();
        for (DanhMuc dm : listDM) {
            model.addElement(dm.getTen());
        }
    }

    public void fillLocDanhMuc(List<DanhMuc> listLD) {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cb_LocDM.getModel();
        model.removeAllElements();
        for (DanhMuc dm : listLD) {
            model.addElement(dm.getTen());
        }
    }

    public void showForm(SanPham sp) {
        index = tbl_SanPham.getSelectedRow();
        txt_Ma.setText(tbl_SanPham.getValueAt(index, 0).toString());
        txt_Ten.setText(tbl_SanPham.getValueAt(index, 1).toString());
        txt_GiaBan.setText(tbl_SanPham.getValueAt(index, 2).toString());
        txt_SoLuong.setText(tbl_SanPham.getValueAt(index, 3).toString());
        cb_KichThuoc.setSelectedItem(tbl_SanPham.getValueAt(index, 4));
        cb_MauSac.setSelectedItem(tbl_SanPham.getValueAt(index, 5));
        cb_ChatLieu.setSelectedItem(tbl_SanPham.getValueAt(index, 6));
        cb_DanhMuc.setSelectedItem(tbl_SanPham.getValueAt(index, 7));
        String tt = (String) tbl_SanPham.getValueAt(index, 8);
        if (tt.equals("Đang bán")) {
            rd_DangBan.setSelected(true);
        }
        if (tt.equals("Dừng bán")) {
            rd_DungBan.setSelected(true);
        }

    }

    public boolean validateForm() {

        return true;
    }

    SanPham readForm() {
        String ten, ma, size = null, mausac = null, chatlieu = null, danhmuc = null, trangthai = null;
        int soluong;
        float giaban;
        ma = txt_Ma.getText().trim();
        ten = txt_Ten.getText().trim();
        soluong = Integer.parseInt(txt_SoLuong.getText());
        giaban = Float.parseFloat(txt_GiaBan.getText());
        if (rd_DangBan.isSelected()) {
            trangthai = "Đang bán";
        } else if (rd_DungBan.isSelected()) {
            trangthai = "Dừng bán";
        }
        index = cb_KichThuoc.getSelectedIndex();
        List<KichCo> listKC = ks.getAll();
        for (int i = 0; i < listKC.size(); i++) {
            if (i == index) {
                size = String.valueOf(listKC.get(i).getId());
            }
        }
        index = cb_MauSac.getSelectedIndex();
        List<MauSac> listMS = ms.getAll();
        for (int i = 0; i < listMS.size(); i++) {
            if (i == index) {
                mausac = String.valueOf(listMS.get(i).getId());
            }
        }
        index = cb_ChatLieu.getSelectedIndex();
        List<ChatLieu> listCL = cs.getAll();
        for (int i = 0; i < listCL.size(); i++) {
            if (i == index) {
                chatlieu = String.valueOf(listCL.get(i).getId());
            }
        }
        index = cb_DanhMuc.getSelectedIndex();
        List<DanhMuc> listDM = ds.getAll();
        for (int i = 0; i < listDM.size(); i++) {
            if (i == index) {
                danhmuc = String.valueOf(listDM.get(i).getId());
            }
        }
        return new SanPham(ma, ten, giaban, soluong, size, mausac, chatlieu, danhmuc, trangthai);
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
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_Ma = new javax.swing.JTextField();
        txt_Ten = new javax.swing.JTextField();
        txt_GiaBan = new javax.swing.JTextField();
        txt_SoLuong = new javax.swing.JTextField();
        cb_DanhMuc = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cb_MauSac = new javax.swing.JComboBox<>();
        cb_KichThuoc = new javax.swing.JComboBox<>();
        cb_ChatLieu = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        rd_DangBan = new javax.swing.JRadioButton();
        rd_DungBan = new javax.swing.JRadioButton();
        btn_ThemMS = new javax.swing.JButton();
        btn_ThemKC = new javax.swing.JButton();
        btn_ThemCL = new javax.swing.JButton();
        btn_ThemDM = new javax.swing.JButton();
        btn_Them = new javax.swing.JButton();
        btn_Sua = new javax.swing.JButton();
        btn_LamMoi = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_SanPham = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        txt_TimKiem = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        cb_LocDM = new javax.swing.JComboBox<>();
        cb_LocMS = new javax.swing.JComboBox<>();
        cb_LocKT = new javax.swing.JComboBox<>();
        cb_LocCL = new javax.swing.JComboBox<>();
        cb_LocTT = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1054, 692));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Quản lý sản phẩm ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Mã sản phẩm : ");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Tên sản phẩm : ");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Danh mục : ");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Giá bán : ");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Số lượng : ");

        txt_Ma.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txt_Ten.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txt_GiaBan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txt_SoLuong.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        cb_DanhMuc.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cb_DanhMuc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", " " }));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Màu sắc : ");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Kích cỡ : ");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Chất liệu : ");

        cb_MauSac.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        cb_KichThuoc.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        cb_ChatLieu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("Trạng thái : ");

        buttonGroup1.add(rd_DangBan);
        rd_DangBan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rd_DangBan.setText("Đang bán");

        buttonGroup1.add(rd_DungBan);
        rd_DungBan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rd_DungBan.setText("Dừng bán");
        rd_DungBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rd_DungBanActionPerformed(evt);
            }
        });

        btn_ThemMS.setText("+");
        btn_ThemMS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThemMSActionPerformed(evt);
            }
        });

        btn_ThemKC.setText("+");
        btn_ThemKC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThemKCActionPerformed(evt);
            }
        });

        btn_ThemCL.setText("+");
        btn_ThemCL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThemCLActionPerformed(evt);
            }
        });

        btn_ThemDM.setText("+");
        btn_ThemDM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThemDMActionPerformed(evt);
            }
        });

        btn_Them.setBackground(new java.awt.Color(153, 204, 255));
        btn_Them.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_Them.setText("Thêm ");
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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_Ma, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_Ten, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cb_DanhMuc, javax.swing.GroupLayout.Alignment.TRAILING, 0, 258, Short.MAX_VALUE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_SoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_GiaBan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btn_ThemDM)
                        .addGap(108, 108, 108)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel8)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cb_KichThuoc, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cb_ChatLieu, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cb_MauSac, 0, 282, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btn_ThemMS)
                                    .addComponent(btn_ThemKC)
                                    .addComponent(btn_ThemCL)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(rd_DangBan)
                                .addGap(30, 30, 30)
                                .addComponent(rd_DungBan)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_Them, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(btn_Sua, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(btn_LamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_Ma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel6)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cb_MauSac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_ThemMS))))
                .addGap(13, 13, 13)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_Ten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cb_KichThuoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(btn_ThemKC))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cb_DanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(cb_ChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_ThemCL)
                            .addComponent(btn_ThemDM))))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(txt_GiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_SoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(65, 65, 65))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rd_DungBan, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rd_DangBan)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_Them, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_Sua, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_LamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(47, 47, 47))))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin sản phẩm ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N

        tbl_SanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã SP ", "Tên SP", "Giá bán ", "Số lượng", "Kích cỡ", "Màu sắc ", "Chất liệu", "Danh mục ", "Trạng thái "
            }
        ));
        tbl_SanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_SanPhamMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_SanPham);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Tìm kiếm : ");

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

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lọc", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        cb_LocDM.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cb_LocDM.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        cb_LocDM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_LocDMActionPerformed(evt);
            }
        });

        cb_LocMS.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cb_LocMS.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        cb_LocMS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_LocMSActionPerformed(evt);
            }
        });

        cb_LocKT.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cb_LocKT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        cb_LocKT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_LocKTActionPerformed(evt);
            }
        });

        cb_LocCL.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cb_LocCL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_LocCLActionPerformed(evt);
            }
        });

        cb_LocTT.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cb_LocTT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_LocTTActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setText("Danh mục :");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setText("Màu sắc : ");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setText("Kích thước : ");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setText("Chất liệu : ");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel15.setText("Trạng thái : ");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cb_LocDM, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(14, 14, 14)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cb_LocMS, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cb_LocKT, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cb_LocCL, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(cb_LocTT, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb_LocMS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_LocKT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_LocCL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_LocTT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_LocDM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_TimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txt_TimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void rd_DungBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rd_DungBanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rd_DungBanActionPerformed

    private void tbl_SanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_SanPhamMouseClicked
        // TODO add your handling code here:
        index = tbl_SanPham.getSelectedRow();
        if (index > -1) {
            showForm(ss.getAll().get(index));
        }
    }//GEN-LAST:event_tbl_SanPhamMouseClicked

    private void txt_TimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_TimKiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_TimKiemActionPerformed

    private void txt_TimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_TimKiemKeyReleased
        // TODO add your handling code here:
        DefaultTableModel ob = (DefaultTableModel) tbl_SanPham.getModel();
        TableRowSorter<DefaultTableModel> obj = new TableRowSorter<>(ob);
        tbl_SanPham.setRowSorter(obj);
        obj.setRowFilter(RowFilter.regexFilter(txt_TimKiem.getText()));
    }//GEN-LAST:event_txt_TimKiemKeyReleased

    private void btn_ThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThemActionPerformed
        // TODO add your handling code here:
        int chon = JOptionPane.showConfirmDialog(this, "Bạn có muốn thêm không ?", "Thêm sản phẩm :", JOptionPane.YES_NO_CANCEL_OPTION,
                3, null);
        if (chon == 0) {
            if (validateForm()) {
                try {
                    String maNV = txt_Ma.getText();
                    if (ss.isMaSanPham(maNV)) {
                        JOptionPane.showMessageDialog(this, "Mã sản phẩm đã tồn tại !");
                        return;
                    } else if (ss.insertSP(this.readForm()) > 0) {
                        JOptionPane.showMessageDialog(this, "Thêm thành công!");
                        this.fillTable(ss.getAll());
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Thêm thất bại !");
                }
            }
        }
    }//GEN-LAST:event_btn_ThemActionPerformed

    private void btn_SuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SuaActionPerformed
        // TODO add your handling code here:
        int chon = JOptionPane.showConfirmDialog(this, "Bạn có muốn sửa không ?", "Sửa Nhân viên",
                JOptionPane.YES_NO_CANCEL_OPTION, 3, null);
        if (chon == 0) {
            if (validateForm()) {
                if (index == -1) {
                    JOptionPane.showMessageDialog(this, "Bạn chưa chọn dòng nào !");
                } else {
                    index = tbl_SanPham.getSelectedRow();
                    SanPham sp = readForm();
                    if (ss.updateSP(sp) > 0) {
                        JOptionPane.showMessageDialog(this, "Sửa thành công !");
                        this.fillTable(ss.getAll());
                        fillSanPham(ss.getAll());
                    } else {
                        JOptionPane.showMessageDialog(this, "Sửa thất bại !");
                    }
                }

            }
        }
    }//GEN-LAST:event_btn_SuaActionPerformed

    private void btn_LamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_LamMoiActionPerformed
        // TODO add your handling code here:
        txt_Ma.setText("");
        txt_Ten.setText("");
        txt_SoLuong.setText("");
        txt_GiaBan.setText("");
        buttonGroup1.clearSelection();
        //        cb_ChatLieu.removeAllItems();
        //        cb_DanhMuc.removeAllItems();
        //        cb_KichThuoc.removeAllItems();
        //        cb_MauSac.removeAllItems();
    }//GEN-LAST:event_btn_LamMoiActionPerformed

    private void cb_LocDMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_LocDMActionPerformed
        // TODO add your handling code here:
        String selectedDM = (String) cb_LocDM.getSelectedItem();

        // Gọi phương thức locTheoTt từ service để lọc danh sách nhân viên theo trạng thái đã chọn
        List<SanPham> listSanPham = ss.locDM(selectedDM);

        // Cập nhật bảng hiển thị danh sách nhân viên với danh sách đã lọc
        fillTable(listSanPham);
    }//GEN-LAST:event_cb_LocDMActionPerformed

    private void cb_LocMSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_LocMSActionPerformed
        // TODO add your handling code here:
        String selectedMS = (String) cb_LocMS.getSelectedItem();

        // Gọi phương thức locTheoTt từ service để lọc danh sách nhân viên theo trạng thái đã chọn
        List<SanPham> listSanPham = ss.locMS(selectedMS);

        // Cập nhật bảng hiển thị danh sách nhân viên với danh sách đã lọc
        fillTable(listSanPham);
    }//GEN-LAST:event_cb_LocMSActionPerformed

    private void cb_LocKTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_LocKTActionPerformed
        // TODO add your handling code here:
        String selectedKT = (String) cb_LocKT.getSelectedItem();

        // Gọi phương thức locTheoTt từ service để lọc danh sách nhân viên theo trạng thái đã chọn
        List<SanPham> listSanPham = ss.locKC(selectedKT);

        // Cập nhật bảng hiển thị danh sách nhân viên với danh sách đã lọc
        fillTable(listSanPham);
    }//GEN-LAST:event_cb_LocKTActionPerformed

    private void cb_LocCLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_LocCLActionPerformed
        // TODO add your handling code here:
        String selectedCL = (String) cb_LocCL.getSelectedItem();

        // Gọi phương thức locTheoTt từ service để lọc danh sách nhân viên theo trạng thái đã chọn
        List<SanPham> listSanPham = ss.locCL(selectedCL);

        // Cập nhật bảng hiển thị danh sách nhân viên với danh sách đã lọc
        fillTable(listSanPham);
    }//GEN-LAST:event_cb_LocCLActionPerformed

    private void cb_LocTTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_LocTTActionPerformed
        // TODO add your handling code here:
        String selectedTT = (String) cb_LocTT.getSelectedItem();

        // Gọi phương thức locTheoTt từ service để lọc danh sách nhân viên theo trạng thái đã chọn
        List<SanPham> listSanPham = ss.locTT(selectedTT);

        // Cập nhật bảng hiển thị danh sách nhân viên với danh sách đã lọc
        fillTable(listSanPham);
    }//GEN-LAST:event_cb_LocTTActionPerformed

    private void btn_ThemMSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThemMSActionPerformed
        // TODO add your handling code here:
        new MauSac_Dialog(null, true).setVisible(true);
        this.fillMauSac(ms.getAll());
    }//GEN-LAST:event_btn_ThemMSActionPerformed

    private void btn_ThemKCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThemKCActionPerformed
        // TODO add your handling code here:
        new KichCo_Dialog(null, true).setVisible(true);
        this.fillSize(ks.getAll());
    }//GEN-LAST:event_btn_ThemKCActionPerformed

    private void btn_ThemDMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThemDMActionPerformed
        // TODO add your handling code here:
        new DanhMuc_Dialog(null, true).setVisible(true);
        this.fillDanhMuc(ds.getAll());
    }//GEN-LAST:event_btn_ThemDMActionPerformed

    private void btn_ThemCLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThemCLActionPerformed
        // TODO add your handling code here:
        new ChatLieu_Dialog(null, true).setVisible(true);
        this.fillChatLieu(cs.getAll());
    }//GEN-LAST:event_btn_ThemCLActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_LamMoi;
    private javax.swing.JButton btn_Sua;
    private javax.swing.JButton btn_Them;
    private javax.swing.JButton btn_ThemCL;
    private javax.swing.JButton btn_ThemDM;
    private javax.swing.JButton btn_ThemKC;
    private javax.swing.JButton btn_ThemMS;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cb_ChatLieu;
    private javax.swing.JComboBox<String> cb_DanhMuc;
    private javax.swing.JComboBox<String> cb_KichThuoc;
    private javax.swing.JComboBox<String> cb_LocCL;
    private javax.swing.JComboBox<String> cb_LocDM;
    private javax.swing.JComboBox<String> cb_LocKT;
    private javax.swing.JComboBox<String> cb_LocMS;
    private javax.swing.JComboBox<String> cb_LocTT;
    private javax.swing.JComboBox<String> cb_MauSac;
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rd_DangBan;
    private javax.swing.JRadioButton rd_DungBan;
    private javax.swing.JTable tbl_SanPham;
    private javax.swing.JTextField txt_GiaBan;
    private javax.swing.JTextField txt_Ma;
    private javax.swing.JTextField txt_SoLuong;
    private javax.swing.JTextField txt_Ten;
    private javax.swing.JTextField txt_TimKiem;
    // End of variables declaration//GEN-END:variables
}
