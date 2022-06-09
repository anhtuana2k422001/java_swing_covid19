package View;

import Check_Validator.Validation;
import Controller.QuyenController;
import Controller.TaiKhoanController;
import Model.TaiKhoan;
import javax.swing.JOptionPane;

public class FromTaoTaiKhoanMoi extends javax.swing.JFrame {

    public boolean checkShowPass = true;
    
    @SuppressWarnings("OverridableMethodCallInConstructor")
    public FromTaoTaiKhoanMoi() {
        initComponents();
        setLocationRelativeTo(null); // Cho form vào giữa màn hình
        
        // load thông tin các quyền lên View
        new QuyenController().Load_CMB_Quyen(cmb_Quyen);
        
        txt_MatKhau.setEchoChar('\u25cf');
        txt_NhapLaiMK.setEchoChar('\u25cf');
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_TaiKhoan = new javax.swing.JTextField();
        btnTaoTaiKhoan = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        cmb_Quyen = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        checkboxMatKhau = new java.awt.Checkbox();
        txt_MatKhau = new javax.swing.JPasswordField();
        txt_NhapLaiMK = new javax.swing.JPasswordField();

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(51, 204, 0));

        jLabel1.setForeground(new java.awt.Color(51, 204, 0));
        jLabel1.setText("Tên tài khoản");

        jLabel2.setForeground(new java.awt.Color(51, 204, 0));
        jLabel2.setText("Mật khẩu");

        jLabel3.setForeground(new java.awt.Color(51, 204, 0));
        jLabel3.setText("Nhập lại mật khẩu");

        jLabel4.setForeground(new java.awt.Color(255, 51, 51));
        jLabel4.setText("Quyền");

        btnTaoTaiKhoan.setBackground(new java.awt.Color(51, 255, 51));
        btnTaoTaiKhoan.setText("Tạo tài khoản mới");
        btnTaoTaiKhoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoTaiKhoanActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 255));
        jLabel5.setText("THÊM TÀI KHOẢN");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        checkboxMatKhau.setLabel("Hiển thị mật khẩu");
        checkboxMatKhau.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                checkboxMatKhauItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(123, 123, 123))
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(checkboxMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txt_NhapLaiMK, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_MatKhau, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_TaiKhoan)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(131, 131, 131)
                                .addComponent(btnTaoTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(cmb_Quyen, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(38, 38, 38))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_TaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_MatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_NhapLaiMK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(checkboxMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cmb_Quyen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(66, 66, 66)
                .addComponent(btnTaoTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTaoTaiKhoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoTaiKhoanActionPerformed
       String tentk = txt_TaiKhoan.getText();
        String mk = String.valueOf(txt_MatKhau.getPassword());
        String check_mk = String.valueOf(txt_NhapLaiMK.getPassword());
        String quyen = new QuyenController().Get_MaQuyen(cmb_Quyen);
        TaiKhoan tk = new TaiKhoan(tentk,mk,quyen);
        // Gọi hàm validation để kiểm tra nhập liệu
        boolean validate = new Validation().Validate_TaiKhoan(tentk,mk,check_mk) ;
        if (validate) {
            // Gọi hàm từ TaiKhoanController để kiểm tra
            boolean Check_TaoTaiKhoan = new TaiKhoanController().TaoTaiKhoan(tk);
            if (Check_TaoTaiKhoan) {
                JOptionPane.showMessageDialog(null, "Đăng ký tài khoản mới thành công !",
                        "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Đăng ký thất bại",
                        "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnTaoTaiKhoanActionPerformed

    private void checkboxMatKhauItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_checkboxMatKhauItemStateChanged
        if (checkShowPass) {
            txt_MatKhau.setEchoChar((char) 0);
            txt_NhapLaiMK.setEchoChar((char) 0);
            checkShowPass = false;
        } else {
            txt_MatKhau.setEchoChar('\u25cf');
            txt_NhapLaiMK.setEchoChar('\u25cf');
            checkShowPass = true;
        }
    }//GEN-LAST:event_checkboxMatKhauItemStateChanged

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
            java.util.logging.Logger.getLogger(FromTaoTaiKhoanMoi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FromTaoTaiKhoanMoi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FromTaoTaiKhoanMoi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FromTaoTaiKhoanMoi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FromTaoTaiKhoanMoi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTaoTaiKhoan;
    private java.awt.Checkbox checkboxMatKhau;
    private javax.swing.JComboBox<String> cmb_Quyen;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPasswordField txt_MatKhau;
    private javax.swing.JPasswordField txt_NhapLaiMK;
    private javax.swing.JTextField txt_TaiKhoan;
    // End of variables declaration//GEN-END:variables
}
