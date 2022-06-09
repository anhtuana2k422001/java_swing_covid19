package Controller;

import Model.ConnectionModel;
import Model.LoVacXin;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class LoVacXinController {
    public ArrayList<LoVacXin> layDSLoVacXin() {
        // Khởi tạo danh sách tài khoản
        ArrayList<LoVacXin> danhsachLoVacXin = new ArrayList<>();
        try {
            String sql = "Select * From LoVacXin"; // Thực hiện câu lệnh SQL
            ResultSet rs = ConnectionModel.ThucHienSQL(sql);
            while (rs.next()) {
                LoVacXin lvx = new LoVacXin(rs.getString("masolo"),rs.getInt("soluong"),rs.getString("maloai"),rs.getDate("ngaysanxuat").toString(),rs.getString("ngayhethan"),rs.getBoolean("trangthai"),rs.getString("dotuoi"));
                danhsachLoVacXin.add(lvx);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoVacXinController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return danhsachLoVacXin;
    }
    public void loaddataLoVacXin(JTable jTableLoVacXin) {

        ArrayList<LoVacXin> loadLoVacXin = new LoVacXinController().layDSLoVacXin();
        DefaultTableModel tbModel = (DefaultTableModel) jTableLoVacXin.getModel();
        tbModel.setRowCount(0);
        int stt = 0;
        for (LoVacXin lovx : loadLoVacXin) {
            stt++;
            Object[] object = new Object[]{stt, lovx.getMasolo(), lovx.getSoluong(), lovx.getMaloai(), lovx.getNgaysanxuat(), lovx.getNgayhethan(), lovx.isTrangthai(), lovx.getDotuoi()};
            tbModel.addRow(object);
        }
    }

    public void LoadDataToComboboxLoVacXin(JComboBox cmbMaSoLoDotTiem) {
        try {
            String sql = "SELECT * FROM LoVacXin";
            ResultSet rs = ConnectionModel.ThucHienSQL(sql);
            while (rs.next()) {
                cmbMaSoLoDotTiem.addItem(rs.getString("MaSoLo"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
