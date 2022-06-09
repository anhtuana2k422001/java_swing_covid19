package Model;

public class DoiNguYT {
    private String madoingu;
    private String tendoingu;
    
    public DoiNguYT(){
        
    }

    public DoiNguYT(String madoingu, String tendoingu) {
        this.madoingu = madoingu;
        this.tendoingu = tendoingu;
    }

    public String getMaDoiNgu() {
        return madoingu;
    }

    public void setMaDoiNgu(String madoingu) {
        this.madoingu = madoingu;
    }

    public String getTenDoiNgu() {
        return tendoingu;
    }

    public void setTenDoiNgu(String tendoingu) {
        this.tendoingu = tendoingu;
    }

    @Override
    public String toString() {
        return "DoiNguYT{" + "madoingu=" + madoingu + '}';
    }
}
