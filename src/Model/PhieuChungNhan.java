package Model;

public class PhieuChungNhan {
    private String masophieu;
    private String madottiem;
    private int lantiem;
    private String cmnd;  
    private String manhanvienyt;
    
    public PhieuChungNhan(){
        
    }

    public PhieuChungNhan(String masophieu, String madottiem, int lantiem, String cmnd, String manhanvienyt) {
        this.masophieu = masophieu;
        this.madottiem = madottiem;
        this.lantiem = lantiem;
        this.cmnd = cmnd;
        this.manhanvienyt = manhanvienyt;
    }

    public String getMasophieu() {
        return masophieu;
    }

    public void setMasophieu(String masophieu) {
        this.masophieu = masophieu;
    }

    public String getMadottiem() {
        return madottiem;
    }

    public void setMadottiem(String madottiem) {
        this.madottiem = madottiem;
    }

    public int getLantiem() {
        return lantiem;
    }

    public void setLantiem(int lantiem) {
        this.lantiem = lantiem;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public String getManhanvienyt() {
        return manhanvienyt;
    }

    public void setManhanvienyt(String manhanvienyt) {
        this.manhanvienyt = manhanvienyt;
    }
    
    @Override
    public String toString(){
        return masophieu;
    }
}
