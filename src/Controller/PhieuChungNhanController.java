package Controller;

import Model.ConnectionModel;
import Model.PhieuChungNhan;
import com.toedter.calendar.JDateChooser;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class PhieuChungNhanController {
     public ArrayList<PhieuChungNhan> layDSPhieuChungNhan() {
        // Khởi tạo danh sách tài khoản
        ArrayList<PhieuChungNhan> danhsachPhieuChungNhan = new ArrayList<>();
        try {
            String sql = "Select * From PhieuChungNhan"; // Thực hiện câu lệnh SQL
            ResultSet rs = ConnectionModel.ThucHienSQL(sql);
            // Đọc từng bản ghi một
            while (rs.next()) {
                PhieuChungNhan tk = new PhieuChungNhan(rs.getString("masophieu"),rs.getString("madottiem"),rs.getInt("lantiem"),rs.getString("cmnd"),rs.getString("manhanvienyt"));
                danhsachPhieuChungNhan.add(tk);
            }
 
        } catch (SQLException ex) {
            Logger.getLogger(PhieuChungNhanController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return danhsachPhieuChungNhan;
    }
     
    public int SoLuongMuiTiem() {
        return layDSPhieuChungNhan().size();
    }
    
    /*Lấy ra số lượng tiêm ngày hôm qua --- chưa đúng -- đang chờ fix */
    public int SoLuongHomQua(){
        
        int dem = 0;
        String madottiem =  new DotTiemController().MaDotTiemHomQua();
        for (PhieuChungNhan item : layDSPhieuChungNhan()) {
            if(madottiem.equals(item.getMadottiem())){
                dem++;
            }
        }
        return dem;
    }
    
    /*Load bảng mũi tiêm theo đợt tiêm*/
    public void Lay_MuiTiem_TheoDotTiem(JTable table_muitiem, JComboBox cmb_dottiem) {
        String sql = "SELECT PCN.CMND, HoTen, TenLoai, NgayTiem, LanTiem , TenNhanVienYT\n"
                + "FROM PhieuChungNhan PCN \n"
                + "JOIN NguoiDan ND ON ND.CMND = PCN.CMND\n"
                + "JOIN DotTiem DT ON DT.MaDotTiem = PCN.MaDotTiem\n"
                + "JOIN NhanVienYT NV ON NV.MaNhanVienYT = PCN.MaNhanVienYT\n"
                + "JOIN LoVacXin LOVX ON LOVX.MaSoLo = DT.MaSoLo\n"
                + "JOIN LoaiVacXin LVX ON LVX.MaLoai = LOVX.MaLoai\n"
                + "WHERE DT.MaDotTiem = '" + cmb_dottiem.getSelectedItem().toString() + "'";
        ResultSet rs = ConnectionModel.ThucHienSQL(sql);
        DefaultTableModel tbModel = (DefaultTableModel) table_muitiem.getModel();
        tbModel.setRowCount(0);
        // Đọc từng bản ghi một
        int stt = 0;
        try {
            while (rs.next()) {
                stt++;
                Object[] obj = new Object[]{stt, rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
                    rs.getString(5), rs.getString(6)};
                tbModel.addRow(obj);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PhieuChungNhanController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /*Tìm kiếm Mũi tiêm của người dân theo cmnd và họ tên*/
    public boolean TimKiemMuiTiem(JTable table_muitiem, JTextField cmnd,JTextField hoten){
        String sql = "SELECT PCN.CMND, HoTen, TenLoai, NgayTiem, LanTiem , TenNhanVienYT\n"
                + "FROM PhieuChungNhan PCN \n"
                + "JOIN NguoiDan ND ON ND.CMND = PCN.CMND\n"
                + "JOIN DotTiem DT ON DT.MaDotTiem = PCN.MaDotTiem\n"
                + "JOIN NhanVienYT NV ON NV.MaNhanVienYT = PCN.MaNhanVienYT\n"
                + "JOIN LoVacXin LOVX ON LOVX.MaSoLo = DT.MaSoLo\n"
                + "JOIN LoaiVacXin LVX ON LVX.MaLoai = LOVX.MaLoai\n"
                + "WHERE ND.CMND = '" + cmnd.getText() + "' AND HoTen = N'" + hoten.getText() + "'";
        ResultSet rs = ConnectionModel.ThucHienSQL(sql);
        DefaultTableModel tbModel = (DefaultTableModel) table_muitiem.getModel();
        tbModel.setRowCount(0);
        // Đọc từng bản ghi một
        int stt = 0;
        try {
            while (rs.next()) {
                stt++;
                Object[] obj = new Object[]{stt, rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
                    rs.getString(5), rs.getString(6)};
                tbModel.addRow(obj);
            }
            if(0==stt)
            {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PhieuChungNhanController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
    
    /*Kiểm Tra Mũi tiêm của người dân theo cmnd và họ tên -- để chức năng xóa */
    public boolean KiemTraMuiTiem(JTextField cmnd, JTextField hoten) {
        String sql = "SELECT PCN.CMND, HoTen, TenLoai, NgayTiem, LanTiem , TenNhanVienYT\n"
                + "FROM PhieuChungNhan PCN \n"
                + "JOIN NguoiDan ND ON ND.CMND = PCN.CMND\n"
                + "JOIN DotTiem DT ON DT.MaDotTiem = PCN.MaDotTiem\n"
                + "JOIN NhanVienYT NV ON NV.MaNhanVienYT = PCN.MaNhanVienYT\n"
                + "JOIN LoVacXin LOVX ON LOVX.MaSoLo = DT.MaSoLo\n"
                + "JOIN LoaiVacXin LVX ON LVX.MaLoai = LOVX.MaLoai\n"
                + "WHERE ND.CMND = '" + cmnd.getText() + "' AND HoTen = N'" + hoten.getText() + "'";
        ResultSet rs = ConnectionModel.ThucHienSQL(sql);
        // Đọc từng bản ghi một
        try {
            while (rs.isBeforeFirst()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PhieuChungNhanController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean NhapMuiTiem(JTable table_muitiem, JTextField cmnd, JTextField hoten) {
        String sql = "SELECT CMND, HoTen\n"
                + "FROM NguoiDan ND\n"
                + "WHERE ND.CMND = '" + cmnd.getText() + "' AND HoTen = N'" + hoten.getText() + "'\n"
                + "AND ND.CMND NOT IN (SELECT PCN.CMND FROM PhieuChungNhan PCN) ";
        ResultSet rs = ConnectionModel.ThucHienSQL(sql);
        DefaultTableModel tbModel = (DefaultTableModel) table_muitiem.getModel();
        tbModel.setRowCount(0);
           int stt = 0;
        try {
            while (rs.next()) {
                stt++;
                Object[] obj = new Object[]{stt, rs.getString(1), rs.getString(2), "Chưa cập nhật ...", "Chưa cập nhật ...",
                    "Chưa cập nhật ...", "Chưa cập nhật ..."};
                tbModel.addRow(obj);
            }
            if(0==stt)
            {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PhieuChungNhanController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
    
    // Hàm tạo mã phiếu tự động 
    public String AutoMaPhieuChungNhan() {
        List<Integer> listMaPCN = new ArrayList<>();
        for (PhieuChungNhan item : layDSPhieuChungNhan()) {
            String maphieu = String.valueOf(item.getMasophieu().substring(4, 7));
            listMaPCN.add(Integer.parseInt(maphieu));
        }
        int max = listMaPCN.get(0);
        for (Integer item : listMaPCN) {
            if (max < item) {
                max = item;
            }
        }
        max++;
        return "PCN0" + max;
    }

    public boolean ThemMuiTiemND(JComboBox cmb_dottiem, JComboBox lantiem, JTextField cmnd, JComboBox cmb_nhanvienyt, JLabel madanhsach) {
        String maphieu = AutoMaPhieuChungNhan();
        String manhanvienyt = new NhanVienYTController().Lay_MaNhanVienYT_TheoTen(cmb_nhanvienyt.getSelectedItem().toString());
        String sql = "insert into PhieuChungNhan values (N'" + maphieu + "',N'" + cmb_dottiem.getSelectedItem().toString() + "', N'" + lantiem.getSelectedItem().toString() + "',N'" + cmnd.getText() + "',N'" + manhanvienyt + "')";
        
        //Sửa lại mã danh sách
        String sqlND = "UPDATE NguoiDan SET MaSoDS = N'" + madanhsach.getText() + "'\n"
                + "WHERE CMND = '" + cmnd.getText() + "'";
        ConnectionModel.UpdateSQl(sqlND);
        
        int update = ConnectionModel.UpdateSQl(sql);
        return 0 != update;
        /* Xong bước này quay lại bước xóa người dân làm bổ sung*/
    }

    public boolean SuaMuiTiemND(String tenvacxin, String lantiem, JTextField cmnd, JComboBox cmb_nhanvienyt) {
        String manhanvienyt = new NhanVienYTController().Lay_MaNhanVienYT_TheoTen(cmb_nhanvienyt.getSelectedItem().toString());
        String sql = "UPDATE PCN SET MaNhanVienYT = N'" + manhanvienyt + "'\n"
                + "FROM PhieuChungNhan PCN\n"
                + "JOIN DotTiem DT ON DT.MaDotTiem = PCN.MaDotTiem\n"
                + "JOIN LoVacXin LOVX ON LOVX.MaSoLo = DT.MaSoLo\n"
                + "JOIN LoaiVacXin LVX ON LVX.MaLoai = LOVX.MaLoai\n"
                + "WHERE TenLoai = N'" + tenvacxin + "' AND LanTiem = N'" + lantiem + "' AND CMND = N'" + cmnd.getText() + "'";
        int update = ConnectionModel.UpdateSQl(sql);
        return 0 != update;
    }

    public boolean XoaMuiTiemND(String tenvacxin, String lantiem, JTextField cmnd) {
        String sql = "DELETE PCN\n"
                + "FROM PhieuChungNhan PCN\n"
                + "JOIN DotTiem DT ON DT.MaDotTiem = PCN.MaDotTiem\n"
                + "JOIN LoVacXin LOVX ON LOVX.MaSoLo = DT.MaSoLo\n"
                + "JOIN LoaiVacXin LVX ON LVX.MaLoai = LOVX.MaLoai\n"
                + "WHERE TenLoai = N'" + tenvacxin + "' AND LanTiem = N'" + lantiem + "' AND CMND = N'" + cmnd.getText() + "'";
        int update = ConnectionModel.UpdateSQl(sql);
        return 0 != update;
    }
    
    public boolean TraCuuPhieuChungNhan(JTable table_muitiem, JTextField cmnd, JTextField hoten, JTextField sdt, JDateChooser namsinh, JLabel ngaysinh, JLabel diachi){
        String sql = "SELECT HoTen, ND.CMND, SDT , NamSinh, PND.TenPhuong, QND.TenQuan,\n"
                + "NgayTiem, LVX.TenLoai, LOVX.MaSoLo, P.TenPhuong , Q.TenQuan\n"
                + "FROM PhieuChungNhan PCN\n"
                + "JOIN NguoiDan ND ON ND.CMND = PCN.CMND\n"
                + "JOIN DotTiem DT ON DT.MaDotTiem = PCN.MaDotTiem\n"
                + "JOIN Phuong P ON P.MaPhuong = DT.MaPhuong\n"
                + "JOIN QUAN Q ON Q.MaQuan = DT.MaQuan\n"
                + "JOIN PHUONG PND ON PND.MaPhuong = ND.MaPhuong\n"
                + "JOIN Quan QND ON QND.MaQuan = ND.MaQuan\n"
                + "JOIN LoVacXin LOVX ON LOVX.MaSoLo = DT.MaSoLo\n"
                + "JOIN LoaiVacXin LVX ON LVX.MaLoai = LOVX.MaLoai\n"
                + "WHERE ND.CMND = N'"+cmnd.getText().trim()+"' AND HoTen = N'"+hoten.getText().trim()+"' AND SDT = N'"+sdt.getText().trim()+"'";
        ResultSet rs = ConnectionModel.ThucHienSQL(sql);
        DefaultTableModel tbModel = (DefaultTableModel) table_muitiem.getModel();
        tbModel.setRowCount(0);
        // Đọc từng bản ghi một
        int stt = 0;
        try {
            while (rs.next()) {
                diachi.setText(rs.getString(5) + " - " + rs.getString(6) + " - " + "Thành phố Hồ Chí Minh");
                stt++;
                String noitiem = rs.getString(10) + ", " + rs.getString(11) + ", " + "Tp.HCM";
                Object[] obj = new Object[]{stt, rs.getString(7), rs.getString(8), rs.getString(9), noitiem};
                tbModel.addRow(obj);
            }
            if(0==stt)
            {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PhieuChungNhanController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
    
}
