package Controller;

import Check_Validator.Validation;
import static Controller.PhuongController.Get_MaPhuong;
import static Controller.QuanController.Get_MaQuan;
import Model.ConnectionModel;
import Model.DotTiem;
import Model.NguoiDan;
import com.toedter.calendar.JDateChooser;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class NguoiDanController {
    public static ArrayList<NguoiDan> layDSNguoiDan() {
        // Khởi tạo danh sách tài khoản
        ArrayList<NguoiDan> danhsachNguoiDan = new ArrayList<>();
        try {
            String sql = "Select * From NguoiDan"; // Thực hiện câu lệnh SQL
            ResultSet rs = ConnectionModel.ThucHienSQL(sql);
            // Đọc từng bản ghi một
            while (rs.next()) {
                NguoiDan tk = new NguoiDan(rs.getString("cmnd"), rs.getString("hoten"), rs.getString("gioitinh"), rs.getString("namsinh"),
                        rs.getString("sdt"), rs.getString("maquan"), rs.getString("maphuong"), rs.getString("diachi"), rs.getString("masods"));
                danhsachNguoiDan.add(tk);
            }

        } catch (SQLException ex) {
            Logger.getLogger(NguoiDanController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return danhsachNguoiDan;
    }

    public void loadDataNguoiDan(JTable tbl_ThongKe, JTextField txt_TuNgay, JTextField txt_DenNgay, JComboBox cmb_Quan, JComboBox cmb_Phuong,
            JComboBox cmb_LoaiVacxin, JRadioButton opt_TheoNgay, JRadioButton opt_TheoThang, JCheckBox opt_khuVuc, JCheckBox opt_loaiVacxin, JComboBox cmb_Thang, JTextField txt_Tong) {

        String maquan = QuanController.Get_MaQuan(cmb_Quan); //get maquan
        String maphuong = PhuongController.Get_MaPhuong(cmb_Phuong); //get maphuong
        String tenloaiVacxin = cmb_LoaiVacxin.getSelectedItem().toString(); //get ten loai vacxin
        tbl_ThongKe.removeAll();
        //=============================================================================
        String opt = "";
        if (opt_TheoNgay.isSelected()) {//nếu thống kê theo ngày
            boolean validate = new Validation().Validate_ThongKe(txt_TuNgay.getText(), txt_DenNgay.getText()); //check có nhập từ ngày đến ngày không?
            if (validate) {
                if (txt_TuNgay.getText().equals("") && txt_DenNgay.getText().equals("")) { //nếu không nhập gì thì gán ngày đầu tiên đến ngày hiện tại
                    for (DotTiem i : new DotTiemController().layDSDotTiem()) {
                        txt_TuNgay.setText(i.getNgaytiem().toString());
                        break;
                    }//từ ngày của dợt đầu tiên
                    txt_DenNgay.setText(String.valueOf(LocalDate.now()));// ngày hiện tại
                }
                opt = " and dt.NgayTiem >='" + txt_TuNgay.getText() + "' and dt.NgayTiem <= '" + txt_DenNgay.getText() + "'";
            }//close validate
        } else {//nếu thống kê theo tháng
            opt = " and Month(dt.NgayTiem) =" + cmb_Thang.getSelectedItem().toString() + " ";
        }

        String theoKhuVuc;
        String theoLoaiVacxin;
        if (opt_khuVuc.isSelected()) {
            theoKhuVuc = " q.MaQuan ='" + maquan + "' and p.MaPhuong='" + maphuong + "' ";
        } else {
            theoKhuVuc = "";
        }
        if (opt_loaiVacxin.isSelected()) {
            theoLoaiVacxin = " lvx.TenLoai= '" + tenloaiVacxin + "' ";
        } else {
            theoLoaiVacxin = "";
        }
        if (opt_khuVuc.isSelected() && opt_loaiVacxin.isSelected()) {
            theoLoaiVacxin = " and " + theoLoaiVacxin;
           } try {
                String sql = "select nd.CMND, nd.HoTen, nd.NamSinh,nd.GioiTinh, nd.SDT,nd.DiaChi,p.TenPhuong, q.TenQuan, dt.NgayTiem, lvx.TenLoai, cn.LanTiem "
                        + " from NguoiDan nd \n"
                        + "join PhieuChungNhan cn on nd.CMND = cn.CMND\n"
                        + "join DotTiem dt  on cn.MaDotTiem = dt.MaDotTiem\n"
                        + "join Quan q on dt.MaQuan = q.MaQuan\n"
                        + "join Phuong p on dt.MaPhuong = p.MaPhuong\n"
                        + "join LoVacXin lo on lo.MaSoLo = dt.MaSoLo\n"
                        + "join LoaiVacXin lvx on lvx.MaLoai = lo.MaLoai\n"
                       + "where "
                        //q.MaQuan = N'Q1' and p.MaPhuong = 'P003'";
                        + theoKhuVuc + theoLoaiVacxin + opt;// Thực hiện câu lệnh SQL

                ResultSet rs = ConnectionModel.ThucHienSQL(sql);

                DefaultTableModel tbModel = (DefaultTableModel) tbl_ThongKe.getModel();
                tbModel.setRowCount(0);
                // Đọc từng bản ghi một

                int stt = 0;
                while (rs.next()) {
                    stt++;
                    Object[] obj = new Object[]{stt, rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11)};
                    tbModel.addRow(obj);
                }
                txt_Tong.setText(String.valueOf(stt));
                if (stt == 0) {
                    JOptionPane.showMessageDialog(null, "Không có kết quả thống kê phù hợp với điều kiện!",
                            "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                }

            } catch (SQLException ex) {
                Logger.getLogger(NguoiDanController.class.getName()).log(Level.SEVERE, null, ex);
            }
         if (!opt_khuVuc.isSelected() && !opt_loaiVacxin.isSelected()) {
            JOptionPane.showMessageDialog(null, "Mời chọn thống kê theo ngày hoặc theo khu vực",
                    "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
    }//close loadDataNguoiDan

    // Lấy thông tin tất cả người dân
    public void LayTatCa_NguoiDan(JTable tablenguoidan) {
        try {
            String sql = "SELECT CMND, HoTen, SDT, NamSinh, \n"
                    + "GioiTinh, DiaChi, TenPhuong, TenQuan \n"
                    + "FROM NguoiDan ND \n"
                    + "JOIN Phuong P ON P.MaPhuong = ND.MaPhuong\n"
                    + "JOIN Quan Q ON Q.MaQuan = ND.MaQuan";
            ResultSet rs = ConnectionModel.ThucHienSQL(sql);
            DefaultTableModel tbModel = (DefaultTableModel) tablenguoidan.getModel();
            tbModel.setRowCount(0);
            // Đọc từng bản ghi một
            int stt = 0;
            while (rs.next()) {
                 String gioitinh = "Nam";
                 if(!gioitinh.equals(rs.getString(5))){
                     gioitinh = "Nữ";
                 }
                stt++;
                Object[] obj = new Object[]{stt, rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
                    gioitinh, rs.getString(6), rs.getString(7), rs.getString(8)};
                tbModel.addRow(obj);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NguoiDanController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void SuaThongTinNguoiDan(JTable tablenguoidan , JTextField cmnd_mt, JTextField hoten_mt, JTextField cmnd,  JTextField hoten,   JTextField sdt, JDateChooser ngaysinh, JRadioButton gtnam, JRadioButton gtnu , JComboBox cmb_Quan, JComboBox cmb_Phuong , JTextField diachi ){
           try {
            String sql = "SELECT CMND, HoTen, SDT, NamSinh, \n"
                    + "GioiTinh, DiaChi, TenPhuong, TenQuan \n"
                    + "FROM NguoiDan ND \n"
                    + "JOIN Phuong P ON P.MaPhuong = ND.MaPhuong\n"
                    + "JOIN Quan Q ON Q.MaQuan = ND.MaQuan\n"
                    + "WHERE ND.CMND = '" + cmnd_mt.getText() + "' AND HoTen = N'" + hoten_mt.getText() + "'";
            ResultSet rs = ConnectionModel.ThucHienSQL(sql);
            DefaultTableModel tbModel = (DefaultTableModel) tablenguoidan.getModel();
            tbModel.setRowCount(0);
            // Đọc từng bản ghi một
            while (rs.next()) {
                 String gioitinh = "Nam";
                 if(!gioitinh.equals(rs.getString(5))){
                     gioitinh = "Nữ";
                     gtnu.setSelected(true);
                     gtnam.setSelected(false);
                 }else{
                    gtnu.setSelected(false);
                    gtnam.setSelected(true);
                 }
                Object[] obj = new Object[]{1, rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
                    gioitinh, rs.getString(6), rs.getString(7), rs.getString(8)};
                tbModel.addRow(obj);
                 cmnd.setText( rs.getString(1));
                 hoten.setText( rs.getString(2));
                 sdt.setText( rs.getString(3));
                 cmb_Quan.setSelectedItem(rs.getString(8));
                 cmb_Phuong.setSelectedItem(rs.getString(7));
                 diachi.setText( rs.getString(6));
                try {
                    Date date = new SimpleDateFormat("dd/MM/yyyy").parse( rs.getString(4));
                    ngaysinh.setDate(date);
                } catch (ParseException ex) {
                    Logger.getLogger(NguoiDanController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(NguoiDanController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean ThemNguoiDan(JTextField cmnd,  JTextField hoten,   JTextField sdt, JDateChooser ngaysinh, JRadioButton gt, JComboBox cmb_Quan, JComboBox cmb_Phuong , JTextField diachi){
        String gioitinh = "Nu";
        if(gt.isSelected()){
            gioitinh = "Nam";
        }
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String stringDate = dateFormat.format(ngaysinh.getDate());
        String maquan = Get_MaQuan(cmb_Quan);
        String maphuong = Get_MaPhuong(cmb_Phuong);
        String sql = "insert into NguoiDan values ('"+cmnd.getText()+"',N'"+hoten.getText()+"',N'"+gioitinh+"',N'"+ stringDate+"',N'"+sdt.getText()+"',N'"+maquan+"',N'"+ maphuong +"',N'"+diachi.getText()+"',N'DS030' )";
        int update = ConnectionModel.UpdateSQl(sql);
        return 0 != update;
    }
    
    public boolean SuaNguoiDan(JTextField cmnd,  JTextField hoten,   JTextField sdt, JDateChooser ngaysinh, JRadioButton gt, JComboBox cmb_Quan, JComboBox cmb_Phuong , JTextField diachi) {
        String gioitinh = "Nu";
        if (gt.isSelected()) {
            gioitinh = "Nam";
        }
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String stringDate = dateFormat.format(ngaysinh.getDate());
        System.out.print(stringDate);
        String maquan = Get_MaQuan(cmb_Quan);
        String maphuong = Get_MaPhuong(cmb_Phuong);
        String sql = "UPDATE NguoiDan SET HoTen = N'" + hoten.getText() + "', GioiTinh = N'" + gioitinh + "',  NamSinh = N'" + stringDate + "', SDT = N'" + sdt.getText() + "', MaQuan = N'" + maquan + "', MaPhuong = N'" + maphuong + "',DiaChi = N'" + diachi.getText() + "'\n"
                    + "WHERE CMND = '" + cmnd.getText() + "'";
        int update = ConnectionModel.UpdateSQl(sql);
        return 0 != update;
    }

    // Xóa người dân -- chưa có phiếu chứng nhận
    public boolean XoaNguoiDan(JTextField cmnd, JTextField hoten) {
        String sql = "DELETE NguoiDan\n"
                + "WHERE CMND = '" + cmnd.getText() + "' AND HoTen = '" + hoten.getText() + "' ";
        int update = ConnectionModel.UpdateSQl(sql);
        return 0 != update;
    }
    
    // Xóa tất cả thông tin người dân
    public boolean XoaTaTCaThongTinND(JTextField cmnd) {
        String sql = "DELETE PCN\n"
                + "FROM PhieuChungNhan PCN\n"
                + "WHERE CMND = N'" + cmnd.getText() + "'";
        ConnectionModel.UpdateSQl(sql);
        
        String sqlND = "DELETE NguoiDan\n"
                + "WHERE CMND = '" + cmnd.getText() + "'";
        int update = ConnectionModel.UpdateSQl(sqlND);
        return 0 != update;
    }
    
    public void NguoiDanMoiNhat(JTable tablenguoidan){
        String sql = "SELECT CMND, HoTen, SDT, NamSinh, GioiTinh, DiaChi, TenPhuong, TenQuan \n"
                + "FROM NguoiDan ND \n"
                + "JOIN Phuong P ON P.MaPhuong = ND.MaPhuong\n"
                + "JOIN Quan Q ON Q.MaQuan = ND.MaQuan\n"
                + "WHERE ND.CMND NOT IN  (\n"
                + "	SELECT PCN.CMND FROM PhieuChungNhan PCN\n"
                + ")";
        ResultSet rs = ConnectionModel.ThucHienSQL(sql);
        DefaultTableModel tbModel = (DefaultTableModel) tablenguoidan.getModel();
        tbModel.setRowCount(0);
        int stt = 0;
        try {
            while (rs.next()) {
                String gioitinh = "Nam";
                if (!gioitinh.equals(rs.getString(5))) {
                    gioitinh = "Nữ";
                }
                stt++;
                Object[] obj = new Object[]{stt, rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
                    gioitinh, rs.getString(6), rs.getString(7), rs.getString(8)};
                tbModel.addRow(obj);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NguoiDanController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void TimKiemNguoiDan(JTable tablenguoidan, JTextField cmnd, JTextField hoten, JTextField sdt, JTextField soluong) {
        String sql = "SELECT * FROM NguoiDan WHERE CMND LIKE N'%" + cmnd.getText() + "%'AND HoTen LIKE N'%" + hoten.getText() + "%' AND SDT LIKE N'%" + sdt.getText() + "%'";
        ResultSet rs = ConnectionModel.ThucHienSQL(sql);
        DefaultTableModel tbModel = (DefaultTableModel) tablenguoidan.getModel();
        tbModel.setRowCount(0);
        try {
            int stt = 0 ;
            while (rs.next()) {
                stt++;
                Object[] obj = new Object[]{
                    stt++,
                    rs.getString("CMND"),
                    rs.getString("HoTen"),
                    rs.getString("GioiTinh"),
                    rs.getString("NamSinh"),
                    rs.getString("SDT"),
                    rs.getString("MaQuan"),
                    rs.getString("MaPhuong"),
                    rs.getString("DiaChi"),
                    rs.getString("MaSoDS")};
                tbModel.addRow(obj);
            }
            soluong.setText(String.valueOf(stt));
        } catch (SQLException ex) {
            Logger.getLogger(NguoiDanController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public void LoadDataDanhSachND(JTable tablenguoidan, JTextField soluong){
        ArrayList<NguoiDan> loadNguoiDan = layDSNguoiDan();
        DefaultTableModel model = (DefaultTableModel) tablenguoidan.getModel();
        model.setRowCount(0);
        int stt = 0;
        for (NguoiDan nd : loadNguoiDan) {
            stt++;
            Object[] object = new Object[]{stt, nd.getCmnd(), nd.getHoten(), nd.getGioitinh(), nd.getNamsinh(), nd.getSdt(), nd.getMaquan(), nd.getMaphuong(), nd.getDiachi(), nd.getMasods()};
            model.addRow(object);
        }
        soluong.setText(String.valueOf(stt));
     }
    
}
