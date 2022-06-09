package Model;

public class LoVacXin {
    private String masolo;
    private int soluong;
    private String maloai;
    private String ngaysanxuat;  
    private String ngayhethan;
    private boolean trangthai;
    private String dotuoi;
    
    public LoVacXin(){
        
    }

    public LoVacXin(String masolo, int soluong, String maloai, String ngaysanxuat, String ngayhethan, boolean trangthai, String dotuoi) {
        this.masolo = masolo;
        this.soluong = soluong;
        this.maloai = maloai;
        this.ngaysanxuat = ngaysanxuat;
        this.ngayhethan = ngayhethan;
        this.trangthai = trangthai;
        this.dotuoi = dotuoi;
    }

    public String getMasolo() {
        return masolo;
    }

    public void setMasolo(String masolo) {
        this.masolo = masolo;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public String getMaloai() {
        return maloai;
    }

    public void setMaloai(String maloai) {
        this.maloai = maloai;
    }

    public String getNgaysanxuat() {
        return ngaysanxuat;
    }

    public void setNgaysanxuat(String ngaysanxuat) {
        this.ngaysanxuat = ngaysanxuat;
    }

    public String getNgayhethan() {
        return ngayhethan;
    }

    public void setNgayhethan(String ngayhethan) {
        this.ngayhethan = ngayhethan;
    }

    public boolean isTrangthai() {
        return trangthai;
    }

    public void setTrangthai(boolean trangthai) {
        this.trangthai = trangthai;
    }

    public String getDotuoi() {
        return dotuoi;
    }

    public void setDotuoi(String dotuoi) {
        this.dotuoi = dotuoi;
    }

    @Override
    public String toString() {
        return "LoVacXin{" + "masolo=" + masolo + '}';
    }
    
}
