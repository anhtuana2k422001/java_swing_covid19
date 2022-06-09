package Model;

public class Quan {
    private String maquan;
    private String tenquan;
            
    public  Quan(){
        
    }

    public Quan(String maquan, String tenquan) {
        this.maquan = maquan;
        this.tenquan = tenquan;
    }

    public String getMaquan() {
        return maquan;
    }

    public void setMaquan(String maquan) {
        this.maquan = maquan;
    }

    public String getTenquan() {
        return tenquan;
    }

    public void setTenquan(String tenquan) {
        this.tenquan = tenquan;
    }

    @Override
    public String toString() {
        return "Quan{" + "maquan=" + maquan + '}';
    }
}
