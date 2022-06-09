package Model;

public class DanhSachTiem 
{
    private String masods;
    private String tendanhsach;;
   
    
    public DanhSachTiem(){
        
    }

    public DanhSachTiem(String masods, String tendanhsach) {
        this.masods = masods;
        this.tendanhsach = tendanhsach;
    }

    public String getMasods() {
        return masods;
    }

    public void setMasods(String masods) {
        this.masods = masods;
    }

    public String getTends() {
        return tendanhsach;
    }

    public void setTends(String tends) {
        this.tendanhsach = tendanhsach;
    }

    @Override
    public String toString() {
        return "DanhSachTiem{" + "masods=" + masods + '}';
    }

}
