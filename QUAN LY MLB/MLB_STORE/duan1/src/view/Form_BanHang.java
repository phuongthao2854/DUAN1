package view;

import DAO.MSGHelper;
import component.KhachHang_List;
import java.awt.Color;
import java.awt.Font;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.DanhMuc;
import model.HoaDonChiTiet_M;
import model.HoaDon_M;
import model.KichCo;
import model.MauSac;
import model.SanPham;
import model.Voucher;
import service.BanHang_HDCT_Service;
import service.BanHang_HD_Service;
import service.DanhMuc_Service;
import service.KichCo_Service;
import service.Login_Service;
import service.MauSac_Service;
import service.SP_BanHang_Service;
import service.Voucher_Service;

public final class Form_BanHang extends javax.swing.JPanel {

    public Form_BanHang() {
        initComponents();
        init();
        formWindowOpened();//Flat
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel_BanHang = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_HoaDon = new javax.swing.JTable();
        btn_taoDon = new swingStyle.btn();
        btn_xoaDon = new swingStyle.btn();
        jLabel29 = new javax.swing.JLabel();
        lbl_numberInvoice = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        lbl_InvoiceChoosed = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_GioHang = new javax.swing.JTable();
        btn_remove = new swingStyle.btn();
        fhhnfah = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbl_SanPham = new javax.swing.JTable();
        txt_searchSPCT = new javax.swing.JTextField();
        cbb_danhMuc = new swingStyle.Combobox();
        cbb_size = new swingStyle.Combobox();
        cbb_mauSac = new swingStyle.Combobox();
        btn_all = new swingStyle.btn();
        jPanel1 = new javax.swing.JPanel();
        pn_thongTinKH = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txt_maKH = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_tenKH = new javax.swing.JTextField();
        btn_KH = new swingStyle.btn();
        btn_remove1 = new swingStyle.btn();
        pn_thongTinHoaDon = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txt_maHD = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txt_maNV = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txt_tongGiaTriHD = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txt_soTienGiam = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txt_tienKhachDua = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        txt_tienThua = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        txt_ngayTaoHoaDon = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        cbb_voucher = new javax.swing.JComboBox<>();
        txt_thanhToan = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ta_GhiChu = new javax.swing.JTextArea();
        btn_thanhToan = new swingStyle.btn();
        btn_clear = new swingStyle.btn();

        setBackground(new java.awt.Color(255, 255, 255));

        Panel_BanHang.setBackground(new java.awt.Color(214, 209, 209));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Hóa đơn chờ ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        tbl_HoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "Mã HĐ", "Nhân viên ", "Khách hàng", "Ngày tạo ", "Trạng thái"
            }
        )
        {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
            public boolean isCellEditable(int row, int column){
                return false;
            }

        }

    );
    tbl_HoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            tbl_HoaDonMouseClicked(evt);
        }
    });
    jScrollPane1.setViewportView(tbl_HoaDon);

    btn_taoDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Statistics_Images/invoice.png"))); // NOI18N
    btn_taoDon.setText("Tạo Đơn");
    btn_taoDon.setRadius(19);
    btn_taoDon.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btn_taoDonActionPerformed(evt);
        }
    });

    btn_xoaDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Statistics_Images/bill.png"))); // NOI18N
    btn_xoaDon.setText("Xóa HĐ");
    btn_xoaDon.setRadius(19);
    btn_xoaDon.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btn_xoaDonActionPerformed(evt);
        }
    });

    jLabel29.setText("Số Hóa Đơn : ");

    lbl_numberInvoice.setText("5");

    jLabel38.setText("--HĐ đang chọn--");

    lbl_InvoiceChoosed.setText("-1");

    javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
    jPanel3.setLayout(jPanel3Layout);
    jPanel3Layout.setHorizontalGroup(
        jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jScrollPane1)
        .addGroup(jPanel3Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(btn_taoDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 508, Short.MAX_VALUE)
            .addComponent(btn_xoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap())
        .addGroup(jPanel3Layout.createSequentialGroup()
            .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(lbl_numberInvoice, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(27, 27, 27)
            .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(lbl_InvoiceChoosed, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, Short.MAX_VALUE))
    );
    jPanel3Layout.setVerticalGroup(
        jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btn_xoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btn_taoDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(lbl_InvoiceChoosed))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(lbl_numberInvoice)))
            .addContainerGap())
    );

    jPanel4.setBackground(new java.awt.Color(255, 255, 255));
    jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Giỏ hàng ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

    tbl_GioHang.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {
        },
        new String [] {
            "Mã HĐCT","Mã SP ", "Tên SP","Đơn giá", "Số lượng",  "Thành tiền"
        }
    )
    {
        Class[] types = new Class [] {
            java.lang.Object.class,java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
        };

        public Class getColumnClass(int columnIndex) {
            return types [columnIndex];
        }
        public boolean isCellEditable(int row, int column){
            return false;
        }
    }
    );
    tbl_GioHang.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            tbl_GioHangMouseClicked(evt);
        }
    });
    jScrollPane3.setViewportView(tbl_GioHang);

    btn_remove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Statistics_Images/Bin2.png"))); // NOI18N
    btn_remove.setRadius(19);
    btn_remove.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btn_removeActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
    jPanel4.setLayout(jPanel4Layout);
    jPanel4Layout.setHorizontalGroup(
        jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel4Layout.createSequentialGroup()
            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 616, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(btn_remove, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap())
    );
    jPanel4Layout.setVerticalGroup(
        jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel4Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(btn_remove, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(23, 99, Short.MAX_VALUE))
        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
    );

    fhhnfah.setBackground(new java.awt.Color(255, 255, 255));
    fhhnfah.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách sản phẩm ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

    tbl_SanPham.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {
        },
        new String [] {
            "Mã SP", "Tên SP", "Kích cỡ ", "Màu Sắc ", "Chất liệu ", "Danh mục ", "Số lượng ", "Giá bán "
        }
    )
    {
        Class[] types = new Class [] {
            java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,
        };

        public Class getColumnClass(int columnIndex) {
            return types [columnIndex];
        }
        public boolean isCellEditable(int row, int column){
            return false;
        }
    }
    );
    tbl_SanPham.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            tbl_SanPhamMouseClicked(evt);
        }
    });
    jScrollPane4.setViewportView(tbl_SanPham);

    txt_searchSPCT.setForeground(java.awt.Color.gray);
    txt_searchSPCT.setText("Tìm kiếm sản phẩm theo mã sản phẩm , tên ....");
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

    cbb_danhMuc.setMaximumRowCount(8);
    cbb_danhMuc.setLabeText("Danh mục");
    cbb_danhMuc.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            cbb_danhMucActionPerformed(evt);
        }
    });

    cbb_size.setMaximumRowCount(8);
    cbb_size.setLabeText("Size");
    cbb_size.setPreferredSize(new java.awt.Dimension(70, 40));
    cbb_size.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            cbb_sizeActionPerformed(evt);
        }
    });

    cbb_mauSac.setMaximumRowCount(8);
    cbb_mauSac.setLabeText("Màu Sắc");
    cbb_mauSac.setPreferredSize(new java.awt.Dimension(70, 40));
    cbb_mauSac.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            cbb_mauSacActionPerformed(evt);
        }
    });

    btn_all.setText("Bỏ Lọc");
    btn_all.setRadius(19);
    btn_all.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btn_allActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout fhhnfahLayout = new javax.swing.GroupLayout(fhhnfah);
    fhhnfah.setLayout(fhhnfahLayout);
    fhhnfahLayout.setHorizontalGroup(
        fhhnfahLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(fhhnfahLayout.createSequentialGroup()
            .addComponent(txt_searchSPCT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(cbb_size, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(cbb_mauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(cbb_danhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(btn_all, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGap(12, 12, 12))
        .addComponent(jScrollPane4)
    );
    fhhnfahLayout.setVerticalGroup(
        fhhnfahLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(fhhnfahLayout.createSequentialGroup()
            .addGap(2, 2, 2)
            .addGroup(fhhnfahLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fhhnfahLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbb_size, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbb_mauSac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(txt_searchSPCT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btn_all, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(cbb_danhMuc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE))
    );

    jPanel1.setBackground(new java.awt.Color(255, 255, 255));
    jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Hóa đơn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

    pn_thongTinKH.setBackground(new java.awt.Color(255, 255, 255));
    pn_thongTinKH.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "Thông tin khách hàng"));
    pn_thongTinKH.setForeground(new java.awt.Color(242, 242, 242));

    jLabel2.setText("Mã KH :");

    txt_maKH.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 255)));
    txt_maKH.setDoubleBuffered(true);
    txt_maKH.setEnabled(false);
    txt_maKH.setOpaque(true);
    txt_maKH.setPreferredSize(new java.awt.Dimension(200, 25));

    jLabel5.setText("Tên KH : ");

    txt_tenKH.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 255)));
    txt_tenKH.setEnabled(false);
    txt_tenKH.setPreferredSize(new java.awt.Dimension(200, 25));

    btn_KH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Statistics_Images/client.png"))); // NOI18N
    btn_KH.setRadius(19);
    btn_KH.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btn_KHActionPerformed(evt);
        }
    });

    btn_remove1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Statistics_Images/Bin2.png"))); // NOI18N
    btn_remove1.setRadius(19);
    btn_remove1.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btn_remove1ActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout pn_thongTinKHLayout = new javax.swing.GroupLayout(pn_thongTinKH);
    pn_thongTinKH.setLayout(pn_thongTinKHLayout);
    pn_thongTinKHLayout.setHorizontalGroup(
        pn_thongTinKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(pn_thongTinKHLayout.createSequentialGroup()
            .addContainerGap()
            .addGroup(pn_thongTinKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGap(18, 18, 18)
            .addGroup(pn_thongTinKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pn_thongTinKHLayout.createSequentialGroup()
                    .addComponent(txt_tenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(btn_remove1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(pn_thongTinKHLayout.createSequentialGroup()
                    .addComponent(txt_maKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(btn_KH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    pn_thongTinKHLayout.setVerticalGroup(
        pn_thongTinKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(pn_thongTinKHLayout.createSequentialGroup()
            .addGap(7, 7, 7)
            .addGroup(pn_thongTinKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                .addComponent(jLabel2)
                .addComponent(txt_maKH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_KH, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(pn_thongTinKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addGroup(pn_thongTinKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_tenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(btn_remove1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
            .addContainerGap(12, Short.MAX_VALUE))
    );

    pn_thongTinHoaDon.setBackground(new java.awt.Color(255, 255, 255));
    pn_thongTinHoaDon.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "Thông tin hóa đơn"));

    jLabel4.setText("Mã Hóa Đơn");
    jLabel4.setMaximumSize(null);
    jLabel4.setPreferredSize(new java.awt.Dimension(100, 20));

    txt_maHD.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    txt_maHD.setForeground(new java.awt.Color(51, 51, 255));
    txt_maHD.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 255)));
    txt_maHD.setDisabledTextColor(java.awt.Color.black);
    txt_maHD.setEnabled(false);
    txt_maHD.setPreferredSize(new java.awt.Dimension(200, 25));

    jLabel9.setText("Mã Nhân Viên");
    jLabel9.setMaximumSize(null);
    jLabel9.setPreferredSize(new java.awt.Dimension(100, 20));

    txt_maNV.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    txt_maNV.setForeground(new java.awt.Color(51, 51, 255));
    txt_maNV.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 255)));
    txt_maNV.setDisabledTextColor(java.awt.Color.black);
    txt_maNV.setEnabled(false);
    txt_maNV.setPreferredSize(new java.awt.Dimension(200, 25));

    jLabel13.setText("Tổng giá trị HĐ");
    jLabel13.setPreferredSize(new java.awt.Dimension(100, 20));

    txt_tongGiaTriHD.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    txt_tongGiaTriHD.setForeground(new java.awt.Color(51, 51, 255));
    txt_tongGiaTriHD.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 255)));
    txt_tongGiaTriHD.setDisabledTextColor(java.awt.Color.black);
    txt_tongGiaTriHD.setEnabled(false);
    txt_tongGiaTriHD.setPreferredSize(new java.awt.Dimension(200, 25));

    jLabel17.setText("Giảm Giá Voucher");
    jLabel17.setPreferredSize(new java.awt.Dimension(100, 20));

    txt_soTienGiam.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    txt_soTienGiam.setForeground(new java.awt.Color(51, 51, 255));
    txt_soTienGiam.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 255)));
    txt_soTienGiam.setDisabledTextColor(java.awt.Color.black);
    txt_soTienGiam.setEnabled(false);
    txt_soTienGiam.setPreferredSize(new java.awt.Dimension(200, 25));

    jLabel18.setText("Số tiền giảm");
    jLabel18.setPreferredSize(new java.awt.Dimension(100, 20));

    jLabel19.setText("Thanh Toán");
    jLabel19.setPreferredSize(new java.awt.Dimension(100, 20));

    jLabel20.setText("Tiền khách đưa");
    jLabel20.setPreferredSize(new java.awt.Dimension(100, 20));

    txt_tienKhachDua.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    txt_tienKhachDua.setForeground(new java.awt.Color(51, 51, 255));
    txt_tienKhachDua.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 255)));
    txt_tienKhachDua.setDisabledTextColor(java.awt.Color.black);
    txt_tienKhachDua.setPreferredSize(new java.awt.Dimension(200, 25));
    txt_tienKhachDua.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyReleased(java.awt.event.KeyEvent evt) {
            txt_tienKhachDuaKeyReleased(evt);
        }
    });

    jLabel22.setText("Tiền thừa");
    jLabel22.setPreferredSize(new java.awt.Dimension(100, 20));

    txt_tienThua.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    txt_tienThua.setForeground(new java.awt.Color(51, 51, 255));
    txt_tienThua.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 255)));
    txt_tienThua.setDisabledTextColor(java.awt.Color.black);
    txt_tienThua.setEnabled(false);
    txt_tienThua.setPreferredSize(new java.awt.Dimension(200, 25));

    jLabel23.setText("Ngày Tạo");
    jLabel23.setPreferredSize(new java.awt.Dimension(100, 20));

    txt_ngayTaoHoaDon.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    txt_ngayTaoHoaDon.setForeground(new java.awt.Color(51, 51, 255));
    txt_ngayTaoHoaDon.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 255)));
    txt_ngayTaoHoaDon.setDisabledTextColor(java.awt.Color.black);
    txt_ngayTaoHoaDon.setEnabled(false);
    txt_ngayTaoHoaDon.setPreferredSize(new java.awt.Dimension(200, 25));

    jLabel34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Statistics_Images/pay.png"))); // NOI18N

    jLabel36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Statistics_Images/coupon.png"))); // NOI18N

    jLabel37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Statistics_Images/fiat-money.png"))); // NOI18N

    cbb_voucher.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
    cbb_voucher.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
    cbb_voucher.setPreferredSize(new java.awt.Dimension(200, 25));
    cbb_voucher.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            cbb_voucherActionPerformed(evt);
        }
    });

    txt_thanhToan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
    txt_thanhToan.setForeground(new java.awt.Color(51, 51, 255));
    txt_thanhToan.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 255)));
    txt_thanhToan.setDisabledTextColor(java.awt.Color.black);
    txt_thanhToan.setEnabled(false);
    txt_thanhToan.setPreferredSize(new java.awt.Dimension(200, 25));

    jLabel24.setText("Ghi Chú");
    jLabel24.setPreferredSize(new java.awt.Dimension(100, 20));

    ta_GhiChu.setColumns(20);
    ta_GhiChu.setForeground(new java.awt.Color(51, 51, 255));
    ta_GhiChu.setRows(5);
    ta_GhiChu.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 255)));
    jScrollPane2.setViewportView(ta_GhiChu);

    javax.swing.GroupLayout pn_thongTinHoaDonLayout = new javax.swing.GroupLayout(pn_thongTinHoaDon);
    pn_thongTinHoaDon.setLayout(pn_thongTinHoaDonLayout);
    pn_thongTinHoaDonLayout.setHorizontalGroup(
        pn_thongTinHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(pn_thongTinHoaDonLayout.createSequentialGroup()
            .addContainerGap()
            .addGroup(pn_thongTinHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pn_thongTinHoaDonLayout.createSequentialGroup()
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(txt_tienThua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE))
                .addGroup(pn_thongTinHoaDonLayout.createSequentialGroup()
                    .addGroup(pn_thongTinHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pn_thongTinHoaDonLayout.createSequentialGroup()
                            .addGroup(pn_thongTinHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(pn_thongTinHoaDonLayout.createSequentialGroup()
                                    .addGroup(pn_thongTinHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                .addGroup(pn_thongTinHoaDonLayout.createSequentialGroup()
                                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGap(6, 6, 6)))
                            .addGroup(pn_thongTinHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txt_soTienGiam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_tongGiaTriHD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_maHD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_maNV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cbb_voucher, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_thanhToan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(pn_thongTinHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel36)
                                .addComponent(jLabel37)))
                        .addGroup(pn_thongTinHoaDonLayout.createSequentialGroup()
                            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txt_ngayTaoHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(pn_thongTinHoaDonLayout.createSequentialGroup()
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txt_tienKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel34))
                        .addGroup(pn_thongTinHoaDonLayout.createSequentialGroup()
                            .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(8, 18, Short.MAX_VALUE))))
    );
    pn_thongTinHoaDonLayout.setVerticalGroup(
        pn_thongTinHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(pn_thongTinHoaDonLayout.createSequentialGroup()
            .addGroup(pn_thongTinHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(txt_maHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addGroup(pn_thongTinHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(txt_maNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(19, 19, 19)
            .addGroup(pn_thongTinHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(txt_ngayTaoHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addGroup(pn_thongTinHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pn_thongTinHoaDonLayout.createSequentialGroup()
                    .addGroup(pn_thongTinHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_tongGiaTriHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(pn_thongTinHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pn_thongTinHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbb_voucher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel36)))
                .addComponent(jLabel37))
            .addGap(18, 18, 18)
            .addGroup(pn_thongTinHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(txt_soTienGiam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addGroup(pn_thongTinHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(txt_thanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addGroup(pn_thongTinHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addGroup(pn_thongTinHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_tienKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(jLabel34))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(pn_thongTinHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(txt_tienThua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(pn_thongTinHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap(11, Short.MAX_VALUE))
    );

    btn_thanhToan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Statistics_Images/bill1.png"))); // NOI18N
    btn_thanhToan.setText("Thanh Toán");
    btn_thanhToan.setRadius(19);
    btn_thanhToan.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btn_thanhToanActionPerformed(evt);
        }
    });

    btn_clear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Statistics_Images/clean.png"))); // NOI18N
    btn_clear.setText("Làm mới");
    btn_clear.setRadius(19);
    btn_clear.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btn_clearActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup()
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pn_thongTinKH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(btn_thanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(28, 28, 28)
                            .addComponent(btn_clear, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, Short.MAX_VALUE))
                        .addComponent(pn_thongTinHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addContainerGap())
    );
    jPanel1Layout.setVerticalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup()
            .addComponent(pn_thongTinKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(pn_thongTinHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btn_thanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btn_clear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout Panel_BanHangLayout = new javax.swing.GroupLayout(Panel_BanHang);
    Panel_BanHang.setLayout(Panel_BanHangLayout);
    Panel_BanHangLayout.setHorizontalGroup(
        Panel_BanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(Panel_BanHangLayout.createSequentialGroup()
            .addGroup(Panel_BanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(fhhnfah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addContainerGap())
    );
    Panel_BanHangLayout.setVerticalGroup(
        Panel_BanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(Panel_BanHangLayout.createSequentialGroup()
            .addGroup(Panel_BanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_BanHangLayout.createSequentialGroup()
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(fhhnfah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addContainerGap())
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(Panel_BanHang, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(Panel_BanHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addContainerGap())
    );
    }// </editor-fold>//GEN-END:initComponents

    private void txt_searchSPCTFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_searchSPCTFocusGained
        //Sự kiện xảy ra khi thành phần txt_timKiemSP UI nhận đc trạng thái focus.
        if (txt_searchSPCT.getText().equals("Tìm kiếm sản phẩm theo mã sản phẩm , tên ....")) {
            txt_searchSPCT.setText(null);
            txt_searchSPCT.requestFocus(); //Yêu cầu tập trung Focus vào 1 component nào đó.
            //remove placeholder style
            removePlaceholderStyle(txt_searchSPCT);
        }
    }//GEN-LAST:event_txt_searchSPCTFocusGained

    private void txt_searchSPCTFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_searchSPCTFocusLost
        //Sự kiện xảy ra khi thành phần txt_timKiemSP UI nhận đc trạng thái focusLost.
        if (txt_searchSPCT.getText().length() == 0) {
            //add Placeholder style 
            addPlaceholderStyle(txt_searchSPCT);
            txt_searchSPCT.setText("Tìm kiếm sản phẩm theo mã sản phẩm , tên ....");
        } else {
            txt_searchSPCT.setColumns(25); // Số lượng ký tự hiển thị
        }
    }//GEN-LAST:event_txt_searchSPCTFocusLost

    private void txt_searchSPCTKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_searchSPCTKeyReleased
        String searchString = txt_searchSPCT.getText();
        dtm_SP = (DefaultTableModel) this.tbl_SanPham.getModel();
        search(searchString, dtm_SP, this.tbl_SanPham);
    }//GEN-LAST:event_txt_searchSPCTKeyReleased

    private void btn_removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_removeActionPerformed
        if (tbl_GioHang != null && tbl_GioHang.getSelectedRow() != -1) {
            SanPham sp = sps.getSP_BY_MaSP(String.valueOf(tbl_GioHang.getValueAt(tbl_GioHang.getSelectedRow(), 1)));
            if (MSGHelper.confirm(this, "Xác nhận xóa SP : " + sp.getTenSanPham() + " ra khỏi giỏ hàng?")) {
                int SLUpdate = sp.getSoLuong() + Integer.valueOf(String.valueOf(tbl_GioHang.getValueAt(tbl_GioHang.getSelectedRow(), 4)));
                int hoanSL_SP = sps.updateSL_SP_BY_IDSP(sp.getIdSP(), SLUpdate);
                int XoaHDCT = bhhdcts.delete_HDCT(Integer.valueOf(String.valueOf(dtm_HDCT.getValueAt(tbl_GioHang.getSelectedRow(), 0))));
                int update_TT_HD = bhs.update_TT_HD_BY_idHD(WIDTH, PROPERTIES);
                if (hoanSL_SP == 1 && XoaHDCT == 1) {
                    MSGHelper.alert(this, "Xóa SP " + sp.getTenSanPham() + " khỏi giỏ hàng thành công");
                    HoaDon_M hd = bhs.getHD_BY_MaHD(maHDSelected);
                    update_TT_For_HD_BY_Id_HD(hd.getIdHD());
                    //Fill FormInf_Invoice + Giỏ hàng + SP
                    Validate_VoucherForInvoice();
                    fillGioHang_BY_IdHD(hd.getIdHD());
                    fillSP();
                } else if (hoanSL_SP == 0) {
                    MSGHelper.alert(this, "Lỗi hoàn lại SP SP");
                } else if (XoaHDCT == 0) {
                    MSGHelper.alert(this, "Lỗi xóa HĐCT");
                }
            }
        } else if (dtm_HDCT == null) {
            MSGHelper.alert(this, "Giỏ hàng trống ko thể xóa");
        } else if (dtm_HDCT != null && tbl_GioHang.getSelectedRow() == -1) {
            MSGHelper.alert(this, "Vui lòng chọn sản phẩm muốn xóa");
        }
    }//GEN-LAST:event_btn_removeActionPerformed

    private void cbb_danhMucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbb_danhMucActionPerformed
        if (dcb_danhMuc.getSelectedItem() != null) {
            String danhMuc = String.valueOf(dcb_danhMuc.getSelectedItem()).trim();
            fillSPByDM(danhMuc);
        }
    }//GEN-LAST:event_cbb_danhMucActionPerformed

    private void cbb_sizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbb_sizeActionPerformed
        if (dcb_size.getSelectedItem() != null) {
            String size = String.valueOf(dcb_size.getSelectedItem()).trim();
            fillSPBySize(size);
        }
    }//GEN-LAST:event_cbb_sizeActionPerformed

    private void cbb_mauSacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbb_mauSacActionPerformed
        if (dcb_mauSac.getSelectedItem() != null) {
            String ms = String.valueOf(dcb_mauSac.getSelectedItem()).trim();
            fillSPByMS(ms);
        }
    }//GEN-LAST:event_cbb_mauSacActionPerformed

    private void btn_allActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_allActionPerformed
        fillSP();
    }//GEN-LAST:event_btn_allActionPerformed

    private void btn_taoDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_taoDonActionPerformed
        if (dtm_HD.getRowCount() < 5 && MSGHelper.confirm(this, "Bạn muốn thêm hóa đơn")) {
            if (insertHD() == 1) {
                MSGHelper.alert(this, "Thêm hóa đơn thành công");
                fillHD();

                int rowSelected = indexInvoiceSelected = this.tbl_HoaDon.getRowCount() - 1;
                this.tbl_HoaDon.setRowSelectionInterval(rowSelected, rowSelected);
                showInfInvoiceToForm();

                if (dtm_HDCT != null && dtm_HDCT.getRowCount() != 0) {
                    dtm_HDCT.setRowCount(0);
                }
            }
        } else if (dtm_HD.getRowCount() == 5) {
            MSGHelper.alert(this, "Tối đa 5 hóa đơn");
        }
    }//GEN-LAST:event_btn_taoDonActionPerformed

    private void btn_xoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaDonActionPerformed
        if (indexInvoiceSelected != -1) {
            if (MSGHelper.confirm(this, "Xác nhận xóa hóa đơn " + this.maHDSelected)) {
                if (this.tbl_GioHang != null && this.tbl_GioHang.getRowCount() != 0) {
                    for (int i = 0; i < tbl_GioHang.getRowCount(); i++) {
                        //Update lại SL_SP
                        SanPham sp = sps.getSP_BY_MaSP(String.valueOf(tbl_GioHang.getValueAt(i, 1)));
                        int SLUp = sp.getSoLuong() + Integer.valueOf(String.valueOf(tbl_GioHang.getValueAt(i, 4)));
                        sps.updateSL_SP_BY_IDSP(sp.getIdSP(), SLUp);
                        //Xóa HĐCT
                        bhhdcts.delete_HDCT(Integer.valueOf(String.valueOf(tbl_GioHang.getValueAt(i, 0))));
                    }

                }
                bhs.delete_HD_BY_MaHD(this.maHDSelected);
                //Fill lại : Bảng HĐ + Giỏ hàng + SP  + FormInfInvoice
                fillHD();
                fillSP();
                if (this.tbl_GioHang != null && this.tbl_GioHang.getRowCount() != 0) {
                    dtm_HDCT.setRowCount(0);
                }
                clearAllForm();
                System.out.println("maHDChoosed " + maHDSelected);
                this.maHDSelected = null;

            }
        }
    }//GEN-LAST:event_btn_xoaDonActionPerformed

    private void btn_KHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_KHActionPerformed
        //Check HĐ đc chọn
        if (indexInvoiceSelected != -1) {
            //Cần truyền vào cửa số hiện tại. + MaHD cập nhật thông tin KH
            openJPanelKH(this, maHDSelected);
        } else {
            MSGHelper.alert(this, "Vui lòng chọn hóa đơn để cập nhật thông tin khách hàng");
        }
    }//GEN-LAST:event_btn_KHActionPerformed

    private void tbl_HoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_HoaDonMouseClicked
        if (dtm_HD.getRowCount() != 0 && tbl_HoaDon.getSelectedRow() != -1) {//Bảng ko trống + HĐ đc chọn
            this.indexInvoiceSelected = tbl_HoaDon.getSelectedRow();//Dựa vào index này để fill
            showInfInvoiceToForm();
            int ID_HD = getHD_BY_MaHD(maHDSelected).getIdHD();
            fillGioHang_BY_IdHD(ID_HD);
        } else {
            MSGHelper.alert(this, "Không có hóa đơn để chọn");
        }
    }//GEN-LAST:event_tbl_HoaDonMouseClicked

    private void txt_tienKhachDuaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_tienKhachDuaKeyReleased
        HoaDon_M HD = bhs.getHD_BY_MaHD(maHDSelected);
        if (HD != null && HD.getTongTien() > 0) {
            setTKD_TT();
        } else if (HD == null) {
            MSGHelper.alert(this, "Vui lòng chọn hóa đơn để nhập tiền");
            txt_tienKhachDua.setText(null);
        } else if (HD.getTongTien() <= 0) {
            MSGHelper.alert(this, "Vui lòng chọn sản phẩm cho hóa đơn");
            txt_tienKhachDua.setText(null);
        }
    }//GEN-LAST:event_txt_tienKhachDuaKeyReleased

    private void cbb_voucherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbb_voucherActionPerformed
        if (isLoadWindow == false) {
            Validate_VoucherForInvoice();
        }
    }//GEN-LAST:event_cbb_voucherActionPerformed

    private void tbl_SanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_SanPhamMouseClicked
        if (evt.getClickCount() == 2) {
            String maSP = String.valueOf(this.dtm_SP.getValueAt(this.tbl_SanPham.getSelectedRow(), 0));
            CheckVali_When_Choosed_SP(maSP);
        }
    }//GEN-LAST:event_tbl_SanPhamMouseClicked

    private void tbl_GioHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_GioHangMouseClicked
        int rowSelected = this.tbl_GioHang.getSelectedRow();
        if (evt.getClickCount() == 2 && rowSelected != -1) {
            int ID_HDCT = (int) dtm_HDCT.getValueAt(rowSelected, 0);
            String maSP = (String) dtm_HDCT.getValueAt(rowSelected, 1);
            CheckVali_When_Choosed_HDCT(ID_HDCT, maSP);
        }
    }//GEN-LAST:event_tbl_GioHangMouseClicked

    private void btn_thanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_thanhToanActionPerformed
        if (maHDSelected != null && tinh_setup_GiaTri_TienThua()) {//HĐ đc chọn + Tiền thừ >=0
            //Check xem hóa đơn đó có áp voucher không ? 
            int id_HD = bhs.getHD_BY_MaHD(maHDSelected).getIdHD();
            String ghiChu = ta_GhiChu.getText();
            String message = null;
            if (dcb_voucher.getSelectedItem().equals("Chưa áp dụng voucher")) {
                message = (bhs.update_ThanhToan_HD_BY_IdHD(id_HD, 0, ghiChu) == 1) ? "Thanh toán thành công " : "Lỗi thanh toán hóa đơn --ko voucher";
            } else {//TH có voucher : MaVoucher --> Id_Voucher
                String maVoucher = ((Voucher) dcb_voucher.getSelectedItem()).getMa();
                System.out.println("MaVoucher " + maVoucher);
                int id_Voucher = sps.getVoucherByMaVoucher(maVoucher).getIDVoucher();
                //Update lại SL Voucher
                bhs.update_SL_Voucher_BY_ID_Voucher(id_Voucher);
                message = (bhs.update_ThanhToan_HD_BY_IdHD(id_HD, id_Voucher, ghiChu) == 1) ? "Thanh toán thành công--Có Voucher " : "Lỗi thanh toán hóa đơn --ko voucher";
            }
            MSGHelper.alert(this, message);
            //Fill lại HD + HDCT + FormInfHD + SP
            fillHD();
            clearAllForm();
            dtm_HDCT.setRowCount(0);
            //Thiết lập lại chỉ mục
            this.indexInvoiceSelected = -1;
            this.maHDSelected = null;
        } else if (maHDSelected == null) {
            MSGHelper.alert(this, "Vui lòng chọn hóa đơn để thanh toán");
        } else if (!tinh_setup_GiaTri_TienThua()) {
            MSGHelper.alert(this, "Vui lòng điền đủ tiền khách đưa để thanh toán");
        }
    }//GEN-LAST:event_btn_thanhToanActionPerformed

    private void btn_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearActionPerformed
        txt_tienKhachDua.setText(null);
        ta_GhiChu.setText(null);
        setTKD_TT();
    }//GEN-LAST:event_btn_clearActionPerformed

    private void btn_remove1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_remove1ActionPerformed
        //Check : Chọn HĐ + Có thông tin KH.
        //Xóa thông tin khách hàng để đặt lại là khách vãng lại --> insert lại hd vs id_KhachHang.
        //--> Fill lại form ở phần trên 
        if (indexInvoiceSelected != -1 && !txt_maKH.getText().equals("KH01") && MSGHelper.confirm(this, "Bạn muỗn xóa thông tin khách hàng của hóa đơn")) {
            //Update HD = KH vãng lại
            String message = (bhs.update_IdKH_For_HD(maHDSelected, 1) == 1) ? "Hủy thông tin khách hàng thành công" : "Lỗi hủy thông tin khách hàng";
            MSGHelper.alert(this, message);
            showInfInvoiceToForm();
        } else if (indexInvoiceSelected == -1) {
            MSGHelper.alert(this, "Vui lòng chọn hóa đơn để xóa thông tin khách hàng");
        } else if (txt_maKH.getText().endsWith("KH01")) {
            MSGHelper.alert(this, "Hóa đơn chưa có thông tin khách hàng");
        }
    }//GEN-LAST:event_btn_remove1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Panel_BanHang;
    private swingStyle.btn btn_KH;
    private swingStyle.btn btn_all;
    private swingStyle.btn btn_clear;
    private swingStyle.btn btn_remove;
    private swingStyle.btn btn_remove1;
    private swingStyle.btn btn_taoDon;
    private swingStyle.btn btn_thanhToan;
    private swingStyle.btn btn_xoaDon;
    private swingStyle.Combobox cbb_danhMuc;
    private swingStyle.Combobox cbb_mauSac;
    private swingStyle.Combobox cbb_size;
    private javax.swing.JComboBox<String> cbb_voucher;
    private javax.swing.JPanel fhhnfah;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lbl_InvoiceChoosed;
    private javax.swing.JLabel lbl_numberInvoice;
    private javax.swing.JPanel pn_thongTinHoaDon;
    private javax.swing.JPanel pn_thongTinKH;
    private javax.swing.JTextArea ta_GhiChu;
    private javax.swing.JTable tbl_GioHang;
    private javax.swing.JTable tbl_HoaDon;
    private javax.swing.JTable tbl_SanPham;
    private javax.swing.JTextField txt_maHD;
    private javax.swing.JTextField txt_maKH;
    private javax.swing.JTextField txt_maNV;
    private javax.swing.JTextField txt_ngayTaoHoaDon;
    private javax.swing.JTextField txt_searchSPCT;
    private javax.swing.JTextField txt_soTienGiam;
    private javax.swing.JTextField txt_tenKH;
    private javax.swing.JTextField txt_thanhToan;
    private javax.swing.JTextField txt_tienKhachDua;
    private javax.swing.JTextField txt_tienThua;
    private javax.swing.JTextField txt_tongGiaTriHD;
    // End of variables declaration//GEN-END:variables
    //Model các bảng
    DefaultTableModel dtm_SP;
    DefaultTableModel dtm_HDCT;
    DefaultTableModel dtm_HD;
    //Model các cbb
    DefaultComboBoxModel dcb_size;
    DefaultComboBoxModel dcb_danhMuc;
    DefaultComboBoxModel dcb_mauSac;
    DefaultComboBoxModel dcb_voucher;

    //Service fill cbb
    KichCo_Service kcs = new KichCo_Service();
    DanhMuc_Service dms = new DanhMuc_Service();
    MauSac_Service mss = new MauSac_Service();
    Voucher_Service vcs = new Voucher_Service();
    //Servece bán hàng
    SP_BanHang_Service sps = new SP_BanHang_Service();//Fill SP đang bán
    BanHang_HD_Service bhs = new BanHang_HD_Service();
    BanHang_HDCT_Service bhhdcts = new BanHang_HDCT_Service();
    //in4 hóa đơn
    int indexInvoiceSelected = -1;
    String maHDSelected = null;//BĐ maHĐ chọn là null

    private void init() {
        fillCbb();
        fillSP();
        fillHD();
    }

//11. openJPanelKH
    public void openJPanelKH(Form_BanHang Obj_UI_Sell, String maHD) {
        KhachHang_List JDiaLog_ListKH = new KhachHang_List(Obj_UI_Sell, maHD);
        JDiaLog_ListKH.setVisible(true);
    }

    public void update_HD_With_Id_KH(String maHD, int id_KH) {
        //Update --> Fill lại HD --> Fill lại Form
        int result = bhs.update_IdKH_For_HD(maHD, id_KH);
        if (result == 1) {
            fillHD();
            this.tbl_HoaDon.setRowSelectionInterval(this.indexInvoiceSelected, this.indexInvoiceSelected);
            showInfInvoiceToForm();
            MSGHelper.alert(this, "cập nhật thông tin khách hàng cho hóa đơn thành công");
        }
    }

//10.Clearn Form
    public void clearAllForm() {
        txt_maKH.setText(null);
        txt_tenKH.setText(null);
        txt_maHD.setText(null);
        txt_maNV.setText(null);
        txt_ngayTaoHoaDon.setText(null);
        txt_tongGiaTriHD.setText(null);
        dcb_voucher.setSelectedItem("Chưa áp dụng voucher");
        txt_soTienGiam.setText(null);
        txt_thanhToan.setText(null);
        txt_tienKhachDua.setText(null);
        txt_tienThua.setText(null);
        ta_GhiChu.setText(null);
    }

//9.Check tiền khách đưa
    private String tienNhap = null;

    public boolean checkTienNhap() {//ko là số hoặc == 0
        try {
            long TKDLong = Long.parseLong(txt_tienKhachDua.getText());
            if (txt_tienKhachDua.getText().startsWith("0")) {
                MSGHelper.alert(this, "Tiền khách đưa không nhập số 0 ở đâu");
                return false;
            }
        } catch (NumberFormatException e) {
            MSGHelper.alert(this, "Vui lòng nhập tiến khác đưa là số");
            return false;
        }
        return true;
    }
//9.1 Tính tiền thừa --> Nếu mà tiền thừa số dương --> thanh toán đc.

    public boolean tinh_setup_GiaTri_TienThua() {
        if (!txt_tienKhachDua.getText().isEmpty()) {
            long tkdLong = Long.parseLong(txt_tienKhachDua.getText());
            long ttLong = Long.parseLong(txt_thanhToan.getText());
            txt_tienThua.setText(String.valueOf(tkdLong - ttLong));
            return tkdLong >= ttLong;
        }
        return false;
    }
//9.2(***) Check + Set tiền hợp lệ

    public void setTKD_TT() {
        this.tienNhap = txt_tienKhachDua.getText();
        if (checkTienNhap()) {//TH hợp lệ
            tinh_setup_GiaTri_TienThua();
        } else {//TH tiền nhập không hợp lệ
            if (this.tienNhap.length() <= 1) {//Giá trị đầu --> False --> Gán lại null;
                this.tienNhap = null;
                txt_tienKhachDua.setText(null);
                txt_tienThua.setText(null);
            } else if (this.tienNhap.length() >= 2) {
                this.tienNhap = txt_tienKhachDua.getText().substring(0, txt_tienKhachDua.getText().length() - 1);
                txt_tienKhachDua.setText(this.tienNhap);
                tinh_setup_GiaTri_TienThua();
            }
        }
    }

//8. Khi chọn HĐCT trong giỏ hàng. 
    public void CheckVali_When_Choosed_HDCT(int id_HDCT, String maSP) {
        HoaDonChiTiet_M hdct = bhhdcts.getHDCT_BY_Id_HDCT(id_HDCT);
        SanPham sp = sps.getSP_BY_MaSP(maSP);
        int tong_SL_SP = hdct.getSoLuongMua() + sp.getSoLuong();//Tổng SL sản phẩm đang có trong cửa hàng.

        String slnhap;
        while (true) {
            slnhap = MSGHelper.promot(this, "Thay đổi số lượng SP-" + maSP);
            if (slnhap == null) {
                MSGHelper.alert(this, "Hủy thay đổi số lượng sản phẩm");
                break;
            }
            if (Check_SL_Nhap_GioHang(tong_SL_SP, slnhap)) {
                break;
            }
        }
        if (slnhap != null) {//TH nhập hợp lệ
            int slnhapInt = Integer.valueOf(slnhap);
            if (slnhapInt == 0) {
                //-->Xóa HĐCT --> Update SL_SP
                bhhdcts.delete_HDCT(id_HDCT);
                sps.updateSL_SP_BY_IDSP(sp.getIdSP(), tong_SL_SP);

            } else if (slnhapInt > 0 && slnhapInt <= tong_SL_SP) {
                //-->Update SL SP + HĐCT 
                sps.updateSL_SP_BY_IDSP(sp.getIdSP(), (tong_SL_SP - slnhapInt));
                bhhdcts.updateSL_HDCT(id_HDCT, slnhapInt, (long) (slnhapInt * sp.getGiaBan()));
            }
            //Fill lại SP + Giỏ hàng + FormInf_Invoice
            update_TT_For_HD_BY_Id_HD(hdct.getId_HD());//Update tổng tiền dựa vào sum(hdct.thanhTien)
            //Fill lại bảng giỏ hàng + SP + Form thông tin
            fillGioHang_BY_IdHD(hdct.getId_HD());
            fillSP();
            Validate_VoucherForInvoice();
        }
    }
//8.1 : Check số lượng SP nhập trong giỏ hàng.

    private boolean Check_SL_Nhap_GioHang(int tongSL_SP, String slnhap) {
        try {
            int slnhapInt = Integer.valueOf(slnhap);
            if (slnhapInt > tongSL_SP) {
                MSGHelper.alert(this, "Số lượng tồn không đủ");
                return false;
            }
        } catch (NumberFormatException e) {
            MSGHelper.alert(this, "Vui lòng nhập số lượng sản phẩm là số");
            return false;
        }
        return true;
    }

//7. Ktra đk sản phẩm chọn
    private void CheckVali_When_Choosed_SP(String maSP) {
        SanPham sp = sps.getSP_BY_MaSP(maSP);//Lấy SP đang chọn theo MaSP
        if (this.maHDSelected != null && sp != null) {//Chek chọn HĐ + truy ra sp theo maSP?
            //Check SL nhập hợp lệ.
            String slnhap;
            while (true) {
                slnhap = MSGHelper.promot(this, "Nhập vào số lượng SP-" + maSP + " muốn mua");
                if (slnhap == null) {
                    MSGHelper.alert(this, "Hủy thêm sản phẩm");
                    break;
                }
                if (checkValidation_NhapSL_Mua(slnhap, sp.getSoLuong())) {//Chek hợp lệ
                    break;
                }
            }
            if (slnhap != null) {//Nếu nhập hợp lệ --> Xử lý.
                int ID_HD = getHD_BY_MaHD(maHDSelected).getIdHD();//Lấy ID_HĐ theo mã HĐ đag chọn
                boolean exist_SP_In_HDCT = checkExist(ID_HD, sp.getIdSP());
                //Case1 : SP chưa có --> Insert_HĐCT --> Up SL SP.
                //Case2 : SP đã có --> Upda lại SL_HĐCT --> UP SL SP.
                if (exist_SP_In_HDCT) {//tồn tại
                    System.out.println("Thông tin hđ update : " + "ID_HD : " + ID_HD + " ID_SP " + sp.getIdSP() + " GiaBan " + sp.getGiaBan() + " SL  " + slnhap);
//Update SL : HĐCT  -->Update SL : SP (SL hiện có - SL nhập ) --> Update tổng tiền HĐ.
                    HoaDonChiTiet_M hdct = bhhdcts.getHDCT_BY_IdHD_IdSP(ID_HD, sp.getIdSP());
                    int SL_HDCT_Update = hdct.getSoLuongMua() + Integer.valueOf(slnhap);//(SL hđct có + SL nhập)
                    long thanhTien = (long) (SL_HDCT_Update * hdct.getGiaBan());
                    bhhdcts.updateSL_HDCT(hdct.getId_HDCT(), SL_HDCT_Update, thanhTien);

                    int SL_SP_Update = sp.getSoLuong() - Integer.valueOf(slnhap);
                    sps.updateSL_SP_BY_IDSP(sp.getIdSP(), SL_SP_Update);

                } else {//chưa tồn tại
//insertHDCT --> UpdateSL_SP --> Update_TTien_HĐ
                    System.out.println("Thông tin hđ insert : " + "ID_HD : " + ID_HD + " ID_SP " + sp.getIdSP() + " GiaBan " + sp.getGiaBan() + " SL  " + slnhap);
                    insertHDCT(ID_HD, sp.getIdSP(), sp.getGiaBan(), Integer.valueOf(slnhap));

                    int slUp_ForSP = sp.getSoLuong() - Integer.valueOf(slnhap);//SL SP_update = SL có - SL khách hàng chọn =))
                    update_SLSP_BY_IdSP(sp.getIdSP(), slUp_ForSP);

                }
                update_TT_For_HD_BY_Id_HD(ID_HD);//Update tổng tiền dựa vào sum(hdct.thanhTien)
                //Fill lại bảng giỏ hàng + SP + Form thông tin
                fillGioHang_BY_IdHD(ID_HD);
                fillSP();
                Validate_VoucherForInvoice();
            }
        } else if (sp == null) {
            MSGHelper.alert(this, "Ko truy ra sp theo maSP --> error");
        } else if (this.maHDSelected == null) {
            MSGHelper.alert(this, "Vui lòng chọn hóa đơn để thêm sản phẩm");
        }
    }

//7.1 Check vali SL nhập.
    //Check Số + Check > 0 + Check hợp lệ.
    public boolean checkValidation_NhapSL_Mua(String SL_Mua, int SL_Max_SPCT) {
        try {
            if (Integer.valueOf(SL_Mua.trim()) <= 0) {
                MSGHelper.alert(this, "Số lượng mua > 0!");
                return false;
            } else if (Integer.valueOf(SL_Mua.trim()) > SL_Max_SPCT) {
                MSGHelper.alert(this, "Số lượng mua < Số Lượng hiện đang có!");
                return false;
            }
        } catch (NumberFormatException e) {
            MSGHelper.alert(this, "Số lượng mua chỉ là số nguyên!");
            return false;
        }
        return true;//TH SL mua <= SL max
    }

//7.2 Check SP đã tồn tại trong hóa đơn chưa
    public boolean checkExist(int id_HD, int idSPCT) {//Tồn tại --> True else False
        boolean exist = (bhhdcts.getHDCT_BY_IdHD_IdSP(id_HD, idSPCT) != null);
        return exist;
    }
//7.3(Util) Lấy Hóa đơn theo MaHD

    public HoaDon_M getHD_BY_MaHD(String maHD) {
        return bhs.getHD_BY_MaHD(maHD);
    }
//7.4 Insert HDCT

    public int insertHDCT(int idHD, int idSP, float giaBan, int slMua) {
        HoaDonChiTiet_M hdct = new HoaDonChiTiet_M();
        hdct.setId_HD(idHD);
        hdct.setId_SP(idSP);
        hdct.setGiaBan(giaBan);
        hdct.setSoLuongMua(slMua);
        hdct.setThanhTien(giaBan * slMua);
        return bhhdcts.insertHDCT(hdct);
    }
//7.5 

//7.6 update SL_SP_BY_ID_SP   
    public int update_SLSP_BY_IdSP(int id_SP, int SLUpdate) {
        return sps.updateSL_SP_BY_IDSP(id_SP, SLUpdate);
    }
//7.7 Update tổng tiền cho hóa đơn 

    public int update_TT_For_HD_BY_Id_HD(int Id_HD) {
        long tongTien = getTongTien_HD_BY_IdHD(Id_HD);
        return bhs.update_TT_HD_BY_idHD(Id_HD, tongTien);
    }
//7.8(Util) Lấy tổng tiền hóa đơn bởi ID_HĐ dựa vào SUM(ThanhTien) trong HĐCT

    public long getTongTien_HD_BY_IdHD(int ID_HD) {
        return bhs.get_TongTien_HD_BY_IdHD(ID_HD);
    }

//6.Fill lại thông tin Hóa đơn dựa vào Voucher đag chọn.
    private void Validate_VoucherForInvoice() {
        HoaDon_M hd = (maHDSelected != null) ? bhs.getHDByID(maHDSelected) : null;
        //--> Từ indexSelected --> MaHD --> HĐ
        if (hd != null) {
            if (dcb_voucher.getSelectedItem() != null && !String.valueOf(dcb_voucher.getSelectedItem()).equals("Chưa áp dụng voucher")) {//TH ko chọn.
                //--> MaVoucher đc chọn --> Voucher
                String maVoucher = String.valueOf(((Voucher) dcb_voucher.getSelectedItem()).getMa());
                Voucher VChoosed = sps.getVoucherByMaVoucher(maVoucher);
                //KT Voucher đag chọn --> Fill lại dữ liệu bảng.
                if (hd.getTongTien() >= VChoosed.getDhtoithieu()) {//TH Hóa đơn đủ đk áp dụng Voucher 
                    fillInf_WhenChoosed_Voucher(hd, VChoosed);
                    tinh_setup_GiaTri_TienThua();
                } else {//TH HĐ ko đủ đk
                    MSGHelper.alert(this, "Hóa đơn tối thiểu " + VChoosed.getDhtoithieu() + " mới áp dụng được Voucher : " + "'" + VChoosed.getTen() + "'");
                    dcb_voucher.setSelectedItem("Chưa áp dụng voucher");
                    infToForm(hd);

                }
            } else {
                dcb_voucher.setSelectedItem("Chưa áp dụng voucher");
                infToForm(hd);
                tinh_setup_GiaTri_TienThua();
            }
        } else if (hd == null) {
            MSGHelper.alert(this, "Vui lòng chọn hóa đơn để áp dụng Voucher");
            dcb_voucher.setSelectedItem("Chưa áp dụng voucher");
        } else if (hd.getTongTien() == 0) {
            MSGHelper.alert(this, "Không thể áp dụng Voucher khi chưa có sản phẩm");
            dcb_voucher.setSelectedItem("Chưa áp dụng voucher");
        }
    }

    public void insertVoucher(Voucher Vap) {
        String message = (bhs.insertVoucherForInvoice(Vap.getIDVoucher()) == 1) ? "Áp dụng voucher cho hóa đơn thành công" : "Thêm Voucher cho hóa đơn lỗi";
        MSGHelper.alert(this, message);
    }

    //Tăng hoặc giảm // maVC tăng // maVC giảm
    public void update_SL_Voucher(String upOrDown, String maVC_Increase, String maVC_reduce) {//Update lại SL Voucher +/-

    }

//5: Evt mouse click hóa đơn
    private void showInfInvoiceToForm() {
        this.maHDSelected = (String) dtm_HD.getValueAt(indexInvoiceSelected, 0);
        lbl_InvoiceChoosed.setText(maHDSelected);
        HoaDon_M hd = bhs.getHDByID(maHDSelected);
        infToForm(hd);
    }

    public void infToForm(HoaDon_M hd) {//Fill thông tin lên Form
        txt_maKH.setText(hd.getMaKH());
        txt_tenKH.setText(hd.getTenKH());

        //------------
        txt_maHD.setText(hd.getMaHD());
        txt_maNV.setText(hd.getMaNV());
        txt_ngayTaoHoaDon.setText(String.valueOf(hd.getNgayTao()));
        txt_tongGiaTriHD.setText(String.valueOf(hd.getTongTien()).replaceAll("\\.0$", ""));

        dcb_voucher.setSelectedItem("Chưa áp dụng voucher");
        txt_soTienGiam.setText("0");
        txt_thanhToan.setText(String.valueOf(hd.getTongTien()).replaceAll("\\.0$", ""));

        txt_tienKhachDua.setText(null);

        ta_GhiChu.setText(hd.getGhiChu());
        txt_tienThua.setText("0");
    }

    public void fillInf_WhenChoosed_Voucher(HoaDon_M hd, Voucher V) {//TH chọn voucher cho một HĐ.
        long soTienGiam = (long) (hd.getTongTien() * V.getTlgiam() / 100);
        if (soTienGiam > V.getGiamtoida()) {//TH hàng nó mua qua lớn
            soTienGiam = (long) V.getGiamtoida();
        }
        txt_tongGiaTriHD.setText(String.valueOf(hd.getTongTien()).replaceAll("\\.0$", ""));
        txt_soTienGiam.setText(String.valueOf(soTienGiam));
        txt_thanhToan.setText(String.valueOf(hd.getTongTien() - soTienGiam).replaceAll("\\.0$", ""));
    }

    //4: Insert hóa đơn
    private int insertHD() {
        HoaDon_M hd = new HoaDon_M();
        hd.setMaHD(randomMaHoaDon());
        hd.setIdNV(Login_Service.getIdNV());
        hd.setIdKH(1);//Default ban đầu là khách vãng lại
        hd.setTrangThai("Chờ thanh toán");
        System.out.println(Login_Service.getIdNV());
        return bhs.insertHD(hd);
    }

    public String randomMaHoaDon() {
        Set<String> generatedCodes = new HashSet<>();

        Random random = new Random();
        String code;

        do {
            String s1 = "H";
            String s2 = "D";
            String so = "1234567890";

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < 1; i++) {
                int randomIndex = random.nextInt(s1.length());
                sb.append(s1.charAt(randomIndex));
            }

            for (int i = 0; i < 1; i++) {
                int randomIndex = random.nextInt(s2.length());
                sb.append(s2.charAt(randomIndex));
            }

            for (int i = 0; i < 5; i++) {
                int randomIndex = random.nextInt(so.length());
                sb.append(so.charAt(randomIndex));
            }

            code = sb.toString();
        } while (generatedCodes.contains(code));

        generatedCodes.add(code);

        return code;
    }

//3.Fill cho hóa đơn = Giỏ hàng(Bởi Id_HD)
    private void fillHD() {
        dtm_HD = (DefaultTableModel) this.tbl_HoaDon.getModel();
        dtm_HD.setRowCount(0);
        List<HoaDon_M> listHD = bhs.getListHD();
        if (listHD != null) {
            for (HoaDon_M hd : listHD) {
                Object[] data = new Object[]{
                    hd.getMaHD(),
                    hd.getTenNV(),
                    hd.getTenKH(),
                    hd.getNgayTao(),
                    hd.getTrangThai()
                };
                dtm_HD.addRow(data);
            }
        }
        lbl_numberInvoice.setText(String.valueOf(dtm_HD.getRowCount()));
        lbl_InvoiceChoosed.setText("Ko hóa đơn được chọn");
    }

    private void fillGioHang_BY_IdHD(int Id_HD) {
        dtm_HDCT = (DefaultTableModel) this.tbl_GioHang.getModel();
        dtm_HDCT.setRowCount(0);
        List<HoaDonChiTiet_M> listHDCT = bhhdcts.getList_HDCT_BY_IdHD(Id_HD);
        if (listHDCT != null) {
            for (HoaDonChiTiet_M hdct : listHDCT) {
                Object[] data = new Object[]{
                    hdct.getId_HDCT(),
                    hdct.getMaSP(),
                    hdct.getTenSP(),
                    hdct.getGiaBan(),
                    hdct.getSoLuongMua(),
                    hdct.getThanhTien()
                };
                dtm_HDCT.addRow(data);
            }
        }
    }

//2. Thiết lập evt filter cho combobox.    
    public void fillSPBySize(String size) {
        List<SanPham> listSP = sps.getALLBySize(size);
        fillSPSell(listSP);
    }

    public void fillSPByMS(String ms) {
        List<SanPham> listSP = sps.getALLByMS(ms);
        fillSPSell(listSP);
    }

    public void fillSPByDM(String dm) {
        List<SanPham> listSP = sps.getALLByDM(dm);
        fillSPSell(listSP);
    }

//1. Hàm đầu    
    private void fillSP() {
        List<SanPham> listSP = sps.getALL();
        fillSPSell(listSP);
    }

    private void fillCbb() {//FillCbb
        dcb_size = (DefaultComboBoxModel) cbb_size.getModel();
        dcb_danhMuc = (DefaultComboBoxModel) cbb_danhMuc.getModel();
        dcb_mauSac = (DefaultComboBoxModel) cbb_mauSac.getModel();
        dcb_voucher = (DefaultComboBoxModel) cbb_voucher.getModel();
        fillComboBox(dcb_size, kcs.getAll());
        fillComboBox(dcb_mauSac, mss.getAll());
        fillComboBox(dcb_danhMuc, dms.getAll());
        fillComboBox(dcb_voucher, sps.getAll_Voucher());
    }

    //Hàm chung
    public void fillSPSell(List<SanPham> listSPSell) {
        dtm_SP = (DefaultTableModel) tbl_SanPham.getModel();
        dtm_SP.setRowCount(0);
        for (SanPham sp : listSPSell) {
            Object[] data = new Object[]{
                sp.getMaSanPham(),
                sp.getTenSanPham(),
                sp.getSize(),
                sp.getMauSac(),
                sp.getChatLieu(),
                sp.getDanhMuc(),
                sp.getSoLuong(),
                sp.getGiaBan()
            };
            dtm_SP.addRow(data);
        }
    }

    //Hàm chung
    public void fillComboBox(DefaultComboBoxModel model, List<?> list) {
        model.removeAllElements();
        dcb_voucher.addElement("Chưa áp dụng voucher");
        for (Object item : list) {
            model.addElement(item instanceof KichCo ? ((KichCo) item).getTen() : null);
            model.addElement(item instanceof MauSac ? ((MauSac) item).getTen() : null);
            model.addElement(item instanceof DanhMuc ? ((DanhMuc) item).getTen() : null);
            model.addElement(item instanceof Voucher ? ((Voucher) item) : null);
        }
        removeNullElements(model);
    }

    public void removeNullElements(DefaultComboBoxModel model) {
        for (int i = 0; i < model.getSize(); i++) {
            if (model.getElementAt(i) == null) {
                model.removeElementAt(i);
                i--; // Đảm bảo không bỏ sót phần tử sau khi xóa
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
    //---------------------------------------------------------------------------

    // Khai báo một biến cờ để kiểm tra xem có trong quá trình khởi tạo hay không
    private boolean isLoadWindow = true;

    // Sự kiện khi khởi động JFrame
    public void formWindowOpened() {
        isLoadWindow = false;// Bỏ cờ khi khởi động hoàn thành
    }
}
