package View;

import Controller.QuyenController;
import Controller.TaiKhoanController;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;

public class FormQuanLyTaiKhoan extends javax.swing.JFrame {

    public FormQuanLyTaiKhoan() {
        initComponents();
        setLocationRelativeTo(null); // Cho form vào giữa màn hình
        LoadThongTin();
        radio_TatCa.setSelected(true);

    }

    private void LoadThongTin() {
        new QuyenController().Load_CMB_Quyen(ComboBox_Quyen);
        ComboBox_Quyen.setSelectedItem("Quản Lý");
        new TaiKhoanController().QLTaiKhoan(table_taikhoan, "TatCa");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupQLTaiKhoan = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        txtTimKiem = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_taikhoan = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtTenTaiKhoan = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        ComboBox_Quyen = new javax.swing.JComboBox<>();
        btnCapNhat = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        radio_TatCa = new javax.swing.JRadioButton();
        radioQuanLy = new javax.swing.JRadioButton();
        radioNhapLieu = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });
        getContentPane().setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(new java.awt.Color(26, 25, 85));
        jPanel1.setToolTipText("");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Quản Lý Tài Khoản");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icon_timkiem.png"))); // NOI18N

        txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyReleased(evt);
            }
        });

        table_taikhoan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "STT", "Tên tài khoản", "Mật khẩu", "Quyền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_taikhoan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_taikhoanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_taikhoan);
        if (table_taikhoan.getColumnModel().getColumnCount() > 0) {
            table_taikhoan.getColumnModel().getColumn(0).setMinWidth(40);
            table_taikhoan.getColumnModel().getColumn(0).setMaxWidth(50);
        }

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Tên tài khoản :");

        txtTenTaiKhoan.setForeground(new java.awt.Color(51, 255, 0));
        txtTenTaiKhoan.setText("admin");

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Quyền :");

        btnCapNhat.setText("Cập nhật");
        btnCapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatActionPerformed(evt);
            }
        });

        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        buttonGroupQLTaiKhoan.add(radio_TatCa);
        radio_TatCa.setForeground(new java.awt.Color(255, 255, 255));
        radio_TatCa.setText("Tất cả");
        radio_TatCa.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                radio_TatCaFocusGained(evt);
            }
        });

        buttonGroupQLTaiKhoan.add(radioQuanLy);
        radioQuanLy.setForeground(new java.awt.Color(255, 255, 255));
        radioQuanLy.setText("Quản Lý");
        radioQuanLy.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                radioQuanLyFocusGained(evt);
            }
        });

        buttonGroupQLTaiKhoan.add(radioNhapLieu);
        radioNhapLieu.setForeground(new java.awt.Color(255, 255, 255));
        radioNhapLieu.setText("Nhập liệu");
        radioNhapLieu.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                radioNhapLieuFocusGained(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(125, 125, 125))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(txtTenTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(ComboBox_Quyen, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnCapNhat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnXoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(28, 28, 28))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(radio_TatCa)
                                .addGap(18, 18, 18)
                                .addComponent(radioQuanLy)
                                .addGap(18, 18, 18)
                                .addComponent(radioNhapLieu)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtTenTaiKhoan))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(ComboBox_Quyen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(btnXoa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCapNhat)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(radio_TatCa)
                            .addComponent(radioQuanLy)
                            .addComponent(radioNhapLieu))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPanel1, "card2");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        int checkxoa = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn xóa tài khoản này không ?",
                "Thông báo", JOptionPane.YES_NO_OPTION);
        if (checkxoa == 0) {
            boolean xoaTK = new TaiKhoanController().XoaTaiKhoan(txtTenTaiKhoan);
            if (xoaTK) {
                JOptionPane.showMessageDialog(null, "Xóa thành công",
                        "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                radio_TatCa.setSelected(true);
                new TaiKhoanController().QLTaiKhoan(table_taikhoan, "TatCa");
                ComboBox_Quyen.setSelectedItem("Quản Lý");
                txtTenTaiKhoan.setText("admin");
            } else {
                JOptionPane.showMessageDialog(null, "Đây là tài khoản Admin mặc định để quản lý phần mềm\n Vui lòng không xóa tài khoản này",
                        "Thông báo", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatActionPerformed
        boolean suaTK = new TaiKhoanController().CapNhatTaiKhoan(txtTenTaiKhoan, ComboBox_Quyen);
        if (suaTK) {
            JOptionPane.showMessageDialog(null, "Sửa thành công",
                    "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            radio_TatCa.setSelected(true);
            new TaiKhoanController().QLTaiKhoan(table_taikhoan, "TatCa");
            ComboBox_Quyen.setSelectedItem("Quản Lý");
            txtTenTaiKhoan.setText("admin");
        } else {
            JOptionPane.showMessageDialog(null, "Đây là tài khoản Admin mặc định để quản lý phần mềm\n Vui lòng không sửa tài khoản này",
                    "Thông báo", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnCapNhatActionPerformed

    private void txtTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyReleased
        if (radio_TatCa.isSelected()) {
            new TaiKhoanController().TimKiemTaiKhoan(table_taikhoan, txtTimKiem, "TatCa");
        }
        if (radioQuanLy.isSelected()) {
            new TaiKhoanController().TimKiemTaiKhoan(table_taikhoan, txtTimKiem, "QuanLy");
        }
        if (radioNhapLieu.isSelected()) {
            new TaiKhoanController().TimKiemTaiKhoan(table_taikhoan, txtTimKiem, "NhapLieu");
        }
        if (txtTimKiem.getText().isEmpty()) {
            if (radio_TatCa.isSelected()) {
                new TaiKhoanController().QLTaiKhoan(table_taikhoan, "TatCa");
            }
            if (radioQuanLy.isSelected()) {
                new TaiKhoanController().QLTaiKhoan(table_taikhoan, "QuanLy");
            }
            if (radioNhapLieu.isSelected()) {
                new TaiKhoanController().QLTaiKhoan(table_taikhoan, "NhapLieu");
            }
        }
    }//GEN-LAST:event_txtTimKiemKeyReleased

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosed

    private void table_taikhoanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_taikhoanMouseClicked
        int[] index = table_taikhoan.getSelectedRows();
        TableModel model = table_taikhoan.getModel();
        txtTenTaiKhoan.setText(model.getValueAt(index[0], 1).toString());
        ComboBox_Quyen.setSelectedItem(model.getValueAt(index[0], 3).toString());
    }//GEN-LAST:event_table_taikhoanMouseClicked

    private void radio_TatCaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_radio_TatCaFocusGained
        if (txtTimKiem.getText().isEmpty()) {
            new TaiKhoanController().QLTaiKhoan(table_taikhoan, "TatCa");
        } else {
            new TaiKhoanController().TimKiemTaiKhoan(table_taikhoan, txtTimKiem, "TatCa");
        }
    }//GEN-LAST:event_radio_TatCaFocusGained

    private void radioQuanLyFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_radioQuanLyFocusGained
        if (txtTimKiem.getText().isEmpty()) {
            new TaiKhoanController().QLTaiKhoan(table_taikhoan, "QuanLy");
        } else {
            new TaiKhoanController().TimKiemTaiKhoan(table_taikhoan, txtTimKiem, "QuanLy");
        }
    }//GEN-LAST:event_radioQuanLyFocusGained

    private void radioNhapLieuFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_radioNhapLieuFocusGained
        if (txtTimKiem.getText().isEmpty()) {
            new TaiKhoanController().QLTaiKhoan(table_taikhoan, "NhapLieu");
        } else {
            new TaiKhoanController().TimKiemTaiKhoan(table_taikhoan, txtTimKiem, "NhapLieu");
        }
    }//GEN-LAST:event_radioNhapLieuFocusGained

    @SuppressWarnings("Convert2Lambda")
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
            java.util.logging.Logger.getLogger(FormQuanLyTaiKhoan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormQuanLyTaiKhoan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormQuanLyTaiKhoan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormQuanLyTaiKhoan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @SuppressWarnings("override")
            public void run() {
                new FormQuanLyTaiKhoan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboBox_Quyen;
    private javax.swing.JButton btnCapNhat;
    private javax.swing.JButton btnXoa;
    private javax.swing.ButtonGroup buttonGroupQLTaiKhoan;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton radioNhapLieu;
    private javax.swing.JRadioButton radioQuanLy;
    private javax.swing.JRadioButton radio_TatCa;
    private javax.swing.JTable table_taikhoan;
    private javax.swing.JLabel txtTenTaiKhoan;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
