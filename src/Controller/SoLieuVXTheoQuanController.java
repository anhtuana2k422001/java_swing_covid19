package Controller;

import Model.ConnectionModel;
import Model.Quan;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class SoLieuVXTheoQuanController {
    
    public void SoLieuVacXinTheoQuan(JTable table_solieumuitiem) {
        try {
            int stt = 0;
            DefaultTableModel tbModel = (DefaultTableModel) table_solieumuitiem.getModel();
            tbModel.setRowCount(0);

            for (Quan item : new QuanController().layDSQuan()) {
                stt++;
                /* lấy số mũi tiêm của 1 quận */
                double SLMuiTiemQuan = 0;
                String sqlmuitiem = "SELECT COUNT(PCN.CMND)\n"
                        + "FROM NguoiDan ND\n"
                        + "JOIN PhieuChungNhan PCN ON PCN.CMND = ND.CMND\n"
                        + "JOIN Quan Q ON Q.MaQuan = ND.MaQuan\n"
                        + "WHERE Q.TenQuan = N'" + item.getTenquan() + "'";
                ResultSet rs_mt = ConnectionModel.ThucHienSQL(sqlmuitiem);
                while (rs_mt.next()) {
                    SLMuiTiemQuan = rs_mt.getInt(1);
                }
                
                double SLNguoiDan = 0;
                /* lấy số người dân của 1 quận */
                String sqlnguoidan = "SELECT COUNT(ND.CMND) \n"
                        + "FROM NguoiDan ND\n"
                        + "JOIN Quan Q ON Q.MaQuan = ND.MaQuan\n"
                        + "WHERE Q.TenQuan = N'" + item.getTenquan() + "'";
                ResultSet rsnd = ConnectionModel.ThucHienSQL(sqlnguoidan);
                while (rsnd.next()) {
                    SLNguoiDan = rsnd.getInt(1);
                }
                
                double SLMuiTiem1 = 0;
                /* lấy số người dân đã tiêm mũi 1 của 1 quận */
                String sqltiemmui1 = "SELECT COUNT(PCN.CMND)\n"
                        + "FROM NguoiDan ND\n"
                        + "JOIN PhieuChungNhan PCN ON PCN.CMND = ND.CMND\n"
                        + "JOIN Quan Q ON Q.MaQuan = ND.MaQuan\n"
                        + "WHERE Q.TenQuan = N'" + item.getTenquan() + "' and pcn.LanTiem = '1'";
                ResultSet rs_tm1 = ConnectionModel.ThucHienSQL(sqltiemmui1);
                while (rs_tm1.next()) {
                    SLMuiTiem1 = rs_tm1.getInt(1);
                }
                
                  double SLMuiTiem2 = 0;
                /* lấy số người dân đã tiêm mũi 2 trở lên của 1 quận */
                String sqltiemmui2 = "SELECT COUNT(PCN.CMND)\n"
                        + "FROM NguoiDan ND\n"
                        + "JOIN PhieuChungNhan PCN ON PCN.CMND = ND.CMND\n"
                        + "JOIN Quan Q ON Q.MaQuan = ND.MaQuan\n"
                        + "WHERE Q.TenQuan = N'" + item.getTenquan() + "' and pcn.LanTiem != '1'";
                ResultSet rs_tm2 = ConnectionModel.ThucHienSQL(sqltiemmui2);
                while (rs_tm2.next()) {
                    SLMuiTiem2 = rs_tm2.getInt(1);
                }
                
                /* lấy tỉ lệ phần trăm mũi đã tiêm của 1 quận so với thành phố */
                double slMuiTiemTP = new PhieuChungNhanController().SoLuongMuiTiem();
                double TiLePhanTram = (SLMuiTiemQuan*100)/slMuiTiemTP;
                DecimalFormat f = new DecimalFormat("##.00");
               
                Object[] obj = new Object[]{stt, item.getTenquan() , (int)SLMuiTiem1, (int)SLMuiTiem2, (int)SLMuiTiemQuan, (int)SLNguoiDan, f.format(TiLePhanTram)+"%"};
                tbModel.addRow(obj);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SoLieuVXTheoQuanController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
