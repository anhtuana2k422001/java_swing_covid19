package Controller;

import Model.ConnectionModel;
import Model.NhanVienYT;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class NhanVienYTController {

    public ArrayList<NhanVienYT> layDSNhanVienYT() {
        // Khởi tạo danh sách nhân viên y tế
        ArrayList<NhanVienYT> danhsachNhanVienYT = new ArrayList<>();
        try {
            String sql = "Select * From NhanVienYT"; // Thực hiện câu lệnh SQL
            ResultSet rs = ConnectionModel.ThucHienSQL(sql);
            // Đọc từng bản ghi một
            while (rs.next()) {
                NhanVienYT nv = new NhanVienYT(rs.getString("manhanvienyt"), rs.getString("tennhanvienyt"), rs.getString("madoingu"), rs.getString("sdt"), rs.getString("coquan"), rs.getString("email"));
                danhsachNhanVienYT.add(nv);
            }

        } catch (SQLException ex) {
            Logger.getLogger(QuanController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return danhsachNhanVienYT;
    }

    public void loadDataNVYT(JTable tbl_ThongKe, JComboBox cmb_Thang, JComboBox cmb_Quan, JCheckBox opt_Thang, JCheckBox opt_Quan, JTextField txt_Tong) {
        String maquan = QuanController.Get_MaQuan(cmb_Quan); //get maquan
        String theoThang;
        String theoQuan;
         if(opt_Thang.isSelected()) //nếu thống kê theo tháng
              theoThang = " Month(dt.NgayTiem) = " + cmb_Thang.getSelectedItem().toString() + "";
         else theoThang = "";
         if(opt_Quan.isSelected())//nếu thống kê theo quận
              theoQuan = " q.MaQuan = '" + maquan + "' ";
         else theoQuan="";
         if(opt_Thang.isSelected() && opt_Quan.isSelected()) // nếu chọn thống kê theo tháng và quận
             theoThang += " and ";
        
        try {
            String sql = "select nv.MaNhanVienYT, nv.TenNhanVienYT, nv.SDT,nv.CoQuan,nv.Email, dt.NgayTiem, q.TenQuan from NhanVienYT nv\n"
                    + "join DotTiem dt on dt.MaDoiNgu = nv.MaDoiNgu\n"
                    +"join Quan q on q.MaQuan = dt.MaQuan"
                    + " where "
                    + theoThang
                    + theoQuan;// Thực hiện câu lệnh SQL

            ResultSet rs = ConnectionModel.ThucHienSQL(sql);

            DefaultTableModel tbModel = (DefaultTableModel) tbl_ThongKe.getModel();
            tbModel.setRowCount(0);
            // Đọc từng bản ghi một

            int stt = 0;
            while (rs.next()) {
                stt++;
                Object[] obj = new Object[]{stt, rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
                    rs.getString(5), rs.getString(6), rs.getString(7)};
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
    }//close loadDataNguoiDan

    /* Load table nhân viên y tế */
    public void loaddataNhanVienYT(JTable jTablenvyt) {
        ArrayList<NhanVienYT> loadNhanVienYT = new NhanVienYTController().layDSNhanVienYT();
        DefaultTableModel tbModel = (DefaultTableModel) jTablenvyt.getModel();
        tbModel.setRowCount(0);
        int stt = 0;
        for (NhanVienYT nv : loadNhanVienYT) {
            stt++;
            Object[] object = new Object[]{stt, nv.getMaNhanVienYT(), nv.getTenNhanVienYT(), nv.getSDT(), nv.getMaDoiNgu(), nv.getCoQuan(), nv.getEmail()};
            tbModel.addRow(object);
        }
    }
    
    /* Lấy ra thông tin các nhân viên y tế theo mã đôi ngũ */
    public void Lay_CMB_TenNhanVien(JLabel madoingu, JComboBox cmb_tennhanvien){
        String sql = "SELECT TenNhanVienYT\n"
                + "FROM NhanVienYT NV \n"
                + "JOIN DoiNguYT DN ON DN.MaDoiNgu = NV.MaDoiNgu\n"
                + "WHERE DN.MaDoiNgu = '"+madoingu.getText()+"'";
        ResultSet rs = ConnectionModel.ThucHienSQL(sql);
        
        try {
            cmb_tennhanvien.removeAllItems();
            while (rs.next()) {
                  cmb_tennhanvien.addItem(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienYTController.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
    
    /* Lấy ra mã đội ngũ từ 1 nhân viên viên y tế */
    public void Lay_MaDoiNgu_TenNV(JLabel madoingu, String tennhanvien){
        for(NhanVienYT item : layDSNhanVienYT()){
            if(item.getTenNhanVienYT().equals(tennhanvien)){
                madoingu.setText(item.getMaDoiNgu());
            }
        }
    }

    // Lấy ra ma nhân viên y tế từ tên
    public String Lay_MaNhanVienYT_TheoTen(String tennhanvien){
       String manhanvienyt = "";
        for(NhanVienYT item : layDSNhanVienYT()){
            if(item.getTenNhanVienYT().equals(tennhanvien)){
                manhanvienyt = item.getMaNhanVienYT();
            }
        }
        return manhanvienyt;
    }
    
    public void TimKiemNhanVienYT(JTable tablenhanvien, JTextField manhanvien, JTextField hotennhanvien, JTextField sdt, JTextField soluong) {
        String sql = "SELECT * FROM NhanVienYT WHERE MaNhanVienYT LIKE N'%" + manhanvien.getText().toUpperCase() + "%'AND TenNhanVienYT LIKE N'%" + hotennhanvien.getText().toUpperCase() + "%' AND SDT LIKE N'%" + sdt.getText() + "%'";
        ResultSet rs = ConnectionModel.ThucHienSQL(sql);
        DefaultTableModel tbModel = (DefaultTableModel) tablenhanvien.getModel();
        tbModel.setRowCount(0);
        try {
            int stt = 0;
            while (rs.next()) {
                stt++;
                Object[] obj = new Object[]{
                    stt++,
                    rs.getString("MaNhanVienYT"),
                    rs.getString("TenNhanVienYT"),
                    rs.getString("SDT"),
                    rs.getString("MaDoiNgu"),
                    rs.getString("CoQuan"),
                    rs.getString("Email"),};
                tbModel.addRow(obj);
            }
            soluong.setText(String.valueOf(stt));
        } catch (SQLException ex) {
            Logger.getLogger(NguoiDanController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void LoadDataTimKiemNVYT(JTable tablenhanvien, JTextField soluong){
        ArrayList<NhanVienYT> loadNhanVienYT = new NhanVienYTController().layDSNhanVienYT();
        DefaultTableModel model = (DefaultTableModel) tablenhanvien.getModel();
        model.setNumRows(0);
        int stt = 0;
        for (NhanVienYT nv : loadNhanVienYT) {
            stt++;
            Object[] object = new Object[]{stt, nv.getMaNhanVienYT(), nv.getTenNhanVienYT(), nv.getSDT(), nv.getMaDoiNgu(), nv.getCoQuan(), nv.getEmail()};
            model.addRow(object);
        }
        soluong.setText(String.valueOf(stt));
    }
}
