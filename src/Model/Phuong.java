package Model;

public class Phuong {
    private String maphuong;
    private String tenphuong;
    private String maquan;
    public  Phuong(){
        
    }
     public Phuong(String maphuong, String tenphuong, String maquan) {
        this.maphuong = maphuong;
        this.tenphuong = tenphuong;
        this.maquan = maquan;
    }

    public String getMaPhuong() {
        return maphuong;
    }

    public void setMaPhuong(String maphuong) {
        this.maphuong = maphuong;
    }
    public String getTenPhuong() {
        return tenphuong;
    }

    public void setTenPhuong(String tenphuong) {
        this.tenphuong = tenphuong;
    }
     public String getMaQuan() {
        return maquan;
    }

    public void setMaQuan(String maquan) {
        this.maquan = maquan;
    }
     public String toString(){
        return maphuong;
    }
}
