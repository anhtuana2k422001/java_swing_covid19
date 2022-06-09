package Model;

public class TaiKhoan {

    private String tentaikhoan;
    private String matkhau;
    private String maquyen;

    
    public TaiKhoan(){
        
    }
    
    public TaiKhoan(String tentaikhoan, String matkhau, String maquyen) {
        this.tentaikhoan = tentaikhoan;
        this.matkhau = matkhau;
        this.maquyen = maquyen;
    }

    public String getTentaikhoan() {
        return tentaikhoan;
    }

    public void setTentaikhoan(String tentaikhoan) {
        this.tentaikhoan = tentaikhoan;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public String getMaquyen() {
        return maquyen;
    }

    public void setMaquyen(String maquyen) {
        this.maquyen = maquyen;
    }
    
    @Override
    public String toString(){
        return tentaikhoan;
    }
    
}
