
package Model;

public class NguoiDan {
    private String cmnd;
    private String hoten;
    private String gioitinh;
    private String namsinh;
    private String sdt;
    private String maquan;
    private String maphuong;
    private String diachi;
    private String masods;
   
    
    public NguoiDan() {
    
    }

    public NguoiDan(String cmnd, String hoten, String gioitinh, String namsinh, String sdt, String maquan, String maphuong, String diachi, String masods) {
        this.cmnd = cmnd;
        this.hoten = hoten;
        this.gioitinh = gioitinh;
        this.namsinh = namsinh;
        this.sdt = sdt;
        this.maquan = maquan;
        this.maphuong = maphuong;
        this.diachi = diachi;
        this.masods = masods;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getNamsinh() {
        return namsinh;
    }

    public void setNamsinh(String namsinh) {
        this.namsinh = namsinh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getMaquan() {
        return maquan;
    }

    public void setMaquan(String maquan) {
        this.maquan = maquan;
    }

    public String getMaphuong() {
        return maphuong;
    }

    public void setMaphuong(String maphuong) {
        this.maphuong = maphuong;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getMasods() {
        return masods;
    }

    public void setMasods(String masods) {
        this.masods = masods;
    }

    @Override
    public String toString() {
        return "NguoiDan{" + "cmnd=" + cmnd + '}';
    }

}
