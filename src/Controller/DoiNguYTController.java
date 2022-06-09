package Controller;

import Model.ConnectionModel;
import Model.DoiNguYT;
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

public class DoiNguYTController {
     public ArrayList<DoiNguYT> layDSDoiNguYT() {
        // Khởi tạo danh sách tài khoản
        ArrayList<DoiNguYT> danhsachDoiNguYT = new ArrayList<>();
        try {
            String sql = "Select * From DoiNguYT"; // Thực hiện câu lệnh SQL
            ResultSet rs = ConnectionModel.ThucHienSQL(sql);
            // Đọc từng bản ghi một
            while (rs.next()) {
                DoiNguYT dn = new DoiNguYT(rs.getString("madoingu"),rs.getString("tendoingu"));
                danhsachDoiNguYT.add(dn);
            }
 
        } catch (SQLException ex) {
            Logger.getLogger(DoiNguYTController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return danhsachDoiNguYT;
    }

    public void loaddataDoiNguYT(JTable jTableDoiNgu) {
        ArrayList<DoiNguYT> loadDoiNguYT = new DoiNguYTController().layDSDoiNguYT();
        DefaultTableModel tbModel = (DefaultTableModel) jTableDoiNgu.getModel();
        tbModel.setRowCount(0);
        int stt = 0;
        for (DoiNguYT dnyt : loadDoiNguYT) {
            stt++;
            Object[] object = new Object[]{stt, dnyt.getMaDoiNgu(), dnyt.getTenDoiNgu()};
            tbModel.addRow(object);
        }
    }

    public void LoadDataToComboboxDoiNgu(JComboBox cmbmadnnvyt, JComboBox cmbmadoinguDotTiem) {
        try {
            String sql = "SELECT * FROM DoiNguYT";
            ResultSet rs = ConnectionModel.ThucHienSQL(sql);
            while (rs.next()) {
                cmbmadnnvyt.addItem(rs.getString("MaDoiNgu"));
                cmbmadoinguDotTiem.addItem(rs.getString("MaDoiNgu"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
}
