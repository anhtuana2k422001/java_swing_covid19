package Controller;

import Model.ConnectionModel;
import Model.TaiKhoan;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class TaiKhoanController {

    public ArrayList<TaiKhoan> layDSTaiKhoan() {
        // Khởi tạo danh sách tài khoản
        ArrayList<TaiKhoan> danhsachTaiKhoan = new ArrayList<>();
        try {
            String sql = "Select * From TaiKhoan"; // Thực hiện câu lệnh SQL
            ResultSet rs = ConnectionModel.ThucHienSQL(sql);
            // Đọc từng bản ghi một
            while (rs.next()) {
                TaiKhoan tk = new TaiKhoan(rs.getString("tentaikhoan"),rs.getString("matkhau"),rs.getString("maquyen"));
                danhsachTaiKhoan.add(tk);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TaiKhoanController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return danhsachTaiKhoan;
    }

    /* Hàm tạo tài khoản */
    public boolean TaoTaiKhoan(TaiKhoan tk) {
        String sql = "insert into TaiKhoan values ('"+tk.getTentaikhoan()+"','"+tk.getMatkhau()+"','"+tk.getMaquyen()+"')";
        int update = ConnectionModel.UpdateSQl(sql);
        return 0 != update;
    }
    
    /* Hàm đổi mật khẩu */
    public boolean DoiMatKhau(String taikhoan, JPasswordField  matkhau) {
        String sql = "update TaiKhoan set MatKhau = '" + String.valueOf(matkhau.getPassword()) + "' where TenTaiKhoan = N'" + taikhoan + "'";
        int update = ConnectionModel.UpdateSQl(sql);
        return 0 != update;
    }
    
    /* Đăng nhập */
    public boolean DangNhap(String taikhoan, String matkhau) {
        for (TaiKhoan nv : layDSTaiKhoan()) {
            if (nv.getTentaikhoan().equals(taikhoan) && nv.getMatkhau().equals(matkhau)) {
                return true;
            }
        }
        return false;
    }
    
    public void QLTaiKhoan(JTable table_taikhoan, String chucnang) {
        DefaultTableModel tbModel = (DefaultTableModel) table_taikhoan.getModel();
        tbModel.setRowCount(0);
        int stt = 0;
        for (TaiKhoan item : layDSTaiKhoan()) {
            stt++;
            String mahoamatkhau = "";
            for (int i = 0; i <= item.getMatkhau().length(); i++) {
                mahoamatkhau = mahoamatkhau.concat("*");
            }
            String tenquyen = new QuyenController().LayTenQuyen(item.getMaquyen());
              if ("TatCa".equals(chucnang)) {
                    Object[] obj = new Object[]{stt, item.getTentaikhoan(), mahoamatkhau, tenquyen};
                    tbModel.addRow(obj);
                }
                if ("QuanLy".equals(chucnang)) {
                    if (tenquyen.equals("Quản Lý")) {
                        Object[] obj = new Object[]{stt, item.getTentaikhoan(), mahoamatkhau, tenquyen};
                        tbModel.addRow(obj);
                    }
                }
                if ("NhapLieu".equals(chucnang)) {
                    if (tenquyen.equals("Nhập Liệu")) {
                        Object[] obj = new Object[]{stt, item.getTentaikhoan(), mahoamatkhau, tenquyen};
                        tbModel.addRow(obj);
                    }
                }
        }
    }
    
    public void TimKiemTaiKhoan(JTable table_taikhoan, JTextField tentaikhoan, String chucnang) {
        DefaultTableModel tbModel = (DefaultTableModel) table_taikhoan.getModel();
        tbModel.setRowCount(0);
        int stt = 0;
        for (TaiKhoan item : layDSTaiKhoan()) {
            if (item.getTentaikhoan().contains(tentaikhoan.getText())) {
                stt++;
                String mahoamatkhau = "";
                for (int i = 0; i <= item.getMatkhau().length(); i++) {
                    mahoamatkhau = mahoamatkhau.concat("*");
                }
                String tenquyen = new QuyenController().LayTenQuyen(item.getMaquyen());
                if ("TatCa".equals(chucnang)) {
                    Object[] obj = new Object[]{stt, item.getTentaikhoan(), mahoamatkhau, tenquyen};
                    tbModel.addRow(obj);
                }
                if ("QuanLy".equals(chucnang)) {
                    if (tenquyen.equals("Quản Lý")) {
                        Object[] obj = new Object[]{stt, item.getTentaikhoan(), mahoamatkhau, tenquyen};
                        tbModel.addRow(obj);
                    }
                }
                if ("NhapLieu".equals(chucnang)) {
                    if (tenquyen.equals("Nhập Liệu")) {
                        Object[] obj = new Object[]{stt, item.getTentaikhoan(), mahoamatkhau, tenquyen};
                        tbModel.addRow(obj);
                    }
                }
            }
        }
    }
    
    public boolean XoaTaiKhoan(JLabel tentaikhoan) {
        String sql;
        if (!"admin".equals(tentaikhoan.getText())) {
            sql = "DELETE TK\n"
                    + "FROM TaiKhoan TK\n"
                    + "WHERE TenTaiKhoan = N'" + tentaikhoan.getText() + "'";
        } else {
            return false;
        }
        int update = ConnectionModel.UpdateSQl(sql);
        return 0 != update;
    }
    
    public boolean CapNhatTaiKhoan(JLabel tentaikhoan, JComboBox tenquyen) {
        String sql;
        String maquyen = new QuyenController().Get_MaQuyen(tenquyen);
        if (!"admin".equals(tentaikhoan.getText())) {
            sql = "UPDATE TaiKhoan SET MaQuyen = N'" + maquyen + "'\n"
                    + "WHERE TenTaiKhoan = N'" + tentaikhoan.getText() + "'";
        } else {
            return false;
        }
        int update = ConnectionModel.UpdateSQl(sql);
        return 0 != update;
    }
    
    // Kiểm tra quyền cho tài khoản
    public boolean KiemTraQuyenAdmin(String tentaikhoan) {
        for (TaiKhoan item : layDSTaiKhoan()) {
            if (item.getTentaikhoan().equals(tentaikhoan)) {
                if ("Q01".equals(item.getMaquyen())) {
                    return true;
                }
            }
        }
        return false;
    }

    // Test thử lấy ra một thông tin tài khoản
     public static void main(String args[]) {
         TaiKhoanController tkmodel = new TaiKhoanController();
         System.out.print("Tài Khoản: "+tkmodel.layDSTaiKhoan().get(0).getTentaikhoan());
         System.out.print("\nMật Khẩu: "+tkmodel.layDSTaiKhoan().get(0).getMatkhau());
         System.out.print("\nMã Quyền: "+tkmodel.layDSTaiKhoan().get(0).getMaquyen());
         System.out.println();
    }
     

}
