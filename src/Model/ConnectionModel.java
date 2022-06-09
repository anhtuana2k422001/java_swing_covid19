package Model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionModel {
    // Tạo phương thức để kết nối với CSDL
    public static Connection getConnection() {
       Connection conn = null;
        try {
            String userSQL  = "sa"; 
            String passWord  = "12345656"; 
            // Tạo chuối kết nối
            String chuoiketnoi = "jdbc:sqlserver://DESKTOP-C2AOP59\\LOCAL:1433;databaseName=DB_TIEMCHUNGCOVID_19";     
            // Đăng ký JDBC
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // Thực hiện kết nối
             conn = DriverManager.getConnection(chuoiketnoi,userSQL,passWord);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ConnectionModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }
    // Phương thức để thưc hiện lấy cơ sở dữ liệu lên
    public static ResultSet ThucHienSQL(String sql) {
        ResultSet rs = null;
        try {
            // Kết nối đến cơ dữ liệu
            Connection conn = ConnectionModel.getConnection(); // Trả lại một đối tượng kết nối
            Statement Statement = conn.createStatement();
            rs = Statement.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    // Phương thức để thêm và cập nhật vào cở sở dữ liệu 
    public static int UpdateSQl(String sql) {
        try {
            // Kết nối đến cơ dữ liệu
            Connection conn = ConnectionModel.getConnection(); // Trả lại một đối tượng kết nối
            Statement stmt = conn.createStatement();
            int index = stmt.executeUpdate(sql);
            return index;
        } catch (SQLException ex) {
            return -1;
        }
    }
    
    public static void main(String args[]) {
    }
}
