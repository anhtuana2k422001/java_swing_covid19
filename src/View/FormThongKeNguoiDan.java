package View;

import Controller.LoaiVacXinController;
import Controller.NguoiDanController;
import Controller.NhapXuatExcel;
import Controller.PhuongController;
import Controller.QuanController;
import javax.swing.JOptionPane;

public class FormThongKeNguoiDan extends javax.swing.JFrame {

    @SuppressWarnings("OverridableMethodCallInConstructor")
    public FormThongKeNguoiDan(Main form) {
        initComponents();
        setLocationRelativeTo(null); // Cho form vào giữa màn 
        formmain = form;
        form.HideFormMain();
        // load thông tin các quận lên View
        cmb_Quan.removeAllItems();// phải remove tất cả các item có sẵn trước khi thêm
        new QuanController().Load_CMB_Quan(cmb_Quan);
        // load thông tin các phường lên View
        cmb_Phuong.removeAllItems();
        new PhuongController().Load_CMB_Phuong(cmb_Phuong, cmb_Quan);

        cmb_LoaiVacxin.removeAllItems();
        new LoaiVacXinController().Load_CMB_LoaiVacxin(cmb_LoaiVacxin);
        //thống kê theo tháng
        opt_TheoThang.setSelected(true);

        cmb_Thang.setEnabled(true);
        txt_TuNgay.setEnabled(false);
        txt_DenNgay.setEnabled(false);
        //thống kê theo cả khu vực
        opt_khuVuc.setSelected(true);
       //opt_loaiVacxin.setSelected(true);
    }
    
    Main formmain = new Main();

    @SuppressWarnings("UseSpecificCatch")
    private FormThongKeNguoiDan() {
        try {
            throw new UnsupportedOperationException("Not supported yet."); 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "QUẢN LÝ TIÊM CHUNG COVID 19 THÔNG BÁO...không thể mở \n Bạn Cần Đăng Nhập Từ Giao Diện Chính để mở ! \n\n Liên hệ: 0392766630 để được hỗ trợ",
                    "Thông báo", JOptionPane.ERROR_MESSAGE);
        }
        System.exit(0);
    }
    
    //@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_ThongKe = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txt_Tong = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cmb_Quan = new javax.swing.JComboBox<>();
        cmb_Phuong = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_TuNgay = new javax.swing.JTextField();
        txt_DenNgay = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btn_ThongKe = new javax.swing.JButton();
        btn_XuatExcel = new javax.swing.JButton();
        cmb_LoaiVacxin = new javax.swing.JComboBox<>();
        opt_TheoNgay = new javax.swing.JRadioButton();
        opt_TheoThang = new javax.swing.JRadioButton();
        jLabel10 = new javax.swing.JLabel();
        cmb_Thang = new javax.swing.JComboBox<>();
        opt_loaiVacxin = new javax.swing.JCheckBox();
        opt_khuVuc = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 255));
        jLabel1.setText("THỐNG KÊ DANH SÁCH NGƯỜI DÂN");

        tbl_ThongKe.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "CMND", "Họ tên", "Năm sinh", "Giới tính", "SĐT", "Địa chỉ", "Phường", "Quận", "Ngày tiêm", "Loại vacxin", "Lần tiêm"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbl_ThongKe);
        if (tbl_ThongKe.getColumnModel().getColumnCount() > 0) {
            tbl_ThongKe.getColumnModel().getColumn(0).setPreferredWidth(10);
            tbl_ThongKe.getColumnModel().getColumn(1).setPreferredWidth(40);
            tbl_ThongKe.getColumnModel().getColumn(4).setPreferredWidth(30);
            tbl_ThongKe.getColumnModel().getColumn(5).setPreferredWidth(45);
            tbl_ThongKe.getColumnModel().getColumn(8).setPreferredWidth(40);
            tbl_ThongKe.getColumnModel().getColumn(10).setPreferredWidth(50);
            tbl_ThongKe.getColumnModel().getColumn(11).setPreferredWidth(30);
        }

        jLabel2.setBackground(new java.awt.Color(255, 255, 204));
        jLabel2.setForeground(new java.awt.Color(255, 51, 0));
        jLabel2.setText("Tổng: ");

        jLabel3.setText("Theo ngày");

        cmb_Quan.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmb_QuanItemStateChanged(evt);
            }
        });

        jLabel4.setText("Từ ngày");

        jLabel5.setText("Đến ngày");

        jLabel6.setText("Quận");

        jLabel7.setText("Phường");

        btn_ThongKe.setText("Thống kê");
        btn_ThongKe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThongKeActionPerformed(evt);
            }
        });

        btn_XuatExcel.setText("Xuất excel");
        btn_XuatExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_XuatExcelActionPerformed(evt);
            }
        });

        buttonGroup1.add(opt_TheoNgay);
        opt_TheoNgay.setText("Theo ngày");
        opt_TheoNgay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                opt_TheoNgayMouseClicked(evt);
            }
        });

        buttonGroup1.add(opt_TheoThang);
        opt_TheoThang.setText("Theo tháng");
        opt_TheoThang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                opt_TheoThangMouseClicked(evt);
            }
        });

        jLabel10.setText("Theo tháng");

        cmb_Thang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        cmb_Thang.setEnabled(false);

        opt_loaiVacxin.setText("Theo loại vacxin");

        opt_khuVuc.setText("Theo khu vực");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(43, 43, 43)
                                        .addComponent(jLabel6))
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmb_Quan, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmb_Phuong, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(opt_khuVuc)))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmb_LoaiVacxin, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(opt_TheoNgay)
                                .addGap(18, 18, 18)
                                .addComponent(opt_TheoThang))
                            .addComponent(opt_loaiVacxin))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(8, 8, 8)
                                        .addComponent(jLabel4))
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_TuNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_DenNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_Tong, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cmb_Thang, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_ThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_XuatExcel))
                        .addGap(52, 52, 52))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(366, 366, 366))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addGap(53, 53, 53))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(cmb_Thang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(txt_DenNgay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_Tong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2)
                                    .addComponent(opt_TheoThang)
                                    .addComponent(opt_TheoNgay)
                                    .addComponent(cmb_Phuong, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(txt_TuNgay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(btn_XuatExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_ThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addComponent(opt_loaiVacxin)
                                .addGap(4, 4, 4))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(opt_khuVuc)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmb_LoaiVacxin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmb_Quan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        formmain.ShowFormMain();
    }//GEN-LAST:event_formWindowClosed

    private void cmb_QuanItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmb_QuanItemStateChanged
        cmb_Phuong.removeAllItems();
        new PhuongController().Load_CMB_Phuong(cmb_Phuong, cmb_Quan);
    }//GEN-LAST:event_cmb_QuanItemStateChanged

    private void btn_ThongKeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThongKeActionPerformed
        new NguoiDanController().loadDataNguoiDan(tbl_ThongKe, txt_TuNgay, txt_DenNgay, cmb_Quan, cmb_Phuong, cmb_LoaiVacxin, opt_TheoNgay, opt_TheoThang, opt_khuVuc, opt_loaiVacxin, cmb_Thang, txt_Tong);
    }//GEN-LAST:event_btn_ThongKeActionPerformed

    private void btn_XuatExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_XuatExcelActionPerformed
         //new NguoiDanController().xuatFileExcel(tbl_ThongKe, txt_Tong);
         new NhapXuatExcel().exportExcel(tbl_ThongKe);
    }//GEN-LAST:event_btn_XuatExcelActionPerformed

    private void opt_TheoNgayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opt_TheoNgayMouseClicked
        // TODO add your handling code here:
        cmb_Thang.setEnabled(false);
        txt_TuNgay.setEnabled(true);
        txt_DenNgay.setEnabled(true);
    }//GEN-LAST:event_opt_TheoNgayMouseClicked

    private void opt_TheoThangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opt_TheoThangMouseClicked
        cmb_Thang.setEnabled(true);
        txt_TuNgay.setEnabled(false);
        txt_DenNgay.setEnabled(false);
        txt_TuNgay.setText("");
        txt_DenNgay.setText("");
    }//GEN-LAST:event_opt_TheoThangMouseClicked

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
            java.util.logging.Logger.getLogger(FormThongKeNguoiDan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormThongKeNguoiDan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormThongKeNguoiDan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormThongKeNguoiDan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @SuppressWarnings("override")
            public void run() {
                new FormThongKeNguoiDan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_ThongKe;
    private javax.swing.JButton btn_XuatExcel;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cmb_LoaiVacxin;
    private javax.swing.JComboBox<String> cmb_Phuong;
    private javax.swing.JComboBox<String> cmb_Quan;
    private javax.swing.JComboBox<String> cmb_Thang;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton opt_TheoNgay;
    private javax.swing.JRadioButton opt_TheoThang;
    private javax.swing.JCheckBox opt_khuVuc;
    private javax.swing.JCheckBox opt_loaiVacxin;
    private javax.swing.JTable tbl_ThongKe;
    private javax.swing.JTextField txt_DenNgay;
    private javax.swing.JTextField txt_Tong;
    private javax.swing.JTextField txt_TuNgay;
    // End of variables declaration//GEN-END:variables
}
