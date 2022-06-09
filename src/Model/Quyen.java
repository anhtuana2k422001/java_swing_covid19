package Model;

public class Quyen {
    private String maquyen;
    private String tenquyen;
            
    public  Quyen(){
        
    }

    public Quyen(String maquyen, String tenquyen) {
        this.maquyen = maquyen;
        this.tenquyen = tenquyen;
    }

    public String getMaquyen() {
        return maquyen;
    }

    public void setMaquyen(String maquyen) {
        this.maquyen = maquyen;
    }

    public String getTenquyen() {
        return tenquyen;
    }

    public void setTenquyen(String tenquyen) {
        this.tenquyen = tenquyen;
    }

    @Override
    public String toString() {
        return "Quyen{" + "maquyen=" + maquyen + '}';
    }
 
}
