package view;

import DAO.MSGHelper;
import java.awt.Color;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.HoaDon;
import model.SanPham;
import model.Voucher;
import service.HoaDonlmpl;

public final class Form_HoaDon extends javax.swing.JPanel {

    public Form_HoaDon() {
        initComponents();
        init();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        txt_TuNgay = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_HoaDon = new javax.swing.JTable();
        JDC_ngayBatDau = new com.toedter.calendar.JDateChooser();
        JDC_ngayKetThuc = new com.toedter.calendar.JDateChooser();
        rd_DaThanhToan = new javax.swing.JRadioButton();
        rd_ChuaThanhToan = new javax.swing.JRadioButton();
        txt_SearchHD = new javax.swing.JTextField();
        txt_loc = new swingStyle.btn();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_HoaDonCT = new javax.swing.JTable();

        txt_TuNgay.setBackground(new java.awt.Color(255, 255, 255));
        txt_TuNgay.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Hóa đơn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N

        tbl_HoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã HĐ", "Ngày tạo", "Tên Nhân viên", "Tên Khách hàng  ", "Tên Voucher", "Phần trăm giảm", "Giảm tối đa", "Tổng tiền", "Số tiền giảm", "Thanh tiền"
            }
        ));
        tbl_HoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_HoaDonMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_HoaDon);

        JDC_ngayBatDau.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ngày bắt đầu", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N
        JDC_ngayBatDau.setPreferredSize(new java.awt.Dimension(150, 20));

        JDC_ngayKetThuc.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ngày kết thúc", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N
        JDC_ngayKetThuc.setPreferredSize(new java.awt.Dimension(150, 20));

        buttonGroup1.add(rd_DaThanhToan);
        rd_DaThanhToan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rd_DaThanhToan.setSelected(true);
        rd_DaThanhToan.setText("Đã thanh toán");
        rd_DaThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rd_DaThanhToanActionPerformed(evt);
            }
        });

        buttonGroup1.add(rd_ChuaThanhToan);
        rd_ChuaThanhToan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rd_ChuaThanhToan.setText("Chưa thanh toán");
        rd_ChuaThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rd_ChuaThanhToanActionPerformed(evt);
            }
        });

        txt_SearchHD.setForeground(java.awt.Color.gray);
        txt_SearchHD.setText("Tìm kiếm theo Mã HĐ , Tên NV , Tên KH....");
        txt_SearchHD.setBorder(javax.swing.BorderFactory.createTitledBorder("Search"));
        txt_SearchHD.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_SearchHDFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_SearchHDFocusLost(evt);
            }
        });
        txt_SearchHD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_SearchHDKeyReleased(evt);
            }
        });

        txt_loc.setText("lọc");
        txt_loc.setRadius(19);
        txt_loc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_locActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout txt_TuNgayLayout = new javax.swing.GroupLayout(txt_TuNgay);
        txt_TuNgay.setLayout(txt_TuNgayLayout);
        txt_TuNgayLayout.setHorizontalGroup(
            txt_TuNgayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(txt_TuNgayLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(txt_TuNgayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(txt_TuNgayLayout.createSequentialGroup()
                        .addComponent(txt_SearchHD, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addComponent(JDC_ngayBatDau, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(JDC_ngayKetThuc, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(txt_loc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, txt_TuNgayLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(rd_DaThanhToan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rd_ChuaThanhToan)))
                .addContainerGap())
        );
        txt_TuNgayLayout.setVerticalGroup(
            txt_TuNgayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(txt_TuNgayLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(txt_TuNgayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txt_SearchHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_loc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JDC_ngayBatDau, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                    .addComponent(JDC_ngayKetThuc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(txt_TuNgayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rd_DaThanhToan)
                    .addComponent(rd_ChuaThanhToan))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chi tiết hóa đơn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N

        tbl_HoaDonCT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã SP ", "Tên Sản phẩm", "Số lượng mua", "Giá bán", "Màu sắc", "Chất liệu", "Kích cỡ ", "Thành tiền"
            }
        ));
        jScrollPane2.setViewportView(tbl_HoaDonCT);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt_TuNgay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(txt_TuNgay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void rd_ChuaThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rd_ChuaThanhToanActionPerformed
        fill_HD(hds.getHoaDonAll2("Chờ thanh toán"));
    }//GEN-LAST:event_rd_ChuaThanhToanActionPerformed

    private void tbl_HoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_HoaDonMouseClicked
        //Khi click vào HD --> Fill HDCT
        indexRowSelected = this.tbl_HoaDon.getSelectedRow();
        if (indexRowSelected != -1) {
            String maHD = String.valueOf(tbl_HoaDon.getValueAt(indexRowSelected, 1));
            List<SanPham> listSP = hds.getListSP_BY_MaHD(maHD);
            fill_HDCT_BY_Ma_HD(listSP);
        }
    }//GEN-LAST:event_tbl_HoaDonMouseClicked

    private void txt_locActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_locActionPerformed
        //Lọc HĐ
        if (check()) {
            filter();
        }
    }//GEN-LAST:event_txt_locActionPerformed

    private void txt_SearchHDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_SearchHDKeyReleased
        String searchString = txt_SearchHD.getText();
        dtm_HD = (DefaultTableModel) this.tbl_HoaDon.getModel();
        search(searchString, dtm_HD, this.tbl_HoaDon);
    }//GEN-LAST:event_txt_SearchHDKeyReleased

    private void txt_SearchHDFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_SearchHDFocusGained
        if (txt_SearchHD.getText().equals("Tìm kiếm theo Mã HĐ , Tên NV , Tên KH....")) {
            txt_SearchHD.setText(null);
            txt_SearchHD.requestFocus(); //Yêu cầu tập trung Focus vào 1 component nào đó.
            //remove placeholder style
            removePlaceholderStyle(txt_SearchHD);
        }
    }//GEN-LAST:event_txt_SearchHDFocusGained

    private void txt_SearchHDFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_SearchHDFocusLost
        if (txt_SearchHD.getText().length() == 0) {
            //add Placeholder style 
            addPlaceholderStyle(txt_SearchHD);
            txt_SearchHD.setText("Tìm kiếm theo Mã HĐ , Tên NV , Tên KH....");
        } else {
            txt_SearchHD.setColumns(25); // Số lượng ký tự hiển thị
        }
    }//GEN-LAST:event_txt_SearchHDFocusLost

    private void rd_DaThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rd_DaThanhToanActionPerformed
        fill_HD(hds.getHoaDonAll2("Đã thanh toán"));
    }//GEN-LAST:event_rd_DaThanhToanActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser JDC_ngayBatDau;
    private com.toedter.calendar.JDateChooser JDC_ngayKetThuc;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton rd_ChuaThanhToan;
    private javax.swing.JRadioButton rd_DaThanhToan;
    private javax.swing.JTable tbl_HoaDon;
    private javax.swing.JTable tbl_HoaDonCT;
    private javax.swing.JTextField txt_SearchHD;
    private javax.swing.JPanel txt_TuNgay;
    private swingStyle.btn txt_loc;
    // End of variables declaration//GEN-END:variables
    //Model
    DefaultTableModel dtm_HD;
    DefaultTableModel dtm_HDCT;

    //Service
    HoaDonlmpl hds = new HoaDonlmpl();
    //index 
    int indexRowSelected = -1;

    private void init() {
        fill_HD(hds.getHoaDonAll2("Đã thanh toán"));
    }

    //Thực hiện tìm kiếm 
    public void filter() {
        Date nbd = (Date) JDC_ngayBatDau.getDate();
        Date nkt = (Date) JDC_ngayKetThuc.getDate();
        //Format
        String nbd_format = toString(nbd, "yyyy-MM-dd");
        String nkt_format = toString(nkt, "yyyy-MM-dd");
        //Lọc theo trạng thái hóa đơn + ngày bđ + ngày kt
        String trangThai = (rd_DaThanhToan.isSelected()) ? "Đã thanh toán" : "Chờ thanh toán";
        List<HoaDon> listHD = hds.getHoaDonAll3(trangThai, nbd_format, nkt_format);
        fill_HD(listHD);
    }
    //Chức năng : Chuyển đổi từ một đối tượng Date thành một chuỗi theo một mẫu pattern.    
    SimpleDateFormat formater = new SimpleDateFormat();

    public String toString(Date date, String pattern) {
        formater.applyPattern(pattern);
        return formater.format(date);
    }

    //Lọc theo ngày
    private boolean check() {
        if (JDC_ngayBatDau.getDate() == null) {
            MSGHelper.alert(this, "Vui lòng nhập ngày bắt đầu");
            return false;
        } else if (JDC_ngayKetThuc.getDate() == null) {
            MSGHelper.alert(this, "Vui lòng nhập ngày kết thúc");
            return false;
        }
        Date nbd = (Date) JDC_ngayBatDau.getDate();
        Date nkt = (Date) JDC_ngayKetThuc.getDate();
        if (nbd.getTime() > nkt.getTime()) {
            MSGHelper.alert(this, "Ngày bắt đầu phải nhỏ hơn ngày kết thúc");
            return false;
        }
        return true;
    }

    private void fill_HD(List<HoaDon> listHD) {
        dtm_HD = (DefaultTableModel) tbl_HoaDon.getModel();
        dtm_HD.setRowCount(0);
        int stt = 1;
        List<HoaDon> list = listHD;
        for (HoaDon hd : list) {
            Voucher v = hds.getVoucher_BY_MaHD(hd.getMaHD());
            Object[] row = new Object[]{
                stt++,
                hd.getMaHD(),
                hd.getNgayTao(),
                hd.getTenNV(),
                hd.getTenKH(),
                (v.getTen() != null) ? v.getTen() : "Không áp Voucher",
                (v.getTen() != null) ? ((int) v.getTlgiam()) + "%" : "Trống",
                (v.getTen() != null) ? v.getGiamtoida() : "Trống",
                hd.getTongTien(),
                (v.getTen() != null) ? tinhSTG(hd.getTongTien(), v.getTlgiam(), v.getGiamtoida()) : "Trống",
                (v.getTen() != null) ? (hd.getTongTien() - tinhSTG(hd.getTongTien(), v.getTlgiam(), v.getGiamtoida())) : "Trống"
            };
            dtm_HD.addRow(row);
        }
    }

//1.1(Util) tính số tiền giảm dựa vào tổng tiền , tỉ lệ giảm , giảm tối đa 
    public long tinhSTG(float tongTien, float tiLeGiam, float giamToiDa) {
//TH có áp voucher :  Số tiền giảm có 2 case -->
        //Case 1 : STG < Giới hạn giảm --> STG = Tổng tiền - ( Tổng tiền * tỉ lệ giảm ) 
        //Case 2 : STG > Giới hạn giảm --> STG = Giảm tối đa
        long soTienGiam = (long) (tongTien * tiLeGiam / 100);
        if (soTienGiam > giamToiDa) {//TH hàng nó mua qua lớn
            soTienGiam = (long) giamToiDa;
        }
        return soTienGiam;
    }

    private void fill_HDCT_BY_Ma_HD(List<SanPham> list) {
        dtm_HDCT = (DefaultTableModel) tbl_HoaDonCT.getModel();
        dtm_HDCT.setRowCount(0);
        int stt = 1;
        for (SanPham sp : list) {
            dtm_HDCT.addRow(new Object[]{
                stt++,
                sp.getMaSanPham(),
                sp.getTenSanPham(),
                sp.getSoLuong(),//SL trong HDCT
                sp.getGiaBan(),//Giá này theo giá trong HDCT
                sp.getMauSac(),
                sp.getChatLieu(),
                sp.getSize(),
                (sp.getSoLuong() * sp.getGiaBan())
            });
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
