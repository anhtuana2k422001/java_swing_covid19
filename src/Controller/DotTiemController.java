package Controller;

import Model.ConnectionModel;
import Model.DotTiem;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DotTiemController {
     public ArrayList<DotTiem> layDSDotTiem() {
        // Khởi tạo danh sách tài khoản
        ArrayList<DotTiem> danhsachDotTiem = new ArrayList<>();
        try {
            String sql = "Select * From DotTiem"; // Thực hiện câu lệnh SQL
            ResultSet rs = ConnectionModel.ThucHienSQL(sql);
            // Đọc từng bản ghi một
            while (rs.next()) {
                DotTiem dt = new DotTiem(rs.getString("madottiem"),rs.getDate("ngaytiem"),rs.getString("maquan"),rs.getString("maphuong"),rs.getString("masolo"),rs.getString("masods"),rs.getString("madoingu"));
                danhsachDotTiem.add(dt);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DotTiemController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return danhsachDotTiem;
    }

    public void loaddataDotTiem(JTable jTableDotTiem) {
       ArrayList<DotTiem> loadDotTiem = new DotTiemController().layDSDotTiem();
        DefaultTableModel tbModel = (DefaultTableModel) jTableDotTiem.getModel();
        tbModel.setRowCount(0);
        int stt = 0;
        for (DotTiem dt : loadDotTiem) {
            stt++;
            String tenquan = new QuanController().LayTenquan_TheoMaQuan(dt.getMaquan());               
            String tenphuong = new PhuongController().LayTenphuong_TheoMaPhuong(dt.getMaphuong());            

            Object[] object = new Object[]{stt, dt.getMadottiem(), dt.getNgaytiem(), tenquan, tenphuong, dt.getMasolo(), dt.getMasods(), dt.getMadoingu()};
            tbModel.addRow(object);
        }
    }
    
    public String MaDotTiemHomQua(){
        Calendar calendar = Calendar.getInstance(); // Lấy ngày hôm nay
        calendar.add(Calendar.DATE, - 1);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        String date = dateFormat.format(calendar.getTime());
        String ngayhomqua = date.replace("/", "-");
        String madottiem = "";
        for(DotTiem item : layDSDotTiem()){
            if(ngayhomqua.equals(item.getNgaytiem().toString())){
                madottiem = item.getMadottiem();
            }
        }
        return madottiem;
    }
    
    // Lấy ra tất cả các đơt tiêm
    public JComboBox LaycmbDotTiem(JComboBox cmbDotTiem){
         ArrayList<DotTiem> lstQuan= layDSDotTiem();
        lstQuan.forEach(item -> {
            cmbDotTiem.addItem(item.getMadottiem());
        });
        cmbDotTiem.setSelectedIndex(layDSDotTiem().size()-1); // Lấy ra đợt tiêm mới nhất
        return  cmbDotTiem;
    }
    
        
    /*Lấy ra thông tin tiêm chủng theo đợt tiêm*/
    public void ThongTinDotTiem(JComboBox cmbDotTiem, JLabel loaivacxin, JLabel malo, JLabel ngaytiem,JLabel danhsach, JLabel doingu, JLabel diadiem, JLabel soluong ){
        String sql = "SELECT  TenLoai, DT.MaSoLo, NgayTiem, MaSoDS, MaDoiNgu, TenPhuong, TenQuan\n"
                + "FROM DotTiem DT\n"
                + "JOIN Phuong P ON P.MaPhuong = DT.MaPhuong\n"
                + "JOIN Quan Q ON Q.MaQuan = DT.MaQuan\n"
                + "JOIN PhieuChungNhan PCN ON PCN.MaDotTiem = DT.MaDotTiem\n"
                + "JOIN LoVacXin LOVX ON LOVX.MaSoLo = DT.MaSoLo\n"
                + "JOIN LoaiVacXin LVX ON LVX.MaLoai = LOVX.MaLoai\n"
                + "WHERE DT.MaDotTiem = '"+cmbDotTiem.getSelectedItem().toString()+"' ";
        ResultSet rs = ConnectionModel.ThucHienSQL(sql);
         try {
             int sluongmuitiem = 0;
             String diachi = null;
             while (rs.next()) {
                 sluongmuitiem++;
                 loaivacxin.setText(rs.getString(1));
                 malo.setText(rs.getString(2));
                 ngaytiem.setText(rs.getString(3));
                 danhsach.setText(rs.getString(4));
                 doingu.setText(rs.getString(5));
                 diachi = rs.getString(6) +", "+ rs.getString(7)+", TP.HCM";
             }
             diadiem.setText(diachi);
             soluong.setText(String.valueOf(sluongmuitiem));
         } catch (SQLException ex) {
             Logger.getLogger(DotTiemController.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
}
