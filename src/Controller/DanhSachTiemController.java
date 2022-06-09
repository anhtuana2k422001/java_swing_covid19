package Controller;

import Model.ConnectionModel;
import Model.DanhSachTiem;
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

public class DanhSachTiemController {
    public ArrayList<DanhSachTiem> layDSDanhSachTiem() {
        // Khởi tạo danh sách tài khoản
        ArrayList<DanhSachTiem> danhsachDanhSachTiem = new ArrayList<>();
        try {
            String sql = "Select * From DanhSachTiem"; // Thực hiện câu lệnh SQL
            ResultSet rs = ConnectionModel.ThucHienSQL(sql);
            // Đọc từng bản ghi một
            while (rs.next()) {
                DanhSachTiem dst = new DanhSachTiem(rs.getString("masods"),rs.getString("tendanhsach"));
                danhsachDanhSachTiem.add(dst);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DanhSachTiemController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return danhsachDanhSachTiem;
    }

    public void loaddataDanhSachTiem(JTable jTableDanhSachTiem) {
        ArrayList<DanhSachTiem> loadDanhSachTiem = new DanhSachTiemController().layDSDanhSachTiem();
        DefaultTableModel tbModel = (DefaultTableModel) jTableDanhSachTiem.getModel();
        tbModel.setRowCount(0);
        int stt = 0;
        for (DanhSachTiem dst : loadDanhSachTiem) {
            stt++;
            Object[] object = new Object[]{stt, dst.getMasods(), dst.getTends()};
            tbModel.addRow(object);
        }
    }

    public void LoadDataToComboboxDanhSachTiem(JComboBox cmbMaSoDSDotTiem) {
        try {
            // Thực hiện kết nối
            String sql = "SELECT * FROM DanhSachTiem";
            ResultSet rs = ConnectionModel.ThucHienSQL(sql);
            while (rs.next()) {
                cmbMaSoDSDotTiem.addItem(rs.getString("MaSoDS"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
