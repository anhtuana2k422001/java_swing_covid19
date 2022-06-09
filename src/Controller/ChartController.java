package Controller;

import Model.ConnectionModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;


public class ChartController {
    public String Ngay;
    public int CountCaTiem;

    public String getNgay() {
        return Ngay;
    }

    public void setNgay(String Ngay) {
        this.Ngay = Ngay;
    }

    public int getCountCaTiem() {
        return CountCaTiem;
    }

    public void setCountCaTiem(int CountCaTiem) {
        this.CountCaTiem = CountCaTiem;
    }
    
    public ArrayList<ChartController> LayThonTinBieuDo(){
        ArrayList<ChartController> LayBieuDo = new  ArrayList<>(); 
           try {
                String sql = "SELECT NgayTiem , COUNT(PCN.CMND) \n"
                        + "FROM PhieuChungNhan PCN\n"
                        + "JOIN DotTiem DT on DT.MaDotTiem = PCN.MaDotTiem\n"
                        + "GROUP BY DT.NgayTiem"; // Thực hiện câu lệnh SQL
                ResultSet rs = ConnectionModel.ThucHienSQL(sql);
                // Đọc từng bản ghi một
                while (rs.next()) {
                    ChartController item = new ChartController();
                    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                    String stringDate = dateFormat.format(rs.getDate(1)); //Định dạng thời gian theo trên
                    String NgayTiem = stringDate.replace("-", "/");
                    item.Ngay = NgayTiem;
                    item.CountCaTiem = rs.getInt(2); 
                    LayBieuDo.add(item);
                  //System.out.print("Ngày:" + item.Ngay);
                  //System.out.print(", Số ca tiêm: " + item.CountCaTiem+ "\n");
                }
            } catch (SQLException ex) {
                Logger.getLogger(ChartController.class.getName()).log(Level.SEVERE, null, ex);
            }
         return LayBieuDo;
     }
    
    public JFreeChart createChart(int ngay) {
        JFreeChart barChart = ChartFactory.createLineChart( "BIỂU ĐỒ MŨI TIÊM", "Ngày tiêm 7 ngày gần nhất", "Số mũi tiêm",createDataset(ngay), PlotOrientation.VERTICAL, false, false, false);
        return barChart;
    }

    private CategoryDataset createDataset(int ngay) {
        ArrayList<ChartController> listSLMuiTiem = new ChartController().LayThonTinBieuDo();
        DefaultCategoryDataset dataset = new DefaultCategoryDataset(); // để add data vào biểu đồ

        Calendar calendar = Calendar.getInstance(); // Lấy ngày hôm nay
        calendar.add(Calendar.DATE, - ngay); // Lấy từ chậm hơn 6 ngày so với ngày hiện tại
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        /* Lấy ra bảy ngày gần nhất thực tế theo lịch */
        for (int j = 0; j < 7; j++) {
              calendar.add(Calendar.DATE, +1);
            /* Lấy số liệu theo ngày trong database */
            String date = dateFormat.format(calendar.getTime()); // Mặc định cho số mui tiêm của từng ngày bằng 0
            dataset.addValue(0, "Số mũi tiêm", date);// Không trùng cho = 0
            for (int i = 0; i < listSLMuiTiem.size(); i++) {
                // Kiểm tra xem ngày trùng không
                if (listSLMuiTiem.get(i).getNgay().contains(String.valueOf(date))) {
                    // trùng thì thêm số liệu ngày thì thay đổi số mũi tiêm
                    dataset.addValue(listSLMuiTiem.get(i).CountCaTiem, "Số mũi tiêm", date);
                }
            }
        }
        return dataset;
    }
  
    public static void main(String[] args) {
        ChartPanel chartPanel = new ChartPanel(new ChartController().createChart(7));
        chartPanel.setPreferredSize(new java.awt.Dimension(400, 300));
        JFrame frame = new JFrame();
        frame.add(chartPanel);
        frame.setTitle("Biểu đồ JFreeChart trong Java Swing");
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}