package View;

import Controller.NhanVienYTController;
import Controller.NhapXuatExcel;
import Controller.QuanController;
import javax.swing.JOptionPane;

public class FormThongKeNhanVienYTe extends javax.swing.JFrame {

    @SuppressWarnings("OverridableMethodCallInConstructor")
    public FormThongKeNhanVienYTe(Main form) {
        initComponents();
        setLocationRelativeTo(null); // Cho form vào giữa màn hình
        cmb_Quan.removeAllItems();
        new QuanController().Load_CMB_Quan(cmb_Quan);
        opt_Quan.setSelected(true);
        opt_Thang.setSelected(true);
        form.HideFormMain();
        formmain = form;
    }

    Main formmain = new Main();

    @SuppressWarnings("UseSpecificCatch")
    private FormThongKeNhanVienYTe() {
        try {
            throw new UnsupportedOperationException("Not supported yet."); 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "QUẢN LÝ TIÊM CHUNG COVID 19 THÔNG BÁO...không thể mở \n Bạn Cần Đăng Nhập Từ Giao Diện Chính để mở ! \n\n Liên hệ: 0392766630 để được hỗ trợ",
                    "Thông báo", JOptionPane.ERROR_MESSAGE);
        }
        System.exit(0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_ThongKe = new javax.swing.JTable();
        cmb_Thang = new javax.swing.JComboBox<>();
        btn_ThongKe = new javax.swing.JButton();
        cmb_Quan = new javax.swing.JComboBox<>();
        btn_XuatExcel = new javax.swing.JButton();
        opt_Thang = new javax.swing.JCheckBox();
        opt_Quan = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        txt_Tong = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 255));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setText("THỐNG KÊ NHÂN VIÊN Y TẾ");

        tbl_ThongKe.setBackground(new java.awt.Color(153, 255, 153));
        tbl_ThongKe.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã NV", "Họ tên", "SĐT", "Cơ quan", "Email", "Ngày", "Tên quận"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbl_ThongKe);
        if (tbl_ThongKe.getColumnModel().getColumnCount() > 0) {
            tbl_ThongKe.getColumnModel().getColumn(0).setPreferredWidth(10);
            tbl_ThongKe.getColumnModel().getColumn(1).setPreferredWidth(25);
            tbl_ThongKe.getColumnModel().getColumn(7).setPreferredWidth(35);
        }

        cmb_Thang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));

        btn_ThongKe.setBackground(new java.awt.Color(255, 255, 0));
        btn_ThongKe.setText("Thống kê");
        btn_ThongKe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThongKeActionPerformed(evt);
            }
        });

        btn_XuatExcel.setBackground(new java.awt.Color(255, 255, 0));
        btn_XuatExcel.setText("Xuất excel");
        btn_XuatExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_XuatExcelActionPerformed(evt);
            }
        });

        opt_Thang.setText("Theo tháng");

        opt_Quan.setText("Theo quận");

        jLabel2.setText("Tổng");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(257, 257, 257)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(opt_Thang)
                            .addComponent(opt_Quan))
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmb_Quan, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmb_Thang, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_XuatExcel)
                            .addComponent(btn_ThongKe))))
                .addContainerGap(273, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_Tong, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmb_Thang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_XuatExcel)
                    .addComponent(opt_Thang))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_ThongKe)
                    .addComponent(cmb_Quan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(opt_Quan))
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_Tong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        formmain.ShowFormMain();
    }//GEN-LAST:event_formWindowClosed

    private void btn_ThongKeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThongKeActionPerformed
        new NhanVienYTController().loadDataNVYT(tbl_ThongKe,cmb_Thang,cmb_Quan,opt_Thang,opt_Quan, txt_Tong);
    }//GEN-LAST:event_btn_ThongKeActionPerformed

    private void btn_XuatExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_XuatExcelActionPerformed
        new NhapXuatExcel().exportExcel(tbl_ThongKe);
    }//GEN-LAST:event_btn_XuatExcelActionPerformed

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
            java.util.logging.Logger.getLogger(FormThongKeNhanVienYTe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormThongKeNhanVienYTe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormThongKeNhanVienYTe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormThongKeNhanVienYTe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @SuppressWarnings("override")
            public void run() {
                new FormThongKeNhanVienYTe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_ThongKe;
    private javax.swing.JButton btn_XuatExcel;
    private javax.swing.JComboBox<String> cmb_Quan;
    private javax.swing.JComboBox<String> cmb_Thang;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JCheckBox opt_Quan;
    private javax.swing.JCheckBox opt_Thang;
    private javax.swing.JTable tbl_ThongKe;
    private javax.swing.JTextField txt_Tong;
    // End of variables declaration//GEN-END:variables
}
