package Model;

public class LoaiVacXin {
    private String maloai;
    private String tenloai;
    private int somuitiem;
    private String xuatxu;  
    private String mota;
    private boolean trangthai;
    private int lieutrinh;
    
    public LoaiVacXin(){
        
    }

    public LoaiVacXin(String maloai, String tenloai, int somuitiem, String xuatxu, String mota, boolean trangthai, int lieutrinh) {
        this.maloai = maloai;
        this.tenloai = tenloai;
        this.somuitiem = somuitiem;
        this.xuatxu = xuatxu;
        this.mota = mota;
        this.trangthai = trangthai;
        this.lieutrinh = lieutrinh;
    }

    public String getMaloai() {
        return maloai;
    }

    public void setMaloai(String maloai) {
        this.maloai = maloai;
    }

    public String getTenloai() {
        return tenloai;
    }

    public void setTenloai(String tenloai) {
        this.tenloai = tenloai;
    }

    public int getSomuitiem() {
        return somuitiem;
    }

    public void setSomuitiem(int somuitiem) {
        this.somuitiem = somuitiem;
    }

    public String getXuatxu() {
        return xuatxu;
    }

    public void setXuatxu(String xuatxu) {
        this.xuatxu = xuatxu;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public boolean isTrangthai() {
        return trangthai;
    }

    public void setTrangthai(boolean trangthai) {
        this.trangthai = trangthai;
    }

    public int getLieutrinh() {
        return lieutrinh;
    }

    public void setLieutrinh(int lieutrinh) {
        this.lieutrinh = lieutrinh;
    }

    @Override
    public String toString() {
        return "LoaiVacXin{" + "maloai=" + maloai + '}';
    }
    
}
