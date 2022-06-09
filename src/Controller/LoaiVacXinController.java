package Controller;

import Model.ConnectionModel;
import Model.LoaiVacXin;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class LoaiVacXinController {
     public ArrayList<LoaiVacXin> layDSLoaiVacXin() {
        // Khởi tạo danh sách tài khoản
        ArrayList<LoaiVacXin> danhsachLoaiVacXin = new ArrayList<>();
        try {
           String sql = "Select * From LoaiVacXin"; // Thực hiện câu lệnh SQL
           ResultSet rs = ConnectionModel.ThucHienSQL(sql);
            while (rs.next()) {
                LoaiVacXin loaivx = new LoaiVacXin(rs.getString("maloai"),rs.getString("tenloai"),rs.getInt("somuitiem"),rs.getString("xuatxu"),rs.getString("mota"),rs.getBoolean("trangthai"),rs.getInt("lieutrinh"));
                danhsachLoaiVacXin.add(loaivx);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoaiVacXinController.class.getName()).log(Level.SEVERE, null, ex);
       }
        return danhsachLoaiVacXin;
    }
     
      //Thêm data tên loại vacxin load vào cmb lên View
    public JComboBox Load_CMB_LoaiVacxin(JComboBox cmb_LoaiVacxin) {
        ArrayList<LoaiVacXin> lstLoaiVacxin=  new LoaiVacXinController().layDSLoaiVacXin();
        lstLoaiVacxin.forEach(item -> {
            cmb_LoaiVacxin.addItem(item.getTenloai());
        });
        return cmb_LoaiVacxin;
    }
    
    // Lấy ra các mã loại từ tên loại vacxin
    public static String Get_MaLoaiVacxin(JComboBox cmb_LoaiVacxin) {
        ArrayList<LoaiVacXin> lstLoaiVacxin = new LoaiVacXinController().layDSLoaiVacXin();
        String maquan = "";
        for (LoaiVacXin item : lstLoaiVacxin) {
            if (item.getTenloai().equals(cmb_LoaiVacxin.getSelectedItem().toString())) {
                maquan = item.getMaloai();
            }
        }
        return maquan;
    }

    public void loaddataLoaiVacXin(JTable jTableLoaiVacXin ) {
       ArrayList<LoaiVacXin> loadLoaiVacXin = new LoaiVacXinController().layDSLoaiVacXin();
        DefaultTableModel tbModel = (DefaultTableModel) jTableLoaiVacXin.getModel();
        tbModel.setRowCount(0);
        int stt = 0;
        for (LoaiVacXin lvx : loadLoaiVacXin) {
            stt++;
            Object[] object = new Object[]{stt, lvx.getMaloai(), lvx.getTenloai(), lvx.getSomuitiem(), lvx.getXuatxu(), lvx.getMota(), lvx.isTrangthai(), lvx.getLieutrinh()};
            tbModel.addRow(object);
        }
    }

    public static class LoadDataToComboboxLoaiVacXin {
        public LoadDataToComboboxLoaiVacXin(JComboBox cmbMaLoaiVacXin) {
            try {
                String sql = "SELECT * FROM LoaiVacXin";
                ResultSet rs = ConnectionModel.ThucHienSQL(sql);
                while (rs.next()) {
                    cmbMaLoaiVacXin.addItem(rs.getString("MaLoai"));
                }
            } catch (SQLException ex) {
                Logger.getLogger(ConnectionModel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    /* Lấy ra thông sô mũi tiem ( số lần tiêm ) của loại vắc xin theo tên */
    public void Load_MuiTiem_TheoVacXin(JLabel tenvacxin, JComboBox cmb_muitiem) {
        int muitiem = 0;
        for (LoaiVacXin item : layDSLoaiVacXin()) {
            if (item.getTenloai().equals(tenvacxin.getText())) {
                muitiem = item.getSomuitiem();
            }
        }

        cmb_muitiem.removeAllItems();
        for (int i = 1; i <= muitiem; i++) {
            cmb_muitiem.addItem(i);
        }
    }
    
   
}
