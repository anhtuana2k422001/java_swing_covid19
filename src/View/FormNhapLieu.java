package View;

import Check_Validator.Validation;
import Controller.DanhSachTiemController;
import Controller.DoiNguYTController;
import Controller.DotTiemController;
import Controller.LoVacXinController;
import Controller.LoaiVacXinController;
import Controller.NhanVienYTController;
import Controller.PhuongController;
import Controller.QuanController;
import Controller.TaiKhoanController;
import Model.ConnectionModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;

public class FormNhapLieu extends javax.swing.JFrame {
    
        public Connection conn = null;
    
    @SuppressWarnings("ResultOfObjectAllocationIgnored")
    public FormNhapLieu(Main form) {
        initComponents();
        form.HideFormMain();
        formmain = form;
        setLocationRelativeTo(null); // Cho form vào giữa màn hình
 


        new LoaiVacXinController().loaddataLoaiVacXin(jTableLoaiVacXin);
        new DoiNguYTController().loaddataDoiNguYT(jTableDoiNgu);
        new QuanController().loaddataQuan(jTableQuan);
        new PhuongController.loaddataPhuong(jTablePhuong);
        new NhanVienYTController().loaddataNhanVienYT(jTablenvyt);
        new DotTiemController().loaddataDotTiem(jTableDotTiem);
        new DanhSachTiemController().loaddataDanhSachTiem(jTableDanhSachTiem);
        new LoVacXinController().loaddataLoVacXin(jTableLoVacXin);

        new DanhSachTiemController().LoadDataToComboboxDanhSachTiem(cmbMaSoDSDotTiem);
        new QuanController().Load_CMB_Quan(cmbQuan);
        new QuanController().Load_CMB_Quan(cmbQuanDotTiem);
        new PhuongController().Load_CMB_Phuong(cmbPhuongDotTiem, cmbQuanDotTiem);
        new DoiNguYTController().LoadDataToComboboxDoiNgu(cmbmadnnvyt, cmbmadoinguDotTiem);
        new LoaiVacXinController.LoadDataToComboboxLoaiVacXin(cmbMaLoaiVacXin);
        new LoVacXinController().LoadDataToComboboxLoVacXin(cmbMaSoLoDotTiem);
        
        CaiDatPhanQuyen();
    }
    Main formmain = new Main();
    @SuppressWarnings("UseSpecificCatch")
    private FormNhapLieu() {
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jLayeredPane7 = new javax.swing.JLayeredPane();
        jTabbedPaneDoiNgu = new javax.swing.JTabbedPane();
        jLayeredPane8 = new javax.swing.JLayeredPane();
        jPanel22 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        txtMaLoaiVacXin = new javax.swing.JTextField();
        txtSoMuiTiem = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        TrangThai = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        txtLieuTrinhLoaiVacXin = new javax.swing.JTextField();
        btnDeleteLoaiVacXin = new javax.swing.JButton();
        btnEditLoaiVacXin = new javax.swing.JButton();
        btnExitLoaiVacXin = new javax.swing.JButton();
        btnAddLoaiVacXin = new javax.swing.JButton();
        jLabel64 = new javax.swing.JLabel();
        txtXuatXuLoaiVacXin = new javax.swing.JTextField();
        txtTenLoaiVacXin = new javax.swing.JTextField();
        rdbtrueloaivacxin = new javax.swing.JRadioButton();
        rdbfalseloaivacxin = new javax.swing.JRadioButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtArea_MoTaLoaiVacXin = new javax.swing.JTextArea();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTableLoaiVacXin = new javax.swing.JTable();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jPanel21 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        txtMaDanhSachTiem = new javax.swing.JTextField();
        txtTenDanhSachTiem = new javax.swing.JTextField();
        btnDeleteDanhSachTiem = new javax.swing.JButton();
        btnEditDanhSachTiem = new javax.swing.JButton();
        btnExitDanhSachTiem = new javax.swing.JButton();
        btnAddDanhSachTiem = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableDanhSachTiem = new javax.swing.JTable();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        jPanel23 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        txtMaDoiNgu = new javax.swing.JTextField();
        txtTenDoiNgu = new javax.swing.JTextField();
        btnDeleteDoiNgu = new javax.swing.JButton();
        btnEditDoiNgu = new javax.swing.JButton();
        btnExitDoiNgu = new javax.swing.JButton();
        btnAddDoiNgu = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableDoiNgu = new javax.swing.JTable();
        jLayeredPane3 = new javax.swing.JLayeredPane();
        jPanel24 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        txtMaPhuong = new javax.swing.JTextField();
        txtTenPhuong = new javax.swing.JTextField();
        cmbQuan = new javax.swing.JComboBox<>();
        btnDeletePhuong = new javax.swing.JButton();
        btnEditPhuong = new javax.swing.JButton();
        btnExitPhuong = new javax.swing.JButton();
        btnAddPhuong = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTablePhuong = new javax.swing.JTable();
        jLayeredPane4 = new javax.swing.JLayeredPane();
        jPanel25 = new javax.swing.JPanel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        txtMaQuan = new javax.swing.JTextField();
        txtTenQuan = new javax.swing.JTextField();
        btnDeleteQuan = new javax.swing.JButton();
        btnEditQuan = new javax.swing.JButton();
        btnExitQuan = new javax.swing.JButton();
        btnAddQuan = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableQuan = new javax.swing.JTable();
        jLayeredPane5 = new javax.swing.JLayeredPane();
        jPanel19 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        txtMaNVYT = new javax.swing.JTextField();
        txtHoTenNVYT = new javax.swing.JTextField();
        txtSdtNVYT = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        txtCoQuan = new javax.swing.JTextField();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        cmbmadnnvyt = new javax.swing.JComboBox<>();
        btnDeleteNVYT = new javax.swing.JButton();
        btnEditNVYT = new javax.swing.JButton();
        btnExitNVYT = new javax.swing.JButton();
        btnAddNVYT = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTablenvyt = new javax.swing.JTable();
        jLayeredPane6 = new javax.swing.JLayeredPane();
        jPanel26 = new javax.swing.JPanel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        txtMaDotTiem = new javax.swing.JTextField();
        txtNgayTiem = new javax.swing.JTextField();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        cmbQuanDotTiem = new javax.swing.JComboBox<>();
        jLabel56 = new javax.swing.JLabel();
        cmbPhuongDotTiem = new javax.swing.JComboBox<>();
        cmbMaSoLoDotTiem = new javax.swing.JComboBox<>();
        btnDeleteDotTiem = new javax.swing.JButton();
        btnEditDotTiem = new javax.swing.JButton();
        btnExitDotTiem = new javax.swing.JButton();
        btnAddDotTiem = new javax.swing.JButton();
        jLabel65 = new javax.swing.JLabel();
        cmbMaSoDSDotTiem = new javax.swing.JComboBox<>();
        cmbmadoinguDotTiem = new javax.swing.JComboBox<>();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTableDotTiem = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        txtMaSoLoVacXin = new javax.swing.JTextField();
        txtSoLuongLoVacXin = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        txtHSDLoVacXin = new javax.swing.JTextField();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        cmbMaLoaiVacXin = new javax.swing.JComboBox<>();
        btnDeleteLoVacXin = new javax.swing.JButton();
        btnEditLoVacXin = new javax.swing.JButton();
        btnExitLoVacXin = new javax.swing.JButton();
        btnAddLoVacXin = new javax.swing.JButton();
        txtNSXLoVacXin = new javax.swing.JTextField();
        TrangThaiLo = new javax.swing.JLabel();
        cmbDoTuoiLoVacXin = new javax.swing.JComboBox<>();
        rdbtruelo = new javax.swing.JRadioButton();
        rdbfalselo = new javax.swing.JRadioButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTableLoVacXin = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });
        getContentPane().setLayout(new java.awt.CardLayout());

        jLayeredPane7.setLayout(new java.awt.CardLayout());

        jTabbedPaneDoiNgu.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPaneDoiNgu.setFont(new java.awt.Font("Tahoma", 0, 18));

        jPanel22.setBackground(new java.awt.Color(0, 102, 102));
        jPanel22.setForeground(new java.awt.Color(255, 255, 255));

        jLabel33.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setText("Mã loại");

        jLabel34.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText("Tên loại");

        jLabel35.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setText("Số mũi tiêm");

        jLabel36.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setText("Thông tin loại vacxin");

        jLabel61.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(255, 255, 255));
        jLabel61.setText("Mô tả");

        TrangThai.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        TrangThai.setForeground(new java.awt.Color(255, 255, 255));
        TrangThai.setText("Trạng thái");

        jLabel63.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel63.setForeground(new java.awt.Color(255, 255, 255));
        jLabel63.setText("Xuất xứ");

        btnDeleteLoaiVacXin.setBackground(new java.awt.Color(255, 255, 153));
        btnDeleteLoaiVacXin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/delete.png"))); // NOI18N
        btnDeleteLoaiVacXin.setText("Xóa");
        btnDeleteLoaiVacXin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteLoaiVacXinActionPerformed(evt);
            }
        });

        btnEditLoaiVacXin.setBackground(new java.awt.Color(255, 255, 153));
        btnEditLoaiVacXin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/OIP.jpg"))); // NOI18N
        btnEditLoaiVacXin.setText("Sửa");
        btnEditLoaiVacXin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditLoaiVacXinActionPerformed(evt);
            }
        });

        btnExitLoaiVacXin.setBackground(new java.awt.Color(255, 255, 153));
        btnExitLoaiVacXin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/exit.png"))); // NOI18N
        btnExitLoaiVacXin.setText("Thoát");
        btnExitLoaiVacXin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitLoaiVacXinActionPerformed(evt);
            }
        });

        btnAddLoaiVacXin.setBackground(new java.awt.Color(255, 255, 153));
        btnAddLoaiVacXin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Button-Add-icon.png"))); // NOI18N
        btnAddLoaiVacXin.setText("Thêm");
        btnAddLoaiVacXin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddLoaiVacXinActionPerformed(evt);
            }
        });

        jLabel64.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel64.setForeground(new java.awt.Color(255, 255, 255));
        jLabel64.setText("Liệu trình");

        buttonGroup2.add(rdbtrueloaivacxin);
        rdbtrueloaivacxin.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rdbtrueloaivacxin.setForeground(new java.awt.Color(255, 255, 255));
        rdbtrueloaivacxin.setText("True");

        buttonGroup2.add(rdbfalseloaivacxin);
        rdbfalseloaivacxin.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rdbfalseloaivacxin.setForeground(new java.awt.Color(255, 255, 255));
        rdbfalseloaivacxin.setText("False");

        txtArea_MoTaLoaiVacXin.setColumns(20);
        txtArea_MoTaLoaiVacXin.setRows(5);
        jScrollPane2.setViewportView(txtArea_MoTaLoaiVacXin);

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addComponent(jLabel36)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel33)
                            .addComponent(jLabel34)
                            .addComponent(jLabel35)
                            .addComponent(jLabel63))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtMaLoaiVacXin, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                            .addComponent(txtSoMuiTiem)
                            .addComponent(txtTenLoaiVacXin)
                            .addComponent(txtXuatXuLoaiVacXin))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel22Layout.createSequentialGroup()
                                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel61)
                                    .addComponent(TrangThai))
                                .addGap(28, 28, 28)
                                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel22Layout.createSequentialGroup()
                                        .addComponent(rdbtrueloaivacxin)
                                        .addGap(18, 18, 18)
                                        .addComponent(rdbfalseloaivacxin))
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel22Layout.createSequentialGroup()
                                .addComponent(jLabel64)
                                .addGap(28, 28, 28)
                                .addComponent(txtLieuTrinhLoaiVacXin, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnAddLoaiVacXin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnDeleteLoaiVacXin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnEditLoaiVacXin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnExitLoaiVacXin))
                        .addGap(45, 45, 45))))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel36)
                        .addGap(17, 17, 17)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel22Layout.createSequentialGroup()
                                .addComponent(jLabel61)
                                .addGap(26, 26, 26)
                                .addComponent(txtTenLoaiVacXin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(65, 65, 65)
                                .addComponent(jLabel63))
                            .addGroup(jPanel22Layout.createSequentialGroup()
                                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnEditLoaiVacXin, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnAddLoaiVacXin, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(29, 29, 29)
                                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnDeleteLoaiVacXin, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnExitLoaiVacXin, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel22Layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel33)
                                    .addComponent(txtMaLoaiVacXin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26)
                                .addComponent(jLabel34)
                                .addGap(21, 21, 21))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel35)
                            .addComponent(txtSoMuiTiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TrangThai)
                            .addComponent(rdbtrueloaivacxin)
                            .addComponent(rdbfalseloaivacxin))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtXuatXuLoaiVacXin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtLieuTrinhLoaiVacXin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel64))))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jTableLoaiVacXin.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã loại", "Tên loại", "Số mũi tiêm", "Xuất sứ", "Mô tả", "Trạng thái", "Liệu trình"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableLoaiVacXin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableLoaiVacXinMouseClicked(evt);
            }
        });
        jScrollPane9.setViewportView(jTableLoaiVacXin);

        jLayeredPane8.setLayer(jPanel22, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane8.setLayer(jScrollPane9, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane8Layout = new javax.swing.GroupLayout(jLayeredPane8);
        jLayeredPane8.setLayout(jLayeredPane8Layout);
        jLayeredPane8Layout.setHorizontalGroup(
            jLayeredPane8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane9)
        );
        jLayeredPane8Layout.setVerticalGroup(
            jLayeredPane8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane8Layout.createSequentialGroup()
                .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPaneDoiNgu.addTab("Loại Vắc xin", jLayeredPane8);

        jPanel21.setBackground(new java.awt.Color(0, 102, 102));
        jPanel21.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel29.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Thông tin danh sách tiêm");

        jLabel30.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("Mã DS");

        jLabel31.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("Tên DS");

        btnDeleteDanhSachTiem.setBackground(new java.awt.Color(255, 255, 153));
        btnDeleteDanhSachTiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/delete.png"))); // NOI18N
        btnDeleteDanhSachTiem.setText("Xóa");
        btnDeleteDanhSachTiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteDanhSachTiemActionPerformed(evt);
            }
        });

        btnEditDanhSachTiem.setBackground(new java.awt.Color(255, 255, 153));
        btnEditDanhSachTiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/OIP.jpg"))); // NOI18N
        btnEditDanhSachTiem.setText("Sửa");
        btnEditDanhSachTiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditDanhSachTiemActionPerformed(evt);
            }
        });

        btnExitDanhSachTiem.setBackground(new java.awt.Color(255, 255, 153));
        btnExitDanhSachTiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/exit.png"))); // NOI18N
        btnExitDanhSachTiem.setText("Thoát");
        btnExitDanhSachTiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitDanhSachTiemActionPerformed(evt);
            }
        });

        btnAddDanhSachTiem.setBackground(new java.awt.Color(255, 255, 153));
        btnAddDanhSachTiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Button-Add-icon.png"))); // NOI18N
        btnAddDanhSachTiem.setText("Thêm");
        btnAddDanhSachTiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddDanhSachTiemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnDeleteDanhSachTiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAddDanhSachTiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnExitDanhSachTiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEditDanhSachTiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel29)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel30)
                            .addComponent(jLabel31))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTenDanhSachTiem, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaDanhSachTiem, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(37, 37, 37))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel29)
                .addGap(34, 34, 34)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(txtMaDanhSachTiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(txtTenDanhSachTiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(91, 91, 91)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditDanhSachTiem, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddDanhSachTiem, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDeleteDanhSachTiem, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExitDanhSachTiem, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTableDanhSachTiem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã DS", "Tên DS"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableDanhSachTiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableDanhSachTiemMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTableDanhSachTiem);

        jLayeredPane1.setLayer(jPanel21, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jScrollPane3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 703, Short.MAX_VALUE)
                .addContainerGap())
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 552, Short.MAX_VALUE)
        );

        jTabbedPaneDoiNgu.addTab("Danh sách tiêm", jLayeredPane1);

        jPanel23.setBackground(new java.awt.Color(0, 102, 102));
        jPanel23.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel37.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setText("Thông tin đội ngũ");

        jLabel38.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setText("Mã ĐN");

        jLabel39.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setText("Tên ĐN");

        btnDeleteDoiNgu.setBackground(new java.awt.Color(255, 255, 153));
        btnDeleteDoiNgu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/delete.png"))); // NOI18N
        btnDeleteDoiNgu.setText("Xóa");
        btnDeleteDoiNgu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteDoiNguActionPerformed(evt);
            }
        });

        btnEditDoiNgu.setBackground(new java.awt.Color(255, 255, 153));
        btnEditDoiNgu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/OIP.jpg"))); // NOI18N
        btnEditDoiNgu.setText("Sửa");
        btnEditDoiNgu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditDoiNguActionPerformed(evt);
            }
        });

        btnExitDoiNgu.setBackground(new java.awt.Color(255, 255, 153));
        btnExitDoiNgu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/exit.png"))); // NOI18N
        btnExitDoiNgu.setText("Thoát");
        btnExitDoiNgu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitDoiNguActionPerformed(evt);
            }
        });

        btnAddDoiNgu.setBackground(new java.awt.Color(255, 255, 153));
        btnAddDoiNgu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Button-Add-icon.png"))); // NOI18N
        btnAddDoiNgu.setText("Thêm");
        btnAddDoiNgu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddDoiNguActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel37)
                            .addGroup(jPanel23Layout.createSequentialGroup()
                                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel38)
                                    .addComponent(jLabel39))
                                .addGap(28, 28, 28)
                                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTenDoiNgu, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMaDoiNgu, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(37, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnDeleteDoiNgu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAddDoiNgu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnEditDoiNgu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnExitDoiNgu))
                        .addGap(62, 62, 62))))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel37)
                .addGap(34, 34, 34)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(txtMaDoiNgu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39)
                    .addComponent(txtTenDoiNgu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(92, 92, 92)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditDoiNgu, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddDoiNgu, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDeleteDoiNgu, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExitDoiNgu, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTableDoiNgu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Stt", "Mã ĐN", "Tên ĐN"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableDoiNgu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableDoiNguMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTableDoiNgu);

        jLayeredPane2.setLayer(jPanel23, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jScrollPane4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane2Layout = new javax.swing.GroupLayout(jLayeredPane2);
        jLayeredPane2.setLayout(jLayeredPane2Layout);
        jLayeredPane2Layout.setHorizontalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane2Layout.createSequentialGroup()
                .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
                .addContainerGap())
        );
        jLayeredPane2Layout.setVerticalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 552, Short.MAX_VALUE)
        );

        jTabbedPaneDoiNgu.addTab("Đội ngũ", jLayeredPane2);

        jPanel24.setBackground(new java.awt.Color(0, 102, 102));
        jPanel24.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel32.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("Thông tin phường");

        jLabel40.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setText("Mã phường");

        jLabel41.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 255, 255));
        jLabel41.setText("Tên phường");

        jLabel42.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(255, 255, 255));
        jLabel42.setText("Quận");

        cmbQuan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbQuanActionPerformed(evt);
            }
        });

        btnDeletePhuong.setBackground(new java.awt.Color(255, 255, 153));
        btnDeletePhuong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/delete.png"))); // NOI18N
        btnDeletePhuong.setText("Xóa");
        btnDeletePhuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletePhuongActionPerformed(evt);
            }
        });

        btnEditPhuong.setBackground(new java.awt.Color(255, 255, 153));
        btnEditPhuong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/OIP.jpg"))); // NOI18N
        btnEditPhuong.setText("Sửa");
        btnEditPhuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditPhuongActionPerformed(evt);
            }
        });

        btnExitPhuong.setBackground(new java.awt.Color(255, 255, 153));
        btnExitPhuong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/exit.png"))); // NOI18N
        btnExitPhuong.setText("Thoát");
        btnExitPhuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitPhuongActionPerformed(evt);
            }
        });

        btnAddPhuong.setBackground(new java.awt.Color(255, 255, 153));
        btnAddPhuong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Button-Add-icon.png"))); // NOI18N
        btnAddPhuong.setText("Thêm");
        btnAddPhuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddPhuongActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel32)
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel40)
                            .addComponent(jLabel41)
                            .addComponent(jLabel42))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTenPhuong, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                            .addComponent(txtMaPhuong, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                            .addComponent(cmbQuan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel24Layout.createSequentialGroup()
                .addContainerGap(93, Short.MAX_VALUE)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAddPhuong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDeletePhuong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnEditPhuong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnExitPhuong))
                .addGap(70, 70, 70))
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel32)
                .addGap(34, 34, 34)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel40)
                    .addComponent(txtMaPhuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel41)
                    .addComponent(txtTenPhuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbQuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel42))
                .addGap(90, 90, 90)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditPhuong, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddPhuong, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDeletePhuong, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExitPhuong, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTablePhuong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Stt", "Mã phường", "Tên phường", "Quận"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTablePhuong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablePhuongMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(jTablePhuong);

        jLayeredPane3.setLayer(jPanel24, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(jScrollPane5, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane3Layout = new javax.swing.GroupLayout(jLayeredPane3);
        jLayeredPane3.setLayout(jLayeredPane3Layout);
        jLayeredPane3Layout.setHorizontalGroup(
            jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane3Layout.createSequentialGroup()
                .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 685, Short.MAX_VALUE))
        );
        jLayeredPane3Layout.setVerticalGroup(
            jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 552, Short.MAX_VALUE)
        );

        jTabbedPaneDoiNgu.addTab("Phường", jLayeredPane3);

        jPanel25.setBackground(new java.awt.Color(0, 102, 102));
        jPanel25.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel43.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(255, 255, 255));
        jLabel43.setText("Thông tin quận");

        jLabel44.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(255, 255, 255));
        jLabel44.setText("Mã quận");

        jLabel45.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(255, 255, 255));
        jLabel45.setText("Tên quận");

        btnDeleteQuan.setBackground(new java.awt.Color(255, 255, 153));
        btnDeleteQuan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/delete.png"))); // NOI18N
        btnDeleteQuan.setText("Xóa");
        btnDeleteQuan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteQuanActionPerformed(evt);
            }
        });

        btnEditQuan.setBackground(new java.awt.Color(255, 255, 153));
        btnEditQuan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/OIP.jpg"))); // NOI18N
        btnEditQuan.setText("Sửa");
        btnEditQuan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditQuanActionPerformed(evt);
            }
        });

        btnExitQuan.setBackground(new java.awt.Color(255, 255, 153));
        btnExitQuan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/exit.png"))); // NOI18N
        btnExitQuan.setText("Thoát");
        btnExitQuan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitQuanActionPerformed(evt);
            }
        });

        btnAddQuan.setBackground(new java.awt.Color(255, 255, 153));
        btnAddQuan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Button-Add-icon.png"))); // NOI18N
        btnAddQuan.setText("Thêm");
        btnAddQuan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddQuanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel43)
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel44)
                            .addComponent(jLabel45))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTenQuan, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                            .addComponent(txtMaQuan))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnDeleteQuan, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                    .addComponent(btnAddQuan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnEditQuan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnExitQuan))
                .addGap(63, 63, 63))
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel43)
                .addGap(34, 34, 34)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel44)
                    .addComponent(txtMaQuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel45)
                    .addComponent(txtTenQuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(87, 87, 87)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditQuan, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddQuan, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDeleteQuan, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExitQuan, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTableQuan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Stt", "Mã quận", "Tên quận"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableQuan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableQuanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableQuan);

        jLayeredPane4.setLayer(jPanel25, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane4Layout = new javax.swing.GroupLayout(jLayeredPane4);
        jLayeredPane4.setLayout(jLayeredPane4Layout);
        jLayeredPane4Layout.setHorizontalGroup(
            jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane4Layout.createSequentialGroup()
                .addComponent(jPanel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 726, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jLayeredPane4Layout.setVerticalGroup(
            jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane4Layout.createSequentialGroup()
                .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 546, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPaneDoiNgu.addTab("Quận", jLayeredPane4);

        jPanel19.setBackground(new java.awt.Color(0, 102, 102));

        jLabel22.setBackground(new java.awt.Color(255, 255, 255));
        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Mã nhân viên");

        jLabel23.setBackground(new java.awt.Color(255, 255, 255));
        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Họ tên");

        jLabel24.setBackground(new java.awt.Color(255, 255, 255));
        jLabel24.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("SDT");

        jLabel21.setBackground(new java.awt.Color(255, 255, 255));
        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Thông tin nhân viên YT");

        jLabel46.setBackground(new java.awt.Color(255, 255, 255));
        jLabel46.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(255, 255, 255));
        jLabel46.setText("Mã ĐN");

        jLabel47.setBackground(new java.awt.Color(255, 255, 255));
        jLabel47.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(255, 255, 255));
        jLabel47.setText("Cơ quan");

        jLabel48.setBackground(new java.awt.Color(255, 255, 255));
        jLabel48.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(255, 255, 255));
        jLabel48.setText("Email");

        btnDeleteNVYT.setBackground(new java.awt.Color(255, 255, 153));
        btnDeleteNVYT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/delete.png"))); // NOI18N
        btnDeleteNVYT.setText("Xóa");
        btnDeleteNVYT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteNVYTActionPerformed(evt);
            }
        });

        btnEditNVYT.setBackground(new java.awt.Color(255, 255, 153));
        btnEditNVYT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/OIP.jpg"))); // NOI18N
        btnEditNVYT.setText("Sửa");
        btnEditNVYT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditNVYTActionPerformed(evt);
            }
        });

        btnExitNVYT.setBackground(new java.awt.Color(255, 255, 153));
        btnExitNVYT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/exit.png"))); // NOI18N
        btnExitNVYT.setText("Thoát");
        btnExitNVYT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitNVYTActionPerformed(evt);
            }
        });

        btnAddNVYT.setBackground(new java.awt.Color(255, 255, 153));
        btnAddNVYT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Button-Add-icon.png"))); // NOI18N
        btnAddNVYT.setText("Thêm");
        btnAddNVYT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddNVYTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel22)
                            .addComponent(jLabel23)
                            .addComponent(jLabel24))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSdtNVYT, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtHoTenNVYT, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaNVYT, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel46)
                            .addComponent(jLabel47)
                            .addComponent(jLabel48))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtEmail)
                            .addComponent(txtCoQuan)
                            .addComponent(cmbmadnnvyt, 0, 214, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 155, Short.MAX_VALUE)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnAddNVYT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnDeleteNVYT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnEditNVYT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnExitNVYT))
                        .addGap(45, 45, 45))))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21)
                .addGap(20, 20, 20)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel46)
                            .addComponent(cmbmadnnvyt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel47)
                            .addComponent(txtCoQuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtSdtNVYT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel48)
                                .addComponent(jLabel24))
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(txtMaNVYT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel23)
                            .addComponent(txtHoTenNVYT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnEditNVYT, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAddNVYT, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(60, 60, 60)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnDeleteNVYT, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnExitNVYT, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jTablenvyt.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã NV", "Họ tên", "SDT", "Mã ĐN", "Cơ quan", "Email"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTablenvyt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablenvytMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(jTablenvyt);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jLayeredPane5.setLayer(jPanel19, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane5.setLayer(jPanel5, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane5Layout = new javax.swing.GroupLayout(jLayeredPane5);
        jLayeredPane5.setLayout(jLayeredPane5Layout);
        jLayeredPane5Layout.setHorizontalGroup(
            jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jLayeredPane5Layout.setVerticalGroup(
            jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane5Layout.createSequentialGroup()
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPaneDoiNgu.addTab("Nhân viên YT", jLayeredPane5);

        jPanel26.setBackground(new java.awt.Color(0, 102, 102));

        jLabel49.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(255, 255, 255));
        jLabel49.setText("Mã đợt tiêm");

        jLabel50.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(255, 255, 255));
        jLabel50.setText("Ngày tiêm");

        jLabel52.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(255, 255, 255));
        jLabel52.setText("Thông tin đợt tiêm");

        jLabel53.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(255, 255, 255));
        jLabel53.setText("Quận");

        jLabel54.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(255, 255, 255));
        jLabel54.setText("Phường");

        jLabel55.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(255, 255, 255));
        jLabel55.setText("Mã Số lô");

        cmbQuanDotTiem.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbQuanDotTiemItemStateChanged(evt);
            }
        });

        jLabel56.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(255, 255, 255));
        jLabel56.setText("Mã ĐN");

        btnDeleteDotTiem.setBackground(new java.awt.Color(255, 255, 153));
        btnDeleteDotTiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/delete.png"))); // NOI18N
        btnDeleteDotTiem.setText("Xóa");
        btnDeleteDotTiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteDotTiemActionPerformed(evt);
            }
        });

        btnEditDotTiem.setBackground(new java.awt.Color(255, 255, 153));
        btnEditDotTiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/OIP.jpg"))); // NOI18N
        btnEditDotTiem.setText("Sửa");
        btnEditDotTiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditDotTiemActionPerformed(evt);
            }
        });

        btnExitDotTiem.setBackground(new java.awt.Color(255, 255, 153));
        btnExitDotTiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/exit.png"))); // NOI18N
        btnExitDotTiem.setText("Thoát");
        btnExitDotTiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitDotTiemActionPerformed(evt);
            }
        });

        btnAddDotTiem.setBackground(new java.awt.Color(255, 255, 153));
        btnAddDotTiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Button-Add-icon.png"))); // NOI18N
        btnAddDotTiem.setText("Thêm");
        btnAddDotTiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddDotTiemActionPerformed(evt);
            }
        });

        jLabel65.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel65.setForeground(new java.awt.Color(255, 255, 255));
        jLabel65.setText("Mã số DS");

        cmbMaSoDSDotTiem.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
                cmbMaSoDSDotTiemAncestorRemoved(evt);
            }
        });

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addComponent(jLabel52)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel49)
                            .addComponent(jLabel53)
                            .addComponent(jLabel54)
                            .addGroup(jPanel26Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel50)))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbPhuongDotTiem, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbQuanDotTiem, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNgayTiem, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaDotTiem, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel65)
                            .addComponent(jLabel56)
                            .addComponent(jLabel55))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbMaSoLoDotTiem, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(cmbMaSoDSDotTiem, 0, 231, Short.MAX_VALUE)
                                .addComponent(cmbmadoinguDotTiem, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 155, Short.MAX_VALUE)
                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnDeleteDotTiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAddDotTiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnEditDotTiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnExitDotTiem))
                        .addGap(34, 34, 34))))
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel52)
                .addGap(20, 20, 20)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel49)
                            .addComponent(txtMaDotTiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel55)
                            .addComponent(cmbMaSoLoDotTiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel26Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(jLabel65))
                            .addGroup(jPanel26Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtNgayTiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel50))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel53)
                            .addComponent(cmbQuanDotTiem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel54)
                            .addComponent(cmbPhuongDotTiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnEditDotTiem, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAddDotTiem, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbMaSoDSDotTiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnDeleteDotTiem, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnExitDotTiem, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbmadoinguDotTiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel56))))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jTableDotTiem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã đợt tiêm", "Ngày tiêm", "Quận", "Phường", "Mã số lô", "Mã DS", "Mã đội ngũ"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableDotTiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableDotTiemMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(jTableDotTiem);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane7)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
        );

        jLayeredPane6.setLayer(jPanel26, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane6.setLayer(jPanel6, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane6Layout = new javax.swing.GroupLayout(jLayeredPane6);
        jLayeredPane6.setLayout(jLayeredPane6Layout);
        jLayeredPane6Layout.setHorizontalGroup(
            jLayeredPane6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jLayeredPane6Layout.setVerticalGroup(
            jLayeredPane6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane6Layout.createSequentialGroup()
                .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPaneDoiNgu.addTab("Đợt tiêm", jLayeredPane6);

        jPanel1.setLayout(null);

        jPanel20.setBackground(new java.awt.Color(0, 102, 102));

        jLabel25.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Mã số lô");

        jLabel26.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Số lượng");

        jLabel27.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Mã loại");

        jLabel28.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("Thông tin lô vắc xin");

        jLabel57.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(255, 255, 255));
        jLabel57.setText("Ngày sản xuất");

        jLabel58.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(255, 255, 255));
        jLabel58.setText("Ngày hết hạn");

        jLabel59.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(255, 255, 255));
        jLabel59.setText("Độ tuổi");

        btnDeleteLoVacXin.setBackground(new java.awt.Color(255, 255, 153));
        btnDeleteLoVacXin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/delete.png"))); // NOI18N
        btnDeleteLoVacXin.setText("Xóa");
        btnDeleteLoVacXin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteLoVacXinActionPerformed(evt);
            }
        });

        btnEditLoVacXin.setBackground(new java.awt.Color(255, 255, 153));
        btnEditLoVacXin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/OIP.jpg"))); // NOI18N
        btnEditLoVacXin.setText("Sửa");
        btnEditLoVacXin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditLoVacXinActionPerformed(evt);
            }
        });

        btnExitLoVacXin.setBackground(new java.awt.Color(255, 255, 153));
        btnExitLoVacXin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/exit.png"))); // NOI18N
        btnExitLoVacXin.setText("Thoát");
        btnExitLoVacXin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitLoVacXinActionPerformed(evt);
            }
        });

        btnAddLoVacXin.setBackground(new java.awt.Color(255, 255, 153));
        btnAddLoVacXin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Button-Add-icon.png"))); // NOI18N
        btnAddLoVacXin.setText("Thêm");
        btnAddLoVacXin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddLoVacXinActionPerformed(evt);
            }
        });

        TrangThaiLo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        TrangThaiLo.setForeground(new java.awt.Color(255, 255, 255));
        TrangThaiLo.setText("Trạng thái");

        cmbDoTuoiLoVacXin.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1-12", "12-16", "18-80", "80-100", "Trên 100" }));

        buttonGroup1.add(rdbtruelo);
        rdbtruelo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rdbtruelo.setForeground(new java.awt.Color(255, 255, 255));
        rdbtruelo.setText("True");

        buttonGroup1.add(rdbfalselo);
        rdbfalselo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rdbfalselo.setForeground(new java.awt.Color(255, 255, 255));
        rdbfalselo.setText("False");

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addComponent(jLabel28)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel25)
                            .addComponent(jLabel26)
                            .addComponent(jLabel27))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSoLuongLoVacXin, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaSoLoVacXin, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbMaLoaiVacXin, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel57)
                            .addComponent(jLabel58)
                            .addComponent(jLabel59)
                            .addComponent(TrangThaiLo))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtHSDLoVacXin, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                                    .addComponent(txtNSXLoVacXin))
                                .addComponent(cmbDoTuoiLoVacXin, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel20Layout.createSequentialGroup()
                                .addComponent(rdbtruelo)
                                .addGap(18, 18, 18)
                                .addComponent(rdbfalselo)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 187, Short.MAX_VALUE)
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnAddLoVacXin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnDeleteLoVacXin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnEditLoVacXin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnExitLoVacXin))
                        .addGap(45, 45, 45))))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel28)
                .addGap(17, 17, 17)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel57)
                            .addComponent(txtNSXLoVacXin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel58)
                            .addComponent(txtHSDLoVacXin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdbtruelo)
                            .addComponent(rdbfalselo)
                            .addComponent(btnDeleteLoVacXin, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnExitLoVacXin, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel59)
                            .addComponent(cmbDoTuoiLoVacXin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel25)
                            .addComponent(txtMaSoLoVacXin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel26)
                            .addComponent(txtSoLuongLoVacXin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27)
                            .addComponent(cmbMaLoaiVacXin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TrangThaiLo)))
                    .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnEditLoVacXin, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAddLoVacXin, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel20);
        jPanel20.setBounds(0, 0, 1080, 230);

        jTableLoVacXin.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã số lô", "Số lượng", "Mã loại", "Ngày sản xuất", "HSD", "Trạng thái", "Độ tuổi"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableLoVacXin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableLoVacXinMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(jTableLoVacXin);

        jPanel1.add(jScrollPane8);
        jScrollPane8.setBounds(0, 230, 1080, 320);

        jTabbedPaneDoiNgu.addTab("Lô Vacxin", jPanel1);

        jLayeredPane7.add(jTabbedPaneDoiNgu, "card2");
        jTabbedPaneDoiNgu.getAccessibleContext().setAccessibleName("");

        getContentPane().add(jLayeredPane7, "card2");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CaiDatPhanQuyen() {
        @SuppressWarnings("UnusedAssignment")
        boolean check = true;
        check = new TaiKhoanController().KiemTraQuyenAdmin(formmain.txtTaiKhoanDangNhap.getText());
        if (check) {
            jTabbedPaneDoiNgu.remove(jLayeredPane1);
            jTabbedPaneDoiNgu.remove(jLayeredPane2);
            jTabbedPaneDoiNgu.remove(jLayeredPane3);            
            jTabbedPaneDoiNgu.remove(jLayeredPane5);
            jTabbedPaneDoiNgu.remove(jLayeredPane6);
            jTabbedPaneDoiNgu.remove(jLayeredPane8);
            jTabbedPaneDoiNgu.remove(jPanel1);
             
            jTabbedPaneDoiNgu.add(jLayeredPane8);
            jTabbedPaneDoiNgu.add(jLayeredPane1);
            jTabbedPaneDoiNgu.add(jLayeredPane2);            
            jTabbedPaneDoiNgu.add(jLayeredPane3);
            jTabbedPaneDoiNgu.add(jLayeredPane4);
            jTabbedPaneDoiNgu.add(jLayeredPane5);
            jTabbedPaneDoiNgu.add(jLayeredPane6);
            jTabbedPaneDoiNgu.add(jPanel1);
            jTabbedPaneDoiNgu.setTitleAt(0, "Loại vắc xin");            
            jTabbedPaneDoiNgu.setTitleAt(1, "Danh sách tiêm");
            jTabbedPaneDoiNgu.setTitleAt(2, "Đội ngũ");
            jTabbedPaneDoiNgu.setTitleAt(3, "Phường");            
            jTabbedPaneDoiNgu.setTitleAt(4, "Quận");
            jTabbedPaneDoiNgu.setTitleAt(5, "Nhân viên YT");
             jTabbedPaneDoiNgu.setTitleAt(6, "Đợt tiêm");
            jTabbedPaneDoiNgu.setTitleAt(7, "Lô vắc xin");

        } else {
            jTabbedPaneDoiNgu.remove(jLayeredPane8);
            jTabbedPaneDoiNgu.remove(jLayeredPane3);
            jTabbedPaneDoiNgu.remove(jLayeredPane4);
            jTabbedPaneDoiNgu.remove(jPanel1);
        }
    }
    
    @SuppressWarnings({"UseSpecificCatch", "static-access", "ConvertToTryWithResources"})
    private void btnAddDotTiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddDotTiemActionPerformed
        try {
            conn = new ConnectionModel().getConnection();
            String sql = "insert into DotTiem(madottiem,ngaytiem,maquan,maphuong,masolo,masods,madoingu) values(?,?,?,?,?,?,?)";
            String madottiem = String.valueOf(txtMaDotTiem.getText());
            boolean validate = new Validation().Validate_Madottiem(madottiem);
            if (validate) {
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, txtMaDotTiem.getText());
                pstmt.setString(2, txtNgayTiem.getText());
                
                String tenquan = cmbQuanDotTiem.getSelectedItem().toString();
                String maquan = new QuanController().LayMaquan_TheoTenQuan(tenquan);
                String tenphuong = cmbPhuongDotTiem.getSelectedItem().toString();
                String maphuong = new PhuongController().LayMapuong_TheoTenphuong(tenphuong);
                pstmt.setString(3, maquan);
                pstmt.setString(4, maphuong);
                
                String lovacxin = cmbMaSoLoDotTiem.getSelectedItem().toString();
                pstmt.setString(5, lovacxin);
                String danhsachtiem = cmbMaSoDSDotTiem.getSelectedItem().toString();
                pstmt.setString(6, danhsachtiem);
                String doingu = cmbmadoinguDotTiem.getSelectedItem().toString();
                pstmt.setString(7, doingu);
                pstmt.executeUpdate();
                new DotTiemController().loaddataDotTiem(jTableDotTiem);
                JOptionPane.showMessageDialog(this, "Thêm mới thành công!");
                pstmt.close();
                conn.close();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }

    }//GEN-LAST:event_btnAddDotTiemActionPerformed

     @SuppressWarnings({"UseSpecificCatch", "static-access", "ConvertToTryWithResources"})
    private void btnAddNVYTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddNVYTActionPerformed
        try {
            conn = new ConnectionModel().getConnection();
            String sql = "insert into NhanVienYT(manhanvienyt,tennhanvienyt,sdt,madoingu,coquan,email) values(?,?,?,?,?,?)";
            String manhanvienyt = String.valueOf(txtMaNVYT.getText());
            boolean validate = new Validation().Validate_MaNhanVienYT(manhanvienyt);
            if (validate) {
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, txtMaNVYT.getText());
                pstmt.setString(2, txtHoTenNVYT.getText());
                pstmt.setString(3, txtSdtNVYT.getText());
                String madoingu = cmbmadnnvyt.getSelectedItem().toString();
                pstmt.setString(4, madoingu);
                pstmt.setString(5, txtCoQuan.getText());
                pstmt.setString(6, txtEmail.getText());
                pstmt.executeUpdate();
                new NhanVienYTController().loaddataNhanVienYT(jTablenvyt);
                JOptionPane.showMessageDialog(this, "Thêm mới thành công!");
                pstmt.close();
                conn.close();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_btnAddNVYTActionPerformed

     @SuppressWarnings({"UseSpecificCatch", "static-access", "ConvertToTryWithResources"})
    private void btnAddQuanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddQuanActionPerformed
        try {
            conn = new ConnectionModel().getConnection();
            String sql = "insert into Quan(maquan,tenquan) values(?,?)";
            String maquan = String.valueOf(txtMaQuan.getText());
            boolean validate = new Validation().Validate_MaQuan(maquan);
            if (validate) {
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, txtMaQuan.getText());
                pstmt.setString(2, txtTenQuan.getText());
                pstmt.executeUpdate();
                new QuanController().loaddataQuan(jTableQuan);
                JOptionPane.showMessageDialog(this, "Thêm mới thành công!");
                pstmt.close();
                conn.close();
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_btnAddQuanActionPerformed

    @SuppressWarnings({"UseSpecificCatch", "static-access", "ConvertToTryWithResources", "ResultOfObjectAllocationIgnored"})
    private void btnAddPhuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddPhuongActionPerformed
        try {
            conn = new ConnectionModel().getConnection();
            String sql = "insert into Phuong(maphuong,tenphuong,maquan) values(?,?,?)";
            // Gọi hàm validation để kiểm tra nhập liệu
            String maphuong = String.valueOf(txtMaPhuong.getText());
            boolean validate = new Validation().Validate_MaPhuong(maphuong);
            if (validate) {
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, txtMaPhuong.getText());
                pstmt.setString(2, txtTenPhuong.getText());
                String tenquan = cmbQuan.getSelectedItem().toString();
                String maquan = new QuanController().LayMaquan_TheoTenQuan(tenquan);
                pstmt.setString(3, maquan);
                pstmt.executeUpdate();
                new PhuongController.loaddataPhuong(jTablePhuong);
                JOptionPane.showMessageDialog(this, "Thêm mới thành công!");
                pstmt.close();
                conn.close();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_btnAddPhuongActionPerformed

    @SuppressWarnings({"UseSpecificCatch", "static-access", "ConvertToTryWithResources"})
    private void btnAddDoiNguActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddDoiNguActionPerformed
        try {
            conn = new ConnectionModel().getConnection();
            String sql = "insert into DoiNguYT(madoingu,tendoingu) values(?,?)";
            // Gọi hàm validation để kiểm tra nhập liệu
            String madoingu = String.valueOf(txtMaDoiNgu.getText());
            boolean validate = new Validation().Validate_MaDoiNgu(madoingu);
            if (validate) {
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, txtMaDoiNgu.getText());
                pstmt.setString(2, txtTenDoiNgu.getText());
                pstmt.executeUpdate();
                new DoiNguYTController().loaddataDoiNguYT(jTableDoiNgu);
                JOptionPane.showMessageDialog(this, "Thêm mới thành công!");
                pstmt.close();
                conn.close();
            }
            txtMaDoiNgu.setText("");
            txtTenDoiNgu.setText("");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_btnAddDoiNguActionPerformed
  
    @SuppressWarnings({"UseSpecificCatch", "static-access", "ConvertToTryWithResources"})
    private void btnAddDanhSachTiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddDanhSachTiemActionPerformed
        try {
            conn = new ConnectionModel().getConnection();
            String sql = "insert into DanhSachTiem(masods,tendanhsach) values(?,?)";
            String masods = String.valueOf(txtMaDanhSachTiem.getText());
            boolean validate = new Validation().Validate_Masods(masods);
            if (validate) {
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, txtMaDanhSachTiem.getText());
                pstmt.setString(2, txtTenDanhSachTiem.getText());
                pstmt.executeUpdate();
                new DanhSachTiemController().loaddataDanhSachTiem(jTableDanhSachTiem);
                JOptionPane.showMessageDialog(this, "Thêm mới thành công!");
                pstmt.close();
                conn.close();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_btnAddDanhSachTiemActionPerformed

    @SuppressWarnings({"UseSpecificCatch", "static-access", "ConvertToTryWithResources"})
    private void btnAddLoVacXinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddLoVacXinActionPerformed
        try {
            conn = new ConnectionModel().getConnection();
            String sql = "insert into LoVacXin(masolo,soluong,maloai,ngaysanxuat,ngayhethan,trangthai,dotuoi) values(?,?,?,?,?,?,?)";
            String masolo = String.valueOf(txtMaSoLoVacXin.getText());
            boolean validate = new Validation().Validate_MaDoiNgu(masolo);
            if (validate) 
            {
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, txtMaSoLoVacXin.getText());
                pstmt.setString(2, txtSoLuongLoVacXin.getText());
                String maloai = cmbMaLoaiVacXin.getSelectedItem().toString();
                pstmt.setString(3, maloai);
                pstmt.setString(4, txtNSXLoVacXin.getText());
                pstmt.setString(5, txtHSDLoVacXin.getText());
                @SuppressWarnings("LocalVariableHidesMemberVariable")
                boolean TrangThaiLo = false;
                if (rdbtruelo.isSelected()) {
                    TrangThaiLo = true;
                } else if (rdbfalselo.isSelected()) {
                    TrangThaiLo = false;
                }
                pstmt.setBoolean(6, TrangThaiLo);

                String dotuoi = cmbDoTuoiLoVacXin.getSelectedItem().toString();
                pstmt.setString(7, dotuoi);
                pstmt.executeUpdate();
                new LoVacXinController().loaddataLoVacXin(jTableLoVacXin);
                JOptionPane.showMessageDialog(this, "Thêm mới thành công!");
                pstmt.close();
                conn.close();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_btnAddLoVacXinActionPerformed

    @SuppressWarnings({"UseSpecificCatch", "static-access", "ConvertToTryWithResources"})
    private void btnAddLoaiVacXinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddLoaiVacXinActionPerformed
        try {
            conn = new ConnectionModel().getConnection();
            String sql = "insert into LoaiVacXin(maloai,tenloai,somuitiem,xuatxu,mota,trangthai,lieutrinh) values(?,?,?,?,?,?,?)";
            // Gọi hàm validation để kiểm tra nhập liệu
            String maloai = String.valueOf(txtMaLoaiVacXin.getText());
            boolean validate = new Validation().Validate_MaLoai(maloai);
            if (validate) {
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, txtMaLoaiVacXin.getText());
                pstmt.setString(2, txtTenLoaiVacXin.getText());
                pstmt.setString(3, txtSoMuiTiem.getText());
                pstmt.setString(4, txtXuatXuLoaiVacXin.getText());
                pstmt.setString(5, txtArea_MoTaLoaiVacXin.getText());
                @SuppressWarnings("LocalVariableHidesMemberVariable")
                boolean TrangThai = false;
                if (rdbtrueloaivacxin.isSelected()) {
                    TrangThai = true;
                } else if (rdbfalseloaivacxin.isSelected()) {
                    TrangThai = false;
                }
                pstmt.setBoolean(6, TrangThai);
                pstmt.setString(7, txtLieuTrinhLoaiVacXin.getText());
                pstmt.executeUpdate();
                new LoaiVacXinController().loaddataLoaiVacXin(jTableLoaiVacXin);
                JOptionPane.showMessageDialog(this, "Thêm mới thành công!");
                pstmt.close();
                conn.close();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_btnAddLoaiVacXinActionPerformed

    private void jTablenvytMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablenvytMouseClicked
        int row = jTablenvyt.getSelectedRow();
        String manv = jTablenvyt.getValueAt(row, 1).toString();
        String tennv = jTablenvyt.getValueAt(row, 2).toString();
        String sdt = jTablenvyt.getValueAt(row, 3).toString();
        String madoingu = jTablenvyt.getValueAt(row, 4).toString();
        String coquan = jTablenvyt.getValueAt(row, 5).toString();
        String email = jTablenvyt.getValueAt(row, 6).toString();
        txtMaNVYT.setText(manv);
        txtHoTenNVYT.setText(tennv);
        txtSdtNVYT.setText(sdt);
        cmbmadnnvyt.setSelectedItem(madoingu);
        txtCoQuan.setText(coquan);
        txtEmail.setText(email);
    }//GEN-LAST:event_jTablenvytMouseClicked

    private void jTableDoiNguMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableDoiNguMouseClicked
        int row = jTableDoiNgu.getSelectedRow();
        txtMaDoiNgu.setText(jTableDoiNgu.getValueAt(row, 1).toString());
        txtTenDoiNgu.setText(jTableDoiNgu.getValueAt(row, 2).toString());
    }//GEN-LAST:event_jTableDoiNguMouseClicked

    private void jTableDanhSachTiemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableDanhSachTiemMouseClicked
        int row = jTableDanhSachTiem.getSelectedRow();
        txtMaDanhSachTiem.setText(jTableDanhSachTiem.getValueAt(row, 1).toString());
        txtTenDanhSachTiem.setText(jTableDanhSachTiem.getValueAt(row, 2).toString());
    }//GEN-LAST:event_jTableDanhSachTiemMouseClicked

    private void jTableQuanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableQuanMouseClicked
        int row = jTableQuan.getSelectedRow();
        txtMaQuan.setText(jTableQuan.getValueAt(row, 1).toString());
        txtTenQuan.setText(jTableQuan.getValueAt(row, 2).toString());
    }//GEN-LAST:event_jTableQuanMouseClicked

       @SuppressWarnings({"UseSpecificCatch", "static-access", "ConvertToTryWithResources"})
    private void btnDeleteDanhSachTiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteDanhSachTiemActionPerformed
        if (JOptionPane.showConfirmDialog(this, "Bạn có chắn chắn xóa?") == JOptionPane.NO_OPTION) {
            return;
        }
        try {
            conn = new ConnectionModel().getConnection();
            String sql = "delete from DanhSachTiem where masods =?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, txtMaDanhSachTiem.getText());
            pstmt.executeUpdate();
            new DanhSachTiemController().loaddataDanhSachTiem(jTableDanhSachTiem);
            JOptionPane.showMessageDialog(this, "Đã xóa thành công! Dữ liệu đã được cập nhật!");
            pstmt.close();
            conn.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_btnDeleteDanhSachTiemActionPerformed

    private void btnExitDanhSachTiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitDanhSachTiemActionPerformed
        dispose();
    }//GEN-LAST:event_btnExitDanhSachTiemActionPerformed

    @SuppressWarnings({"UseSpecificCatch", "static-access", "ConvertToTryWithResources"})
    private void btnEditDanhSachTiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditDanhSachTiemActionPerformed
        if (JOptionPane.showConfirmDialog(this, "Bạn có chắn chắn sửa?") == JOptionPane.NO_OPTION) {
            return;
        }
        try {
            conn = new ConnectionModel().getConnection();
            String sql = "update DanhSachTiem set tendanhsach =? where masods=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, txtTenDanhSachTiem.getText());
            pstmt.setString(2, txtMaDanhSachTiem.getText());
            pstmt.executeUpdate();
            new DanhSachTiemController().loaddataDanhSachTiem(jTableDanhSachTiem);
            JOptionPane.showMessageDialog(this, "Dữ liệu đã được cập nhật!");
            pstmt.close();
            conn.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_btnEditDanhSachTiemActionPerformed

     @SuppressWarnings({"UseSpecificCatch", "static-access", "ConvertToTryWithResources"})
    private void btnEditDoiNguActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditDoiNguActionPerformed
        if (JOptionPane.showConfirmDialog(this, "Bạn có chắn chắn sửa?") == JOptionPane.NO_OPTION) {
            return;
        }
        try {
            conn = new ConnectionModel().getConnection();
            String sql = "update DoiNguYT set tendoingu =? where madoingu=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, txtTenDoiNgu.getText());
            pstmt.setString(2, txtMaDoiNgu.getText());
            pstmt.executeUpdate();
            new DoiNguYTController().loaddataDoiNguYT(jTableDoiNgu);
            JOptionPane.showMessageDialog(this, "Dữ liệu đã được cập nhật!");
            pstmt.close();
            conn.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_btnEditDoiNguActionPerformed

    @SuppressWarnings({"UseSpecificCatch", "static-access", "ConvertToTryWithResources"})
    private void btnDeleteDoiNguActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteDoiNguActionPerformed
        if (JOptionPane.showConfirmDialog(this, "Bạn có chắn chắn xóa?") == JOptionPane.NO_OPTION) {
            return;
        }
        try {
            conn = new ConnectionModel().getConnection();
            String sql = "delete from DoiNguYT where madoingu =?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, txtMaDoiNgu.getText());
            pstmt.executeUpdate();
            new DoiNguYTController().loaddataDoiNguYT(jTableDoiNgu);
            JOptionPane.showMessageDialog(this, "Đã xóa thành công! Dữ liệu đã được cập nhật!");
            pstmt.close();
            conn.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_btnDeleteDoiNguActionPerformed

    private void btnExitDoiNguActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitDoiNguActionPerformed
        dispose();
    }//GEN-LAST:event_btnExitDoiNguActionPerformed

        @SuppressWarnings({"UseSpecificCatch", "static-access", "ConvertToTryWithResources"})
    private void btnEditQuanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditQuanActionPerformed
        if (JOptionPane.showConfirmDialog(this, "Bạn có chắn chắn sửa?") == JOptionPane.NO_OPTION) {
            return;
        }
        try {
            conn = new ConnectionModel().getConnection();
            String sql = "update Quan set tenquan =? where maquan=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, txtTenQuan.getText());
            pstmt.setString(2, txtMaQuan.getText());
            pstmt.executeUpdate();
            new QuanController().loaddataQuan(jTableQuan);
            JOptionPane.showMessageDialog(this, "Dữ liệu đã được cập nhật!");
            pstmt.close();
            conn.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_btnEditQuanActionPerformed

    private void btnExitQuanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitQuanActionPerformed
        dispose();
    }//GEN-LAST:event_btnExitQuanActionPerformed

    
    private void btnDeleteQuanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteQuanActionPerformed
        String sql = "delete from Quan where maquan = '"+txtMaQuan.getText()+"'";
        int rs = ConnectionModel.UpdateSQl(sql);
        new QuanController().loaddataQuan(jTableQuan);
        JOptionPane.showMessageDialog(this, "Đã xóa thành công! Dữ liệu đã được cập nhật!");
        if(rs==0)
            JOptionPane.showMessageDialog(this, "Xóa không thành công! Dữ liệu đã được cập nhật!");
    }//GEN-LAST:event_btnDeleteQuanActionPerformed

    private void btnExitLoaiVacXinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitLoaiVacXinActionPerformed
        dispose();
    }//GEN-LAST:event_btnExitLoaiVacXinActionPerformed

    private void btnExitPhuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitPhuongActionPerformed
        dispose();
    }//GEN-LAST:event_btnExitPhuongActionPerformed

    private void btnExitNVYTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitNVYTActionPerformed
        dispose();
    }//GEN-LAST:event_btnExitNVYTActionPerformed

    private void btnExitDotTiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitDotTiemActionPerformed
        dispose();
    }//GEN-LAST:event_btnExitDotTiemActionPerformed

    private void btnExitLoVacXinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitLoVacXinActionPerformed
        dispose();
    }//GEN-LAST:event_btnExitLoVacXinActionPerformed


    private void cmbQuanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbQuanActionPerformed

    }//GEN-LAST:event_cmbQuanActionPerformed

    private void jTablePhuongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablePhuongMouseClicked
        int row = jTablePhuong.getSelectedRow();
        String maphuong = jTablePhuong.getValueAt(row, 1).toString();
        String tenphuong = jTablePhuong.getValueAt(row, 2).toString();
        String maquanp = jTablePhuong.getValueAt(row, 3).toString();
        txtMaPhuong.setText(maphuong);
        txtTenPhuong.setText(tenphuong);
        cmbQuan.setSelectedItem(maquanp);
    }//GEN-LAST:event_jTablePhuongMouseClicked

    private void jTableDotTiemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableDotTiemMouseClicked
        int row = jTableDotTiem.getSelectedRow();
        String madottiem = jTableDotTiem.getValueAt(row, 1).toString();
        String ngaytiem = jTableDotTiem.getValueAt(row, 2).toString();
        String quan = jTableDotTiem.getValueAt(row, 3).toString();
        String phuong = jTableDotTiem.getValueAt(row, 4).toString();
        String lovacxin = jTableDotTiem.getValueAt(row, 5).toString();
        String masodsa = jTableDotTiem.getValueAt(row, 6).toString();
        String madoingu = jTableDotTiem.getValueAt(row, 7).toString();
        txtMaDotTiem.setText(madottiem);
        txtNgayTiem.setText(ngaytiem);
        cmbQuanDotTiem.setSelectedItem(quan);
        cmbQuanDotTiem.setSelectedItem(phuong);
        cmbMaSoLoDotTiem.setSelectedItem(lovacxin);
        cmbMaSoDSDotTiem.setSelectedItem(masodsa);
        cmbmadoinguDotTiem.setSelectedItem(madoingu);
    }//GEN-LAST:event_jTableDotTiemMouseClicked

    private void jTableLoVacXinMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableLoVacXinMouseClicked
        int row = jTableLoVacXin.getSelectedRow();
        TableModel model = jTableLoVacXin.getModel();
        String masolo = jTableLoVacXin.getValueAt(row, 1).toString();
        String soluong = jTableLoVacXin.getValueAt(row, 2).toString();
        String maloai = jTableLoVacXin.getValueAt(row, 3).toString();
        String ngaysanxuat = jTableLoVacXin.getValueAt(row, 4).toString();
        String ngayhethan = jTableLoVacXin.getValueAt(row, 5).toString();
        @SuppressWarnings("LocalVariableHidesMemberVariable")
        String TrangThaiLo = model.getValueAt(row, 6).toString();
         String dotuoi = jTableLoVacXin.getValueAt(row, 7).toString();
        txtMaSoLoVacXin.setText(masolo);
        txtSoLuongLoVacXin.setText(soluong);
        cmbMaLoaiVacXin.setSelectedItem(maloai);
        txtNSXLoVacXin.setText(ngaysanxuat);
        txtHSDLoVacXin.setText(ngayhethan);
        
        if (TrangThaiLo.equals("true")) {
            rdbtruelo.setSelected(true);
            rdbfalselo.setSelected(false);
        } else {
            rdbfalselo.setSelected(true);
            rdbtruelo.setSelected(false);
        }
        cmbDoTuoiLoVacXin.setSelectedItem(dotuoi);

    }//GEN-LAST:event_jTableLoVacXinMouseClicked

    private void jTableLoaiVacXinMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableLoaiVacXinMouseClicked
        int row = jTableLoaiVacXin.getSelectedRow();
        TableModel model = jTableLoaiVacXin.getModel();
        txtMaLoaiVacXin.setText(jTableLoaiVacXin.getValueAt(row, 1).toString());
        txtTenLoaiVacXin.setText(jTableLoaiVacXin.getValueAt(row, 2).toString());
        txtSoMuiTiem.setText(jTableLoaiVacXin.getValueAt(row, 3).toString());
        txtXuatXuLoaiVacXin.setText(jTableLoaiVacXin.getValueAt(row, 4).toString());
        String mota = jTableLoaiVacXin.getValueAt(row, 5).toString();
        char kytu;
        String chuoimota  = "";
        int sttkytu = 0;
        for (int i = 0; i < mota.length(); i++) {
            kytu = mota.charAt(i);
            chuoimota = chuoimota.concat(String.valueOf(kytu));
            if (Character.isSpace(kytu)) {
                sttkytu++;
                if (sttkytu % 6  == 0 ) {
                    chuoimota = chuoimota.concat("\n");
                }
            }
        }
        txtArea_MoTaLoaiVacXin.setText(chuoimota);
        @SuppressWarnings("LocalVariableHidesMemberVariable")
        String TrangThai = model.getValueAt(row, 6).toString();
        if (TrangThai.equals("true")) {
            rdbtrueloaivacxin.setSelected(true);
            rdbfalseloaivacxin.setSelected(false);
        } else {
            rdbfalseloaivacxin.setSelected(true);
            rdbtrueloaivacxin.setSelected(false);
        }
        txtLieuTrinhLoaiVacXin.setText(jTableLoaiVacXin.getValueAt(row, 7).toString());
    }//GEN-LAST:event_jTableLoaiVacXinMouseClicked

    @SuppressWarnings({"UseSpecificCatch", "static-access", "ConvertToTryWithResources"})
    private void btnEditLoaiVacXinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditLoaiVacXinActionPerformed
        if (JOptionPane.showConfirmDialog(this, "Bạn có chắn chắn sửa?") == JOptionPane.NO_OPTION) {
            return;
        }
        try {
            conn = new ConnectionModel().getConnection();
            String sql = "update LoaiVacXin set tenloai =?, somuitiem=?,  xuatxu=?,  mota=?, trangthai=?, lieutrinh=? where maloai=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, txtTenLoaiVacXin.getText());
            pstmt.setString(2, txtSoMuiTiem.getText());
            pstmt.setString(3, txtXuatXuLoaiVacXin.getText());
            pstmt.setString(4, txtArea_MoTaLoaiVacXin.getText());
            @SuppressWarnings("LocalVariableHidesMemberVariable")
            boolean TrangThai = false;
            if (rdbtrueloaivacxin.isSelected()) {
                TrangThai = true;
            } else if (rdbfalseloaivacxin.isSelected()) {
                TrangThai = false;
            }
            pstmt.setBoolean(5, TrangThai);
            pstmt.setString(6, txtLieuTrinhLoaiVacXin.getText());
            pstmt.setString(7, txtMaLoaiVacXin.getText());
            pstmt.executeUpdate();
            new LoaiVacXinController().loaddataLoaiVacXin(jTableLoaiVacXin);
            JOptionPane.showMessageDialog(this, "Dữ liệu đã được cập nhật!");
            pstmt.close();
            conn.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_btnEditLoaiVacXinActionPerformed

        @SuppressWarnings({"UseSpecificCatch", "static-access", "ConvertToTryWithResources"})
    private void btnDeleteLoaiVacXinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteLoaiVacXinActionPerformed
        if (JOptionPane.showConfirmDialog(this, "Bạn có chắn chắn xóa?") == JOptionPane.NO_OPTION) {
            return;
        }
        try {
            conn = new ConnectionModel().getConnection();
            String sql = "delete from LoaiVacXin where maloai =?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, txtMaLoaiVacXin.getText());
            pstmt.executeUpdate();
            new LoaiVacXinController().loaddataLoaiVacXin(jTableLoaiVacXin);
            JOptionPane.showMessageDialog(this, "Đã xóa thành công! Dữ liệu đã được cập nhật!");
            pstmt.close();
            conn.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }

    }//GEN-LAST:event_btnDeleteLoaiVacXinActionPerformed

    private void cmbMaSoDSDotTiemAncestorRemoved(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_cmbMaSoDSDotTiemAncestorRemoved
    }//GEN-LAST:event_cmbMaSoDSDotTiemAncestorRemoved

    @SuppressWarnings({"UseSpecificCatch", "static-access", "ConvertToTryWithResources", "ResultOfObjectAllocationIgnored"})
    private void btnDeletePhuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletePhuongActionPerformed
        if (JOptionPane.showConfirmDialog(this, "Bạn có chắn chắn xóa?") == JOptionPane.NO_OPTION) {
            return;
        }
        try {
            conn = new ConnectionModel().getConnection();
            String sql = "delete from Phuong where maphuong =?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, txtMaPhuong.getText());
            pstmt.executeUpdate();
            new PhuongController.loaddataPhuong(jTablePhuong);
            JOptionPane.showMessageDialog(this, "Đã xóa thành công! Dữ liệu đã được cập nhật!");
            pstmt.close();
            conn.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_btnDeletePhuongActionPerformed

    @SuppressWarnings({"UseSpecificCatch", "static-access", "ConvertToTryWithResources", "ResultOfObjectAllocationIgnored"})
    private void btnEditPhuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditPhuongActionPerformed
        if (JOptionPane.showConfirmDialog(this, "Bạn có chắn chắn sửa?") == JOptionPane.NO_OPTION) {
            return;
        }
        try {
            conn = new ConnectionModel().getConnection();
            String sql = "update Phuong set tenphuong =?,maquan=? where maphuong=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, txtTenPhuong.getText());
            String tenquan = cmbQuan.getSelectedItem().toString();
            String maquan = new QuanController().LayMaquan_TheoTenQuan(tenquan);
            pstmt.setString(3, maquan);
            pstmt.setString(2, maquan);
            pstmt.setString(3, txtMaPhuong.getText());
            pstmt.executeUpdate();
            new PhuongController.loaddataPhuong(jTablePhuong);
            JOptionPane.showMessageDialog(this, "Dữ liệu đã được cập nhật!");
            pstmt.close();
            conn.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_btnEditPhuongActionPerformed

    @SuppressWarnings({"UseSpecificCatch", "static-access", "ConvertToTryWithResources"})
    private void btnDeleteNVYTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteNVYTActionPerformed
        if (JOptionPane.showConfirmDialog(this, "Bạn có chắn chắn xóa?") == JOptionPane.NO_OPTION) {
            return;
        }
        try {
            conn = new ConnectionModel().getConnection();
            String sql = "delete from NhanVienYT where manhanvienyt =?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, txtMaNVYT.getText());
            pstmt.executeUpdate();
            new NhanVienYTController().loaddataNhanVienYT(jTablenvyt);
            JOptionPane.showMessageDialog(this, "Đã xóa thành công! Dữ liệu đã được cập nhật!");
            pstmt.close();
            conn.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_btnDeleteNVYTActionPerformed

    @SuppressWarnings({"UseSpecificCatch", "static-access", "ConvertToTryWithResources"})
    private void btnEditNVYTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditNVYTActionPerformed
        if (JOptionPane.showConfirmDialog(this, "Bạn có chắn chắn sửa?") == JOptionPane.NO_OPTION) {
            return;
        }
        try {
            conn = new ConnectionModel().getConnection();
            String sql = "update NhanVienYT set tennhanvienyt =?,madoingu=?,sdt=?,coquan=?,email=? where manhanvienyt=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, txtHoTenNVYT.getText());
            String madoingu = cmbmadnnvyt.getSelectedItem().toString();
            pstmt.setString(2, madoingu);
            pstmt.setString(3, txtSdtNVYT.getText());
            pstmt.setString(4, txtCoQuan.getText());
            pstmt.setString(5, txtEmail.getText());
            pstmt.setString(6, txtMaNVYT.getText());
            pstmt.executeUpdate();
            new NhanVienYTController().loaddataNhanVienYT(jTablenvyt);
            JOptionPane.showMessageDialog(this, "Dữ liệu đã được cập nhật!");
            pstmt.close();
            conn.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_btnEditNVYTActionPerformed

    @SuppressWarnings({"UseSpecificCatch", "static-access", "ConvertToTryWithResources"})
    private void btnDeleteLoVacXinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteLoVacXinActionPerformed
        if (JOptionPane.showConfirmDialog(this, "Bạn có chắn chắn xóa?") == JOptionPane.NO_OPTION) {
            return;
        }
        try {
            conn = new ConnectionModel().getConnection();
            String sql = "delete from LoVacXin where masolo =?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, txtMaSoLoVacXin.getText());
            pstmt.executeUpdate();
            new LoVacXinController().loaddataLoVacXin(jTableLoVacXin);
            JOptionPane.showMessageDialog(this, "Đã xóa thành công! Dữ liệu đã được cập nhật!");
            pstmt.close();
            conn.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_btnDeleteLoVacXinActionPerformed

    @SuppressWarnings({"UseSpecificCatch", "static-access", "ConvertToTryWithResources"})
    private void btnEditLoVacXinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditLoVacXinActionPerformed
        if (JOptionPane.showConfirmDialog(this, "Bạn có chắn chắn sửa?") == JOptionPane.NO_OPTION) {
            return;
        }
        try {
            conn = new ConnectionModel().getConnection();
            String sql = "update LoVacXin set soluong =?, maloai=?,  ngaysanxuat=?,  ngayhethan=?, trangthai=?, dotuoi=? where masolo=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, txtSoLuongLoVacXin.getText());
            String maloailo = cmbMaLoaiVacXin.getSelectedItem().toString();
            pstmt.setString(2, maloailo);
            pstmt.setString(3, txtNSXLoVacXin.getText());
            pstmt.setString(4, txtHSDLoVacXin.getText());
            @SuppressWarnings("LocalVariableHidesMemberVariable")
            boolean TrangThaiLo = false;
            if (rdbtruelo.isSelected()) {
                TrangThaiLo = true;
            } else if (rdbfalselo.isSelected()) {
                TrangThaiLo = false;
            }
            pstmt.setBoolean(5, TrangThaiLo);
            String dotuoilo = cmbDoTuoiLoVacXin.getSelectedItem().toString();
            pstmt.setString(6, dotuoilo);
            pstmt.setString(7, txtMaSoLoVacXin.getText());
            pstmt.executeUpdate();
            new LoVacXinController().loaddataLoVacXin(jTableLoVacXin);
            JOptionPane.showMessageDialog(this, "Dữ liệu đã được cập nhật!");
            pstmt.close();
            conn.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_btnEditLoVacXinActionPerformed

    @SuppressWarnings({"UseSpecificCatch", "static-access", "ConvertToTryWithResources"})
    private void btnDeleteDotTiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteDotTiemActionPerformed
        if (JOptionPane.showConfirmDialog(this, "Bạn có chắn chắn xóa?") == JOptionPane.NO_OPTION) {
            return;
        }
        try {
            conn = new ConnectionModel().getConnection();
            String sql = "delete from DotTiem where madottiem =?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, txtMaDotTiem.getText());
            pstmt.executeUpdate();
            new DotTiemController().loaddataDotTiem(jTableDotTiem);
            JOptionPane.showMessageDialog(this, "Đã xóa thành công! Dữ liệu đã được cập nhật!");
            pstmt.close();
            conn.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_btnDeleteDotTiemActionPerformed

    @SuppressWarnings({"UseSpecificCatch", "static-access", "ConvertToTryWithResources"})
    private void btnEditDotTiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditDotTiemActionPerformed
        try {
            conn = new ConnectionModel().getConnection();
            String sql = "update DotTiem set ngaytiem =?, maquan=?,  maphuong=?,  masolo=?, masods=?, madoingu=? where madottiem=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, txtNgayTiem.getText());
            String tenquan = cmbQuanDotTiem.getSelectedItem().toString();
            String maquan = new QuanController().LayMaquan_TheoTenQuan(tenquan);
            String tenphuong = cmbPhuongDotTiem.getSelectedItem().toString();
            String maphuong = new PhuongController().LayMapuong_TheoTenphuong(tenphuong);
            pstmt.setString(2, maquan);
            pstmt.setString(3, maphuong);
            String lovacxin = cmbMaSoLoDotTiem.getSelectedItem().toString();
            pstmt.setString(4, lovacxin);
            String danhsachtiem = cmbMaSoDSDotTiem.getSelectedItem().toString();
            pstmt.setString(5, danhsachtiem);
            String doingu = cmbmadoinguDotTiem.getSelectedItem().toString();
            pstmt.setString(6, doingu);
            pstmt.setString(7, txtMaDotTiem.getText());
            pstmt.executeUpdate();
            new DotTiemController().loaddataDotTiem(jTableDotTiem);
            JOptionPane.showMessageDialog(this, "Cập nhật thành công!");
            pstmt.close();
            conn.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_btnEditDotTiemActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        formmain.ShowFormMain();
    }//GEN-LAST:event_formWindowClosed

    private void cmbQuanDotTiemItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbQuanDotTiemItemStateChanged
        new PhuongController().Load_CMB_Phuong(cmbPhuongDotTiem, cmbQuanDotTiem);
    }//GEN-LAST:event_cmbQuanDotTiemItemStateChanged

    @SuppressWarnings("Convert2Lambda")
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @SuppressWarnings("override")
            public void run() {
                new FormNhapLieu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel TrangThai;
    private javax.swing.JLabel TrangThaiLo;
    private javax.swing.JButton btnAddDanhSachTiem;
    private javax.swing.JButton btnAddDoiNgu;
    private javax.swing.JButton btnAddDotTiem;
    private javax.swing.JButton btnAddLoVacXin;
    private javax.swing.JButton btnAddLoaiVacXin;
    private javax.swing.JButton btnAddNVYT;
    private javax.swing.JButton btnAddPhuong;
    private javax.swing.JButton btnAddQuan;
    private javax.swing.JButton btnDeleteDanhSachTiem;
    private javax.swing.JButton btnDeleteDoiNgu;
    private javax.swing.JButton btnDeleteDotTiem;
    private javax.swing.JButton btnDeleteLoVacXin;
    private javax.swing.JButton btnDeleteLoaiVacXin;
    private javax.swing.JButton btnDeleteNVYT;
    private javax.swing.JButton btnDeletePhuong;
    private javax.swing.JButton btnDeleteQuan;
    private javax.swing.JButton btnEditDanhSachTiem;
    private javax.swing.JButton btnEditDoiNgu;
    private javax.swing.JButton btnEditDotTiem;
    private javax.swing.JButton btnEditLoVacXin;
    private javax.swing.JButton btnEditLoaiVacXin;
    private javax.swing.JButton btnEditNVYT;
    private javax.swing.JButton btnEditPhuong;
    private javax.swing.JButton btnEditQuan;
    private javax.swing.JButton btnExitDanhSachTiem;
    private javax.swing.JButton btnExitDoiNgu;
    private javax.swing.JButton btnExitDotTiem;
    private javax.swing.JButton btnExitLoVacXin;
    private javax.swing.JButton btnExitLoaiVacXin;
    private javax.swing.JButton btnExitNVYT;
    private javax.swing.JButton btnExitPhuong;
    private javax.swing.JButton btnExitQuan;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cmbDoTuoiLoVacXin;
    private javax.swing.JComboBox<String> cmbMaLoaiVacXin;
    private javax.swing.JComboBox<String> cmbMaSoDSDotTiem;
    private javax.swing.JComboBox<String> cmbMaSoLoDotTiem;
    private javax.swing.JComboBox<String> cmbPhuongDotTiem;
    private javax.swing.JComboBox<String> cmbQuan;
    private javax.swing.JComboBox<String> cmbQuanDotTiem;
    private javax.swing.JComboBox<String> cmbmadnnvyt;
    private javax.swing.JComboBox<String> cmbmadoinguDotTiem;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JLayeredPane jLayeredPane3;
    private javax.swing.JLayeredPane jLayeredPane4;
    private javax.swing.JLayeredPane jLayeredPane5;
    private javax.swing.JLayeredPane jLayeredPane6;
    private javax.swing.JLayeredPane jLayeredPane7;
    private javax.swing.JLayeredPane jLayeredPane8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPaneDoiNgu;
    private javax.swing.JTable jTableDanhSachTiem;
    private javax.swing.JTable jTableDoiNgu;
    private javax.swing.JTable jTableDotTiem;
    private javax.swing.JTable jTableLoVacXin;
    private javax.swing.JTable jTableLoaiVacXin;
    private javax.swing.JTable jTablePhuong;
    private javax.swing.JTable jTableQuan;
    private javax.swing.JTable jTablenvyt;
    private javax.swing.JRadioButton rdbfalselo;
    private javax.swing.JRadioButton rdbfalseloaivacxin;
    private javax.swing.JRadioButton rdbtruelo;
    private javax.swing.JRadioButton rdbtrueloaivacxin;
    private javax.swing.JTextArea txtArea_MoTaLoaiVacXin;
    private javax.swing.JTextField txtCoQuan;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtHSDLoVacXin;
    private javax.swing.JTextField txtHoTenNVYT;
    private javax.swing.JTextField txtLieuTrinhLoaiVacXin;
    private javax.swing.JTextField txtMaDanhSachTiem;
    private javax.swing.JTextField txtMaDoiNgu;
    private javax.swing.JTextField txtMaDotTiem;
    private javax.swing.JTextField txtMaLoaiVacXin;
    private javax.swing.JTextField txtMaNVYT;
    private javax.swing.JTextField txtMaPhuong;
    private javax.swing.JTextField txtMaQuan;
    private javax.swing.JTextField txtMaSoLoVacXin;
    private javax.swing.JTextField txtNSXLoVacXin;
    private javax.swing.JTextField txtNgayTiem;
    private javax.swing.JTextField txtSdtNVYT;
    private javax.swing.JTextField txtSoLuongLoVacXin;
    private javax.swing.JTextField txtSoMuiTiem;
    private javax.swing.JTextField txtTenDanhSachTiem;
    private javax.swing.JTextField txtTenDoiNgu;
    private javax.swing.JTextField txtTenLoaiVacXin;
    private javax.swing.JTextField txtTenPhuong;
    private javax.swing.JTextField txtTenQuan;
    private javax.swing.JTextField txtXuatXuLoaiVacXin;
    // End of variables declaration//GEN-END:variables

}
