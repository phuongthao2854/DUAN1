/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.ChatLieu;
import service.ChatLieu_Service;

/**
 *
 * @author Admin
 */
public class ChatLieu_Dialog extends javax.swing.JDialog {

    private ChatLieu_Service cs = new ChatLieu_Service();
    private DefaultTableModel model = new DefaultTableModel();
    private int index = -1;

    /**
     * Creates new form ChatLieu_Dialog
     */
    public ChatLieu_Dialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        this.fillTable(cs.getAll());
    }

    public void fillTable(List<ChatLieu> list) {
        model = (DefaultTableModel) tbl_ChatLieu.getModel();
        model.setRowCount(0);
        for (ChatLieu cl : list) {
            model.addRow(cl.toDataRow());

        }

    }

    public boolean validateForm() {
        if (txt_Ten.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Tên thuộc tính không được để trống");
            return false;
        }
        return true;
    }

    public void showForm(ChatLieu cl) {
        index = tbl_ChatLieu.getSelectedRow();
        txt_Ten.setText(tbl_ChatLieu.getValueAt(index, 1).toString());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txt_Ten = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_ChatLieu = new javax.swing.JTable();
        lbCl = new javax.swing.JLabel();
        btn_Them = new javax.swing.JButton();
        btn_Sua = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Chất liệu");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Tên TT : ");

        txt_Ten.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        tbl_ChatLieu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "Tên Thuộc Tính"
            }
        ));
        tbl_ChatLieu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_ChatLieuMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_ChatLieu);

        lbCl.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lbCl.setText("Chất Liệu");

        btn_Them.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_Them.setText("Thêm");
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(185, 185, 185)
                .addComponent(lbCl, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(25, 25, 25)
                .addComponent(txt_Ten, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_Them)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_Sua)
                .addGap(30, 30, 30))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(lbCl)
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_Ten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Sua)
                    .addComponent(btn_Them))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_ThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThemActionPerformed
        // TODO add your handling code here:
        int check = JOptionPane.showConfirmDialog(this, "Bạn có muốn thêm không ?");
        if (check == JOptionPane.YES_OPTION) {
            if(validateForm()){
                try {
                    String tenTT = txt_Ten.getText();
                    if (cs.isTenTT(tenTT)) {
                        JOptionPane.showMessageDialog(this, "Tên chất liệu đã tồn tại !");
                        return;
                    } else if (cs.insertCL(this.readForm()) > 0) {
                        JOptionPane.showMessageDialog(this, "Thêm thành công !");
                        this.fillTable(cs.getAll());
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Thêm thất bại !");
                }
            }
            

        }
    }//GEN-LAST:event_btn_ThemActionPerformed
    ChatLieu readForm() {
        String ten;
        ten = txt_Ten.getText().trim();
        return new ChatLieu(ten);
    }
    private void btn_SuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SuaActionPerformed
        int chon = JOptionPane.showConfirmDialog(this, "Bạn có muốn sửa không ?", "Sửa Nhân viên",
                JOptionPane.YES_NO_CANCEL_OPTION, 3, null);
        if (chon == 0) {
            if (index == -1) {
                JOptionPane.showMessageDialog(this, "Bạn chưa chọn dòng nào !");
            } else if (validateForm()) {//có chọn
                index = tbl_ChatLieu.getSelectedRow();
                int id = (int) tbl_ChatLieu.getValueAt(index, 0);
                if (cs.updateCL(id, readForm()) == 1) {
                    JOptionPane.showMessageDialog(this, "Sửa thành công !");
                    this.fillTable(cs.getAll());
                } else {
                    JOptionPane.showMessageDialog(this, "Sửa thất bại !");
                }
            }
        }
    }//GEN-LAST:event_btn_SuaActionPerformed

    private void tbl_ChatLieuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_ChatLieuMouseClicked
        // TODO add your handling code here:
        index = tbl_ChatLieu.getSelectedRow();
        if (index > -1) {
            showForm(cs.getAll().get(index));
        }
    }//GEN-LAST:event_tbl_ChatLieuMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ChatLieu_Dialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChatLieu_Dialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChatLieu_Dialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChatLieu_Dialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ChatLieu_Dialog dialog = new ChatLieu_Dialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Sua;
    private javax.swing.JButton btn_Them;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbCl;
    private javax.swing.JTable tbl_ChatLieu;
    private javax.swing.JTextField txt_Ten;
    // End of variables declaration//GEN-END:variables
}
