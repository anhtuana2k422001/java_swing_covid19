package View;
import Check_Validator.Validation;
import Controller.ChartController;
import Controller.DotTiemController;
import Controller.LoaiVacXinController;
import Controller.NguoiDanController;
import Controller.NhanVienYTController;
import Controller.PhieuChungNhanController;
import Controller.PhuongController;
import Controller.QuanController;
import Controller.SoLieuVXTheoQuanController;
import Controller.TaiKhoanController;
import static Model.ConnectionModel.getConnection;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import org.jfree.chart.ChartPanel;

public class Main extends javax.swing.JFrame {
    /* lấy thời gian hệ thống */
    Date date = new Date(); 
    
    /*Thông tin đăng nhập*/
    public String taikhoandangnhap = "";
    public String matkhaudangnhap = "";
    
    /*Kiểm tra phân quyền */
    public boolean checkAdmin = false;
    
              
    public boolean TimKiemMuiTiem = false;  /* Kiểm tra xem đã tìm thấy mũi tiêm hay chưa */
    public boolean Chonmuitem = false ; /* Kiểm tra xem người nhập liệu đã chọn mũi tiêm nào hay chưa */
    
    
    /* Lấy tên vắc xin và lần tiêm của mũi tiêm để kiểm tra Validate, xóa, sủa */
    public String TenVacXin = ""; 
    public String LanTiem = ""; 
    
    public int ngaytiem = 7; /* Tạo để xem biểu đồ mũi tiêm - mặc định 7 ngày hiện tai*/
    public boolean checkTaoBieuDo = false; /*Kiểm tra xem biểu đồ đã tạo chưa, tạo rồi rồi thì k tạo nữa*/
    public ChartPanel chartPanelMacDinh; /*Khởi tạo panle ban đầu*/
    
    /* Kiểm tra xem form báo cáo đã mở hay chưa */
    public boolean checkformBaoCao = false;
    
    public String colorbtn = "#1F1E44";
    public String colorbtnActive = "#FF3399";
    
    @SuppressWarnings("OverridableMethodCallInConstructor")
    public Main() {
        initComponents();
        setLocationRelativeTo(null); /* Cho form vào giữa màn hình */
        CaiDatLoadForm();
     
    }

    /* Lấy thông tin tài khoản đăng nhập */
    public Main(String taikhoan, String matkhau) {
        this();
        txtTaiKhoanDangNhap.setText(taikhoan);
        taikhoandangnhap = taikhoan;
        matkhaudangnhap = matkhau;
        CaiDatPhanQuyen();
    }
    
    public void CaiDatLoadForm(){  
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            // tạo 1 đối tượng có định dạng thời gian yyyy-MM-dd HH:mm:ss
            String stringDate = dateFormat.format(date);//Định dạng thời gian theo trên
            txtTime.setText(stringDate);
             /* Active color btn trang chủ */
            btnTrangCHu.setBackground(Color.decode(colorbtnActive));
            
        /*===== Bắt đầu Khởi tạo cho Trang chủ =====*/
            int soluongmuitiem = new PhieuChungNhanController().SoLuongMuiTiem();
            txtTongMuiTiemHCM.setText(String.valueOf(soluongmuitiem));
            
            int sltiemhomqua = new PhieuChungNhanController().SoLuongHomQua();
            textSLTiemHomQua.setText(String.valueOf(sltiemhomqua));
            /*Số liệu vắc xin*/
            new SoLieuVXTheoQuanController().SoLieuVacXinTheoQuan(table_TiemChungHomNay);
        /*===== Kết thúc Khởi tạo cho Trang chủ =====*/
        
        /*===== Bắt đầu Khởi tạo cho Thống Kê =====*/
        /*===== Kết thúc Khởi tạo cho Thông Kê =====*/
        
        /*===== Bắt đầu Khởi tạo cho Người Dân =====*/
            radioNam_ND.setSelected(true);
            new QuanController().Load_CMB_Quan(cmbQuan_ND);
            new PhuongController().Load_CMB_Phuong(cmbPhuong_ND, cmbQuan_ND);
            DateChooser_ND.setDate(date);
            new NguoiDanController().LayTatCa_NguoiDan(tableNguoiDan_ND);
        /*===== Kết thúc Khởi tạo cho Người Dân =====*/
    
        /*===== Bắt đầu Khởi tạo cho Mũi Tiêm =====*/
            new DotTiemController().LaycmbDotTiem(cmbDotTiem_MT);
            new DotTiemController().ThongTinDotTiem(cmbDotTiem_MT, txtLoaiVacXin_MT, txtMaLo_MT, txtNgayTiem_MT, txtDanhSach_MT, txtDoiNgu_MT, txtDiaDiem_MT, txtTongCaTiem_MT);
            txtDoiNguTiem_MT.setText(txtDoiNgu_MT.getText()); /* Lấy đội ngũ tiêm */
            new NhanVienYTController().Lay_CMB_TenNhanVien(txtDoiNguTiem_MT, txtNhanVienYT_MT);
            new LoaiVacXinController().Load_MuiTiem_TheoVacXin(txtLoaiVacXin_MT, cmbLanTiem_MT);
            new PhieuChungNhanController().Lay_MuiTiem_TheoDotTiem(tableMuiTiem_MT, cmbDotTiem_MT);
         /*===== Kết thúc Khởi tạo cho Mũi Tiêm =====*/
     
        /*===== Bắt đầu Khởi tạo cho Chứng Nhận =====*/
            DateChooser_NgaySinh.setDate(date);
            BufferedImage img;
            try {
                img = ImageIO.read(new File("src/Image/QRCode_image.png"));
                JLabel pic = new JLabel(new ImageIcon(img));
                pic.setBounds(100, 100, 100, 100);
                pic.setLocation(65, 100);
                Panel_QR_PCN.add(pic);
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
            TraCuuMuiTiem();
        /*===== Kết thúc Khởi tạo cho Chứng Nhận =====*/
    }
    
    private void CaiDatPhanQuyen(){
        @SuppressWarnings("UnusedAssignment")
        boolean check = true;
        check = new TaiKhoanController().KiemTraQuyenAdmin(taikhoandangnhap);
        if(check){
            btnQLTaiKhoan.setVisible(true);            
            btnTaoTaiKhoan.setVisible(true);
            jLabel50.setVisible(true);
            jLabel49.setVisible(true);
        }else{
            btnQLTaiKhoan.setVisible(false);            
            btnTaoTaiKhoan.setVisible(false);
            jLabel50.setVisible(false);
            jLabel49.setVisible(false);
        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jTextField9 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollBar1 = new javax.swing.JScrollBar();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonNamNu_ND = new javax.swing.ButtonGroup();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        Layout = new javax.swing.JPanel();
        Layout_SideBar = new javax.swing.JPanel();
        pen_logo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtTime = new javax.swing.JLabel();
        btnTrangCHu = new javax.swing.JPanel();
        btnTrangChu = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnTiemMui1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnTiemMui2 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        btnThongKe = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        btnCaiDat = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jPanel24 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        btnChungNhan = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jPanel26 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        btnDangXuat = new javax.swing.JPanel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jPanel29 = new javax.swing.JPanel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        Layout_Header = new javax.swing.JPanel();
        btnQLTaiKhoan = new javax.swing.JLabel();
        btnTaoTaiKhoan = new javax.swing.JLabel();
        btn_image = new javax.swing.JLabel();
        txtTieuDe = new javax.swing.JLabel();
        txtTaiKhoanDangNhap = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        Layout_Footer = new javax.swing.JPanel();
        btnCapNhat = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jPanel25 = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        btnBaoCao = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jPanel27 = new javax.swing.JPanel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        btnCmbBaoCao = new javax.swing.JComboBox<>();
        btnTraCuu = new javax.swing.JPanel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jPanel28 = new javax.swing.JPanel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        Layout_Body = new javax.swing.JPanel();
        PanelTrangChu = new javax.swing.JPanel();
        PanelChungNhan1 = new javax.swing.JPanel();
        txtSoLuongTiemHomQua3 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        textSLTiemHomQua = new javax.swing.JLabel();
        txtSoLuongTiemHomQua4 = new javax.swing.JPanel();
        txtinfo1 = new javax.swing.JLabel();
        txtTongMuiTiemHCM = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_TiemChungHomNay = new javax.swing.JTable();
        PanelTiemMui2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        cmbDotTiem_MT = new javax.swing.JComboBox<>();
        jLabel72 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        txtLoaiVacXin_MT = new javax.swing.JLabel();
        txtDanhSach_MT = new javax.swing.JLabel();
        txtDiaDiem_MT = new javax.swing.JLabel();
        txtTongCaTiem_MT = new javax.swing.JLabel();
        txtDoiNgu_MT = new javax.swing.JLabel();
        txtMaLo_MT = new javax.swing.JLabel();
        txtNgayTiem_MT = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        jLabel89 = new javax.swing.JLabel();
        jLabel90 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        btnTimKiem_MT = new javax.swing.JButton();
        jLabel86 = new javax.swing.JLabel();
        txtCMND_MT = new javax.swing.JTextField();
        txtHoTen_MT = new javax.swing.JTextField();
        jLabel92 = new javax.swing.JLabel();
        btnSuaThongTin = new javax.swing.JButton();
        btnThem_MT = new javax.swing.JButton();
        btnSua_MT = new javax.swing.JButton();
        btnXoa_MT = new javax.swing.JButton();
        txtNhanVienYT_MT = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        cmbLanTiem_MT = new javax.swing.JComboBox<>();
        txtDoiNguTiem_MT = new javax.swing.JLabel();
        btnNhapLai_MT = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tableMuiTiem_MT = new javax.swing.JTable();
        PanelTiemMui1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel57 = new javax.swing.JLabel();
        txtCMND_ND = new javax.swing.JTextField();
        txtSDT_ND = new javax.swing.JTextField();
        txtHoTen_ND = new javax.swing.JTextField();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        radioNam_ND = new javax.swing.JRadioButton();
        radioNu_ND = new javax.swing.JRadioButton();
        jLabel67 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        cmbQuan_ND = new javax.swing.JComboBox<>();
        cmbPhuong_ND = new javax.swing.JComboBox<>();
        txtDiaChi_ND = new javax.swing.JTextField();
        btnXoa_ND = new javax.swing.JButton();
        btnSua_ND = new javax.swing.JButton();
        btnNhapLai_ND = new javax.swing.JButton();
        btnMoiNhat_ND = new javax.swing.JButton();
        btnTatCa_ND = new javax.swing.JButton();
        btnNhapMuiTiem_ND = new javax.swing.JButton();
        btnThem_ND = new javax.swing.JButton();
        DateChooser_ND = new com.toedter.calendar.JDateChooser();
        jLabel19 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tableNguoiDan_ND = new javax.swing.JTable();
        PanelThongKe = new javax.swing.JPanel();
        btn7NgaySau = new javax.swing.JButton();
        btn7NgayTruoc = new javax.swing.JButton();
        PanelCaiDat = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        btnDoiPass = new javax.swing.JButton();
        panlemau1 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        btnMacDinh_CD = new javax.swing.JButton();
        btnCam_CD = new javax.swing.JButton();
        btnXanh_CD = new javax.swing.JButton();
        panlemau2 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        btnXanhNhat_CD = new javax.swing.JButton();
        btnTrang_CD = new javax.swing.JButton();
        btnTim_CD = new javax.swing.JButton();
        PanelChungNhan = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txtCMND_CN = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtHoTen_CN = new javax.swing.JTextField();
        jLabel111 = new javax.swing.JLabel();
        txtSDT_CN = new javax.swing.JTextField();
        DateChooser_NgaySinh = new com.toedter.calendar.JDateChooser();
        jLabel21 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        btnTraCuuMuiTiem_CN = new javax.swing.JButton();
        btnNhapLai_CN = new javax.swing.JButton();
        PanelMuiTiem_CN = new javax.swing.JPanel();
        Panel_QR_PCN = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        txtHoTen_QRcode = new javax.swing.JLabel();
        txtCMND_QRcode = new javax.swing.JLabel();
        txtNgaySinh_QRcode = new javax.swing.JLabel();
        txTBSoMuiTiem = new javax.swing.JLabel();
        jLabel99 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel700 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        txtHoten_PCN = new javax.swing.JLabel();
        txtCMND_PCN = new javax.swing.JLabel();
        txtNgaySinh_PCN = new javax.swing.JLabel();
        txtSDT_PCN = new javax.swing.JLabel();
        jLabel94 = new javax.swing.JLabel();
        txtDiaChi_CN = new javax.swing.JLabel();
        jLabel96 = new javax.swing.JLabel();
        jLabel97 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tableTraCuu_CN = new javax.swing.JTable();
        btnInPhieu_CN = new javax.swing.JButton();

        jTextField9.setText("jTextField9");

        jButton3.setText("jButton3");

        jButton4.setText("jButton4");

        jLabel3.setText("jLabel3");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTable2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(31, 30, 68));

        Layout.setBackground(new java.awt.Color(31, 30, 68));

        Layout_SideBar.setBackground(new java.awt.Color(31, 30, 68));
        Layout_SideBar.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(204, 204, 255))); // NOI18N
        Layout_SideBar.setPreferredSize(new java.awt.Dimension(212, 520));

        pen_logo.setBackground(new java.awt.Color(31, 30, 68));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/image_covid1.png"))); // NOI18N

        txtTime.setBackground(new java.awt.Color(255, 255, 255));
        txtTime.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtTime.setForeground(new java.awt.Color(255, 255, 255));
        txtTime.setText("20:30:12 01/04/22021");

        javax.swing.GroupLayout pen_logoLayout = new javax.swing.GroupLayout(pen_logo);
        pen_logo.setLayout(pen_logoLayout);
        pen_logoLayout.setHorizontalGroup(
            pen_logoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pen_logoLayout.createSequentialGroup()
                .addGroup(pen_logoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pen_logoLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(txtTime))
                    .addGroup(pen_logoLayout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jLabel1)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        pen_logoLayout.setVerticalGroup(
            pen_logoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pen_logoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtTime)
                .addGap(18, 18, 18))
        );

        btnTrangCHu.setBackground(new java.awt.Color(31, 30, 68));
        btnTrangCHu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTrangCHuMouseClicked(evt);
            }
        });

        btnTrangChu.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnTrangChu.setForeground(new java.awt.Color(255, 255, 255));
        btnTrangChu.setText("Trang Chủ");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icon_home_green.png"))); // NOI18N

        javax.swing.GroupLayout btnTrangCHuLayout = new javax.swing.GroupLayout(btnTrangCHu);
        btnTrangCHu.setLayout(btnTrangCHuLayout);
        btnTrangCHuLayout.setHorizontalGroup(
            btnTrangCHuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnTrangCHuLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel4)
                .addGap(26, 26, 26)
                .addComponent(btnTrangChu)
                .addContainerGap(46, Short.MAX_VALUE))
        );
        btnTrangCHuLayout.setVerticalGroup(
            btnTrangCHuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnTrangCHuLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(btnTrangCHuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnTrangChu)
                    .addComponent(jLabel4))
                .addGap(361, 361, 361))
        );

        btnTiemMui1.setBackground(new java.awt.Color(31, 30, 68));
        btnTiemMui1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTiemMui1MouseClicked(evt);
            }
        });

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Người Dân");

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icon_muitiem1.png"))); // NOI18N

        jPanel12.setBackground(new java.awt.Color(31, 30, 68));

        jLabel7.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel7.setText("Trang chủ");

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icon_user.png"))); // NOI18N

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel8)
                .addGap(26, 26, 26)
                .addComponent(jLabel7)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addGap(361, 361, 361))
        );

        javax.swing.GroupLayout btnTiemMui1Layout = new javax.swing.GroupLayout(btnTiemMui1);
        btnTiemMui1.setLayout(btnTiemMui1Layout);
        btnTiemMui1Layout.setHorizontalGroup(
            btnTiemMui1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnTiemMui1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel6)
                .addGap(26, 26, 26)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(btnTiemMui1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(btnTiemMui1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        btnTiemMui1Layout.setVerticalGroup(
            btnTiemMui1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnTiemMui1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(btnTiemMui1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(361, 361, 361))
            .addGroup(btnTiemMui1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(btnTiemMui1Layout.createSequentialGroup()
                    .addGap(172, 172, 172)
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(172, Short.MAX_VALUE)))
        );

        btnTiemMui2.setBackground(new java.awt.Color(31, 30, 68));
        btnTiemMui2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTiemMui2MouseClicked(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Mũi Tiêm");

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icon_muitiem2.png"))); // NOI18N

        jPanel16.setBackground(new java.awt.Color(31, 30, 68));

        jLabel15.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel15.setText("Trang chủ");

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icon_user.png"))); // NOI18N

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel16)
                .addGap(26, 26, 26)
                .addComponent(jLabel15)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16))
                .addGap(361, 361, 361))
        );

        javax.swing.GroupLayout btnTiemMui2Layout = new javax.swing.GroupLayout(btnTiemMui2);
        btnTiemMui2.setLayout(btnTiemMui2Layout);
        btnTiemMui2Layout.setHorizontalGroup(
            btnTiemMui2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnTiemMui2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel14)
                .addGap(26, 26, 26)
                .addComponent(jLabel13)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(btnTiemMui2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(btnTiemMui2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        btnTiemMui2Layout.setVerticalGroup(
            btnTiemMui2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnTiemMui2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(btnTiemMui2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel14)
                    .addComponent(jLabel13))
                .addGap(361, 361, 361))
            .addGroup(btnTiemMui2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(btnTiemMui2Layout.createSequentialGroup()
                    .addGap(172, 172, 172)
                    .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(172, Short.MAX_VALUE)))
        );

        btnThongKe.setBackground(new java.awt.Color(31, 30, 68));
        btnThongKe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThongKeMouseClicked(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Thống Kê");

        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icon_thongke.png"))); // NOI18N

        jPanel22.setBackground(new java.awt.Color(31, 30, 68));

        jLabel27.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel27.setText("Trang chủ");

        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icon_user.png"))); // NOI18N

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel28)
                .addGap(26, 26, 26)
                .addComponent(jLabel27)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel27)
                    .addComponent(jLabel28))
                .addGap(361, 361, 361))
        );

        javax.swing.GroupLayout btnThongKeLayout = new javax.swing.GroupLayout(btnThongKe);
        btnThongKe.setLayout(btnThongKeLayout);
        btnThongKeLayout.setHorizontalGroup(
            btnThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnThongKeLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel26)
                .addGap(26, 26, 26)
                .addComponent(jLabel25)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(btnThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(btnThongKeLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        btnThongKeLayout.setVerticalGroup(
            btnThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnThongKeLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(btnThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel25)
                    .addComponent(jLabel26))
                .addGap(361, 361, 361))
            .addGroup(btnThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(btnThongKeLayout.createSequentialGroup()
                    .addGap(172, 172, 172)
                    .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(172, Short.MAX_VALUE)))
        );

        btnCaiDat.setBackground(new java.awt.Color(31, 30, 68));
        btnCaiDat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCaiDatMouseClicked(evt);
            }
        });

        jLabel29.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Cài Đặt");

        jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icon_caidat.png"))); // NOI18N

        jPanel24.setBackground(new java.awt.Color(31, 30, 68));

        jLabel31.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel31.setText("Trang chủ");

        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icon_user.png"))); // NOI18N

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel32)
                .addGap(26, 26, 26)
                .addComponent(jLabel31)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel24Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel31)
                    .addComponent(jLabel32))
                .addGap(361, 361, 361))
        );

        javax.swing.GroupLayout btnCaiDatLayout = new javax.swing.GroupLayout(btnCaiDat);
        btnCaiDat.setLayout(btnCaiDatLayout);
        btnCaiDatLayout.setHorizontalGroup(
            btnCaiDatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnCaiDatLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel30)
                .addGap(26, 26, 26)
                .addComponent(jLabel29)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(btnCaiDatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(btnCaiDatLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        btnCaiDatLayout.setVerticalGroup(
            btnCaiDatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnCaiDatLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(btnCaiDatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel29)
                    .addComponent(jLabel30))
                .addGap(361, 361, 361))
            .addGroup(btnCaiDatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(btnCaiDatLayout.createSequentialGroup()
                    .addGap(172, 172, 172)
                    .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(172, Short.MAX_VALUE)))
        );

        btnChungNhan.setBackground(new java.awt.Color(31, 30, 68));
        btnChungNhan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnChungNhanMouseClicked(evt);
            }
        });

        jLabel33.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setText("Chứng Nhận");

        jLabel34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icon_chungnhan.png"))); // NOI18N

        jPanel26.setBackground(new java.awt.Color(31, 30, 68));

        jLabel35.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel35.setText("Trang chủ");

        jLabel36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icon_user.png"))); // NOI18N

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel36)
                .addGap(26, 26, 26)
                .addComponent(jLabel35)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel26Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel35)
                    .addComponent(jLabel36))
                .addGap(361, 361, 361))
        );

        javax.swing.GroupLayout btnChungNhanLayout = new javax.swing.GroupLayout(btnChungNhan);
        btnChungNhan.setLayout(btnChungNhanLayout);
        btnChungNhanLayout.setHorizontalGroup(
            btnChungNhanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnChungNhanLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel34)
                .addGap(26, 26, 26)
                .addComponent(jLabel33)
                .addContainerGap(35, Short.MAX_VALUE))
            .addGroup(btnChungNhanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(btnChungNhanLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        btnChungNhanLayout.setVerticalGroup(
            btnChungNhanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnChungNhanLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(btnChungNhanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel33)
                    .addComponent(jLabel34))
                .addGap(361, 361, 361))
            .addGroup(btnChungNhanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(btnChungNhanLayout.createSequentialGroup()
                    .addGap(172, 172, 172)
                    .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(172, Short.MAX_VALUE)))
        );

        btnDangXuat.setBackground(new java.awt.Color(31, 30, 68));
        btnDangXuat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDangXuatMouseClicked(evt);
            }
        });

        jLabel51.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(255, 255, 255));
        jLabel51.setText("Đăng Xuất");

        jLabel52.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icon_DangXuat.png"))); // NOI18N

        jPanel29.setBackground(new java.awt.Color(31, 30, 68));

        jLabel53.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel53.setText("Trang chủ");

        jLabel54.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icon_user.png"))); // NOI18N

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel54)
                .addGap(26, 26, 26)
                .addComponent(jLabel53)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel29Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel53)
                    .addComponent(jLabel54))
                .addGap(361, 361, 361))
        );

        javax.swing.GroupLayout btnDangXuatLayout = new javax.swing.GroupLayout(btnDangXuat);
        btnDangXuat.setLayout(btnDangXuatLayout);
        btnDangXuatLayout.setHorizontalGroup(
            btnDangXuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnDangXuatLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel52)
                .addGap(26, 26, 26)
                .addComponent(jLabel51)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(btnDangXuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(btnDangXuatLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        btnDangXuatLayout.setVerticalGroup(
            btnDangXuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnDangXuatLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(btnDangXuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel51)
                    .addComponent(jLabel52))
                .addGap(361, 361, 361))
            .addGroup(btnDangXuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(btnDangXuatLayout.createSequentialGroup()
                    .addGap(172, 172, 172)
                    .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(172, Short.MAX_VALUE)))
        );

        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icon_trash.png"))); // NOI18N
        jLabel17.setText("Thùng Rác");

        javax.swing.GroupLayout Layout_SideBarLayout = new javax.swing.GroupLayout(Layout_SideBar);
        Layout_SideBar.setLayout(Layout_SideBarLayout);
        Layout_SideBarLayout.setHorizontalGroup(
            Layout_SideBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Layout_SideBarLayout.createSequentialGroup()
                .addGroup(Layout_SideBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Layout_SideBarLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(Layout_SideBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnChungNhan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(Layout_SideBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(btnTiemMui2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnTiemMui1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnThongKe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(pen_logo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(Layout_SideBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnTrangCHu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnCaiDat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDangXuat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(Layout_SideBarLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel17)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Layout_SideBarLayout.setVerticalGroup(
            Layout_SideBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Layout_SideBarLayout.createSequentialGroup()
                .addComponent(pen_logo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTrangCHu, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTiemMui1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTiemMui2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnChungNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCaiDat, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDangXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 152, Short.MAX_VALUE)
                .addComponent(jLabel17)
                .addContainerGap())
        );

        Layout_Header.setBackground(new java.awt.Color(26, 25, 62));

        btnQLTaiKhoan.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        btnQLTaiKhoan.setForeground(new java.awt.Color(255, 255, 255));
        btnQLTaiKhoan.setText("Quản Lý Tài Khoản");
        btnQLTaiKhoan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnQLTaiKhoanMouseClicked(evt);
            }
        });

        btnTaoTaiKhoan.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        btnTaoTaiKhoan.setForeground(new java.awt.Color(255, 255, 255));
        btnTaoTaiKhoan.setText("Tạo Tài Khoản mới");
        btnTaoTaiKhoan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTaoTaiKhoanMouseClicked(evt);
            }
        });

        btn_image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icon_home_green.png"))); // NOI18N

        txtTieuDe.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtTieuDe.setForeground(new java.awt.Color(255, 51, 153));
        txtTieuDe.setText("Trang Chủ");

        txtTaiKhoanDangNhap.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtTaiKhoanDangNhap.setForeground(new java.awt.Color(255, 51, 153));
        txtTaiKhoanDangNhap.setText("admin");

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icon_avata.png"))); // NOI18N

        jLabel49.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icon_taomoi.png"))); // NOI18N

        jLabel50.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icon_user_qltk.png"))); // NOI18N

        javax.swing.GroupLayout Layout_HeaderLayout = new javax.swing.GroupLayout(Layout_Header);
        Layout_Header.setLayout(Layout_HeaderLayout);
        Layout_HeaderLayout.setHorizontalGroup(
            Layout_HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Layout_HeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel50)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Layout_HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Layout_HeaderLayout.createSequentialGroup()
                        .addComponent(btn_image)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTieuDe))
                    .addComponent(btnQLTaiKhoan))
                .addGroup(Layout_HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Layout_HeaderLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel49)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnTaoTaiKhoan)
                        .addContainerGap(412, Short.MAX_VALUE))
                    .addGroup(Layout_HeaderLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTaiKhoanDangNhap)
                        .addGap(30, 30, 30))))
        );
        Layout_HeaderLayout.setVerticalGroup(
            Layout_HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Layout_HeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Layout_HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Layout_HeaderLayout.createSequentialGroup()
                        .addGroup(Layout_HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Layout_HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel50)
                                .addComponent(jLabel49)
                                .addComponent(btnTaoTaiKhoan, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(btnQLTaiKhoan))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                        .addGroup(Layout_HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(Layout_HeaderLayout.createSequentialGroup()
                                .addComponent(txtTaiKhoanDangNhap)
                                .addGap(8, 8, 8))
                            .addGroup(Layout_HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtTieuDe)
                                .addComponent(btn_image))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Layout_HeaderLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel20)))
                .addContainerGap())
        );

        Layout_Footer.setBackground(new java.awt.Color(31, 30, 80));
        Layout_Footer.setPreferredSize(new java.awt.Dimension(634, 55));

        btnCapNhat.setBackground(new java.awt.Color(31, 30, 68));
        btnCapNhat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCapNhatMouseClicked(evt);
            }
        });

        jLabel37.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setText("Cập Nhật");

        jLabel38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icon_update.png"))); // NOI18N

        jPanel25.setBackground(new java.awt.Color(31, 30, 68));

        jLabel39.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel39.setText("Trang chủ");

        jLabel40.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icon_user.png"))); // NOI18N

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel40)
                .addGap(26, 26, 26)
                .addComponent(jLabel39)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel25Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel39)
                    .addComponent(jLabel40))
                .addGap(361, 361, 361))
        );

        javax.swing.GroupLayout btnCapNhatLayout = new javax.swing.GroupLayout(btnCapNhat);
        btnCapNhat.setLayout(btnCapNhatLayout);
        btnCapNhatLayout.setHorizontalGroup(
            btnCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnCapNhatLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel38)
                .addGap(18, 18, 18)
                .addComponent(jLabel37)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(btnCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(btnCapNhatLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        btnCapNhatLayout.setVerticalGroup(
            btnCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnCapNhatLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(btnCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel37)
                    .addComponent(jLabel38))
                .addGap(361, 361, 361))
            .addGroup(btnCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(btnCapNhatLayout.createSequentialGroup()
                    .addGap(172, 172, 172)
                    .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(172, Short.MAX_VALUE)))
        );

        btnBaoCao.setBackground(new java.awt.Color(31, 30, 68));
        btnBaoCao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBaoCaoMouseClicked(evt);
            }
        });

        jLabel41.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 255, 255));

        jLabel42.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icon_report.png"))); // NOI18N

        jPanel27.setBackground(new java.awt.Color(31, 30, 68));

        jLabel43.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel43.setText("Trang chủ");

        jLabel44.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icon_user.png"))); // NOI18N

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel44)
                .addGap(26, 26, 26)
                .addComponent(jLabel43)
                .addContainerGap(82, Short.MAX_VALUE))
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel27Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel43)
                    .addComponent(jLabel44))
                .addGap(361, 361, 361))
        );

        btnCmbBaoCao.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnCmbBaoCao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "     -- Báo Cáo --", "Người Dân Tiêm", "Nhân Viên Y Tế" }));
        btnCmbBaoCao.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                btnCmbBaoCaoItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout btnBaoCaoLayout = new javax.swing.GroupLayout(btnBaoCao);
        btnBaoCao.setLayout(btnBaoCaoLayout);
        btnBaoCaoLayout.setHorizontalGroup(
            btnBaoCaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnBaoCaoLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel42)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCmbBaoCao, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel41)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(btnBaoCaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(btnBaoCaoLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        btnBaoCaoLayout.setVerticalGroup(
            btnBaoCaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnBaoCaoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(btnBaoCaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel42)
                    .addGroup(btnBaoCaoLayout.createSequentialGroup()
                        .addComponent(jLabel41)
                        .addGap(30, 30, 30))
                    .addComponent(btnCmbBaoCao, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(367, 367, 367))
            .addGroup(btnBaoCaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(btnBaoCaoLayout.createSequentialGroup()
                    .addGap(172, 172, 172)
                    .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(172, Short.MAX_VALUE)))
        );

        btnTraCuu.setBackground(new java.awt.Color(31, 30, 68));
        btnTraCuu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTraCuuMouseClicked(evt);
            }
        });

        jLabel45.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(255, 255, 255));
        jLabel45.setText("Tra Cứu");

        jLabel46.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icon_search.png"))); // NOI18N

        jPanel28.setBackground(new java.awt.Color(31, 30, 68));

        jLabel47.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel47.setText("Trang chủ");

        jLabel48.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icon_user.png"))); // NOI18N

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel48)
                .addGap(26, 26, 26)
                .addComponent(jLabel47)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel28Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel47)
                    .addComponent(jLabel48))
                .addGap(361, 361, 361))
        );

        javax.swing.GroupLayout btnTraCuuLayout = new javax.swing.GroupLayout(btnTraCuu);
        btnTraCuu.setLayout(btnTraCuuLayout);
        btnTraCuuLayout.setHorizontalGroup(
            btnTraCuuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnTraCuuLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel46)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel45)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(btnTraCuuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(btnTraCuuLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        btnTraCuuLayout.setVerticalGroup(
            btnTraCuuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnTraCuuLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(btnTraCuuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel45)
                    .addComponent(jLabel46))
                .addGap(361, 361, 361))
            .addGroup(btnTraCuuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(btnTraCuuLayout.createSequentialGroup()
                    .addGap(172, 172, 172)
                    .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(172, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout Layout_FooterLayout = new javax.swing.GroupLayout(Layout_Footer);
        Layout_Footer.setLayout(Layout_FooterLayout);
        Layout_FooterLayout.setHorizontalGroup(
            Layout_FooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Layout_FooterLayout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addComponent(btnCapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addComponent(btnTraCuu, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(btnBaoCao, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Layout_FooterLayout.setVerticalGroup(
            Layout_FooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Layout_FooterLayout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(Layout_FooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnTraCuu, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBaoCao, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        Layout_Body.setPreferredSize(new java.awt.Dimension(670, 450));
        Layout_Body.setLayout(new java.awt.CardLayout());

        PanelTrangChu.setBackground(new java.awt.Color(51, 0, 153));
        PanelTrangChu.setPreferredSize(new java.awt.Dimension(670, 500));

        PanelChungNhan1.setBackground(new java.awt.Color(26, 25, 70));

        txtSoLuongTiemHomQua3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel22.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel22.setText("Số mũi đã tiêm hôm qua");

        textSLTiemHomQua.setBackground(new java.awt.Color(0, 0, 0));
        textSLTiemHomQua.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        textSLTiemHomQua.setText("0");

        javax.swing.GroupLayout txtSoLuongTiemHomQua3Layout = new javax.swing.GroupLayout(txtSoLuongTiemHomQua3);
        txtSoLuongTiemHomQua3.setLayout(txtSoLuongTiemHomQua3Layout);
        txtSoLuongTiemHomQua3Layout.setHorizontalGroup(
            txtSoLuongTiemHomQua3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(txtSoLuongTiemHomQua3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(textSLTiemHomQua, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );
        txtSoLuongTiemHomQua3Layout.setVerticalGroup(
            txtSoLuongTiemHomQua3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(txtSoLuongTiemHomQua3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(txtSoLuongTiemHomQua3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(textSLTiemHomQua))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtSoLuongTiemHomQua4.setBackground(new java.awt.Color(255, 255, 255));

        txtinfo1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtinfo1.setText("Số mũi đã tiêm toàn TP HCM");

        txtTongMuiTiemHCM.setBackground(new java.awt.Color(0, 0, 0));
        txtTongMuiTiemHCM.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtTongMuiTiemHCM.setText("0");

        javax.swing.GroupLayout txtSoLuongTiemHomQua4Layout = new javax.swing.GroupLayout(txtSoLuongTiemHomQua4);
        txtSoLuongTiemHomQua4.setLayout(txtSoLuongTiemHomQua4Layout);
        txtSoLuongTiemHomQua4Layout.setHorizontalGroup(
            txtSoLuongTiemHomQua4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(txtSoLuongTiemHomQua4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtinfo1, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(txtTongMuiTiemHCM, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        txtSoLuongTiemHomQua4Layout.setVerticalGroup(
            txtSoLuongTiemHomQua4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(txtSoLuongTiemHomQua4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(txtSoLuongTiemHomQua4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtinfo1)
                    .addComponent(txtTongMuiTiemHCM))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        table_TiemChungHomNay.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Tên quận", "SL Tiêm mũi 1", "SL tiêm >= 2 mũi", "Tổng mũi tiêm", "Tổng số người tiêm", "Tỉ lệ % so với TP"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(table_TiemChungHomNay);
        if (table_TiemChungHomNay.getColumnModel().getColumnCount() > 0) {
            table_TiemChungHomNay.getColumnModel().getColumn(0).setMinWidth(35);
            table_TiemChungHomNay.getColumnModel().getColumn(0).setMaxWidth(45);
        }

        javax.swing.GroupLayout PanelChungNhan1Layout = new javax.swing.GroupLayout(PanelChungNhan1);
        PanelChungNhan1.setLayout(PanelChungNhan1Layout);
        PanelChungNhan1Layout.setHorizontalGroup(
            PanelChungNhan1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelChungNhan1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelChungNhan1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelChungNhan1Layout.createSequentialGroup()
                        .addComponent(txtSoLuongTiemHomQua3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 126, Short.MAX_VALUE)
                        .addComponent(txtSoLuongTiemHomQua4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        PanelChungNhan1Layout.setVerticalGroup(
            PanelChungNhan1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelChungNhan1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(PanelChungNhan1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtSoLuongTiemHomQua4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSoLuongTiemHomQua3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout PanelTrangChuLayout = new javax.swing.GroupLayout(PanelTrangChu);
        PanelTrangChu.setLayout(PanelTrangChuLayout);
        PanelTrangChuLayout.setHorizontalGroup(
            PanelTrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelChungNhan1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PanelTrangChuLayout.setVerticalGroup(
            PanelTrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelChungNhan1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        Layout_Body.add(PanelTrangChu, "card3");

        PanelTiemMui2.setBackground(new java.awt.Color(26, 25, 70));
        PanelTiemMui2.setPreferredSize(new java.awt.Dimension(670, 500));
        PanelTiemMui2.setRequestFocusEnabled(false);

        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153), 2));

        cmbDotTiem_MT.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbDotTiem_MTItemStateChanged(evt);
            }
        });

        jLabel72.setText("Chọn đợt tiêm :");

        jLabel73.setText("Số ca tiêm:");

        jLabel74.setText("Loại Vắc Xin :");

        jLabel75.setText("Địa điểm tiêm :");

        jLabel76.setText("Danh sách: ");

        jLabel77.setText("Đội Ngũ :");

        jLabel78.setText("Mã lô :");

        jLabel79.setText("Ngày tiêm :");

        txtLoaiVacXin_MT.setForeground(new java.awt.Color(255, 102, 102));
        txtLoaiVacXin_MT.setText("................");

        txtDanhSach_MT.setForeground(new java.awt.Color(255, 102, 102));
        txtDanhSach_MT.setText("..............");

        txtDiaDiem_MT.setForeground(new java.awt.Color(255, 102, 102));
        txtDiaDiem_MT.setText("...............................................................");

        txtTongCaTiem_MT.setText("0");

        txtDoiNgu_MT.setForeground(new java.awt.Color(255, 102, 102));
        txtDoiNgu_MT.setText(".............");

        txtMaLo_MT.setForeground(new java.awt.Color(255, 102, 102));
        txtMaLo_MT.setText("...........................");

        txtNgayTiem_MT.setForeground(new java.awt.Color(255, 102, 102));
        txtNgayTiem_MT.setText("...........................");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDiaDiem_MT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel72, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbDotTiem_MT, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel73)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTongCaTiem_MT, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel75))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel78)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMaLo_MT)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                        .addComponent(jLabel76)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtDanhSach_MT)
                        .addGap(17, 17, 17))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel74)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtLoaiVacXin_MT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel79)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNgayTiem_MT)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel77)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDoiNgu_MT)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(12, 12, 12)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbDotTiem_MT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel72))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel74, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLoaiVacXin_MT))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel78)
                    .addComponent(jLabel76)
                    .addComponent(txtDanhSach_MT)
                    .addComponent(txtMaLo_MT))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel79)
                    .addComponent(txtNgayTiem_MT)
                    .addComponent(jLabel77)
                    .addComponent(txtDoiNgu_MT))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel75, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(txtDiaDiem_MT)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTongCaTiem_MT)
                    .addComponent(jLabel73))
                .addGap(6, 6, 6))
        );

        jLabel80.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel80.setText("Thông Tin Mũi Tiêm");

        jLabel89.setText("Tên nhân viên YT :");

        jLabel90.setText("Lần tiêm :");

        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153), 2));

        btnTimKiem_MT.setBackground(new java.awt.Color(51, 255, 51));
        btnTimKiem_MT.setText("Tìm Kiếm");
        btnTimKiem_MT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiem_MTActionPerformed(evt);
            }
        });

        jLabel86.setText("Họ và tên :");

        jLabel92.setText("CMND/CCCD :");

        btnSuaThongTin.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.borderColor"));
        btnSuaThongTin.setText("Sửa Thông Tin");
        btnSuaThongTin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaThongTinActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel92)
                            .addComponent(jLabel86, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtHoTen_MT)
                            .addComponent(txtCMND_MT)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel8Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(btnTimKiem_MT)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                        .addComponent(btnSuaThongTin)))
                .addGap(35, 35, 35))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCMND_MT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel92))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtHoTen_MT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel86))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSuaThongTin)
                    .addComponent(btnTimKiem_MT))
                .addGap(44, 44, 44))
        );

        btnThem_MT.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.borderColor"));
        btnThem_MT.setText("Thêm");
        btnThem_MT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThem_MTActionPerformed(evt);
            }
        });

        btnSua_MT.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.borderColor"));
        btnSua_MT.setText("   Sửa ");
        btnSua_MT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSua_MTActionPerformed(evt);
            }
        });

        btnXoa_MT.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.borderColor"));
        btnXoa_MT.setText("   Xóa   ");
        btnXoa_MT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoa_MTActionPerformed(evt);
            }
        });

        jLabel18.setText("Đội ngũ :");

        txtDoiNguTiem_MT.setForeground(new java.awt.Color(0, 51, 255));
        txtDoiNguTiem_MT.setText("..................");

        btnNhapLai_MT.setBackground(new java.awt.Color(51, 255, 51));
        btnNhapLai_MT.setText("Nhập lại");
        btnNhapLai_MT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhapLai_MTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel80)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel89, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNhanVienYT_MT, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(jLabel90)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cmbLanTiem_MT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(24, 24, 24)
                                        .addComponent(jLabel18)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtDoiNguTiem_MT))
                                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnSua_MT)
                                    .addComponent(btnThem_MT)
                                    .addComponent(btnXoa_MT)
                                    .addComponent(btnNhapLai_MT))))
                        .addGap(61, 61, 61))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel80)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(btnThem_MT)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSua_MT)
                        .addGap(18, 18, 18)
                        .addComponent(btnXoa_MT)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnNhapLai_MT))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel90)
                                .addComponent(cmbLanTiem_MT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel18)
                                .addComponent(txtDoiNguTiem_MT)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel89)
                            .addComponent(txtNhanVienYT_MT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        tableMuiTiem_MT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "CMND", "Họ tên", "Vắc xin", "Ngày tiêm", "Lần Tiêm", "Nhân viên YT"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableMuiTiem_MT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMuiTiem_MTMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tableMuiTiem_MT);

        javax.swing.GroupLayout PanelTiemMui2Layout = new javax.swing.GroupLayout(PanelTiemMui2);
        PanelTiemMui2.setLayout(PanelTiemMui2Layout);
        PanelTiemMui2Layout.setHorizontalGroup(
            PanelTiemMui2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelTiemMui2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelTiemMui2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 710, Short.MAX_VALUE))
                .addGap(10, 10, 10))
        );
        PanelTiemMui2Layout.setVerticalGroup(
            PanelTiemMui2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTiemMui2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
                .addContainerGap())
        );

        Layout_Body.add(PanelTiemMui2, "card5");

        PanelTiemMui1.setBackground(new java.awt.Color(26, 25, 70));
        PanelTiemMui1.setPreferredSize(new java.awt.Dimension(670, 500));
        PanelTiemMui1.setRequestFocusEnabled(false);

        jLabel57.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel57.setText("Thông Tin Người Dân");

        jLabel62.setText("Ngày sinh :");

        jLabel63.setText("Giới tính :");

        jLabel64.setText("Họ và tên :");

        jLabel65.setText("CMND/CCCD :");

        jLabel66.setText("Số điện thoại :");

        buttonNamNu_ND.add(radioNam_ND);
        radioNam_ND.setText("Nam");

        buttonNamNu_ND.add(radioNu_ND);
        radioNu_ND.setText("Nữ");

        jLabel67.setText("Quận :");

        jLabel68.setText("Phường :");

        jLabel69.setText("Địa chỉ :");

        cmbQuan_ND.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbQuan_NDItemStateChanged(evt);
            }
        });

        btnXoa_ND.setBackground(new java.awt.Color(255, 204, 102));
        btnXoa_ND.setText("  Xóa     ");
        btnXoa_ND.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoa_NDActionPerformed(evt);
            }
        });

        btnSua_ND.setBackground(new java.awt.Color(255, 204, 102));
        btnSua_ND.setText("   Sửa      ");
        btnSua_ND.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSua_NDActionPerformed(evt);
            }
        });

        btnNhapLai_ND.setBackground(new java.awt.Color(255, 204, 102));
        btnNhapLai_ND.setText("Nhập lại");
        btnNhapLai_ND.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhapLai_NDActionPerformed(evt);
            }
        });

        btnMoiNhat_ND.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.borderColor"));
        btnMoiNhat_ND.setText("Mới nhất");
        btnMoiNhat_ND.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoiNhat_NDActionPerformed(evt);
            }
        });

        btnTatCa_ND.setBackground(new java.awt.Color(51, 255, 51));
        btnTatCa_ND.setText("Tất cả");
        btnTatCa_ND.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTatCa_NDActionPerformed(evt);
            }
        });

        btnNhapMuiTiem_ND.setBackground(new java.awt.Color(255, 255, 102));
        btnNhapMuiTiem_ND.setText("Nhập mũi tiêm");
        btnNhapMuiTiem_ND.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhapMuiTiem_NDActionPerformed(evt);
            }
        });

        btnThem_ND.setBackground(new java.awt.Color(255, 204, 102));
        btnThem_ND.setText("Thêm    ");
        btnThem_ND.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThem_NDActionPerformed(evt);
            }
        });

        DateChooser_ND.setDateFormatString("dd/MM/yyyy");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel19.setText("/");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel57)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel64)
                                .addComponent(jLabel65)
                                .addComponent(jLabel66, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel62))
                            .addComponent(jLabel63))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCMND_ND)
                            .addComponent(txtHoTen_ND)
                            .addComponent(txtSDT_ND)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(radioNam_ND)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(radioNu_ND))
                            .addComponent(DateChooser_ND, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel67)
                                        .addGap(30, 30, 30)
                                        .addComponent(cmbQuan_ND, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel68)
                                            .addComponent(jLabel69))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(cmbPhuong_ND, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtDiaChi_ND, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(btnXoa_ND))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnThem_ND)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(btnNhapMuiTiem_ND)
                                .addGap(25, 25, 25)
                                .addComponent(btnTatCa_ND)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel19)
                                .addGap(4, 4, 4)))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnMoiNhat_ND, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnSua_ND)
                                    .addComponent(btnNhapLai_ND))
                                .addGap(4, 4, 4)))))
                .addGap(76, 76, 76))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel57)
                .addGap(17, 17, 17)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel65)
                            .addComponent(txtCMND_ND, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel64)
                            .addComponent(txtHoTen_ND, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel67)
                            .addComponent(cmbQuan_ND, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnThem_ND)
                            .addComponent(btnSua_ND))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel68)
                            .addComponent(cmbPhuong_ND, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnXoa_ND)
                            .addComponent(btnNhapLai_ND))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel69)
                            .addComponent(txtDiaChi_ND, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSDT_ND, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel66, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel62, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(DateChooser_ND, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel63)
                    .addComponent(radioNam_ND)
                    .addComponent(radioNu_ND)
                    .addComponent(btnNhapMuiTiem_ND)
                    .addComponent(btnTatCa_ND)
                    .addComponent(btnMoiNhat_ND)
                    .addComponent(jLabel19))
                .addGap(12, 12, 12))
        );

        tableNguoiDan_ND.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "CMND", "Họ Tên", "SĐT", "Ngày Sinh", "Giới Tính", "Địa Chỉ", "Phường", "Quận"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableNguoiDan_ND.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableNguoiDan_NDMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tableNguoiDan_ND);

        javax.swing.GroupLayout PanelTiemMui1Layout = new javax.swing.GroupLayout(PanelTiemMui1);
        PanelTiemMui1.setLayout(PanelTiemMui1Layout);
        PanelTiemMui1Layout.setHorizontalGroup(
            PanelTiemMui1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelTiemMui1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelTiemMui1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane5)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 714, Short.MAX_VALUE))
                .addContainerGap())
        );
        PanelTiemMui1Layout.setVerticalGroup(
            PanelTiemMui1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTiemMui1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(149, 149, 149))
        );

        Layout_Body.add(PanelTiemMui1, "card4");

        PanelThongKe.setBackground(new java.awt.Color(26, 25, 70));
        PanelThongKe.setForeground(new java.awt.Color(255, 255, 255));
        PanelThongKe.setPreferredSize(new java.awt.Dimension(670, 500));

        btn7NgaySau.setBackground(new java.awt.Color(102, 255, 0));
        btn7NgaySau.setText("7 ngày sau");
        btn7NgaySau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn7NgaySauActionPerformed(evt);
            }
        });

        btn7NgayTruoc.setText("7 ngày trước");
        btn7NgayTruoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn7NgayTruocActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelThongKeLayout = new javax.swing.GroupLayout(PanelThongKe);
        PanelThongKe.setLayout(PanelThongKeLayout);
        PanelThongKeLayout.setHorizontalGroup(
            PanelThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelThongKeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn7NgaySau)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn7NgayTruoc)
                .addContainerGap(526, Short.MAX_VALUE))
        );
        PanelThongKeLayout.setVerticalGroup(
            PanelThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelThongKeLayout.createSequentialGroup()
                .addContainerGap(478, Short.MAX_VALUE)
                .addGroup(PanelThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn7NgaySau)
                    .addComponent(btn7NgayTruoc))
                .addGap(15, 15, 15))
        );

        Layout_Body.add(PanelThongKe, "card2");
        PanelThongKe.getAccessibleContext().setAccessibleDescription("");

        PanelCaiDat.setBackground(new java.awt.Color(26, 25, 70));
        PanelCaiDat.setPreferredSize(new java.awt.Dimension(670, 500));

        jButton1.setText("Đổi Giao Diện");

        btnDoiPass.setText("Đổi Mật Khẩu");
        btnDoiPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoiPassActionPerformed(evt);
            }
        });

        panlemau1.setBackground(new java.awt.Color(26, 25, 70));

        jPanel10.setBackground(new java.awt.Color(255, 204, 0));
        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 3));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 104, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel14.setBackground(new java.awt.Color(102, 255, 102));
        jPanel14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 3));

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 102, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 95, Short.MAX_VALUE)
        );

        jPanel11.setBackground(new java.awt.Color(26, 25, 70));
        jPanel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 3));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 97, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 95, Short.MAX_VALUE)
        );

        btnMacDinh_CD.setBackground(new java.awt.Color(51, 255, 0));
        btnMacDinh_CD.setText("mặc định");
        btnMacDinh_CD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMacDinh_CDActionPerformed(evt);
            }
        });

        btnCam_CD.setBackground(java.awt.SystemColor.controlHighlight);
        btnCam_CD.setText("cam");
        btnCam_CD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCam_CDActionPerformed(evt);
            }
        });

        btnXanh_CD.setBackground(java.awt.SystemColor.controlHighlight);
        btnXanh_CD.setText("xanh");
        btnXanh_CD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXanh_CDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panlemau1Layout = new javax.swing.GroupLayout(panlemau1);
        panlemau1.setLayout(panlemau1Layout);
        panlemau1Layout.setHorizontalGroup(
            panlemau1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panlemau1Layout.createSequentialGroup()
                .addGroup(panlemau1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panlemau1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panlemau1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(btnMacDinh_CD)
                        .addGap(56, 56, 56)
                        .addComponent(btnCam_CD)))
                .addGroup(panlemau1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panlemau1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panlemau1Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(btnXanh_CD)))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        panlemau1Layout.setVerticalGroup(
            panlemau1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panlemau1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panlemau1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(panlemau1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXanh_CD)
                    .addComponent(btnCam_CD)
                    .addComponent(btnMacDinh_CD)))
        );

        panlemau2.setBackground(new java.awt.Color(26, 25, 70));

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));
        jPanel15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 3));

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 104, Short.MAX_VALUE)
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 89, Short.MAX_VALUE)
        );

        jPanel17.setBackground(new java.awt.Color(153, 0, 153));
        jPanel17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 3));

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 102, Short.MAX_VALUE)
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel18.setBackground(new java.awt.Color(51, 255, 204));
        jPanel18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 3));

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 97, Short.MAX_VALUE)
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panlemau2Layout = new javax.swing.GroupLayout(panlemau2);
        panlemau2.setLayout(panlemau2Layout);
        panlemau2Layout.setHorizontalGroup(
            panlemau2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panlemau2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(61, Short.MAX_VALUE))
        );
        panlemau2Layout.setVerticalGroup(
            panlemau2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panlemau2Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(panlemau2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        btnXanhNhat_CD.setBackground(java.awt.SystemColor.controlHighlight);
        btnXanhNhat_CD.setText("xanh nhạt");
        btnXanhNhat_CD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXanhNhat_CDActionPerformed(evt);
            }
        });

        btnTrang_CD.setBackground(java.awt.SystemColor.controlHighlight);
        btnTrang_CD.setText("trắng");
        btnTrang_CD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTrang_CDActionPerformed(evt);
            }
        });

        btnTim_CD.setBackground(java.awt.SystemColor.controlHighlight);
        btnTim_CD.setText("tím");
        btnTim_CD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTim_CDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelCaiDatLayout = new javax.swing.GroupLayout(PanelCaiDat);
        PanelCaiDat.setLayout(PanelCaiDatLayout);
        PanelCaiDatLayout.setHorizontalGroup(
            PanelCaiDatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCaiDatLayout.createSequentialGroup()
                .addGroup(PanelCaiDatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelCaiDatLayout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addGroup(PanelCaiDatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnDoiPass, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(30, 30, 30)
                        .addComponent(panlemau1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelCaiDatLayout.createSequentialGroup()
                        .addGap(216, 216, 216)
                        .addComponent(panlemau2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelCaiDatLayout.createSequentialGroup()
                        .addGap(253, 253, 253)
                        .addComponent(btnXanhNhat_CD)
                        .addGap(56, 56, 56)
                        .addComponent(btnTrang_CD)
                        .addGap(76, 76, 76)
                        .addComponent(btnTim_CD)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelCaiDatLayout.setVerticalGroup(
            PanelCaiDatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelCaiDatLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(btnDoiPass)
                .addGap(60, 60, 60)
                .addGroup(PanelCaiDatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(panlemau1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(panlemau2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelCaiDatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXanhNhat_CD)
                    .addComponent(btnTrang_CD)
                    .addComponent(btnTim_CD))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        Layout_Body.add(PanelCaiDat, "card7");
        PanelCaiDat.getAccessibleContext().setAccessibleName("");

        PanelChungNhan.setBackground(new java.awt.Color(26, 25, 70));
        PanelChungNhan.setPreferredSize(new java.awt.Dimension(670, 500));

        jLabel9.setText("CMND");

        txtCMND_CN.setText("1911165417");

        jLabel10.setText("Họ và tên");

        txtHoTen_CN.setText("Trần Thị Cẩm Tú");

        jLabel111.setText("Số điện thoại");

        txtSDT_CN.setText("0989384329");

        DateChooser_NgaySinh.setDateFormatString("dd/MM/yyyy");

        jLabel21.setText("Ngày sinh");

        jLabel12.setForeground(new java.awt.Color(255, 0, 0));
        jLabel12.setText("(*)");

        jLabel23.setForeground(new java.awt.Color(255, 0, 0));
        jLabel23.setText("(*)");

        jLabel24.setForeground(new java.awt.Color(255, 0, 0));
        jLabel24.setText("(*)");

        btnTraCuuMuiTiem_CN.setBackground(new java.awt.Color(51, 255, 0));
        btnTraCuuMuiTiem_CN.setText("Tra Cứu");
        btnTraCuuMuiTiem_CN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTraCuuMuiTiem_CNActionPerformed(evt);
            }
        });

        btnNhapLai_CN.setText("Nhập lại");
        btnNhapLai_CN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhapLai_CNActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel24))
                    .addComponent(txtCMND_CN, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel23))
                    .addComponent(txtHoTen_CN, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel111)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel12))
                    .addComponent(txtSDT_CN))
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(DateChooser_NgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65)
                        .addComponent(btnTraCuuMuiTiem_CN)
                        .addGap(29, 29, 29)
                        .addComponent(btnNhapLai_CN)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel111)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSDT_CN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jLabel23))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtHoTen_CN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel24))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCMND_CN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DateChooser_NgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnTraCuuMuiTiem_CN)
                        .addComponent(btnNhapLai_CN)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PanelMuiTiem_CN.setBackground(new java.awt.Color(255, 255, 255));

        Panel_QR_PCN.setBackground(new java.awt.Color(0, 102, 51));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel55.setText("Họ tên :");

        jLabel56.setText("CMND :");

        jLabel58.setText("Ngày sinh :");

        txtHoTen_QRcode.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtHoTen_QRcode.setText("Trần Thị Cẩm Tú");

        txtCMND_QRcode.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtCMND_QRcode.setText("1911165417");

        txtNgaySinh_QRcode.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtNgaySinh_QRcode.setText("17/02/1996");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel55)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtHoTen_QRcode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNgaySinh_QRcode, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel56)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCMND_QRcode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel55)
                    .addComponent(txtHoTen_QRcode))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel56)
                    .addComponent(txtCMND_QRcode))
                .addGap(12, 12, 12)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel58)
                    .addComponent(txtNgaySinh_QRcode))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        txTBSoMuiTiem.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txTBSoMuiTiem.setForeground(new java.awt.Color(255, 255, 255));
        txTBSoMuiTiem.setText("ĐÃ TIÊM 2 MŨI VẮC XIN");

        jLabel99.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/image_logo_CN.png"))); // NOI18N

        javax.swing.GroupLayout Panel_QR_PCNLayout = new javax.swing.GroupLayout(Panel_QR_PCN);
        Panel_QR_PCN.setLayout(Panel_QR_PCNLayout);
        Panel_QR_PCNLayout.setHorizontalGroup(
            Panel_QR_PCNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_QR_PCNLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(txTBSoMuiTiem)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_QR_PCNLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(Panel_QR_PCNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_QR_PCNLayout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_QR_PCNLayout.createSequentialGroup()
                        .addComponent(jLabel99)
                        .addGap(83, 83, 83))))
        );
        Panel_QR_PCNLayout.setVerticalGroup(
            Panel_QR_PCNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_QR_PCNLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel99)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txTBSoMuiTiem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel700.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel700.setText("CỘNG HÒA XÃ HỘI CHỦ NGHĨA VIỆT NAM");

        jLabel71.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel71.setText("Độc lập - Tự do - Hạnh phúc");

        jLabel81.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel81.setText("CHỨNG NHẬN TIÊM CHỦNG COVID-19");

        jLabel82.setText("Họ và tên");

        jLabel83.setText("CMND");

        jLabel84.setText("Ngày sinh");

        jLabel85.setText("Số điện thoại");

        txtHoten_PCN.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtHoten_PCN.setText("Trần thị cẩm tú");

        txtCMND_PCN.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtCMND_PCN.setText("1911165417");

        txtNgaySinh_PCN.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtNgaySinh_PCN.setText("01/01/2001");

        txtSDT_PCN.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtSDT_PCN.setText("0989382392");

        jLabel94.setText("Địa chỉ  :");

        txtDiaChi_CN.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtDiaChi_CN.setText("Phường 15 - Quận Bình Thạnh - Thành phố Hồ Chí Minh");

        jLabel96.setText("Kết luận :");

        jLabel97.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel97.setText("Đã được tiêm phòng vắc xin phòng bệnh Covid-19");

        tableTraCuu_CN.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mũi số", "Ngày tiêm", "Tên vắc xin", "Số lô", "Nơi tiêm"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane6.setViewportView(tableTraCuu_CN);
        if (tableTraCuu_CN.getColumnModel().getColumnCount() > 0) {
            tableTraCuu_CN.getColumnModel().getColumn(0).setMinWidth(45);
            tableTraCuu_CN.getColumnModel().getColumn(0).setMaxWidth(50);
            tableTraCuu_CN.getColumnModel().getColumn(1).setMinWidth(90);
            tableTraCuu_CN.getColumnModel().getColumn(1).setMaxWidth(110);
            tableTraCuu_CN.getColumnModel().getColumn(2).setMinWidth(100);
            tableTraCuu_CN.getColumnModel().getColumn(2).setMaxWidth(120);
            tableTraCuu_CN.getColumnModel().getColumn(3).setMinWidth(80);
            tableTraCuu_CN.getColumnModel().getColumn(3).setMaxWidth(100);
        }

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel96)
                            .addComponent(jLabel97))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane6)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel94)
                                        .addGap(83, 83, 83))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel82, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(54, 54, 54))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                        .addComponent(txtHoten_PCN, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(29, 29, 29)))
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel83)
                                    .addComponent(txtCMND_PCN, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel84, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNgaySinh_PCN, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(49, 49, 49)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel85, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtSDT_PCN, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(txtDiaChi_CN, javax.swing.GroupLayout.PREFERRED_SIZE, 504, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(jLabel81, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel700)
                                .addGap(126, 126, 126))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel71, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(189, 189, 189)))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel700)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel71)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel81)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel82)
                    .addComponent(jLabel83)
                    .addComponent(jLabel84)
                    .addComponent(jLabel85))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtHoten_PCN)
                    .addComponent(txtCMND_PCN)
                    .addComponent(txtNgaySinh_PCN)
                    .addComponent(txtSDT_PCN))
                .addGap(18, 18, 18)
                .addComponent(jLabel94)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDiaChi_CN)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel96)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel97)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout PanelMuiTiem_CNLayout = new javax.swing.GroupLayout(PanelMuiTiem_CN);
        PanelMuiTiem_CN.setLayout(PanelMuiTiem_CNLayout);
        PanelMuiTiem_CNLayout.setHorizontalGroup(
            PanelMuiTiem_CNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelMuiTiem_CNLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(Panel_QR_PCN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        PanelMuiTiem_CNLayout.setVerticalGroup(
            PanelMuiTiem_CNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelMuiTiem_CNLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelMuiTiem_CNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Panel_QR_PCN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        btnInPhieu_CN.setText("In Phiếu Chứng Nhận");
        btnInPhieu_CN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInPhieu_CNActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelChungNhanLayout = new javax.swing.GroupLayout(PanelChungNhan);
        PanelChungNhan.setLayout(PanelChungNhanLayout);
        PanelChungNhanLayout.setHorizontalGroup(
            PanelChungNhanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelChungNhanLayout.createSequentialGroup()
                .addGroup(PanelChungNhanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelChungNhanLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnInPhieu_CN))
                    .addGroup(PanelChungNhanLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(PanelChungNhanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(PanelMuiTiem_CN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        PanelChungNhanLayout.setVerticalGroup(
            PanelChungNhanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelChungNhanLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(PanelMuiTiem_CN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnInPhieu_CN)
                .addContainerGap())
        );

        Layout_Body.add(PanelChungNhan, "card6");

        javax.swing.GroupLayout LayoutLayout = new javax.swing.GroupLayout(Layout);
        Layout.setLayout(LayoutLayout);
        LayoutLayout.setHorizontalGroup(
            LayoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LayoutLayout.createSequentialGroup()
                .addComponent(Layout_SideBar, javax.swing.GroupLayout.PREFERRED_SIZE, 188, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(LayoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LayoutLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(LayoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Layout_Body, javax.swing.GroupLayout.PREFERRED_SIZE, 726, Short.MAX_VALUE)
                            .addComponent(Layout_Header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(Layout_Footer, javax.swing.GroupLayout.DEFAULT_SIZE, 730, Short.MAX_VALUE)))
        );
        LayoutLayout.setVerticalGroup(
            LayoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LayoutLayout.createSequentialGroup()
                .addGroup(LayoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(Layout_SideBar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 701, Short.MAX_VALUE)
                    .addGroup(LayoutLayout.createSequentialGroup()
                        .addComponent(Layout_Header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Layout_Body, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Layout_Footer, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        Layout_SideBar.getAccessibleContext().setAccessibleDescription("");
        Layout_Body.getAccessibleContext().setAccessibleName("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Layout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Layout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Cài đặt màu cho các nút btn có trong giao diện
    public void SettingColor(){
       btnTrangCHu.setBackground(Color.decode(colorbtn));
       btnThongKe.setBackground(Color.decode(colorbtn));
       btnTiemMui1.setBackground(Color.decode(colorbtn));
       btnTiemMui2.setBackground(Color.decode(colorbtn));
       btnChungNhan.setBackground(Color.decode(colorbtn));
       btnCaiDat.setBackground(Color.decode(colorbtn));
    }
    
   // Hàm ẩn tất cả Panel có trong giao diện
    public void HihePanel(){
       PanelTrangChu.hide();
       PanelThongKe.hide();
       PanelTiemMui1.hide();
       PanelTiemMui2.hide();
       PanelChungNhan.hide();
       PanelCaiDat.hide();
    }
    
    /*Tạo biểu đồ mũi tiêm*/
    public void TaoBieuDoMuiTiem(){
        PanelThongKe.remove(chartPanelMacDinh);
        PanelThongKe.setVisible(false);
        /*Khởi tạo lại biểu đồ nếu có sự thay đổi*/
        ChartPanel chartPanel = new ChartPanel(new ChartController().createChart(ngaytiem));
        chartPanel.setPreferredSize(new java.awt.Dimension(400, 300));
        chartPanel.setBounds(500, 500, 800, 450);
        chartPanel.setLocation(0, 0);
        chartPanelMacDinh = chartPanel;
        PanelThongKe.add(chartPanelMacDinh);
        PanelThongKe.setVisible(true);
    }

    /* Khi bấm vào chứng năng thì sẽ hiện icon tương ứng */
    public void SuaIconImage(String ten_icon_image) {
        BufferedImage img_btn;
        try {
            img_btn = ImageIO.read(new File("src/Image/"+ten_icon_image));
            btn_image.setIcon(new ImageIcon(img_btn));
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    // Click vào bt Trang chủ
    private void btnTrangCHuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTrangCHuMouseClicked
        HihePanel();
        PanelTrangChu.show();
        SettingColor();
        btnTrangCHu.setBackground(Color.decode(colorbtnActive));
        txtTieuDe.setText("Trang Chủ");
        SuaIconImage("icon_home_green.png");
        int soluongmuitiem = new PhieuChungNhanController().SoLuongMuiTiem();
        txtTongMuiTiemHCM.setText(String.valueOf(soluongmuitiem));

        int sltiemhomqua = new PhieuChungNhanController().SoLuongHomQua();
        textSLTiemHomQua.setText(String.valueOf(sltiemhomqua));
        new SoLieuVXTheoQuanController().SoLieuVacXinTheoQuan(table_TiemChungHomNay);
    }//GEN-LAST:event_btnTrangCHuMouseClicked


    private void btnThongKeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThongKeMouseClicked
        HihePanel();
        PanelThongKe.show();
        SettingColor();
        btnThongKe.setBackground(Color.decode(colorbtnActive));
        txtTieuDe.setText("Thống kê");
        SuaIconImage("icon_thongke.png");

        if (checkTaoBieuDo == false) {
            /*Khởi tạo biểu đồ*/
            chartPanelMacDinh = new ChartPanel(new ChartController().createChart(ngaytiem));
            chartPanelMacDinh.setPreferredSize(new java.awt.Dimension(400, 300));
            chartPanelMacDinh.setBounds(500, 500, 800, 450);
            chartPanelMacDinh.setLocation(0, 0);
            PanelThongKe.add(chartPanelMacDinh);
            PanelThongKe.setVisible(true);
        }
        checkTaoBieuDo = true;
    }//GEN-LAST:event_btnThongKeMouseClicked

    private void btnTiemMui1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTiemMui1MouseClicked
        HihePanel();
        PanelTiemMui1.show();
        SettingColor();
        btnTiemMui1.setBackground(Color.decode(colorbtnActive));
        txtTieuDe.setText("Người Dân");
        SuaIconImage("icon_muitiem1.png");
    }//GEN-LAST:event_btnTiemMui1MouseClicked

    private void btnTiemMui2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTiemMui2MouseClicked
        HihePanel();
        PanelTiemMui2.show();
        SettingColor();
        btnTiemMui2.setBackground(Color.decode(colorbtnActive));
        txtTieuDe.setText("Mũi Tiêm");
        SuaIconImage("icon_muitiem2.png");
    }//GEN-LAST:event_btnTiemMui2MouseClicked

    private void btnChungNhanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnChungNhanMouseClicked
        HihePanel();
        PanelChungNhan.show();
        SettingColor();
        btnChungNhan.setBackground(Color.decode(colorbtnActive));
        txtTieuDe.setText("Chứng Nhận");
        SuaIconImage("icon_chungnhan.png");
    }//GEN-LAST:event_btnChungNhanMouseClicked

    private void btnCaiDatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCaiDatMouseClicked
        HihePanel();
        PanelCaiDat.show();
        SettingColor();
        btnCaiDat.setBackground(Color.decode(colorbtnActive));
        txtTieuDe.setText("Cài Đặt");
        SuaIconImage("icon_caidat.png");
    }//GEN-LAST:event_btnCaiDatMouseClicked

    private void btnCapNhatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCapNhatMouseClicked
        if (checkformBaoCao == false) {
            FormNhapLieu m = new FormNhapLieu(this);
            m.show();
            checkformBaoCao = true;
        }
    }//GEN-LAST:event_btnCapNhatMouseClicked

    public void ShowFormMain() {
        this.setVisible(true);
        checkformBaoCao = false;
    }

    public void HideFormMain() {
        this.setVisible(false);
    }

    /*Mở các form thống kê ra*/
    private void btnBaoCaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBaoCaoMouseClicked

    }//GEN-LAST:event_btnBaoCaoMouseClicked

    /*Tra cứu - tìm kiếm */
    private void btnTraCuuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTraCuuMouseClicked
        FormTimKiem m = new FormTimKiem(this);
        m.setVisible(true);
    }//GEN-LAST:event_btnTraCuuMouseClicked

    /* Xử lý đăng xuất */
    private void btnDangXuatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDangXuatMouseClicked
        int check = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn thoát khỏi chương trình không",
                "Thông báo", JOptionPane.YES_NO_OPTION);
        if (check == 0) {
            new Login().setVisible(true);
            this.hide();
        }
    }//GEN-LAST:event_btnDangXuatMouseClicked

    private void btnTaoTaiKhoanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTaoTaiKhoanMouseClicked
        FromTaoTaiKhoanMoi m = new FromTaoTaiKhoanMoi();
        m.show();
    }//GEN-LAST:event_btnTaoTaiKhoanMouseClicked

    private void btnDoiPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoiPassActionPerformed
        FromDoiMatKhau form = new  FromDoiMatKhau( taikhoandangnhap, matkhaudangnhap);
        form.show();
    }//GEN-LAST:event_btnDoiPassActionPerformed

    public void CaiDatNhapMuiTiem() {
        HihePanel();
        PanelTiemMui2.show();
        SettingColor();
        btnTiemMui2.setBackground(Color.decode("#FF3399"));
        txtTieuDe.setText("Mũi Tiêm");
        txtCMND_MT.setText(txtCMND_ND.getText());
        txtHoTen_MT.setText(txtHoTen_ND.getText());
        TimKiemThanhCong();
    }
    
    private void btnNhapMuiTiem_NDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhapMuiTiem_NDActionPerformed
        XoaTable(tableMuiTiem_MT);
        boolean checkTKND_moi = new PhieuChungNhanController().NhapMuiTiem(tableMuiTiem_MT, txtCMND_ND, txtHoTen_ND);
        if (checkTKND_moi) {
            CaiDatNhapMuiTiem(); // Lấy được thông tin khôn cần tìm kiếm
            HuyChonMuiTiem(); // Bắt chọn lại từng mũi tiêm
        } else {
            boolean checktimkiem = new PhieuChungNhanController().TimKiemMuiTiem(tableMuiTiem_MT, txtCMND_ND, txtHoTen_ND);
            if (checktimkiem) {
                CaiDatNhapMuiTiem();
                HuyChonMuiTiem(); // Bắt chọn lại từng mũi tiêm
            } else {
                JOptionPane.showMessageDialog(null, "Thông tin chính không chính xác\nKiểm tra lại cmnd hoặc họ tên",
                        "Thông báo", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnNhapMuiTiem_NDActionPerformed

    private void btnNhapLai_NDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhapLai_NDActionPerformed
        txtCMND_ND.setText("");
        txtHoTen_ND.setText("");
        txtSDT_ND.setText("");
        radioNam_ND.setSelected(true);
        radioNu_ND.setSelected(false);
        txtDiaChi_ND.setText("");
        cmbQuan_ND.setSelectedIndex(0);
        cmbPhuong_ND.setSelectedIndex(0);
    }//GEN-LAST:event_btnNhapLai_NDActionPerformed

    private void btnSua_NDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSua_NDActionPerformed
        boolean Validate = new Validation().Validate_NguoiDan(txtCMND_ND, txtHoTen_ND, txtSDT_ND, txtDiaChi_ND, "sua");
        if (Validate) {
            boolean themND = new NguoiDanController().SuaNguoiDan(txtCMND_ND, txtHoTen_ND, txtSDT_ND, DateChooser_ND, radioNam_ND, cmbQuan_ND, cmbPhuong_ND, txtDiaChi_ND);
            if (themND) {
                JOptionPane.showMessageDialog(null, "Sửa thành công !", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                new NguoiDanController().NguoiDanMoiNhat(tableNguoiDan_ND);
                btnTatCa_ND.setBackground(Color.decode("#C2C2C2"));
                btnMoiNhat_ND.setBackground(Color.decode("#33FF33"));
            } else {
                JOptionPane.showMessageDialog(null, "Sửa thất bại !\n Cmnd hoặc họ tên không chính xác",
                        "Thông báo", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnSua_NDActionPerformed

    private void btnXoa_NDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoa_NDActionPerformed
        boolean Validate = new Validation().Validate_NguoiDan(txtCMND_ND, txtHoTen_ND, txtSDT_ND, txtDiaChi_ND, "xoa");
        if (Validate) {
            boolean checkMuitiem = new PhieuChungNhanController().KiemTraMuiTiem(txtCMND_ND, txtHoTen_ND);
            if (checkMuitiem) { // TH1: người dân chưa tồn tại mũi tiêm
                int checkxoa = JOptionPane.showConfirmDialog(null, "Chú ý: \nHệ thống đã ghi nhân người dân tên : " + txtHoTen_ND.getText() + " đã có mũi tiêm \n"
                        + "Nếu như xóa người này thì toàn bộ mũi tiêm sẽ bị xóa\nBạn có chắc chắn không ?",
                        "Thông báo", JOptionPane.YES_NO_OPTION);
                if (checkxoa == 0) {
                    boolean xoatatca = new NguoiDanController().XoaTaTCaThongTinND(txtCMND_ND);
                    if (xoatatca) {
                        JOptionPane.showMessageDialog(null, "Xóa thành công !", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                        new NguoiDanController().LayTatCa_NguoiDan(tableNguoiDan_ND);
                        btnTatCa_ND.setBackground(Color.decode("#33FF33"));
                        btnMoiNhat_ND.setBackground(Color.decode("#C2C2C2"));
                    } else {
                        JOptionPane.showMessageDialog(null, "Xóa thất bại ! \n Cmnd hoặc họ tên không chính xác", "Thông báo", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } else { // TH2: người dân đã tồn tại mũi tiêm
                int check = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa người dân tên : " + txtHoTen_ND.getText() + " khỏi hệ thống không ?", "Thông báo", JOptionPane.YES_NO_OPTION);
                if (check == 0) {
                    boolean xoaND = new NguoiDanController().XoaNguoiDan(txtCMND_ND, txtHoTen_ND);
                    if (xoaND) {
                        JOptionPane.showMessageDialog(null, "Xóa thành công !", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                        new NguoiDanController().LayTatCa_NguoiDan(tableNguoiDan_ND);
                        btnTatCa_ND.setBackground(Color.decode("#33FF33"));
                        btnMoiNhat_ND.setBackground(Color.decode("#C2C2C2"));
                    } else {
                        JOptionPane.showMessageDialog(null, "Xóa thất bại ! \n Cmnd hoặc họ tên không chính xác", "Thông báo", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }
      
    }//GEN-LAST:event_btnXoa_NDActionPerformed

    private void btnMoiNhat_NDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoiNhat_NDActionPerformed
        new NguoiDanController().NguoiDanMoiNhat(tableNguoiDan_ND);
        btnTatCa_ND.setBackground(Color.decode("#C2C2C2"));
        btnMoiNhat_ND.setBackground(Color.decode("#33FF33"));
    }//GEN-LAST:event_btnMoiNhat_NDActionPerformed

    private void btnTatCa_NDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTatCa_NDActionPerformed
        new NguoiDanController().LayTatCa_NguoiDan(tableNguoiDan_ND);
        btnTatCa_ND.setBackground(Color.decode("#33FF33"));
        btnMoiNhat_ND.setBackground(Color.decode("#C2C2C2"));
    }//GEN-LAST:event_btnTatCa_NDActionPerformed

    private void btnThem_NDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThem_NDActionPerformed
        boolean Validate = new Validation().Validate_NguoiDan(txtCMND_ND, txtHoTen_ND, txtSDT_ND, txtDiaChi_ND, "them");
        if (Validate) {
            boolean themND = new NguoiDanController().ThemNguoiDan(txtCMND_ND, txtHoTen_ND, txtSDT_ND, DateChooser_ND, radioNam_ND, cmbQuan_ND, cmbPhuong_ND, txtDiaChi_ND);
            if (themND) {
                JOptionPane.showMessageDialog(null, "Thêm thành công !","Thông báo", JOptionPane.INFORMATION_MESSAGE);
                new NguoiDanController().NguoiDanMoiNhat(tableNguoiDan_ND);
                btnTatCa_ND.setBackground(Color.decode("#C2C2C2"));
                btnMoiNhat_ND.setBackground(Color.decode("#33FF33"));
            } else {
                JOptionPane.showMessageDialog(null, "Thêm thất bại !",
                        "Thông báo", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnThem_NDActionPerformed

    /*Quận thay đổi thì tên phường ứng với quận đó thay đổi theo*/
    private void cmbQuan_NDItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbQuan_NDItemStateChanged
        new PhuongController().Load_CMB_Phuong(cmbPhuong_ND, cmbQuan_ND);
    }//GEN-LAST:event_cmbQuan_NDItemStateChanged

    /*Đợt tiêm thay đổi thì thông tin đợt tiêm thay đổi theo*/
    private void cmbDotTiem_MTItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbDotTiem_MTItemStateChanged
        new DotTiemController().ThongTinDotTiem(cmbDotTiem_MT, txtLoaiVacXin_MT, txtMaLo_MT, txtNgayTiem_MT, txtDanhSach_MT, txtDoiNgu_MT, txtDiaDiem_MT, txtTongCaTiem_MT);
        txtDoiNguTiem_MT.setText(txtDoiNgu_MT.getText());
        new NhanVienYTController().Lay_CMB_TenNhanVien(txtDoiNguTiem_MT, txtNhanVienYT_MT);
        new LoaiVacXinController().Load_MuiTiem_TheoVacXin(txtLoaiVacXin_MT, cmbLanTiem_MT);
        new PhieuChungNhanController().Lay_MuiTiem_TheoDotTiem(tableMuiTiem_MT, cmbDotTiem_MT);
        HuyTimKiem();
        HuyChonMuiTiem();
    }//GEN-LAST:event_cmbDotTiem_MTItemStateChanged

    /*Color và kiểm tra nêu tìm kiếm thấy mũi tiêm */
    public void TimKiemThanhCong(){
        TimKiemMuiTiem = true;
        btnSuaThongTin.setBackground(Color.decode("#33FF33"));
        btnThem_MT.setBackground(Color.decode("#33FF33"));
    }
    
    /*Hủy color và kiểm tra nêu tìm kiếm thấy mũi tiêm */
    public void HuyTimKiem(){
        TimKiemMuiTiem = false;
        btnSuaThongTin.setBackground(Color.decode("#C2C2C2"));
        btnThem_MT.setBackground(Color.decode("#C2C2C2"));
    }
    
    
    /*Color và kiểm tra nêu chọn thấy mũi tiêm */
    public void ChonMuiTiemThanhCong(){
        Chonmuitem = true;
        btnSua_MT.setBackground(Color.decode("#33FF33"));
        btnXoa_MT.setBackground(Color.decode("#33FF33"));
    }
    
    /*Hủy color và kiểm tra nêu chọn thấy mũi tiêm */
    public void HuyChonMuiTiem(){
        Chonmuitem = false;
        btnSua_MT.setBackground(Color.decode("#C2C2C2"));
        btnXoa_MT.setBackground(Color.decode("#C2C2C2"));
    }
    
    /* Hàm Tìm kiếm thông tin mũi tiêm để dùng chung */
    public void TimKiemMuiTiem() {
        XoaTable(tableMuiTiem_MT);
        boolean checkTKND_moi = new PhieuChungNhanController().NhapMuiTiem(tableMuiTiem_MT, txtCMND_MT, txtHoTen_MT);
        if (checkTKND_moi) {
            TimKiemThanhCong();
        } else {
            boolean checktimkiem = new PhieuChungNhanController().TimKiemMuiTiem(tableMuiTiem_MT, txtCMND_MT, txtHoTen_MT);
            if (checktimkiem) {
                TimKiemThanhCong();
            } else {
                JOptionPane.showMessageDialog(null, "Thông tin chính không chính xác\nKiểm tra lại cmnd hoặc họ tên",
                        "Thông báo", JOptionPane.WARNING_MESSAGE);
            }
        }
    }
    
    /* Tìm kiếm thông tin các mũi tiêm của người dân */
    private void btnTimKiem_MTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiem_MTActionPerformed
        TimKiemMuiTiem();
    }//GEN-LAST:event_btnTimKiem_MTActionPerformed

    /*  Bảng Người Dân --  Click vào table hiện thị thông tin tương ứng lên ô nhập liêu*/
    private void tableNguoiDan_NDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableNguoiDan_NDMouseClicked
        try {
            int[] index = tableNguoiDan_ND.getSelectedRows();
            TableModel model = tableNguoiDan_ND.getModel();
            txtCMND_ND.setText(model.getValueAt(index[0], 1).toString());
            txtHoTen_ND.setText(model.getValueAt(index[0], 2).toString());
            txtSDT_ND.setText(model.getValueAt(index[0], 3).toString());
            String quan = model.getValueAt(index[0], 8).toString();
            String stringDate = model.getValueAt(index[0], 4).toString();
            Date date = new SimpleDateFormat("dd/MM/yyyy").parse(stringDate);
            DateChooser_ND.setDate(date);
            String gioitinh = model.getValueAt(index[0], 5).toString();
            if("Nam".equals(gioitinh)){
                radioNam_ND.setSelected(true);
                radioNu_ND.setSelected(false);
            }else{
                radioNam_ND.setSelected(false);
                radioNu_ND.setSelected(true);
            }
            cmbQuan_ND.setSelectedItem(quan);
            String phuong = model.getValueAt(index[0], 7).toString();
            cmbPhuong_ND.setSelectedItem(phuong);
            txtDiaChi_ND.setText(model.getValueAt(index[0], 6).toString());
        } catch (ParseException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tableNguoiDan_NDMouseClicked

    public void XoaTable(JTable table) {
        DefaultTableModel dm = (DefaultTableModel) table.getModel();
        dm.getDataVector().removeAllElements();
        table.revalidate();
        ((DefaultTableModel)table.getModel()).setNumRows(0);
    }
    
     /*  Bảng Mũi tiêm -- Click vào table hiện thị thông tin tương ứng lên ô nhập liêu*/
    private void tableMuiTiem_MTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMuiTiem_MTMouseClicked
        try {
            int[] index = tableMuiTiem_MT.getSelectedRows();
            TableModel model = tableMuiTiem_MT.getModel();
            txtCMND_MT.setText(model.getValueAt(index[0], 1).toString());
            txtHoTen_MT.setText(model.getValueAt(index[0], 2).toString());
            if (TimKiemMuiTiem) {
                if (!model.getValueAt(index[0], 3).toString().equals("Chưa cập nhật ...")) {
                    /*Xét lại đội ngũ ý tế và nhân viên y tế theo từng mũi tiê ---> hỗ trợ sửa người tiêm*/
                    String nhanvienYT = model.getValueAt(index[0], 6).toString();
                    new NhanVienYTController().Lay_MaDoiNgu_TenNV(txtDoiNguTiem_MT, nhanvienYT);
                    new NhanVienYTController().Lay_CMB_TenNhanVien(txtDoiNguTiem_MT, txtNhanVienYT_MT);
                    txtNhanVienYT_MT.setSelectedItem(nhanvienYT);
                    
                    String lantiem = model.getValueAt(index[0], 5).toString();
                    cmbLanTiem_MT.setSelectedItem(Integer.parseInt(lantiem));
                    ChonMuiTiemThanhCong();
                    TenVacXin = model.getValueAt(index[0], 3).toString();
                    LanTiem =  model.getValueAt(index[0], 5).toString(); 
                }
            }
        } catch (NumberFormatException ex) {
               JOptionPane.showMessageDialog(null, "Lỗi",
                    "Thông báo", JOptionPane.WARNING_MESSAGE);
        }
        // Lâu lâu bị lỗi, chưa giải quyết được
    }//GEN-LAST:event_tableMuiTiem_MTMouseClicked

    private void btnNhapLai_MTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhapLai_MTActionPerformed
        XoaTable(tableMuiTiem_MT);
        HuyTimKiem();
        HuyChonMuiTiem();
        /*Tạo sự thay đôi cmb để load ra thông tin mới*/
        cmbDotTiem_MT.setSelectedIndex(0);
        cmbDotTiem_MT.setSelectedIndex( new DotTiemController().layDSDotTiem().size()-1);
    }//GEN-LAST:event_btnNhapLai_MTActionPerformed

    private void btnThem_MTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThem_MTActionPerformed
        boolean Validation = new Validation().validate_PhieuChungNhan(txtCMND_MT, txtLoaiVacXin_MT, txtMaLo_MT, cmbDotTiem_MT, cmbLanTiem_MT);
        if (Validation) {
            boolean themMT = new PhieuChungNhanController().ThemMuiTiemND(cmbDotTiem_MT, cmbLanTiem_MT, txtCMND_MT, txtNhanVienYT_MT, txtDanhSach_MT);
            if (themMT) {
                JOptionPane.showMessageDialog(null, "Thêm thành công !", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                boolean checktimkiem = new PhieuChungNhanController().TimKiemMuiTiem(tableMuiTiem_MT, txtCMND_MT, txtHoTen_MT);
                if (checktimkiem) {
                    CaiDatNhapMuiTiem();
                    HuyChonMuiTiem();
                } else {
                    JOptionPane.showMessageDialog(null, "Lỗi hệ thống!", "Thông báo", JOptionPane.WARNING_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Thêm phiếu chứng nhận thất bại !", "Thông báo", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnThem_MTActionPerformed

    private void btnSuaThongTinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaThongTinActionPerformed
        if (TimKiemMuiTiem) {
            HihePanel();
            PanelTiemMui1.show();
            SettingColor();
            btnTiemMui1.setBackground(Color.decode("#FF3399"));
            txtTieuDe.setText("Người Dân");
            new NguoiDanController().SuaThongTinNguoiDan(tableNguoiDan_ND, txtCMND_MT, txtHoTen_MT, txtCMND_ND, txtHoTen_ND, txtSDT_ND, DateChooser_ND, radioNam_ND, radioNu_ND, cmbQuan_ND, cmbPhuong_ND, txtDiaChi_ND );
            HuyChonMuiTiem();
        } else {
            JOptionPane.showMessageDialog(null, "Bạn cần thực hiện tìm kiếm để thực hiện chức năng này","Thông báo", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnSuaThongTinActionPerformed

    private void btnXoa_MTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoa_MTActionPerformed
        int check = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa mũi tiêm này không : ?\nChi tiết:\nHọ và tên: " + txtHoTen_MT.getText() + " \nLoại vắc xin: " + TenVacXin + "\nMũi Tiêm: " + LanTiem + "", "Thông báo", JOptionPane.YES_NO_OPTION);
        if (check == 0) {
            boolean xoaMT = new PhieuChungNhanController().XoaMuiTiemND(TenVacXin, LanTiem, txtCMND_MT);
            if (xoaMT) {
                JOptionPane.showMessageDialog(null, "Xóa thành công !", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                TimKiemMuiTiem();
                HuyChonMuiTiem();
            } else {
                JOptionPane.showMessageDialog(null, "Xóa mũi tiêm thất bại !", "Thông báo", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnXoa_MTActionPerformed

    private void btnSua_MTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSua_MTActionPerformed
        boolean suaMT = new PhieuChungNhanController().SuaMuiTiemND(TenVacXin, LanTiem, txtCMND_MT, txtNhanVienYT_MT);
        if (suaMT) {
            JOptionPane.showMessageDialog(null, "Sửa thành công !", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                TimKiemMuiTiem();
                HuyChonMuiTiem();
        } else {
            JOptionPane.showMessageDialog(null, "Sửa mũi tiêm thất bại !", "Thông báo", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSua_MTActionPerformed

    public void TraCuuMuiTiem() {
        boolean tracuuPCN = new PhieuChungNhanController().TraCuuPhieuChungNhan(tableTraCuu_CN, txtCMND_CN, txtHoTen_CN, txtSDT_CN, DateChooser_NgaySinh, txtNgaySinh_PCN, txtDiaChi_CN);
        if (tracuuPCN) {
            txtHoten_PCN.setText(txtHoTen_CN.getText());
            txtHoTen_QRcode.setText(txtHoTen_CN.getText());
            txtCMND_PCN.setText(txtCMND_CN.getText());
            txtCMND_QRcode.setText(txtCMND_CN.getText());
            txtNgaySinh_PCN.setText(txtNgaySinh_PCN.getText());
            txtNgaySinh_QRcode.setText(txtNgaySinh_PCN.getText());
            txtSDT_PCN.setText(txtSDT_CN.getText());
            PanelMuiTiem_CN.setVisible(true);
            btnInPhieu_CN.setVisible(true);
            int sl = tableTraCuu_CN.getRowCount();
            if (sl == 1) {
                txTBSoMuiTiem.setText("ĐÃ TIÊM 1 MŨI VẮC XIN");
                Panel_QR_PCN.setBackground(Color.decode("#FFCC33"));
            } else {
                txTBSoMuiTiem.setText("ĐÃ TIÊM " + sl + " MŨI VẮC XIN");
                Panel_QR_PCN.setBackground(Color.decode("#006633"));
            }
        } else {
            PanelMuiTiem_CN.setVisible(false);
            btnInPhieu_CN.setVisible(false);
            JOptionPane.showMessageDialog(null, "Hệ thống không tìm thấy  !", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    private void btnTraCuuMuiTiem_CNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTraCuuMuiTiem_CNActionPerformed
        boolean ValidateMuitiem = new Validation().validateTraCuu_ChungNhan(txtCMND_CN, txtHoTen_CN, txtSDT_CN);
        if (ValidateMuitiem) {
            TraCuuMuiTiem();
        }
    }//GEN-LAST:event_btnTraCuuMuiTiem_CNActionPerformed

    private void btnInPhieu_CNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInPhieu_CNActionPerformed
        new PhieuChungNhanController().TraCuuPhieuChungNhan(tableTraCuu_CN, txtCMND_CN, txtHoTen_CN, txtSDT_CN, DateChooser_NgaySinh, txtNgaySinh_PCN, txtDiaChi_CN);
        int sl = tableTraCuu_CN.getRowCount();
        try {
            if (sl != 0) {
                Hashtable map = new Hashtable();
                if (sl == 1) {
                    map.put("$cmnd", txtCMND_CN.getText().trim());
                    Connection conn = getConnection();
                    JasperReport rpt = JasperCompileManager.compileReport("src/Report/rptPhieuChungNhan_Vang.jrxml");
                    JasperPrint p = JasperFillManager.fillReport(rpt, map, conn);
                    JasperViewer.viewReport(p, false);
                } else {
                    map.put("$cmnd", txtCMND_CN.getText().trim());
                    Connection conn = getConnection();
                    JasperReport rpt = JasperCompileManager.compileReport("src/Report/rptPhieuChungNhan_Xanh.jrxml");
                    JasperPrint p = JasperFillManager.fillReport(rpt, map, conn);
                    JasperViewer.viewReport(p, false);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Không thể In phiếu vì tra cứu không thành công  !", "Thông báo", JOptionPane.WARNING_MESSAGE);
            }
        } catch (JRException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnInPhieu_CNActionPerformed

    private void btnNhapLai_CNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhapLai_CNActionPerformed
        txtCMND_CN.setText("");
        txtHoTen_CN.setText("");
        txtSDT_CN.setText("");
        DateChooser_NgaySinh.setDate(date);
        PanelMuiTiem_CN.setVisible(false);
        btnInPhieu_CN.setVisible(false);
    }//GEN-LAST:event_btnNhapLai_CNActionPerformed

    public boolean checkQLTaiKhoan = false;
    /*Quản lý tài khoản --- admin*/
    private void btnQLTaiKhoanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnQLTaiKhoanMouseClicked
        if (checkQLTaiKhoan == false) {
            FormQuanLyTaiKhoan form = new FormQuanLyTaiKhoan();
            form.show();
            //checkQLTaiKhoan = true; 
        }
    }//GEN-LAST:event_btnQLTaiKhoanMouseClicked

    private void btn7NgayTruocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn7NgayTruocActionPerformed
        if (ngaytiem!=7) {
            ngaytiem = ngaytiem - 7;
            TaoBieuDoMuiTiem();
            if(ngaytiem==7){
                btn7NgayTruoc.setBackground(Color.decode("#FFFFFF"));
            }
        }else{
            JOptionPane.showMessageDialog(null, "Không thể xem ngày tiêm trong tương lai !", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btn7NgayTruocActionPerformed

    private void btn7NgaySauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn7NgaySauActionPerformed
        ngaytiem = ngaytiem + 7;
        TaoBieuDoMuiTiem();
        if(ngaytiem!=7){
                btn7NgayTruoc.setBackground(Color.decode("#66FF00"));
        }
    }//GEN-LAST:event_btn7NgaySauActionPerformed

    /*Mở các form thống kê ra*/
    private void btnCmbBaoCaoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_btnCmbBaoCaoItemStateChanged
        int value = btnCmbBaoCao.getSelectedIndex();
        if (value == 1 && checkformBaoCao == false) {
            FormThongKeNguoiDan formTKND = new FormThongKeNguoiDan(this);
            formTKND.setVisible(true);
            checkformBaoCao = true;    
        }
        if (value == 2 && checkformBaoCao == false ) {
            FormThongKeNhanVienYTe formTKYT = new FormThongKeNhanVienYTe(this);
            formTKYT.setVisible(true);
            checkformBaoCao = true;   
        }
    }//GEN-LAST:event_btnCmbBaoCaoItemStateChanged

    public void ChuMauDen(){
        txtTime.setForeground(Color.BLACK);
        btnQLTaiKhoan.setForeground(Color.BLACK);
        btnTaoTaiKhoan.setForeground(Color.BLACK);
        btnTrangChu.setForeground(Color.BLACK);
        jLabel25.setForeground(Color.BLACK);
        jLabel5.setForeground(Color.BLACK); 
        jLabel13.setForeground(Color.BLACK);
        jLabel33.setForeground(Color.BLACK); 
        jLabel29.setForeground(Color.BLACK);
        jLabel51.setForeground(Color.BLACK); 
        jLabel17.setForeground(Color.BLACK);
        jLabel37.setForeground(Color.BLACK); 
        jLabel45.setForeground(Color.BLACK);
        colorbtnActive = "#389FD6";
        txtTieuDe.setForeground(Color.decode("#389FD6"));
        txtTaiKhoanDangNhap.setForeground(Color.decode("#389FD6"));
    }
    
    public void ChuMauTrang(){
         txtTime.setForeground(Color.white);
        btnQLTaiKhoan.setForeground(Color.white);
        btnTaoTaiKhoan.setForeground(Color.white);
        btnTrangChu.setForeground(Color.white);
        jLabel25.setForeground(Color.white);
        jLabel5.setForeground(Color.white); 
        jLabel13.setForeground(Color.white);
        jLabel33.setForeground(Color.white); 
        jLabel29.setForeground(Color.white);
        jLabel51.setForeground(Color.white); 
        jLabel17.setForeground(Color.white);
        jLabel37.setForeground(Color.white); 
        jLabel45.setForeground(Color.white);    
        colorbtnActive = "#FF3399";
        txtTieuDe.setForeground(Color.decode("#FF3399"));
        txtTaiKhoanDangNhap.setForeground(Color.decode("#FF3399"));
    }
    
    
    private void DoiMauGiaoDien(String maugiaodien, String maunav) {
        btnCam_CD.setBackground(Color.decode("#E3E3E3"));
        btnMacDinh_CD.setBackground(Color.decode("#E3E3E3"));
        btnXanh_CD.setBackground(Color.decode("#E3E3E3"));
        btnXanhNhat_CD.setBackground(Color.decode("#E3E3E3"));
        btnTrang_CD.setBackground(Color.decode("#E3E3E3"));
        btnTim_CD.setBackground(Color.decode("#E3E3E3"));
        
        colorbtn = maunav;
        pen_logo.setBackground(Color.decode(maunav));
        btnTrangCHu.setBackground(Color.decode(maunav));
        btnThongKe.setBackground(Color.decode(maunav));   
        btnTiemMui1.setBackground(Color.decode(maunav));
        btnTiemMui2.setBackground(Color.decode(maunav));
        btnChungNhan.setBackground(Color.decode(maunav));
        btnCaiDat.setBackground(Color.decode(maunav));
        btnDangXuat.setBackground(Color.decode(maunav));
        
        Layout.setBackground(Color.decode(maunav));
        Layout_Body.setBackground(Color.decode(maunav));
        Layout_SideBar.setBackground(Color.decode(maunav));
        Layout_Footer.setBackground(Color.decode(maunav));
        Layout_Header.setBackground(Color.decode(maunav));
        btnCapNhat.setBackground(Color.decode(maunav));
        btnTraCuu.setBackground(Color.decode(maunav));
        btnBaoCao.setBackground(Color.decode(maunav));
        
        PanelTrangChu.setBackground(Color.decode(maugiaodien));
        PanelChungNhan1.setBackground(Color.decode(maugiaodien));
        
        PanelThongKe.setBackground(Color.decode(maugiaodien));
        
        PanelTiemMui1.setBackground(Color.decode(maugiaodien));
        jPanel4.setBackground(Color.decode(maugiaodien));
        
        PanelTiemMui2.setBackground(Color.decode(maugiaodien));
        jPanel6.setBackground(Color.decode(maugiaodien));
        
        PanelChungNhan.setBackground(Color.decode(maugiaodien));
        jPanel1.setBackground(Color.decode(maugiaodien));
                
        PanelCaiDat.setBackground(Color.decode(maugiaodien));
        
        panlemau1.setBackground(Color.decode(maugiaodien));
        panlemau2.setBackground(Color.decode(maugiaodien));
        
        btnCaiDat.setBackground(Color.decode(colorbtnActive));
    }
    
    private void btnCam_CDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCam_CDActionPerformed
         ChuMauDen();
        DoiMauGiaoDien("#FFCC00", "#FFCC00");
        btnCam_CD.setBackground(Color.decode("#33FF00"));
       
    }//GEN-LAST:event_btnCam_CDActionPerformed

    private void btnMacDinh_CDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMacDinh_CDActionPerformed
        ChuMauTrang();
        DoiMauGiaoDien("#1A1946", "#1A1946");
        btnMacDinh_CD.setBackground(Color.decode("#33FF00"));
    }//GEN-LAST:event_btnMacDinh_CDActionPerformed

    private void btnXanh_CDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXanh_CDActionPerformed
        ChuMauDen();
        DoiMauGiaoDien("#66FF66", "#66FF66");
        btnXanh_CD.setBackground(Color.decode("#33FF00"));

    }//GEN-LAST:event_btnXanh_CDActionPerformed

    private void btnXanhNhat_CDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXanhNhat_CDActionPerformed
        ChuMauDen();
        DoiMauGiaoDien("#33FFCC", "#33FFCC");
        btnXanhNhat_CD.setBackground(Color.decode("#33FF00"));
    }//GEN-LAST:event_btnXanhNhat_CDActionPerformed

    private void btnTrang_CDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTrang_CDActionPerformed
        ChuMauDen();
        DoiMauGiaoDien("#FFFFFF", "#FFFFFF");
        btnTrang_CD.setBackground(Color.decode("#33FF00"));
    }//GEN-LAST:event_btnTrang_CDActionPerformed

    private void btnTim_CDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTim_CDActionPerformed
        ChuMauTrang();
        DoiMauGiaoDien("#990099", "#990099");
        btnTim_CD.setBackground(Color.decode("#33FF00"));
    }//GEN-LAST:event_btnTim_CDActionPerformed

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @SuppressWarnings("override")
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser DateChooser_ND;
    private com.toedter.calendar.JDateChooser DateChooser_NgaySinh;
    private javax.swing.JPanel Layout;
    private javax.swing.JPanel Layout_Body;
    private javax.swing.JPanel Layout_Footer;
    private javax.swing.JPanel Layout_Header;
    private javax.swing.JPanel Layout_SideBar;
    private javax.swing.JPanel PanelCaiDat;
    private javax.swing.JPanel PanelChungNhan;
    private javax.swing.JPanel PanelChungNhan1;
    private javax.swing.JPanel PanelMuiTiem_CN;
    private javax.swing.JPanel PanelThongKe;
    private javax.swing.JPanel PanelTiemMui1;
    private javax.swing.JPanel PanelTiemMui2;
    private javax.swing.JPanel PanelTrangChu;
    private javax.swing.JPanel Panel_QR_PCN;
    private javax.swing.JButton btn7NgaySau;
    private javax.swing.JButton btn7NgayTruoc;
    private javax.swing.JPanel btnBaoCao;
    private javax.swing.JPanel btnCaiDat;
    private javax.swing.JButton btnCam_CD;
    private javax.swing.JPanel btnCapNhat;
    private javax.swing.JPanel btnChungNhan;
    private javax.swing.JComboBox<String> btnCmbBaoCao;
    private javax.swing.JPanel btnDangXuat;
    private javax.swing.JButton btnDoiPass;
    private javax.swing.JButton btnInPhieu_CN;
    private javax.swing.JButton btnMacDinh_CD;
    private javax.swing.JButton btnMoiNhat_ND;
    private javax.swing.JButton btnNhapLai_CN;
    private javax.swing.JButton btnNhapLai_MT;
    private javax.swing.JButton btnNhapLai_ND;
    private javax.swing.JButton btnNhapMuiTiem_ND;
    private javax.swing.JLabel btnQLTaiKhoan;
    private javax.swing.JButton btnSuaThongTin;
    private javax.swing.JButton btnSua_MT;
    private javax.swing.JButton btnSua_ND;
    private javax.swing.JLabel btnTaoTaiKhoan;
    private javax.swing.JButton btnTatCa_ND;
    private javax.swing.JButton btnThem_MT;
    private javax.swing.JButton btnThem_ND;
    private javax.swing.JPanel btnThongKe;
    private javax.swing.JPanel btnTiemMui1;
    private javax.swing.JPanel btnTiemMui2;
    private javax.swing.JButton btnTimKiem_MT;
    private javax.swing.JButton btnTim_CD;
    private javax.swing.JPanel btnTraCuu;
    private javax.swing.JButton btnTraCuuMuiTiem_CN;
    private javax.swing.JPanel btnTrangCHu;
    private javax.swing.JLabel btnTrangChu;
    private javax.swing.JButton btnTrang_CD;
    private javax.swing.JButton btnXanhNhat_CD;
    private javax.swing.JButton btnXanh_CD;
    private javax.swing.JButton btnXoa_MT;
    private javax.swing.JButton btnXoa_ND;
    private javax.swing.JLabel btn_image;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonNamNu_ND;
    private javax.swing.JComboBox<String> cmbDotTiem_MT;
    private javax.swing.JComboBox<String> cmbLanTiem_MT;
    private javax.swing.JComboBox<String> cmbPhuong_ND;
    private javax.swing.JComboBox<String> cmbQuan_ND;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
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
    private javax.swing.JLabel jLabel4;
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
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel700;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JPanel panlemau1;
    private javax.swing.JPanel panlemau2;
    private javax.swing.JPanel pen_logo;
    private javax.swing.JRadioButton radioNam_ND;
    private javax.swing.JRadioButton radioNu_ND;
    private javax.swing.JTable tableMuiTiem_MT;
    private javax.swing.JTable tableNguoiDan_ND;
    private javax.swing.JTable tableTraCuu_CN;
    private javax.swing.JTable table_TiemChungHomNay;
    private javax.swing.JLabel textSLTiemHomQua;
    private javax.swing.JLabel txTBSoMuiTiem;
    private javax.swing.JTextField txtCMND_CN;
    private javax.swing.JTextField txtCMND_MT;
    private javax.swing.JTextField txtCMND_ND;
    private javax.swing.JLabel txtCMND_PCN;
    private javax.swing.JLabel txtCMND_QRcode;
    private javax.swing.JLabel txtDanhSach_MT;
    private javax.swing.JLabel txtDiaChi_CN;
    private javax.swing.JTextField txtDiaChi_ND;
    private javax.swing.JLabel txtDiaDiem_MT;
    private javax.swing.JLabel txtDoiNguTiem_MT;
    private javax.swing.JLabel txtDoiNgu_MT;
    private javax.swing.JTextField txtHoTen_CN;
    private javax.swing.JTextField txtHoTen_MT;
    private javax.swing.JTextField txtHoTen_ND;
    private javax.swing.JLabel txtHoTen_QRcode;
    private javax.swing.JLabel txtHoten_PCN;
    private javax.swing.JLabel txtLoaiVacXin_MT;
    private javax.swing.JLabel txtMaLo_MT;
    private javax.swing.JLabel txtNgaySinh_PCN;
    private javax.swing.JLabel txtNgaySinh_QRcode;
    private javax.swing.JLabel txtNgayTiem_MT;
    private javax.swing.JComboBox<String> txtNhanVienYT_MT;
    private javax.swing.JTextField txtSDT_CN;
    private javax.swing.JTextField txtSDT_ND;
    private javax.swing.JLabel txtSDT_PCN;
    private javax.swing.JPanel txtSoLuongTiemHomQua3;
    private javax.swing.JPanel txtSoLuongTiemHomQua4;
    public javax.swing.JLabel txtTaiKhoanDangNhap;
    private javax.swing.JLabel txtTieuDe;
    private javax.swing.JLabel txtTime;
    private javax.swing.JLabel txtTongCaTiem_MT;
    private javax.swing.JLabel txtTongMuiTiemHCM;
    private javax.swing.JLabel txtinfo1;
    // End of variables declaration//GEN-END:variables
}
