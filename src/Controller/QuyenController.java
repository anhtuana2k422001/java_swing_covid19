package Controller;

import Model.ConnectionModel;
import Model.Quyen;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;

public class QuyenController {
     public ArrayList<Quyen> layDSQuyen() {
        // Khởi tạo danh sách Quyền
        ArrayList<Quyen> danhsachQuyen = new ArrayList<>();
        try {
            String sql = "Select * From Quyen"; // Thực hiện câu lệnh SQL
            ResultSet rs = ConnectionModel.ThucHienSQL(sql);
            while (rs.next()) {
                Quyen q = new Quyen(rs.getString("maquyen"),rs.getString("tenquyen"));
                danhsachQuyen.add(q);
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuanController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return danhsachQuyen;
}
     
     //Thêm data tên quyền load vào cmb lên View
    public JComboBox Load_CMB_Quyen(JComboBox cmb_Quyen) {
        ArrayList<Quyen> lstQuyen= new QuyenController().layDSQuyen();
        lstQuyen.forEach(item -> {
            cmb_Quyen.addItem(item.getTenquyen());
        });
        return cmb_Quyen;
    }
    
    // Lấy ra mã quyền
    public String Get_MaQuyen(JComboBox cmb_Quyen) {
        String maquyen = "";
        for (Quyen item : layDSQuyen()) {
            if (item.getTenquyen().equals(cmb_Quyen.getSelectedItem().toString())) {
                maquyen = item.getMaquyen();
            }
        }
        return maquyen;
    }
    
    // Lấy ra tên quyền từ mã quyền
    public String LayTenQuyen(String maquyen){
        String tenquyen = "";
        for (Quyen item : layDSQuyen()) {
            if (item.getMaquyen().equals(maquyen)) {
                tenquyen = item.getTenquyen();
            }
        }
        return tenquyen;
    }
}
