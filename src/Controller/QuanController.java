package Controller;
import Model.ConnectionModel;
import Model.Quan;
import Model.Quyen;
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

public class QuanController {
    public ArrayList<Quan> layDSQuan() {
        // Khởi tạo danh sách Quận
        ArrayList<Quan> danhsachQuan = new ArrayList<>();
        try {
            String sql = "Select * From Quan"; // Thực hiện câu lệnh SQL
            ResultSet rs = ConnectionModel.ThucHienSQL(sql);
            // Đọc từng bản ghi một
            while (rs.next()) {
                Quan q = new Quan(rs.getString("maquan"), rs.getString("tenquan"));
                danhsachQuan.add(q);
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuanController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return danhsachQuan;
    }
    
    /*Load data quận lên table*/
     public void loaddataQuan(JTable jTableQuan) {
        ArrayList<Quan> loadQuan = new QuanController().layDSQuan();
        DefaultTableModel tbModel = (DefaultTableModel) jTableQuan.getModel();
        tbModel.setRowCount(0);
        int stt = 0;
        for (Quan q : loadQuan) {
            stt++;
            Object[] object = new Object[]{stt, q.getMaquan(), q.getTenquan()};
            tbModel.addRow(object);
        }

    }
     
    //Thêm data tên quận load vào cmb lên View
    public JComboBox Load_CMB_Quan(JComboBox cmb_Quan) {
        ArrayList<Quan> lstQuan= new QuanController().layDSQuan();
        lstQuan.forEach(item -> {
            cmb_Quan.addItem(item.getTenquan());
        });
        return cmb_Quan;
    }
    
    // Lấy ra các mã quận từ tên quận
    public static String Get_MaQuan(JComboBox cmb_Quan) {
        ArrayList<Quan> lstQuan = new QuanController().layDSQuan();
        String maquan = "";
        for (Quan item : lstQuan) {
            if (item.getTenquan().equals(cmb_Quan.getSelectedItem().toString())) {
                maquan = item.getMaquan();
            }
        }
        return maquan;
    }
    
    public String LayTenquan_TheoMaQuan(String maquan){
        String tenquan = "";
       for(Quan item : layDSQuan()){
           if(item.getMaquan().equals(maquan)){
               tenquan = item.getTenquan();
           }
       }
       return tenquan;
    }
    
     public String LayMaquan_TheoTenQuan(String tenquan){
        String maquan = "";
       for(Quan item : layDSQuan()){
           if(item.getTenquan().equals(tenquan)){
               maquan = item.getMaquan();
           }
       }
       return maquan;
    }

}
