package Controller;

import static Controller.QuanController.Get_MaQuan;
import Model.ConnectionModel;
import Model.Phuong;
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

public class PhuongController {
    public ArrayList<Phuong> layDSPhuong() {
        // Khởi tạo danh sách Phường
        ArrayList<Phuong> danhsachPhuong = new ArrayList<>();
        try {
            String sql = "Select * From Phuong"; // Thực hiện câu lệnh SQL
            ResultSet rs = ConnectionModel.ThucHienSQL(sql);
            // Đọc từng bản ghi một
            while (rs.next()) {
                Phuong p = new Phuong(rs.getString("maphuong"), rs.getString("tenphuong"), rs.getString("maquan"));
                danhsachPhuong.add(p);
            }

        } catch (SQLException ex) {
            Logger.getLogger(PhuongController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return danhsachPhuong;
    }
    // Load tên phường theo quân vào cmb 
    public JComboBox Load_CMB_Phuong(JComboBox cmb_Phuong, JComboBox cmb_Quan) {
        cmb_Phuong.removeAllItems();
        String maQuan = Get_MaQuan(cmb_Quan);
        layDSPhuong().forEach(item -> {
            if(item.getMaQuan().equals(maQuan))
                cmb_Phuong.addItem(item.getTenPhuong());
        });
        return cmb_Phuong;
    }
    
    // Lấy ra mã phường từ tên phương
    public static String Get_MaPhuong(JComboBox cmb_Phuong) {
        ArrayList<Phuong> lstPhuong = new PhuongController().layDSPhuong();
        String maphuong = "";
        for (Phuong item : lstPhuong) {
            if (item.getTenPhuong().equals(cmb_Phuong.getSelectedItem().toString())) {
                maphuong = item.getMaPhuong();
            }
        }
        return maphuong;
    }
    
      public String LayTenphuong_TheoMaPhuong(String maphuong){
        String tenphuong = "";
       for(Phuong item : layDSPhuong()){
           if(item.getMaPhuong().equals(maphuong)){
               tenphuong = item.getTenPhuong();
           }
       }
       return tenphuong;
    }
    
     public String LayMapuong_TheoTenphuong(String tenphuong){
        String maphuong = "";
       for(Phuong item : layDSPhuong()){
           if(item.getTenPhuong().equals(tenphuong)){
               maphuong = item.getMaPhuong();
           }
       }
       return maphuong;
    }


    public static class loaddataPhuong {
        public loaddataPhuong(JTable jTablePhuong) {
        ArrayList<Phuong> loadPhuong = new PhuongController().layDSPhuong();
        DefaultTableModel tbModel = (DefaultTableModel) jTablePhuong.getModel();
        tbModel.setRowCount(0);
        int stt = 0;
        for (Phuong p : loadPhuong) {
            stt++;
            String tenquan = new QuanController().LayTenquan_TheoMaQuan(p.getMaQuan());
            Object[] object = new Object[]{stt, p.getMaPhuong(), p.getTenPhuong(), tenquan};
            tbModel.addRow(object);
        }
        }
    }

}
