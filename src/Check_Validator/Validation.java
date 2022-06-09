package Check_Validator;

// Hàm để kiểm tra nhập liệu cho View
import Model.ConnectionModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Validation {

    /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>  Bắt đầu Validate Form Login >>>>>>>>>>>>>>>>>>>>>>>>>>>> */
    /* Hàm kiểm nhập liệu login */
    public boolean Validate_DangNhap(String taikhoan, String matkhau, JLabel thongbao) {
        if ("".equals(taikhoan)) {
            thongbao.setText("Chưa nhập tài khoản !");
            return false;
        }
        if ("".equals(matkhau)) {
            thongbao.setText("Chưa nhập mật khẩu!");
            return false;
        }
        return true;
    }
    /*>>>>>>>>>>>>>>>>>>>>>>>>>>>> Kết thúc Validate Form Login <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< */

    /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>  Bắt đầu Validate Form Đổi Mật Khẩu >>>>>>>>>>>>>>>>>>>>>>>>>>>> */
    public boolean Validate_DoiMatKhau(String mkdangnhap, JPasswordField mk_hientai, JPasswordField mk_moi, JPasswordField kt_matkhau) {
        String mkHienTai = String.valueOf(mk_hientai.getPassword());
        String mkMoi = String.valueOf(mk_moi.getPassword());
        String mkKTMatKhau = String.valueOf(kt_matkhau.getPassword());
        if (mkHienTai.isEmpty() | mkMoi.isEmpty() | mkKTMatKhau.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập thông tin đầy đủ", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        if (!mkdangnhap.equals(mkHienTai)) {
            JOptionPane.showMessageDialog(null, "Mật khẩu hiện tại không chính xác", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return false;
        }
      
        if (mkMoi.length() < 6 || mkMoi.length() > 8 || mkKTMatKhau.length() < 6 || mkKTMatKhau.length() > 8) {
            JOptionPane.showMessageDialog(null, "Mật khẩu phải có độ dài từ 6 đến 8 ký tự","Thông báo", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        
        if (!mkKTMatKhau.equals(mkMoi)) {
            JOptionPane.showMessageDialog(null, "Mật khẩu xác nhận không trùng khớp", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        if (mkdangnhap.equals(mkMoi)) {
            JOptionPane.showMessageDialog(null, "Mật khẩu mới không được trùng với mật khẩu hiện tại", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        
        return true;
    }
     /*>>>>>>>>>>>>>>>>>>>>>>>>>>>> Kết thúc Validate Form Đổi Mật Khẩu <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< */
    
    /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>  Bắt đầu Validate Form Tạo Tài Khoản <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< */
    /* Hàm Chech nhập liệu tạo tài khoản */
    public boolean Validate_TaiKhoan(String taikhoan, String matkhau, String checkmatkhau) {

        if (taikhoan.isEmpty() || matkhau.isEmpty() || checkmatkhau.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập thông tin đầy đủ",
                    "Thông báo", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        if (checkmatkhau.length() < 6 || checkmatkhau.length() > 8) {
            JOptionPane.showMessageDialog(null, "Mật khẩu phải có độ dài từ 6 đến 8 ký tự",
                    "Thông báo", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        
           if (matkhau.length() < 6 || matkhau.length() > 8) {
            JOptionPane.showMessageDialog(null, "Mật khẩu phải có độ dài từ 6 đến 8 ký tự",
                    "Thông báo", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        if (!matkhau.equals(checkmatkhau)) {
            JOptionPane.showMessageDialog(null, "Mật khẩu xác nhận không trùng khớp",
                    "Thông báo", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        /* kiểm tra xem tài khoản đã tồn tại hay chưa */
        String sql = "select * from TaiKhoan where TenTaiKhoan ='" + taikhoan + "'";
        ResultSet rs = ConnectionModel.ThucHienSQL(sql);
        try {
            if (true == rs.isBeforeFirst()) {
                JOptionPane.showMessageDialog(null, "Tài khoản đã tồn tại",
                        "Thông báo", JOptionPane.WARNING_MESSAGE);
                return false;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Tạo tài khoản không thành công",
                    "Thông báo", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>  Kết thúc Validate Form Tạo Tài Khoản ________________________________ */

    /*>>>>>>>>>>>>>>>>>>>>>>>>>>>> Bắt đầu Validate Form Người Dân <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< */
    public boolean Validate_NguoiDan(JTextField cmnd, JTextField hoten, JTextField sdt, JTextField diachi, String chucnang) {
        if ("them".equals(chucnang)) {
            /* kiểm tra xem người dân đã tồn tại hay chưa */
            String sql = "select * from NguoiDan where CMND ='" + cmnd.getText() + "'";
            ResultSet rs = ConnectionModel.ThucHienSQL(sql);
            try {
                if (true == rs.isBeforeFirst()) {
                    JOptionPane.showMessageDialog(null, "Người dân này đã tồn tại",
                            "Thông báo", JOptionPane.WARNING_MESSAGE);
                    return false;
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Thêm không thành công",
                        "Thông báo", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        
        if ("them".equals(chucnang) || "sua".equals(chucnang)) {
            if (cmnd.getText().isEmpty() | hoten.getText().isEmpty() | sdt.getText().isEmpty() | diachi.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Vui lòng nhập thông tin đầy đủ", "Thông báo", JOptionPane.WARNING_MESSAGE);
                return false;
            }
        }
 
        if ("xoa".equals(chucnang)) {
            if (cmnd.getText().isEmpty() | hoten.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Nhập cmnd và tên người dân để thực hiện chức năng xóa", "Thông báo", JOptionPane.WARNING_MESSAGE);
                return false;
            }
        }
        
        return true;
    }
    /*>>>>>>>>>>>>>>>>>>>>>>>>>>>> Kết thúc Validate Form Người Dân  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< */
    
    
    /*>>>>>>>>>>>>>>>>>>>>>>>>>>>> Bắt đầu Validate Form Người Dân <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< */
    public boolean validateTraCuu_ChungNhan(JTextField cmnd, JTextField hoten, JTextField sdt){
          if (cmnd.getText().isEmpty() | hoten.getText().isEmpty() | sdt.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ CMND, Họ tên, Số điện thoại để tra cứu !", "Thông báo", JOptionPane.WARNING_MESSAGE);
                return false;
            }
        return true;
    }
    /*>>>>>>>>>>>>>>>>>>>>>>>>>>>> Kết thúc Validate Form Người Dân  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< */
    
    
    /*>>>>>>>>>>>>>>>>>>>>>>>>>>>> Bắt đầu Validate Form Chứng Nhận <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< */
    public boolean validate_PhieuChungNhan(JTextField cmnd, JLabel tenvacxin, JLabel masolo, JComboBox dottiem,  JComboBox lantiem ){
        try {
            /* Kiểm tra  đội tuổi, số lượng mũi tiêm của mỗi loại vắc xin*/
            String sql1 = "SELECT LVX.TenLoai, LOVX.DoTuoi, LOVX.SoLuong, LOVX.MaSoLo\n"
                    + "FROM LoVacXin LOVX\n"
                    + "JOIN LoaiVacXin LVX ON LVX.MaLoai = LOVX.MaLoai\n"
                    + "WHERE LVX.TenLoai = '" + tenvacxin.getText() + "' AND LOVX.MaSoLo = '" + masolo.getText() + "'";

            /* Kiểm tra số lần tiêm, liệu trình của mỗi loại vắc xin*/
            String sql2 = "SELECT DT.NgayTiem, LVX.LieuTrinh, LVX.TenLoai, pcn.LanTiem\n"
                    + "FROM NguoiDan ND\n"
                    + "JOiN PhieuChungNhan PCN ON PCN.CMND = ND.CMND\n"
                    + "JOIN DotTiem DT ON DT.MaDotTiem = PCN.MaDotTiem\n"
                    + "JOIN LoVacXin LOVX ON LOVX.MaSoLo = DT.MaSoLo\n"
                    + "JOIN LoaiVacXin LVX ON LVX.MaLoai = LOVX.MaLoai\n"
                    + "WHERE ND.CMND = '" + cmnd.getText() + "'";

             /*Kiểm tra ngày theo liệu trình */
            String sql3 = "SELECT DT.NgayTiem FROM DotTiem DT WHERE DT.MaDotTiem = '"+dottiem.getSelectedItem().toString()+"'";
            
            /*Kiểm tra độ tuổi của người dân */
            String sql4 = "SELECT ND.NamSinh\n"
                    + "FROM NguoiDan ND WHERE ND.CMND = '" + cmnd.getText() + "'";

            ResultSet rs1 = ConnectionModel.ThucHienSQL(sql1);
            ResultSet rs2 = ConnectionModel.ThucHienSQL(sql2);
            ResultSet rs3 = ConnectionModel.ThucHienSQL(sql3);
            ResultSet rs4 = ConnectionModel.ThucHienSQL(sql4);
            while (rs1.next()) {
            }
            
            int muitiem = Integer.parseInt(lantiem.getSelectedItem().toString());
            int lieutrinh = 0;
            Calendar ngaytiem_gannhat = Calendar.getInstance() ;
            boolean checkvacxin = false;
            System.out.print(muitiem);
            while (rs2.next()) {
                if(rs2.getString(3).equals(tenvacxin.getText()) && rs2.getString(4).equals(lantiem.getSelectedItem().toString())){
                        JOptionPane.showMessageDialog(null, "Hệ Thống đã ghi nhận mũi tiêm lần "+ lantiem.getSelectedItem().toString()+ " của loại vắc xin "+tenvacxin.getText()+" trước đó!\nVậy nên không thể thêm", "Thông báo", JOptionPane.WARNING_MESSAGE);
                    return false;
                }
                 /*Nếu cùng loại vắc xin*/
                if (rs2.getString(3).equals(tenvacxin.getText())) {
                    checkvacxin = true;
                    lieutrinh = Integer.parseInt(rs2.getString(2));
                    for (int i = muitiem; i >= 2; i--) {
                        if (String.valueOf(i).equals(rs2.getString(4))) {
                            i = 0; // Thoát khỏi vòng for
                        }else{
                           if (i  ==  muitiem - 1) {
                                JOptionPane.showMessageDialog(null, "Hệ Thống chưa ghi nhận mũi tiêm lần " + String.valueOf(muitiem -1) + " của loại vắc xin " + tenvacxin.getText() + " trước đó---!\nVậy nên không thể thêm thêm mũi tiêm lần " + lantiem.getSelectedItem().toString(), "Thông báo", JOptionPane.WARNING_MESSAGE);
                                return false;
                            }
                        }
                        if(muitiem - 1 == rs2.getInt(4)){
                            /* Lấy ngày tiêm gần nhất của loại vắc xin đó */
                            ngaytiem_gannhat.setTime(rs2.getDate(1));
                        }
                    }
                }
            }
            
            /*Lấy ngày tiêm cần thêm để kiểm tra*/
            Calendar ngaytiem_canthem = Calendar.getInstance();
            while (rs3.next()) {
                ngaytiem_canthem.setTime(rs3.getDate(1));
            }
            
            /*Kiểm tra đã tồn tại mũi 1 của loại cần thêm vào hay chưa*/
            if (checkvacxin == false) {
                if (!lantiem.getSelectedItem().toString().equals("1")) {
                    JOptionPane.showMessageDialog(null, "Hệ Thống chưa ghi nhận mũi tiêm lần 1 của loại vắc xin " + tenvacxin.getText() + " trước đó!\nVậy nên không thể thêm thêm mũi tiêm lần " + lantiem.getSelectedItem().toString(), "Thông báo", JOptionPane.WARNING_MESSAGE);
                    return false;
                }
            }else{
                ngaytiem_gannhat.add(Calendar.DATE, + lieutrinh);
                if (ngaytiem_canthem.getTime().getDate() >= ngaytiem_gannhat.getTime().getDate()) {
                    // xem lại luôn chạy đúng
                    JOptionPane.showMessageDialog(null, "Đúng--- ", "Thông báo", JOptionPane.WARNING_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Sai --- ", "Thông báo", JOptionPane.WARNING_MESSAGE);
                }
            }
            
            
            while (rs4.next()) {
            }
            // Chức năng xóa tượng tự thêm..., Ví dụ xóa mũi thứ 2 trước khi xóa mũi đầu
            
        } catch (SQLException ex) {
            Logger.getLogger(Validation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return true;
    }
    
    /*>>>>>>>>>>>>>>>>>>>>>>>>>>>> Kết thúc Validate Form Chứng Nhận  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< */
    
    /*>>>>>>>>>>>>>>>>>>>>>>>>>>>> Bắt đầu Validate Form Thống Kê <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< */
    public boolean Validate_ThongKe(String txt_TuNgay, String txt_DenNgay) {
        if (!txt_TuNgay.equals("") && txt_DenNgay.equals("") || txt_TuNgay.equals("") && !txt_DenNgay.equals("")) {
            JOptionPane.showMessageDialog(null, "Phải nhập đủ từ ngày đến ngày",
                    "Thông báo", JOptionPane.WARNING_MESSAGE);
                    return false;
        }
        return true;
    }
    /*>>>>>>>>>>>>>>>>>>>>>>>>>>>> Kết thúc Validate Form Thống Kê  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< */
    
    
    /*>>>>>>>>>>>>>>>>>>>>>>>>>>>> Bắt đầu Validate Form Nhập Liệu <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< */
        // check thêm mã loại vacxin
    public boolean Validate_MaLoai(String maloai) {
        /* kiểm tra xem mã vacxin đã tồn tại hay chưa */
        String sql = "select * from LoaiVacXin where MaLoai ='" + maloai + "'";
        ResultSet rs = ConnectionModel.ThucHienSQL(sql);
        try {
            if (true == rs.isBeforeFirst()) {
                JOptionPane.showMessageDialog(null, "Mã loại vacxin đã tồn tại! Vui lòng nhập khác!",
                        "Thông báo", JOptionPane.WARNING_MESSAGE);
                return false;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Thêm mới không thành công",
                    "Thông báo", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    // check thêm mã đội ngũ
    public boolean Validate_MaDoiNgu(String madoingu) {
        /* kiểm tra xem mã đội ngũ đã tồn tại hay chưa */
        String sql = "select * from DoiNguYT where MaDoiNgu ='" + madoingu + "'";
        ResultSet rs = ConnectionModel.ThucHienSQL(sql);
        try {
            if (true == rs.isBeforeFirst()) {
                JOptionPane.showMessageDialog(null, "Mã đội ngũ đã tồn tại!Vui lòng nhập khác!",
                        "Thông báo", JOptionPane.WARNING_MESSAGE);
                return false;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Thêm mới không thành công",
                    "Thông báo", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
   // check thêm mã danh sách tiêm
    public boolean Validate_Masods(String masods) {
        /* kiểm tra xem mã danh sách tiêm đã tồn tại hay chưa */
        String sql = "select * from DanhSachTiem where Masods ='" + masods + "'";
        ResultSet rs = ConnectionModel.ThucHienSQL(sql);
        try {
            if (true == rs.isBeforeFirst()) {
                JOptionPane.showMessageDialog(null, "Mã danh sách đã tồn tại!Vui lòng nhập khác!",
                        "Thông báo", JOptionPane.WARNING_MESSAGE);
                return false;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Thêm mới không thành công",
                    "Thông báo", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    // check thêm mã phường
    public boolean Validate_MaPhuong(String maphuong) {
        /* kiểm tra xem mã phường đã tồn tại hay chưa */
        String sql = "select * from Phuong where MaPhuong ='" + maphuong + "'";
        ResultSet rs = ConnectionModel.ThucHienSQL(sql);
        try {
            if (true == rs.isBeforeFirst()) {
                JOptionPane.showMessageDialog(null, "Mã phường đã tồn tại!Vui lòng nhập khác!",
                        "Thông báo", JOptionPane.WARNING_MESSAGE);
                return false;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Thêm mới không thành công",
                    "Thông báo", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
     // check thêm mã quận
    public boolean Validate_MaQuan(String maquan) {
        /* kiểm tra xem mã quận đã tồn tại hay chưa */
        String sql = "select * from Quan where MaQuan ='" + maquan + "'";
        ResultSet rs = ConnectionModel.ThucHienSQL(sql);
        try {
            if (true == rs.isBeforeFirst()) {
                JOptionPane.showMessageDialog(null, "Mã quận đã tồn tại!Vui lòng nhập khác!",
                        "Thông báo", JOptionPane.WARNING_MESSAGE);
                return false;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Thêm mới không thành công",
                    "Thông báo", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
      // check thêm mã nhân viên y tế
    public boolean Validate_MaNhanVienYT(String manhanvienyt) {
        /* kiểm tra xem mã nhân viên y tế đã tồn tại hay chưa */
        String sql = "select * from NhanVienYT where MaNhanVienYT ='" + manhanvienyt + "'";
        ResultSet rs = ConnectionModel.ThucHienSQL(sql);
        try {
            if (true == rs.isBeforeFirst()) {
                JOptionPane.showMessageDialog(null, "Mã nhân viên y tế đã tồn tại! Vui lòng nhập khác!",
                        "Thông báo", JOptionPane.WARNING_MESSAGE);
                return false;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Thêm mới không thành công",
                    "Thông báo", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
      // check thêm mã đợt tiêm
    public boolean Validate_Madottiem(String madottiem) {
        /* kiểm tra xem mã đợt tiêm đã tồn tại hay chưa */
        String sql = "select * from DotTiem where Madottiem ='" + madottiem + "'";
        ResultSet rs = ConnectionModel.ThucHienSQL(sql);
        try {
            if (true == rs.isBeforeFirst()) {
                JOptionPane.showMessageDialog(null, "Mã đợt tiêm đã tồn tại! Vui lòng nhập khác!",
                        "Thông báo", JOptionPane.WARNING_MESSAGE);
                return false;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Thêm mới không thành công",
                    "Thông báo", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
      // check thêm mã số lô
    public boolean Validate_Masolo(String masolo) {
        /* kiểm tra xem mã số lô đã tồn tại hay chưa */
        String sql = "select * from LoVacXin where Masolo ='" + masolo + "'";
        ResultSet rs = ConnectionModel.ThucHienSQL(sql);
        try {
            if (true == rs.isBeforeFirst()) {
                JOptionPane.showMessageDialog(null, "Mã số lô đã tồn tại! Vui lòng nhập khác!",
                        "Thông báo", JOptionPane.WARNING_MESSAGE);
                return false;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Thêm mới không thành công",
                    "Thông báo", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    /*>>>>>>>>>>>>>>>>>>>>>>>>>>>> Kết thúc Validate Form Nhâ Liệu  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< */
}
