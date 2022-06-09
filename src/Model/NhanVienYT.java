package Model;

public class NhanVienYT {
     private String manhanvienyt;
    private String tennhanvienyt;
    private String madoingu;
    private String sdt;  
    private String coquan;
    private String email;
    
    public NhanVienYT(){
        
    }

    public NhanVienYT(String manhanvienyt, String tennhanvienyt, String madoingu, String sdt, String coquan, String email) {
        this.manhanvienyt = manhanvienyt;
        this.tennhanvienyt = tennhanvienyt;
        this.madoingu=madoingu;
        this.sdt = sdt;
        this.coquan = coquan;
        this.email = email;
    }

    public String getMaNhanVienYT() {
        return manhanvienyt;
    }

    public void setMaNhanVienYT(String manhanvienyt) {
        this.manhanvienyt = manhanvienyt;
    }

    public String getTenNhanVienYT() {
        return tennhanvienyt;
    }

    public void setTenNhanVienYT(String tennhanvienyt) {
        this.tennhanvienyt = tennhanvienyt;
    }

    public String getMaDoiNgu() {
        return madoingu;
    }

    public void setMaDoiNgu(String madoingu) {
        this.madoingu = madoingu;
    }

    public String getSDT() {
        return sdt;
    }

    public void setSDT(String sdt) {
        this.sdt = sdt;
    }

    public String getCoQuan() {
        return coquan;
    }

    public void setCoQuan(String coquan) {
        this.coquan = coquan;
    }
     public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    @Override
    public String toString(){
        return manhanvienyt;
    }
}
